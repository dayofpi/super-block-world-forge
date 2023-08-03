package com.dayofpi.super_block_world.worldgen.biome;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class ModBiomes {
    public static final ResourceKey<Biome> MUSHROOM_GRASSLANDS = register("mushroom_grasslands");
    public static final int GRASSLANDS_WATER_COLOR = 4046591;
    public static final int GRASSLANDS_SKY_COLOR = 11134462;
    public static final int GRASSLANDS_FOG_COLOR = 14005247;
    public static final int GRASSLANDS_GRASS_COLOR = 6879535;
    public static final int GRASSLANDS_FOLIAGE_COLOR = 6408218;

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(MUSHROOM_GRASSLANDS, mushroomGrasslands(context));
    }

    public static Biome mushroomGrasslands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 4, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 2));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityTypes.SHY_GUY.get(), 100, 4, 4));

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);
        ModBiomeFeatures.addMushroomGrasslandsVegetation(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.4f).temperature(0.8f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(GRASSLANDS_WATER_COLOR).waterFogColor(GRASSLANDS_WATER_COLOR).skyColor(GRASSLANDS_SKY_COLOR).fogColor(GRASSLANDS_FOG_COLOR).grassColorOverride(GRASSLANDS_GRASS_COLOR).foliageColorOverride(GRASSLANDS_FOLIAGE_COLOR).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(ModBiomeFeatures.createBiomeMusic(ModSoundEvents.MUSIC_GRASSLANDS)).build()).build();
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
