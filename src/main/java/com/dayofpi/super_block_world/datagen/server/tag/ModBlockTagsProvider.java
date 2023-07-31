package com.dayofpi.super_block_world.datagen.server.tag;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.VANILLATE.get(), ModBlocks.TOPPED_VANILLATE.get(), ModBlocks.VANILLATE_CRUMBLE.get(), ModBlocks.VANILLATE_BRICKS.get(), ModBlocks.VANILLATE_TILES.get(), ModBlocks.TOADSTONE.get(), ModBlocks.TOADSTONE_BRICKS.get(), ModBlocks.SMOOTH_TOADSTONE.get(), ModBlocks.HARDSTONE.get(), ModBlocks.HARDSTONE_BRICKS.get(), ModBlocks.SMOOTH_HARDSTONE.get(), ModBlocks.STAR_CLUSTER.get());
        tag(BlockTags.FLOWERS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
