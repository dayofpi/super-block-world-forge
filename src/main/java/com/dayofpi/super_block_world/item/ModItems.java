package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.custom.HammerItem;
import com.dayofpi.super_block_world.item.custom.SuperPickaxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Item> VANILLATE = registerBlockItem("vanillate", ModBlocks.VANILLATE);
    public static final RegistryObject<Item> VANILLATE_CRUMBLE = registerBlockItem("vanillate_crumble", ModBlocks.VANILLATE_CRUMBLE);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().durability(131)));
    public static final RegistryObject<Item> SUPER_PICKAXE = ITEMS.register("super_pickaxe", () -> new SuperPickaxeItem(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWER_SHARD = ITEMS.register("power_shard", () -> new Item(new Item.Properties()));

    private static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> blockSupplier) {
        return ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }
}
