package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.block_entities.ModBrushableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ModBrushableBlock extends BrushableBlock {
    public ModBrushableBlock(Block block, Properties properties, SoundEvent brushingSoundEvent, SoundEvent brushingCompleteSoundEvent) {
        super(block, properties, brushingSoundEvent, brushingCompleteSoundEvent);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModBrushableBlockEntity(pPos, pState);
    }
}
