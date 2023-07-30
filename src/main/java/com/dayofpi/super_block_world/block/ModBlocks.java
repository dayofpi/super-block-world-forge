package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<Block> VANILLATE = BLOCKS.register("vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
    public static final RegistryObject<Block> VANILLATE_CRUMBLE = BLOCKS.register("vanillate_crumble", () -> new SandBlock(12176828, BlockBehaviour.Properties.copy(VANILLATE.get()).strength(1.0F)));
}
