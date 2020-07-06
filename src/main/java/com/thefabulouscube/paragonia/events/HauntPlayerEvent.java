package com.thefabulouscube.paragonia.events;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.entities.GhostEntity;
import com.thefabulouscube.paragonia.init.EntityInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Paragonia.MOD_ID, bus = Bus.FORGE)
public class HauntPlayerEvent {

	@SubscribeEvent
	public static void hauntPlayerEvent(LivingDeathEvent event) {
		LivingEntity dearlyDeparted = event.getEntityLiving();
			LivingEntity killer = event.getSource().getTrueSource() instanceof LivingEntity ? (LivingEntity)event.getSource().getTrueSource() : null;
		World world = event.getEntity().getEntityWorld();
		if (dearlyDeparted != null && !(dearlyDeparted instanceof GhostEntity) && !(killer instanceof GhostEntity)) {
			if (killer != null && killer instanceof LivingEntity) {  // consistantly crashed for null
				GhostEntity ghost = new GhostEntity(EntityInit.GHOST.get(), world);
				ghost.setKiller(killer);
				ghost.setAttackTarget(killer);
				ghost.setRevengeTarget(killer);
				ghost.setLocationAndAngles(dearlyDeparted.getPosX(), dearlyDeparted.getPosY(), dearlyDeparted.getPosZ(), 0, 0);
				if (!world.isRemote && ghost.setKiller((LivingEntity) killer)) {
					world.addEntity(ghost);
				}
			}
		}
	}

}
