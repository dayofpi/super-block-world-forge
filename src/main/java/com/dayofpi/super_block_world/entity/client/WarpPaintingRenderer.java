package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.WarpPaintingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WarpPaintingRenderer extends EntityRenderer<WarpPaintingEntity> {
    private final EntityModel<WarpPaintingEntity> model;

    private static final ResourceLocation LOCKED = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/warp_painting/locked.png");
    private static final ResourceLocation MUSHROOM_KINGDOM = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/warp_painting/mushroom_kingdom.png");
    private static final ResourceLocation OVERWORLD = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/warp_painting/overworld.png");

    public WarpPaintingRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new WarpPaintingModel<>(pContext.bakeLayer(WarpPaintingModel.LAYER_LOCATION));
    }

    @Override
    public void render(WarpPaintingEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.pushPose();
        Direction direction = pEntity.getDirection();
        Vec3 vec3 = this.getRenderOffset(pEntity, pPartialTick);
        pPoseStack.translate(-vec3.x(), -vec3.y(), -vec3.z());
        double d0 = 0.46875D;
        pPoseStack.translate((double)direction.getStepX() * 0.46875D, (double)direction.getStepY() * 0.46875D, (double)direction.getStepZ() * 0.46875D);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getXRot()));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F - pEntity.getYRot()));
        boolean flag = pEntity.isInvisible();
        if (!flag) {
            pPoseStack.pushPose();
            pPoseStack.scale(-1.0F, -1.0F, 1.0F);
            pPoseStack.translate(0.0F, 0.5F, 1.0F);
            VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
            this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            pPoseStack.popPose();
        }
        pPoseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(WarpPaintingEntity pEntity) {
        if (pEntity.getVariant() == WarpPaintingEntity.WarpPaintingVariant.LOCKED) {
            return LOCKED;
        }
        return pEntity.level().dimension() == Level.OVERWORLD ? MUSHROOM_KINGDOM : OVERWORLD;
    }
}
