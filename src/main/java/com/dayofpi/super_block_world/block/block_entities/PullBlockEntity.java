package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class PullBlockEntity extends BlockEntity {
    public PullBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntityTypes.PULL_BLOCK.get(), pPos, pBlockState);
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, PullBlockEntity pullBlockEntity) {
        List<ItemEntity> affectedItems = new ArrayList<>();
        if (blockState.getValue(BlockStateProperties.POWERED)) {
            List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, new AABB(blockPos).inflate(16));
            for (ItemEntity item : items) {
                if (!item.isNoGravity()) {
                    item.setNoGravity(true);
                    affectedItems.add(item);
                }
                Vec3 vec3 = new Vec3(blockPos.getX() - item.getX(), blockPos.getY() - item.getY(), blockPos.getZ() - item.getZ());
                double lengthSquared = vec3.lengthSqr();
                if (lengthSquared < 64.0) {
                    double e = 1.0 - Math.sqrt(lengthSquared) / 8.0;
                    double v = e * e * 0.2;
                    item.setDeltaMovement(item.getDeltaMovement().add(vec3.normalize().multiply(v, v, v)));
                }
            }
        }
        for (ItemEntity item : affectedItems) {
            item.setNoGravity(false);
        }
    }
}
