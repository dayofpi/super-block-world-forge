package com.dayofpi.super_block_world.worldgen.structure;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSets {
    public static final ResourceKey<StructureSet> MOON_MONOLITHS = register("moon_monoliths");
    public static final ResourceKey<StructureSet> OVERWORLD_BRICK_FORTRESSES = register("overworld_brick_fortresses");
    public static final ResourceKey<StructureSet> MUSHROOM_KINGDOM_BRICK_FORTRESSES = register("mushroom_kingdom_brick_fortresses");

    public static void bootstrap(BootstapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(MOON_MONOLITHS, new StructureSet(structures.getOrThrow(ModStructures.MOON_MONOLITH), new RandomSpreadStructurePlacement(64, 16, RandomSpreadType.LINEAR, 1666030804)));
        context.register(OVERWORLD_BRICK_FORTRESSES, new StructureSet(structures.getOrThrow(ModStructures.BRICK_FORTRESS_OVERWORLD), new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 1110473394)));
        context.register(MUSHROOM_KINGDOM_BRICK_FORTRESSES, new StructureSet(structures.getOrThrow(ModStructures.BRICK_FORTRESS_MUSHROOM_KINGDOM), new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 1186354726)));
    }

    private static ResourceKey<StructureSet> register(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
