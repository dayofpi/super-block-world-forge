package com.dayofpi.super_block_world.datagen.server;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import com.dayofpi.super_block_world.worldgen.dimension.ModDimensions;
import com.dayofpi.super_block_world.worldgen.feature.ModConfiguredFeatures;
import com.dayofpi.super_block_world.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModEntriesProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.NOISE_SETTINGS, ModDimensions::noiseBootstrap)
            .add(Registries.LEVEL_STEM, ModDimensions::stemBootstrap)
            .add(Registries.DIMENSION_TYPE, ModDimensions::typeBootstrap);

    public ModEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SuperBlockWorld.MOD_ID));
    }
}
