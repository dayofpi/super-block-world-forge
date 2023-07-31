package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ItemDisplayBlockEntity extends BlockEntity {
    public ItemDisplayBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.ITEM_DISPLAY.get(), pPos, pBlockState);
    }
}
