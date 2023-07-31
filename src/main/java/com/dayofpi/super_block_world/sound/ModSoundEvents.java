package com.dayofpi.super_block_world.sound;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<SoundEvent> TOADSTONE_BREAK = registerSoundEvent("block.toadstone.break");
    public static final RegistryObject<SoundEvent> TOADSTONE_STEP = registerSoundEvent("block.toadstone.step");
    public static final RegistryObject<SoundEvent> TOADSTONE_PLACE = registerSoundEvent("block.toadstone.place");
    public static final RegistryObject<SoundEvent> TOADSTONE_HIT = registerSoundEvent("block.toadstone.hit");
    public static final RegistryObject<SoundEvent> TOADSTONE_FALL = registerSoundEvent("block.toadstone.fall");
    public static final RegistryObject<SoundEvent> POWER_STAR_SHINE = registerSoundEvent("block.power_star.shine");
    public static final RegistryObject<SoundEvent> HAMMER_THROW = registerSoundEvent("item.hammer.throw");
    public static final RegistryObject<SoundEvent> HAMMER_BREAK = registerSoundEvent("item.hammer.break");
    public static final RegistryObject<SoundEvent> STAR_BIT_PICKUP = registerSoundEvent("item.star_bit.pickup");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(SuperBlockWorld.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
