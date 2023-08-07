package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.block_entities.WarpPipeBlockEntity;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LinkedWarpPipeFeature extends Feature<NoneFeatureConfiguration> {
    public LinkedWarpPipeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos caveWarpPipePos = pContext.origin();
        BlockPos caveFloorPos = caveWarpPipePos.below();

        WorldGenLevel level = pContext.level();
        BlockPos surfaceWarpPipePos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, caveWarpPipePos);
        BlockPos surfaceFloorPos = surfaceWarpPipePos.below();

        boolean canPlaceCavePipe = caveWarpPipePos != surfaceWarpPipePos && level.getBlockState(caveWarpPipePos).isAir() && level.getBlockState(caveWarpPipePos.above()).isAir() && level.getBlockState(caveFloorPos).isSolidRender(level, caveFloorPos);
        boolean canPlaceSurfacePipe = level.getBlockState(surfaceWarpPipePos).isAir() && level.getBlockState(surfaceWarpPipePos.above()).isAir() && level.getBlockState(surfaceFloorPos).isSolidRender(level, surfaceFloorPos);
        if (canPlaceCavePipe && canPlaceSurfacePipe) {
            RandomSource random = pContext.random();
            BlockState warpPipeState = getWarpPipeState(random);
            BlockState pipeBodyState = getMatchingPipeBody(warpPipeState);

            // Generate cave pipe
            int cavePipeHeight = 1 + random.nextInt(6);
            boolean canGrow = true;
            for (int i = 0; i <= cavePipeHeight; ++i) {
                if (!level.getBlockState(caveWarpPipePos.above(i)).isAir())
                    canGrow = false;
            }
            if (level.getBlockState(caveWarpPipePos.above(cavePipeHeight + 1)).isAir()) {
                for (int i = 0; i < cavePipeHeight; ++i) {
                    level.setBlock(caveWarpPipePos.above(i), pipeBodyState, 2);
                }
                caveWarpPipePos = caveWarpPipePos.above(cavePipeHeight);
            }

            level.setBlock(caveWarpPipePos, warpPipeState, 2);

            // Generate surface pipe
            int surfacePipeHeight = 1 + random.nextInt(6);
            canGrow = true;
            for (int i = 0; i <= surfacePipeHeight; ++i) {
                if (!level.getBlockState(surfaceWarpPipePos.above(i)).isAir())
                    canGrow = false;
            }
            if (level.getBlockState(surfaceWarpPipePos.above(surfacePipeHeight + 1)).isAir()) {
                for (int i = 0; i < surfacePipeHeight; ++i) {
                    level.setBlock(surfaceWarpPipePos.above(i), pipeBodyState, 2);
                }
                surfaceWarpPipePos = surfaceWarpPipePos.above(surfacePipeHeight);
            }
            level.setBlock(surfaceWarpPipePos, warpPipeState, 2);
            if (level.getBlockEntity(caveWarpPipePos) instanceof WarpPipeBlockEntity caveWarpPipeBE && level.getBlockEntity(surfaceWarpPipePos) instanceof WarpPipeBlockEntity surfaceWarpPipeBE) {
                caveWarpPipeBE.setDestinationPos(surfaceWarpPipePos, level);
                surfaceWarpPipeBE.setDestinationPos(caveWarpPipePos, level);
            }
            return true;
        }

        return false;
    }

    private BlockState getWarpPipeState(RandomSource randomSource) {
        if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.RED_WARP_PIPE, Direction.UP, false);
        } else if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.YELLOW_WARP_PIPE, Direction.UP, false);
        } else if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.BLUE_WARP_PIPE, Direction.UP, false);
        }
        return WarpPipeFeature.createPipeState(ModBlocks.GREEN_WARP_PIPE, Direction.UP, false);
    }

    private BlockState getMatchingPipeBody(BlockState blockState) {
        Block block = ModBlocks.GREEN_PIPE_BODY.get();
        if (blockState.is(ModBlocks.RED_WARP_PIPE.get()))
            block = ModBlocks.RED_PIPE_BODY.get();
        else if (blockState.is(ModBlocks.YELLOW_WARP_PIPE.get()))
            block = ModBlocks.YELLOW_PIPE_BODY.get();
        else if (blockState.is(ModBlocks.BLUE_WARP_PIPE.get()))
            block = ModBlocks.BLUE_PIPE_BODY.get();
        return block.defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP);
    }
}
