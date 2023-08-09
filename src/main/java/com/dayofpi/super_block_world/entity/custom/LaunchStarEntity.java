package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LaunchStarEntity extends HangingEntity {
    private static final EntityDataAccessor<Integer> COOLDOWN = SynchedEntityData.defineId(LaunchStarEntity.class, EntityDataSerializers.INT);
    private static final int MAX_COOLDOWN = 30;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState launchAnimationState = new AnimationState();
    private int ambientSoundChance;

    public LaunchStarEntity(EntityType<? extends HangingEntity> entityType, Level level) {
        super(entityType, level);
    }

    public LaunchStarEntity(Level level, BlockPos pos, Direction direction) {
        super(ModEntityTypes.LAUNCH_STAR.get(), level, pos);
        this.setDirection(direction);
    }

    public int getCooldown() {
        return this.entityData.get(COOLDOWN);
    }

    public void setCooldown(int time) {
        this.entityData.set(COOLDOWN, time);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putByte("facing", (byte)this.direction.get2DDataValue());
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("LaunchCooldown", this.getCooldown());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        this.direction = Direction.from2DDataValue(compoundTag.getByte("facing"));
        super.readAdditionalSaveData(compoundTag);
        this.setCooldown(compoundTag.getInt("LaunchCooldown"));
        this.setDirection(this.direction);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COOLDOWN, 0);
    }

    public int getMinAmbientSoundDelay() {
        return 140;
    }

    public void playAmbientSound() {
        SoundEvent soundEvent = ModSoundEvents.LAUNCH_STAR_AMBIENT.get();
        this.playSound(soundEvent, 1.0F, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.idleAnimationState.animateWhen(this.getCooldown() <= 0, this.tickCount);
            this.launchAnimationState.animateWhen(this.getCooldown() > 0, this.tickCount);
            if (random.nextFloat() > 0.8F)
                this.level().addParticle(ParticleTypes.WAX_OFF, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), this.direction.getNormal().getX(), this.direction.getNormal().getY(), this.direction.getNormal().getZ());
        }

        List<Entity> list = level().getEntities(this, this.getBoundingBox(), EntitySelector.NO_SPECTATORS);
        if (this.getCooldown() > 0) {
            this.setCooldown(this.getCooldown() - 1);
        }

        final int launchTime = MAX_COOLDOWN / 2;
        List<Entity> passengers = new ArrayList<>(List.of());

        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundChance++) {
            this.resetSoundDelay();
            this.playAmbientSound();
        }

        if (!list.isEmpty()) {
            passengers.addAll(list);
            if (this.getCooldown() == 0) {
                this.setCooldown(MAX_COOLDOWN);
                this.playSound(ModSoundEvents.LAUNCH_STAR_LAUNCH.get(), 5.0F, 1.0F);
            }
            for (Iterator<Entity> iterator = passengers.iterator(); iterator.hasNext(); ) {
                Entity entity = iterator.next();
                if (this.getCooldown() > launchTime) {
                    Vec3 vec3;
                    double d;
                    if ((d = (vec3 = new Vec3(this.getX() - entity.getX(), this.getY() - entity.getY(), this.getZ() - entity.getZ())).lengthSqr()) < 64.0) {
                        double e = 1.0 - Math.sqrt(d) / 8.0;
                        entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.normalize().multiply(e * e * 0.2, e * e * 0.2, e * e * 0.2)));
                    }
                } else if (this.getCooldown() == launchTime) {
                    if (level() instanceof ServerLevel) {
                        ((ServerLevel) level()).sendParticles(ParticleTypes.POOF, this.getX() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), this.getY() + 0.5D, this.getZ() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                        ((ServerLevel) level()).sendParticles(ParticleTypes.POOF, this.getX() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), this.getY() + 0.5D, this.getZ() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    }
                    entity.setDeltaMovement(Vec3.atLowerCornerOf(this.direction.getNormal()).multiply(3, 3, 3));
                    iterator.remove();
                }
            }
        }

    }

    private void resetSoundDelay() {
        this.ambientSoundChance = -this.getMinAmbientSoundDelay();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.getCooldown() > 0)
            return false;
        return super.hurt(source, amount);
    }

    @Override
    public boolean survives() {
        if (!this.level().noCollision(this)) {
            return false;
        }
        return this.level().getEntities(this, this.getBoundingBox(), HANGING_ENTITY).isEmpty();
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public void dropItem(@Nullable Entity entity) {
        this.playSound(ModSoundEvents.LAUNCH_STAR_BREAK.get(), 1.0F, 0.8F);
        if (entity instanceof Player player && player.getAbilities().instabuild) return;
        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) this.spawnAtLocation(ModItems.LAUNCH_STAR.get());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
        this.setDirection(Direction.from3DDataValue(pPacket.getData()));
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.LAUNCH_STAR.get());
    }

    @Override
    public void playPlacementSound() {
        this.playSound(ModSoundEvents.LAUNCH_STAR_PLACE.get(), 1.0F, 1.0F);
    }

    @Override
    protected float getEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.0F;
    }

    @Override
    protected void setDirection(Direction pFacingDirection) {
        Validate.notNull(pFacingDirection);
        this.direction = pFacingDirection;
        if (pFacingDirection.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float)(this.direction.get2DDataValue() * 90));
        } else {
            this.setXRot((float)(-90 * pFacingDirection.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    @Override
    protected void recalculateBoundingBox() {
        if (direction != null) {
            double x = (double) this.pos.getX() + 0.5 - (double) this.direction.getStepX() * 0.46875;
            double y = (double) this.pos.getY() + 0.5 - (double) this.direction.getStepY() * 0.46875;
            double z = (double) this.pos.getZ() + 0.5 - (double) this.direction.getStepZ() * 0.46875;
            double xp = this.getWidth();
            double yp = this.getHeight();
            double zp = this.getWidth();
            Direction.Axis axis = this.direction.getAxis();
            switch (axis) {
                case X -> {
                    xp = 5.0;
                    x += 0.3 * this.direction.getStepX();
                }
                case Y -> {
                    yp = 5.0;
                    y += 0.3 * this.direction.getStepY();
                }
                case Z -> {
                    zp = 5.0;
                    z += 0.3 * this.direction.getStepZ();
                }
            }
            this.setPosRaw(x, y, z);
            this.setBoundingBox(new AABB(x - (xp /= 32.0), y - (yp /= 32.0), z - (zp /= 32.0), x + xp, y + yp, z + zp));
        }
    }
}
