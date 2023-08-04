package com.dayofpi.super_block_world.item.custom;

import com.dayofpi.super_block_world.block.block_entities.WarpPipeBlockEntity;
import com.dayofpi.super_block_world.block.custom.WarpPipeBlock;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Optional;

public class WarpLinkItem extends Item {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String WARP_PIPE_POS_KEY = "WarpPipePos";
    private static final String WARP_PIPE_DIMENSION_KEY = "WarpPipeDimension";
    private static final int MAX_DISTANCE = 140;

    public WarpLinkItem(Properties properties) {
        super(properties);
    }

    public static boolean isLinked(ItemStack stack) {
        CompoundTag compoundTag = stack.getTag();
        return compoundTag != null && (compoundTag.contains(WARP_PIPE_DIMENSION_KEY) || compoundTag.contains(WARP_PIPE_POS_KEY));
    }

    private static Optional<ResourceKey<Level>> getWarpPipeDimension(CompoundTag compoundTag) {
        return Level.RESOURCE_KEY_CODEC.parse(NbtOps.INSTANCE, compoundTag.get(WARP_PIPE_DIMENSION_KEY)).result();
    }

    @Nullable
    private static GlobalPos createWarpPipePos(CompoundTag compoundTag) {
        Optional<ResourceKey<Level>> optional;
        boolean bl = compoundTag.contains(WARP_PIPE_POS_KEY);
        boolean bl2 = compoundTag.contains(WARP_PIPE_DIMENSION_KEY);
        if (bl && bl2 && (optional = WarpLinkItem.getWarpPipeDimension(compoundTag)).isPresent()) {
            BlockPos blockPos = NbtUtils.readBlockPos(compoundTag.getCompound(WARP_PIPE_POS_KEY));
            return GlobalPos.of(optional.get(), blockPos);
        }
        return null;
    }

    private void spawnParticles(Level level, BlockPos blockPos) {
        if (level instanceof ServerLevel) {
            RandomSource random = level.getRandom();

            for (int i = 0; i < 4; ++i) {
                ((ServerLevel) level).sendParticles(ParticleTypes.POOF, blockPos.getX() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D + (0.5D * (random.nextBoolean() ? 1 : -1)), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    private InteractionResult reset(Level level, BlockPos blockPos, CompoundTag compoundTag, boolean fromBreak) {
        this.playSound(level, blockPos, fromBreak ? ModSoundEvents.WARP_LINK_BREAK.get() : ModSoundEvents.WARP_LINK_RESET.get());
        compoundTag.remove(WARP_PIPE_POS_KEY);
        compoundTag.remove(WARP_PIPE_DIMENSION_KEY);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private void link(BlockPos blockPos, Level level, CompoundTag compoundTag, WarpPipeBlockEntity warpPipeBE, WarpPipeBlockEntity warpPipeBE1) {
        this.spawnParticles(level, blockPos);
        this.playSound(level, blockPos, ModSoundEvents.WARP_LINK_END.get());
        warpPipeBE.setDestinationPos(warpPipeBE1.getBlockPos(), level);
        warpPipeBE1.setDestinationPos(blockPos, level);
        compoundTag.remove(WARP_PIPE_POS_KEY);
        compoundTag.remove(WARP_PIPE_DIMENSION_KEY);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide()) {
            return;
        }
        if (WarpLinkItem.isLinked(itemStack)) {
            CompoundTag nbtCompound = itemStack.getOrCreateTag();
            GlobalPos globalPos = WarpLinkItem.createWarpPipePos(nbtCompound);
            if (globalPos == null || !(entity instanceof Player)) return;
            boolean bl = ((Player) entity).getOffhandItem() == itemStack;
            if (selected || bl) {
                if (!globalPos.pos().closerToCenterThan(entity.position(), MAX_DISTANCE)) {
                    InteractionHand hand = InteractionHand.MAIN_HAND;
                    if (bl)
                        hand = InteractionHand.OFF_HAND;
                    InteractionHand finalHand = hand;
                    itemStack.hurtAndBreak(2, (Player) entity, p -> p.broadcastBreakEvent(finalHand));
                    this.reset(level, entity.blockPosition(), nbtCompound, true);
                }
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        BlockPos blockPos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        Level level = useOnContext.getLevel();
        InteractionResult interactionResult = super.useOn(useOnContext);
        if (WarpPipeBlock.isLinkableWarpPipe(level, blockPos)) {
            ItemStack itemStack = useOnContext.getItemInHand();
            if (WarpLinkItem.isLinked(itemStack)) {
                CompoundTag compoundTag = itemStack.getOrCreateTag();
                GlobalPos globalPos = WarpLinkItem.createWarpPipePos(compoundTag);
                if (globalPos == null)
                    return interactionResult;
                if (globalPos.pos().equals(blockPos)) {
                    return this.reset(level, blockPos, compoundTag, false);
                }
                BlockEntity blockEntity = level.getBlockEntity(blockPos);
                BlockEntity blockEntity1 = level.getBlockEntity(globalPos.pos());
                if (blockEntity instanceof WarpPipeBlockEntity warpPipeBE && blockEntity1 instanceof WarpPipeBlockEntity warpPipeBE1) {
                    if (WarpPipeBlock.isLinkableWarpPipe(level, globalPos.pos())) {
                        if (player != null)
                            itemStack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(useOnContext.getHand()));
                        this.link(blockPos, level, compoundTag, warpPipeBE, warpPipeBE1);
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }
                } else return this.reset(level, blockPos, compoundTag, false);
            } else {
                this.playSound(level, blockPos, ModSoundEvents.WARP_LINK_START.get());
                Player playerEntity = useOnContext.getPlayer();
                if (playerEntity == null)
                    return interactionResult;
                this.writeNbt(level.dimension(), blockPos, itemStack.getOrCreateTag());
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return interactionResult;
    }

    private void playSound(Level level, BlockPos blockPos, SoundEvent soundEvent) {
        level.playSound(null, blockPos, soundEvent, SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    private void writeNbt(ResourceKey<Level> resourceKey, BlockPos pos, CompoundTag compoundTag) {
        compoundTag.put(WARP_PIPE_POS_KEY, NbtUtils.writeBlockPos(pos));
        Level.RESOURCE_KEY_CODEC.encodeStart(NbtOps.INSTANCE, resourceKey).resultOrPartial(LOGGER::error).ifPresent(nbtElement -> compoundTag.put(WARP_PIPE_DIMENSION_KEY, nbtElement));
    }
}
