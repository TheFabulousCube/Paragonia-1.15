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
		Paragonia.LOGGER.info("Hit Haunt Player Dearly Departed" + dearlyDeparted.getEntityString());
		World world = event.getEntity().getEntityWorld();
		if (dearlyDeparted != null && !(dearlyDeparted instanceof GhostEntity) && !(killer instanceof GhostEntity)) {
//			player.getPosition();
			if (killer != null && killer instanceof LivingEntity) {  // consistantly crashed for null
				Paragonia.LOGGER.info("Hit Haunt Player Killer" + killer.getEntityString());
//				Try passing in the killer to the constructor
				GhostEntity ghost = new GhostEntity(EntityInit.GHOST.get(), world);
				ghost.setKiller(killer);
				ghost.setAttackTarget(killer);
//				killer.setGlowing(true);
				ghost.setRevengeTarget(killer);
				ghost.setLocationAndAngles(dearlyDeparted.getPosX(), dearlyDeparted.getPosY(), dearlyDeparted.getPosZ(), 0, 0);
				if (!world.isRemote && ghost.setKiller((LivingEntity) killer)) {
					Paragonia.LOGGER.info("Haunt Player Event hit killer: " + ghost.getKiller());
					Paragonia.LOGGER.info("Haunt Player Event attackTarget: " + ghost.getAttackTarget());
					Paragonia.LOGGER.info("Haunt Player Event revengeTarget: " + ghost.getRevengeTarget());
					world.addEntity(ghost);
					Paragonia.LOGGER.info("there should be a " + ghost + " attacking: " + event.getSource().getTrueSource());
				} else {

					Paragonia.LOGGER.info("The " + ghost + " can't find its killer");
				}

			}
		}
	}

}
