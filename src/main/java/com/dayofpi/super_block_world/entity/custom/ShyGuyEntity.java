package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.block.ModBlocks;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class ShyGuyEntity extends Monster implements VariantHolder<ShyGuyEntity.Type> {
    private static final EntityDataAccessor<String> DATA_TYPE = SynchedEntityData.defineId(ShyGuyEntity.class, EntityDataSerializers.STRING);
    public final AnimationState idleAnimationState = new AnimationState();

    public ShyGuyEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.5));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, livingEntity -> !livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SHY_GUY_MASK.get())));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 7.0).add(Attributes.MAX_HEALTH, 18.0).add(Attributes.MOVEMENT_SPEED, 0.2).add(Attributes.ATTACK_DAMAGE, 3.0);
    }

    public static boolean checkShyGuySpawnRules(EntityType<? extends ShyGuyEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos blockPos, RandomSource randomSource) {
        if (!level.getBiome(blockPos).is(ModTags.Biomes.SPAWNS_SURFACE_SHY_GUYS) && (level.canSeeSky(blockPos) || !Monster.isDarkEnoughToSpawn(level, blockPos, randomSource))) {
            return false;
        }
        return randomSource.nextInt(5) == 0 && !(level.getBrightness(LightLayer.BLOCK, blockPos) > 0);
    }

    @Override
    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        return 0.0F;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.SHY_GUY_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSoundEvents.SHY_GUY_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.SHY_GUY_DEATH.get();
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving(), this.tickCount);
        }
        super.tick();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setVariant(Util.getRandomSafe(Arrays.stream(Type.values()).toList(), pLevel.getRandom()).orElse(Type.RED));
        this.populateDefaultEquipmentSlots(pLevel.getRandom(), pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        if (pRandom.nextInt(5) == 0 && this.shouldSpawnMinerShyGuy(level().getBlockState(this.blockPosition().below()))) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_PICKAXE));
        }
    }

    private boolean shouldSpawnMinerShyGuy(BlockState blockState) {
        return blockState.is(ModBlocks.VANILLATE.get()) || blockState.is(ModBlocks.TOPPED_VANILLATE.get());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE, Type.RED.getSerializedName());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("Type", this.getVariant().getSerializedName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(Type.byName(pCompound.getString("Type")));
    }

    @Override
    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_TYPE, pVariant.name);
    }

    @Override
    public Type getVariant() {
        return Type.byName(this.entityData.get(DATA_TYPE));
    }

    public enum Type implements StringRepresentable {
        RED("red"),
        LIGHT_BLUE("light_blue"),
        BLUE("blue"),
        PINK("pink");

        public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        static Type byName(String pName) {
            return CODEC.byName(pName, RED);
        }
    }
}
