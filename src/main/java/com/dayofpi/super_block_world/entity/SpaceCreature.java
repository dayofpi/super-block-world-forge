package com.dayofpi.super_block_world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public interface SpaceCreature {
    public static boolean checkSpawnRules(EntityType<? extends SpaceCreature> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.canSeeSky(pPos);
    }
}
