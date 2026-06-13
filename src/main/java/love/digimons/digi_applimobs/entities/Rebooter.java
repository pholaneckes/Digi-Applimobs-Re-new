package love.digimons.digi_applimobs.entities;

import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.items.ItemReg;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Rebooter extends Item {
    public Rebooter() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof StandardApplimob appli){
            ItemStack itemInHand = player.getItemInHand(hand);
            if(!appli.isAppliLinked()){
                int appmonPower = appli.getAppmonPower();
                int power = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appli)).getPower();
                int fanhuan = (int) Math.ceil((float)(appmonPower - power) / (power * 0.075)) - 1;
                appli.setAppmonPower(power);
                player.addItem(new ItemStack(ItemReg.powerTrainerXXS.get(),fanhuan));
                int health = AppliEntity.getAppmonHealth(appli);
                Ways.setAppmonHealth(appli,health);
                itemInHand.shrink(1);
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        componentList.add(Component.translatable("dga.tip.rebooter"));
    }
}
