package love.digimons.digi_applimobs.gui.inv.band;

import love.digimons.digi_applimobs.gui.ContainerReg;
import love.digimons.digi_applimobs.items.AppliChipItem;
import love.digimons.digi_applimobs.network.SendPack;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class BandContainer extends AbstractContainerMenu {

	private final Player player;
	private final ItemStackHandler invBand;

	public static BandContainer fromNetwork(int windowId, Inventory playerInv) {
		return new BandContainer(windowId, playerInv, new ItemStackHandler(99), false);
	}

	public BandContainer(int windowId, Inventory invPlayer, ItemStackHandler invBand, boolean immutable) {
		super(ContainerReg.BAND_CONTAINER.get(), windowId);
		this.player = invPlayer.player;
		this.invBand = invBand;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				addSlot(new AppliBandSlot(invBand, j + i* 13, 176 + j* 18, 14 + i* 18));
			}
		}
		addPlayerInventory(invPlayer, 176, 152);
	}

//	private IHBSlot createContainerSlot(IItemHandlerModifiable inv, int index, int x, int y) {
//		if (immutable) {
//			return new IHBSlot(inv, index, x, y) {
//				@Override
//				public boolean mayPickup(@Nonnull Player player) {
//					return false;
//				}
//
//				@Override
//				public boolean mayPlace(@Nonnull ItemStack stack) {
//					return false;
//				}
//			};
//		}
//		return new IHBSlot(inv, index, x, y);
//	}
//
//	protected ISlot createInsertableSlot(@Nonnull Inventory inv, int index, int x, int y) {
//		if (immutable) {
//			return new ISlot(inv, index, x, y) {
//				@Override
//				public boolean mayPickup(@Nonnull Player player) {
//					return false;
//				}
//
//				@Override
//				public boolean mayPlace(@Nonnull ItemStack stack) {
//					return false;
//				}
//			};
//		}
//		return new ISlot(inv, index, x, y);
//	}
//

	@Nonnull
	@Override
	public ItemStack quickMoveStack(@Nonnull Player player, int slotIndex) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(slotIndex);
		if (slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (slotIndex < 63 && slot.getItem().getItem() instanceof AppliChipItem) {
				if (!this.moveItemStackTo(itemstack1, 63, this.slots.size(), true)) {
					SendPack.tongbuAppmonBand(invBand.serializeNBT(),player.getUUID());
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 0, 63, false)) {
				SendPack.tongbuAppmonBand(invBand.serializeNBT(),player.getUUID());
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void slotsChanged(Container container) {
		SendPack.tongbuAppmonBand(invBand.serializeNBT(),player.getUUID());
		super.slotsChanged(container);
	}



	//	@Override
//	public void clicked(int slotId, int dragType, @Nonnull ClickType clickType, @Nonnull Player player) {
//		if(!immutable){
//			super.clicked(slotId, dragType, clickType, player);
//		}
//	}


	@Override
	public boolean stillValid(@Nonnull Player player) {
		SendPack.tongbuAppmonBand(invBand.serializeNBT(),player.getUUID());
		return true;
	}

//	protected final List<IHBSlot> IHBSlots = new ArrayList<>();
//	protected final List<ISlot> mainInventorySlots = new ArrayList<>();
//	private final List<DataSlot> intFields = new ArrayList<>();

	private void addPlayerInventory(Inventory invPlayer, int xStart, int yStart) {
		int slotSize = 18;
		int rows = 3;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 9; j++) {
				addSlot(new Slot(invPlayer, j + i* 9 + 9, xStart + j* slotSize, yStart + i* slotSize));
			}
		}
		yStart = yStart + slotSize* rows + 4;
		
		for (int i = 0; i < Inventory.getSelectionSize(); i++) {
			Slot slot = new Slot(invPlayer, i, xStart + i * slotSize, yStart);
			addSlot(slot);
		}
	}




//	@Nonnull
//	@Override
//	protected Slot addSlot(@Nonnull Slot slot) {
//		return slot;
//	}

//	@Nonnull
//	@Override
//	protected DataSlot addDataSlot(@Nonnull DataSlot referenceHolder) {
//		intFields.add(referenceHolder);
//		return referenceHolder;
//	}

//	public static ItemStack size(ItemStack stack, int size) {
//		if (size <= 0 || stack.isEmpty()) {
//			return ItemStack.EMPTY;
//		}
//		return ItemHandlerHelper.copyStackWithSize(stack, size);
//	}
}