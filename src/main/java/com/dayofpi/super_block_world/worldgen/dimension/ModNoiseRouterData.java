package com.dayofpi.super_block_world.worldgen.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoiseRouterData {
    public static NoiseRouter mushroomKingdom(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters) {
        DensityFunction densityFunction = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D);
        DensityFunction densityFunction1 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D);
        DensityFunction densityFunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D);
        DensityFunction densityFunction3 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_LAVA));
        DensityFunction densityFunction4 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SHIFT_X);
        DensityFunction densityFunction5 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SHIFT_Z);
        DensityFunction densityFunction6 = DensityFunctions.shiftedNoise2d(densityFunction4, densityFunction5, 0.25D, pNoiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction densityFunction7 = DensityFunctions.shiftedNoise2d(densityFunction4, densityFunction5, 0.25D, pNoiseParameters.getOrThrow(Noises.VEGETATION));
        DensityFunction densityFunction8 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.FACTOR);
        DensityFunction densityFunction9 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.DEPTH);
        DensityFunction densityFunction10 = NoiseRouterData.noiseGradientDensity(DensityFunctions.cache2d(densityFunction8), densityFunction9);
        DensityFunction densityFunction11 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SLOPED_CHEESE);
        DensityFunction densityFunction12 = DensityFunctions.min(densityFunction11, DensityFunctions.mul(DensityFunctions.constant(5.0D), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.ENTRANCES)));
        DensityFunction densityFunction13 = DensityFunctions.rangeChoice(densityFunction11, -1000000.0D, 1.5625D, densityFunction12, NoiseRouterData.underground(pDensityFunctions, pNoiseParameters, densityFunction11));
        DensityFunction densityFunction14 = DensityFunctions.min(NoiseRouterData.postProcess(slideMushroomKingdom(densityFunction13)), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.NOODLE));

        return new NoiseRouter(densityFunction, densityFunction1, densityFunction2, densityFunction3, densityFunction6, densityFunction7, NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.CONTINENTS), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.EROSION), densityFunction9,NoiseRouterData. getFunction(pDensityFunctions, NoiseRouterData.RIDGES), slideMushroomKingdom(DensityFunctions.add(densityFunction10, DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)), densityFunction14, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
    }

    private static DensityFunction slideMushroomKingdom(DensityFunction densityFunction) {
        return NoiseRouterData.slide(densityFunction, -32, 352, 80, 64, -0.078125D, 0, 24, 0.1171875D);
    }
}
