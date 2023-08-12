package com.dayofpi.super_block_world.sound;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<SoundEvent> MUSIC_CAVES = registerSoundEvent("music.caves");
    public static final RegistryObject<SoundEvent> MUSIC_NIGHT = registerSoundEvent("music.night");
    public static final RegistryObject<SoundEvent> MUSIC_GRASSLANDS = registerSoundEvent("music.grasslands");
    public static final RegistryObject<SoundEvent> TOADSTONE_BREAK = registerSoundEvent("block.toadstone.break");
    public static final RegistryObject<SoundEvent> TOADSTONE_STEP = registerSoundEvent("block.toadstone.step");
    public static final RegistryObject<SoundEvent> TOADSTONE_PLACE = registerSoundEvent("block.toadstone.place");
    public static final RegistryObject<SoundEvent> TOADSTONE_HIT = registerSoundEvent("block.toadstone.hit");
    public static final RegistryObject<SoundEvent> TOADSTONE_FALL = registerSoundEvent("block.toadstone.fall");
    public static final RegistryObject<SoundEvent> PULL_BLOCK_PULL = registerSoundEvent("block.pull_block.pull");
    public static final RegistryObject<SoundEvent> WARP_PIPE_TELEPORT = registerSoundEvent("block.warp_pipe.teleport");
    public static final RegistryObject<SoundEvent> POWER_STAR_SHINE = registerSoundEvent("block.power_star.shine");
    public static final RegistryObject<SoundEvent> WARP_LINK_BREAK = registerSoundEvent("item.warp_link.break");
    public static final RegistryObject<SoundEvent> WARP_LINK_END = registerSoundEvent("item.warp_link.end");
    public static final RegistryObject<SoundEvent> WARP_LINK_RESET = registerSoundEvent("item.warp_link.reset");
    public static final RegistryObject<SoundEvent> WARP_LINK_START = registerSoundEvent("item.warp_link.start");
    public static final RegistryObject<SoundEvent> TURNIP_THROW = registerSoundEvent("item.turnip.throw");
    public static final RegistryObject<SoundEvent> HAMMER_THROW = registerSoundEvent("item.hammer.throw");
    public static final RegistryObject<SoundEvent> HAMMER_BREAK = registerSoundEvent("item.hammer.break");
    public static final RegistryObject<SoundEvent> COIN_PICKUP = registerSoundEvent("item.coin.pickup");
    public static final RegistryObject<SoundEvent> STAR_COIN_PICKUP = registerSoundEvent("item.star_coin.pickup");
    public static final RegistryObject<SoundEvent> STAR_BIT_PICKUP = registerSoundEvent("item.star_bit.pickup");
    public static final RegistryObject<SoundEvent> STAR_BIT_SHOOT = registerSoundEvent("item.star_bit.shoot");
    public static final RegistryObject<SoundEvent> STAR_BIT_BREAK = registerSoundEvent("item.star_bit.break");
    public static final RegistryObject<SoundEvent> SHY_GUY_AMBIENT = registerSoundEvent("entity.shy_guy.ambient");
    public static final RegistryObject<SoundEvent> SHY_GUY_HURT = registerSoundEvent("entity.shy_guy.hurt");
    public static final RegistryObject<SoundEvent> SHY_GUY_DEATH = registerSoundEvent("entity.shy_guy.death");
    public static final RegistryObject<SoundEvent> LUMA_AMBIENT = registerSoundEvent("entity.luma.ambient");
    public static final RegistryObject<SoundEvent> LUMA_HURT = registerSoundEvent("entity.luma.hurt");
    public static final RegistryObject<SoundEvent> LUMA_DEATH = registerSoundEvent("entity.luma.death");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_AMBIENT = registerSoundEvent("entity.hungry_luma.ambient");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_EAT = registerSoundEvent("entity.hungry_luma.eat");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_TRANSFORM = registerSoundEvent("entity.hungry_luma.transform");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_POOF = registerSoundEvent("entity.hungry_luma.poof");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_HURT = registerSoundEvent("entity.hungry_luma.hurt");
    public static final RegistryObject<SoundEvent> HUNGRY_LUMA_DEATH = registerSoundEvent("entity.hungry_luma.death");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_AMBIENT = registerSoundEvent("entity.boom_boom.ambient");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_SPIN = registerSoundEvent("entity.boom_boom.spin");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_DIZZY = registerSoundEvent("entity.boom_boom.dizzy");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_READY = registerSoundEvent("entity.boom_boom.ready");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_HURT = registerSoundEvent("entity.boom_boom.hurt");
    public static final RegistryObject<SoundEvent> BOOM_BOOM_DEATH = registerSoundEvent("entity.boom_boom.death");
    public static final RegistryObject<SoundEvent> WARP_PAINTING_POWER = registerSoundEvent("entity.warp_painting.power");
    public static final RegistryObject<SoundEvent> WARP_PAINTING_TRAVEL = registerSoundEvent("entity.warp_painting.travel");
    public static final RegistryObject<SoundEvent> LAUNCH_STAR_AMBIENT = registerSoundEvent("entity.launch_star.ambient");
    public static final RegistryObject<SoundEvent> LAUNCH_STAR_PLACE = registerSoundEvent("entity.launch_star.place");
    public static final RegistryObject<SoundEvent> LAUNCH_STAR_BREAK = registerSoundEvent("entity.launch_star.break");
    public static final RegistryObject<SoundEvent> LAUNCH_STAR_LAUNCH = registerSoundEvent("entity.launch_star.launch");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(SuperBlockWorld.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
