package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.BoomBoomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BoomBoomRenderer extends MobRenderer<BoomBoomEntity, BoomBoomModel<BoomBoomEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/boom_boom.png");
    private static final ResourceLocation DIZZY_TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/boom_boom_dizzy.png");

    public BoomBoomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BoomBoomModel<>(pContext.bakeLayer(BoomBoomModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(BoomBoomEntity pEntity) {
        return pEntity.isDizzyState() ? DIZZY_TEXTURE_LOCATION : TEXTURE_LOCATION;
    }
}
