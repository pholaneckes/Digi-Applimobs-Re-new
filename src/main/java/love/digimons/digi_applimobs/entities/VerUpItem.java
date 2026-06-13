package love.digimons.digi_applimobs.entities;

import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VerUpItem extends Item {
    public VerUpItem() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof StandardApplimob applimob){
            player.getItemInHand(hand).shrink(1);
            applimob.setAppmonVer(applimob.getAppmonVer()+1);
        }
        return super.use(level, player, hand);
    }
}
