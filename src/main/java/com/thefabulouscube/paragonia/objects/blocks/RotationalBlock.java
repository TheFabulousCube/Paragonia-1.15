package com.thefabulouscube.paragonia.objects.blocks;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.util.AABB;
import com.thefabulouscube.paragonia.util.AllFacing;
import com.thefabulouscube.paragonia.util.Level;
import com.thefabulouscube.paragonia.util.MyBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class RotationalBlock extends Block {

	public static final EnumProperty<AllFacing> FACING = MyBlockStateProperties.ALLFACES;
	public static final EnumProperty<Level> LEVEL = MyBlockStateProperties.LEVEL;
	private VoxelShape [][] voxelShapes = new VoxelShape[LEVEL.getAllowedValues().size()][FACING.getAllowedValues().size()];
	
	public RotationalBlock(Properties properties, AABB voxelShapesIn) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, AllFacing.NNN).with(LEVEL, Level.EVEN ));
		for (int i = 0; i < voxelShapes.length; i++) {
			for (int j = 0; j < voxelShapes[i].length; j++) {
				double[][] working = voxelShapesIn.getBoundingBoxes();
				working = ((Level) MyBlockStateProperties.LEVEL.getAllowedValues().toArray()[i]).toLevel(working);
				working = ((AllFacing) MyBlockStateProperties.ALLFACES.getAllowedValues().toArray()[j])
						.toFacing(working);
				this.voxelShapes[i][j] = AABB.toVoxelShape(working);
			}
		}
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return this.voxelShapes[state.get(LEVEL).getIndex()][state.get(FACING).getIndex()];		
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Paragonia.LOGGER.info("RotationalBlock DIRECTION: " + AllFacing.getFacing(context.getPlayer(), context.getPos(), 16) + " LEVEL: " + Level.getLevel(context.getPlayer(), context.getPos()));
		
		return this.stateContainer.getBaseState().with(FACING, AllFacing.getFacing(context.getPlayer(), context.getPos(), 16)).with(LEVEL, Level.getLevel(context.getPlayer(), context.getPos()));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING, LEVEL);
	}

}
