package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.OctoombaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OctoombaRenderer extends MobRenderer<OctoombaEntity, OctoombaModel<OctoombaEntity>> {
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/octoomba.png");

    public OctoombaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OctoombaModel<>(pContext.bakeLayer(OctoombaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(OctoombaEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}
