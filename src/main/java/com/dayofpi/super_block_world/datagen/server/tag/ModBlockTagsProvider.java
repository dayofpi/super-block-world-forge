package com.dayofpi.super_block_world.datagen.server.tag;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
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
        tag(Tags.Blocks.ORES).add(ModBlocks.BRONZE_ORE.get());
        tag(ModTags.Blocks.FLAGS).add(ModBlocks.WHITE_FLAG.get(), ModBlocks.LIGHT_GRAY_FLAG.get(), ModBlocks.GRAY_FLAG.get(), ModBlocks.BLACK_FLAG.get(), ModBlocks.BROWN_FLAG.get(), ModBlocks.RED_FLAG.get(), ModBlocks.ORANGE_FLAG.get(), ModBlocks.YELLOW_FLAG.get(), ModBlocks.LIME_FLAG.get(), ModBlocks.GREEN_FLAG.get(), ModBlocks.CYAN_FLAG.get(), ModBlocks.LIGHT_BLUE_FLAG.get(), ModBlocks.BLUE_FLAG.get(), ModBlocks.PURPLE_FLAG.get(), ModBlocks.MAGENTA_FLAG.get(), ModBlocks.PINK_FLAG.get(), ModBlocks.RAINBOW_FLAG.get());
        tag(ModTags.Blocks.WARP_PIPES).add(ModBlocks.WHITE_WARP_PIPE.get(), ModBlocks.LIGHT_GRAY_WARP_PIPE.get(), ModBlocks.GRAY_WARP_PIPE.get(), ModBlocks.BLACK_WARP_PIPE.get(), ModBlocks.BROWN_WARP_PIPE.get(), ModBlocks.RED_WARP_PIPE.get(), ModBlocks.ORANGE_WARP_PIPE.get(), ModBlocks.YELLOW_WARP_PIPE.get(), ModBlocks.LIME_WARP_PIPE.get(), ModBlocks.GREEN_WARP_PIPE.get(), ModBlocks.CYAN_WARP_PIPE.get(), ModBlocks.LIGHT_BLUE_WARP_PIPE.get(), ModBlocks.BLUE_WARP_PIPE.get(), ModBlocks.PURPLE_WARP_PIPE.get(), ModBlocks.MAGENTA_WARP_PIPE.get(), ModBlocks.PINK_WARP_PIPE.get());
        tag(ModTags.Blocks.PIPE_BODIES).add(ModBlocks.WHITE_PIPE_BODY.get(), ModBlocks.LIGHT_GRAY_PIPE_BODY.get(), ModBlocks.GRAY_PIPE_BODY.get(), ModBlocks.BLACK_PIPE_BODY.get(), ModBlocks.BROWN_PIPE_BODY.get(), ModBlocks.RED_PIPE_BODY.get(), ModBlocks.ORANGE_PIPE_BODY.get(), ModBlocks.YELLOW_PIPE_BODY.get(), ModBlocks.LIME_PIPE_BODY.get(), ModBlocks.GREEN_PIPE_BODY.get(), ModBlocks.CYAN_PIPE_BODY.get(), ModBlocks.LIGHT_BLUE_PIPE_BODY.get(), ModBlocks.BLUE_PIPE_BODY.get(), ModBlocks.PURPLE_PIPE_BODY.get(), ModBlocks.MAGENTA_PIPE_BODY.get(), ModBlocks.PINK_PIPE_BODY.get());
        tag(ModTags.Blocks.BRONZE_BLOCKS).add(ModBlocks.BRONZE_BLOCK.get(), ModBlocks.WHITE_BRONZE.get(), ModBlocks.LIGHT_GRAY_BRONZE.get(), ModBlocks.GRAY_BRONZE.get(), ModBlocks.BLACK_BRONZE.get(), ModBlocks.BROWN_BRONZE.get(), ModBlocks.RED_BRONZE.get(), ModBlocks.ORANGE_BRONZE.get(), ModBlocks.YELLOW_BRONZE.get(), ModBlocks.LIME_BRONZE.get(), ModBlocks.GREEN_BRONZE.get(), ModBlocks.CYAN_BRONZE.get(), ModBlocks.LIGHT_BLUE_BRONZE.get(), ModBlocks.BLUE_BRONZE.get(), ModBlocks.PURPLE_BRONZE.get(), ModBlocks.MAGENTA_BRONZE.get(), ModBlocks.PINK_BRONZE.get());
        tag(ModTags.Blocks.AMANITA_LOGS).add(ModBlocks.AMANITA_LOG.get(), ModBlocks.AMANITA_WOOD.get(), ModBlocks.STRIPPED_AMANITA_LOG.get(), ModBlocks.STRIPPED_AMANITA_WOOD.get());
        tag(ModTags.Blocks.VANILLATE_TOPPING_REPLACEABLE).add(ModBlocks.VANILLATE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(ModTags.Blocks.FLAGS).addTag(ModTags.Blocks.WARP_PIPES).addTag(ModTags.Blocks.PIPE_BODIES).addTag(ModTags.Blocks.BRONZE_BLOCKS).add(ModBlocks.BRONZE_ORE.get(), ModBlocks.RAW_BRONZE_BLOCK.get(), ModBlocks.BRONZE_STAIRS.get(), ModBlocks.BRONZE_SLAB.get(), ModBlocks.VANILLATE.get(), ModBlocks.VANILLATE_STAIRS.get(), ModBlocks.VANILLATE_SLAB.get(), ModBlocks.TOPPED_VANILLATE.get(), ModBlocks.VANILLATE_CRUMBLE.get(), ModBlocks.VANILLATE_BRICKS.get(), ModBlocks.VANILLATE_BRICK_STAIRS.get(), ModBlocks.VANILLATE_BRICK_SLAB.get(), ModBlocks.VANILLATE_TILES.get(), ModBlocks.VANILLATE_TILE_STAIRS.get(), ModBlocks.VANILLATE_TILE_SLAB.get(), ModBlocks.TOADSTONE.get(), ModBlocks.TOADSTONE_STAIRS.get(), ModBlocks.TOADSTONE_SLAB.get(), ModBlocks.TOADSTONE_BRICKS.get(), ModBlocks.TOADSTONE_BRICK_STAIRS.get(), ModBlocks.TOADSTONE_BRICK_SLAB.get(), ModBlocks.SMOOTH_TOADSTONE.get(), ModBlocks.SMOOTH_TOADSTONE_STAIRS.get(), ModBlocks.SMOOTH_TOADSTONE_SLAB.get(), ModBlocks.HARDSTONE.get(), ModBlocks.HARDSTONE_STAIRS.get(), ModBlocks.HARDSTONE_SLAB.get(), ModBlocks.CHISELED_HARDSTONE.get(), ModBlocks.HARDSTONE_BRICKS.get(), ModBlocks.CRACKED_HARDSTONE_BRICKS.get(), ModBlocks.HARDSTONE_BRICK_STAIRS.get(), ModBlocks.HARDSTONE_BRICK_SLAB.get(), ModBlocks.SMOOTH_HARDSTONE.get(), ModBlocks.SMOOTH_HARDSTONE_STAIRS.get(), ModBlocks.SMOOTH_HARDSTONE_SLAB.get(), ModBlocks.MOON_ROCK.get(), ModBlocks.RAINBOW_TILES.get(), ModBlocks.RAINBOW_TILE_STAIRS.get(), ModBlocks.RAINBOW_TILE_SLAB.get(), ModBlocks.STAR_CLUSTER.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get(), ModBlocks.TOADSTOOL_PATH.get());
        tag(BlockTags.NEEDS_STONE_TOOL).addTag(ModTags.Blocks.BRONZE_BLOCKS).add(ModBlocks.BRONZE_ORE.get(), ModBlocks.RAW_BRONZE_BLOCK.get(), ModBlocks.BRONZE_STAIRS.get(), ModBlocks.BRONZE_SLAB.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MOON_ROCK.get());
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.AMANITA_LOGS);
        tag(BlockTags.PLANKS).add(ModBlocks.AMANITA_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.AMANITA_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.AMANITA_SLAB.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.AMANITA_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.AMANITA_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.AMANITA_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.AMANITA_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.AMANITA_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.AMANITA_BUTTON.get());
        tag(BlockTags.STANDING_SIGNS).add(ModBlocks.AMANITA_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(ModBlocks.AMANITA_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.AMANITA_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.AMANITA_WALL_HANGING_SIGN.get());
        tag(BlockTags.LEAVES).add(ModBlocks.AMANITA_LEAVES.get(), ModBlocks.FRUITING_AMANITA_LEAVES.get());
        tag(BlockTags.DIRT).add(ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        tag(BlockTags.FLOWERS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
        tag(BlockTags.WALLS).add(ModBlocks.VANILLATE_WALL.get(), ModBlocks.VANILLATE_BRICK_WALL.get(), ModBlocks.VANILLATE_TILE_WALL.get(), ModBlocks.TOADSTONE_WALL.get(), ModBlocks.TOADSTONE_BRICK_WALL.get(), ModBlocks.HARDSTONE_WALL.get(), ModBlocks.HARDSTONE_BRICK_WALL.get(), ModBlocks.RAINBOW_TILE_WALL.get());
        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.WHITE_FLOWERBED.get(), ModBlocks.YELLOW_FLOWERBED.get());
        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(ModBlocks.VANILLATE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
