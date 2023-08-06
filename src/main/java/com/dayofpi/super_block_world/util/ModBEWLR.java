package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.block.block_entities.FlagBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModBEWLR extends BlockEntityWithoutLevelRenderer {
    public static final ModBEWLR INSTANCE = new ModBEWLR();
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public ModBEWLR() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
    }

    @Override
    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        Item item = itemStack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();
            if (block.defaultBlockState().is(ModTags.Blocks.FLAGS)) {
                this.blockEntityRenderDispatcher.renderItem(new FlagBlockEntity(BlockPos.ZERO, block.defaultBlockState()), poseStack, multiBufferSource, packedLight, packedOverlay);
            }
        }
    }
}
