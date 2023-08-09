package com.dayofpi.super_block_world.networking;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.networking.packet.ModTeleportSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(SuperBlockWorld.MOD_ID, "messages")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();
        INSTANCE = net;
        net.messageBuilder(ModTeleportSoundPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT).decoder(ModTeleportSoundPacket::new).encoder(ModTeleportSoundPacket::toBytes).consumerMainThread(ModTeleportSoundPacket::handle).add();
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer serverPlayer) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), message);
    }
}
