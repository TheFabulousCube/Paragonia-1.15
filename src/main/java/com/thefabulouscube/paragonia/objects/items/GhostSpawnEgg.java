package com.thefabulouscube.paragonia.objects.items;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.entities.GhostEntity;
import com.thefabulouscube.paragonia.init.EntityInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class GhostSpawnEgg extends MySpawnEggItem {
	private static final int primaryColor = 5636095;
	private static final int secondaryColor = 43690;

	public GhostSpawnEgg(Properties builder) {
		super((() -> EntityType.Builder.create(GhostEntity::new, EntityClassification.CREATURE)
				.size(0.6F, 1.7F).build("ghost")), primaryColor, secondaryColor, builder);
		Paragonia.LOGGER.info("Ghost Spoawn Egg");
	}

	@Override
	public EntityType<?> getEntityType() {
		return EntityInit.GHOST.get();
	}

}
