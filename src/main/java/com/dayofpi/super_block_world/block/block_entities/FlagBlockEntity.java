package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.block.custom.FlagBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class FlagBlockEntity extends BlockEntity {
    private final boolean rainbow;
    private final DyeColor color;
    @Nullable
    private Component customName;

    public FlagBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.FLAG.get(), blockPos, blockState);
        this.rainbow = ((FlagBlock) blockState.getBlock()).isRainbow();
        this.color = ((FlagBlock) blockState.getBlock()).getColor();
    }

    public FlagBlockEntity(BlockPos blockPos, BlockState blockState, DyeColor color, boolean rainbow) {
        super(ModBlockEntityTypes.FLAG.get(), blockPos, blockState);
        this.rainbow = rainbow;
        this.color = color;
    }

    @Override
    public AABB getRenderBoundingBox() {
        return new AABB(this.getBlockPos()).inflate(0.2, 0.0, 0.2);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (compoundTag.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson(compoundTag.getString("CustomName"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (this.customName != null) {
            compoundTag.putString("CustomName", Component.Serializer.toJson(this.customName));
        }
    }

    public @Nullable Component getCustomName() {
        return customName;
    }

    public void setCustomName(@Nullable Component customName) {
        this.customName = customName;
    }

    public boolean isRainbow() {
        return this.rainbow;
    }

    public DyeColor getColor() {
        return this.color;
    }
}
