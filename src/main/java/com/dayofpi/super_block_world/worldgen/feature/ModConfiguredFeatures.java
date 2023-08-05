package com.dayofpi.super_block_world.worldgen.feature;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.util.ModTags;
import com.dayofpi.super_block_world.worldgen.feature.custom.ToppingFeatureConfiguration;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
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
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> VANILLATE_TOPPING = registerKey("vanillate_topping");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_WATER = registerKey("spring_water");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SAND = registerKey("disk_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BRONZE = registerKey("ore_bronze");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CRUMBLE = registerKey("ore_crumble");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TOADSTONE = registerKey("ore_toadstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_HARDSTONE = registerKey("ore_hardstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STAR_CLUSTER = registerKey("star_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARP_PIPE = registerKey("warp_pipe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LINKED_WARP_PIPE = registerKey("linked_warp_pipe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNDERWATER_PIPE = registerKey("underwater_pipe");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        register(context, AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new StraightTrunkPlacer(3, 2, 1), BlockStateProvider.simple(ModBlocks.AMANITA_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).build());
        register(context, FRUITING_AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new StraightTrunkPlacer(3, 2, 1), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.AMANITA_LEAVES.get().defaultBlockState(), 5).add(ModBlocks.FRUITING_AMANITA_LEAVES.get().defaultBlockState(), 2).build()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).build());
        register(context, MEGA_AMANITA, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.AMANITA_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.AMANITA_LEAVES.get().defaultBlockState(), 10).add(ModBlocks.FRUITING_AMANITA_LEAVES.get().defaultBlockState(), 2).build()), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1,  1,0, 1, 2, OptionalInt.empty())).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.TOADSTOOL_SOIL.get())).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.TOADSTOOL_GRASS.get())))).build());
        register(context, FLOWERBED_WHITE, Feature.RANDOM_PATCH, new RandomPatchConfiguration(320, 7, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_FLOWERBED.get())))));
        register(context, FLOWERBED_YELLOW, Feature.RANDOM_PATCH, new RandomPatchConfiguration(320, 7, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_FLOWERBED.get())))));
        register(context, TREES_MUSHROOM_GRASSLANDS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM)), 0.2f), new WeightedPlacedFeature(placedFeatures.getOrThrow(ModPlacedFeatures.FRUITING_AMANITA_CHECKED), 0.1F)), placedFeatures.getOrThrow(ModPlacedFeatures.AMANITA_CHECKED)));
        register(context, VANILLATE_TOPPING, ModFeatures.TOPPING.get(), new ToppingFeatureConfiguration(ModTags.Blocks.VANILLATE_TOPPING_REPLACEABLE, BlockStateProvider.simple(ModBlocks.TOPPED_VANILLATE.get()), CaveSurface.FLOOR, ConstantInt.of(1), 0.0f, 1, ConstantInt.of(7), 0.3f));
        register(context, SPRING_WATER, Feature.SPRING, new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.VANILLATE.get(), ModBlocks.TOADSTOOL_SOIL.get())));
        register(context, DISK_SAND, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(BlockStateProvider.simple(Blocks.SAND), List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR), BlockStateProvider.simple(Blocks.SANDSTONE)))), BlockPredicate.matchesBlocks(List.of(ModBlocks.TOADSTOOL_SOIL.get(), ModBlocks.TOADSTOOL_GRASS.get())), UniformInt.of(2, 6), 2));
        BlockMatchTest isVanillate = new BlockMatchTest(ModBlocks.VANILLATE.get());
        register(context, ORE_BRONZE, Feature.ORE, new OreConfiguration(isVanillate, ModBlocks.BRONZE_ORE.get().defaultBlockState(), 24));
        List<OreConfiguration.TargetBlockState> crumbleTargets = List.of(OreConfiguration.target(new BlockMatchTest(ModBlocks.TOADSTOOL_SOIL.get()), ModBlocks.COARSE_TOADSTOOL_SOIL.get().defaultBlockState()), OreConfiguration.target(isVanillate, ModBlocks.VANILLATE_CRUMBLE.get().defaultBlockState()));
        register(context, ORE_CRUMBLE, Feature.ORE, new OreConfiguration(crumbleTargets, 16));
        register(context, ORE_TOADSTONE, Feature.ORE, new OreConfiguration(isVanillate, ModBlocks.TOADSTONE.get().defaultBlockState(), 64));
        register(context, ORE_HARDSTONE, Feature.ORE, new OreConfiguration(isVanillate, ModBlocks.HARDSTONE.get().defaultBlockState(), 64));
        register(context, STAR_CLUSTER, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 7, 3, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.STAR_CLUSTER.get().defaultBlockState(), 2).add(ModBlocks.STAR_CLUSTER.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN), 1).add(ModBlocks.STAR_CLUSTER.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.NORTH), 1).add(ModBlocks.STAR_CLUSTER.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.SOUTH), 1).add(ModBlocks.STAR_CLUSTER.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.EAST), 1).add(ModBlocks.STAR_CLUSTER.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.WEST), 1).build())), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE))));
        register(context, WARP_PIPE, ModFeatures.WARP_PIPE.get(), new NoneFeatureConfiguration());
        register(context, LINKED_WARP_PIPE, ModFeatures.LINKED_WARP_PIPE.get(), new NoneFeatureConfiguration());
        register(context, UNDERWATER_PIPE, ModFeatures.UNDERWATER_PIPE.get(), new NoneFeatureConfiguration());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
