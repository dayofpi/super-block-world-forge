package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.util.ModTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.RegistryObject;

public class WarpPipeFeature extends Feature<NoneFeatureConfiguration> {
    public WarpPipeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public static BlockState createPipeState(RegistryObject<Block> block, Direction direction, boolean waterlogged) {
        return block.get().defaultBlockState().setValue(BlockStateProperties.FACING, direction).setValue(BlockStateProperties.WATERLOGGED, waterlogged);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int i = 0;
        WorldGenLevel level = pContext.level();
        BlockPos blockPos = pContext.origin();

        i = pContext.random().nextBoolean() ? generateCeilingPipe(pContext, i, level, blockPos) : generateFloorPipe(pContext, i, level, blockPos);

        return i > 0;
    }

    private static int generateFloorPipe(FeaturePlaceContext<NoneFeatureConfiguration> pContext, int i, WorldGenLevel level, BlockPos blockPos) {
        BlockPos floor = blockPos.below();
        if (level.getBlockState(blockPos).isAir() && level.getBlockState(floor).isSolidRender(level, floor)) {
            BlockState warpPipeState = createPipeState(ModBlocks.GREEN_WARP_PIPE, Direction.UP, false);
            BlockState pipeBodyState = createPipeState(ModBlocks.GREEN_PIPE_BODY, Direction.UP, false);
            RandomSource random = pContext.random();

            if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.RED_WARP_PIPE, Direction.UP, false);
                pipeBodyState = createPipeState(ModBlocks.RED_PIPE_BODY, Direction.UP, false);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.YELLOW_WARP_PIPE, Direction.UP, false);
                pipeBodyState = createPipeState(ModBlocks.YELLOW_PIPE_BODY, Direction.UP, false);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.BLUE_WARP_PIPE, Direction.UP, false);
                pipeBodyState = createPipeState(ModBlocks.BLUE_PIPE_BODY, Direction.UP, false);
            }

            int height = 1 + random.nextInt(6);
            for (int l = 0; l <= height; ++l) {
                if (level.getBlockState(blockPos).isAir() && level.getBlockState(blockPos.above()).isAir()) {
                    if (l == height) {
                        level.setBlock(blockPos, warpPipeState, 2);
                        ++i;
                    } else {
                        level.setBlock(blockPos, pipeBodyState, 2);
                    }
                } else if (l > 0) {
                    BlockPos blockPos3 = blockPos.below();
                    if (!level.getBlockState(blockPos3.below()).is(ModTags.Blocks.WARP_PIPES)) {
                        level.setBlock(blockPos3, warpPipeState, 2);
                        ++i;
                    }
                    break;
                }

                blockPos = blockPos.above();
            }
        }
        return i;
    }

    private static int generateCeilingPipe(FeaturePlaceContext<NoneFeatureConfiguration> pContext, int i, WorldGenLevel level, BlockPos blockPos) {
        BlockPos ceiling = blockPos.above();
        if (level.getBlockState(blockPos).isAir() && level.getBlockState(ceiling).isSolidRender(level, ceiling)) {
            BlockState warpPipeState = createPipeState(ModBlocks.GREEN_WARP_PIPE, Direction.DOWN, false);
            BlockState pipeBodyState = createPipeState(ModBlocks.GREEN_PIPE_BODY, Direction.DOWN, false);
            RandomSource random = pContext.random();

            if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.RED_WARP_PIPE, Direction.DOWN, false);
                pipeBodyState = createPipeState(ModBlocks.RED_PIPE_BODY, Direction.DOWN, false);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.YELLOW_WARP_PIPE, Direction.DOWN, false);
                pipeBodyState = createPipeState(ModBlocks.YELLOW_PIPE_BODY, Direction.DOWN, false);
            } else if (random.nextInt(4) == 0) {
                warpPipeState = createPipeState(ModBlocks.BLUE_WARP_PIPE, Direction.DOWN, false);
                pipeBodyState = createPipeState(ModBlocks.BLUE_PIPE_BODY, Direction.DOWN, false);
            }

            int height = 1 + random.nextInt(6);
            for (int l = 0; l <= height; ++l) {
                if (level.getBlockState(blockPos).isAir() && level.getBlockState(blockPos.below()).isAir()) {
                    if (l == height) {
                        level.setBlock(blockPos, warpPipeState, 2);
                        ++i;
                    } else {
                        level.setBlock(blockPos, pipeBodyState, 2);
                    }
                } else if (l > 0) {
                    BlockPos blockPos3 = blockPos.above();
                    if (!level.getBlockState(blockPos3.above()).is(ModTags.Blocks.WARP_PIPES)) {
                        level.setBlock(blockPos3, warpPipeState, 2);
                        ++i;
                    }
                    break;
                }

                blockPos = blockPos.below();
            }
        }
        return i;
    }
}
