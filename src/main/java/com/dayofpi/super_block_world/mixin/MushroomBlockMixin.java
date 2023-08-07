package com.dayofpi.super_block_world.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HugeMushroomBlock.class)
public class MushroomBlockMixin extends Block {
    public MushroomBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (this.isBouncy(pState) && !pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance * 0.5F);
        } else {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        }
    }

    public void updateEntityAfterFallOn(BlockGetter pLevel, Entity pEntity) {
        if (this.isBouncy(pEntity.getBlockStateOn()) && !pEntity.isSuppressingBounce()) {
            this.bounceUp(pEntity);
        } else super.updateEntityAfterFallOn(pLevel, pEntity);
    }

    @Unique
    private void bounceUp(Entity pEntity) {
        Vec3 vec3 = pEntity.getDeltaMovement();
        if (vec3.y < 0.0D) {
            double d0 = pEntity instanceof LivingEntity ? 1.0D : 0.8D;
            pEntity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
        }
    }

    @Unique
    private boolean isBouncy(BlockState blockState) {
        return blockState.is(Blocks.RED_MUSHROOM_BLOCK);
    }
}
