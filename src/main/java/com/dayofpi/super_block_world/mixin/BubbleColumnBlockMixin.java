package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BubbleColumnBlock.class)
public class BubbleColumnBlockMixin {
    @Inject(at = @At("HEAD"), method = "getColumnState", cancellable = true)
    private static void getColumnState(BlockState state, CallbackInfoReturnable<BlockState> info) {
        if (state.is(ModTags.Blocks.WARP_PIPES) && state.getValue(BlockStateProperties.FACING) == Direction.UP && state.getValue(BlockStateProperties.WATERLOGGED)) {
            info.setReturnValue(Blocks.BUBBLE_COLUMN.defaultBlockState().setValue(BubbleColumnBlock.DRAG_DOWN, false));
        }
    }

    @Inject(at = @At("HEAD"), method = "canSurvive", cancellable = true)
    public void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> info) {
        BlockState blockState2 = levelReader.getBlockState(blockPos.below());
        if (blockState2.is(ModTags.Blocks.WARP_PIPES) && blockState2.getValue(BlockStateProperties.FACING) == Direction.UP && blockState2.getValue(BlockStateProperties.WATERLOGGED)) {
            info.setReturnValue(true);
        }
    }
}
