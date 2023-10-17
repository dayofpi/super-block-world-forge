package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.ChainChompEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChainChompRenderer extends MobRenderer<ChainChompEntity, ChainChompModel<ChainChompEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/chain_chomp/chain_chomp.png");
    private static final ResourceLocation TAME_TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/chain_chomp/chain_chomp_tame.png");

    public ChainChompRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChainChompModel<>(pContext.bakeLayer(ChainChompModel.LAYER_LOCATION)), 0.8F);
        this.addLayer(new ChainChompCollarLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ChainChompEntity pEntity) {
        return pEntity.isTame() ? TAME_TEXTURE_LOCATION : TEXTURE_LOCATION;
    }
}
