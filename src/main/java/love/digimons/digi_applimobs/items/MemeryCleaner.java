package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Collection;

public class MemeryCleaner extends Item {
    public MemeryCleaner() {
        super(new Properties().stacksTo(64));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli){
            ItemStack itemInHand = player.getItemInHand(hand);
            Collection<MobEffectInstance> activeEffects = appli.getActiveEffects();
            boolean cl = false;
            for (MobEffectInstance eff : activeEffects) {
                if(!eff.getEffect().isBeneficial()){
                    appli.removeEffect(eff.getEffect());
                    cl = true;
                }
            }
            if(cl) {
                itemInHand.shrink(1);
                player.sendSystemMessage(Component.translatable("dga.msg.mmyc.comp"));
            }else {

            }
        }
        return super.use(level, player, hand);
    }
}
