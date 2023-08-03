package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.client.PlacedItemRenderer;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.client.HammerRenderer;
import com.dayofpi.super_block_world.entity.client.ModBoatRenderer;
import com.dayofpi.super_block_world.entity.client.ShyGuyRenderer;
import com.dayofpi.super_block_world.entity.client.WarpPaintingRenderer;
import com.dayofpi.super_block_world.entity.custom.HammerEntity;
import com.dayofpi.super_block_world.item.ModCreativeTabs;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.item.custom.WarpLinkItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import com.dayofpi.super_block_world.worldgen.feature.ModFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SuperBlockWorld.MOD_ID)
public class SuperBlockWorld {
    public static final String MOD_ID = "super_block_world";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SuperBlockWorld() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Registers to the mod event bus
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerPottables();
            registerFlammables();
            registerCompostables();
            registerDispenserBehaviors();
        });
    }

    private static void registerPottables() {
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.AMANITA_SAPLING.getId(), ModBlocks.POTTED_AMANITA_SAPLING);
    }

    private static void registerFlammables() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(ModBlocks.AMANITA_LOG.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.AMANITA_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.FRUITING_AMANITA_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.WHITE_FLOWERBED.get(), 60, 100);
        fireBlock.setFlammable(ModBlocks.YELLOW_FLOWERBED.get(), 60, 100);
    }

    private static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ModItems.YOSHI_FRUIT.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.AMANITA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FRUITING_AMANITA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.AMANITA_SAPLING.get(), 0.3F);
    }

    private static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ModItems.HAMMER.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new HammerEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), hammerEntity -> hammerEntity.setItem(pStack));
            }
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntityTypes.SHY_GUY.get(), ShyGuyRenderer::new);
                EntityRenderers.register(ModEntityTypes.HAMMER.get(), HammerRenderer::new);
                EntityRenderers.register(ModEntityTypes.WARP_PAINTING.get(), WarpPaintingRenderer::new);
                EntityRenderers.register(ModEntityTypes.BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntityTypes.CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
                ItemProperties.register(ModItems.WARP_LINK.get(), new ResourceLocation("linked"), (pStack, pLevel, pEntity, pSeed) -> WarpLinkItem.isLinked(pStack) ? 1.0F : 0.0F);
            });
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> ModBiomes.GRASSLANDS_GRASS_COLOR, ModItems.TOADSTOOL_GRASS.get());
            event.register((pStack, pTintIndex) -> ModBiomes.GRASSLANDS_FOLIAGE_COLOR, ModItems.AMANITA_LEAVES.get(), ModItems.FRUITING_AMANITA_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : ModBiomes.GRASSLANDS_GRASS_COLOR, ModBlocks.TOADSTOOL_GRASS.get());
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : ModBiomes.GRASSLANDS_FOLIAGE_COLOR, ModBlocks.AMANITA_LEAVES.get(), ModBlocks.FRUITING_AMANITA_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.ITEM_DISPLAY.get(), pContext -> new PlacedItemRenderer());
        }
    }
}
