package com.dayofpi.super_block_world.datagen.server.loot;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.POWER_STAR.get());
        dropSelf(ModBlocks.VANILLATE_CRUMBLE.get());
        dropSelf(ModBlocks.VANILLATE_BRICKS.get());
        dropSelf(ModBlocks.VANILLATE_TILES.get());
        dropSelf(ModBlocks.TOADSTONE.get());
        dropSelf(ModBlocks.TOADSTONE_BRICKS.get());
        dropSelf(ModBlocks.SMOOTH_TOADSTONE.get());
        dropSelf(ModBlocks.HARDSTONE.get());
        dropSelf(ModBlocks.HARDSTONE_BRICKS.get());
        dropSelf(ModBlocks.SMOOTH_HARDSTONE.get());
        add(ModBlocks.VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.VANILLATE.get(), ModBlocks.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.TOPPED_VANILLATE.get(), createSingleItemTableWithSilkTouch(ModBlocks.TOPPED_VANILLATE.get(), ModBlocks.VANILLATE_CRUMBLE.get()));
        add(ModBlocks.STAR_CLUSTER.get(), createSilkTouchOnlyTable(ModBlocks.STAR_CLUSTER.get()).withPool(applyExplosionCondition(ModBlocks.STAR_CLUSTER.get(), LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F)).add(LootItem.lootTableItem(ModItems.YELLOW_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.GREEN_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.BLUE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.PURPLE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F)))).when(HAS_NO_SILK_TOUCH)));
        add(ModBlocks.WHITE_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(ModBlocks.YELLOW_FLOWERBED.get(), BlockLootSubProvider::createShearsOnlyDrop);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
