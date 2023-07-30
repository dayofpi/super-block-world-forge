package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Item> VANILLATE = registerBlockItem("vanillate", ModBlocks.VANILLATE);
    public static final RegistryObject<Item> VANILLATE_CRUMBLE = registerBlockItem("vanillate_crumble", ModBlocks.VANILLATE_CRUMBLE);

    private static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> blockSupplier) {
        return ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }
}
