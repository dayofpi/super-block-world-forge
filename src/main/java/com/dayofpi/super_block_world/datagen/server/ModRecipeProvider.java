package com.dayofpi.super_block_world.datagen.server;

import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.util.ModTags;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        smeltingResultFromBase(pWriter, ModItems.VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get());
        smeltingResultFromBase(pWriter, ModItems.TOPPED_VANILLATE.get(), ModItems.VANILLATE.get());
        smeltingResultFromBase(pWriter, ModItems.TOADSTONE.get(), ModItems.TOADSTOOL_SOIL.get());
        smeltingResultFromBase(pWriter, ModItems.SMOOTH_TOADSTONE.get(), ModItems.TOADSTONE.get());
        smeltingResultFromBase(pWriter, ModItems.CRACKED_HARDSTONE_BRICKS.get(), ModItems.HARDSTONE_BRICKS.get());
        smeltingResultFromBase(pWriter, ModItems.SMOOTH_HARDSTONE.get(), ModItems.HARDSTONE.get());
        oreSmelting(pWriter, ImmutableList.of(ModItems.BRONZE_ORE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 200, "bronze_ingot");
        oreBlasting(pWriter, ImmutableList.of(ModItems.BRONZE_ORE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 100, "bronze_ingot");
        oreSmelting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 200, "bronze_ingot");
        oreBlasting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 100, "bronze_ingot");

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.COIN.get(), RecipeCategory.MISC, ModItems.STAR_COIN.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_BRONZE.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BRONZE_BLOCK.get());
        nineBlockStorageRecipesRecipesWithCustomUnpacking(pWriter, RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_BLOCK.get(), "bronze_ingot_from_bronze_block", "bronze_ingot");

        woodFromLogs(pWriter, ModItems.AMANITA_WOOD.get(), ModItems.AMANITA_LOG.get());
        woodFromLogs(pWriter, ModItems.STRIPPED_AMANITA_WOOD.get(), ModItems.STRIPPED_AMANITA_LOG.get());
        woodFromLogs(pWriter, ModItems.MAYOI_WOOD.get(), ModItems.MAYOI_LOG.get());
        woodFromLogs(pWriter, ModItems.STRIPPED_MAYOI_WOOD.get(), ModItems.STRIPPED_MAYOI_LOG.get());

        planksFromLogs(pWriter, ModItems.AMANITA_PLANKS.get(), ModTags.Items.AMANITA_LOGS, 4);
        planksFromLogs(pWriter, ModItems.MAYOI_PLANKS.get(), ModTags.Items.MAYOI_LOGS, 4);

        oneToOneConversionRecipe(pWriter, Items.WHITE_DYE, ModItems.WHITE_FLOWERBED.get(), "white_dye");
        oneToOneConversionRecipe(pWriter, Items.YELLOW_DYE, ModItems.YELLOW_FLOWERBED.get(), "yellow_dye");
        oneToOneConversionRecipe(pWriter, Items.RED_DYE, ModItems.YOSHI_FRUIT.get(), "red_dye");

        paintedBronzeBlock(pWriter, ModItems.WHITE_BRONZE.get(), Items.WHITE_DYE);
        paintedBronzeBlock(pWriter, ModItems.LIGHT_GRAY_BRONZE.get(), Items.LIGHT_GRAY_DYE);
        paintedBronzeBlock(pWriter, ModItems.GRAY_BRONZE.get(), Items.GRAY_DYE);
        paintedBronzeBlock(pWriter, ModItems.BLACK_BRONZE.get(), Items.BLACK_DYE);
        paintedBronzeBlock(pWriter, ModItems.BROWN_BRONZE.get(), Items.BROWN_DYE);
        paintedBronzeBlock(pWriter, ModItems.RED_BRONZE.get(), Items.RED_DYE);
        paintedBronzeBlock(pWriter, ModItems.ORANGE_BRONZE.get(), Items.ORANGE_DYE);
        paintedBronzeBlock(pWriter, ModItems.YELLOW_BRONZE.get(), Items.YELLOW_DYE);
        paintedBronzeBlock(pWriter, ModItems.LIME_BRONZE.get(), Items.LIME_DYE);
        paintedBronzeBlock(pWriter, ModItems.GREEN_BRONZE.get(), Items.GREEN_DYE);
        paintedBronzeBlock(pWriter, ModItems.CYAN_BRONZE.get(), Items.CYAN_DYE);
        paintedBronzeBlock(pWriter, ModItems.LIGHT_BLUE_BRONZE.get(), Items.LIGHT_BLUE_DYE);
        paintedBronzeBlock(pWriter, ModItems.BLUE_BRONZE.get(), Items.BLUE_DYE);
        paintedBronzeBlock(pWriter, ModItems.PURPLE_BRONZE.get(), Items.PURPLE_DYE);
        paintedBronzeBlock(pWriter, ModItems.MAGENTA_BRONZE.get(), Items.MAGENTA_DYE);
        paintedBronzeBlock(pWriter, ModItems.PINK_BRONZE.get(), Items.PINK_DYE);

        flag(pWriter, ModItems.WHITE_FLAG.get(), Items.WHITE_WOOL);
        flag(pWriter, ModItems.LIGHT_GRAY_FLAG.get(), Items.LIGHT_GRAY_WOOL);
        flag(pWriter, ModItems.GRAY_FLAG.get(), Items.GRAY_WOOL);
        flag(pWriter, ModItems.BLACK_FLAG.get(), Items.BLACK_WOOL);
        flag(pWriter, ModItems.BROWN_FLAG.get(), Items.BROWN_WOOL);
        flag(pWriter, ModItems.RED_FLAG.get(), Items.RED_WOOL);
        flag(pWriter, ModItems.ORANGE_FLAG.get(), Items.ORANGE_WOOL);
        flag(pWriter, ModItems.YELLOW_FLAG.get(), Items.YELLOW_WOOL);
        flag(pWriter, ModItems.LIME_FLAG.get(), Items.LIME_WOOL);
        flag(pWriter, ModItems.GREEN_FLAG.get(), Items.GREEN_WOOL);
        flag(pWriter, ModItems.CYAN_FLAG.get(), Items.CYAN_WOOL);
        flag(pWriter, ModItems.LIGHT_BLUE_FLAG.get(), Items.LIGHT_BLUE_WOOL);
        flag(pWriter, ModItems.BLUE_FLAG.get(), Items.BLUE_WOOL);
        flag(pWriter, ModItems.PURPLE_FLAG.get(), Items.PURPLE_WOOL);
        flag(pWriter, ModItems.MAGENTA_FLAG.get(), Items.MAGENTA_WOOL);
        flag(pWriter, ModItems.PINK_FLAG.get(), Items.PINK_WOOL);

        warpPipe(pWriter, ModItems.WHITE_WARP_PIPE.get(), Items.WHITE_DYE);
        warpPipe(pWriter, ModItems.LIGHT_GRAY_WARP_PIPE.get(), Items.LIGHT_GRAY_DYE);
        warpPipe(pWriter, ModItems.GRAY_WARP_PIPE.get(), Items.GRAY_DYE);
        warpPipe(pWriter, ModItems.BLACK_WARP_PIPE.get(), Items.BLACK_DYE);
        warpPipe(pWriter, ModItems.BROWN_WARP_PIPE.get(), Items.BROWN_DYE);
        warpPipe(pWriter, ModItems.RED_WARP_PIPE.get(), Items.RED_DYE);
        warpPipe(pWriter, ModItems.ORANGE_WARP_PIPE.get(), Items.ORANGE_DYE);
        warpPipe(pWriter, ModItems.YELLOW_WARP_PIPE.get(), Items.YELLOW_DYE);
        warpPipe(pWriter, ModItems.LIME_WARP_PIPE.get(), Items.LIME_DYE);
        warpPipe(pWriter, ModItems.GREEN_WARP_PIPE.get(), Items.GREEN_DYE);
        warpPipe(pWriter, ModItems.CYAN_WARP_PIPE.get(), Items.CYAN_DYE);
        warpPipe(pWriter, ModItems.LIGHT_BLUE_WARP_PIPE.get(), Items.LIGHT_BLUE_DYE);
        warpPipe(pWriter, ModItems.BLUE_WARP_PIPE.get(), Items.BLUE_DYE);
        warpPipe(pWriter, ModItems.PURPLE_WARP_PIPE.get(), Items.PURPLE_DYE);
        warpPipe(pWriter, ModItems.MAGENTA_WARP_PIPE.get(), Items.MAGENTA_DYE);
        warpPipe(pWriter, ModItems.PINK_WARP_PIPE.get(), Items.PINK_DYE);

        pipeBody(pWriter, ModItems.WHITE_PIPE_BODY.get(), Items.WHITE_DYE);
        pipeBody(pWriter, ModItems.LIGHT_GRAY_PIPE_BODY.get(), Items.LIGHT_GRAY_DYE);
        pipeBody(pWriter, ModItems.GRAY_PIPE_BODY.get(), Items.GRAY_DYE);
        pipeBody(pWriter, ModItems.BLACK_PIPE_BODY.get(), Items.BLACK_DYE);
        pipeBody(pWriter, ModItems.BROWN_PIPE_BODY.get(), Items.BROWN_DYE);
        pipeBody(pWriter, ModItems.RED_PIPE_BODY.get(), Items.RED_DYE);
        pipeBody(pWriter, ModItems.ORANGE_PIPE_BODY.get(), Items.ORANGE_DYE);
        pipeBody(pWriter, ModItems.YELLOW_PIPE_BODY.get(), Items.YELLOW_DYE);
        pipeBody(pWriter, ModItems.LIME_PIPE_BODY.get(), Items.LIME_DYE);
        pipeBody(pWriter, ModItems.GREEN_PIPE_BODY.get(), Items.GREEN_DYE);
        pipeBody(pWriter, ModItems.CYAN_PIPE_BODY.get(), Items.CYAN_DYE);
        pipeBody(pWriter, ModItems.LIGHT_BLUE_PIPE_BODY.get(), Items.LIGHT_BLUE_DYE);
        pipeBody(pWriter, ModItems.BLUE_PIPE_BODY.get(), Items.BLUE_DYE);
        pipeBody(pWriter, ModItems.PURPLE_PIPE_BODY.get(), Items.PURPLE_DYE);
        pipeBody(pWriter, ModItems.MAGENTA_PIPE_BODY.get(), Items.MAGENTA_DYE);
        pipeBody(pWriter, ModItems.PINK_PIPE_BODY.get(), Items.PINK_DYE);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_STAIRS.get(), ModItems.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_SLAB.get(), ModItems.BRONZE_BLOCK.get(), 2);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICKS.get(), ModItems.VANILLATE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILES.get(), ModItems.VANILLATE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_STAIRS.get(), ModItems.VANILLATE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_SLAB.get(), ModItems.VANILLATE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.VANILLATE_WALL.get(), ModItems.VANILLATE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICK_STAIRS.get(), ModItems.VANILLATE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICK_SLAB.get(), ModItems.VANILLATE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.VANILLATE_BRICK_WALL.get(), ModItems.VANILLATE.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILES.get(), ModItems.VANILLATE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICK_STAIRS.get(), ModItems.VANILLATE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICK_SLAB.get(), ModItems.VANILLATE_BRICKS.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.VANILLATE_BRICK_WALL.get(), ModItems.VANILLATE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILE_STAIRS.get(), ModItems.VANILLATE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILE_SLAB.get(), ModItems.VANILLATE_BRICKS.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.VANILLATE_TILE_WALL.get(), ModItems.VANILLATE_BRICKS.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILE_STAIRS.get(), ModItems.VANILLATE_TILES.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILE_SLAB.get(), ModItems.VANILLATE_TILES.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.VANILLATE_TILE_WALL.get(), ModItems.VANILLATE_TILES.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICKS.get(), ModItems.TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_TOADSTONE_BRICKS.get(), ModItems.TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_STAIRS.get(), ModItems.TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_SLAB.get(), ModItems.TOADSTONE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_WALL.get(), ModItems.TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_STAIRS.get(), ModItems.TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_SLAB.get(), ModItems.TOADSTONE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_WALL.get(), ModItems.TOADSTONE.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_TOADSTONE_BRICKS.get(), ModItems.TOADSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_STAIRS.get(), ModItems.TOADSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_SLAB.get(), ModItems.TOADSTONE_BRICKS.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICK_WALL.get(), ModItems.TOADSTONE_BRICKS.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_TOADSTONE_STAIRS.get(), ModItems.SMOOTH_TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_TOADSTONE_SLAB.get(), ModItems.SMOOTH_TOADSTONE.get(), 2);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICKS.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_HARDSTONE_BRICKS.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_HARDSTONE.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_PILLAR.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_STAIRS.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_SLAB.get(), ModItems.HARDSTONE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_WALL.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_STAIRS.get(), ModItems.HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_SLAB.get(), ModItems.HARDSTONE.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_WALL.get(), ModItems.HARDSTONE.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_HARDSTONE_BRICKS.get(), ModItems.HARDSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_STAIRS.get(), ModItems.HARDSTONE_BRICKS.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_SLAB.get(), ModItems.HARDSTONE_BRICKS.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICK_WALL.get(), ModItems.HARDSTONE_BRICKS.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_HARDSTONE_STAIRS.get(), ModItems.SMOOTH_HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_HARDSTONE_SLAB.get(), ModItems.SMOOTH_HARDSTONE.get(), 2);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILE_STAIRS.get(), ModItems.RAINBOW_TILES.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILE_SLAB.get(), ModItems.RAINBOW_TILES.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.RAINBOW_TILE_WALL.get(), ModItems.RAINBOW_TILES.get());

        chiseled(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_HARDSTONE.get(), ModItems.HARDSTONE_SLAB.get());
        chiseled(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_TOADSTONE_BRICKS.get(), ModItems.TOADSTONE_BRICK_SLAB.get());
        chiseled(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_HARDSTONE_BRICKS.get(), ModItems.HARDSTONE_BRICK_SLAB.get());

        stairs(pWriter, ModItems.BRONZE_STAIRS.get(), ModItems.BRONZE_BLOCK.get());
        stairs(pWriter, ModItems.VANILLATE_STAIRS.get(), ModItems.VANILLATE.get());
        stairs(pWriter, ModItems.VANILLATE_BRICK_STAIRS.get(), ModItems.VANILLATE_BRICKS.get());
        stairs(pWriter, ModItems.VANILLATE_TILE_STAIRS.get(), ModItems.VANILLATE_TILES.get());
        stairs(pWriter, ModItems.TOADSTONE_STAIRS.get(), ModItems.TOADSTONE.get());
        stairs(pWriter, ModItems.TOADSTONE_BRICK_STAIRS.get(), ModItems.TOADSTONE_BRICKS.get());
        stairs(pWriter, ModItems.SMOOTH_TOADSTONE_STAIRS.get(), ModItems.SMOOTH_TOADSTONE.get());
        stairs(pWriter, ModItems.HARDSTONE_STAIRS.get(), ModItems.HARDSTONE.get());
        stairs(pWriter, ModItems.HARDSTONE_BRICK_STAIRS.get(), ModItems.HARDSTONE_BRICKS.get());
        stairs(pWriter, ModItems.SMOOTH_HARDSTONE_STAIRS.get(), ModItems.SMOOTH_HARDSTONE.get());
        stairs(pWriter, ModItems.CLOUD_STAIRS.get(), ModItems.PACKED_CLOUD.get());
        stairs(pWriter, ModItems.RAINBOW_TILE_STAIRS.get(), ModItems.RAINBOW_TILES.get());
        stairs(pWriter, ModItems.AMANITA_STAIRS.get(), ModItems.AMANITA_PLANKS.get());
        stairs(pWriter, ModItems.MAYOI_STAIRS.get(), ModItems.MAYOI_PLANKS.get());

        slab(pWriter, ModItems.BRONZE_SLAB.get(), ModItems.BRONZE_BLOCK.get());
        slab(pWriter, ModItems.VANILLATE_SLAB.get(), ModItems.VANILLATE.get());
        slab(pWriter, ModItems.VANILLATE_BRICK_SLAB.get(), ModItems.VANILLATE_BRICKS.get());
        slab(pWriter, ModItems.VANILLATE_TILE_SLAB.get(), ModItems.VANILLATE_TILES.get());
        slab(pWriter, ModItems.TOADSTONE_SLAB.get(), ModItems.TOADSTONE.get());
        slab(pWriter, ModItems.TOADSTONE_BRICK_SLAB.get(), ModItems.TOADSTONE_BRICKS.get());
        slab(pWriter, ModItems.SMOOTH_TOADSTONE_SLAB.get(), ModItems.SMOOTH_TOADSTONE.get());
        slab(pWriter, ModItems.HARDSTONE_SLAB.get(), ModItems.HARDSTONE.get());
        slab(pWriter, ModItems.HARDSTONE_BRICK_SLAB.get(), ModItems.HARDSTONE_BRICKS.get());
        slab(pWriter, ModItems.SMOOTH_HARDSTONE_SLAB.get(), ModItems.SMOOTH_HARDSTONE.get());
        slab(pWriter, ModItems.CLOUD_SLAB.get(), ModItems.PACKED_CLOUD.get());
        slab(pWriter, ModItems.RAINBOW_TILE_SLAB.get(), ModItems.RAINBOW_TILES.get());
        slab(pWriter, ModItems.AMANITA_SLAB.get(), ModItems.AMANITA_PLANKS.get());
        slab(pWriter, ModItems.MAYOI_SLAB.get(), ModItems.MAYOI_PLANKS.get());

        wall(pWriter, ModItems.VANILLATE_WALL.get(), ModItems.VANILLATE.get());
        wall(pWriter, ModItems.VANILLATE_BRICK_WALL.get(), ModItems.VANILLATE_BRICKS.get());
        wall(pWriter, ModItems.VANILLATE_TILE_WALL.get(), ModItems.VANILLATE_TILES.get());
        wall(pWriter, ModItems.TOADSTONE_WALL.get(), ModItems.TOADSTONE.get());
        wall(pWriter, ModItems.TOADSTONE_BRICK_WALL.get(), ModItems.TOADSTONE_BRICKS.get());
        wall(pWriter, ModItems.HARDSTONE_WALL.get(), ModItems.HARDSTONE.get());
        wall(pWriter, ModItems.HARDSTONE_BRICK_WALL.get(), ModItems.HARDSTONE_BRICKS.get());
        wall(pWriter, ModItems.RAINBOW_TILE_WALL.get(), ModItems.RAINBOW_TILES.get());

        fenceBuilder(ModItems.AMANITA_FENCE.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        fenceBuilder(ModItems.MAYOI_FENCE.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        fenceGateBuilder(ModItems.AMANITA_FENCE_GATE.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        fenceGateBuilder(ModItems.MAYOI_FENCE_GATE.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        doorBuilder(ModItems.AMANITA_DOOR.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        doorBuilder(ModItems.MAYOI_DOOR.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        trapdoorBuilder(ModItems.AMANITA_TRAPDOOR.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        trapdoorBuilder(ModItems.MAYOI_TRAPDOOR.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        pressurePlate(pWriter, ModItems.AMANITA_PRESSURE_PLATE.get(), ModItems.AMANITA_PLANKS.get());
        pressurePlate(pWriter, ModItems.MAYOI_PRESSURE_PLATE.get(), ModItems.MAYOI_PLANKS.get());

        buttonBuilder(ModItems.AMANITA_BUTTON.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        buttonBuilder(ModItems.MAYOI_BUTTON.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        signBuilder(ModItems.AMANITA_SIGN.get(), Ingredient.of(ModItems.AMANITA_PLANKS.get())).unlockedBy("has_amanita_planks", has(ModItems.AMANITA_PLANKS.get())).save(pWriter);
        signBuilder(ModItems.MAYOI_SIGN.get(), Ingredient.of(ModItems.MAYOI_PLANKS.get())).unlockedBy("has_mayoi_planks", has(ModItems.MAYOI_PLANKS.get())).save(pWriter);

        hangingSign(pWriter, ModItems.AMANITA_HANGING_SIGN.get(), ModItems.STRIPPED_AMANITA_LOG.get());
        hangingSign(pWriter, ModItems.MAYOI_HANGING_SIGN.get(), ModItems.STRIPPED_MAYOI_LOG.get());

        woodenBoat(pWriter, ModItems.AMANITA_BOAT.get(), ModItems.AMANITA_PLANKS.get());
        woodenBoat(pWriter, ModItems.MAYOI_BOAT.get(), ModItems.MAYOI_PLANKS.get());

        chestBoat(pWriter, ModItems.AMANITA_CHEST_BOAT.get(), ModItems.AMANITA_PLANKS.get());
        chestBoat(pWriter, ModItems.MAYOI_CHEST_BOAT.get(), ModItems.MAYOI_PLANKS.get());

        toadStool(pWriter, ModItems.BROWN_TOAD_STOOL.get(), Items.BROWN_MUSHROOM_BLOCK);
        toadStool(pWriter, ModItems.RED_TOAD_STOOL.get(), Items.RED_MUSHROOM_BLOCK);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.POWER_SHARD.get(), 5).requires(ModItems.POWER_STAR.get()).unlockedBy("has_power_star", has(ModItems.POWER_STAR.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModItems.PULL_BLOCK.get()).pattern("0X0").pattern("X0X").pattern("0X0").define('0', ModItems.BLUE_STAR_BIT.get()).define('X', Items.IRON_INGOT).unlockedBy("has_blue_star_bit", has(ModItems.BLUE_STAR_BIT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.FLAGPOLE.get(), 2).pattern("#").pattern("#").pattern("#").define('#', ModItems.BRONZE_INGOT.get()).unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTOOL_TURF.get(), 3).pattern("##").pattern("##").define('#', ModItems.TOADSTOOL_GRASS.get()).unlockedBy("has_toadstool_grass", has(ModItems.TOADSTOOL_GRASS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.COARSE_TOADSTOOL_SOIL.get(), 4).pattern("DG").pattern("GD").define('D', ModItems.TOADSTOOL_SOIL.get()).define('G', Items.GRAVEL).unlockedBy("has_material", has(ModItems.TOADSTOOL_SOIL.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE.get()).unlockedBy("has_material", has(ModItems.VANILLATE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILES.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE_BRICKS.get()).unlockedBy("has_material", has(ModItems.VANILLATE_BRICKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.TOADSTONE.get()).unlockedBy("has_material", has(ModItems.TOADSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.HARDSTONE.get()).unlockedBy("has_material", has(ModItems.HARDSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILES.get()).pattern("RY").pattern("BP").define('R', ModItems.RED_STAR_BIT.get()).define('Y', ModItems.YELLOW_STAR_BIT.get()).define('B', ModItems.BLUE_STAR_BIT.get()).define('P', ModItems.PURPLE_STAR_BIT.get()).unlockedBy("has_star_bit", has(ModTags.Items.STAR_BITS)).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_PILLAR.get(), 2).pattern("#").pattern("#").define('#', ModItems.HARDSTONE.get()).unlockedBy("has_material", has(ModItems.HARDSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.WARP_PAINTING.get()).pattern("###").pattern("#P#").pattern("###").define('#', ModItems.SUBCON_THREAD.get()).define('P', Items.PAINTING).unlockedBy("has_subcon_thread", has(ModItems.SUBCON_THREAD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WARP_LINK.get()).pattern("X#X").define('X', ModItems.YELLOW_STAR_BIT.get()).define('#', ModItems.SUBCON_THREAD.get()).unlockedBy("has_subcon_thread", has(ModItems.SUBCON_THREAD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HAMMER.get()).pattern("## ").pattern("#/#").pattern(" / ").define('#', ModItems.BRONZE_INGOT.get()).define('/', Items.STICK).unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SUPER_PICKAXE.get()).pattern("###").pattern(" / ").pattern(" / ").define('#', ModItems.POWER_SHARD.get()).define('/', Items.STICK).unlockedBy("has_power_shard", has(ModItems.POWER_SHARD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.YOSHI_COOKIE.get()).pattern("/#/").define('/', Items.WHEAT).define('#', ModItems.YOSHI_FRUIT.get()).unlockedBy("has_yoshi_fruit", has(ModItems.YOSHI_FRUIT.get())).save(pWriter);
    }

    private static void toadStool(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike toadStool, ItemLike mushroomBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, toadStool).pattern("#").pattern("/").define('#', mushroomBlock).define('/', Items.MUSHROOM_STEM).group("toad_stool").unlockedBy("has_mushroom_block", has(mushroomBlock)).save(finishedRecipeConsumer);
    }

    private static void paintedBronzeBlock(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike bronzeBlock, ItemLike dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bronzeBlock, 8).define('#', ModItems.BRONZE_BLOCK.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("painted_bronze").unlockedBy("has_bronze_block", has(ModItems.BRONZE_BLOCK.get())).save(finishedRecipeConsumer);
    }

    private static void flag(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike flag, ItemLike wool) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, flag).define('#', ModItems.BRONZE_INGOT.get()).define('W', wool).pattern("W").pattern("#").pattern("#").group("flag").unlockedBy(getHasName(wool), has(wool)).save(finishedRecipeConsumer);
    }

    private static void warpPipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike warpPipe, ItemLike dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, warpPipe).define('#', ModItems.BRONZE_INGOT.get()).define('X', Items.ENDER_PEARL).define('0', dye).pattern("#X#").pattern("#0#").group("warp_pipe").unlockedBy(getHasName(dye), has(dye)).save(finishedRecipeConsumer);
    }

    private static void pipeBody(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike pipeBody, ItemLike dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pipeBody, 2).define('#', ModItems.BRONZE_INGOT.get()).define('0', dye).pattern("# #").pattern("#0#").pattern("# #").group("pipe_body").unlockedBy(getHasName(dye), has(dye)).save(finishedRecipeConsumer);
    }

    private static void stairs(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike stairs, ItemLike material) {
        stairBuilder(stairs, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

    private static void slab(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike slab, ItemLike material) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

    private static void wall(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike wall, ItemLike material) {
        wallBuilder(RecipeCategory.DECORATIONS, wall, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }
}
