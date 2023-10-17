package com.dayofpi.super_block_world.datagen.server.tag;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.util.ModTags;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Biomes.IS_MUSHROOM_KINGDOM).addOptional(ModBiomes.MUSHROOM_GRASSLANDS.location()).addOptional(ModBiomes.SUBCON_HILLS.location()).addOptional(ModBiomes.GRITZY_DESERT.location()).addOptional(ModBiomes.DESERT_OASIS.location());
        tag(ModTags.Biomes.SPAWNS_SURFACE_SHY_GUYS).addOptional(ModBiomes.MUSHROOM_GRASSLANDS.location()).addOptional(ModBiomes.SUBCON_HILLS.location()).addOptional(ModBiomes.GRITZY_DESERT.location());
        tag(ModTags.Biomes.HAS_TOSTARENA_RUINS).addOptional(ModBiomes.GRITZY_DESERT.location()).addOptional(ModBiomes.DESERT_OASIS.location());
        tag(ModTags.Biomes.HAS_PREHISTORIC_SITE).addOptional(ModBiomes.FOSSIL_FALLS.location());
    }

    @Override
    public String getName() {
        return "Biome Tags";
    }
}
