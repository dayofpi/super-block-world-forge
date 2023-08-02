package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMANITA = registerKey("amanita");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FRUITING_AMANITA = registerKey("fruiting_amanita");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_AMANITA = registerKey("mega_amanita");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERBED_WHITE = registerKey("flowerbed_white");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERBED_YELLOW = registerKey("flowerbed_yellow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MUSHROOM_GRASSLANDS = registerKey("trees_mushroom_grasslands");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_WATER = registerKey("spring_water");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        register(context, AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new StraightTrunkPlacer(3, 2, 1), BlockStateProvider.simple(ModBlocks.AMANITA_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).build());
        register(context, FRUITING_AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new StraightTrunkPlacer(3, 2, 1), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.AMANITA_LEAVES.get().defaultBlockState(), 5).add(ModBlocks.FRUITING_AMANITA_LEAVES.get().defaultBlockState(), 2).build()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).build());
        register(context, MEGA_AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.AMANITA_LEAVES.get().defaultBlockState(), 10).add(ModBlocks.FRUITING_AMANITA_LEAVES.get().defaultBlockState(), 2).build()), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1,  1,0, 1, 2, OptionalInt.empty())).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.TOADSTOOL_GRASS.get())))).build());
        register(context, FLOWERBED_WHITE, Feature.RANDOM_PATCH, new RandomPatchConfiguration(320, 7, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_FLOWERBED.get())))));
        register(context, FLOWERBED_YELLOW, Feature.RANDOM_PATCH, new RandomPatchConfiguration(320, 7, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_FLOWERBED.get())))));
        register(context, TREES_MUSHROOM_GRASSLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM)), 0.2f), new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.FRUITING_AMANITA_CHECKED), 0.1F)), placedFeatures.getOrThrow(ModPlacedFeatures.AMANITA_CHECKED)));
        register(context, SPRING_WATER, Feature.SPRING, new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.VANILLATE.get(), ModBlocks.TOADSTOOL_SOIL.get())));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
