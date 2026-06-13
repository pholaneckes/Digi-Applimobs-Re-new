package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HPCharger extends Item {

    private final byte type;
    public HPCharger(byte type) {
        super(new Properties());
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli && appli.isTame() && appli.getOwner().equals(player)){
            ItemStack itemInHand = player.getItemInHand(hand);
            float t = switch (type) {
                case 1 -> 0.2f;
                case 2 -> 0.4f;
                case 3 -> 0.6f;
                case 4 -> 1.0f;
                default -> 0.1f;
            };
            double baseValue = appli.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
            appli.setHealth((float) Math.min(baseValue, appli.getHealth()+baseValue*t));
            itemInHand.shrink(1);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        String componentListAdd = switch (type) {
            case 1 -> Component.translatable("dga.text.tip.hpc").getString()+"20%";
            case 2 -> Component.translatable("dga.text.tip.hpc").getString()+"40%";
            case 3 -> Component.translatable("dga.text.tip.hpc").getString()+"60%";
            case 4 -> Component.translatable("dga.text.tip.hpc").getString()+"100%";
            default -> throw new IllegalStateException("Unknown charger value: " + type);
        };
        componentList.add(Component.nullToEmpty(componentListAdd));
    }
}
