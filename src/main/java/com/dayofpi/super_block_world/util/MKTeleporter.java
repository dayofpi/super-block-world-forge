package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.BlockUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
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
        BlockPos blockpos = new BlockPos((int) Mth.clamp(entity.getX() * coordinateDifference, minX, maxX), (int) entity.getY(), (int) Mth.clamp(entity.getZ() * coordinateDifference, minZ, maxZ));
        return this.makePlatform(blockpos, entity.getDirection().getAxis()).map((result) -> {
            Direction.Axis axis;
            Vec3 vector3d;
            axis = Direction.Axis.X;
            vector3d = new Vec3(0.0D, -1.0D, 0.0D);

            return PortalShape.createPortalInfo(destWorld, result, axis, vector3d, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
        }).orElse(null);
    }

    public Optional<BlockUtil.FoundRectangle> makePlatform(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.level.getWorldBorder();
        int dimensionLogicalHeight = this.level.getHeight() - 1;
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (BlockPos.MutableBlockPos blockpos$mutable1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(dimensionLogicalHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutable1.getX(), blockpos$mutable1.getZ()));
            if (worldborder.isWithinBounds(blockpos$mutable1) && worldborder.isWithinBounds(blockpos$mutable1.move(direction, 1))) {
                blockpos$mutable1.move(direction.getOpposite(), 1);

                for (int l = j; l >= 0; --l) {
                    blockpos$mutable1.setY(l);
                    if (this.level.isEmptyBlock(blockpos$mutable1)) {
                        int i1;
                        for (i1 = l; l > 0 && this.level.isEmptyBlock(blockpos$mutable1.move(Direction.DOWN)); --l) {
                        }

                        if (l + 4 <= dimensionLogicalHeight) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                blockpos$mutable1.setY(l);
                                if (this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(blockpos$mutable1);
                                    if (this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, -1) && this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockpos$mutable1.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockpos$mutable1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 70, this.level.getHeight() - 10), pos.getZ())).immutable();
            Direction direction1 = direction.getClockWise();
            if (!worldborder.isWithinBounds(blockpos)) {
                return Optional.empty();
            }

            for (int l1 = -1; l1 < 2; ++l1) {
                for (int k2 = -1; k2 < 2; ++k2) {
                    for (int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockstate1 = i3 < 0 ? ModBlocks.PACKED_CLOUD.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockpos, k2 * direction.getStepX() + l1 * direction1.getStepX(), i3, k2 * direction.getStepZ() + l1 * direction1.getStepZ());
                        this.level.setBlockAndUpdate(mutablePos, blockstate1);
                    }
                }
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.above().immutable(), 1, 1));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for (int i = -1; i < 3; ++i) {
            for (int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !this.level.getBlockState(offsetPos).isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.level.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(ModSoundEvents.WARP_PAINTING_TRAVEL.get(), 1.0F, 1.0F));
        return false;
    }
}
