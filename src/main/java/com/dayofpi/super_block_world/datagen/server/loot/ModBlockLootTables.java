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
        dropSelf(ModBlocks.TOADSTOOL_SOIL.get());
        dropSelf(ModBlocks.COARSE_TOADSTOOL_SOIL.get());
        dropOther(ModBlocks.TOADSTOOL_PATH.get(), ModItems.TOADSTOOL_SOIL.get());
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
        dropSelf(ModBlocks.TOADSTONE_BRICKS.get());
        dropSelf(ModBlocks.SMOOTH_TOADSTONE.get());
        dropSelf(ModBlocks.SMOOTH_TOADSTONE_STAIRS.get());
        slab(ModBlocks.SMOOTH_TOADSTONE_SLAB);
        dropSelf(ModBlocks.HARDSTONE.get());
        dropSelf(ModBlocks.HARDSTONE_BRICKS.get());
        dropSelf(ModBlocks.SMOOTH_HARDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_HARDSTONE_STAIRS.get());
        slab(ModBlocks.SMOOTH_HARDSTONE_SLAB);
        dropSelf(ModBlocks.PACKED_CLOUD.get());
        dropSelf(ModBlocks.CLOUD_STAIRS.get());
        slab(ModBlocks.CLOUD_SLAB);
        dropSelf(ModBlocks.RAINBOW_TILES.get());
        dropSelf(ModBlocks.RAINBOW_TILE_STAIRS.get());
        slab(ModBlocks.RAINBOW_TILE_SLAB);
        dropSelf(ModBlocks.RAINBOW_TILE_WALL.get());
        dropSelf(ModBlocks.AMANITA_LOG.get());
        dropSelf(ModBlocks.AMANITA_PLANKS.get());
        add(ModBlocks.AMANITA_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.AMANITA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.FRUITING_AMANITA_LEAVES.get(), block -> createFruitingLeavesDrops(block, ModBlocks.AMANITA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.AMANITA_SAPLING.get());
        add(ModBlocks.TOADSTOOL_GRASS.get(), createSingleItemTableWithSilkTouch(ModBlocks.TOADSTOOL_GRASS.get(), ModItems.TOADSTOOL_SOIL.get()));
        add(ModBlocks.VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.TOPPED_VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.TOPPED_VANILLATE.get(), ModItems.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.STAR_CLUSTER.get(), createSilkTouchOnlyTable(ModBlocks.STAR_CLUSTER.get()).withPool(applyExplosionCondition(ModItems.STAR_CLUSTER.get(), LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F)).add(LootItem.lootTableItem(ModItems.YELLOW_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.GREEN_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.BLUE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.PURPLE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F)))).when(HAS_NO_SILK_TOUCH)));
        add(ModBlocks.WHITE_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(ModBlocks.YELLOW_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
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
