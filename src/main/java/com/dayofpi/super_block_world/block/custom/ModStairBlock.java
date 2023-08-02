package com.dayofpi.super_block_world.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModStairBlock extends StairBlock {
    public ModStairBlock(Supplier<Block> blockSupplier) {
        super(() -> blockSupplier.get().defaultBlockState(), BlockBehaviour.Properties.copy(blockSupplier.get()));
    }
}
