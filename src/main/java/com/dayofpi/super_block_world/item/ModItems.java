package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.entity.custom.ModBoatEntity;
import com.dayofpi.super_block_world.item.custom.*;
import net.minecraft.world.food.FoodProperties;
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
    public static final RegistryObject<Item> TOADSTOOL_GRASS = registerBlockItem("toadstool_grass", ModBlocks.TOADSTOOL_GRASS);
    public static final RegistryObject<Item> TOADSTOOL_SOIL = registerBlockItem("toadstool_soil", ModBlocks.TOADSTOOL_SOIL);
    public static final RegistryObject<Item> COARSE_TOADSTOOL_SOIL = registerBlockItem("coarse_toadstool_soil", ModBlocks.COARSE_TOADSTOOL_SOIL);
    public static final RegistryObject<Item> TOADSTOOL_PATH = registerBlockItem("toadstool_path", ModBlocks.TOADSTOOL_PATH);
    public static final RegistryObject<Item> VANILLATE = registerBlockItem("vanillate", ModBlocks.VANILLATE);
    public static final RegistryObject<Item> VANILLATE_STAIRS = registerBlockItem("vanillate_stairs", ModBlocks.VANILLATE_STAIRS);
    public static final RegistryObject<Item> VANILLATE_SLAB = registerBlockItem("vanillate_slab", ModBlocks.VANILLATE_SLAB);
    public static final RegistryObject<Item> VANILLATE_WALL = registerBlockItem("vanillate_wall", ModBlocks.VANILLATE_WALL);
    public static final RegistryObject<Item> TOPPED_VANILLATE = registerBlockItem("topped_vanillate", ModBlocks.TOPPED_VANILLATE);
    public static final RegistryObject<Item> VANILLATE_CRUMBLE = registerBlockItem("vanillate_crumble", ModBlocks.VANILLATE_CRUMBLE);
    public static final RegistryObject<Item> VANILLATE_BRICKS = registerBlockItem("vanillate_bricks", ModBlocks.VANILLATE_BRICKS);
    public static final RegistryObject<Item> VANILLATE_BRICK_STAIRS = registerBlockItem("vanillate_brick_stairs", ModBlocks.VANILLATE_BRICK_STAIRS);
    public static final RegistryObject<Item> VANILLATE_BRICK_SLAB = registerBlockItem("vanillate_brick_slab", ModBlocks.VANILLATE_BRICK_SLAB);
    public static final RegistryObject<Item> VANILLATE_BRICK_WALL = registerBlockItem("vanillate_brick_wall", ModBlocks.VANILLATE_BRICK_WALL);
    public static final RegistryObject<Item> VANILLATE_TILES = registerBlockItem("vanillate_tiles", ModBlocks.VANILLATE_TILES);
    public static final RegistryObject<Item> VANILLATE_TILE_STAIRS = registerBlockItem("vanillate_tile_stairs", ModBlocks.VANILLATE_TILE_STAIRS);
    public static final RegistryObject<Item> VANILLATE_TILE_SLAB = registerBlockItem("vanillate_tile_slab", ModBlocks.VANILLATE_TILE_SLAB);
    public static final RegistryObject<Item> VANILLATE_TILE_WALL = registerBlockItem("vanillate_tile_wall", ModBlocks.VANILLATE_TILE_WALL);
    public static final RegistryObject<Item> TOADSTONE = registerBlockItem("toadstone", ModBlocks.TOADSTONE);
    public static final RegistryObject<Item> TOADSTONE_BRICKS = registerBlockItem("toadstone_bricks", ModBlocks.TOADSTONE_BRICKS);
    public static final RegistryObject<Item> SMOOTH_TOADSTONE = registerBlockItem("smooth_toadstone", ModBlocks.SMOOTH_TOADSTONE);
    public static final RegistryObject<Item> SMOOTH_TOADSTONE_STAIRS = registerBlockItem("smooth_toadstone_stairs", ModBlocks.SMOOTH_TOADSTONE_STAIRS);
    public static final RegistryObject<Item> SMOOTH_TOADSTONE_SLAB = registerBlockItem("smooth_toadstone_slab", ModBlocks.SMOOTH_TOADSTONE_SLAB);
    public static final RegistryObject<Item> HARDSTONE = registerBlockItem("hardstone", ModBlocks.HARDSTONE);
    public static final RegistryObject<Item> HARDSTONE_BRICKS = registerBlockItem("hardstone_bricks", ModBlocks.HARDSTONE_BRICKS);
    public static final RegistryObject<Item> SMOOTH_HARDSTONE = registerBlockItem("smooth_hardstone", ModBlocks.SMOOTH_HARDSTONE);
    public static final RegistryObject<Item> SMOOTH_HARDSTONE_STAIRS = registerBlockItem("smooth_hardstone_stairs", ModBlocks.SMOOTH_HARDSTONE_STAIRS);
    public static final RegistryObject<Item> SMOOTH_HARDSTONE_SLAB = registerBlockItem("smooth_hardstone_slab", ModBlocks.SMOOTH_HARDSTONE_SLAB);
    public static final RegistryObject<Item> PACKED_CLOUD = registerBlockItem("packed_cloud", ModBlocks.PACKED_CLOUD);
    public static final RegistryObject<Item> CLOUD_STAIRS = registerBlockItem("cloud_stairs", ModBlocks.CLOUD_STAIRS);
    public static final RegistryObject<Item> CLOUD_SLAB = registerBlockItem("cloud_slab", ModBlocks.CLOUD_SLAB);
    public static final RegistryObject<Item> RAINBOW_TILES = registerBlockItem("rainbow_tiles", ModBlocks.RAINBOW_TILES);
    public static final RegistryObject<Item> RAINBOW_TILE_STAIRS = registerBlockItem("rainbow_tile_stairs", ModBlocks.RAINBOW_TILE_STAIRS);
    public static final RegistryObject<Item> RAINBOW_TILE_SLAB = registerBlockItem("rainbow_tile_slab", ModBlocks.RAINBOW_TILE_SLAB);
    public static final RegistryObject<Item> RAINBOW_TILE_WALL = registerBlockItem("rainbow_tile_wall", ModBlocks.RAINBOW_TILE_WALL);
    public static final RegistryObject<Item> STAR_CLUSTER = registerBlockItem("star_cluster", ModBlocks.STAR_CLUSTER);
    public static final RegistryObject<Item> AMANITA_LOG = registerBlockItem("amanita_log", ModBlocks.AMANITA_LOG);
    public static final RegistryObject<Item> AMANITA_PLANKS = registerBlockItem("amanita_planks", ModBlocks.AMANITA_PLANKS);
    public static final RegistryObject<Item> AMANITA_LEAVES = registerBlockItem("amanita_leaves", ModBlocks.AMANITA_LEAVES);
    public static final RegistryObject<Item> FRUITING_AMANITA_LEAVES = registerBlockItem("fruiting_amanita_leaves", ModBlocks.FRUITING_AMANITA_LEAVES);
    public static final RegistryObject<Item> AMANITA_SAPLING = registerBlockItem("amanita_sapling", ModBlocks.AMANITA_SAPLING);
    public static final RegistryObject<Item> WHITE_FLOWERBED = registerBlockItem("white_flowerbed", ModBlocks.WHITE_FLOWERBED);
    public static final RegistryObject<Item> YELLOW_FLOWERBED = registerBlockItem("yellow_flowerbed", ModBlocks.YELLOW_FLOWERBED);
    public static final RegistryObject<Item> WARP_PAINTING = ITEMS.register("warp_painting", () -> new WarpPaintingItem(new Item.Properties()));
    public static final RegistryObject<Item> AMANITA_BOAT = ITEMS.register("amanita_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.AMANITA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AMANITA_CHEST_BOAT = ITEMS.register("amanita_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.AMANITA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().durability(131)));
    public static final RegistryObject<Item> SUPER_PICKAXE = ITEMS.register("super_pickaxe", () -> new SuperPickaxeItem(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> YOSHI_FRUIT = ITEMS.register("yoshi_fruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> YOSHI_COOKIE = ITEMS.register("yoshi_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build())));
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
