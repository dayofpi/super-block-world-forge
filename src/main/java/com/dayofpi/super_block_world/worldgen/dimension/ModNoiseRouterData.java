package com.dayofpi.super_block_world.worldgen.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoiseRouterData {
    public static NoiseRouter mushroomKingdom(HolderGetter<DensityFunction> pDensityFunctions, HolderGetter<NormalNoise.NoiseParameters> pNoiseParameters) {
        DensityFunction densityfunction = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_BARRIER), 0.5D);
        DensityFunction densityfunction1 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_FLOODEDNESS), 0.67D);
        DensityFunction densityfunction2 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_FLUID_LEVEL_SPREAD), 0.7142857142857143D);
        DensityFunction densityfunction3 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.AQUIFER_LAVA));
        DensityFunction densityfunction4 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SHIFT_X);
        DensityFunction densityfunction5 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SHIFT_Z);
        DensityFunction densityfunction6 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, pNoiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction densityfunction7 = DensityFunctions.shiftedNoise2d(densityfunction4, densityfunction5, 0.25D, pNoiseParameters.getOrThrow(Noises.VEGETATION));
        DensityFunction densityfunction8 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.FACTOR);
        DensityFunction densityfunction9 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.DEPTH);
        DensityFunction densityfunction10 = NoiseRouterData.noiseGradientDensity(DensityFunctions.cache2d(densityfunction8), densityfunction9);
        DensityFunction densityfunction11 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.SLOPED_CHEESE);
        DensityFunction densityfunction12 = DensityFunctions.min(densityfunction11, DensityFunctions.mul(DensityFunctions.constant(5.0D), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.ENTRANCES)));
        DensityFunction densityfunction13 = DensityFunctions.rangeChoice(densityfunction11, -1000000.0D, 1.5625D, densityfunction12, NoiseRouterData.underground(pDensityFunctions, pNoiseParameters, densityfunction11));
        DensityFunction densityfunction14 = DensityFunctions.min(NoiseRouterData.postProcess(slideMushroomKingdom(densityfunction13)), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.NOODLE));
        DensityFunction densityfunction15 = NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.Y);

        float f = 4.0F;

        DensityFunction densityfunction20 = DensityFunctions.noise(pNoiseParameters.getOrThrow(Noises.ORE_GAP));
        return new NoiseRouter(densityfunction, densityfunction1, densityfunction2, densityfunction3, densityfunction6, densityfunction7, NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.CONTINENTS), NoiseRouterData.getFunction(pDensityFunctions, NoiseRouterData.EROSION), densityfunction9,NoiseRouterData. getFunction(pDensityFunctions, NoiseRouterData.RIDGES), slideMushroomKingdom(DensityFunctions.add(densityfunction10, DensityFunctions.constant(-0.703125D)).clamp(-64.0D, 64.0D)), densityfunction14, DensityFunctions.zero(), DensityFunctions.zero(), densityfunction20);
    }

    private static DensityFunction slideMushroomKingdom(DensityFunction p_224491_) {
        return NoiseRouterData.slide(p_224491_, -32, 352, 80, 64, -0.078125D, 0, 24, 0.1171875D);
    }
}
