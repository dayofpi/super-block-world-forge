package com.dayofpi.super_block_world.entity.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.HungryLumaEntity;
import com.dayofpi.super_block_world.item.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.material.MapColor;
import org.joml.Matrix4f;

public class HungryLumaRenderer extends MobRenderer<HungryLumaEntity, HungryLumaModel<HungryLumaEntity>> {
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/luma/hungry_luma.png");
    public static final ResourceLocation FULL_TEXTURE_LOCATION = new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/entity/luma/hungry_luma_full.png");

    public HungryLumaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HungryLumaModel<>(pContext.bakeLayer(HungryLumaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    protected int getBlockLightLevel(HungryLumaEntity pEntity, BlockPos pPos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(HungryLumaEntity pEntity) {
        return pEntity.isFull() ? FULL_TEXTURE_LOCATION : TEXTURE_LOCATION;
    }

    @Override
    public void render(HungryLumaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        if (this.entityRenderDispatcher.crosshairPickEntity != pEntity || pEntity.getReceivedStarBits() == pEntity.getWantedStarBits()) {
            return;
        }
        String received = String.valueOf(pEntity.getReceivedStarBits());
        String wanted = String.valueOf(pEntity.getWantedStarBits());
        Component count = Component.literal(received + "/" + wanted);
        float itemY = pEntity.getBbHeight() + 0.5f;
        int textY = 10;
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0, itemY, 0.0);
        pMatrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        pMatrixStack.scale(-0.025f, -0.025f, 0.025f);
        Matrix4f matrix4f = pMatrixStack.last().pose();
        float backgroundOpacity = Minecraft.getInstance().options.getBackgroundOpacity(0.25f);
        int j = (int) (backgroundOpacity * 255.0f) << 24;
        Font font = this.getFont();
        float x = -font.width(count) / 2f;
        font.drawInBatch(count, x, (float) textY, MapColor.SNOW.col, false, matrix4f, pBuffer, Font.DisplayMode.NORMAL, j, pPackedLight);
        pMatrixStack.popPose();
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0, itemY, 0.0);
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(pEntity.tickCount * 10));
        pMatrixStack.scale(0.4f, 0.4f, 0.4f);
        Minecraft.getInstance().getItemRenderer().renderStatic(ModItems.RAINBOW_STAR_BIT.get().getDefaultInstance(), ItemDisplayContext.GUI, pPackedLight, OverlayTexture.NO_OVERLAY, pMatrixStack, pBuffer, pEntity.level(), 0);
        pMatrixStack.popPose();
    }
}
