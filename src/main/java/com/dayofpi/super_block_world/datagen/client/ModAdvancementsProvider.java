package com.dayofpi.super_block_world.datagen.client;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.worldgen.dimension.ModDimensions;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementsProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement mushroomKingdomRoot = Advancement.Builder.advancement().display(new DisplayInfo(new ItemStack(ModItems.WARP_PAINTING.get()), Component.translatable("advancements.mushroom_kingdom.root.title"), Component.translatable("advancements.mushroom_kingdom.root.description"), new ResourceLocation(SuperBlockWorld.MOD_ID, "textures/block/toadstone_bricks.png"), FrameType.TASK, false, false, false)).requirements(RequirementsStrategy.OR).addCriterion("has_power_star", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POWER_STAR.get())).addCriterion("entered_mushroom_kingdom", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(ModDimensions.MUSHROOM_KINGDOM_LEVEL)).save(saver, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom/root"), existingFileHelper);
        Advancement enterMushroomKingdom = Advancement.Builder.advancement().display(new DisplayInfo(new ItemStack(ModBlocks.TOADSTOOL_GRASS.get()), Component.translatable("advancements.mushroom_kingdom.enter_dimension.title"), Component.translatable("advancements.mushroom_kingdom.enter_dimension.description"), null, FrameType.TASK, true, true, false)).parent(mushroomKingdomRoot).addCriterion("entered_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(ModDimensions.MUSHROOM_KINGDOM_LEVEL)).save(saver, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom/enter_dimension"), existingFileHelper);
        Advancement breedMooshroom = Advancement.Builder.advancement().display(new DisplayInfo(new ItemStack(Blocks.RED_MUSHROOM_BLOCK), Component.translatable("advancements.mushroom_kingdom.breed_mooshroom.title"), Component.translatable("advancements.mushroom_kingdom.breed_mooshroom.description"), null, FrameType.CHALLENGE, true, true, false)).parent(enterMushroomKingdom).addCriterion("breed_mooshroom", BredAnimalsTrigger.TriggerInstance.bredAnimals(EntityPredicate.Builder.entity().of(EntityType.MOOSHROOM).located(LocationPredicate.inDimension(ModDimensions.MUSHROOM_KINGDOM_LEVEL)))).save(saver, new ResourceLocation(SuperBlockWorld.MOD_ID, "mushroom_kingdom/breed_mooshroom"), existingFileHelper);
    }
}
