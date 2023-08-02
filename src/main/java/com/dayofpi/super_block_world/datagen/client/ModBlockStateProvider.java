package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.TOADSTOOL_SOIL.get(), models().cubeColumn(name(ModBlocks.TOADSTOOL_SOIL.get()), blockTexture(ModBlocks.TOADSTOOL_SOIL.get()), extend(blockTexture(ModBlocks.TOADSTOOL_SOIL.get()), "_top")));
        simpleBlockWithItem(ModBlocks.COARSE_TOADSTOOL_SOIL.get(), models().cubeColumn(name(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), blockTexture(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), extend(blockTexture(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), "_top")));
        simpleBlockWithItem(ModBlocks.VANILLATE);
        simpleBlockWithItem(ModBlocks.TOPPED_VANILLATE.get(), models().cubeBottomTop(name(ModBlocks.TOPPED_VANILLATE.get()), blockTexture(ModBlocks.TOPPED_VANILLATE.get()), blockTexture(ModBlocks.VANILLATE.get()), extend(blockTexture(ModBlocks.TOPPED_VANILLATE.get()), "_top")));
        simpleBlockWithItem(ModBlocks.VANILLATE_CRUMBLE);
        simpleBlockWithItem(ModBlocks.VANILLATE_BRICKS);
        simpleBlockWithItem(ModBlocks.VANILLATE_TILES);
        simpleBlockWithItem(ModBlocks.TOADSTONE);
        simpleBlockWithItem(ModBlocks.TOADSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.SMOOTH_TOADSTONE);
        simpleBlockWithItem(ModBlocks.HARDSTONE);
        simpleBlockWithItem(ModBlocks.HARDSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.SMOOTH_HARDSTONE);
        simpleBlockWithItem(ModBlocks.PACKED_CLOUD);
        simpleBlockWithItem(ModBlocks.RAINBOW_TILES);
        simpleBlockWithItem(ModBlocks.AMANITA_PLANKS);
        cross(ModBlocks.AMANITA_SAPLING);
        simpleBlock(ModBlocks.WHITE_FLOWERBED.get(), models().carpet("white_flowerbed", blockTexture(ModBlocks.WHITE_FLOWERBED.get())).renderType("cutout"));
        simpleBlock(ModBlocks.YELLOW_FLOWERBED.get(), models().carpet("yellow_flowerbed", blockTexture(ModBlocks.YELLOW_FLOWERBED.get())).renderType("cutout"));

        logBlock((RotatedPillarBlock) ModBlocks.AMANITA_LOG.get());

        stairsBlock((StairBlock) ModBlocks.VANILLATE_STAIRS.get(), blockTexture(ModBlocks.VANILLATE.get()));
        stairsBlock((StairBlock) ModBlocks.VANILLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.VANILLATE_TILE_STAIRS.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        stairsBlock((StairBlock) ModBlocks.SMOOTH_TOADSTONE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.HARDSTONE_STAIRS.get(), blockTexture(ModBlocks.HARDSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.SMOOTH_HARDSTONE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.CLOUD_STAIRS.get(), blockTexture(ModBlocks.PACKED_CLOUD.get()));
        stairsBlock((StairBlock) ModBlocks.RAINBOW_TILE_STAIRS.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()));

        slabBlock((SlabBlock) ModBlocks.VANILLATE_SLAB.get(), blockTexture(ModBlocks.VANILLATE.get()), blockTexture(ModBlocks.VANILLATE.get()));
        slabBlock((SlabBlock) ModBlocks.VANILLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.VANILLATE_TILE_SLAB.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        slabBlock((SlabBlock) ModBlocks.SMOOTH_TOADSTONE_SLAB.get(), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.HARDSTONE_SLAB.get(), blockTexture(ModBlocks.HARDSTONE.get()), blockTexture(ModBlocks.HARDSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.SMOOTH_HARDSTONE_SLAB.get(), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.CLOUD_SLAB.get(), blockTexture(ModBlocks.PACKED_CLOUD.get()), blockTexture(ModBlocks.PACKED_CLOUD.get()));
        slabBlock((SlabBlock) ModBlocks.RAINBOW_TILE_SLAB.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()), blockTexture(ModBlocks.RAINBOW_TILES.get()));

        wallBlock((WallBlock) ModBlocks.VANILLATE_WALL.get(), blockTexture(ModBlocks.VANILLATE.get()));
        wallBlock((WallBlock) ModBlocks.VANILLATE_BRICK_WALL.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.VANILLATE_TILE_WALL.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        wallBlock((WallBlock) ModBlocks.HARDSTONE_WALL.get(), blockTexture(ModBlocks.HARDSTONE.get()));
        wallBlock((WallBlock) ModBlocks.RAINBOW_TILE_WALL.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()));
    }

    private void simpleBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void cross(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().cross(blockTexture(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private ResourceLocation extend(ResourceLocation location, String suffix) {
        return new ResourceLocation(location.getNamespace(), location.getPath() + suffix);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
