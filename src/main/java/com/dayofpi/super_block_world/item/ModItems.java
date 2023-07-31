package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.custom.HammerItem;
import com.dayofpi.super_block_world.item.custom.PowerStarItem;
import com.dayofpi.super_block_world.item.custom.SuperPickaxeItem;
import com.dayofpi.super_block_world.item.custom.WarpPaintingItem;
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

    public static final RegistryObject<Item> POWER_STAR = ITEMS.register("power_star", () -> new PowerStarItem(ModBlocks.POWER_STAR.get(), new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> VANILLATE = registerBlockItem("vanillate", ModBlocks.VANILLATE);
    public static final RegistryObject<Item> TOPPED_VANILLATE = registerBlockItem("topped_vanillate", ModBlocks.TOPPED_VANILLATE);
    public static final RegistryObject<Item> VANILLATE_CRUMBLE = registerBlockItem("vanillate_crumble", ModBlocks.VANILLATE_CRUMBLE);
    public static final RegistryObject<Item> VANILLATE_BRICKS = registerBlockItem("vanillate_bricks", ModBlocks.VANILLATE_BRICKS);
    public static final RegistryObject<Item> VANILLATE_TILES = registerBlockItem("vanillate_tiles", ModBlocks.VANILLATE_TILES);
    public static final RegistryObject<Item> TOADSTONE = registerBlockItem("toadstone", ModBlocks.TOADSTONE);
    public static final RegistryObject<Item> TOADSTONE_BRICKS = registerBlockItem("toadstone_bricks", ModBlocks.TOADSTONE_BRICKS);
    public static final RegistryObject<Item> SMOOTH_TOADSTONE = registerBlockItem("smooth_toadstone", ModBlocks.SMOOTH_TOADSTONE);
    public static final RegistryObject<Item> HARDSTONE = registerBlockItem("hardstone", ModBlocks.HARDSTONE);
    public static final RegistryObject<Item> HARDSTONE_BRICKS = registerBlockItem("hardstone_bricks", ModBlocks.HARDSTONE_BRICKS);
    public static final RegistryObject<Item> SMOOTH_HARDSTONE = registerBlockItem("smooth_hardstone", ModBlocks.SMOOTH_HARDSTONE);
    public static final RegistryObject<Item> STAR_CLUSTER = registerBlockItem("star_cluster", ModBlocks.STAR_CLUSTER);
    public static final RegistryObject<Item> WHITE_FLOWERBED = registerBlockItem("white_flowerbed", ModBlocks.WHITE_FLOWERBED);
    public static final RegistryObject<Item> YELLOW_FLOWERBED = registerBlockItem("yellow_flowerbed", ModBlocks.YELLOW_FLOWERBED);
    public static final RegistryObject<Item> WARP_PAINTING = ITEMS.register("warp_painting", () -> new WarpPaintingItem(new Item.Properties()));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().durability(131)));
    public static final RegistryObject<Item> SUPER_PICKAXE = ITEMS.register("super_pickaxe", () -> new SuperPickaxeItem(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAW_BRONZE = ITEMS.register("raw_bronze", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWER_SHARD = ITEMS.register("power_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_STAR_BIT = ITEMS.register("yellow_star_bit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_STAR_BIT = ITEMS.register("green_star_bit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_STAR_BIT = ITEMS.register("blue_star_bit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_STAR_BIT = ITEMS.register("purple_star_bit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUBCON_THREAD = ITEMS.register("subcon_thread", () -> new Item(new Item.Properties()));

    private static RegistryObject<Item> registerBlockItem(String name, Supplier<Block> blockSupplier) {
        return ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }
}
