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
    public static final ResourceKey<StructureTemplatePool> BRICK_FORTRESS = register("brick_fortress");
    public static final ResourceKey<StructureTemplatePool> FORTRESS_BOSSES = register("fortress_bosses");
    public static final ResourceKey<StructureTemplatePool> TOSTARENA_RUINS = register("tostarena_ruins");
    public static final ResourceKey<StructureTemplatePool> TOSTARENA_RUINS_DECOR = register("tostarena_ruins_decor");
    public static final ResourceKey<StructureTemplatePool> TOSTARENA_RUINS_CENTER = register("tostarena_ruins_center");
    public static final ResourceKey<StructureTemplatePool> PREHISTORIC_SITE = register("prehistoric_site");
    public static final ResourceKey<StructureTemplatePool> PREHISTORIC_SITE_DECOR = register("prehistoric_site_decor");

    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        HolderGetter<StructureProcessorList> processorLists = context.lookup(Registries.PROCESSOR_LIST);

        context.register(MOON_MONOLITH, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:moon_monolith", processorLists.getOrThrow(ModProcessorLists.MOON_MONOLITH_DECAY)), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(BRICK_FORTRESS, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:brick_fortress"), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(FORTRESS_BOSSES, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:bosses/boom_boom"), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(TOSTARENA_RUINS, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/base", processorLists.getOrThrow(ModProcessorLists.TOSTARENA_RUINS_ARCHAEOLOGY)), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(TOSTARENA_RUINS_DECOR, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(
                Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/decor1"), 1),
                Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/decor2"), 1),
                Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/decor3"), 1),
                Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/decor4"), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(TOSTARENA_RUINS_CENTER, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(
                Pair.of(StructurePoolElement.legacy("super_block_world:tostarena_ruins/center1", processorLists.getOrThrow(ModProcessorLists.TOSTARENA_RUINS_DECAY)), 1)
        ), StructureTemplatePool.Projection.RIGID));
        context.register(PREHISTORIC_SITE, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(Pair.of(StructurePoolElement.legacy("super_block_world:prehistoric_site/base", processorLists.getOrThrow(ModProcessorLists.PREHISTORIC_SITE_ARCHAEOLOGY)), 1)), StructureTemplatePool.Projection.RIGID));
        context.register(PREHISTORIC_SITE_DECOR, new StructureTemplatePool(templatePools.getOrThrow(Pools.EMPTY), ImmutableList.of(
                Pair.of(StructurePoolElement.legacy("super_block_world:prehistoric_site/decor1"), 1),
                Pair.of(StructurePoolElement.legacy("super_block_world:prehistoric_site/decor2"), 1)
        ), StructureTemplatePool.Projection.RIGID));
    }

    private static ResourceKey<StructureTemplatePool> register(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
