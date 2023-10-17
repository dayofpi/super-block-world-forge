package com.dayofpi.super_block_world.worldgen.structure;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.rule.blockentity.AppendLoot;

public class ModProcessorLists {
    public static final ResourceKey<StructureProcessorList> MOON_MONOLITH_DECAY = register("moon_monolith_decay");
    public static final ResourceKey<StructureProcessorList> TOSTARENA_RUINS_ARCHAEOLOGY = register("tostarena_ruins_archaeology");
    public static final ResourceKey<StructureProcessorList> TOSTARENA_RUINS_DECAY = register("tostarena_ruins_decay");
    public static final ResourceKey<StructureProcessorList> PREHISTORIC_SITE_ARCHAEOLOGY = register("prehistoric_site_archaeology");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        context.register(MOON_MONOLITH_DECAY, new StructureProcessorList(ImmutableList.of(new BlockRotProcessor(0.87F), new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE))));
        context.register(TOSTARENA_RUINS_ARCHAEOLOGY, new StructureProcessorList(ImmutableList.of(BlockIgnoreProcessor.AIR, new RuleProcessor(ImmutableList.of(
                new ProcessorRule(new RandomBlockMatchTest(ModBlocks.CUT_GRITZY_SANDSTONE.get(), 0.2F), AlwaysTrueTest.INSTANCE, ModBlocks.GRITZY_SAND.get().defaultBlockState()),
                new ProcessorRule(new RandomBlockMatchTest(ModBlocks.CUT_GRITZY_SANDSTONE.get(), 0.02F), AlwaysTrueTest.INSTANCE, PosAlwaysTrueTest.INSTANCE, ModBlocks.SUSPICIOUS_GRITZY_SAND.get().defaultBlockState(), new AppendLoot(new ResourceLocation(SuperBlockWorld.MOD_ID, "archaeology/tostarena_ruins")))/*,
                new ProcessorRule(new RandomBlockMatchTest(ModBlocks.CUT_GRITZY_SANDSTONE.get(), 0.02F), AlwaysTrueTest.INSTANCE, ModBlocks.SUSPICIOUS_GRITZY_SAND.get().defaultBlockState())*/
        )))));
        context.register(TOSTARENA_RUINS_DECAY, new StructureProcessorList(ImmutableList.of(new BlockRotProcessor(0.87F))));
        context.register(PREHISTORIC_SITE_ARCHAEOLOGY, new StructureProcessorList(ImmutableList.of(BlockIgnoreProcessor.AIR, new RuleProcessor(ImmutableList.of(
                new ProcessorRule(new RandomBlockMatchTest(Blocks.VINE, 0.5F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState()),
                new ProcessorRule(new RandomBlockMatchTest(ModBlocks.GRASSY_TOADSTONE.get(), 0.5F), AlwaysTrueTest.INSTANCE, ModBlocks.GRITZY_SAND.get().defaultBlockState()),
                new ProcessorRule(new RandomBlockMatchTest(ModBlocks.GRASSY_TOADSTONE.get(), 0.08F), AlwaysTrueTest.INSTANCE, PosAlwaysTrueTest.INSTANCE, ModBlocks.SUSPICIOUS_GRITZY_SAND.get().defaultBlockState(), new AppendLoot(new ResourceLocation(SuperBlockWorld.MOD_ID, "archaeology/prehistoric_site")))
        )))));
    }

    private static ResourceKey<StructureProcessorList> register(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
