package com.dayofpi.super_block_world.datagen.server;

import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.HAMMER.get()).pattern("## ").pattern("#/#").pattern(" / ").define('#', ModItems.BRONZE_INGOT.get()).define('/', Items.STICK).unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SUPER_PICKAXE.get()).pattern("###").pattern(" / ").pattern(" / ").define('#', ModItems.POWER_SHARD.get()).define('/', Items.STICK).unlockedBy("has_power_shard", has(ModItems.POWER_SHARD.get())).save(pWriter);
    }
}
