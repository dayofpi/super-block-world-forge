package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.block_entities.FlagBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlagBlock extends FlagpoleBlock implements EntityBlock {
    public static final List<String> TRANS = List.of("Trans", "trans", "transgender", "Transgender");
    public static final List<String> BI = List.of("Bi", "bi", "bisexual", "Bisexual");
    public static final List<String> LESBIAN = List.of("Lesbian", "lesbian");

    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
    private static final VoxelShape TOP_SHAPE = Block.box(6.0, 12.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape SHAPE = Shapes.or(POLE_SHAPE, TOP_SHAPE);
    private final boolean rainbow;
    private final DyeColor color;

    public FlagBlock(DyeColor color, Properties properties) {
        super(properties);
        this.rainbow = false;
        this.color = color;
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROTATION, 0));
    }

    public FlagBlock(Properties properties) {
        super(properties);
        this.rainbow = true;
        this.color = DyeColor.WHITE;
        this.registerDefaultState(this.getStateDefinition().any().setValue(ROTATION, 0));
    }

    public boolean isRainbow() {
        return this.rainbow;
    }

    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        BlockEntity blockEntity;
        if (itemStack.hasCustomHoverName() && (blockEntity = level.getBlockEntity(blockPos)) instanceof FlagBlockEntity) {
            ((FlagBlockEntity) blockEntity).setCustomName(itemStack.getHoverName());
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        blockState = blockState.cycle(ROTATION);
        level.setBlockAndUpdate(blockPos, blockState);
        level.updateNeighbourForOutputSignal(blockPos, this);
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return blockState.getValue(ROTATION);
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(ROTATION, rotation.rotate(blockState.getValue(ROTATION), 16));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.setValue(ROTATION, mirror.mirror(blockState.getValue(ROTATION), 16));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FlagBlockEntity(blockPos, blockState, this.getColor(), this.isRainbow());
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int i, int j) {
        super.triggerEvent(blockState, level, blockPos, i, j);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity != null && blockEntity.triggerEvent(i, j);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }
}
