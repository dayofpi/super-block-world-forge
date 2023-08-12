package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.block_entities.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<BlockEntityType<ItemDisplayBlockEntity>> ITEM_DISPLAY = BLOCK_ENTITY_TYPES.register("item_display", () -> BlockEntityType.Builder.of(ItemDisplayBlockEntity::new, ModBlocks.POWER_STAR.get(), ModBlocks.COIN.get(), ModBlocks.STAR_COIN.get()).build(null));
    public static final RegistryObject<BlockEntityType<FlagBlockEntity>> FLAG = BLOCK_ENTITY_TYPES.register("flag", () -> BlockEntityType.Builder.of(FlagBlockEntity::new, ModBlocks.WHITE_FLAG.get(), ModBlocks.LIGHT_GRAY_FLAG.get(), ModBlocks.GRAY_FLAG.get(), ModBlocks.BLACK_FLAG.get(), ModBlocks.BROWN_FLAG.get(), ModBlocks.RED_FLAG.get(), ModBlocks.ORANGE_FLAG.get(), ModBlocks.YELLOW_FLAG.get(), ModBlocks.LIME_FLAG.get(), ModBlocks.GREEN_FLAG.get(), ModBlocks.CYAN_FLAG.get(), ModBlocks.LIGHT_BLUE_FLAG.get(), ModBlocks.BLUE_FLAG.get(), ModBlocks.PURPLE_FLAG.get(), ModBlocks.MAGENTA_FLAG.get(), ModBlocks.PINK_FLAG.get(), ModBlocks.RAINBOW_FLAG.get()).build(null));
    public static final RegistryObject<BlockEntityType<WarpPipeBlockEntity>> WARP_PIPE = BLOCK_ENTITY_TYPES.register("warp_pipe", () -> BlockEntityType.Builder.of(WarpPipeBlockEntity::new, ModBlocks.WHITE_WARP_PIPE.get(), ModBlocks.LIGHT_GRAY_WARP_PIPE.get(), ModBlocks.GRAY_WARP_PIPE.get(), ModBlocks.BLACK_WARP_PIPE.get(), ModBlocks.BROWN_WARP_PIPE.get(), ModBlocks.RED_WARP_PIPE.get(), ModBlocks.ORANGE_WARP_PIPE.get(), ModBlocks.YELLOW_WARP_PIPE.get(), ModBlocks.LIME_WARP_PIPE.get(), ModBlocks.GREEN_WARP_PIPE.get(), ModBlocks.CYAN_WARP_PIPE.get(), ModBlocks.LIGHT_BLUE_WARP_PIPE.get(), ModBlocks.BLUE_WARP_PIPE.get(), ModBlocks.PURPLE_WARP_PIPE.get(), ModBlocks.MAGENTA_WARP_PIPE.get(), ModBlocks.PINK_WARP_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PullBlockEntity>> PULL_BLOCK = BLOCK_ENTITY_TYPES.register("pull_block", () -> BlockEntityType.Builder.of(PullBlockEntity::new, ModBlocks.PULL_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.AMANITA_SIGN.get(), ModBlocks.AMANITA_WALL_SIGN.get(), ModBlocks.MAYOI_SIGN.get(), ModBlocks.MAYOI_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITY_TYPES.register("hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.AMANITA_HANGING_SIGN.get(), ModBlocks.AMANITA_WALL_HANGING_SIGN.get(), ModBlocks.MAYOI_HANGING_SIGN.get(), ModBlocks.MAYOI_WALL_HANGING_SIGN.get()).build(null));
}
