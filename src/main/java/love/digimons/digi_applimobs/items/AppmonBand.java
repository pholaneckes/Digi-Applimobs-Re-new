package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.gui.inv.band.BandContainer;
import love.digimons.digi_applimobs.util.varia.AppmonBandProcider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class AppmonBand extends Item {
	public AppmonBand() {
		super(new Properties().stacksTo(1));
	}

	@Nonnull
	@Override
	public InteractionResultHolder<ItemStack> use(@Nonnull Level world, @Nonnull Player player, @Nonnull InteractionHand hand) {
		if (!world.isClientSide) {
			OpenAppliBondGui(player);
		}
		return InteractionResultHolder.success(player.getItemInHand(hand));
	}

	public static void OpenAppliBondGui(Player player) {
		LazyOptional<ItemStackHandler> capability = player.getCapability(AppmonBandProcider.BANDINV);
		capability.ifPresent((cpd)->{
			CompoundTag appmonBand = cpd.serializeNBT();
			ItemStackHandler itemStackHandler = new ItemStackHandler(99);
			itemStackHandler.deserializeNBT(appmonBand);
			ContainerProvider containerProvider = new ContainerProvider(itemStackHandler);
			player.openMenu(containerProvider);
		});
		//Minecraft.getInstance().setScreen(containerProvider);//new BandScreen(ContainerReg.BAND_CONTAINER.get().create(,player.getInventory()),player.getInventory(), Component.empty()));
	}

	private static class ContainerProvider implements MenuProvider {
		private final ItemStackHandler itemStackHandler;
		 public ContainerProvider(ItemStackHandler itemStackHandler){
			 this.itemStackHandler = itemStackHandler;
		 }

		@Nonnull
		@Override
		public AbstractContainerMenu createMenu(int windowId, @Nonnull Inventory playerInventory, @Nonnull Player player) {
			return new BandContainer(windowId, playerInventory, itemStackHandler, false);
		}

		@Override
		public Component getDisplayName() {
			return Component.empty();
		}
	}
}