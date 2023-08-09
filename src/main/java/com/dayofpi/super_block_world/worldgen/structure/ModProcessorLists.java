package com.dayofpi.super_block_world.worldgen.structure;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockRotProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class ModProcessorLists {
    public static final ResourceKey<StructureProcessorList> MOON_MONOLITH_DECAY = register("moon_monolith_decay");

    public static void bootstrap(BootstapContext<StructureProcessorList> context) {
        context.register(MOON_MONOLITH_DECAY, new StructureProcessorList(ImmutableList.of(new BlockRotProcessor(0.87F), new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE))));
    }

    private static ResourceKey<StructureProcessorList> register(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
