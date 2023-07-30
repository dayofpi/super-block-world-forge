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

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VANILLATE.get())).title(Component.translatable("itemGroup.super_block_world")).displayItems((itemDisplayParameters, output) -> {
        output.accept(ModItems.VANILLATE.get());
        output.accept(ModItems.VANILLATE_CRUMBLE.get());
    }).build());
}
