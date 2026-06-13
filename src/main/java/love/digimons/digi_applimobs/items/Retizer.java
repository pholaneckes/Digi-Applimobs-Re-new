package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.entities.WaruAppmobs;
import love.digimons.digi_applimobs.entities.appmobs.Flickmob;
import love.digimons.digi_applimobs.entities.appmobs.Swipemob;
import love.digimons.digi_applimobs.entities.appmobs.Tapmob;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Retizer extends Item {
    private final byte type;
    public Retizer(Properties properties, byte type) {
        super(properties.stacksTo(16));
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof WaruAppmobs waruAppmobs){
            if(waruAppmobs.isTame() && waruAppmobs.getOwner().equals(player)) {
                byte waruType = waruAppmobs.getWaruType();
                byte changeTo = (byte) Mth.nextInt(waruAppmobs.getRandom(), 0, 6);
                if (waruType == changeTo) {
                    changeTo = (byte) Mth.nextInt(waruAppmobs.getRandom(), 0, 6);
                }
                if (type == 0 && waruAppmobs instanceof Flickmob) {
                    player.getItemInHand(hand).shrink(1);
                    waruAppmobs.setWaruType(changeTo);
                } else if (type == 1 && waruAppmobs instanceof Tapmob) {
                    player.getItemInHand(hand).shrink(1);
                    waruAppmobs.setWaruType(changeTo);
                } else if (type == 2 && waruAppmobs instanceof Swipemob) {
                    player.getItemInHand(hand).shrink(1);
                    waruAppmobs.setWaruType(changeTo);
                }
            }
        }
        return super.use(level, player, hand);
    }
}
