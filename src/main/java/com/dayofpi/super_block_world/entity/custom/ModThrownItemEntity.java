package com.dayofpi.super_block_world.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;

public abstract class ModThrownItemEntity extends ThrowableItemProjectile {
    public ModThrownItemEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModThrownItemEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, double pX, double pY, double pZ, Level pLevel) {
        super(pEntityType, pX, pY, pZ, pLevel);
    }

    public ModThrownItemEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }

    private ParticleOptions getParticleParameters() {
        return new ItemParticleOption(ParticleTypes.ITEM, this.getItem());
    }

    public void handleEntityEvent(byte status) {
        super.handleEntityEvent(status);
        if (status != 3)
            return;
        ParticleOptions particleOptions = this.getParticleParameters();
        for (int i = 0; i < 8; ++i) {
            this.level().addParticle(particleOptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }
}
