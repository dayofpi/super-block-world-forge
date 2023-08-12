package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AMANITA_CHECKED = registerKey("amanita_checked");
    public static final ResourceKey<PlacedFeature> FRUITING_AMANITA_CHECKED = registerKey("fruiting_amanita_checked");
    public static final ResourceKey<PlacedFeature> MEGA_AMANITA_CHECKED = registerKey("mega_amanita_checked");
    public static final ResourceKey<PlacedFeature> MAYOI_CHECKED = registerKey("mayoi_checked");
    public static final ResourceKey<PlacedFeature> MEGA_MAYOI_CHECKED = registerKey("mega_mayoi_checked");
    public static final ResourceKey<PlacedFeature> STUMP = registerKey("stump");
    public static final ResourceKey<PlacedFeature> RED_TOAD_STOOL = registerKey("red_toad_stool");
    public static final ResourceKey<PlacedFeature> RED_GRASS = registerKey("red_grass");
    public static final ResourceKey<PlacedFeature> RED_GRASS_EXTRA = registerKey("red_grass_extra");
    public static final ResourceKey<PlacedFeature> SUBCON_PALM = registerKey("subcon_palm");
    public static final ResourceKey<PlacedFeature> BEANSTALK = registerKey("beanstalk");
    public static final ResourceKey<PlacedFeature> BEANSTALK_COMMON = registerKey("beanstalk_common");
    public static final ResourceKey<PlacedFeature> FLOWERBED_WHITE = registerKey("flowerbed_white");
    public static final ResourceKey<PlacedFeature> FLOWERBED_YELLOW = registerKey("flowerbed_yellow");
    public static final ResourceKey<PlacedFeature> TREES_MUSHROOM_GRASSLANDS = registerKey("trees_mushroom_grasslands");
    public static final ResourceKey<PlacedFeature> VANILLATE_TOPPING = registerKey("vanillate_topping");
    public static final ResourceKey<PlacedFeature> SPRING_WATER = registerKey("spring_water");
    public static final ResourceKey<PlacedFeature> DISK_SAND = registerKey("disk_sand");
    public static final ResourceKey<PlacedFeature> ORE_BRONZE = registerKey("ore_bronze");
    public static final ResourceKey<PlacedFeature> ORE_CRUMBLE = registerKey("ore_crumble");
    public static final ResourceKey<PlacedFeature> ORE_TOADSTONE = registerKey("ore_toadstone");
    public static final ResourceKey<PlacedFeature> ORE_HARDSTONE = registerKey("ore_hardstone");
    public static final ResourceKey<PlacedFeature> STAR_CLUSTER = registerKey("star_cluster");
    public static final ResourceKey<PlacedFeature> WARP_PIPE = registerKey("warp_pipe");
    public static final ResourceKey<PlacedFeature> LINKED_WARP_PIPE = registerKey("linked_warp_pipe");
    public static final ResourceKey<PlacedFeature> UNDERWATER_PIPE = registerKey("underwater_pipe");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, FRUITING_AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.FRUITING_AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, MEGA_AMANITA_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGA_AMANITA), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AMANITA_SAPLING.get())));
        register(context, MAYOI_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAYOI), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MAYOI_SAPLING.get())));
        register(context, MEGA_MAYOI_CHECKED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEGA_MAYOI), List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.MAYOI_SAPLING.get())));
        register(context, STUMP, configuredFeatures.getOrThrow(ModConfiguredFeatures.STUMP), ImmutableList.of(CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(0), 15).add(UniformInt.of(3, 5), 1).build())), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_TURF.get()))), BiomeFilter.biome()));
        register(context, RED_TOAD_STOOL, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_RED_TOAD_STOOL), ImmutableList.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RED_GRASS, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_RED_GRASS), ImmutableList.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(200)), BiomeFilter.biome()));
        register(context, RED_GRASS_EXTRA, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_RED_GRASS), ImmutableList.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, SUBCON_PALM, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUBCON_PALM), ImmutableList.of(CountPlacement.of(UniformInt.of(0, 3)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), ModBlocks.TOADSTOOL_TURF.get()))), BiomeFilter.biome()));
        register(context, BEANSTALK, configuredFeatures.getOrThrow(ModConfiguredFeatures.BEANSTALK), ImmutableList.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.TOADSTOOL_TURF.get()))), BiomeFilter.biome()));
        register(context, BEANSTALK_COMMON, configuredFeatures.getOrThrow(ModConfiguredFeatures.BEANSTALK), ImmutableList.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.TOADSTOOL_TURF.get()))), BiomeFilter.biome()));
        register(context, FLOWERBED_WHITE, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWERBED_WHITE), ImmutableList.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, FLOWERBED_YELLOW, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWERBED_YELLOW), ImmutableList.of(RarityFilter.onAverageOnceEvery(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, TREES_MUSHROOM_GRASSLANDS, configuredFeatures.getOrThrow(ModConfiguredFeatures.TREES_MUSHROOM_GRASSLANDS), VegetationPlacements.treePlacement(CountPlacement.of(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(0), 4).add(ConstantInt.of(4), 1).build())), ModBlocks.AMANITA_SAPLING.get()));
        register(context, VANILLATE_TOPPING, configuredFeatures.getOrThrow(ModConfiguredFeatures.VANILLATE_TOPPING), ImmutableList.of(CountPlacement.of(50), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(190)), BiomeFilter.biome()));
        register(context, SPRING_WATER, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPRING_WATER), ImmutableList.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(192)), BiomeFilter.biome()));
        register(context, DISK_SAND, configuredFeatures.getOrThrow(ModConfiguredFeatures.DISK_SAND), ImmutableList.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome()));
        register(context, ORE_BRONZE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_BRONZE), ImmutableList.of(CountPlacement.of(14), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(128)), BiomeFilter.biome()));
        register(context, ORE_CRUMBLE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_CRUMBLE), ImmutableList.of(CountPlacement.of(32), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(100)), BiomeFilter.biome()));
        register(context, ORE_TOADSTONE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_TOADSTONE), ImmutableList.of(CountPlacement.of(3), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(190)), BiomeFilter.biome()));
        register(context, ORE_HARDSTONE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_HARDSTONE), ImmutableList.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(190)), BiomeFilter.biome()));
        register(context, STAR_CLUSTER, configuredFeatures.getOrThrow(ModConfiguredFeatures.STAR_CLUSTER), ImmutableList.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(63)), BiomeFilter.biome()));
        register(context, WARP_PIPE, configuredFeatures.getOrThrow(ModConfiguredFeatures.WARP_PIPE), ImmutableList.of(CountPlacement.of(14), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(128)), BiomeFilter.biome()));
        register(context, LINKED_WARP_PIPE, configuredFeatures.getOrThrow(ModConfiguredFeatures.LINKED_WARP_PIPE), ImmutableList.of(CountPlacement.of(3), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(42)), BiomeFilter.biome()));
        register(context, UNDERWATER_PIPE, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNDERWATER_PIPE), ImmutableList.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(70)), BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
