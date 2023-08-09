package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.entity.SpaceCreature;
import com.dayofpi.super_block_world.worldgen.dimension.ModDimensions;
import com.dayofpi.super_block_world.worldgen.structure.ModStructures;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    private static final ImmutableList<RegistryObject<? extends EntityType<? extends Mob>>> SPAWN_LIST = ImmutableList.of(ModEntityTypes.LUMA, ModEntityTypes.HUNGRY_LUMA);
    @Shadow public abstract ServerLevel getLevel();

    @Inject(at=@At("TAIL"), method = "tickCustomSpawners")
    private void tickCustomSpawners(boolean pSpawnEnemies, boolean pSpawnFriendlies, CallbackInfo ci) {
        ServerLevel level = this.getLevel();
        if (pSpawnFriendlies && level.dimension() == ModDimensions.MUSHROOM_KINGDOM_LEVEL && level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && level.getDayTime() > 17000 && level.getDayTime() < 19000)  {
            Player player = level.getRandomPlayer();
            if (player != null) {
                RandomSource randomsource = level.random;
                int i = (4 + randomsource.nextInt(24)) * (randomsource.nextBoolean() ? -1 : 1);
                int j = (4 + randomsource.nextInt(24)) * (randomsource.nextBoolean() ? -1 : 1);
                BlockPos blockPos = player.blockPosition().offset(i, 0, j);
                if (level.hasChunksAt(blockPos.getX() - 10, blockPos.getZ() - 10, blockPos.getX() + 10, blockPos.getZ() + 10)) {
                    EntityType<? extends Mob> entityType = SPAWN_LIST.get(randomsource.nextInt(SPAWN_LIST.size())).get();
                    if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, level, blockPos, entityType)) {
                        boolean shouldSpawn = false;
                        for (BlockPos blockPos1 : BlockPos.withinManhattan(blockPos, 10, 10, 10)) {
                            if (level.structureManager().getStructureWithPieceAt(blockPos1, ModStructures.MOON_MONOLITH).isValid()) {
                                shouldSpawn = true;
                            }
                        }
                        if (shouldSpawn) {
                            List<Mob> list = this.getLevel().getEntitiesOfClass(Mob.class, (new AABB(blockPos)).inflate(24.0D, 16.0D, 24.0D), entity -> entity instanceof SpaceCreature);
                            if (list.size() < 3) {
                                this.spawnMob(blockPos, this.getLevel(), entityType.create(this.getLevel()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void spawnMob(BlockPos pPos, ServerLevel pServerLevel, Mob mob) {
        if (mob != null) {
            mob.moveTo(pPos, 0.0F, 0.0F);
            ForgeEventFactory.onFinalizeSpawn(mob, pServerLevel, pServerLevel.getCurrentDifficultyAt(pPos), MobSpawnType.NATURAL, null, null);
            pServerLevel.addFreshEntityWithPassengers(mob);
        }
    }
}
