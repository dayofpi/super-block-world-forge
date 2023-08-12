package com.dayofpi.super_block_world.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public interface ThrowableItem {
    default void playSound(Level level, Vec3 pos, SoundEvent soundEvent, float pitch) {
        level.playSound(null, pos.x(), pos.y(), pos.z(), soundEvent, SoundSource.NEUTRAL, (float) 0.5, pitch);
    }

    default void useStack(Player user, Item item, ItemStack itemStack) {
        user.awardStat(Stats.ITEM_USED.get(item));
        if (!user.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
    }
}
