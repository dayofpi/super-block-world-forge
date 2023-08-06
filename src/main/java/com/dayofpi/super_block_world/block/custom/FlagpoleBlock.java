package com.dayofpi.super_block_world.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FlagpoleBlock extends Block {
    protected static final VoxelShape POLE_SHAPE = Block.box(7.0, 0.0, 7.0, 9.0, 16.0, 9.0);

    public FlagpoleBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return POLE_SHAPE;
    }
}
