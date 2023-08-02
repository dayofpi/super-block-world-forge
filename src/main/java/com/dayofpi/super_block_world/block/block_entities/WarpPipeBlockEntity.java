package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.block.custom.WarpPipeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WarpPipeBlockEntity extends BlockEntity {
    private static final String DESTINATION_POS = "DestinationPos";
    @Nullable
    public BlockPos destinPos;

    public WarpPipeBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.WARP_PIPE.get(), blockPos, blockState);
    }

    private boolean hasDestinationPos() {
        return this.destinPos != null;
    }

    public void setDestinationPos(@Nullable BlockPos blockPos) {
        this.destinPos = blockPos;
        if (this.level != null) {
            BlockState blockState = this.getBlockState();
            this.level.setBlock(this.getBlockPos(), blockState.setValue(WarpPipeBlock.LINKED, destinPos != null), 3);
        }
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.destinPos = null;
        if (compoundTag.contains(DESTINATION_POS)) {
            this.setDestinationPos(NbtUtils.readBlockPos(compoundTag.getCompound(DESTINATION_POS)));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (this.hasDestinationPos()) {
            compoundTag.put(DESTINATION_POS, NbtUtils.writeBlockPos(this.destinPos));
        }
    }
}
