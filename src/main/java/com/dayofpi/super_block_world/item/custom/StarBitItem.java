package com.dayofpi.super_block_world.item.custom;

import com.dayofpi.super_block_world.entity.custom.StarBitEntity;
import com.dayofpi.super_block_world.item.ThrowableItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StarBitItem extends Item implements ThrowableItem {
    public StarBitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        this.playSound(level, player.position(), ModSoundEvents.STAR_BIT_SHOOT.get(), (level.random.nextFloat() - level.random.nextFloat()) * 0.2F + 1.0F);
        if (!level.isClientSide) {
            StarBitEntity starBit = new StarBitEntity(level, player);
            starBit.setItem(itemStack);
            starBit.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(starBit);
        }

        this.useStack(player, this, itemStack);
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
