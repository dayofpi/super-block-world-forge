package com.dayofpi.super_block_world.datagen.server.tag;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.util.ModTags;
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
        tag(ModTags.Blocks.AMANITA_LOGS).add(ModBlocks.AMANITA_LOG.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.VANILLATE.get(), ModBlocks.VANILLATE_STAIRS.get(), ModBlocks.VANILLATE_SLAB.get(), ModBlocks.VANILLATE_WALL.get(), ModBlocks.TOPPED_VANILLATE.get(), ModBlocks.VANILLATE_CRUMBLE.get(), ModBlocks.VANILLATE_BRICKS.get(), ModBlocks.VANILLATE_BRICK_STAIRS.get(), ModBlocks.VANILLATE_BRICK_SLAB.get(), ModBlocks.VANILLATE_BRICK_WALL.get(), ModBlocks.VANILLATE_TILES.get(), ModBlocks.VANILLATE_TILE_STAIRS.get(), ModBlocks.VANILLATE_TILE_SLAB.get(), ModBlocks.VANILLATE_TILE_WALL.get(), ModBlocks.TOADSTONE.get(), ModBlocks.TOADSTONE_BRICKS.get(), ModBlocks.SMOOTH_TOADSTONE.get(), ModBlocks.SMOOTH_TOADSTONE_STAIRS.get(), ModBlocks.SMOOTH_TOADSTONE_SLAB.get(), ModBlocks.HARDSTONE.get(), ModBlocks.HARDSTONE_BRICKS.get(), ModBlocks.SMOOTH_HARDSTONE.get(), ModBlocks.SMOOTH_HARDSTONE_STAIRS.get(), ModBlocks.SMOOTH_HARDSTONE_SLAB.get(), ModBlocks.RAINBOW_TILES.get(), ModBlocks.RAINBOW_TILE_STAIRS.get(), ModBlocks.RAINBOW_TILE_SLAB.get(), ModBlocks.RAINBOW_TILE_WALL.get(), ModBlocks.STAR_CLUSTER.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get(), ModBlocks.TOADSTOOL_PATH.get());
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.AMANITA_LOGS);
        tag(BlockTags.PLANKS).add(ModBlocks.AMANITA_PLANKS.get());
        tag(BlockTags.LEAVES).add(ModBlocks.AMANITA_LEAVES.get(), ModBlocks.FRUITING_AMANITA_LEAVES.get());
        tag(BlockTags.DIRT).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        tag(BlockTags.FLOWERS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
        tag(BlockTags.WALLS).add(ModBlocks.VANILLATE_WALL.get(), ModBlocks.VANILLATE_BRICK_WALL.get(), ModBlocks.VANILLATE_TILE_WALL.get(), ModBlocks.RAINBOW_TILE_WALL.get());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(ModBlocks.VANILLATE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
