package com.thefabulouscube.paragonia.client.entity.render;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.client.entity.model.GhostModel;
import com.thefabulouscube.paragonia.entities.GhostEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GhostRender extends MobRenderer<GhostEntity, GhostModel<GhostEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Paragonia.MOD_ID, "textures/entity/ghost.png");
	
	public GhostRender(EntityRendererManager renderMangerIn) {
		super(renderMangerIn, new GhostModel<GhostEntity>(), 0.0F);
	}

	@Override
	public ResourceLocation getEntityTexture(GhostEntity entity) {
		return TEXTURE;
	}
}
