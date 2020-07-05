package com.thefabulouscube.paragonia.objects.items;

import com.thefabulouscube.paragonia.entities.WoodSpriteEntity;
import com.thefabulouscube.paragonia.init.EntityInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class WoodSpriteSpawnEgg extends MySpawnEggItem {
	private static final int primaryColor = 8606770;
	private static final int secondaryColor = 10824234;
	
	public WoodSpriteSpawnEgg(Properties builder) {
		super((() -> EntityType.Builder.create(WoodSpriteEntity::new, EntityClassification.CREATURE)
				.size(0.6F, 1.7F).build("wood_sprite")), primaryColor, secondaryColor, builder);
		// TODO Auto-generated constructor stub
	}


	@Override
	public EntityType<?> getEntityType() {
		return EntityInit.WOOD_SPRITE.get();
	}

}
