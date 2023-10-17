package com.dayofpi.super_block_world.worldgen.biome;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> MUSHROOM_GRASSLANDS = register("mushroom_grasslands");
    public static final ResourceKey<Biome> SUBCON_HILLS = register("subcon_hills");
    public static final ResourceKey<Biome> GRITZY_DESERT = register("gritzy_desert");
    public static final ResourceKey<Biome> DESERT_OASIS = register("desert_oasis");
    public static final ResourceKey<Biome> FOSSIL_FALLS = register("fossil_falls");

    private static final int GRASSLANDS_WATER_COLOR = 4046591;
    private static final int GRASSLANDS_SKY_COLOR = 11134462;
    private static final int GRASSLANDS_FOG_COLOR = 14005247;
    public static final int GRASSLANDS_GRASS_COLOR = 6879535;
    public static final int GRASSLANDS_FOLIAGE_COLOR = 6408218;
    private static final int DESERT_WATER_COLOR = 4190462;
    public static final int DESERT_GRASS_COLOR = 12050954;
    public static final int DESERT_FOLIAGE_COLOR = 9030922;
    public static final int FOSSIL_FALLS_PLANT_COLOR = 43606;

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(MUSHROOM_GRASSLANDS, mushroomGrasslands(context));
        context.register(SUBCON_HILLS, subconHills(context));
        context.register(GRITZY_DESERT, gritzyDesert(context));
        context.register(DESERT_OASIS, desertOasis(context));
        context.register(FOSSIL_FALLS, fossilFalls(context));
    }

    public static Biome mushroomGrasslands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCaveMobs(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 2));

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        ModBiomeFeatures.addMushroomGrasslandsVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.4f).temperature(0.8f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(GRASSLANDS_WATER_COLOR).waterFogColor(GRASSLANDS_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(GRASSLANDS_GRASS_COLOR).foliageColorOverride(GRASSLANDS_FOLIAGE_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    public static Biome subconHills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCaveMobs(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 4, 4));

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        ModBiomeFeatures.addSubconHillsVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.4f).temperature(0.8f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(GRASSLANDS_WATER_COLOR).waterFogColor(GRASSLANDS_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(GRASSLANDS_GRASS_COLOR).foliageColorOverride(GRASSLANDS_FOLIAGE_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    public static Biome gritzyDesert(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCaveMobs(spawnBuilder);

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        ModBiomeFeatures.addGritzyDesertVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0f).temperature(1.0f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(DESERT_WATER_COLOR).waterFogColor(DESERT_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(DESERT_GRASS_COLOR).foliageColorOverride(DESERT_FOLIAGE_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    public static Biome desertOasis(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCaveMobs(spawnBuilder);

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        ModBiomeFeatures.addDesertOasisVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0f).temperature(1.0f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(DESERT_WATER_COLOR).waterFogColor(DESERT_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(DESERT_GRASS_COLOR).foliageColorOverride(DESERT_FOLIAGE_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    public static Biome fossilFalls(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        ModBiomeFeatures.addCaveMobs(spawnBuilder);

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        generationBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ORE_FOSSIL_STONE);
        generationBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, ModPlacedFeatures.SPRING_WATER_EXTRA);
        ModBiomeFeatures.addFossilFallsVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.4f).temperature(0.8f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(GRASSLANDS_WATER_COLOR).waterFogColor(GRASSLANDS_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(FOSSIL_FALLS_PLANT_COLOR).foliageColorOverride(FOSSIL_FALLS_PLANT_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
