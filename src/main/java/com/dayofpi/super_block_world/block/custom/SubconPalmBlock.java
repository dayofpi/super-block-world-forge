package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;

public class SubconPalmBlock extends GrowingPlantHeadBlock {
    public SubconPalmBlock(Properties pProperties) {
        super(pProperties, Direction.UP, Shapes.block(), false, 0.0);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource pRandom) {
        return NetherVines.getBlocksToGrowWhenBonemealed(pRandom);
    }

    @Override
    protected boolean canGrowInto(BlockState pState) {
        return NetherVines.isValidGrowthState(pState);
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.SUBCON_PALM_STEM.get();
    }
}
