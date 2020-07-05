package com.thefabulouscube.paragonia.util;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public enum BoundingBoxes  implements IStringSerializable{

	APPLE("apple",
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(5.5, 0, 5.5, 9.5, 4, 9.5), Block.makeCuboidShape(5.25, -0.25, 5.25, 9.75, 4.25, 9.75), IBooleanFunction.OR),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6.5, 0, 6.5, 10.5, 4, 10.5), Block.makeCuboidShape(6.25, -0.25, 6.25, 10.75, 4.25, 10.75), IBooleanFunction.OR),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(6.5, 0, 5.5, 10.5, 4, 9.5), Block.makeCuboidShape(6.25, -0.25, 5.25, 10.75, 4.25, 9.75), IBooleanFunction.OR),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(5.5, 0, 6.5, 9.5, 4, 10.5), Block.makeCuboidShape(5.25, -0.25, 6.25, 9.75, 4.25, 10.75), IBooleanFunction.OR)
			),

	MEAT_DRUMSTICK("meat_drumstick",
			Stream.of(Block.makeCuboidShape(8, 0, 6.5, 12, 3, 9.5),
					Block.makeCuboidShape(5, 1, 7.5, 8, 2, 8.5), Block.makeCuboidShape(4, 1, 7, 5, 2, 9)).reduce((v1, v2) -> {
						return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
					}).get(),
			Stream.of(Block.makeCuboidShape(4, 0, 6.5, 8, 3, 9.5),
					Block.makeCuboidShape(8, 1, 7.5, 11, 2, 8.5), Block.makeCuboidShape(11, 1, 7, 12, 2, 9))
					.reduce((v1, v2) -> {
						return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
					}).get(),
			Stream.of(Block.makeCuboidShape(6.5, 0, 8, 9.5, 3, 12),
					Block.makeCuboidShape(7.5, 1, 5, 8.5, 2, 8), Block.makeCuboidShape(7, 1, 4,
					9, 2, 5)).reduce((v1, v2) -> { return VoxelShapes.combineAndSimplify(v1, v2,
					IBooleanFunction.OR); }).get(),
			Stream.of(Block.makeCuboidShape(6.5, 0, 4, 9.5, 3, 8), Block.makeCuboidShape(7.5, 1, 8,
					  8.5, 2, 11), Block.makeCuboidShape(7, 1, 11, 9, 2, 12) ).reduce((v1, v2) ->
					  {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()
			);
	
	
	private final VoxelShape north, south, east, west;
	private final String name;
	
	BoundingBoxes(String nameIn, VoxelShape northIn, VoxelShape southIn, VoxelShape eastIn, VoxelShape westIn) {
		this.name =  nameIn;
		this.north = northIn;
		this.east = eastIn;
		this.south = southIn;
		this.west = westIn;
	}
	   public String getName() {
		      return this.name;
		   }
	public VoxelShape getNorthBB() {
		return this.north;
	}
	public VoxelShape getSouthBB() {
		return this.south;
	}
	public VoxelShape getEastBB() {
		return this.east;
	}
	public VoxelShape getWestBB() {
		return this.west;
	}

}
