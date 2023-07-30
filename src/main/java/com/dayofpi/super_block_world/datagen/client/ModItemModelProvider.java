package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
