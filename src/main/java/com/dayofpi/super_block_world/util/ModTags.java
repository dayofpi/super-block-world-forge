package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> STAR_BITS = tag("star_bits");
        public static final TagKey<Item> AMANITA_LOGS = tag("amanita_logs");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> WARP_PIPES = tag("warp_pipes");
        public static final TagKey<Block> PIPE_BODIES = tag("pipe_bodies");
        public static final TagKey<Block> AMANITA_LOGS = tag("amanita_logs");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
        }
    }
}
