package com.dayofpi.super_block_world.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PipeBodyBlock extends AbstractPipe {
    private static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    private static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    private static final BooleanProperty EAST = BlockStateProperties.EAST;
    private static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    private static final BooleanProperty WEST = BlockStateProperties.WEST;
    private static final BooleanProperty UP = BlockStateProperties.UP;

    private static final VoxelShape Y_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    private static final VoxelShape X_SHAPE = Block.box(0.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D);
    private static final VoxelShape Z_SHAPE = Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 16.0D);

    public PipeBodyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(FACING) == Direction.UP || blockState.getValue(FACING) == Direction.DOWN) {
            return Y_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.WEST || blockState.getValue(FACING) == Direction.EAST) {
            return X_SHAPE;
        } else if (blockState.getValue(FACING) == Direction.NORTH || blockState.getValue(FACING) == Direction.SOUTH) {
            return Z_SHAPE;
        } else return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(FACING) == Direction.UP || blockState.getValue(FACING) == Direction.DOWN) {
            return this.upDownPredicates(blockState, direction, blockState2);
        } else if (blockState.getValue(FACING) == Direction.NORTH || blockState.getValue(FACING) == Direction.SOUTH) {
            return this.northSouthPredicates(blockState, direction, blockState2);
        } else if (blockState.getValue(FACING) == Direction.EAST || blockState.getValue(FACING) == Direction.WEST) {
            return this.eastWestPredicates(blockState, direction, blockState2);
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    private BlockState northSouthPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = neighbor.getBlock() instanceof AbstractPipe;
        boolean upDown = neighbor.is(this) && (neighbor.getValue(FACING) == Direction.UP || neighbor.getValue(FACING) == Direction.DOWN);
        boolean eastWest = isPipe && (neighbor.getValue(FACING) == Direction.EAST || neighbor.getValue(FACING) == Direction.WEST);

        if (upDown && direction == Direction.UP) {
            return state.setValue(UP, true);
        } else if (!upDown && direction == Direction.UP) {
            return state.setValue(UP, false);
        }
        if (upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, true);
        } else if (!upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, false);
        }

        if (eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, true);
        } else if (!eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, false);
        }
        if (eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, true);
        } else if (!eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, false);
        } else return state;
    }

    private BlockState upDownPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = neighbor.getBlock() instanceof AbstractPipe;
        boolean northSouth = isPipe && (neighbor.getValue(FACING) == Direction.NORTH || neighbor.getValue(FACING) == Direction.SOUTH);
        boolean eastWest = isPipe && (neighbor.getValue(FACING) == Direction.EAST || neighbor.getValue(FACING) == Direction.WEST);

        if (northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, true);
        } else if (!northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, false);
        }
        if (northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, true);
        } else if (!northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, false);
        }

        if (eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, true);
        } else if (!eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, false);
        }
        if (eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, true);
        } else if (!eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, false);
        } else return state;
    }

    private BlockState eastWestPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = neighbor.getBlock() instanceof AbstractPipe;
        boolean northSouth = isPipe && (neighbor.getValue(FACING) == Direction.NORTH || neighbor.getValue(FACING) == Direction.SOUTH);
        boolean upDown = neighbor.is(this) && (neighbor.getValue(FACING) == Direction.UP || neighbor.getValue(FACING) == Direction.DOWN);

        if (upDown && direction == Direction.UP) {
            return state.setValue(UP, true);
        } else if (!upDown && direction == Direction.UP) {
            return state.setValue(UP, false);
        }
        if (upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, true);
        } else if (!upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, false);
        }

        if (northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, true);
        } else if (!northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, false);
        }
        if (northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, true);
        } else if (!northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, false);
        } else return state;

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }
}
