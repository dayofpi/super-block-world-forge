package com.dayofpi.super_block_world.mixin;

import com.dayofpi.super_block_world.sound.ModMusics;
import com.dayofpi.super_block_world.worldgen.dimension.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow @Nullable public LocalPlayer player;

    @Inject(at=@At("HEAD"), method = "getSituationalMusic", cancellable = true)
    private void getSituationalMusic(CallbackInfoReturnable<Music> cir) {
        if (this.player != null) {
            Level level = this.player.level();
            BlockPos blockPos = this.player.blockPosition();

            Holder<Biome> holder = level.getBiome(blockPos);

            if (level.dimension() == ModDimensions.MUSHROOM_KINGDOM_LEVEL) {
                boolean isDay = level.dayTime() < 12300 || level.dayTime() > 23850;
                if (!level.canSeeSkyFromBelowWater(blockPos)) {
                    cir.setReturnValue(ModMusics.CAVE);
                }
                else if (!isDay) {
                    cir.setReturnValue(ModMusics.NIGHT);
                }
                else {
                    cir.setReturnValue(holder.value().getBackgroundMusic().orElse(Musics.GAME));
                }
            }
        }
    }
}
