package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.client.FlagRenderer;
import com.dayofpi.super_block_world.block.client.PlacedItemRenderer;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.client.*;
import com.dayofpi.super_block_world.entity.custom.HammerEntity;
import com.dayofpi.super_block_world.entity.custom.StarBitEntity;
import com.dayofpi.super_block_world.entity.custom.TurnipEntity;
import com.dayofpi.super_block_world.item.ModCreativeTabs;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.item.custom.WarpLinkItem;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModWoodTypes;
import com.dayofpi.super_block_world.worldgen.biome.ModBiomes;
import com.dayofpi.super_block_world.worldgen.feature.ModFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.MAYOI_SAPLING.getId(), ModBlocks.POTTED_MAYOI_SAPLING);
    }

    private static void registerFlammables() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFlammable(ModBlocks.AMANITA_LOG.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.AMANITA_WOOD.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.STRIPPED_AMANITA_LOG.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.STRIPPED_AMANITA_WOOD.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.AMANITA_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.AMANITA_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.AMANITA_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.AMANITA_FENCE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.AMANITA_FENCE_GATE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.AMANITA_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.FRUITING_AMANITA_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.MAYOI_LOG.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.MAYOI_WOOD.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.STRIPPED_MAYOI_LOG.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.STRIPPED_MAYOI_WOOD.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.MAYOI_PLANKS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MAYOI_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MAYOI_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MAYOI_FENCE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MAYOI_FENCE_GATE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MAYOI_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.FRUITING_MAYOI_LEAVES.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.SUBCON_PALM.get(), 30, 60);
        fireBlock.setFlammable(ModBlocks.SUBCON_PALM_STEM.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.WHITE_FLOWERBED.get(), 60, 100);
        fireBlock.setFlammable(ModBlocks.YELLOW_FLOWERBED.get(), 60, 100);
    }

    private static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ModItems.TOADSTOOL_TURF.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.AMANITA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FRUITING_AMANITA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.AMANITA_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.MAYOI_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.FRUITING_MAYOI_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.MAYOI_SAPLING.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.SUBCON_PALM.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.WHITE_FLOWERBED.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.YELLOW_FLOWERBED.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(ModItems.YOSHI_FRUIT.get(), 0.3F);
    }

    private static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ModItems.TURNIP.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new TurnipEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), turnip -> turnip.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.HAMMER.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new HammerEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), hammer -> hammer.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.YELLOW_STAR_BIT.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new StarBitEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), starBit -> starBit.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.RED_STAR_BIT.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new StarBitEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), starBit -> starBit.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.BLUE_STAR_BIT.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new StarBitEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), starBit -> starBit.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.PURPLE_STAR_BIT.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new StarBitEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), starBit -> starBit.setItem(pStack));
            }
        });
        DispenserBlock.registerBehavior(ModItems.RAINBOW_STAR_BIT.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return Util.make(new StarBitEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), starBit -> starBit.setItem(pStack));
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
                Sheets.addWoodType(ModWoodTypes.AMANITA);
                Sheets.addWoodType(ModWoodTypes.MAYOI);
                EntityRenderers.register(ModEntityTypes.SHY_GUY.get(), ShyGuyRenderer::new);
                EntityRenderers.register(ModEntityTypes.LUMA.get(), LumaRenderer::new);
                EntityRenderers.register(ModEntityTypes.HUNGRY_LUMA.get(), HungryLumaRenderer::new);
                EntityRenderers.register(ModEntityTypes.BOOM_BOOM.get(), BoomBoomRenderer::new);
                EntityRenderers.register(ModEntityTypes.TURNIP.get(), ThrownItemRenderer::new);
                EntityRenderers.register(ModEntityTypes.HAMMER.get(), HammerRenderer::new);
                EntityRenderers.register(ModEntityTypes.STAR_BIT.get(), ThrownItemRenderer::new);
                EntityRenderers.register(ModEntityTypes.WARP_PAINTING.get(), WarpPaintingRenderer::new);
                EntityRenderers.register(ModEntityTypes.LAUNCH_STAR.get(), LaunchStarRenderer::new);
                EntityRenderers.register(ModEntityTypes.BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntityTypes.CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
                ItemProperties.register(ModItems.WARP_LINK.get(), new ResourceLocation("linked"), (pStack, pLevel, pEntity, pSeed) -> WarpLinkItem.isLinked(pStack) ? 1.0F : 0.0F);
            });
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> ModBiomes.GRASSLANDS_GRASS_COLOR, ModItems.TOADSTOOL_GRASS.get(), ModItems.TOADSTOOL_TURF.get());
            event.register((pStack, pTintIndex) -> ModBiomes.GRASSLANDS_FOLIAGE_COLOR, ModItems.AMANITA_LEAVES.get(), ModItems.FRUITING_AMANITA_LEAVES.get(), ModItems.MAYOI_LEAVES.get(), ModItems.FRUITING_MAYOI_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : ModBiomes.GRASSLANDS_GRASS_COLOR, ModBlocks.TOADSTOOL_GRASS.get(), ModBlocks.TOADSTOOL_TURF.get());
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : ModBiomes.GRASSLANDS_FOLIAGE_COLOR, ModBlocks.AMANITA_LEAVES.get(), ModBlocks.FRUITING_AMANITA_LEAVES.get(), ModBlocks.MAYOI_LEAVES.get(), ModBlocks.FRUITING_MAYOI_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.ITEM_DISPLAY.get(), pContext -> new PlacedItemRenderer());
            event.registerBlockEntityRenderer(ModBlockEntityTypes.FLAG.get(), FlagRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntityTypes.SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntityTypes.HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }
}
