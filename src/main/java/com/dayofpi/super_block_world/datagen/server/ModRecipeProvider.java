package com.dayofpi.super_block_world.datagen.server;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.util.ModTags;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
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
        smeltingResultFromBase(pWriter, ModItems.SMOOTH_HARDSTONE.get(), ModItems.HARDSTONE.get());
        oreSmelting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 200, "bronze_ingot");
        oreBlasting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 100, "bronze_ingot");

        planksFromLogs(pWriter, ModBlocks.AMANITA_PLANKS.get(), ModTags.Items.AMANITA_LOGS, 4);

        woodenBoat(pWriter, ModItems.AMANITA_BOAT.get(), ModItems.AMANITA_PLANKS.get());
        chestBoat(pWriter, ModItems.AMANITA_CHEST_BOAT.get(), ModItems.AMANITA_PLANKS.get());

        oneToOneConversionRecipe(pWriter, Items.WHITE_DYE, ModItems.WHITE_FLOWERBED.get(), "white_dye");
        oneToOneConversionRecipe(pWriter, Items.YELLOW_DYE, ModItems.YELLOW_FLOWERBED.get(), "yellow_dye");
        oneToOneConversionRecipe(pWriter, Items.RED_DYE, ModItems.YOSHI_FRUIT.get(), "red_dye");

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

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_TOADSTONE_STAIRS.get(), ModItems.SMOOTH_TOADSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_TOADSTONE_SLAB.get(), ModItems.SMOOTH_TOADSTONE.get(), 2);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICKS.get(), ModItems.HARDSTONE.get());

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_HARDSTONE_STAIRS.get(), ModItems.SMOOTH_HARDSTONE.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_HARDSTONE_SLAB.get(), ModItems.SMOOTH_HARDSTONE.get(), 2);

        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILE_STAIRS.get(), ModItems.RAINBOW_TILES.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILE_SLAB.get(), ModItems.RAINBOW_TILES.get(), 2);
        stonecutterResultFromBase(pWriter, RecipeCategory.DECORATIONS, ModItems.RAINBOW_TILE_WALL.get(), ModItems.RAINBOW_TILES.get());

        stairs(pWriter, ModItems.VANILLATE_STAIRS.get(), ModItems.VANILLATE.get());
        stairs(pWriter, ModItems.VANILLATE_BRICK_STAIRS.get(), ModItems.VANILLATE_BRICKS.get());
        stairs(pWriter, ModItems.VANILLATE_TILE_STAIRS.get(), ModItems.VANILLATE_TILES.get());
        stairs(pWriter, ModItems.SMOOTH_TOADSTONE_STAIRS.get(), ModItems.SMOOTH_TOADSTONE.get());
        stairs(pWriter, ModItems.SMOOTH_HARDSTONE_STAIRS.get(), ModItems.SMOOTH_HARDSTONE.get());
        stairs(pWriter, ModItems.CLOUD_STAIRS.get(), ModItems.PACKED_CLOUD.get());
        stairs(pWriter, ModItems.RAINBOW_TILE_STAIRS.get(), ModItems.RAINBOW_TILES.get());

        slab(pWriter, ModItems.VANILLATE_SLAB.get(), ModItems.VANILLATE.get());
        slab(pWriter, ModItems.VANILLATE_BRICK_SLAB.get(), ModItems.VANILLATE_BRICKS.get());
        slab(pWriter, ModItems.VANILLATE_TILE_SLAB.get(), ModItems.VANILLATE_TILES.get());
        slab(pWriter, ModItems.SMOOTH_TOADSTONE_SLAB.get(), ModItems.SMOOTH_TOADSTONE.get());
        slab(pWriter, ModItems.SMOOTH_HARDSTONE_SLAB.get(), ModItems.SMOOTH_HARDSTONE.get());
        slab(pWriter, ModItems.CLOUD_SLAB.get(), ModItems.PACKED_CLOUD.get());
        slab(pWriter, ModItems.RAINBOW_TILE_SLAB.get(), ModItems.RAINBOW_TILES.get());

        wall(pWriter, ModItems.VANILLATE_WALL.get(), ModItems.VANILLATE.get());
        wall(pWriter, ModItems.VANILLATE_BRICK_WALL.get(), ModItems.VANILLATE_BRICKS.get());
        wall(pWriter, ModItems.VANILLATE_TILE_WALL.get(), ModItems.VANILLATE_TILES.get());
        wall(pWriter, ModItems.RAINBOW_TILE_WALL.get(), ModItems.RAINBOW_TILES.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.POWER_SHARD.get(), 5).requires(ModItems.POWER_STAR.get()).unlockedBy("has_power_star", has(ModItems.POWER_STAR.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COARSE_TOADSTOOL_SOIL.get(), 4).pattern("DG").pattern("GD").define('D', ModBlocks.TOADSTOOL_SOIL.get()).define('G', Blocks.GRAVEL).unlockedBy("has_material", has(ModBlocks.TOADSTOOL_SOIL.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE.get()).unlockedBy("has_material", has(ModItems.VANILLATE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILES.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE_BRICKS.get()).unlockedBy("has_material", has(ModItems.VANILLATE_BRICKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.TOADSTONE.get()).unlockedBy("has_material", has(ModItems.TOADSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.HARDSTONE.get()).unlockedBy("has_material", has(ModItems.HARDSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILES.get()).pattern("YG").pattern("BP").define('Y', ModItems.YELLOW_STAR_BIT.get()).define('G', ModItems.GREEN_STAR_BIT.get()).define('B', ModItems.BLUE_STAR_BIT.get()).define('P', ModItems.PURPLE_STAR_BIT.get()).unlockedBy("has_star_bit", has(ModTags.Items.STAR_BITS)).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.WARP_PAINTING.get()).pattern("###").pattern("#P#").pattern("###").define('#', ModItems.SUBCON_THREAD.get()).define('P', Items.PAINTING).unlockedBy("has_subcon_thread", has(ModItems.SUBCON_THREAD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HAMMER.get()).pattern("## ").pattern("#/#").pattern(" / ").define('#', ModItems.BRONZE_INGOT.get()).define('/', Items.STICK).unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SUPER_PICKAXE.get()).pattern("###").pattern(" / ").pattern(" / ").define('#', ModItems.POWER_SHARD.get()).define('/', Items.STICK).unlockedBy("has_power_shard", has(ModItems.POWER_SHARD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.YOSHI_COOKIE.get()).pattern("/#/").define('/', Items.WHEAT).define('#', ModItems.YOSHI_FRUIT.get()).unlockedBy("has_yoshi_fruit", has(ModItems.YOSHI_FRUIT.get())).save(pWriter);
    }

    private static void stairs(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike stairs, ItemLike material) {
        stairBuilder(stairs, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

    private static void slab(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike slab, ItemLike material) {
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

    protected static void wall(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike wall, ItemLike material) {
        wallBuilder(RecipeCategory.DECORATIONS, wall, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }
}
