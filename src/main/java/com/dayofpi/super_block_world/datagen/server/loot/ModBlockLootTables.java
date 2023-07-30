package com.dayofpi.super_block_world.datagen.server.loot;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.VANILLATE_CRUMBLE.get());

        add(ModBlocks.VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
