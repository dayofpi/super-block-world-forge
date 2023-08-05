package com.dayofpi.super_block_world.worldgen.structure;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class ModTemplatePools {
    public static final ResourceKey<StructureTemplatePool> MOON_MONOLITH = register("moon_monolith");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorLists = context.lookup(Registries.PROCESSOR_LIST);

        context.register(MOON_MONOLITH, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:moon_monolith", processorLists.getOrThrow(ModProcessorLists.MOON_MONOLITH_DECAY)), 1)), StructureTemplatePool.Projection.RIGID));
    }

    private static ResourceKey<StructureTemplatePool> register(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
