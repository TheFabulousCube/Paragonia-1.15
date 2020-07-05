package com.thefabulouscube.paragonia.util;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.client.entity.render.GhostRender;
import com.thefabulouscube.paragonia.client.entity.render.WoodSpriteRender;
import com.thefabulouscube.paragonia.init.EntityInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Paragonia.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.GHOST.get(), GhostRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.WOOD_SPRITE.get(), WoodSpriteRender::new);

	}
}
