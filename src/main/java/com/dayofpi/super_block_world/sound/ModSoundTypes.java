package com.dayofpi.super_block_world.sound;

import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;

public class ModSoundTypes {
    public static final SoundType TOADSTONE = new ForgeSoundType(1.0f, 1.0f, ModSoundEvents.TOADSTONE_BREAK, ModSoundEvents.TOADSTONE_STEP, ModSoundEvents.TOADSTONE_PLACE, ModSoundEvents.TOADSTONE_HIT, ModSoundEvents.TOADSTONE_FALL);
    public static final SoundType GRASSY_TOADSTONE = new ForgeSoundType(1.0f, 1.0f, ModSoundEvents.GRASSY_TOADSTONE_BREAK, ModSoundEvents.GRASSY_TOADSTONE_STEP, ModSoundEvents.GRASSY_TOADSTONE_PLACE, ModSoundEvents.GRASSY_TOADSTONE_HIT, ModSoundEvents.GRASSY_TOADSTONE_FALL);
    public static final SoundType ROYALITE = new ForgeSoundType(1.0f, 1.0f, ModSoundEvents.ROYALITE_BREAK, ModSoundEvents.ROYALITE_STEP, ModSoundEvents.ROYALITE_PLACE, ModSoundEvents.ROYALITE_HIT, ModSoundEvents.ROYALITE_FALL);
}
