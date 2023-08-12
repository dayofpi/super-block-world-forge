package com.dayofpi.super_block_world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public interface SpaceCreature {
    static boolean checkSpawnRules(EntityType<? extends SpaceCreature> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos blockPos, RandomSource randomSource) {
        return level.canSeeSky(blockPos);
    }
}
