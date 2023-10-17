package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.ChainChompEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class ChainChompCollarLayer extends RenderLayer<ChainChompEntity, ChainChompModel<ChainChompEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/chain_chomp/chain_chomp_collar.png");

    public ChainChompCollarLayer(RenderLayerParent<ChainChompEntity, ChainChompModel<ChainChompEntity>> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, ChainChompEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (pLivingEntity.isTame() && !pLivingEntity.isInvisible()) {
            float[] afloat = pLivingEntity.getCollarColor().getTextureDiffuseColors();
            renderColoredCutoutModel(this.getParentModel(), TEXTURE_LOCATION, pPoseStack, pBuffer, pPackedLight, pLivingEntity, afloat[0], afloat[1], afloat[2]);
        }
    }
}
