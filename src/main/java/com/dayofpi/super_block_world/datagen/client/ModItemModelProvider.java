package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockItem(ModBlocks.FLAGPOLE);
        simpleItem(ModItems.WHITE_FLAG);
        simpleItem(ModItems.LIGHT_GRAY_FLAG);
        simpleItem(ModItems.GRAY_FLAG);
        simpleItem(ModItems.BLACK_FLAG);
        simpleItem(ModItems.BROWN_FLAG);
        simpleItem(ModItems.RED_FLAG);
        simpleItem(ModItems.ORANGE_FLAG);
        simpleItem(ModItems.YELLOW_FLAG);
        simpleItem(ModItems.LIME_FLAG);
        simpleItem(ModItems.GREEN_FLAG);
        simpleItem(ModItems.CYAN_FLAG);
        simpleItem(ModItems.LIGHT_BLUE_FLAG);
        simpleItem(ModItems.BLUE_FLAG);
        simpleItem(ModItems.PURPLE_FLAG);
        simpleItem(ModItems.MAGENTA_FLAG);
        simpleItem(ModItems.PINK_FLAG);
        simpleItem(ModItems.RAINBOW_FLAG);
        blockItem(ModBlocks.WHITE_WARP_PIPE);
        blockItem(ModBlocks.LIGHT_GRAY_WARP_PIPE);
        blockItem(ModBlocks.GRAY_WARP_PIPE);
        blockItem(ModBlocks.BLACK_WARP_PIPE);
        blockItem(ModBlocks.BROWN_WARP_PIPE);
        blockItem(ModBlocks.RED_WARP_PIPE);
        blockItem(ModBlocks.ORANGE_WARP_PIPE);
        blockItem(ModBlocks.YELLOW_WARP_PIPE);
        blockItem(ModBlocks.LIME_WARP_PIPE);
        blockItem(ModBlocks.GREEN_WARP_PIPE);
        blockItem(ModBlocks.CYAN_WARP_PIPE);
        blockItem(ModBlocks.LIGHT_BLUE_WARP_PIPE);
        blockItem(ModBlocks.BLUE_WARP_PIPE);
        blockItem(ModBlocks.PURPLE_WARP_PIPE);
        blockItem(ModBlocks.MAGENTA_WARP_PIPE);
        blockItem(ModBlocks.PINK_WARP_PIPE);
        blockItem(ModBlocks.WHITE_PIPE_BODY);
        blockItem(ModBlocks.LIGHT_GRAY_PIPE_BODY);
        blockItem(ModBlocks.GRAY_PIPE_BODY);
        blockItem(ModBlocks.BLACK_PIPE_BODY);
        blockItem(ModBlocks.BROWN_PIPE_BODY);
        blockItem(ModBlocks.RED_PIPE_BODY);
        blockItem(ModBlocks.ORANGE_PIPE_BODY);
        blockItem(ModBlocks.YELLOW_PIPE_BODY);
        blockItem(ModBlocks.LIME_PIPE_BODY);
        blockItem(ModBlocks.GREEN_PIPE_BODY);
        blockItem(ModBlocks.CYAN_PIPE_BODY);
        blockItem(ModBlocks.LIGHT_BLUE_PIPE_BODY);
        blockItem(ModBlocks.BLUE_PIPE_BODY);
        blockItem(ModBlocks.PURPLE_PIPE_BODY);
        blockItem(ModBlocks.MAGENTA_PIPE_BODY);
        blockItem(ModBlocks.PINK_PIPE_BODY);
        blockItem(ModBlocks.TOADSTOOL_GRASS);
        blockItem(ModBlocks.TOADSTOOL_PATH);
        blockItem(ModBlocks.BRONZE_STAIRS);
        blockItem(ModBlocks.BRONZE_SLAB);
        blockItem(ModBlocks.VANILLATE_STAIRS);
        blockItem(ModBlocks.VANILLATE_SLAB);
        wallItem(ModBlocks.VANILLATE_WALL, ModBlocks.VANILLATE);
        blockItem(ModBlocks.VANILLATE_BRICK_STAIRS);
        blockItem(ModBlocks.VANILLATE_BRICK_SLAB);
        wallItem(ModBlocks.VANILLATE_BRICK_WALL, ModBlocks.VANILLATE_BRICKS);
        blockItem(ModBlocks.VANILLATE_TILE_STAIRS);
        blockItem(ModBlocks.VANILLATE_TILE_SLAB);
        wallItem(ModBlocks.VANILLATE_TILE_WALL, ModBlocks.VANILLATE_TILES);
        blockItem(ModBlocks.TOADSTONE_STAIRS);
        blockItem(ModBlocks.TOADSTONE_SLAB);
        wallItem(ModBlocks.TOADSTONE_WALL, ModBlocks.TOADSTONE);
        blockItem(ModBlocks.TOADSTONE_BRICK_STAIRS);
        blockItem(ModBlocks.TOADSTONE_BRICK_SLAB);
        wallItem(ModBlocks.TOADSTONE_BRICK_WALL, ModBlocks.TOADSTONE_BRICKS);
        blockItem(ModBlocks.SMOOTH_TOADSTONE_STAIRS);
        blockItem(ModBlocks.SMOOTH_TOADSTONE_SLAB);
        blockItem(ModBlocks.HARDSTONE_STAIRS);
        blockItem(ModBlocks.HARDSTONE_SLAB);
        wallItem(ModBlocks.HARDSTONE_WALL, ModBlocks.HARDSTONE);
        blockItem(ModBlocks.HARDSTONE_BRICK_STAIRS);
        blockItem(ModBlocks.HARDSTONE_BRICK_SLAB);
        wallItem(ModBlocks.HARDSTONE_BRICK_WALL, ModBlocks.HARDSTONE_BRICKS);
        blockItem(ModBlocks.SMOOTH_HARDSTONE_STAIRS);
        blockItem(ModBlocks.SMOOTH_HARDSTONE_SLAB);
        blockItem(ModBlocks.CLOUD_STAIRS);
        blockItem(ModBlocks.CLOUD_SLAB);
        blockItem(ModBlocks.RAINBOW_TILE_STAIRS);
        blockItem(ModBlocks.RAINBOW_TILE_SLAB);
        wallItem(ModBlocks.RAINBOW_TILE_WALL, ModBlocks.RAINBOW_TILES);
        simpleItem(ModItems.POWER_STAR);
        simpleBlockItem(ModItems.STAR_CLUSTER);
        blockItem(ModBlocks.AMANITA_LOG);
        blockItem(ModBlocks.AMANITA_WOOD);
        blockItem(ModBlocks.STRIPPED_AMANITA_LOG);
        blockItem(ModBlocks.STRIPPED_AMANITA_WOOD);
        blockItem(ModBlocks.AMANITA_STAIRS);
        blockItem(ModBlocks.AMANITA_SLAB);
        simpleItem(ModItems.AMANITA_SIGN);
        simpleItem(ModItems.AMANITA_HANGING_SIGN);
        blockItem(ModBlocks.AMANITA_LEAVES);
        blockItem(ModBlocks.FRUITING_AMANITA_LEAVES);
        simpleBlockItem(ModItems.AMANITA_SAPLING);
        simpleBlockItem(ModItems.WHITE_FLOWERBED);
        simpleBlockItem(ModItems.YELLOW_FLOWERBED);
        simpleItem(ModItems.WARP_PAINTING);
        simpleItem(ModItems.AMANITA_BOAT);
        simpleItem(ModItems.AMANITA_CHEST_BOAT);
        simpleItem(ModItems.YOSHI_FRUIT);
        simpleItem(ModItems.YOSHI_COOKIE);
        simpleItem(ModItems.RAW_BRONZE);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.POWER_SHARD);
        simpleItem(ModItems.YELLOW_STAR_BIT);
        simpleItem(ModItems.GREEN_STAR_BIT);
        simpleItem(ModItems.BLUE_STAR_BIT);
        simpleItem(ModItems.PURPLE_STAR_BIT);
        simpleItem(ModItems.SUBCON_THREAD);
        withExistingParent(ModItems.SHY_GUY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(SuperBlockWorld.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void simpleBlockItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + item.getId().getPath()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory")).texture("wall",  new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
