package com.dayofpi.super_block_world.worldgen.biome;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

public class ModBiomes {
    public static final ResourceKey<Biome> MUSHROOM_GRASSLANDS = register("mushroom_grasslands");

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(MUSHROOM_GRASSLANDS, mushroomGrasslands(context));
    }

    public static Biome mushroomGrasslands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 2));

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        ModBiomeFeatures.globalMushroomKingdomGeneration(generationBuilder);

        return new Biome.BiomeBuilder().hasPrecipitation(true).downfall(0.4f).temperature(0.8f).generationSettings(generationBuilder.build()).mobSpawnSettings(spawnBuilder.build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4046591).waterFogColor(4046591).skyColor(11134462).fogColor(14005247).grassColorOverride(6879535).foliageColorOverride(6408218).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()
        ).build();
    }

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
