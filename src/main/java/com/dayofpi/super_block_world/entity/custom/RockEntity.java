package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class RockEntity extends ModThrownItemEntity {
    public RockEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public RockEntity(Level level, LivingEntity owner) {
        super(ModEntityTypes.ROCK.get(), owner, level);
    }

    public RockEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.ROCK.get(), x, y, z, level);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 4);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MOON_ROCK.get();
    }

    @Override
    protected float getGravity() {
        return 0.07F;
    }
}
