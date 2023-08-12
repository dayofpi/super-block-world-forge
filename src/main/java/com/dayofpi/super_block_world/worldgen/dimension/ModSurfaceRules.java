package com.dayofpi.super_block_world.worldgen.dimension;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource TOADSTOOL_GRASS = makeStateRule(ModBlocks.TOADSTOOL_GRASS.get());
    private static final SurfaceRules.RuleSource TOADSTOOL_TURF = makeStateRule(ModBlocks.TOADSTOOL_TURF.get());
    private static final SurfaceRules.RuleSource TOADSTOOL_SOIL = makeStateRule(ModBlocks.TOADSTOOL_SOIL.get());

    public static SurfaceRules.RuleSource mushroomKingdom() {
        SurfaceRules.ConditionSource waterCheckConditionSource = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.RuleSource grassAndSoilRuleSource = SurfaceRules.sequence(SurfaceRules.ifTrue(waterCheckConditionSource, TOADSTOOL_GRASS), TOADSTOOL_SOIL);

        SurfaceRules.RuleSource ruleSource = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.MUSHROOM_GRASSLANDS), grassAndSoilRuleSource),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUBCON_HILLS), TOADSTOOL_TURF)
                        )),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.MUSHROOM_GRASSLANDS), TOADSTOOL_SOIL),
                                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUBCON_HILLS), TOADSTOOL_TURF)
                        ))
                )));

        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        SurfaceRules.RuleSource abovePreliminarySurfaceRuleSource = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), ruleSource);
        builder.add(abovePreliminarySurfaceRuleSource);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));

        return SurfaceRules.sequence(builder.build().toArray(new SurfaceRules.RuleSource[0]));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block pBlock) {
        return SurfaceRules.state(pBlock.defaultBlockState());
    }
}
