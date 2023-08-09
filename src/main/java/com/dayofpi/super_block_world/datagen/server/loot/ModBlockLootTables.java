package com.dayofpi.super_block_world.datagen.server.loot;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.POWER_STAR.get());
        dropSelf(ModBlocks.PULL_BLOCK.get());
        dropSelf(ModBlocks.WHITE_BRONZE.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BRONZE.get());
        dropSelf(ModBlocks.GRAY_BRONZE.get());
        dropSelf(ModBlocks.BLACK_BRONZE.get());
        dropSelf(ModBlocks.BROWN_BRONZE.get());
        dropSelf(ModBlocks.RED_BRONZE.get());
        dropSelf(ModBlocks.ORANGE_BRONZE.get());
        dropSelf(ModBlocks.YELLOW_BRONZE.get());
        dropSelf(ModBlocks.LIME_BRONZE.get());
        dropSelf(ModBlocks.GREEN_BRONZE.get());
        dropSelf(ModBlocks.CYAN_BRONZE.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BRONZE.get());
        dropSelf(ModBlocks.BLUE_BRONZE.get());
        dropSelf(ModBlocks.PURPLE_BRONZE.get());
        dropSelf(ModBlocks.MAGENTA_BRONZE.get());
        dropSelf(ModBlocks.PINK_BRONZE.get());
        dropSelf(ModBlocks.FLAGPOLE.get());
        dropSelf(ModBlocks.WHITE_FLAG.get());
        dropSelf(ModBlocks.LIGHT_GRAY_FLAG.get());
        dropSelf(ModBlocks.GRAY_FLAG.get());
        dropSelf(ModBlocks.BLACK_FLAG.get());
        dropSelf(ModBlocks.BROWN_FLAG.get());
        dropSelf(ModBlocks.RED_FLAG.get());
        dropSelf(ModBlocks.ORANGE_FLAG.get());
        dropSelf(ModBlocks.YELLOW_FLAG.get());
        dropSelf(ModBlocks.LIME_FLAG.get());
        dropSelf(ModBlocks.GREEN_FLAG.get());
        dropSelf(ModBlocks.CYAN_FLAG.get());
        dropSelf(ModBlocks.LIGHT_BLUE_FLAG.get());
        dropSelf(ModBlocks.BLUE_FLAG.get());
        dropSelf(ModBlocks.PURPLE_FLAG.get());
        dropSelf(ModBlocks.MAGENTA_FLAG.get());
        dropSelf(ModBlocks.PINK_FLAG.get());
        dropSelf(ModBlocks.RAINBOW_FLAG.get());
        dropSelf(ModBlocks.WHITE_WARP_PIPE.get());
        dropSelf(ModBlocks.LIGHT_GRAY_WARP_PIPE.get());
        dropSelf(ModBlocks.GRAY_WARP_PIPE.get());
        dropSelf(ModBlocks.BLACK_WARP_PIPE.get());
        dropSelf(ModBlocks.BROWN_WARP_PIPE.get());
        dropSelf(ModBlocks.RED_WARP_PIPE.get());
        dropSelf(ModBlocks.ORANGE_WARP_PIPE.get());
        dropSelf(ModBlocks.YELLOW_WARP_PIPE.get());
        dropSelf(ModBlocks.LIME_WARP_PIPE.get());
        dropSelf(ModBlocks.GREEN_WARP_PIPE.get());
        dropSelf(ModBlocks.CYAN_WARP_PIPE.get());
        dropSelf(ModBlocks.LIGHT_BLUE_WARP_PIPE.get());
        dropSelf(ModBlocks.BLUE_WARP_PIPE.get());
        dropSelf(ModBlocks.PURPLE_WARP_PIPE.get());
        dropSelf(ModBlocks.MAGENTA_WARP_PIPE.get());
        dropSelf(ModBlocks.PINK_WARP_PIPE.get());
        dropSelf(ModBlocks.WHITE_PIPE_BODY.get());
        dropSelf(ModBlocks.LIGHT_GRAY_PIPE_BODY.get());
        dropSelf(ModBlocks.GRAY_PIPE_BODY.get());
        dropSelf(ModBlocks.BLACK_PIPE_BODY.get());
        dropSelf(ModBlocks.BROWN_PIPE_BODY.get());
        dropSelf(ModBlocks.RED_PIPE_BODY.get());
        dropSelf(ModBlocks.ORANGE_PIPE_BODY.get());
        dropSelf(ModBlocks.YELLOW_PIPE_BODY.get());
        dropSelf(ModBlocks.LIME_PIPE_BODY.get());
        dropSelf(ModBlocks.GREEN_PIPE_BODY.get());
        dropSelf(ModBlocks.CYAN_PIPE_BODY.get());
        dropSelf(ModBlocks.LIGHT_BLUE_PIPE_BODY.get());
        dropSelf(ModBlocks.BLUE_PIPE_BODY.get());
        dropSelf(ModBlocks.PURPLE_PIPE_BODY.get());
        dropSelf(ModBlocks.MAGENTA_PIPE_BODY.get());
        dropSelf(ModBlocks.PINK_PIPE_BODY.get());
        dropSelf(ModBlocks.TOADSTOOL_SOIL.get());
        dropSelf(ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        dropOther(ModBlocks.TOADSTOOL_PATH.get(), ModItems.TOADSTOOL_SOIL.get());
        dropSelf(ModBlocks.RAW_BRONZE_BLOCK.get());
        dropSelf(ModBlocks.BRONZE_BLOCK.get());
        dropSelf(ModBlocks.BRONZE_STAIRS.get());
        slab(ModBlocks.BRONZE_SLAB);
        dropSelf(ModBlocks.VANILLATE_STAIRS.get());
        slab(ModBlocks.VANILLATE_SLAB);
        dropSelf(ModBlocks.VANILLATE_WALL.get());
        dropSelf(ModBlocks.VANILLATE_CRUMBLE.get());
        dropSelf(ModBlocks.VANILLATE_BRICKS.get());
        dropSelf(ModBlocks.VANILLATE_BRICK_STAIRS.get());
        slab(ModBlocks.VANILLATE_BRICK_SLAB);
        dropSelf(ModBlocks.VANILLATE_BRICK_WALL.get());
        dropSelf(ModBlocks.VANILLATE_TILES.get());
        dropSelf(ModBlocks.VANILLATE_TILE_STAIRS.get());
        slab(ModBlocks.VANILLATE_TILE_SLAB);
        dropSelf(ModBlocks.VANILLATE_TILE_WALL.get());
        dropSelf(ModBlocks.TOADSTONE.get());
        dropSelf(ModBlocks.TOADSTONE_STAIRS.get());
        slab(ModBlocks.TOADSTONE_SLAB);
        dropSelf(ModBlocks.TOADSTONE_WALL.get());
        dropSelf(ModBlocks.TOADSTONE_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_TOADSTONE_BRICKS.get());
        dropSelf(ModBlocks.TOADSTONE_BRICK_STAIRS.get());
        slab(ModBlocks.TOADSTONE_BRICK_SLAB);
        dropSelf(ModBlocks.TOADSTONE_BRICK_WALL.get());
        dropSelf(ModBlocks.SMOOTH_TOADSTONE.get());
        dropSelf(ModBlocks.SMOOTH_TOADSTONE_STAIRS.get());
        slab(ModBlocks.SMOOTH_TOADSTONE_SLAB);
        dropSelf(ModBlocks.HARDSTONE.get());
        dropSelf(ModBlocks.HARDSTONE_STAIRS.get());
        slab(ModBlocks.HARDSTONE_SLAB);
        dropSelf(ModBlocks.HARDSTONE_WALL.get());
        dropSelf(ModBlocks.CHISELED_HARDSTONE.get());
        dropSelf(ModBlocks.HARDSTONE_BRICKS.get());
        dropSelf(ModBlocks.CRACKED_HARDSTONE_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_HARDSTONE_BRICKS.get());
        dropSelf(ModBlocks.HARDSTONE_BRICK_STAIRS.get());
        slab(ModBlocks.HARDSTONE_BRICK_SLAB);
        dropSelf(ModBlocks.HARDSTONE_BRICK_WALL.get());
        dropSelf(ModBlocks.HARDSTONE_PILLAR.get());
        dropSelf(ModBlocks.SMOOTH_HARDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_HARDSTONE_STAIRS.get());
        slab(ModBlocks.SMOOTH_HARDSTONE_SLAB);
        dropSelf(ModBlocks.PACKED_CLOUD.get());
        dropSelf(ModBlocks.CLOUD_STAIRS.get());
        slab(ModBlocks.CLOUD_SLAB);
        dropSelf(ModBlocks.MOON_ROCK.get());
        dropSelf(ModBlocks.RAINBOW_TILES.get());
        dropSelf(ModBlocks.RAINBOW_TILE_STAIRS.get());
        slab(ModBlocks.RAINBOW_TILE_SLAB);
        dropSelf(ModBlocks.RAINBOW_TILE_WALL.get());
        dropSelf(ModBlocks.AMANITA_LOG.get());
        dropSelf(ModBlocks.AMANITA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_AMANITA_LOG.get());
        dropSelf(ModBlocks.STRIPPED_AMANITA_WOOD.get());
        dropSelf(ModBlocks.AMANITA_PLANKS.get());
        dropSelf(ModBlocks.AMANITA_STAIRS.get());
        slab(ModBlocks.AMANITA_SLAB);
        dropSelf(ModBlocks.AMANITA_FENCE.get());
        dropSelf(ModBlocks.AMANITA_FENCE_GATE.get());
        add(ModBlocks.AMANITA_DOOR.get(), this::createDoorTable);
        dropSelf(ModBlocks.AMANITA_TRAPDOOR.get());
        dropSelf(ModBlocks.AMANITA_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.AMANITA_BUTTON.get());
        dropSelf(ModBlocks.AMANITA_SIGN.get());
        dropSelf(ModBlocks.AMANITA_HANGING_SIGN.get());
        add(ModBlocks.AMANITA_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.AMANITA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.FRUITING_AMANITA_LEAVES.get(), block -> createFruitingLeavesDrops(block, ModBlocks.AMANITA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.AMANITA_SAPLING.get());
        add(ModBlocks.TOADSTOOL_GRASS.get(), createSingleItemTableWithSilkTouch(ModBlocks.TOADSTOOL_GRASS.get(), ModItems.TOADSTOOL_SOIL.get()));
        add(ModBlocks.BRONZE_ORE.get(), createOreDrop(ModBlocks.BRONZE_ORE.get(), ModItems.RAW_BRONZE.get()));
        add(ModBlocks.VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.TOPPED_VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.TOPPED_VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.STAR_CLUSTER.get(), createSilkTouchOnlyTable(ModBlocks.STAR_CLUSTER.get()).withPool(applyExplosionCondition(ModItems.STAR_CLUSTER.get(), LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F)).add(LootItem.lootTableItem(ModItems.YELLOW_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.RED_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.BLUE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.PURPLE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F)))).when(HAS_NO_SILK_TOUCH)));
        add(ModBlocks.WHITE_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(ModBlocks.YELLOW_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(ModBlocks.POTTED_AMANITA_SAPLING.get(), createPotFlowerItemTable(ModItems.AMANITA_SAPLING.get()));
    }

    protected LootTable.Builder createFruitingLeavesDrops(Block leavesBlock, Block saplingBlock, float... chances) {
        return this.createLeavesDrops(leavesBlock, saplingBlock, chances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(ModItems.YOSHI_FRUIT.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))));
    }

    private void slab(RegistryObject<Block> blockRegistryObject) {
        add(blockRegistryObject.get(), block -> createSlabItemTable(blockRegistryObject.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
