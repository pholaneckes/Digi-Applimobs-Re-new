package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.appli_helpers.AppliAttributes;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntiAttriItem extends Item {
    private final byte type;
    public AntiAttriItem(byte type) {
        super(new Properties());
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli) {
            MobEffect coward = AppliAttributes.Attributes.values()[type].getCoward();
            MobEffect prov = AppliAttributes.Attributes.values()[type].getProv();
            if(appli.isTame()){
                if(appli.getOwner().equals(player)){
                    appli.addEffect(new MobEffectInstance(prov,270*20));
                }else {
                    appli.addEffect(new MobEffectInstance(coward,25*20));
                }
            }else {
                appli.addEffect(new MobEffectInstance(coward,150*20));
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level worldIn, List<Component> componentList, TooltipFlag flagIn) {
        componentList.add(Component.translatable("dga.tip.usedon.dif"));
        componentList.add(Component.translatable("dga.tip.anti_item"));
    }
}
