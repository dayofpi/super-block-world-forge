package com.dayofpi.super_block_world.util;

import com.dayofpi.super_block_world.SuperBlockWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> STAR_BITS = tag("star_bits");
        public static final TagKey<Item> AMANITA_LOGS = tag("amanita_logs");
        public static final TagKey<Item> MAYOI_LOGS = tag("mayoi_logs");
        public static final TagKey<Item> MUSHROOM_CAPS = tag("mushroom_caps");
        public static final TagKey<Item> FORGE_INGOTS_BRONZE = forgeTag("ingots/bronze");
        public static final TagKey<Item> FORGE_BLOCKS_BRONZE = forgeTag("blocks/bronze");
        public static final TagKey<Item> FORGE_ORES_BRONZE = forgeTag("ores/bronze");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> FLAGS = tag("flags");
        public static final TagKey<Block> WARP_PIPES = tag("warp_pipes");
        public static final TagKey<Block> PIPE_BODIES = tag("pipe_bodies");
        public static final TagKey<Block> BRONZE_BLOCKS = tag("bronze_blocks");
        public static final TagKey<Block> AMANITA_LOGS = tag("amanita_logs");
        public static final TagKey<Block> MAYOI_LOGS = tag("mayoi_logs");
        public static final TagKey<Block> VANILLATE_TOPPING_REPLACEABLE = tag("vanillate_topping_replaceable");
        public static final TagKey<Block> NEEDS_SUPER_PICKAX = tag("needs_super_pickax");
        public static final TagKey<Block> FORGE_BLOCKS_BRONZE = forgeTag("blocks/bronze");
        public static final TagKey<Block> FORGE_ORES_BRONZE = forgeTag("ores/bronze");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> IS_MUSHROOM_KINGDOM = tag("is_mushroom_kingdom");
        public static final TagKey<Biome> HAS_TOSTARENA_RUINS = tag("has_tostarena_ruins");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
        }
    }
}
