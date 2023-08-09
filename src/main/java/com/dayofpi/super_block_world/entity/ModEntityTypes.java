package com.dayofpi.super_block_world.entity;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<EntityType<ShyGuyEntity>> SHY_GUY = registerEntity("shy_guy", EntityType.Builder.of(ShyGuyEntity::new, MobCategory.MONSTER).sized(0.8F, 0.9F));
    public static final RegistryObject<EntityType<LumaEntity>> LUMA = registerEntity("luma", EntityType.Builder.of(LumaEntity::new, MobCategory.CREATURE).sized(0.65F, 0.75F));
    public static final RegistryObject<EntityType<HungryLumaEntity>> HUNGRY_LUMA = registerEntity("hungry_luma", EntityType.Builder.of(HungryLumaEntity::new, MobCategory.CREATURE).sized(0.85F, 1.15F));
    public static final RegistryObject<EntityType<BoomBoomEntity>> BOOM_BOOM = registerEntity("boom_boom", EntityType.Builder.of(BoomBoomEntity::new, MobCategory.MONSTER).sized(1.2F, 1.45F));
    public static final RegistryObject<EntityType<HammerEntity>> HAMMER = registerEntity("hammer", EntityType.Builder.<HammerEntity>of(HammerEntity::new, MobCategory.MISC).sized(0.45F, 0.45F).clientTrackingRange(4).updateInterval(10));
    public static final RegistryObject<EntityType<StarBitEntity>> STAR_BIT = registerEntity("star_bit", EntityType.Builder.<StarBitEntity>of(StarBitEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
    public static final RegistryObject<EntityType<WarpPaintingEntity>> WARP_PAINTING = registerEntity("warp_painting", EntityType.Builder.<WarpPaintingEntity>of(WarpPaintingEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE));
    public static final RegistryObject<EntityType<LaunchStarEntity>> LAUNCH_STAR = registerEntity("launch_star", EntityType.Builder.<LaunchStarEntity>of(LaunchStarEntity::new, MobCategory.MISC).sized(0.9F, 0.9F).clientTrackingRange(8).updateInterval(10).fireImmune());
    public static final RegistryObject<EntityType<ModBoatEntity>> BOAT = registerEntity("boat", EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> CHEST_BOAT = registerEntity("chest_boat", EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(new ResourceLocation(SuperBlockWorld.MOD_ID, name).toString()));
    }
}
