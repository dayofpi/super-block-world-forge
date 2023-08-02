package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.util.ModTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class UnderwaterPipeFeature extends Feature<NoneFeatureConfiguration> {
    public UnderwaterPipeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int i = 0;
        WorldGenLevel level = pContext.level();
        BlockPos blockPos = pContext.origin();
        BlockPos floor = pContext.origin().below();

        if (level.getBlockState(blockPos).is(Blocks.WATER) && level.getBlockState(floor).isSolidRender(level, floor)) {
            BlockState warpPipeState = WarpPipeFeature.createPipeState(ModBlocks.GREEN_WARP_PIPE, true);
            BlockState pipeBodyState = WarpPipeFeature.createPipeState(ModBlocks.GREEN_PIPE_BODY, true);
            RandomSource random = pContext.random();

            if (random.nextInt(4) == 0) {
                warpPipeState = WarpPipeFeature.createPipeState(ModBlocks.RED_WARP_PIPE, true);
                pipeBodyState = WarpPipeFeature.createPipeState(ModBlocks.RED_PIPE_BODY, true);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = WarpPipeFeature.createPipeState(ModBlocks.YELLOW_WARP_PIPE, true);
                pipeBodyState = WarpPipeFeature.createPipeState(ModBlocks.YELLOW_PIPE_BODY, true);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = WarpPipeFeature.createPipeState(ModBlocks.BLUE_WARP_PIPE, true);
                pipeBodyState = WarpPipeFeature.createPipeState(ModBlocks.BLUE_PIPE_BODY, true);
            }

            int height = 1 + random.nextInt(6);
            for (int l = 0; l <= height; ++l) {
                if (level.getBlockState(blockPos).is(Blocks.WATER) && level.getBlockState(blockPos.above()).is(Blocks.WATER)) {
                    if (l == height) {
                        level.setBlock(blockPos, warpPipeState, 2);
                        BubbleColumnBlock.updateColumn(level, blockPos.above(), warpPipeState);
                        ++i;
                    } else {
                        level.setBlock(blockPos, pipeBodyState, 2);
                    }
                } else if (l > 0) {
                    BlockPos blockPos3 = blockPos.below();
                    if (!level.getBlockState(blockPos3.below()).is(ModTags.Blocks.WARP_PIPES)) {
                        level.setBlock(blockPos3, warpPipeState, 2);
                        BubbleColumnBlock.updateColumn(level, blockPos3.above(), warpPipeState);
                        ++i;
                    }
                    break;
                }

                blockPos = blockPos.above();
            }
        }

        return i > 0;
    }
}
