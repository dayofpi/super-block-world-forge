package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.ShyGuyEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShyGuyRenderer extends MobRenderer<ShyGuyEntity, ShyGuyModel<ShyGuyEntity>> {
    public ShyGuyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShyGuyModel<>(pContext.bakeLayer(ShyGuyModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(ShyGuyEntity pEntity) {
        return new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/shy_guy/" + pEntity.getVariant().getSerializedName() + ".png");
    }
}
