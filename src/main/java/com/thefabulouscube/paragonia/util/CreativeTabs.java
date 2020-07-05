package com.thefabulouscube.paragonia.util;

import com.thefabulouscube.paragonia.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CreativeTabs extends ItemGroup {
	   public static final ItemGroup DECORATIONS = new ItemGroup(ItemGroup.GROUPS.length, "decorations") {
		      @OnlyIn(Dist.CLIENT)
		      public ItemStack createIcon() {
		         return new ItemStack(ItemInit.DECORATIONS.get());
		      }
		   };

		   public static final ItemGroup CREATURES = new ItemGroup(ItemGroup.GROUPS.length, "creatures") {
			      @OnlyIn(Dist.CLIENT)
			      public ItemStack createIcon() {
			         return new ItemStack(ItemInit.CREATURES.get());
			      }
			   };

			   public static final ItemGroup FURNITURE = new ItemGroup(ItemGroup.GROUPS.length, "furniture") {
				      @OnlyIn(Dist.CLIENT)
				      public ItemStack createIcon() {
				         return new ItemStack(ItemInit.FURNITURE.get());
				      }
				   };
	
	public CreativeTabs(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	public CreativeTabs(int index, String label) {
		super(index, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return null;
	}


}
