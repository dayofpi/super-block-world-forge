package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class BombEntity extends ModThrownItemEntity {
    public BombEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public BombEntity(Level level, LivingEntity owner) {
        super(ModEntityTypes.BOMB.get(), owner, level);
    }

    public BombEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.BOMB.get(), x, y, z, level);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.9D, this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        this.goBoom();
    }

    private void goBoom() {
        if (!this.level().isClientSide) {
            level().explode(this, this.getX(), this.getY(), this.getZ(), 1.8F, this.getOwner() instanceof Player ? Level.ExplosionInteraction.TNT : Level.ExplosionInteraction.MOB);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BOMB.get();
    }

    @Override
    protected float getGravity() {
        return 0.05F;
    }
}
