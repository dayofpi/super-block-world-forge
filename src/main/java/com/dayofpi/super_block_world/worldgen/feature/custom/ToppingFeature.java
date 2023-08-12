package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class ToppingFeature extends Feature<ToppingFeatureConfiguration> {
    public ToppingFeature(Codec<ToppingFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public boolean place(FeaturePlaceContext<ToppingFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        ToppingFeatureConfiguration configuration = pContext.config();
        RandomSource randomsource = pContext.random();
        BlockPos blockpos = pContext.origin();
        Predicate<BlockState> predicate = (blockState) -> blockState.is(configuration.replaceable);
        int i = configuration.xzRadius.sample(randomsource) + 1;
        int j = configuration.xzRadius.sample(randomsource) + 1;
        Set<BlockPos> set = this.placeGroundPatch(worldgenlevel, configuration, randomsource, blockpos, predicate, i, j);
        return !set.isEmpty();
    }

    protected Set<BlockPos> placeGroundPatch(WorldGenLevel pLevel, ToppingFeatureConfiguration pConfig, RandomSource pRandom, BlockPos pPos, Predicate<BlockState> pState, int pXRadius, int pZRadius) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();
        BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos$mutableblockpos.mutable();
        Direction direction = pConfig.surface.getDirection();
        Direction direction1 = direction.getOpposite();
        Set<BlockPos> set = new HashSet<>();

        for(int i = -pXRadius; i <= pXRadius; ++i) {
            boolean flag = i == -pXRadius || i == pXRadius;

            for(int j = -pZRadius; j <= pZRadius; ++j) {
                boolean flag1 = j == -pZRadius || j == pZRadius;
                boolean flag2 = flag || flag1;
                boolean flag3 = flag && flag1;
                boolean flag4 = flag2 && !flag3;
                if (!flag3 && (!flag4 || pConfig.extraEdgeColumnChance != 0.0F && !(pRandom.nextFloat() > pConfig.extraEdgeColumnChance))) {
                    blockpos$mutableblockpos.setWithOffset(pPos, i, 0, j);

                    for(int k = 0; pLevel.isStateAtPosition(blockpos$mutableblockpos, BlockBehaviour.BlockStateBase::isAir) && k < pConfig.verticalRange; ++k) {
                        blockpos$mutableblockpos.move(direction);
                    }

                    for(int i1 = 0; pLevel.isStateAtPosition(blockpos$mutableblockpos, (blockState) -> !blockState.isAir()) && i1 < pConfig.verticalRange; ++i1) {
                        blockpos$mutableblockpos.move(direction1);
                    }

                    blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, pConfig.surface.getDirection());
                    BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos1);
                    if (pLevel.isEmptyBlock(blockpos$mutableblockpos) && blockstate.isFaceSturdy(pLevel, blockpos$mutableblockpos1, pConfig.surface.getDirection().getOpposite())) {
                        int l = pConfig.depth.sample(pRandom) + (pConfig.extraBottomBlockChance > 0.0F && pRandom.nextFloat() < pConfig.extraBottomBlockChance ? 1 : 0);
                        BlockPos blockpos = blockpos$mutableblockpos1.immutable();
                        boolean flag5 = this.placeGround(pLevel, pConfig, pState, pRandom, blockpos$mutableblockpos1, l);
                        if (flag5) {
                            set.add(blockpos);
                        }
                    }
                }
            }
        }

        return set;
    }

    protected boolean placeGround(WorldGenLevel pLevel, ToppingFeatureConfiguration pConfig, Predicate<BlockState> pReplaceableblocks, RandomSource pRandom, BlockPos.MutableBlockPos pMutablePos, int pMaxDistance) {
        for(int i = 0; i < pMaxDistance; ++i) {
            BlockState blockstate = pConfig.groundState.getState(pRandom, pMutablePos);
            BlockState blockstate1 = pLevel.getBlockState(pMutablePos);
            if (!blockstate.is(blockstate1.getBlock())) {
                if (!pReplaceableblocks.test(blockstate1)) {
                    return i != 0;
                }

                pLevel.setBlock(pMutablePos, blockstate, 2);
                pMutablePos.move(pConfig.surface.getDirection());
            }
        }

        return true;
    }
}
