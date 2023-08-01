package com.dayofpi.super_block_world.item;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperBlockWorld.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.POWER_STAR.get())).title(Component.translatable("itemGroup.super_block_world")).displayItems((itemDisplayParameters, output) -> {
        output.accept(ModItems.VANILLATE.get());
        output.accept(ModItems.TOPPED_VANILLATE.get());
        output.accept(ModItems.VANILLATE_CRUMBLE.get());
        output.accept(ModItems.VANILLATE_BRICKS.get());
        output.accept(ModItems.VANILLATE_TILES.get());
        output.accept(ModItems.TOADSTONE.get());
        output.accept(ModItems.TOADSTONE_BRICKS.get());
        output.accept(ModItems.SMOOTH_TOADSTONE.get());
        output.accept(ModItems.HARDSTONE.get());
        output.accept(ModItems.HARDSTONE_BRICKS.get());
        output.accept(ModItems.SMOOTH_HARDSTONE.get());
        output.accept(ModItems.PACKED_CLOUD.get());
        output.accept(ModItems.RAINBOW_TILES.get());
        output.accept(ModItems.STAR_CLUSTER.get());
        output.accept(ModItems.WHITE_FLOWERBED.get());
        output.accept(ModItems.YELLOW_FLOWERBED.get());
        output.accept(ModItems.WARP_PAINTING.get());
        output.accept(ModItems.HAMMER.get());
        output.accept(ModItems.SUPER_PICKAXE.get());
        output.accept(ModItems.RAW_BRONZE.get());
        output.accept(ModItems.BRONZE_INGOT.get());
        output.accept(ModItems.POWER_STAR.get());
        output.accept(ModItems.POWER_SHARD.get());
        output.accept(ModItems.YELLOW_STAR_BIT.get());
        output.accept(ModItems.GREEN_STAR_BIT.get());
        output.accept(ModItems.BLUE_STAR_BIT.get());
        output.accept(ModItems.PURPLE_STAR_BIT.get());
        output.accept(ModItems.SUBCON_THREAD.get());
    }).build());
}
