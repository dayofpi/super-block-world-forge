package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SUPER = TierSortingRegistry.registerTier(new ForgeTier(3, 500, 12.0F, 8.0F, 0, ModTags.Blocks.NEEDS_SUPER_PICKAX, () -> Ingredient.EMPTY), new ResourceLocation(SuperBlockWorld.MOD_ID, "super"), List.of(Tiers.IRON), List.of(Tiers.NETHERITE));
}
