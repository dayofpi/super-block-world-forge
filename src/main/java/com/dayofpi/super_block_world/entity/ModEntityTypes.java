package com.dayofpi.super_block_world.entity;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.HammerEntity;
import com.dayofpi.super_block_world.entity.custom.WarpPaintingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<EntityType<HammerEntity>> HAMMER = registerEntity("hammer", EntityType.Builder.<HammerEntity>of(HammerEntity::new, MobCategory.MISC).sized(0.45F, 0.45F).clientTrackingRange(4).updateInterval(10));
    public static final RegistryObject<EntityType<WarpPaintingEntity>> WARP_PAINTING = registerEntity("warp_painting", EntityType.Builder.<WarpPaintingEntity>of(WarpPaintingEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(new ResourceLocation(SuperBlockWorld.MOD_ID, name).toString()));
    }
}
