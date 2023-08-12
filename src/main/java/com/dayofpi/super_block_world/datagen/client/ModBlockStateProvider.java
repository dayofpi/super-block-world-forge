package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.WHITE_BRONZE);
        simpleBlockWithItem(ModBlocks.LIGHT_GRAY_BRONZE);
        simpleBlockWithItem(ModBlocks.GRAY_BRONZE);
        simpleBlockWithItem(ModBlocks.BLACK_BRONZE);
        simpleBlockWithItem(ModBlocks.BROWN_BRONZE);
        simpleBlockWithItem(ModBlocks.RED_BRONZE);
        simpleBlockWithItem(ModBlocks.ORANGE_BRONZE);
        simpleBlockWithItem(ModBlocks.YELLOW_BRONZE);
        simpleBlockWithItem(ModBlocks.LIME_BRONZE);
        simpleBlockWithItem(ModBlocks.GREEN_BRONZE);
        simpleBlockWithItem(ModBlocks.CYAN_BRONZE);
        simpleBlockWithItem(ModBlocks.LIGHT_BLUE_BRONZE);
        simpleBlockWithItem(ModBlocks.BLUE_BRONZE);
        simpleBlockWithItem(ModBlocks.PURPLE_BRONZE);
        simpleBlockWithItem(ModBlocks.MAGENTA_BRONZE);
        simpleBlockWithItem(ModBlocks.PINK_BRONZE);
        simpleBlockWithItem(ModBlocks.TOADSTOOL_SOIL.get(), models().cubeColumn(name(ModBlocks.TOADSTOOL_SOIL.get()), blockTexture(ModBlocks.TOADSTOOL_SOIL.get()), extend(blockTexture(ModBlocks.TOADSTOOL_SOIL.get()), "_top")));
        simpleBlockWithItem(ModBlocks.COARSE_TOADSTOOL_SOIL.get(), models().cubeColumn(name(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), blockTexture(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), extend(blockTexture(ModBlocks.COARSE_TOADSTOOL_SOIL.get()), "_top")));
        simpleBlockWithItem(ModBlocks.BRONZE_ORE);
        simpleBlockWithItem(ModBlocks.RAW_BRONZE_BLOCK);
        simpleBlockWithItem(ModBlocks.BRONZE_BLOCK);
        simpleBlockWithItem(ModBlocks.VANILLATE);
        simpleBlockWithItem(ModBlocks.TOPPED_VANILLATE.get(), models().cubeBottomTop(name(ModBlocks.TOPPED_VANILLATE.get()), blockTexture(ModBlocks.TOPPED_VANILLATE.get()), blockTexture(ModBlocks.VANILLATE.get()), extend(blockTexture(ModBlocks.TOPPED_VANILLATE.get()), "_top")));
        simpleBlockWithItem(ModBlocks.VANILLATE_CRUMBLE);
        simpleBlockWithItem(ModBlocks.VANILLATE_BRICKS);
        simpleBlockWithItem(ModBlocks.VANILLATE_TILES);
        simpleBlockWithItem(ModBlocks.TOADSTONE);
        simpleBlockWithItem(ModBlocks.TOADSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.CHISELED_TOADSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.SMOOTH_TOADSTONE);
        simpleBlockWithItem(ModBlocks.HARDSTONE);
        simpleBlockWithItem(ModBlocks.CHISELED_HARDSTONE);
        simpleBlockWithItem(ModBlocks.HARDSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.CRACKED_HARDSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.CHISELED_HARDSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.SMOOTH_HARDSTONE);
        simpleBlockWithItem(ModBlocks.PACKED_CLOUD);
        simpleBlockWithItem(ModBlocks.MOON_ROCK);
        simpleBlockWithItem(ModBlocks.RAINBOW_TILES);
        simpleBlockWithItem(ModBlocks.AMANITA_PLANKS);
        cross(ModBlocks.AMANITA_SAPLING);
        simpleBlockWithItem(ModBlocks.MAYOI_PLANKS);
        cross(ModBlocks.MAYOI_SAPLING);
        cross(ModBlocks.RED_GRASS);
        cross(ModBlocks.SUBCON_PALM);
        simpleBlock(ModBlocks.WHITE_FLOWERBED.get(), models().carpet("white_flowerbed", blockTexture(ModBlocks.WHITE_FLOWERBED.get())).renderType("cutout"));
        simpleBlock(ModBlocks.YELLOW_FLOWERBED.get(), models().carpet("yellow_flowerbed", blockTexture(ModBlocks.YELLOW_FLOWERBED.get())).renderType("cutout"));

        logBlock((RotatedPillarBlock) ModBlocks.AMANITA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.AMANITA_WOOD.get(), blockTexture(ModBlocks.AMANITA_LOG.get()), blockTexture(ModBlocks.AMANITA_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AMANITA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_AMANITA_WOOD.get(), blockTexture(ModBlocks.STRIPPED_AMANITA_LOG.get()), blockTexture(ModBlocks.STRIPPED_AMANITA_LOG.get()));

        logBlock((RotatedPillarBlock) ModBlocks.MAYOI_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.MAYOI_WOOD.get(), blockTexture(ModBlocks.MAYOI_LOG.get()), blockTexture(ModBlocks.MAYOI_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAYOI_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_MAYOI_WOOD.get(), blockTexture(ModBlocks.STRIPPED_MAYOI_LOG.get()), blockTexture(ModBlocks.STRIPPED_MAYOI_LOG.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.HARDSTONE_PILLAR.get(), blockTexture(ModBlocks.HARDSTONE_PILLAR.get()));

        stairsBlock((StairBlock) ModBlocks.VANILLATE_STAIRS.get(), blockTexture(ModBlocks.VANILLATE.get()));
        stairsBlock((StairBlock) ModBlocks.VANILLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.VANILLATE_TILE_STAIRS.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        stairsBlock((StairBlock) ModBlocks.TOADSTONE_STAIRS.get(), blockTexture(ModBlocks.TOADSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.TOADSTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.TOADSTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.SMOOTH_TOADSTONE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.HARDSTONE_STAIRS.get(), blockTexture(ModBlocks.HARDSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.HARDSTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.HARDSTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.SMOOTH_HARDSTONE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()));
        stairsBlock((StairBlock) ModBlocks.CLOUD_STAIRS.get(), blockTexture(ModBlocks.PACKED_CLOUD.get()));
        stairsBlock((StairBlock) ModBlocks.RAINBOW_TILE_STAIRS.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()));
        stairsBlock((StairBlock) ModBlocks.AMANITA_STAIRS.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.MAYOI_STAIRS.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        slabBlock((SlabBlock) ModBlocks.VANILLATE_SLAB.get(), blockTexture(ModBlocks.VANILLATE.get()), blockTexture(ModBlocks.VANILLATE.get()));
        slabBlock((SlabBlock) ModBlocks.VANILLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.VANILLATE_TILE_SLAB.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        slabBlock((SlabBlock) ModBlocks.TOADSTONE_SLAB.get(), blockTexture(ModBlocks.TOADSTONE.get()), blockTexture(ModBlocks.TOADSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.TOADSTONE_BRICK_SLAB.get(), blockTexture(ModBlocks.TOADSTONE_BRICKS.get()), blockTexture(ModBlocks.TOADSTONE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.SMOOTH_TOADSTONE_SLAB.get(), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()), blockTexture(ModBlocks.SMOOTH_TOADSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.HARDSTONE_SLAB.get(), blockTexture(ModBlocks.HARDSTONE.get()), blockTexture(ModBlocks.HARDSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.HARDSTONE_BRICK_SLAB.get(), blockTexture(ModBlocks.HARDSTONE_BRICKS.get()), blockTexture(ModBlocks.HARDSTONE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.SMOOTH_HARDSTONE_SLAB.get(), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()), blockTexture(ModBlocks.SMOOTH_HARDSTONE.get()));
        slabBlock((SlabBlock) ModBlocks.CLOUD_SLAB.get(), blockTexture(ModBlocks.PACKED_CLOUD.get()), blockTexture(ModBlocks.PACKED_CLOUD.get()));
        slabBlock((SlabBlock) ModBlocks.RAINBOW_TILE_SLAB.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()), blockTexture(ModBlocks.RAINBOW_TILES.get()));
        slabBlock((SlabBlock) ModBlocks.AMANITA_SLAB.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.MAYOI_SLAB.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        wallBlock((WallBlock) ModBlocks.VANILLATE_WALL.get(), blockTexture(ModBlocks.VANILLATE.get()));
        wallBlock((WallBlock) ModBlocks.VANILLATE_BRICK_WALL.get(), blockTexture(ModBlocks.VANILLATE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.VANILLATE_TILE_WALL.get(), blockTexture(ModBlocks.VANILLATE_TILES.get()));
        wallBlock((WallBlock) ModBlocks.TOADSTONE_WALL.get(), blockTexture(ModBlocks.TOADSTONE.get()));
        wallBlock((WallBlock) ModBlocks.TOADSTONE_BRICK_WALL.get(), blockTexture(ModBlocks.TOADSTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.HARDSTONE_WALL.get(), blockTexture(ModBlocks.HARDSTONE.get()));
        wallBlock((WallBlock) ModBlocks.HARDSTONE_BRICK_WALL.get(), blockTexture(ModBlocks.HARDSTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.RAINBOW_TILE_WALL.get(), blockTexture(ModBlocks.RAINBOW_TILES.get()));

        fenceBlock((FenceBlock) ModBlocks.AMANITA_FENCE.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.MAYOI_FENCE.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        fenceGateBlock((FenceGateBlock) ModBlocks.AMANITA_FENCE_GATE.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.MAYOI_FENCE_GATE.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.AMANITA_DOOR.get(), modLoc("block/amanita_door_bottom"), modLoc("block/amanita_door_top"), "cutout");
        doorBlockWithRenderType((DoorBlock) ModBlocks.MAYOI_DOOR.get(), modLoc("block/mayoi_door_bottom"), modLoc("block/mayoi_door_top"), "cutout");

        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.AMANITA_TRAPDOOR.get(), modLoc("block/amanita_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.MAYOI_TRAPDOOR.get(), modLoc("block/mayoi_trapdoor"), true, "cutout");

        pressurePlateBlock((PressurePlateBlock) ModBlocks.AMANITA_PRESSURE_PLATE.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MAYOI_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.AMANITA_BUTTON.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.MAYOI_BUTTON.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));

        modSignBlock(ModBlocks.AMANITA_SIGN.get(), ModBlocks.AMANITA_WALL_SIGN.get(), blockTexture(ModBlocks.AMANITA_PLANKS.get()));
        modSignBlock(ModBlocks.AMANITA_HANGING_SIGN.get(), ModBlocks.AMANITA_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_AMANITA_LOG.get()));

        modSignBlock(ModBlocks.MAYOI_SIGN.get(), ModBlocks.MAYOI_WALL_SIGN.get(), blockTexture(ModBlocks.MAYOI_PLANKS.get()));
        modSignBlock(ModBlocks.MAYOI_HANGING_SIGN.get(), ModBlocks.MAYOI_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_MAYOI_LOG.get()));
    }

    public void modSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
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
