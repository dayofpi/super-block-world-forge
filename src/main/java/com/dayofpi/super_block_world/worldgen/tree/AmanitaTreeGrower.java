package com.dayofpi.super_block_world.worldgen.tree;

import com.dayofpi.super_block_world.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class AmanitaTreeGrower extends AbstractMegaTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return pRandom.nextInt(5) == 0 ? ModConfiguredFeatures.FRUITING_AMANITA : ModConfiguredFeatures.AMANITA;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource pRandom) {
        return ModConfiguredFeatures.MEGA_AMANITA;
    }
}
