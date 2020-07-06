package com.thefabulouscube.paragonia.events;

import java.util.List;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.init.EntityInit;
import com.thefabulouscube.paragonia.objects.blocks.OrthoBlock;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Paragonia.MOD_ID, bus = Bus.FORGE)
public class SittableEvent {

	@SubscribeEvent
	public static <T> void onInteractWithBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity player = event.getPlayer();
		if (player.getRidingEntity() != null)
		{
			return;
		}
		
		World worldIn = event.getWorld();
		BlockPos pos = event.getPos();
		Vec3d vec = new Vec3d(pos.getX(), pos.getY(), pos.getZ());
		double maxDist = 2.0D;
		if ((vec.x - player.getPosX()) * (vec.x - player.getPosX()) + (vec.z - player.getPosZ()) * (vec.z - player.getPosZ()) > maxDist * maxDist)
		{
			return;
		}
		
		BlockState state = worldIn.getBlockState(pos);
		ItemStack mainStack = player.getHeldItemMainhand();
		ItemStack offStack = player.getHeldItemOffhand();
		if (worldIn.isRemote || (!mainStack.isEmpty() || !offStack.isEmpty()))
		{
			return;
		}
		
		if (state.getBlock() instanceof OrthoBlock && ((OrthoBlock) state.getBlock()).isSittable())
		{
//			Paragonia.LOGGER.info("Seat is at " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ());
			SeatEntity block = new SeatEntity(worldIn, pos);
			worldIn.addEntity(block);
			player.startRiding(block);
		}
	}
	

		public static class SeatEntity extends Entity
		{//The type SittableEvent.SeatEntity does not define SeatEntity(EntityType<SittableEvent.SeatEntity>, World) t
			public SeatEntity(World worldIn, BlockPos pos)
			{
				this(EntityInit.SEAT.get(), worldIn);
				setPosition(pos.getX(), pos.getY() + (10/16), pos.getZ());
			}

			public SeatEntity(EntityType<SittableEvent.SeatEntity> type, World worldIn) {
				super(type, worldIn);
			}
			
			@Override
			public void tick() 
			{//Paragonia.LOGGER.info("Seat Base Tick");
				BlockPos pos = getPosition();
				if (!(getEntityWorld().getBlockState(pos).getBlock() instanceof OrthoBlock))
				{
					remove();
					return;
				}
				
				List<Entity> passengers = getPassengers();
				if(passengers.isEmpty())
				{
					remove();
				}
				for (Entity entity : passengers)
				{
					if (entity.isCrouching())
					{
						remove();
					}
				}
			}
			

			@Override
			protected void registerData() {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected void readAdditional(CompoundNBT compound) {
//			      super.readAdditional(compound);
				
			}

			@Override
			protected void writeAdditional(CompoundNBT compound) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				// TODO Auto-generated method stub
				return null;
			}
		}

}
