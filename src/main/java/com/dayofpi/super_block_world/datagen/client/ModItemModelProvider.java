package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.POWER_STAR);
        simpleBlockItem(ModItems.STAR_CLUSTER);
        simpleBlockItem(ModItems.WHITE_FLOWERBED);
        simpleBlockItem(ModItems.YELLOW_FLOWERBED);
        simpleItem(ModItems.WARP_PAINTING);
        simpleItem(ModItems.RAW_BRONZE);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.POWER_SHARD);
        simpleItem(ModItems.YELLOW_STAR_BIT);
        simpleItem(ModItems.GREEN_STAR_BIT);
        simpleItem(ModItems.BLUE_STAR_BIT);
        simpleItem(ModItems.PURPLE_STAR_BIT);
        simpleItem(ModItems.SUBCON_THREAD);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(SuperBlockWorld.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void simpleBlockItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(SuperBlockWorld.MOD_ID, "block/" + item.getId().getPath()));
    }
}
