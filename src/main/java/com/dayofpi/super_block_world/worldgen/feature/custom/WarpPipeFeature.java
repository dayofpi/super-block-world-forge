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
import net.minecraftforge.registries.RegistryObject;

public class WarpPipeFeature extends Feature<NoneFeatureConfiguration> {
    public WarpPipeFeature(Codec<NoneFeatureConfiguration> pCodec) {
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
            if (random.nextBoolean() && level.getBlockState(caveWarpPipePos.above(2)).isAir()) {
                level.setBlock(caveWarpPipePos, pipeBodyState, 2);
                caveWarpPipePos = caveWarpPipePos.above();
            }
            level.setBlock(caveWarpPipePos, warpPipeState, 2);

            if (random.nextBoolean() && level.getBlockState(surfaceWarpPipePos.above(2)).isAir()) {
                level.setBlock(surfaceWarpPipePos, pipeBodyState, 2);
                surfaceWarpPipePos = surfaceWarpPipePos.above();
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

    public static BlockState createPipeState(RegistryObject<Block> block, boolean waterlogged) {
        return block.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, waterlogged);
    }

    private BlockState getWarpPipeState(RandomSource randomSource) {
        if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.RED_WARP_PIPE, false);
        } else if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.YELLOW_WARP_PIPE, false);
        } else if (randomSource.nextInt(4) == 0) {
           return WarpPipeFeature.createPipeState(ModBlocks.BLUE_WARP_PIPE, false);
        }
        return WarpPipeFeature.createPipeState(ModBlocks.GREEN_WARP_PIPE, false);
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
