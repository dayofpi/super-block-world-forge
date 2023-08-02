package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AMANITA_CHECKED = registerKey("amanita_checked");
    public static final ResourceKey<PlacedFeature> FRUITING_AMANITA_CHECKED = registerKey("fruiting_amanita_checked");
    public static final ResourceKey<PlacedFeature> MEGA_AMANITA_CHECKED = registerKey("mega_amanita_checked");
    public static final ResourceKey<PlacedFeature> FLOWERBED_WHITE = registerKey("flowerbed_white");
    public static final ResourceKey<PlacedFeature> FLOWERBED_YELLOW = registerKey("flowerbed_yellow");
    public static final ResourceKey<PlacedFeature> TREES_MUSHROOM_GRASSLANDS = registerKey("trees_mushroom_grasslands");
    public static final ResourceKey<PlacedFeature> SPRING_WATER = registerKey("spring_water");
    public static final ResourceKey<PlacedFeature> ORE_CRUMBLE = registerKey("ore_crumble");
    public static final ResourceKey<PlacedFeature> ORE_TOADSTONE = registerKey("ore_toadstone");
    public static final ResourceKey<PlacedFeature> ORE_HARDSTONE = registerKey("ore_hardstone");
    public static final ResourceKey<PlacedFeature> UNDERWATER_PIPE = registerKey("underwater_pipe");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, FRUITING_AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.FRUITING_AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, MEGA_AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGA_AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, FLOWERBED_WHITE, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWERBED_WHITE), ImmutableList.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, FLOWERBED_YELLOW, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWERBED_YELLOW), ImmutableList.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, TREES_MUSHROOM_GRASSLANDS, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREES_MUSHROOM_GRASSLANDS), VegetationPlacements.treePlacement(CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(0), 4).add(ConstantInt.of(4), 1).build())), ModBlocks.AMANITA_SAPLING.get()));
        register(context, SPRING_WATER, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRING_WATER), ImmutableList.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome()));
        register(context, ORE_CRUMBLE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_CRUMBLE), ImmutableList.of(CountPlacement.of(32), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.TOP), BiomeFilter.biome()));
        register(context, ORE_TOADSTONE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_TOADSTONE), ImmutableList.of(CountPlacement.of(3), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(190)), BiomeFilter.biome()));
        register(context, ORE_HARDSTONE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_HARDSTONE), ImmutableList.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(190)), BiomeFilter.biome()));
        register(context, UNDERWATER_PIPE, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNDERWATER_PIPE), ImmutableList.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(70)), BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
