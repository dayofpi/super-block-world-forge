package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.block.block_entities.WarpPipeBlockEntity;
import com.dayofpi.super_block_world.block.custom.WarpPipeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    private int pipeCooldown;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void setShiftKeyDown(boolean bl) {
        if (bl) {
            this.warpToPipe();
        }
        super.setShiftKeyDown(bl);
    }

    private void warpToPipe() {
        if (this.getPipeCooldown() != 0)
            return;
        BlockPos floor = this.blockPosition().below();
        BlockPos originPos = null;
        if (WarpPipeBlock.canEnterWarpPipe(level(), this.blockPosition()))
            originPos = this.blockPosition();
        if (WarpPipeBlock.canEnterWarpPipe(level(), floor))
            originPos = floor;
        if (originPos != null) {
            this.warpToPipe(originPos);
        }
    }

    private void warpToPipe(BlockPos originPos) {
        BlockPos destinPos = null;
        BlockEntity blockEntity = level().getBlockEntity(originPos);
        if (blockEntity instanceof WarpPipeBlockEntity warpPipeBE) {
            destinPos = warpPipeBE.destinPos;
        }
        if (destinPos == null || !(level().getBlockEntity(destinPos) instanceof WarpPipeBlockEntity)) return;
        WarpPipeBlock.warp((Player) (Object) this, destinPos, level());
        this.setPipeCooldown(20);
    }

    public int getPipeCooldown() {
        return pipeCooldown;
    }

    public void setPipeCooldown(int cooldown) {
        this.pipeCooldown = cooldown;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.isAlive()) {
            if (this.getPipeCooldown() > 0) {
                --this.pipeCooldown;
            }
        }
    }
}
