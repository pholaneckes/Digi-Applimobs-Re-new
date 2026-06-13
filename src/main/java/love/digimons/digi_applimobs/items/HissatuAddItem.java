package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
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

public class HissatuAddItem extends Item {

    private final byte type;
    public HissatuAddItem(byte type) {
        super(new Item.Properties().stacksTo(16));
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli && appli.isTame() && appli.getOwner().equals(player)){
            ItemStack itemInHand = player.getItemInHand(hand);
            float t = switch (type) {
                case 1 -> Mth.nextFloat(level.random,5,15);
                case 2 -> Mth.nextFloat(level.random,20,35);
                case 3 -> Mth.nextFloat(level.random,45,65);
                default -> 5;
            };
            if(appli.getHissatu() < 102.5) {
                appli.setHissatu(appli.getHissatu()+t);
                itemInHand.shrink(1);
            }else {
                player.sendSystemMessage(Component.translatable("dga.msg.full.hisstu"));
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        String componentListAdd = switch (type) {
            case 1 -> Component.translatable("dga.text.tip.hst").getString()+"5~15%";
            case 2 -> Component.translatable("dga.text.tip.hst").getString()+"20~35%";
            case 3 -> Component.translatable("dga.text.tip.hst").getString()+"45~65%";
            default -> throw new IllegalStateException("Unknown hissatu-er value: " + type);
        };
        componentList.add(Component.nullToEmpty(componentListAdd));
    }
}
