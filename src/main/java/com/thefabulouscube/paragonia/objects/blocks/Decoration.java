package com.thefabulouscube.paragonia.objects.blocks;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.util.AABB;
import com.thefabulouscube.paragonia.util.CreativeTabs;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.AxisAlignedBB;

public class Decoration extends DirectionalBlock {
	
	protected AxisAlignedBB boundingBox;
	private ItemGroup tab;

	public Decoration(Properties material) {
		super(material, AABB.MEAT_DRUMSTICK);
		this.tab = CreativeTabs.DECORATIONS;
 
		Paragonia.LOGGER.info("BlockBasic: " + this.tab + ": "+ this.getRegistryName());
	}
}
