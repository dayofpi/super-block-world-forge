package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class HungryLumaEntity extends AbstractLuma {
    private static final EntityDataAccessor<Integer> DATA_STAR_BITS_RECEIVED = SynchedEntityData.defineId(HungryLumaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_STAR_BITS_WANTED = SynchedEntityData.defineId(HungryLumaEntity.class, EntityDataSerializers.INT);
    public final AnimationState transformAnimationState = new AnimationState();
    private int transformTime = 30;

    public HungryLumaEntity(EntityType<? extends AbstractLuma> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new InteractGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isFull() ? null : ModSoundEvents.HUNGRY_LUMA_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSoundEvents.HUNGRY_LUMA_HURT.get();
    }

    @Override
    public void aiStep() {
        if (this.isFull()) {
            --this.transformTime;
        }
        if (this.transformTime == 15) {
            this.playSound(ModSoundEvents.HUNGRY_LUMA_TRANSFORM.get(), 5.0F, this.getVoicePitch());
            if (this.level().isClientSide()) {
                this.transformAnimationState.start(this.tickCount);
                for (int i = 0; i < 5; ++i) {
                    this.level().addParticle(ParticleTypes.WAX_OFF, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                }
            }
        }
        if (this.transformTime == 0) {
            this.transform();
            this.playSound(ModSoundEvents.HUNGRY_LUMA_POOF.get());
            if (this.level().isClientSide()) {
                for (int i = 0; i < 5; ++i) {
                    this.level().addParticle(ParticleTypes.POOF, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                }
            }
            this.discard();
        }
        super.aiStep();
    }

    public boolean isFull() {
        return this.getReceivedStarBits() == this.getWantedStarBits();
    }

    private void transform() {
        this.spawnAtLocation(ModItems.LAUNCH_STAR.get());
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.getDirectEntity() instanceof StarBitEntity && this.getReceivedStarBits() < this.getWantedStarBits()) {
            this.playSound(ModSoundEvents.HUNGRY_LUMA_EAT.get());
            this.setReceivedStarBits(this.getReceivedStarBits() + 1);
            return false;
        }
        return super.hurt(pSource, pAmount);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setWantedStarBits(UniformInt.of(30, 50).sample(pLevel.getRandom()));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_STAR_BITS_RECEIVED, 0);
        this.entityData.define(DATA_STAR_BITS_WANTED, 50);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("ReceivedStarBits", this.getReceivedStarBits());
        pCompound.putInt("WantedStarBits", this.getWantedStarBits());
        pCompound.putInt("TransformTime", this.transformTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setReceivedStarBits(pCompound.getInt("ReceivedStarBits"));
        this.setWantedStarBits(pCompound.getInt("WantedStarBits"));
        if (pCompound.contains("TransformTime")) {
            this.transformTime = pCompound.getInt("TransformTime");
        }
    }

    private void setReceivedStarBits(int starBits) {
        this.entityData.set(DATA_STAR_BITS_RECEIVED, starBits);
    }

    public int getReceivedStarBits() {
        return this.entityData.get(DATA_STAR_BITS_RECEIVED);
    }

    private void setWantedStarBits(int starBits) {
        this.entityData.set(DATA_STAR_BITS_WANTED, starBits);
    }

    public int getWantedStarBits() {
        return this.entityData.get(DATA_STAR_BITS_WANTED);
    }
}
