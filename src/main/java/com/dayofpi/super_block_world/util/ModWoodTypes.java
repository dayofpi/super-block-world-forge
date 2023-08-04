package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public interface ModWoodTypes {
    WoodType AMANITA = WoodType.register(new WoodType(SuperBlockWorld.MOD_ID + ":amanita", BlockSetType.OAK));
}
