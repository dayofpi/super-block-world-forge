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
        flagItem(ModItems.WHITE_FLAG);
        flagItem(ModItems.LIGHT_GRAY_FLAG);
        flagItem(ModItems.GRAY_FLAG);
        flagItem(ModItems.BLACK_FLAG);
        flagItem(ModItems.BROWN_FLAG);
        flagItem(ModItems.RED_FLAG);
        flagItem(ModItems.ORANGE_FLAG);
        flagItem(ModItems.YELLOW_FLAG);
        flagItem(ModItems.LIME_FLAG);
        flagItem(ModItems.GREEN_FLAG);
        flagItem(ModItems.CYAN_FLAG);
        flagItem(ModItems.LIGHT_BLUE_FLAG);
        flagItem(ModItems.BLUE_FLAG);
        flagItem(ModItems.PURPLE_FLAG);
        flagItem(ModItems.MAGENTA_FLAG);
        flagItem(ModItems.PINK_FLAG);
        flagItem(ModItems.RAINBOW_FLAG);
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
        blockItem(ModBlocks.TOADSTOOL_TURF);
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
        blockItem(ModBlocks.HARDSTONE_PILLAR);
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
        fenceItem(ModBlocks.AMANITA_FENCE, ModBlocks.AMANITA_PLANKS);
        blockItem(ModBlocks.AMANITA_FENCE_GATE);
        blockItem(ModBlocks.AMANITA_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.AMANITA_PRESSURE_PLATE);
        buttonItem(ModBlocks.AMANITA_BUTTON, ModBlocks.AMANITA_PLANKS);
        simpleItem(ModItems.AMANITA_DOOR);
        simpleItem(ModItems.AMANITA_SIGN);
        simpleItem(ModItems.AMANITA_HANGING_SIGN);
        blockItem(ModBlocks.AMANITA_LEAVES);
        blockItem(ModBlocks.FRUITING_AMANITA_LEAVES);
        simpleBlockItem(ModItems.AMANITA_SAPLING);
        blockItem(ModBlocks.MAYOI_LOG);
        blockItem(ModBlocks.MAYOI_WOOD);
        blockItem(ModBlocks.STRIPPED_MAYOI_LOG);
        blockItem(ModBlocks.STRIPPED_MAYOI_WOOD);
        blockItem(ModBlocks.MAYOI_STAIRS);
        blockItem(ModBlocks.MAYOI_SLAB);
        fenceItem(ModBlocks.MAYOI_FENCE, ModBlocks.MAYOI_PLANKS);
        blockItem(ModBlocks.MAYOI_FENCE_GATE);
        blockItem(ModBlocks.MAYOI_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.MAYOI_PRESSURE_PLATE);
        buttonItem(ModBlocks.MAYOI_BUTTON, ModBlocks.MAYOI_PLANKS);
        simpleItem(ModItems.MAYOI_DOOR);
        simpleItem(ModItems.MAYOI_SIGN);
        simpleItem(ModItems.MAYOI_HANGING_SIGN);
        blockItem(ModBlocks.MAYOI_LEAVES);
        blockItem(ModBlocks.FRUITING_MAYOI_LEAVES);
        simpleBlockItem(ModItems.MAYOI_SAPLING);
        blockItem(ModBlocks.BROWN_TOAD_STOOL);
        blockItem(ModBlocks.RED_TOAD_STOOL);
        simpleBlockItem(ModItems.RED_GRASS);
        simpleBlockItem(ModItems.SUBCON_PALM);
        simpleBlockItem(ModItems.BEANSTALK);
        simpleBlockItem(ModItems.WHITE_FLOWERBED);
        simpleBlockItem(ModItems.YELLOW_FLOWERBED);
        simpleItem(ModItems.WARP_PAINTING);
        simpleItem(ModItems.LAUNCH_STAR);
        simpleItem(ModItems.AMANITA_BOAT);
        simpleItem(ModItems.AMANITA_CHEST_BOAT);
        simpleItem(ModItems.MAYOI_BOAT);
        simpleItem(ModItems.MAYOI_CHEST_BOAT);
        simpleItem(ModItems.TURNIP);
        simpleItem(ModItems.BOMB);
        simpleItem(ModItems.YOSHI_FRUIT);
        simpleItem(ModItems.YOSHI_COOKIE);
        simpleItem(ModItems.RAW_BRONZE);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.POWER_SHARD);
        simpleItem(ModItems.COIN);
        simpleItem(ModItems.STAR_COIN);
        simpleItem(ModItems.YELLOW_STAR_BIT);
        simpleItem(ModItems.RED_STAR_BIT);
        simpleItem(ModItems.BLUE_STAR_BIT);
        simpleItem(ModItems.PURPLE_STAR_BIT);
        simpleItem(ModItems.RAINBOW_STAR_BIT);
        simpleItem(ModItems.SUBCON_THREAD);
        spawnEggItem(ModItems.SHY_GUY_SPAWN_EGG);
        spawnEggItem(ModItems.LUMA_SPAWN_EGG);
        spawnEggItem(ModItems.HUNGRY_LUMA_SPAWN_EGG);
        spawnEggItem(ModItems.BOOM_BOOM_SPAWN_EGG);
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

    private void blockItem(RegistryObject<Block> blockRegistryObject, String suffix) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + suffix));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory")).texture("wall",  new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory")).texture("texture",  new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory")).texture("texture",  new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void flagItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation(SuperBlockWorld.MOD_ID, "item/template_flag"));
    }

    public void spawnEggItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
