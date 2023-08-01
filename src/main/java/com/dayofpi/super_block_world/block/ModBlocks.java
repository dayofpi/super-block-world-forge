package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.custom.FlowerbedBlock;
import com.dayofpi.super_block_world.block.custom.PowerStarBlock;
import com.dayofpi.super_block_world.sound.ModSoundTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Block> POWER_STAR = BLOCKS.register("power_star", () -> new PowerStarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(value -> 5).instabreak().noCollission().noOcclusion()));
    public static final RegistryObject<Block> VANILLATE = BLOCKS.register("vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> TOPPED_VANILLATE = BLOCKS.register("topped_vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> VANILLATE_CRUMBLE = BLOCKS.register("vanillate_crumble", () -> new SandBlock(12176828, BlockBehaviour.Properties.copy(VANILLATE.get()).strength(1.0F)));
    public static final RegistryObject<Block> VANILLATE_BRICKS = BLOCKS.register("vanillate_bricks", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_TILES = BLOCKS.register("vanillate_tiles", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> TOADSTONE = BLOCKS.register("toadstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> TOADSTONE_BRICKS = BLOCKS.register("toadstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE = BLOCKS.register("smooth_toadstone", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE = BLOCKS.register("hardstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.COLOR_LIGHT_GRAY).strength(6.0F, 200.0F)));
    public static final RegistryObject<Block> HARDSTONE_BRICKS = BLOCKS.register("hardstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE = BLOCKS.register("smooth_hardstone", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> PACKED_CLOUD = BLOCKS.register("packed_cloud", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.25F).sound(SoundType.POWDER_SNOW)));
    public static final RegistryObject<Block> RAINBOW_TILES = BLOCKS.register("rainbow_tiles", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STAR_CLUSTER = BLOCKS.register("star_cluster", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(value -> 10).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WHITE_FLOWERBED = BLOCKS.register("white_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_FLOWERBED = BLOCKS.register("yellow_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
}
