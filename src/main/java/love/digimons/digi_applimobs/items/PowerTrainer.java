package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import love.digimons.digi_applimobs.network.SendPack;
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

public class PowerTrainer extends Item {

    private final byte type;
    public PowerTrainer(byte type) {
        super(new Properties());
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof AppliEntity appli && appli.isTame() && appli.getOwner().equals(player)){
            ItemStack itemInHand = player.getItemInHand(hand);
            if(level.isClientSide()) {
                float t = switch (type) {
                    case 1 -> 0.005f;
                    case 2 -> 0.01f;
                    case 3 -> 0.0175f;
                    default -> 0.001f;
                };
                int appmonPower = appli.getAppmonPower();
                int power = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appli)).getPower();
                float rR = (float) Mth.nextInt(appli.getRandom(), 0, appmonPower) * 1.625f;
                float rR2 = (float) Mth.nextInt(player.getRandom(), 0, appmonPower) * 1.625f;

                float lowgl = (float) ((power/ Math.pow(type+2.0f,type*(5-type))) / (5f - type));
                float v1 = appmonPower / 5f;
                float bon = ((v1 - lowgl) * lowgl + (lowgl * lowgl / 2)) / (lowgl * v1);

                if(!(appmonPower * 1.625f * ((float) power / (float) appmonPower) > appmonPower - power) && !player.isShiftKeyDown()){
                    player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.4").getString() + Component.translatable("dga.msg.ptra.cannot").getString()));
                    return super.use(level, player, hand);
                }else if(player.isShiftKeyDown()){
                    //System.out.println(bon);
                    if(Mth.nextFloat(level.random, 0f,1f) > bon){
                        appli.setAppmonPower((int) (appmonPower + Math.ceil(appmonPower * t)));
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(appli.getUUID(), appli.getAppmonPower(), (short) 104));
                        player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.a").getString() + Component.translatable("dga.msg.ptra.succ").getString()));
                    }else {
                        player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.4").getString()
                                + Component.translatable("dga.msg.ptra.failed").getString()
                                + Component.translatable("color.e").getString()+ "  (<"+(1-bon)*100+"%)"));
                    }
                    return super.use(level, player, hand);
                }
                if ((rR * ((float) power / (float) appmonPower) > appmonPower - power && rR2 * ((float) power / (float) appmonPower) > appmonPower - power) || Mth.nextFloat(level.random, 0f,1f) > bon) {
                    appli.setAppmonPower((int) (appmonPower + Math.ceil(appmonPower * t)));
                    NetworkRegHandler.CHANNEL.sendToServer(new SendPack(appli.getUUID(), appli.getAppmonPower(), (short) 104));
                    player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.a").getString() + Component.translatable("dga.msg.ptra.succ").getString()));
                } else {
                    float max = appmonPower * 1.625f * ((float) power / (float) appmonPower);
                    float gailv = (appmonPower - power)/max;
                    player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.4").getString()
                            + Component.translatable("dga.msg.ptra.failed").getString()
                            + Component.translatable("color.e").getString()+ "  ("+ ((1-gailv)*(1-gailv)*100 + (1-bon)*100) + "%)"));
                }
                //Digi_Applimobs.LOGGER.info(rR + "*" + power + "/" + appmonPower + " __ " + appmonPower + "-" + power);
                //Digi_Applimobs.LOGGER.info(rR * ((float) power / (float) appmonPower) + " __ " + (appmonPower - power));
                float max = appmonPower * 1.625f * ((float) power / (float) appmonPower);
                Digi_Applimobs.LOGGER.info((1-(appmonPower - power)/max)*(1-(appmonPower - power)/max)+"%");
            }
            itemInHand.shrink(1);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        componentList.add(Component.translatable("dga.tip.powertrainer"));
    }
}
