package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.container.ExampleChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, Paragonia.MOD_ID);
	
	public static final RegistryObject<ContainerType<ExampleChestContainer>> SACK = CONTAINER_TYPES
			.register("sack", () -> IForgeContainerType.create(ExampleChestContainer::new));
}
