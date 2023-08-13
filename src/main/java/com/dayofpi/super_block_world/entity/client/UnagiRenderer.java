package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.UnagiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class UnagiRenderer extends MobRenderer<UnagiEntity, UnagiModel<UnagiEntity>> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID,"textures/entity/unagi.png");

    public UnagiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new UnagiModel<>(pContext.bakeLayer(UnagiModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    protected void setupRotations(UnagiEntity pEntityLiving, PoseStack pMatrixStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pMatrixStack, pAgeInTicks, pRotationYaw, pPartialTicks);
        float f = 4.3F * Mth.sin(0.6F * pAgeInTicks);
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(f));
        if (!pEntityLiving.isInWater()) {
            pMatrixStack.translate(0.2F, 0.1F, 0.0F);
            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public void render(UnagiEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = 0.6F * ((float)pEntity.getSize() + 1);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    protected void scale(UnagiEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = 1.0F + 0.5F * (float)pLivingEntity.getSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(UnagiEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}
