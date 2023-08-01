package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class MKTeleporter implements ITeleporter {
    private final ServerLevel level;

    public MKTeleporter(ServerLevel level) {
        this.level = level;
    }

    @Override
    public @Nullable PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        WorldBorder border = destWorld.getWorldBorder();
        double minX = Math.max(-2.9999872E7D, border.getMinX() + 16.0D);
        double minZ = Math.max(-2.9999872E7D, border.getMinZ() + 16.0D);
        double maxX = Math.min(2.9999872E7D, border.getMaxX() - 16.0D);
        double maxZ = Math.min(2.9999872E7D, border.getMaxZ() - 16.0D);
        double coordinateDifference = DimensionType.getTeleportationScale(entity.level().dimensionType(), destWorld.dimensionType());
        BlockPos blockPos = new BlockPos((int) Mth.clamp(entity.getX() * coordinateDifference, minX, maxX), (int) entity.getY(), (int) Mth.clamp(entity.getZ() * coordinateDifference, minZ, maxZ));
        BlockPos destination = this.getTopmostPos(blockPos);
        if (level.getBlockState(destination.above()).isSolid()) {
            destination = destination.above();
        }
        return new PortalInfo(destination.above().getCenter(), Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }

    private BlockPos getTopmostPos(BlockPos blockPos) {
        BlockPos topPos = blockPos;
        while (level.getBlockState(topPos.above()).isSolid() && topPos.getY() < level.getMaxBuildHeight()) {
            topPos = topPos.above();
        }
        while (level.getFluidState(topPos).is(FluidTags.LAVA) || (!level.getBlockState(topPos.above()).isSolid() && level.getBlockState(topPos).isAir() && topPos.getY() > 0)) {
            topPos = topPos.below();
        }
        return topPos;
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(ModSoundEvents.WARP_PAINTING_TRAVEL.get(), 1.0F, 1.0F));
        return false;
    }
}
