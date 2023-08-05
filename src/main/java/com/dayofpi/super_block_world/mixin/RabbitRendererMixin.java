package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Rabbit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RabbitRenderer.class)
public class RabbitRendererMixin {
    @Unique
    private static final ResourceLocation MIPS_TEXTURE = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/rabbit/mips.png");
    @Unique
    private static final ResourceLocation IRIS_TEXTURE = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/rabbit/irislikestodraw.png");

    @Inject(at = @At("HEAD"), method = "getTextureLocation(Lnet/minecraft/world/entity/animal/Rabbit;)Lnet/minecraft/resources/ResourceLocation;", cancellable = true)
    private void getTexture(Rabbit rabbitEntity, CallbackInfoReturnable<ResourceLocation> cir) {
        String string = ChatFormatting.stripFormatting(rabbitEntity.getName().getString());
        if ("MIPS".equals(string)) {
            cir.setReturnValue(MIPS_TEXTURE);
        }
        else if ("irislikestodraw".equals(string)) {
            cir.setReturnValue(IRIS_TEXTURE);
        }
    }
}
