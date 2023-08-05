package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class StarBitEntity extends ModThrownItemEntity {
    public StarBitEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public StarBitEntity(Level level, LivingEntity owner) {
        super(ModEntityTypes.STAR_BIT.get(), owner, level);
    }

    public StarBitEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.STAR_BIT.get(), x, y, z, level);
    }

    @Override
    public void tick() {
        if (this.tickCount > 200) {
            this.discard();
        }
        super.tick();
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(ModSoundEvents.STAR_BIT_BREAK.get(), 0.7F, 1.2F);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.YELLOW_STAR_BIT.get();
    }

    @Override
    protected float getGravity() {
        return 0.0F;
    }
}
