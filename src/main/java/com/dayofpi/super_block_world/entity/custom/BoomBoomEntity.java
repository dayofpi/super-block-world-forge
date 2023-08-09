package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class BoomBoomEntity extends Monster {
    private static final EntityDataAccessor<String> DATA_STATE = SynchedEntityData.defineId(BoomBoomEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Integer> DATA_TIME_UNTIL_NEXT_STATE = SynchedEntityData.defineId(BoomBoomEntity.class, EntityDataSerializers.INT);
    private static final int TICKS_UNTIL_SPIN = 250;
    private static final int TICKS_PRE_SPIN = 10;
    private static final int TICKS_SPINNING = 200;
    private static final int TICKS_DIZZY = 100;
    private final ServerBossEvent bossEvent = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
    private final FlyingPathNavigation flyingPathNavigation;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState spinAnimationState = new AnimationState();

    public BoomBoomEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
        this.flyingPathNavigation = new FlyingPathNavigation(this, pLevel);
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setCanPassDoors(true);
        this.moveControl = new BoomBoomMoveControl(this);
        this.xpReward = 15;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new BoomBoomAttackGoal(this));
        this.goalSelector.addGoal(2, new BoomBoomSpinGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 150.0).add(Attributes.MOVEMENT_SPEED, 0.2).add(Attributes.FLYING_SPEED, 2.0).add(Attributes.ATTACK_DAMAGE, 6.0);
    }

    @Override
    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if (this.isSpinningState())
            return ModSoundEvents.BOOM_BOOM_SPIN.get();
        return this.isDizzyState() ? null : ModSoundEvents.BOOM_BOOM_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSoundEvents.BOOM_BOOM_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.BOOM_BOOM_DEATH.get();
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
        if (!this.isFlyingState()) {
            super.checkFallDamage(pY, pOnGround, pState, pPos);
        }
    }

    @Override
    public void push(Entity pEntity) {
        super.push(pEntity);
        if (!(pEntity instanceof LivingEntity))
            return;
        if (this.isAlive() && this.isSpinningState() && pEntity.hurt(damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + 2.0F)) {
            this.doEnchantDamageEffects(this, pEntity);
        }
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getBoomBoomState() == State.NORMAL, this.tickCount);
            this.spinAnimationState.animateWhen(this.isSpinningState(), this.tickCount);
        }
        super.tick();
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isEffectiveAi()) {
            bossEventTick();
        }
        if (this.getHealth() <= 50 && !this.isDeadOrDying() || this.navigation instanceof FlyingPathNavigation) {
            if (this.getBoomBoomState() != State.FLYING && this.level().isClientSide()) {
                for(int i = 0; i < 5; ++i) {
                    this.level().addParticle(ParticleTypes.POOF, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                }
            }
            this.setBoomBoomState(State.FLYING);
            this.navigation = flyingPathNavigation;
        } else {
            if (this.getTimeUntilNextState() > 0 && (this.isSpinningState() || this.isDizzyState() || this.getTarget() != null))
                this.setTimeUntilNextState(this.getTimeUntilNextState() - 1);
            if (this.getBoomBoomState() == State.NORMAL && this.getTarget() != null) {
                if (this.getTimeUntilNextState() == TICKS_PRE_SPIN) {
                    this.playSound(ModSoundEvents.BOOM_BOOM_READY.get());
                } else if (this.getTimeUntilNextState() == 0) {
                    this.setTimeUntilNextState(TICKS_SPINNING);
                    this.setBoomBoomState(State.SPINNING);
                }
            }
            else if (this.isSpinningState()) {
                this.level().addParticle(ParticleTypes.SWEEP_ATTACK, this.getX(), this.getRandomY(), this.getZ(), 0.0, 0.0, 0.0);
                if (this.getTimeUntilNextState() == 0) {
                    this.setTimeUntilNextState(TICKS_DIZZY);
                    this.playSound(ModSoundEvents.BOOM_BOOM_DIZZY.get());
                    this.setBoomBoomState(State.DIZZY);
                }
            }
            if (this.isDizzyState()) {
                this.dizzyEffect();
                if (this.getTimeUntilNextState() == 0) {
                    this.setTimeUntilNextState(TICKS_UNTIL_SPIN);
                    this.setBoomBoomState(State.NORMAL);
                }
            }
        }
    }

    private void bossEventTick() {
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        if (this.level() instanceof ServerLevel) {
            for (ServerPlayer player : this.bossEvent.getPlayers()) {
                if (player.distanceTo(this) > 48) {
                    this.bossEvent.removePlayer(player);
                }
            }
            for (Player player : level().getNearbyPlayers(TargetingConditions.forNonCombat(), this, AABB.of(BoundingBox.fromCorners(this.blockPosition().offset(30, 10, 30), this.blockPosition().offset(-30, -10, -30))))) {
                if (player instanceof ServerPlayer) {
                    this.bossEvent.addPlayer((ServerPlayer) player);
                }
            }
        }
    }

    private void dizzyEffect() {
        if (this.random.nextInt(6) == 0) {
            double d0 = this.getX() - (double)this.getBbWidth() * Math.sin((double)(this.yBodyRot * ((float)Math.PI / 180F))) + (this.random.nextDouble() * 0.6D - 0.3D);
            double d1 = this.getY() + (double)this.getBbHeight() - 0.3D;
            double d2 = this.getZ() + (double)this.getBbWidth() * Math.cos((double)(this.yBodyRot * ((float)Math.PI / 180F))) + (this.random.nextDouble() * 0.6D - 0.3D);
            this.level().addParticle(ParticleTypes.ENTITY_EFFECT, d0, d1, d2, 0.4980392156862745D, 0.5137254901960784D, 0.5725490196078431D);
        }
    }

    @Override
    protected float getWaterSlowDown() {
        return this.isSpinningState() ? 0.96F : super.getWaterSlowDown();
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        ItemEntity itementity = this.spawnAtLocation(ModItems.POWER_STAR.get());
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypeTags.IS_PROJECTILE) && this.isSpinningState()) {
            return false;
        }
        boolean hurt = super.hurt(pSource, pAmount);
        if (hurt && pSource.getEntity() instanceof IronGolem && this.getBoomBoomState() == State.NORMAL) {
            this.playSound(ModSoundEvents.BOOM_BOOM_READY.get());
            this.setTimeUntilNextState(TICKS_PRE_SPIN);
        }
        return hurt;
    }

    @Override
    public void checkDespawn() {
        if (this.level().getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    @Override
    protected boolean isImmobile() {
        return super.isImmobile() || this.isDizzyState();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_STATE, State.NORMAL.getSerializedName());
        this.entityData.define(DATA_TIME_UNTIL_NEXT_STATE, TICKS_UNTIL_SPIN);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("State", this.getBoomBoomState().getSerializedName());
        pCompound.putInt("TimeUntilNextState", this.getTimeUntilNextState());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setBoomBoomState(State.byName(pCompound.getString("State")));
        this.setTimeUntilNextState(pCompound.getInt("TimeUntilNextState"));
    }

    private void setBoomBoomState(State pVariant) {
        this.entityData.set(DATA_STATE, pVariant.name);
    }

    private State getBoomBoomState() {
        return State.byName(this.entityData.get(DATA_STATE));
    }

    private void setTimeUntilNextState(int stateTime) {
        this.entityData.set(DATA_TIME_UNTIL_NEXT_STATE, stateTime);
    }

    private int getTimeUntilNextState() {
        return this.entityData.get(DATA_TIME_UNTIL_NEXT_STATE);
    }

    public boolean isDizzyState() {
        return this.getBoomBoomState() == State.DIZZY;
    }

    public boolean isSpinningState() {
        return this.getBoomBoomState() == State.SPINNING;
    }

    public boolean isFlyingState() {
        return this.getBoomBoomState() == State.FLYING;
    }

    static class BoomBoomAttackGoal extends MeleeAttackGoal {
        private final BoomBoomEntity boomBoom;

        public BoomBoomAttackGoal(BoomBoomEntity boomBoom) {
            super(boomBoom, 1.4, false);
            this.boomBoom = boomBoom;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && !boomBoom.isSpinningState();
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && !boomBoom.isSpinningState();
        }
    }

    static class BoomBoomSpinGoal extends MeleeAttackGoal {
        private final BoomBoomEntity boomBoom;

        public BoomBoomSpinGoal(BoomBoomEntity boomBoom) {
            super(boomBoom, 1.6, false);
            this.boomBoom = boomBoom;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && boomBoom.isSpinningState();
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && boomBoom.isSpinningState();
        }
    }

    static class BoomBoomMoveControl extends MoveControl {
        private final BoomBoomEntity boomBoom;

        public BoomBoomMoveControl(BoomBoomEntity boomBoom) {
            super(boomBoom);
            this.boomBoom = boomBoom;
        }

        public void tick() {
            if (this.boomBoom.isFlyingState()) {
                if (this.operation == MoveControl.Operation.MOVE_TO) {
                    this.operation = MoveControl.Operation.WAIT;
                    this.mob.setNoGravity(true);
                    double d0 = this.wantedX - this.mob.getX();
                    double d1 = this.wantedY - this.mob.getY();
                    double d2 = this.wantedZ - this.mob.getZ();
                    double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                    if (d3 < (double)2.5000003E-7F) {
                        this.mob.setYya(0.0F);
                        this.mob.setZza(0.0F);
                        return;
                    }

                    float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                    this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, 90.0F));
                    float f1;
                    if (this.mob.onGround()) {
                        f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    } else {
                        f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
                    }

                    this.mob.setSpeed(f1);
                    double d4 = Math.sqrt(d0 * d0 + d2 * d2);
                    if (Math.abs(d1) > (double)1.0E-5F || Math.abs(d4) > (double)1.0E-5F) {
                        float f2 = (float)(-(Mth.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
                        this.mob.setXRot(this.rotlerp(this.mob.getXRot(), f2, (float)10));
                        this.mob.setYya(d1 > 0.0D ? f1 : -f1);
                    }
                } else {
                    this.mob.setNoGravity(false);
                    this.mob.setYya(0.0F);
                    this.mob.setZza(0.0F);
                }
            } else {
                super.tick();
            }
        }
    }

    public enum State implements StringRepresentable {
        NORMAL("normal"),
        DIZZY("dizzy"),
        SPINNING("spinning"),
        FLYING("flying");

        public static final StringRepresentable.EnumCodec<State> CODEC = StringRepresentable.fromEnum(State::values);
        final String name;

        State(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        static State byName(String pName) {
            return CODEC.byName(pName, NORMAL);
        }
    }
}
