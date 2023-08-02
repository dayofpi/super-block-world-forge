package com.dayofpi.super_block_world.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbstractPipe extends DirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape UP_SHAPE = Shapes.or(Block.box(1.0D, 0.0D, 1.0D, 15.0D, 13.0D, 15.0D), Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D), Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D), Block.box(13.0D, 13.0D, 3.0D, 16.0D, 16.0D, 13.0D), Block.box(0.0D, 13.0D, 3.0D, 3.0D, 16.0D, 13.0D));
    private static final VoxelShape DOWN_SHAPE = Shapes.or(Block.box(1.0D, 3.0D, 1.0D, 15.0D, 16.0D, 15.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D), Block.box(0.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D), Block.box(13.0D, 0.0D, 3.0D, 16.0D, 3.0D, 13.0D), Block.box(0.0D, 0.0D, 3.0D, 3.0D, 3.0D, 13.0D));
    private static final VoxelShape NORTH_SHAPE = Shapes.or(Block.box(1.0D, 1.0D, 3.0D, 15.0D, 15.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D), Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 3.0D), Block.box(0.0D, 3.0D, 0.0D, 3.0D, 13.0D, 3.0D), Block.box(13.0D, 3.0D, 0.0D, 16.0D, 13.0D, 3.0D));
    private static final VoxelShape SOUTH_SHAPE = Shapes.or(Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 13.0D), Block.box(0.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D), Block.box(0.0D, 13.0D, 13.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 3.0D, 13.0D, 3.0D, 13.0D, 16.0D), Block.box(13.0D, 3.0D, 13.0D, 16.0D, 13.0D, 16.0D));
    private static final VoxelShape EAST_SHAPE = Shapes.or(Block.box(0.0D, 1.0D, 1.0D, 13.0D, 15.0D, 15.0D), Block.box(13.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), Block.box(13.0D, 3.0D, 13.0D, 16.0D, 13.0D, 16.0D), Block.box(13.0D, 3.0D, 0.0D, 16.0D, 13.0D, 3.0D));
    private static final VoxelShape WEST_SHAPE = Shapes.or(Block.box(3.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D), Block.box(0.0D, 13.0D, 0.0D, 3.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 16.0D), Block.box(0.0D, 3.0D, 13.0D, 3.0D, 13.0D, 16.0D), Block.box(0.0D, 3.0D, 0.0D, 3.0D, 13.0D, 3.0D));

    public AbstractPipe(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(FACING) == Direction.UP) {
            return UP_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.DOWN) {
            return DOWN_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.NORTH) {
            return NORTH_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.EAST) {
            return EAST_SHAPE;
        } else
            return WEST_SHAPE;
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        if (blockState.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(blockState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction direction = blockPlaceContext.getClickedFace();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        boolean isInFluid = fluidState.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, isInFluid);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}
