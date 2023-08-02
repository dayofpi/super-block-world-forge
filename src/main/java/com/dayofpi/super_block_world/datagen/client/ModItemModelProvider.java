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
        blockItem(ModBlocks.TOADSTOOL_GRASS);
        blockItem(ModBlocks.TOADSTOOL_PATH);
        blockItem(ModBlocks.VANILLATE_STAIRS);
        blockItem(ModBlocks.VANILLATE_SLAB);
        wallItem(ModBlocks.VANILLATE_WALL, ModBlocks.VANILLATE);
        blockItem(ModBlocks.VANILLATE_BRICK_STAIRS);
        blockItem(ModBlocks.VANILLATE_BRICK_SLAB);
        wallItem(ModBlocks.VANILLATE_BRICK_WALL, ModBlocks.VANILLATE_BRICKS);
        blockItem(ModBlocks.VANILLATE_TILE_STAIRS);
        blockItem(ModBlocks.VANILLATE_TILE_SLAB);
        wallItem(ModBlocks.VANILLATE_TILE_WALL, ModBlocks.VANILLATE_TILES);
        blockItem(ModBlocks.SMOOTH_TOADSTONE_STAIRS);
        blockItem(ModBlocks.SMOOTH_TOADSTONE_SLAB);
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
