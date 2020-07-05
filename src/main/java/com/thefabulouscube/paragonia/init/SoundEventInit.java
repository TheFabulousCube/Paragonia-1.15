package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEventInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			Paragonia.MOD_ID);
}
