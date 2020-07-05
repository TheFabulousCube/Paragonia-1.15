package com.thefabulouscube.paragonia.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.util.MyBlockStateProperties;
import com.thefabulouscube.paragonia.util.MyBlockStateProperties.WideBlockPart;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WideBlock extends HorizontalBlock {
	protected static final VoxelShape BLOCK_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final EnumProperty<WideBlockPart> PART = MyBlockStateProperties.WIDEBLOCK_PART;
//	public static final Block bd = new BedBlock();

	public WideBlock(Block.Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(PART, WideBlockPart.LEFT));
	}

	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Direction direction = context.getPlacementHorizontalFacing();
		BlockPos blockpos = context.getPos();
		BlockPos blockpos1 = blockpos.offset(getDirectionToOther(WideBlockPart.LEFT, direction));
		return context.getWorld().getBlockState(blockpos1).isReplaceable(context)
				? this.getDefaultState().with(HORIZONTAL_FACING, direction)
				: null;
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place
	 * logic
	 */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (!worldIn.isRemote) {
			BlockPos blockpos = pos.offset(getDirectionToOther(state.get(PART), state.get(HORIZONTAL_FACING)));
			worldIn.setBlockState(blockpos, state.with(PART, WideBlockPart.RIGHT), 3);
			worldIn.notifyNeighbors(pos, Blocks.AIR);
			state.updateNeighbors(worldIn, pos, 3);
		}

	}
	   /**
	    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
	    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
	    * of whether the block can receive random update ticks
	    */
	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	      if (rand.nextInt(100) == 0) {
	         worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
	      }

	      for(int i = 0; i < 4; ++i) {
	         double d0 = (double)pos.getX() + (double)rand.nextFloat();
	         double d1 = (double)pos.getY() + (double)rand.nextFloat();
	         double d2 = (double)pos.getZ() + (double)rand.nextFloat();
	         double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
	         double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
	         double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
	         int j = rand.nextInt(2) * 2 - 1;
	         if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
	            d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
	            d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
	         } else {
	            d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
	            d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
	         }

	         worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
	      }

	   }
	
	
/***   Remember this for the scale   ***/
	/*
	 * And how do I change the block state when the player right-clicks my block
	 * with an empty hand? I think I'm close but I can't figure out how to change
	 * the state:
	 * 
	 * @Override public void onBlockClicked(BlockState state, World worldIn,
	 * BlockPos pos, PlayerEntity player) { super.onBlockClicked(state, worldIn,
	 * pos, player);
	 * 
	 * if (player.getHeldItemMainhand().isEmpty()) { // What goes here? } } 
	 * 
	 * you can do that with world.setblock or setblockstate or something 
	 * 
	 * I have a block with lots of varients. One of the
	 * properties is called "style" and can be from 0 to 7. I want to increment it
	 * when the player right-clicks on the block with an empty hand. Ok let me try,
	 * thanks so much
	 */
	
	
//	   /**
//	    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
//	    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
//	    * returns its solidified counterpart.
//	    * Note that this method should ideally consider only the specific face passed in.
//	    */
//	   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
//	      if (facing == getDirectionToOther(stateIn.get(PART), stateIn.get(HORIZONTAL_FACING))) {
//	         return facingState.getBlock() == this && facingState.get(PART) != stateIn.get(PART) ? stateIn.with(OCCUPIED, facingState.get(OCCUPIED)) : Blocks.AIR.getDefaultState();
//	      } else {
//	         return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//	      }
//	   }

	/**
	    * Given a bed part and the direction it's facing, find the direction to move to get the other bed part
	    */
	private static Direction getDirectionToOther(WideBlockPart part, Direction direction) {
//		return part == WideBlockPart.LEFT ? direction : direction.getOpposite();
		switch (direction) {
		case NORTH:
			return part == WideBlockPart.LEFT ? Direction.WEST : Direction.EAST;
		case EAST:
			return part == WideBlockPart.LEFT ? Direction.NORTH : Direction.SOUTH;
		case SOUTH:
			return part == WideBlockPart.LEFT ? Direction.EAST : Direction.WEST;
		case WEST:
			return part == WideBlockPart.LEFT ? Direction.SOUTH : Direction.NORTH;
		default:
			Paragonia.LOGGER.info("getDirectionToOther returned DEFAULT");
			return Direction.EAST;
	      
	      }
	   }

	/**
	 * Spawns the block's drops in the world. By the time this is called the Block
	 * has possibly been set to air via Block.removedByPlayer
	 */
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	/**
	 * Called before the Block is set to air in the world. Called regardless of if
	 * the player's tool can actually collect this block
	 */
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		WideBlockPart part = state.get(PART);
		BlockPos blockpos = pos.offset(getDirectionToOther(part, state.get(HORIZONTAL_FACING)));
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() == this && blockstate.get(PART) != part) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
			if (!worldIn.isRemote && !player.isCreative()) {
				ItemStack itemstack = player.getHeldItemMainhand();
				spawnDrops(state, worldIn, pos, (TileEntity) null, player, itemstack);
				spawnDrops(blockstate, worldIn, blockpos, (TileEntity) null, player, itemstack);
			}

			player.addStat(Stats.BLOCK_MINED.get(this));
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING, PART);
	}

}
