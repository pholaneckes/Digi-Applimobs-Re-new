package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.effects.EffectReg;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VacProgram extends Item {
    public VacProgram() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli){
            if(appli.isTame() && appli.getOwner().equals(player)){
                appli.removeEffect(EffectReg.virus_ka.get());
                player.getItemInHand(hand).shrink(1);
            }else {
                if(player.isShiftKeyDown()){
                    appli.removeEffect(EffectReg.virus_ka.get());
                    player.getItemInHand(hand).shrink(1);
                }
            }
        }
        return super.use(level, player, hand);
    }
}
