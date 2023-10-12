package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrampolineBlock extends FallingBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty SQUASHED = BooleanProperty.create("squash");
    protected static final VoxelShape SQUASHED_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public TrampolineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false).setValue(SQUASHED, false));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(SQUASHED) ? SQUASHED_SHAPE : Shapes.block();
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        entity.causeFallDamage(f, 0.0f, level.damageSources().fall());
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter blockGetter, Entity entity) {
        BlockState blockState = entity.getBlockStateOn();
        BlockPos blockPos = entity.getOnPos();
        boolean squashed = blockGetter.getBlockState(blockPos).getValue(SQUASHED);

        if (squashed) {
            if (!entity.isSteppingCarefully()) {
                entity.level().setBlockAndUpdate(blockPos, Block.pushEntitiesUp(blockState, blockState.setValue(SQUASHED, false), entity.level(), blockPos));
                entity.level().gameEvent(null, GameEvent.BLOCK_CHANGE, entity.blockPosition());
                this.bounce(entity, 1.2);
                RandomSource random = entity.level().getRandom();
                for (int i = 0; i < 6; i++) {
                    double rand = random.nextBoolean() ? 0.02 : -0.02;
                    entity.level().addParticle(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), i * rand, 0.0D, i * rand);
                }
            }
        } else {
            if (!entity.isSteppingCarefully()) {
                this.bounce(entity, 0.8);
            } else {
                entity.level().setBlockAndUpdate(blockPos, blockState.setValue(SQUASHED, true));
                entity.level().gameEvent(null, GameEvent.BLOCK_CHANGE, entity.blockPosition());
                this.playSound(entity, SoundEvents.WOOD_STEP, 1.0F);
            }
        }

    }

    private void playSound(Entity entity, SoundEvent soundEvent, float pitch) {
        Level level = entity.level();
        level.playSound(null, entity.blockPosition(), soundEvent, SoundSource.BLOCKS, 1.0F, pitch);
    }

    protected void bounce(Entity entity, double strength) {
        entity.setDeltaMovement(entity.getDeltaMovement().x, entity instanceof LivingEntity ? strength : strength - 0.2, entity.getDeltaMovement().z);
        this.playSound(entity, ModSoundEvents.TRAMPOLINE_RELEASE.get(), (float) strength + 0.2F);
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
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        boolean isInFluid = fluidState.getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, isInFluid);
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
        builder.add(WATERLOGGED, SQUASHED);
    }
}
