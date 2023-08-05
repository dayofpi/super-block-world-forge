package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.entity.custom.WarpPaintingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public class AbstractArrowMixin {
    @Inject(at=@At("HEAD"), method = "onHitEntity", cancellable = true)
    private void onHitEntity(EntityHitResult pResult, CallbackInfo ci) {
        if (pResult.getEntity() instanceof WarpPaintingEntity) {
            ci.cancel();
        }
    }
}
