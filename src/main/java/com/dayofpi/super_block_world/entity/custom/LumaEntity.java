package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class LumaEntity extends AbstractLuma implements RangedAttackMob {
    private static final EntityDataAccessor<Integer> DATA_STAR_BITS = SynchedEntityData.defineId(LumaEntity.class, EntityDataSerializers.INT);

    public LumaEntity(EntityType<? extends AbstractLuma> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setCanPickUpLoot(true);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SeekStarBitsGoal());
        this.goalSelector.addGoal(3, new LumaAttackGoal(this, 1.25D, 30, 10.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, (livingEntity) -> livingEntity instanceof Enemy));
    }

    @Override
    protected void pickUpItem(ItemEntity pItemEntity) {
        ItemStack itemstack = pItemEntity.getItem();
        if (itemstack.is(ModTags.Items.STAR_BITS) && this.getStarBits() < 64) {
            this.onItemPickup(pItemEntity);
            this.setStarBits(this.getStarBits() + 1);
            this.take(pItemEntity, 1);
            this.playSound(ModSoundEvents.STAR_BIT_PICKUP.get(), 0.2F, 1.0F);
            itemstack.shrink(1);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.LUMA_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSoundEvents.LUMA_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.LUMA_DEATH.get();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        StarBitEntity starBit = new StarBitEntity(this.level(), this);
        double d0 = pTarget.getEyeY() - (double)1.5F;
        double d1 = pTarget.getX() - this.getX();
        double d2 = d0 - starBit.getY();
        double d3 = pTarget.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        starBit.shoot(d1, d2 + d4, d3, 1.5F, 1.0F);
        this.playSound(ModSoundEvents.STAR_BIT_SHOOT.get(), 1.0F, (this.getRandom().nextFloat() - this.getRandom().nextFloat()) * 0.2F + 1.0F);
        this.setStarBits(this.getStarBits() - 1);
        this.level().addFreshEntity(starBit);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_STAR_BITS, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("StarBits", this.getStarBits());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setStarBits(pCompound.getInt("StarBits"));
    }

    private void setStarBits(int starBits) {
        this.entityData.set(DATA_STAR_BITS, starBits);
    }

    public int getStarBits() {
        return this.entityData.get(DATA_STAR_BITS);
    }

    class SeekStarBitsGoal extends Goal {
        public SeekStarBitsGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            List<ItemEntity> list = LumaEntity.this.level().getEntitiesOfClass(ItemEntity.class, LumaEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), itemEntity -> itemEntity.getItem().is(ModTags.Items.STAR_BITS));
            return !list.isEmpty();
        }

        @Override
        public void tick() {
            List<ItemEntity> list = LumaEntity.this.level().getEntitiesOfClass(ItemEntity.class, LumaEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), itemEntity -> itemEntity.getItem().is(ModTags.Items.STAR_BITS));
            if (!list.isEmpty()) {
                LumaEntity.this.getNavigation().moveTo(list.get(0), 1.2F);
            }
        }

        @Override
        public void start() {
            List<ItemEntity> list = LumaEntity.this.level().getEntitiesOfClass(ItemEntity.class, LumaEntity.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), itemEntity -> itemEntity.getItem().is(ModTags.Items.STAR_BITS));
            if (!list.isEmpty()) {
                LumaEntity.this.getNavigation().moveTo(list.get(0), 1.2F);
            }
        }
    }

    class LumaAttackGoal extends RangedAttackGoal {
        public LumaAttackGoal(LumaEntity luma, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
            super(luma, pSpeedModifier, pAttackInterval, pAttackRadius);
            this.setFlags(EnumSet.of(Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return super.canUse() && LumaEntity.this.getStarBits() > 0;
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && LumaEntity.this.getStarBits() > 0;
        }
    }
}
