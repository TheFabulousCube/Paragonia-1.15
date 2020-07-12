package com.thefabulouscube.paragonia.objects.blocks;

import com.thefabulouscube.paragonia.util.AABB;

import net.minecraft.block.Block;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class FoodBlock extends RotationalBlock {

	private Food food;
	private Block emptyDish;
	
	public FoodBlock(Properties properties, Food foodIn, AABB apple) {
		super(properties, apple);
		this.food = foodIn;
	}
	
	public Food getFood() {
		return food;
	}

	public Item getReturnedItem() {
		return emptyDish == null ? null : emptyDish.asItem();
	}

	public FoodBlock returns(Block block) {
		this.emptyDish = block;
		return this;
	}

}
