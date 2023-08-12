package com.dayofpi.super_block_world.item.custom;

import com.dayofpi.super_block_world.entity.custom.BombEntity;
import com.dayofpi.super_block_world.item.ThrowableItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BombItem extends Item implements ThrowableItem {
    public BombItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        this.playSound(level, player.position(), ModSoundEvents.TURNIP_THROW.get(), (level.random.nextFloat() - level.random.nextFloat()) * 0.2F + 1.0F);
        player.getCooldowns().addCooldown(this, 5);
        if (!level.isClientSide) {
            BombEntity bomb = new BombEntity(level, player);
            bomb.setItem(itemStack);
            bomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(bomb);
        }

        this.useStack(player, this, itemStack);
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
