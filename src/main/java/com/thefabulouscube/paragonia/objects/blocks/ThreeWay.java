package com.thefabulouscube.paragonia.objects.blocks;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.util.AABB;
import com.thefabulouscube.paragonia.util.AllFacing;
import com.thefabulouscube.paragonia.util.Level;
import com.thefabulouscube.paragonia.util.MyBlockStateProperties;
import com.thefabulouscube.paragonia.util.MyBlockStateProperties.ThreeState;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ThreeWay extends Block {
	

	public static final EnumProperty<AllFacing> FACING = MyBlockStateProperties.CARDINAL;
	public static final EnumProperty<Level> LEVEL = MyBlockStateProperties.LEVEL;
	public static final EnumProperty<ThreeState> LMR = MyBlockStateProperties.THREESTATE;
	private VoxelShape [][][] voxelShapes = new VoxelShape[LMR.getAllowedValues().size()][LEVEL.getAllowedValues().size()][FACING.getAllowedValues().size()];

	public ThreeWay(Properties properties, AABB[] aabbIn) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(LMR, ThreeState.MIDDLE));
		for (int k = 2; k >= 0; k--) {
			for (int i = 0; i < voxelShapes[k].length; i++) {
				for (int j = 0; j < voxelShapes[k][i].length; j++) {
					double[][] working = aabbIn[k].getBoundingBoxes();
					working = ((Level) MyBlockStateProperties.LEVEL.getAllowedValues().toArray()[i]).toLevel(working);
					working = ((AllFacing) MyBlockStateProperties.CARDINAL.getAllowedValues().toArray()[j])
							.toFacing(working);
					this.voxelShapes[k][i][j] = AABB.toVoxelShape(working);
				}
			}
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Paragonia.LOGGER.info("3-way FACING: " + AllFacing.getFacing(context.getPlayer(), context.getPos(), 4)
				+ " LEVEL: " + Level.getLevel(context.getPlayer(), context.getPos()));
		return this.stateContainer.getBaseState()
				.with(FACING, AllFacing.getFacing(context.getPlayer(), context.getPos(), 4))
				.with(LEVEL, Level.getLevel(context.getPlayer(), context.getPos())).with(LMR, ThreeState.MIDDLE);

	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

//		Paragonia.LOGGER.info("threeway LMR: " + state.get(LMR).getIndex() + " Level: " + state.get(LEVEL).getIndex() + " Facing: " + state.get(FACING).getIndex());
//		Paragonia.LOGGER.info("threeway arrays are: [" + voxelShapes.length + "][" + voxelShapes[0].length + "][" + voxelShapes[0][0].length + "}");
		return this.voxelShapes[state.get(LMR).getIndex()][state.get(LEVEL).getIndex()][state.get(FACING).getIndex()/4];		
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING, LEVEL, LMR);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		Paragonia.LOGGER.info("Scale clicked");
 
		ItemStack mainStack = player.getHeldItemMainhand();
		player.getHeldItemOffhand();
		if (mainStack.isEmpty() /** || !offStack.isEmpty() **/)
		{
			Paragonia.LOGGER.info("Scale clicked and mainStack is " + mainStack.getCount());
			ThreeState current = worldIn.getBlockState(pos).get(LMR);
			worldIn.setBlockState(pos, state.with(LMR, current.getNext()), 1);
		}
		return ActionResultType.SUCCESS;
	}

}
