package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.custom.*;
import com.dayofpi.super_block_world.sound.ModSoundTypes;
import com.dayofpi.super_block_world.worldgen.tree.AmanitaTreeGrower;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperBlockWorld.MOD_ID);

    public static final MapColor AMANITA_PLANKS_COLOR = MapColor.TERRACOTTA_YELLOW;
    public static final MapColor AMANITA_LOG_COLOR = MapColor.PODZOL;

    public static final RegistryObject<Block> POWER_STAR = BLOCKS.register("power_star", () -> new PowerStarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(value -> 5).instabreak().noCollission().noOcclusion()));
    public static final RegistryObject<Block> WHITE_WARP_PIPE = BLOCKS.register("white_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.COPPER).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_WARP_PIPE = BLOCKS.register("light_gray_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_WARP_PIPE = BLOCKS.register("gray_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_WARP_PIPE = BLOCKS.register("black_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_WARP_PIPE = BLOCKS.register("brown_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_WARP_PIPE = BLOCKS.register("red_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_WARP_PIPE = BLOCKS.register("orange_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_WARP_PIPE = BLOCKS.register("yellow_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_WARP_PIPE = BLOCKS.register("lime_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_WARP_PIPE = BLOCKS.register("green_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_WARP_PIPE = BLOCKS.register("cyan_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_WARP_PIPE = BLOCKS.register("light_blue_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_WARP_PIPE = BLOCKS.register("blue_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_WARP_PIPE = BLOCKS.register("purple_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_WARP_PIPE = BLOCKS.register("magenta_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_WARP_PIPE = BLOCKS.register("pink_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> WHITE_PIPE_BODY = BLOCKS.register("white_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.COPPER).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_PIPE_BODY = BLOCKS.register("light_gray_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_PIPE_BODY = BLOCKS.register("gray_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_PIPE_BODY = BLOCKS.register("black_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_PIPE_BODY = BLOCKS.register("brown_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_PIPE_BODY = BLOCKS.register("red_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_PIPE_BODY = BLOCKS.register("orange_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_PIPE_BODY = BLOCKS.register("yellow_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_PIPE_BODY = BLOCKS.register("lime_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_PIPE_BODY = BLOCKS.register("green_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_PIPE_BODY = BLOCKS.register("cyan_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_PIPE_BODY = BLOCKS.register("light_blue_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_PIPE_BODY = BLOCKS.register("blue_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_PIPE_BODY = BLOCKS.register("purple_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_PIPE_BODY = BLOCKS.register("magenta_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_PIPE_BODY = BLOCKS.register("pink_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> TOADSTOOL_GRASS = BLOCKS.register("toadstool_grass", () -> new ToadstoolGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> TOADSTOOL_SOIL = BLOCKS.register("toadstool_soil", () -> new ToadstoolSoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> COARSE_TOADSTOOL_SOIL = BLOCKS.register("coarse_toadstool_soil", () -> new ToadstoolSoilBlock(BlockBehaviour.Properties.copy(TOADSTOOL_SOIL.get())));
    public static final RegistryObject<Block> TOADSTOOL_PATH = BLOCKS.register("toadstool_path", () -> new ToadstoolPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));
    public static final RegistryObject<Block> VANILLATE = BLOCKS.register("vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> VANILLATE_STAIRS = BLOCKS.register("vanillate_stairs", () -> new ModStairBlock(VANILLATE));
    public static final RegistryObject<Block> VANILLATE_SLAB = BLOCKS.register("vanillate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_WALL = BLOCKS.register("vanillate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> TOPPED_VANILLATE = BLOCKS.register("topped_vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> VANILLATE_CRUMBLE = BLOCKS.register("vanillate_crumble", () -> new SandBlock(12176828, BlockBehaviour.Properties.copy(VANILLATE.get()).strength(1.0F)));
    public static final RegistryObject<Block> VANILLATE_BRICKS = BLOCKS.register("vanillate_bricks", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_BRICK_STAIRS = BLOCKS.register("vanillate_brick_stairs", () -> new ModStairBlock(VANILLATE_BRICKS));
    public static final RegistryObject<Block> VANILLATE_BRICK_SLAB = BLOCKS.register("vanillate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE_BRICKS.get())));
    public static final RegistryObject<Block> VANILLATE_BRICK_WALL = BLOCKS.register("vanillate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE_BRICKS.get())));
    public static final RegistryObject<Block> VANILLATE_TILES = BLOCKS.register("vanillate_tiles", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_TILE_STAIRS = BLOCKS.register("vanillate_tile_stairs", () -> new ModStairBlock(VANILLATE_TILES));
    public static final RegistryObject<Block> VANILLATE_TILE_SLAB = BLOCKS.register("vanillate_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE_TILES.get())));
    public static final RegistryObject<Block> VANILLATE_TILE_WALL = BLOCKS.register("vanillate_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE_TILES.get())));
    public static final RegistryObject<Block> TOADSTONE = BLOCKS.register("toadstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> TOADSTONE_BRICKS = BLOCKS.register("toadstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE = BLOCKS.register("smooth_toadstone", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE_STAIRS = BLOCKS.register("smooth_toadstone_stairs", () -> new ModStairBlock(SMOOTH_TOADSTONE));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE_SLAB = BLOCKS.register("smooth_toadstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_TOADSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE = BLOCKS.register("hardstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.COLOR_LIGHT_GRAY).strength(6.0F, 200.0F)));
    public static final RegistryObject<Block> HARDSTONE_STAIRS = BLOCKS.register("hardstone_stairs", () -> new ModStairBlock(HARDSTONE));
    public static final RegistryObject<Block> HARDSTONE_SLAB = BLOCKS.register("hardstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE_WALL = BLOCKS.register("hardstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE_BRICKS = BLOCKS.register("hardstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE = BLOCKS.register("smooth_hardstone", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE_STAIRS = BLOCKS.register("smooth_hardstone_stairs", () -> new ModStairBlock(SMOOTH_HARDSTONE));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE_SLAB = BLOCKS.register("smooth_hardstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_HARDSTONE.get())));
    public static final RegistryObject<Block> PACKED_CLOUD = BLOCKS.register("packed_cloud", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.25F).sound(SoundType.POWDER_SNOW)));
    public static final RegistryObject<Block> CLOUD_STAIRS = BLOCKS.register("cloud_stairs", () -> new ModStairBlock(PACKED_CLOUD));
    public static final RegistryObject<Block> CLOUD_SLAB = BLOCKS.register("cloud_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PACKED_CLOUD.get())));
    public static final RegistryObject<Block> RAINBOW_TILES = BLOCKS.register("rainbow_tiles", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAINBOW_TILE_STAIRS = BLOCKS.register("rainbow_tile_stairs", () -> new ModStairBlock(RAINBOW_TILES));
    public static final RegistryObject<Block> RAINBOW_TILE_SLAB = BLOCKS.register("rainbow_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RAINBOW_TILES.get())));
    public static final RegistryObject<Block> RAINBOW_TILE_WALL = BLOCKS.register("rainbow_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RAINBOW_TILES.get())));
    public static final RegistryObject<Block> STAR_CLUSTER = BLOCKS.register("star_cluster", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(value -> 10).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> AMANITA_LOG = BLOCKS.register("amanita_log", () -> log(AMANITA_PLANKS_COLOR, AMANITA_LOG_COLOR));
    public static final RegistryObject<Block> AMANITA_PLANKS = BLOCKS.register("amanita_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(AMANITA_PLANKS_COLOR)));
    public static final RegistryObject<Block> AMANITA_LEAVES = BLOCKS.register("amanita_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FRUITING_AMANITA_LEAVES = BLOCKS.register("fruiting_amanita_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> AMANITA_SAPLING = BLOCKS.register("amanita_sapling", () -> new SaplingBlock(new AmanitaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WHITE_FLOWERBED = BLOCKS.register("white_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_FLOWERBED = BLOCKS.register("yellow_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_AMANITA_SAPLING = registerFlowerPot("potted_amanita_sapling", AMANITA_SAPLING);

    private static RotatedPillarBlock log(MapColor planksColor, MapColor woodColor) {
        return new LogBlock(BlockBehaviour.Properties.of().mapColor((blockState) -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? planksColor : woodColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    private static <T extends Block> RegistryObject<Block> registerFlowerPot(String name, Supplier<T> flower) {
        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    }
}
