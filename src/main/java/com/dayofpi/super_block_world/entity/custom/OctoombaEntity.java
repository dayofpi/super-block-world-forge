package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.SpaceCreature;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class OctoombaEntity extends Monster implements SpaceCreature, RangedAttackMob {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    public OctoombaEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0, 25, 5.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.OCTOOMBA_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSoundEvents.OCTOOMBA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.OCTOOMBA_DEATH.get();
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(ModSoundEvents.OCTOOMBA_STEP.get(), 0.15F, 1.0F);
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
        super.tick();
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 4) {
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.level().broadcastEntityEvent(this, (byte)4);
        RockEntity rock = new RockEntity(this.level(), this);
        double d0 = pTarget.getEyeY() - (double)1.5F;
        double d1 = pTarget.getX() - this.getX();
        double d2 = d0 - rock.getY();
        double d3 = pTarget.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        rock.shoot(d1, d2 + d4, d3, 0.8F, 1.0F);
        this.playSound(ModSoundEvents.OCTOOMBA_SHOOT.get(), 1.0F, (this.getRandom().nextFloat() - this.getRandom().nextFloat()) * 0.2F + 1.0F);
        this.level().addFreshEntity(rock);
    }
}
