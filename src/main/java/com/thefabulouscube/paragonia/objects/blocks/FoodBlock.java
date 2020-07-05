package com.thefabulouscube.paragonia.objects.blocks;

import com.thefabulouscube.paragonia.util.AABB;

import net.minecraft.item.Food;

public class FoodBlock extends RotationalBlock {

	private Food food;
	public FoodBlock(Properties properties, Food foodIn, AABB apple) {
		super(properties, apple);
		this.food = foodIn;
	}
	
	public Food getFood() {
		return food;
	}

}
