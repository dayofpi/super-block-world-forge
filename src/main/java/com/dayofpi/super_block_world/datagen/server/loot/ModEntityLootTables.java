package com.dayofpi.super_block_world.datagen.server.loot;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        add(ModEntityTypes.SHY_GUY.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.SUBCON_THREAD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))).when(LootItemKilledByPlayerCondition.killedByPlayer())).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModItems.SHY_GUY_MASK.get())).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.2F, 0.02F))));
        add(ModEntityTypes.LUMA.get(), LootTable.lootTable());
        add(ModEntityTypes.HUNGRY_LUMA.get(), LootTable.lootTable());
        add(ModEntityTypes.SMEECH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        add(ModEntityTypes.OCTOOMBA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).add(LootItem.lootTableItem(ModItems.YELLOW_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.RED_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.BLUE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F))).add(LootItem.lootTableItem(ModItems.PURPLE_STAR_BIT.get()).when(LootItemRandomChanceCondition.randomChance(0.3F)))));
        add(ModEntityTypes.CHAIN_CHOMP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.IRON_INGOT).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
        add(ModEntityTypes.UNAGI.get(), LootTable.lootTable());
        add(ModEntityTypes.BOOM_BOOM.get(), LootTable.lootTable());
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntityTypes.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }
}
