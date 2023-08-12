package com.dayofpi.super_block_world.item.custom;

import com.dayofpi.super_block_world.util.ModBEWLR;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class CustomRendererItem extends BlockItem {
    public CustomRendererItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(ClientItemExtensions.INSTANCE);
    }

    static class ClientItemExtensions implements IClientItemExtensions {
        private static final ClientItemExtensions INSTANCE = new ClientItemExtensions();

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return ModBEWLR.INSTANCE;
        }
    }
}
