package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.effects.EffectReg;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static love.digimons.digi_applimobs.entities.AppliEntity.EMOTION;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppliHurtEvent {
    @SubscribeEvent
    public static void AppliHurt(LivingHurtEvent event) {
        if(event.getAmount() > 0.5) {
            if (event.getEntity() instanceof AppliEntity) {
                event.getEntity().getEntityData().set(EMOTION, "oops");
                AppliTickEvent.doTick(12, "changeEmoToNormal_oops", event.getEntity(), 0);
            }
            AppliEntity whoHurted, whoAtt;
            if (event.getSource().getEntity() instanceof AppliEntity appli){
                whoAtt = (AppliEntity) event.getSource().getEntity();
                if(whoAtt.hasEffect(EffectReg.virus_ka.get())) {
                    event.setAmount(event.getAmount() * 0.7f);
                }
                byte appmonForm = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appli)).getFormTypes().getId();
                int appmonPower = ((AppliEntity) event.getSource().getEntity()).getAppmonPower();
                if(event.getEntity() instanceof AppliEntity appli2) {
                    whoHurted = appli2;
                    byte hurterForm = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(whoHurted)).getFormTypes().getId();
                    event.setAmount(getAppmonAttStats(appmonForm,hurterForm,appmonPower));
                    byte attriHurter = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(whoHurted)).getAttributes().getId();
                    byte attAttri = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(whoAtt)).getAttributes().getId();
                    switch (attAttri){
                        case 0:
                            if(attriHurter == 1) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 4){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 1:
                            if(attriHurter == 5) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 0){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 2:
                            if(attriHurter == 3) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 6){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 3:
                            if(attriHurter == 4) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 2){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 4:
                            if(attriHurter == 0) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 3){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 5:
                            if(attriHurter == 6) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 2){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 6:
                            if(attriHurter == 2) {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }else if(attriHurter == 5){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }
                        case 7:
                            if(attriHurter < 7) {
                                event.setAmount(event.getAmount() * 2.0f);
                                break;
                            }else if(attriHurter == 7){
                                event.setAmount(event.getAmount() * 1.25f);
                                break;
                            }else {
                                event.setAmount(event.getAmount() * 1.5f);
                                break;
                            }
                        case 8, 9:
                            if(attriHurter < 7) {
                                break;
                            }else if(attriHurter == 7){
                                event.setAmount(event.getAmount() * 0.75f);
                                break;
                            }else {
                                event.setAmount(event.getAmount() * 0.25f);
                                break;
                            }
                    }
                }
                if(event.getEntity() instanceof Player){
                    Player player = (Player) event.getEntity();
                    if(appmonForm == 1){
                        event.setAmount(2 + appmonPower/1000f);
                    }else if(appmonForm == 2){
                        event.setAmount(4 + appmonPower/6000f);
                    }else if (appmonForm == 3){
                        event.setAmount(6 + appmonPower/26500f);
                    }else if (appmonForm == 4){
                        event.setAmount(9 + appmonPower/95000f);
                    }else if (appmonForm == 0){
                        event.setAmount(2.5f);
                    }else if (appmonForm == -1){
                        event.setAmount(1);
                    }
                }
                if(event.getEntity() instanceof Animal && !(event.getEntity() instanceof AppliEntity)){
                    if(appmonForm == 1){
                        event.setAmount(appmonPower/900f + 3.2f);
                    }else if(appmonForm == 2){
                        event.setAmount(appmonPower/1700f + 4.5f);
                    }else if (appmonForm == 3){
                        event.setAmount(appmonPower/2050f + 7.7f);
                    }else if (appmonForm == 4){
                        event.setAmount(appmonPower/320f);
                    }else if (appmonForm == 0){
                        event.setAmount(2.5f);
                    }else if (appmonForm == -1){
                        event.setAmount(2);
                    }
                }
                if(event.getEntity() instanceof Monster && !(event.getEntity() instanceof AppliEntity)){
                    if(appmonForm == 1){
                        event.setAmount(appmonPower/400f + 3.2f);
                    }else if(appmonForm == 2){
                        event.setAmount(appmonPower/700f + 4.5f);
                    }else if (appmonForm == 3){
                        event.setAmount(appmonPower/9050f + 7.7f);
                    }else if (appmonForm == 4){
                        event.setAmount(appmonPower/130f);
                    }else if (appmonForm == 0){
                        event.setAmount(2.5f);
                    }else if (appmonForm == -1){
                        event.setAmount(2.5f);
                    }
                }
                if(event.getEntity() != null && !(event.getEntity() instanceof AppliEntity) && !(event.getEntity() instanceof Player) && !(event.getEntity() instanceof Animal) && !(event.getEntity() instanceof Monster)){
                    if(appmonForm == 1){
                        event.setAmount(3);
                    }else if(appmonForm == 2){
                        event.setAmount(9);
                    }else if (appmonForm == 3){
                        event.setAmount(27);
                    }else if (appmonForm == 4){
                        event.setAmount(81);
                    }else if (appmonForm == 0){
                        event.setAmount(2.5f);
                    }else if (appmonForm == -1){
                        event.setAmount(Mth.nextFloat(event.getEntity().getRandom(), 2.25f,729.0f));
                        Digi_Applimobs.LOGGER.error("NOT SURE POWER-FORCE!!!!");
                    }
                }
                if(whoAtt.isTame()){
                    if(whoAtt.isDUO()){//appli.getOwner().getItemInHand(Hand.OFF_HAND).getItem().equals(ItemRegistry.appliDriveDUO.get()) || appli.getOwner().getItemInHand(Hand.MAIN_HAND).getItem().equals(ItemRegistry.appliDriveDUO.get())){
                        event.setAmount(event.getAmount() * 1.5f);
                    }
                    Player player = (Player) whoAtt.getOwner();
                    LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
                    capability.ifPresent((cpd)-> {
                        float appliDenSNR = cpd.getDenSNR();
                        if(appliDenSNR >= 29) {
                            cpd.setDenSNR(cpd.getDenSNR()-appmonForm/5.0f);
                            CapTb.serverDSNRPackSend(player,cpd);
                        }else {
                            player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.dsnr.not_enorgh").getString()));
                            event.setAmount(0.6f);
                        }
                    });
                }
            }
        }
    }
    
    public static float getAppmonAttStats(byte appmonForm, byte hurterForm, int appmonPower){
        double forgeToTemp = Math.max(Math.floor(appmonPower / 5000.0), 5);
        switch (appmonForm) {
            case 1:
                switch (hurterForm) {
                    case 1:
                        return (float) Math.ceil(appmonPower / 150.0);
                    case 2:
                        return (float) Math.ceil(appmonPower / 170.0);
                    case 3:
                        return (float) Math.ceil(appmonPower / 190.0);
                    case 4:
                        return (float) Math.ceil(appmonPower / 225.0);
                    case 0:
                        return (float) forgeToTemp;
                    case -1:
                        return (float) Math.ceil(appmonPower / 600.0);
                }
        case 2:
            switch (hurterForm) {
                case 1:
                    return (float) Math.ceil(appmonPower / 850.0);
                case 2:
                    return (float) Math.ceil(appmonPower / 900.0);
                case 3:
                    return (float) Math.ceil(appmonPower / 910.0);
                case 4:
                    return (float) Math.ceil(appmonPower / 920.0);
                case 0:
                    return (float) forgeToTemp;
                case -1:
                    return (float) Math.ceil(appmonPower / 600.0);
            }
        case 3:
            switch (hurterForm) {
                case 1:
                    return (float) Math.ceil(appmonPower / 6050.0);
                case 2:
                    return (float) Math.ceil(appmonPower / 6300.0);
                case 3:
                    return (float) Math.ceil(appmonPower / 6500.0);
                case 4:
                    return (float) Math.ceil(appmonPower / 6650.0);
                case 0:
                    return (float) forgeToTemp;
                case -1:
                    return (float) Math.ceil(appmonPower / 600.0);
            }
        case 4:
            switch (hurterForm) {
                case 1:
                    return (float) Math.ceil(appmonPower / 10000.0);
                case 2:
                    return (float) Math.ceil(appmonPower / 15500.0);
                case 3:
                    return (float) Math.ceil(appmonPower / 20000.0);
                case 4:
                    return (float) Math.ceil(appmonPower / 23500.0);
                case 0:
                    return (float) forgeToTemp;
                case -1:
                    return (float) Math.ceil(appmonPower / 600.0);
            }
        case 0:
            switch (hurterForm) {
                case 1:
                case 2:
                case 3:
                case 4:
                case -1:
                    return 2.5F;
                case 0:
                    return 0;
            }
        case -1:
            switch (hurterForm) {
                case 1:
                case 2:
                    return (float) Math.ceil(appmonPower / 6000.0);
                case 3:
                case 4:
                    return (float) Math.ceil(appmonPower / 6450.0);
                case 0:
                    return (float) forgeToTemp;
                case -1:
                    return (float) Math.ceil(appmonPower / 999999.0);
            }
            default:
                Digi_Applimobs.LOGGER.error("UNKNOWN FORM!!");
        }
        return 0;
    }
}

