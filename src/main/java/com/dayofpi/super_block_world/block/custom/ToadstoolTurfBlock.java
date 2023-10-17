package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class ToadstoolTurfBlock extends Block implements BonemealableBlock {
    public ToadstoolTurfBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        BlockPos blockPos2 = pPos.above();
        BlockState blockState2 = Blocks.GRASS.defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> optional = pLevel.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(ModPlacedFeatures.BONE_MEAL_VEGETATION);

        label49:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockPos3 = blockPos2;

            for(int j = 0; j < i / 16; ++j) {
                blockPos3 = blockPos3.offset(pRandom.nextInt(3) - 1, (pRandom.nextInt(3) - 1) * pRandom.nextInt(3) / 2, pRandom.nextInt(3) - 1);
                if (!pLevel.getBlockState(blockPos3.below()).is(this) || pLevel.getBlockState(blockPos3).isCollisionShapeFullBlock(pLevel, blockPos3)) {
                    continue label49;
                }
            }

            BlockState blockState3 = pLevel.getBlockState(blockPos3);
            if (blockState3.is(blockState2.getBlock()) && pRandom.nextInt(10) == 0) {
                ((BonemealableBlock)blockState2.getBlock()).performBonemeal(pLevel, pRandom, blockPos3, blockState3);
            }

            if (blockState3.isAir()) {
                Holder<PlacedFeature> holder;
                if (pRandom.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = pLevel.getBiome(blockPos3).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    holder = ((RandomPatchConfiguration) list.get(0).config()).feature();
                } else {
                    if (optional.isEmpty()) {
                        continue;
                    }

                    holder = optional.get();
                }

                holder.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, blockPos3);
            }
        }
    }
}
