package com.dayofpi.super_block_world.networking.packet;

import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ModTeleportSoundPacket {
    public ModTeleportSoundPacket() {

    }

    public ModTeleportSoundPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {}

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(ModSoundEvents.WARP_PAINTING_TRAVEL.get(), 1.0F, 1.0F)));
        return true;
    }
}
