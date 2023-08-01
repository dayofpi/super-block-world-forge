package com.dayofpi.super_block_world.worldgen.biome;

import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeFeatures {
    public static void globalMushroomKingdomGeneration(BiomeGenerationSettings.Builder pBuilder) {
        ModBiomeFeatures.addDefaultCarversAndLakes(pBuilder);
    }

    public static void addDefaultCarversAndLakes(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        pBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        pBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE);
    }
}
