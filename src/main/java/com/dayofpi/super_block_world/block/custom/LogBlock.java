package com.dayofpi.super_block_world.block.custom;

import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlock extends RotatedPillarBlock {
    //private static final ImmutableMap<RegistryObject<Block>, RegistryObject<Block>> STRIPPABLES = new ImmutableMap.Builder<RegistryObject<Block>, RegistryObject<Block>>().put(ModBlocks.AMANITA_LOG, ModBlocks.STRIPPED_AMANITA_LOG).put(ModBlocks.AMANITA_WOOD, ModBlocks.STRIPPED_AMANITA_WOOD).put(ModBlocks.DARK_AMANITA_LOG, ModBlocks.STRIPPED_DARK_AMANITA_LOG).put(ModBlocks.DARK_AMANITA_WOOD, ModBlocks.STRIPPED_DARK_AMANITA_WOOD).put(ModBlocks.BELL_LOG, ModBlocks.STRIPPED_BELL_LOG).put(ModBlocks.BELL_WOOD, ModBlocks.STRIPPED_BELL_WOOD).build();
    public LogBlock(Properties pProperties) {
        super(pProperties);
    }

    /*
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

     */
}
