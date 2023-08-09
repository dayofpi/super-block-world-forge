package com.dayofpi.super_block_world.item.custom;

import com.dayofpi.super_block_world.entity.custom.LaunchStarEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class LaunchStarItem extends Item {
    public LaunchStarItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        Player player = pContext.getPlayer();
        ItemStack itemstack = pContext.getItemInHand();
        if (player != null && !this.mayPlace(player, direction, itemstack, blockpos1)) {
            return InteractionResult.FAIL;
        } else {
            Level level = pContext.getLevel();
            LaunchStarEntity launchStar = new LaunchStarEntity(level, blockpos1, direction);

            CompoundTag compoundtag = itemstack.getTag();
            if (compoundtag != null) {
                EntityType.updateCustomEntityTag(level, player, launchStar, compoundtag);
            }

            if (launchStar.survives()) {
                if (!level.isClientSide) {
                    launchStar.playPlacementSound();
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, launchStar.position());
                    level.addFreshEntity(launchStar);
                }

                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    protected boolean mayPlace(Player pPlayer, Direction pDirection, ItemStack pHangingEntityStack, BlockPos pPos) {
        return pPlayer.mayUseItemAt(pPos, pDirection, pHangingEntityStack);
    }
}
