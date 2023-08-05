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
    public static final Codec<ToppingFeatureConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(TagKey.hashedCodec(Registries.BLOCK).fieldOf("replaceable").forGetter((p_204869_) -> {
            return p_204869_.replaceable;
        }), BlockStateProvider.CODEC.fieldOf("ground_state").forGetter((p_161322_) -> {
            return p_161322_.groundState;
        }), CaveSurface.CODEC.fieldOf("surface").forGetter((p_161318_) -> {
            return p_161318_.surface;
        }), IntProvider.codec(1, 128).fieldOf("depth").forGetter((p_161316_) -> {
            return p_161316_.depth;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_bottom_block_chance").forGetter((p_161314_) -> {
            return p_161314_.extraBottomBlockChance;
        }), Codec.intRange(1, 256).fieldOf("vertical_range").forGetter((p_161312_) -> {
            return p_161312_.verticalRange;
        }), IntProvider.CODEC.fieldOf("xz_radius").forGetter((p_161308_) -> {
            return p_161308_.xzRadius;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_edge_column_chance").forGetter((p_161306_) -> {
            return p_161306_.extraEdgeColumnChance;
        })).apply(instance, ToppingFeatureConfiguration::new);
    });
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
