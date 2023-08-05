package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.worldgen.feature.custom.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Feature<ToppingFeatureConfiguration>> TOPPING = FEATURES.register("topping", () -> new ToppingFeature(ToppingFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WARP_PIPE = FEATURES.register("warp_pipe", () -> new WarpPipeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> LINKED_WARP_PIPE = FEATURES.register("linked_warp_pipe", () -> new LinkedWarpPipeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> UNDERWATER_PIPE = FEATURES.register("underwater_pipe", () -> new UnderwaterPipeFeature(NoneFeatureConfiguration.CODEC));
}
