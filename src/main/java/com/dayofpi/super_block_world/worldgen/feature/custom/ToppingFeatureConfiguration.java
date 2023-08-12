package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class ToppingFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<ToppingFeatureConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(TagKey.hashedCodec(Registries.BLOCK).fieldOf("replaceable").forGetter((configuration) -> configuration.replaceable), BlockStateProvider.CODEC.fieldOf("ground_state").forGetter((configuration) -> configuration.groundState), CaveSurface.CODEC.fieldOf("surface").forGetter((configuration) -> configuration.surface), IntProvider.codec(1, 128).fieldOf("depth").forGetter((configuration) -> configuration.depth), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_bottom_block_chance").forGetter((configuration) -> configuration.extraBottomBlockChance), Codec.intRange(1, 256).fieldOf("vertical_range").forGetter((configuration) -> configuration.verticalRange), IntProvider.CODEC.fieldOf("xz_radius").forGetter((configuration) -> configuration.xzRadius), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_edge_column_chance").forGetter((configuration) -> configuration.extraEdgeColumnChance)).apply(instance, ToppingFeatureConfiguration::new));
    public final TagKey<Block> replaceable;
    public final BlockStateProvider groundState;
    public final CaveSurface surface;
    public final IntProvider depth;
    public final float extraBottomBlockChance;
    public final int verticalRange;
    public final IntProvider xzRadius;
    public final float extraEdgeColumnChance;

    public ToppingFeatureConfiguration(TagKey<Block> blockTagKey, BlockStateProvider blockStateProvider, CaveSurface caveSurface, IntProvider intProvider, float extraBottomBlockChance, int verticalRange, IntProvider xzRadius, float extraEdgeColumnChance) {
        this.replaceable = blockTagKey;
        this.groundState = blockStateProvider;
        this.surface = caveSurface;
        this.depth = intProvider;
        this.extraBottomBlockChance = extraBottomBlockChance;
        this.verticalRange = verticalRange;
        this.xzRadius = xzRadius;
        this.extraEdgeColumnChance = extraEdgeColumnChance;
    }
}
