package com.dayofpi.super_block_world.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class RedGrassBlock extends ToadstoolSproutsBlock {
    public RedGrassBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.isFaceSturdy(pLevel, pPos, Direction.UP);
    }
}
