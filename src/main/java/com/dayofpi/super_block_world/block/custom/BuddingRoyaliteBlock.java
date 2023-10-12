package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingRoyaliteBlock extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingRoyaliteBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = null;
            if (BuddingAmethystBlock.canClusterGrowAtState(blockstate)) {
                block = ModBlocks.SMALL_ROYALITE_BUD.get();
            } else if (blockstate.is(ModBlocks.SMALL_ROYALITE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_ROYALITE_BUD.get();
            } else if (blockstate.is(ModBlocks.MEDIUM_ROYALITE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_ROYALITE_BUD.get();
            } else if (blockstate.is(ModBlocks.LARGE_ROYALITE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.ROYALITE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }
}
