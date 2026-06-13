package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.event.CapTb;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BatteryChargers extends Item {
    private final byte type;
    public BatteryChargers(byte type) {
        super(new Item.Properties().stacksTo(16));
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        if(player.isShiftKeyDown()){
            float t = switch (type) {
                case 1 -> 1.125F;
                case 2 -> 1.25F;
                case 3 -> 1.5F;
                case 4 -> 2F;
                case 5 -> 5F;
                default -> 1;
            };
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd)->{
                cpd.setDenSNR((cpd.getDenSNR()+25*t)*t);
                if(!level.isClientSide) {
                    CapTb.serverDSNRPackSend(player, cpd);
                }
            });
            itemInHand.shrink(1);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        String componentListAdd = switch (type) {
            case 1 -> Component.translatable("dga.text.tip.bchar").getString()+"112.5%";
            case 2 -> Component.translatable("dga.text.tip.bchar").getString()+"125%";
            case 3 -> Component.translatable("dga.text.tip.bchar").getString()+"150%";
            case 4 -> Component.translatable("dga.text.tip.bchar").getString()+"200%";
            case 5 -> Component.translatable("dga.text.tip.bchar").getString()+"500%";
            default -> throw new IllegalStateException("Unknown charger value: " + type);
        };
        componentList.add(Component.nullToEmpty(componentListAdd));
    }
}
