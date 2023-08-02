package com.dayofpi.super_block_world.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.RegistryObject;

public class WarpPipeFeature extends Feature<NoneFeatureConfiguration> {
    public WarpPipeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    public static BlockState createPipeState(RegistryObject<Block> block, boolean waterlogged) {
        return block.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, waterlogged);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        return false;
    }
}
