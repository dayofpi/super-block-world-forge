package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.item.custom.SuperPickaxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = SuperBlockWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

    }

    @Mod.EventBusSubscriber(modid = SuperBlockWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEventBusEvents {
        private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void onBlockBroken(BlockEvent.BreakEvent event) {
            Player player = event.getPlayer();
            ItemStack mainHandItem = player.getMainHandItem();

            // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
            if (mainHandItem.getItem() instanceof SuperPickaxeItem superPickaxe && player instanceof ServerPlayer serverPlayer) {
                BlockPos initalBlockPos = event.getPos();
                if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                    return;
                }

                for (BlockPos pos : SuperPickaxeItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                    if (pos == initalBlockPos || !superPickaxe.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                        continue;
                    }

                    // Have to add them to a Set otherwise, the same code right here will get called for each block!
                    HARVESTED_BLOCKS.add(pos);
                    serverPlayer.gameMode.destroyBlock(pos);
                    HARVESTED_BLOCKS.remove(pos);
                }
            }
        }
    }
}
