package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.VANILLATE.get(), cubeAll(ModBlocks.VANILLATE.get()));
        simpleBlockWithItem(ModBlocks.VANILLATE_CRUMBLE.get(), cubeAll(ModBlocks.VANILLATE_CRUMBLE.get()));
    }
}
