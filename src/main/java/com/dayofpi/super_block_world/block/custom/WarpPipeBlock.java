package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.block_entities.WarpPipeBlockEntity;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class WarpPipeBlock extends AbstractPipe implements EntityBlock {
    public static final BooleanProperty LINKED = BooleanProperty.create("linked");

    public WarpPipeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false).setValue(LINKED, false));
    }

    public static boolean canEnterWarpPipe(Level level, BlockPos blockPos) {
        if (!level.getBlockState(blockPos).is(ModTags.Blocks.WARP_PIPES))
            return false;
        return level.getBlockState(blockPos).getValue(LINKED) && level.getBlockState(blockPos).getValue(FACING) == Direction.UP;
    }

    public static boolean isLinkableWarpPipe(Level level, BlockPos blockPos) {
        if (!level.getBlockState(blockPos).is(ModTags.Blocks.WARP_PIPES))
            return false;
        return !level.getBlockState(blockPos).getValue(LINKED) && level.getBlockState(blockPos).getValue(FACING) == Direction.UP;
    }

    public static void warp(Player player, BlockPos blockPos, Level level) {
        player.teleportTo(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5);
        level.gameEvent(GameEvent.TELEPORT, blockPos, GameEvent.Context.of(player));
        level.broadcastEntityEvent(player, (byte) 46);
        level.playSound(null, blockPos, ModSoundEvents.WARP_PIPE_TELEPORT.get(), SoundSource.BLOCKS, 2.0F, 1.0F);
    }

    public void checkConnection(Level level, BlockPos blockPos, BlockState state) {
        if (level.getBlockEntity(blockPos) instanceof WarpPipeBlockEntity warpPipeBE) {
            if (warpPipeBE.destinPos == null || !level.getBlockState(warpPipeBE.destinPos).is(ModTags.Blocks.WARP_PIPES)) {
                level.setBlock(blockPos, state.setValue(LINKED, false), 3);
                warpPipeBE.destinPos = null;
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LINKED);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        super.onPlace(blockState, level, blockPos, blockState2, bl);
        if (blockState.getValue(FACING) == Direction.UP) {
            if (blockState.getValue(LINKED)) {
                this.checkConnection(level, blockPos, blockState);
            }
            if (blockState.getValue(WATERLOGGED)) {
                level.scheduleTick(blockPos, this, 20);
            }
        }
    }


    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (blockState.getValue(FACING) == Direction.UP && blockState.getValue(LINKED)) {
            this.checkConnection(level, blockPos, blockState);
        }
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, bl);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        BubbleColumnBlock.updateColumn(serverLevel, blockPos.above(), blockState);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (direction == Direction.UP && blockState2.is(Blocks.WATER)) {
            levelAccessor.scheduleTick(blockPos, this, 20);
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(LINKED) && blockState.getValue(FACING) == Direction.UP) {
            double d = (double)blockPos.getX() + 0.5 + (0.5 - randomSource.nextDouble());
            double e = (double)blockPos.getY() + 1.0;
            double f = (double)blockPos.getZ() + 0.5 + (0.5 - randomSource.nextDouble());
            double g = (double)randomSource.nextFloat() * 0.04;
            level.addParticle(ParticleTypes.REVERSE_PORTAL, d, e, f, 0.0, g, 0.0);
        }
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int i, int j) {
        super.triggerEvent(blockState, level, blockPos, i, j);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity != null && blockEntity.triggerEvent(i, j);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WarpPipeBlockEntity(blockPos, blockState);
    }
}
