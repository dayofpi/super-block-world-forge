package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
        simpleBlock(ModBlocks.WHITE_FLOWERBED.get(), models().carpet("white_flowerbed", blockTexture(ModBlocks.WHITE_FLOWERBED.get())).renderType("cutout"));
        simpleBlock(ModBlocks.YELLOW_FLOWERBED.get(), models().carpet("yellow_flowerbed", blockTexture(ModBlocks.YELLOW_FLOWERBED.get())).renderType("cutout"));
    }

    private void simpleBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
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
