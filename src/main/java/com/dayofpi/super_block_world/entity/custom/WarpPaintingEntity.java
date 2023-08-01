package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.util.MKTeleporter;
import com.dayofpi.super_block_world.worldgen.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WarpPaintingEntity extends HangingEntity {
    public WarpPaintingEntity(EntityType<? extends HangingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public WarpPaintingEntity(Level pLevel, BlockPos pPos, Direction pFacingDirection) {
        super(ModEntityTypes.WARP_PAINTING.get(), pLevel, pPos);
        this.setDirection(pFacingDirection);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isRemoved())
            return;
        List<Entity> entityList = level().getEntities(this, this.getBoundingBox());
        if (!entityList.isEmpty()) {
            for (Entity entity : entityList) {
                if (entity.isOnPortalCooldown()) {
                    entity.setPortalCooldown();
                } else {
                    MinecraftServer minecraftServer = entity.level().getServer();
                    if (minecraftServer != null) {
                        ResourceKey<Level> mushroomKingdomDestination = entity.level().dimension() == ModDimensions.MUSHROOM_KINGDOM_LEVEL ? Level.OVERWORLD : ModDimensions.MUSHROOM_KINGDOM_LEVEL;
                        ServerLevel destinationWorld = minecraftServer.getLevel(mushroomKingdomDestination);
                        if (destinationWorld != null && !entity.isPassenger()) {
                            entity.setPortalCooldown();
                            entity.changeDimension(destinationWorld, new MKTeleporter(destinationWorld));
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getWidth() {
        return 64;
    }

    @Override
    public int getHeight() {
        return 64;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putByte("facing", (byte)this.direction.get2DDataValue());
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.direction = Direction.from2DDataValue(pCompound.getByte("facing"));
        super.readAdditionalSaveData(pCompound);
        this.setDirection(this.direction);
    }

    @Override
    public void dropItem(@Nullable Entity pBrokenEntity) {
        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);
            if (pBrokenEntity instanceof Player player) {
                if (player.getAbilities().instabuild) {
                    return;
                }
            }

            this.spawnAtLocation(ModItems.WARP_PAINTING.get());
        }
    }

    @Override
    public void playPlacementSound() {
        this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void moveTo(double pX, double pY, double pZ, float pYaw, float pPitch) {
        this.setPos(pX, pY, pZ);
    }

    @Override
    public void lerpTo(double pX, double pY, double pZ, float pYaw, float pPitch, int pPosRotationIncrements, boolean pTeleport) {
        this.setPos(pX, pY, pZ);
    }

    @Override
    public Vec3 trackingPosition() {
        return Vec3.atLowerCornerOf(this.pos);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
        this.setDirection(Direction.from3DDataValue(pPacket.getData()));
    }

    @Nullable
    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.WARP_PAINTING.get());
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypeTags.IS_EXPLOSION)) {
            return false;
        }
        return super.hurt(pSource, pAmount);
    }
}
