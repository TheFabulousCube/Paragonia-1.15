package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.entities.GhostEntity;
import com.thefabulouscube.paragonia.entities.WoodSpriteEntity;
import com.thefabulouscube.paragonia.events.SittableEvent.SeatEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			Paragonia.MOD_ID);

	public static final RegistryObject<EntityType<SeatEntity>> SEAT = ENTITY_TYPES.register("seat",
			() -> EntityType.Builder.<SeatEntity>create(SeatEntity::new, EntityClassification.MISC).size(0.0f, 0.0f)
					.build(new ResourceLocation(Paragonia.MOD_ID, "seat").toString()));

	
	public static final RegistryObject<EntityType<GhostEntity>> GHOST = ENTITY_TYPES
			.register("ghost", () -> EntityType.Builder.create(GhostEntity::new, EntityClassification.CREATURE)
					.size(0.6F, 1.7F)
					.build("ghost"));
	
	public static final RegistryObject<EntityType<WoodSpriteEntity>> WOOD_SPRITE = ENTITY_TYPES
			.register("wood_sprite", () -> EntityType.Builder.create(WoodSpriteEntity::new, EntityClassification.CREATURE)
					.size(0.6F, 1.7F)
					.build("wood_sprite"));

}	
