package com.dayofpi.super_block_world.block.client;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.block_entities.ItemDisplayBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PlacedItemRenderer implements BlockEntityRenderer<ItemDisplayBlockEntity> {
    public PlacedItemRenderer() {}

    @Override
    public void render(ItemDisplayBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Level level = blockEntity.getLevel();
        BlockPos pos = blockEntity.getBlockPos();

        if (level != null) {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if (blockState.is(ModBlocks.POWER_STAR.get()))
                i = 15728850;
            poseStack.translate(0.5, 0.5, 0.5);
            poseStack.scale(0.8f, 0.8f, 0.8f);
            poseStack.mulPose(Axis.YP.rotationDegrees((level.getGameTime() + f) * 4));
            Minecraft.getInstance().getItemRenderer().renderStatic(block.asItem().getDefaultInstance(), ItemDisplayContext.GUI, i, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, level, 0);
        }
    }
}
