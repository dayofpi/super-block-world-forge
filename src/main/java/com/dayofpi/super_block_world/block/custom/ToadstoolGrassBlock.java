package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class ToadstoolGrassBlock extends ModSpreadingBlock {
    public ToadstoolGrassBlock(Properties pProperties) {
        super(ModBlocks.TOADSTOOL_SOIL, pProperties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.HOE_TILL)
            return Blocks.FARMLAND.defaultBlockState();
        else if (toolAction == ToolActions.SHOVEL_FLATTEN)
            return ModBlocks.TOADSTOOL_PATH.get().defaultBlockState();
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
