package com.thefabulouscube.paragonia.container;

import java.util.Objects;

import com.thefabulouscube.paragonia.init.BlockInit;
import com.thefabulouscube.paragonia.init.ContainerInit;
import com.thefabulouscube.paragonia.tileentity.ExampleChestTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class ExampleChestContainer extends Container {

	public final ExampleChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	private int numRows = 1;
	private int numColumns = 9;
	private int numSlots = numRows * numColumns;

	public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory, final ExampleChestTileEntity tileEntity) {
		super(ContainerInit.SACK.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		
		//Main Inventory
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		int slotSize = 16;
		int horizDivider = 14;
		int hotBarDivider = 4;
		
		for (int row = 0; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				this.addSlot(new Slot(tileEntity, (row * 9) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		
		//Main Player Inventory
		int startPlayerInvY = startY + (numRows * slotSizePlus2) + horizDivider;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
						startPlayerInvY + (row * slotSizePlus2)));
			}
		}

		// Hotbar (I'm not convinced tha the math is correct for hotbarY
		int hotbarY = startPlayerInvY + (3 * slotSizePlus2) + hotBarDivider;
		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.SACK.get());
	}	
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < numSlots) {
				if (!this.mergeItemStack(itemstack1, numSlots, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, numSlots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
	
	private static ExampleChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "Packet Buffer data cannot be null");

		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof ExampleChestTileEntity) {
			return (ExampleChestTileEntity) tileAtPos;
		}

		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

}
