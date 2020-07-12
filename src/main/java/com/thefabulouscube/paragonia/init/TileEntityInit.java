package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.tileentity.ExampleChestTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, Paragonia.MOD_ID);
	
	public static final RegistryObject<TileEntityType<ExampleChestTileEntity>> SACK = TILE_ENTITY_TYPES
			.register("sack",  () -> TileEntityType.Builder
					.create(ExampleChestTileEntity::new, BlockInit.SACK.get()).build(null));
}
