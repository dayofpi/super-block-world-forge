package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModBrushableBlockEntity extends BrushableBlockEntity {
    public ModBrushableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntityTypes.BRUSHABLE_BLOCK.get();
    }
}
