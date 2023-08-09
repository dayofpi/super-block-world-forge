package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.LaunchStarEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class LaunchStarRenderer<T extends LaunchStarEntity> extends EntityRenderer<T> {
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/launch_star.png");
    private final EntityModel<T> model;

    public LaunchStarRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;
        this.model = new LaunchStarModel<>(context.bakeLayer(LaunchStarModel.LAYER_LOCATION));
    }

    @Override
    protected int getBlockLightLevel(T pEntity, BlockPos pPos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return TEXTURE_LOCATION;
    }

    protected float getAnimationProgress(T entity, float tickDelta) {
        return (float)(entity).tickCount + tickDelta;
    }

    @Override
    public void render(T pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getXRot()));
        pPoseStack.scale(-1.0f, -1.0f, 1.0f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0f - pEntity.getYRot()));
        pPoseStack.translate(0.0, -1.5, 0.5);
        this.model.setupAnim(pEntity, pPartialTick, 0.0f, this.getAnimationProgress(pEntity, pPartialTick), 0.0f, 0.0f);

        VertexConsumer base = pBuffer.getBuffer(this.model.renderType(getTextureLocation(pEntity)));
        this.model.renderToBuffer(pPoseStack, base, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);    
    }

}
