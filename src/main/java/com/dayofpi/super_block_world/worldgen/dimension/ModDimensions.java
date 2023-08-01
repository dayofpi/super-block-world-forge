package com.dayofpi.super_block_world.worldgen.dimension;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;

import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> MUSHROOM_KINGDOM_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom"));
    public static final ResourceKey<Level> MUSHROOM_KINGDOM_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom"));
    public static final ResourceKey<DimensionType> MUSHROOM_KINGDOM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom"));
    public static final ResourceKey<NoiseGeneratorSettings> MUSHROOM_KINGDOM_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom"));

    public static void typeBootstrap(BootstapContext<DimensionType> context) {
        context.register(MUSHROOM_KINGDOM_TYPE, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0, true, false, -32, 352, 352, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0f, new DimensionType.MonsterSettings(true, false, UniformInt.of(0, 7), 0)));
    }

    public static void stemBootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(biomes.getOrThrow(ModBiomes.MUSHROOM_GRASSLANDS)), noiseSettings.getOrThrow(MUSHROOM_KINGDOM_NOISE));

        context.register(MUSHROOM_KINGDOM_STEM, new LevelStem(dimensionTypes.getOrThrow(MUSHROOM_KINGDOM_TYPE), chunkGenerator));
    }

    public static void noiseBootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(MUSHROOM_KINGDOM_NOISE, new NoiseGeneratorSettings(NoiseSettings.create(-32, 352, 1, 2), ModBlocks.VANILLATE.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), NoiseRouterData.overworld(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE), false, false), SurfaceRuleData.overworld(), new OverworldBiomeBuilder().spawnTarget(), 63, false, true, false, false));
    }
}
