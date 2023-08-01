package com.dayofpi.super_block_world.datagen.server;

import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.util.ModTags;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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
        smeltingResultFromBase(pWriter, ModItems.SMOOTH_TOADSTONE.get(), ModItems.TOADSTONE.get());
        smeltingResultFromBase(pWriter, ModItems.SMOOTH_HARDSTONE.get(), ModItems.HARDSTONE.get());
        oreSmelting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 200, "bronze_ingot");
        oreBlasting(pWriter, ImmutableList.of(ModItems.RAW_BRONZE.get()), RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 0.7f, 100, "bronze_ingot");

        oneToOneConversionRecipe(pWriter, Items.WHITE_DYE, ModItems.WHITE_FLOWERBED.get(), "white_dye");
        oneToOneConversionRecipe(pWriter, Items.YELLOW_DYE, ModItems.YELLOW_FLOWERBED.get(), "yellow_dye");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.POWER_SHARD.get(), 5).requires(ModItems.POWER_STAR.get()).unlockedBy("has_power_star", has(ModItems.POWER_STAR.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE.get()).unlockedBy("has_material", has(ModItems.VANILLATE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.VANILLATE_TILES.get(), 4).pattern("##").pattern("##").define('#', ModItems.VANILLATE_BRICKS.get()).unlockedBy("has_material", has(ModItems.VANILLATE_BRICKS.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOADSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.TOADSTONE.get()).unlockedBy("has_material", has(ModItems.TOADSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.HARDSTONE_BRICKS.get(), 4).pattern("##").pattern("##").define('#', ModItems.HARDSTONE.get()).unlockedBy("has_material", has(ModItems.HARDSTONE.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.RAINBOW_TILES.get()).pattern("YG").pattern("BP").define('Y', ModItems.YELLOW_STAR_BIT.get()).define('G', ModItems.GREEN_STAR_BIT.get()).define('B', ModItems.BLUE_STAR_BIT.get()).define('P', ModItems.PURPLE_STAR_BIT.get()).unlockedBy("has_star_bit", has(ModTags.Items.STAR_BITS)).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.WARP_PAINTING.get()).pattern("###").pattern("#P#").pattern("###").define('#', ModItems.SUBCON_THREAD.get()).define('P', Items.PAINTING).unlockedBy("has_subcon_thread", has(ModItems.SUBCON_THREAD.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HAMMER.get()).pattern("## ").pattern("#/#").pattern(" / ").define('#', ModItems.BRONZE_INGOT.get()).define('/', Items.STICK).unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SUPER_PICKAXE.get()).pattern("###").pattern(" / ").pattern(" / ").define('#', ModItems.POWER_SHARD.get()).define('/', Items.STICK).unlockedBy("has_power_shard", has(ModItems.POWER_SHARD.get())).save(pWriter);
    }
}
