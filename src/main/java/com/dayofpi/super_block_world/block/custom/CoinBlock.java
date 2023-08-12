package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.block_entities.ItemDisplayBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CoinBlock extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 12.0D, 12.0D);
    private final SoundEvent soundEvent;

    public CoinBlock(SoundEvent soundEvent, Properties properties) {
        super(properties);
        this.soundEvent = soundEvent;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof Player) {
            if (!((Player) pEntity).getAbilities().instabuild)
                ((Player) pEntity).addItem(new ItemStack(this.asItem()));
            pLevel.playSound(null, pPos, soundEvent, SoundSource.BLOCKS, 0.7F, 1.0F);
            pLevel.removeBlock(pPos, false);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ItemDisplayBlockEntity(pPos, pState);
    }
}
