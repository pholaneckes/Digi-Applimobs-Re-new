package love.digimons.digi_applimobs.gui.inv.band;

import love.digimons.digi_applimobs.items.AppliChipItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class AppliBandSlot extends SlotItemHandler {

    public AppliBandSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }


    @Override
    public int getMaxStackSize(ItemStack stack) {
        return Math.min(getMaxStackSize(), stack.getMaxStackSize());
    }

    @Override
    public void onTake(Player p_190901_1_, ItemStack p_190901_2_) {
        super.onTake(p_190901_1_, p_190901_2_);
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return stack.getItem() instanceof AppliChipItem;
    }
}