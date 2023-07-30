package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.entity.custom.HammerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

public class HammerRenderer<T extends HammerEntity> extends EntityRenderer<T> {
    private final ItemRenderer itemRenderer;
    private final float scale;

    public HammerRenderer(EntityRendererProvider.Context context, float scale) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.scale = scale;
    }

    public HammerRenderer(EntityRendererProvider.Context context) {
        this(context, 1.0F);
    }

    public void render(T entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        if (entity.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25D)) {
            poseStack.pushPose();
            poseStack.scale(this.scale, this.scale, this.scale);
            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            poseStack.mulPose(Axis.ZP.rotationDegrees(entity.tickCount * 20));
            this.itemRenderer.renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, entity.level(), entity.getId());
            poseStack.popPose();
            super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
