package com.thefabulouscube.paragonia.util;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IStringSerializable;

public class MyBlockStateProperties extends BlockStateProperties {

	public static final BooleanProperty HORIZONTAL = BooleanProperty.create("horizontal");
	public static final BooleanProperty VERTICAL = BooleanProperty.create("vertical");
	public static final EnumProperty<Level> LEVEL = EnumProperty.create("level", Level.class);
	public static final EnumProperty<AllFacing> ALLFACES = EnumProperty.create("facing", AllFacing.class);
	public static final EnumProperty<AllFacing> DIAGONALS = EnumProperty.create("facing", AllFacing.class,
			v -> v.getIndex() % 2 == 0);
	public static final EnumProperty<AllFacing> CARDINAL = EnumProperty.create("facing", AllFacing.class,
			d -> d.getIndex() % 4 == 0);
	public static final EnumProperty<WideBlockPart> WIDEBLOCK_PART = EnumProperty.create("part", WideBlockPart.class);
	public static final EnumProperty<ThreeState> THREESTATE = EnumProperty.create("state", ThreeState.class);
	public static final EnumProperty<BoundingBoxes> AABB = EnumProperty.create("aabb", BoundingBoxes.class,
			BoundingBoxes.values());

	public enum WideBlockPart implements IStringSerializable {
		LEFT("left"), RIGHT("right");

		private final String name;

		private WideBlockPart(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

	}

	public enum ThreeState implements IStringSerializable {
		LEFT(0, "left"), 
		MIDDLE(1, "middle"), 
		RIGHT(2, "right");

	    private final int index;
		private final String name;

		private ThreeState(int index, String name) {
	    	this.index = index;
	    	this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public ThreeState getNext() {

			switch (this) {
			case LEFT:
				return MIDDLE;
			case MIDDLE:
				return RIGHT;
			case RIGHT:
				return LEFT;
			default:
				return MIDDLE;
			}
		}

	    public int getIndex()
	    {
	        return this.index;
	    }

	}
}
