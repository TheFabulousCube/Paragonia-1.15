package com.thefabulouscube.paragonia.tileentity;

import javax.annotation.Nonnull;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.container.ExampleChestContainer;
import com.thefabulouscube.paragonia.init.TileEntityInit;
import com.thefabulouscube.paragonia.objects.blocks.ExampleChestBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ExampleChestTileEntity extends LockableLootTileEntity {
	private NonNullList<ItemStack> contents = NonNullList.withSize(9,  ItemStack.EMPTY);
	protected int numPlayersUsing;
	private IItemHandlerModifiable items = createHandler();
	private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

	public ExampleChestTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}
	
	//  Find a way to get rid of this parameterless constructor!!!
	public ExampleChestTileEntity() {
		this(TileEntityInit.SACK.get());
	}

	@Override
	public int getSizeInventory() {
		return contents.size();
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.contents;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.contents = itemsIn;

	}

	@Override
	protected ITextComponent getDefaultName() {
//		Wow.  That's hard coded solid.
		return new TranslationTextComponent("container.paragonia.sack");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new ExampleChestContainer(id, player, this);
	}
	


	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.contents);
		}
		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.contents);
		}
	}
	
	public void playSound(SoundEvent sound) {
		double dx = (double)this.pos.getX() + 0.5D;
		double dy = (double)this.pos.getY() + 0.5D;
		double dz = (double)this.pos.getZ() + 0.5D;
		Paragonia.LOGGER.info("Playing sound: " + sound);
		this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
				this.world.rand.nextFloat() * 0.1f + 0.9f);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}
	}

	@Override
	public void openInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}
			++this.numPlayersUsing;
			this.onOpenOrClose();
			Paragonia.LOGGER.info("Trigger for 'Open Inventory'.");
		}
	}

	@Override
	public void closeInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.numPlayersUsing;
			this.onOpenOrClose();
			Paragonia.LOGGER.info("Trigger for 'Close Inventory'.");
		}
	}

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof ExampleChestBlock) {
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, block);
			Paragonia.LOGGER.info("Trigger for onOpenOrClose().");
		}
	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState blockstate = reader.getBlockState(pos);
		if (blockstate.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if (tileentity instanceof ExampleChestTileEntity) {
				return ((ExampleChestTileEntity) tileentity).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(ExampleChestTileEntity te, ExampleChestTileEntity otherTe) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(otherTe.getItems());
		otherTe.setItems(list);
	}

	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		if (this.itemHandler != null) {
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new InvWrapper(this);
	}
	
	@Override
	public void remove() {
		super.remove();
		if(itemHandler != null) {
			itemHandler.invalidate();
		}
	}

}
