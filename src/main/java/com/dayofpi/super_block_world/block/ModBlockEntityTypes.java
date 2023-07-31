package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.block_entities.ItemDisplayBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<BlockEntityType<ItemDisplayBlockEntity>> ITEM_DISPLAY = BLOCK_ENTITY_TYPES.register("item_display", () -> BlockEntityType.Builder.of(ItemDisplayBlockEntity::new, ModBlocks.POWER_STAR.get()).build(null));
}
