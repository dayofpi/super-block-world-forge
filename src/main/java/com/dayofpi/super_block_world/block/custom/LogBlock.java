package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Optional;

public class LogBlock extends RotatedPillarBlock {
    private static final ImmutableMap<RegistryObject<Block>, RegistryObject<Block>> STRIPPABLES = new ImmutableMap.Builder<RegistryObject<Block>, RegistryObject<Block>>().put(ModBlocks.AMANITA_LOG, ModBlocks.STRIPPED_AMANITA_LOG).put(ModBlocks.AMANITA_WOOD, ModBlocks.STRIPPED_AMANITA_WOOD).build();
    public LogBlock(Properties pProperties) {
        super(pProperties);
    }


    @Nullable
    public static BlockState getAxeStrippingState(BlockState originalState) {
        Optional<RegistryObject<Block>> optional = ModBlocks.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() == originalState.getBlock()).findFirst();
        RegistryObject<Block> block = optional.map(STRIPPABLES::get).orElse(null);
        return block != null ? block.get().defaultBlockState().setValue(AXIS, originalState.getValue(AXIS)) : null;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return getAxeStrippingState(state);
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

}
