package love.digimons.digi_applimobs.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Unlocker extends Item {
    public Unlocker() {
        super(new Properties().stacksTo(4));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        InteractionHand inantHand;
        EquipmentSlot equipmentSlot;
        if(hand.equals(InteractionHand.MAIN_HAND)){
            inantHand = InteractionHand.OFF_HAND;
            equipmentSlot = EquipmentSlot.OFFHAND;
        }else {
            inantHand = InteractionHand.MAIN_HAND;
            equipmentSlot = EquipmentSlot.MAINHAND;
        }
        Item chip = player.getItemInHand(inantHand).getItem();
        if(chip instanceof AppliUnlockedChipItem) {
            player.getItemInHand(inantHand).shrink(1);
            itemInHand.shrink(1);
            player.setItemSlot(equipmentSlot,(new ItemStack(((AppliUnlockedChipItem) chip).getLockChip(),1)));

        }
        return super.use(level, player, hand);
    }
}
