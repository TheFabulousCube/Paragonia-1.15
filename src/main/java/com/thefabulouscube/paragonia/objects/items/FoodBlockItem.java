package com.thefabulouscube.paragonia.objects.items;

import javax.annotation.Nullable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodBlockItem extends Item {

	private Item returnedItem = null;
	
	public FoodBlockItem(Properties properties) {
		super(properties);
	}
	

	   /**
	    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	    * the Item before the action is complete.
	    */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
		PlayerEntity player = null;
		if (entityLiving instanceof PlayerEntity) {
			player = (PlayerEntity) entityLiving;
		}
		if (player != null && player.abilities.isCreativeMode) {
			return itemstack;
		} else if (returnedItem == null) {
			return itemstack;
		} else {
			if (itemstack.getCount() > 0) {

	            if (!player.inventory.addItemStackToInventory(new ItemStack(returnedItem))) {
	               player.dropItem(new ItemStack(returnedItem), false);
	            }
				return itemstack;
			} else {
				return new ItemStack(returnedItem);
			}

		}
	}
	
	public FoodBlockItem returns(@Nullable Item leftover) {
		this.returnedItem = leftover;
		return this;
	}

}
