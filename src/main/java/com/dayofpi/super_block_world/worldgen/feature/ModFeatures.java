package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.worldgen.feature.custom.UnderwaterPipeFeature;
import com.dayofpi.super_block_world.worldgen.feature.custom.WarpPipeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WARP_PIPE = FEATURES.register("warp_pipe", () -> new WarpPipeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> UNDERWATER_PIPE = FEATURES.register("underwater_pipe", () -> new UnderwaterPipeFeature(NoneFeatureConfiguration.CODEC));
}
