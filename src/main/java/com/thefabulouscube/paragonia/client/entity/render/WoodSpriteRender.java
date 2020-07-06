package com.thefabulouscube.paragonia.client.entity.render;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.client.entity.model.WoodSpriteModel;
import com.thefabulouscube.paragonia.entities.WoodSpriteEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WoodSpriteRender extends MobRenderer<WoodSpriteEntity, WoodSpriteModel<WoodSpriteEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Paragonia.MOD_ID, "textures/entity/sprite_oak.png");

	public WoodSpriteRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WoodSpriteModel<WoodSpriteEntity>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(WoodSpriteEntity entity) {
		return TEXTURE;
	}
}
