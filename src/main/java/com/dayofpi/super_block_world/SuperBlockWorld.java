package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.block.client.PlacedItemRenderer;
import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.client.HammerRenderer;
import com.dayofpi.super_block_world.entity.client.WarpPaintingRenderer;
import com.dayofpi.super_block_world.entity.custom.HammerEntity;
import com.dayofpi.super_block_world.item.ModCreativeTabs;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(ModItems.HAMMER.get(), new AbstractProjectileDispenseBehavior() {
                @Override
                protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                    return Util.make(new HammerEntity(pLevel, pPosition.x(), pPosition.y(), pPosition.z()), hammerEntity -> hammerEntity.setItem(pStack));
                }
            });
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
                EntityRenderers.register(ModEntityTypes.HAMMER.get(), HammerRenderer::new);
                EntityRenderers.register(ModEntityTypes.WARP_PAINTING.get(), WarpPaintingRenderer::new);
            });
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.ITEM_DISPLAY.get(), pContext -> new PlacedItemRenderer());
        }
    }
}
