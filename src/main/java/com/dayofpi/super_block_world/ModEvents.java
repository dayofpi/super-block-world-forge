package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.client.FlagRenderer;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.SpaceCreature;
import com.dayofpi.super_block_world.entity.client.*;
import com.dayofpi.super_block_world.entity.custom.*;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.item.custom.SuperPickaxeItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
            event.registerLayerDefinition(OctoombaModel.LAYER_LOCATION, OctoombaModel::createBodyLayer);
            event.registerLayerDefinition(ChainChompModel.LAYER_LOCATION, ChainChompModel::createBodyLayer);
            event.registerLayerDefinition(UnagiModel.LAYER_LOCATION, UnagiModel::createBodyLayer);
            event.registerLayerDefinition(BoomBoomModel.LAYER_LOCATION, BoomBoomModel::createBodyLayer);
            event.registerLayerDefinition(WarpPaintingModel.LAYER_LOCATION, WarpPaintingModel::createBodyLayer);
            event.registerLayerDefinition(LaunchStarModel.LAYER_LOCATION, LaunchStarModel::createBodyLayer);
            event.registerLayerDefinition(ModBoatRenderer.AMANITA_BOAT, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModBoatRenderer.AMANITA_CHEST_BOAT, ChestBoatModel::createBodyModel);
            event.registerLayerDefinition(ModBoatRenderer.MAYOI_BOAT, BoatModel::createBodyModel);
            event.registerLayerDefinition(ModBoatRenderer.MAYOI_CHEST_BOAT, ChestBoatModel::createBodyModel);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.SHY_GUY.get(), ShyGuyEntity.createAttributes().build());
            event.put(ModEntityTypes.LUMA.get(), AbstractLuma.createAttributes().build());
            event.put(ModEntityTypes.HUNGRY_LUMA.get(), AbstractLuma.createAttributes().build());
            event.put(ModEntityTypes.SMEECH.get(), SmeechEntity.createAttributes().build());
            event.put(ModEntityTypes.OCTOOMBA.get(), OctoombaEntity.createAttributes().build());
            event.put(ModEntityTypes.CHAIN_CHOMP.get(), ChainChompEntity.createAttributes().build());
            event.put(ModEntityTypes.UNAGI.get(), Monster.createMonsterAttributes().build());
            event.put(ModEntityTypes.BOOM_BOOM.get(), BoomBoomEntity.createAttributes().build());
        }

        @SubscribeEvent
        public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
            event.register(ModEntityTypes.SHY_GUY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShyGuyEntity::checkShyGuySpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.LUMA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpaceCreature::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.HUNGRY_LUMA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpaceCreature::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.SMEECH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.OCTOOMBA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpaceCreature::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
            event.register(ModEntityTypes.UNAGI.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, UnagiEntity::checkUnagiSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
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
                    case "super_block_world:royalite" -> blockMapping.remap(ModBlocks.ROYALITE_BLOCK.get());
                    case "super_block_world:dark_amanita_log" -> blockMapping.remap(ModBlocks.MAYOI_LOG.get());
                    case "super_block_world:dark_amanita_wood" -> blockMapping.remap(ModBlocks.MAYOI_WOOD.get());
                    case "super_block_world:stripped_dark_amanita_log" -> blockMapping.remap(ModBlocks.STRIPPED_MAYOI_LOG.get());
                    case "super_block_world:stripped_dark_amanita_wood" -> blockMapping.remap(ModBlocks.STRIPPED_MAYOI_WOOD.get());
                    case "super_block_world:dark_amanita_planks" -> blockMapping.remap(ModBlocks.MAYOI_PLANKS.get());
                    case "super_block_world:dark_amanita_stairs" -> blockMapping.remap(ModBlocks.MAYOI_STAIRS.get());
                    case "super_block_world:dark_amanita_slab" -> blockMapping.remap(ModBlocks.MAYOI_SLAB.get());
                    case "super_block_world:dark_amanita_fence" -> blockMapping.remap(ModBlocks.MAYOI_FENCE.get());
                    case "super_block_world:dark_amanita_fence_gate" -> blockMapping.remap(ModBlocks.MAYOI_FENCE_GATE.get());
                    case "super_block_world:dark_amanita_door" -> blockMapping.remap(ModBlocks.MAYOI_DOOR.get());
                    case "super_block_world:dark_amanita_trapdoor" -> blockMapping.remap(ModBlocks.MAYOI_TRAPDOOR.get());
                    case "super_block_world:dark_amanita_pressure_plate" -> blockMapping.remap(ModBlocks.MAYOI_PRESSURE_PLATE.get());
                    case "super_block_world:dark_amanita_button" -> blockMapping.remap(ModBlocks.MAYOI_BUTTON.get());
                    case "super_block_world:dark_amanita_sign" -> blockMapping.remap(ModBlocks.MAYOI_SIGN.get());
                    case "super_block_world:dark_amanita_wall_sign" -> blockMapping.remap(ModBlocks.MAYOI_WALL_SIGN.get());
                    case "super_block_world:dark_amanita_leaves" -> blockMapping.remap(ModBlocks.MAYOI_LEAVES.get());
                    case "super_block_world:fruiting_dark_amanita_leaves" -> blockMapping.remap(ModBlocks.FRUITING_MAYOI_LEAVES.get());
                    case "super_block_world:dark_amanita_sapling" -> blockMapping.remap(ModBlocks.MAYOI_SAPLING.get());
                }
            });
            event.getAllMappings(ForgeRegistries.Keys.ITEMS).forEach(itemMapping -> {
                switch (itemMapping.getKey().toString()) {
                    case "super_block_world:polished_hardstone" -> itemMapping.remap(ModItems.SMOOTH_HARDSTONE.get());
                    case "super_block_world:polished_hardstone_stairs" -> itemMapping.remap(ModItems.SMOOTH_HARDSTONE_STAIRS.get());
                    case "super_block_world:polished_hardstone_slab" -> itemMapping.remap(ModItems.SMOOTH_HARDSTONE_SLAB.get());
                    case "super_block_world:polished_hardstone_wall" -> itemMapping.remap(ModItems.HARDSTONE_WALL.get());
                    case "super_block_world:royalite" -> itemMapping.remap(ModItems.ROYALITE_BLOCK.get());
                    case "super_block_world:dark_amanita_log" -> itemMapping.remap(ModItems.MAYOI_LOG.get());
                    case "super_block_world:dark_amanita_wood" -> itemMapping.remap(ModItems.MAYOI_WOOD.get());
                    case "super_block_world:stripped_dark_amanita_log" -> itemMapping.remap(ModItems.STRIPPED_MAYOI_LOG.get());
                    case "super_block_world:stripped_dark_amanita_wood" -> itemMapping.remap(ModItems.STRIPPED_MAYOI_WOOD.get());
                    case "super_block_world:dark_amanita_planks" -> itemMapping.remap(ModItems.MAYOI_PLANKS.get());
                    case "super_block_world:dark_amanita_stairs" -> itemMapping.remap(ModItems.MAYOI_STAIRS.get());
                    case "super_block_world:dark_amanita_slab" -> itemMapping.remap(ModItems.MAYOI_SLAB.get());
                    case "super_block_world:dark_amanita_fence" -> itemMapping.remap(ModItems.MAYOI_FENCE.get());
                    case "super_block_world:dark_amanita_fence_gate" -> itemMapping.remap(ModItems.MAYOI_FENCE_GATE.get());
                    case "super_block_world:dark_amanita_door" -> itemMapping.remap(ModItems.MAYOI_DOOR.get());
                    case "super_block_world:dark_amanita_trapdoor" -> itemMapping.remap(ModItems.MAYOI_TRAPDOOR.get());
                    case "super_block_world:dark_amanita_pressure_plate" -> itemMapping.remap(ModItems.MAYOI_PRESSURE_PLATE.get());
                    case "super_block_world:dark_amanita_button" -> itemMapping.remap(ModItems.MAYOI_BUTTON.get());
                    case "super_block_world:dark_amanita_sign" -> itemMapping.remap(ModItems.MAYOI_SIGN.get());
                    case "super_block_world:dark_amanita_leaves" -> itemMapping.remap(ModItems.MAYOI_LEAVES.get());
                    case "super_block_world:fruiting_dark_amanita_leaves" -> itemMapping.remap(ModItems.FRUITING_MAYOI_LEAVES.get());
                    case "super_block_world:dark_amanita_sapling" -> itemMapping.remap(ModItems.MAYOI_SAPLING.get());
                    case "super_block_world:dark_amanita_boat" -> itemMapping.remap(ModItems.MAYOI_BOAT.get());
                    case "super_block_world:dark_amanita_chest_boat" -> itemMapping.remap(ModItems.MAYOI_CHEST_BOAT.get());
                    case "super_block_world:super_pickax" -> itemMapping.remap(ModItems.SUPER_PICKAXE.get());
                    case "super_block_world:green_star_bit" -> itemMapping.remap(ModItems.YELLOW_STAR_BIT.get());
                }
            });
        }

        @SubscribeEvent
        public static void onItemPickup(PlayerEvent.ItemPickupEvent event) {
            Player player = event.getEntity();
            Level level = player.level();
            if (event.getStack().is(ModItems.COIN.get())) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.COIN_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F);
            } else if (event.getStack().is(ModItems.STAR_COIN.get())) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.STAR_COIN_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F);
            } else if (event.getStack().is(ModTags.Items.STAR_BITS)) {
                level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSoundEvents.STAR_BIT_PICKUP.get(), SoundSource.PLAYERS, 0.2F, 1.0F);
            }
        }
    }
}
