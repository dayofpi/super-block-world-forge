package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.client.FlagRenderer;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.SpaceCreature;
import com.dayofpi.super_block_world.entity.client.*;
import com.dayofpi.super_block_world.entity.custom.BoomBoomEntity;
import com.dayofpi.super_block_world.entity.custom.HungryLumaEntity;
import com.dayofpi.super_block_world.entity.custom.LumaEntity;
import com.dayofpi.super_block_world.entity.custom.ShyGuyEntity;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.item.custom.SuperPickaxeItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

import java.util.HashSet;
import java.util.Set;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = SuperBlockWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(FlagRenderer.LAYER_LOCATION, FlagRenderer::createBodyLayer);
            event.registerLayerDefinition(ShyGuyModel.LAYER_LOCATION, ShyGuyModel::createBodyLayer);
            event.registerLayerDefinition(LumaModel.LAYER_LOCATION, LumaModel::createBodyLayer);
            event.registerLayerDefinition(HungryLumaModel.LAYER_LOCATION, HungryLumaModel::createBodyLayer);
            event.registerLayerDefinition(BoomBoomModel.LAYER_LOCATION, BoomBoomModel::createBodyLayer);
            event.registerLayerDefinition(WarpPaintingModel.LAYER_LOCATION, WarpPaintingModel::createBodyLayer);
            event.registerLayerDefinition(LaunchStarModel.LAYER_LOCATION, LaunchStarModel::createBodyLayer);
            event.registerLayerDefinition(ModBoatRenderer.AMANITA_BOAT, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModBoatRenderer.AMANITA_CHEST_BOAT, ChestBoatModel::createBodyModel);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SHY_GUY.get(), ShyGuyEntity.createAttributes().build());
            event.put(ModEntityTypes.LUMA.get(), LumaEntity.createAttributes().build());
            event.put(ModEntityTypes.HUNGRY_LUMA.get(), HungryLumaEntity.createAttributes().build());
            event.put(ModEntityTypes.BOOM_BOOM.get(), BoomBoomEntity.createAttributes().build());
        }

        @SubscribeEvent
        public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
            event.register(ModEntityTypes.SHY_GUY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShyGuyEntity::checkShyGuySpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.LUMA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpaceCreature::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.HUNGRY_LUMA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpaceCreature::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
        }
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

        @SubscribeEvent
        public static void handleMissingMappings(MissingMappingsEvent event) {
            event.getAllMappings(ForgeRegistries.Keys.BLOCKS).forEach(blockMapping -> {
                switch (blockMapping.getKey().toString()) {
                    case "super_block_world:polished_hardstone" -> blockMapping.remap(ModBlocks.SMOOTH_HARDSTONE.get());
                    case "super_block_world:polished_hardstone_stairs" -> blockMapping.remap(ModBlocks.SMOOTH_HARDSTONE_STAIRS.get());
                    case "super_block_world:polished_hardstone_slab" -> blockMapping.remap(ModBlocks.SMOOTH_HARDSTONE_SLAB.get());
                    case "super_block_world:polished_hardstone_wall" -> blockMapping.remap(ModBlocks.HARDSTONE_WALL.get());
                }
            });
            event.getAllMappings(ForgeRegistries.Keys.ITEMS).forEach(blockMapping -> {
                switch (blockMapping.getKey().toString()) {
                    case "super_block_world:super_pickax" -> blockMapping.remap(ModItems.SUPER_PICKAXE.get());
                    case "super_block_world:green_star_bit" -> blockMapping.remap(ModItems.YELLOW_STAR_BIT.get());
                }
            });
        }

        @SubscribeEvent
        public static void onItemPickup(PlayerEvent.ItemPickupEvent event) {
            Player entity = event.getEntity();
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null || !level.isClientSide)
                return;
            /*if (event.getStack().is(ModBlocks.COIN.get().asItem())) {
                level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ModSounds.COIN_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F, false);
            } else if (event.getStack().is(ModBlocks.STAR_COIN.get().asItem())) {
                level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ModSounds.STAR_COIN_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F, false);
            } else */
            if (event.getStack().is(ModTags.Items.STAR_BITS)) {
                level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), ModSoundEvents.STAR_BIT_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F, false);
            }
        }
    }
}
