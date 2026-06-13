package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.appli_helpers.AppliAttributes;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppliHurtingEffectsEvent {
    @SubscribeEvent
    public static void AppliHurtingOnEffects(LivingHurtEvent event) {
        if(event.getSource().getEntity() instanceof AppliEntity attacker) {
            if (event.getEntity() instanceof Player || event.getEntity() instanceof Animal) {
                LivingEntity hurter = event.getEntity();
                AppliAttributes.Attributes attackerAttributes = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(attacker)).getAttributes();
                byte attriAttacker = attackerAttributes.getId();
                if(hurter instanceof AppliEntity appmonHurted) {
                    AppliAttributes.Attributes hurterAttributes = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appmonHurted)).getAttributes();
                    byte attriHurter = hurterAttributes.getId();
                    MobEffect def = hurterAttributes.getDef();
                    MobEffect coward = hurterAttributes.getCoward();
                    MobEffect prov = hurterAttributes.getProv();
                    MobEffect weak = hurterAttributes.getWeak();

                    if(attacker.hasEffect(prov) && attacker.getEffect(prov).getDuration() >= 2){
                        for (int i = 0; i <= attacker.getEffect(prov).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 1.2375f);
                        }
                    }
                    if(attacker.hasEffect(weak) && attacker.getEffect(weak).getDuration() >= 2){
                        for (int i = 0; i <= attacker.getEffect(weak).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 0.65475f);
                        }
                    }

                    if(appmonHurted.hasEffect(coward) && appmonHurted.getEffect(coward).getDuration() >= 2){
                        for (int i = 0; i <= appmonHurted.getEffect(coward).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 0.725f);
                        }
                    }
                    if(appmonHurted.hasEffect(def) && appmonHurted.getEffect(def).getDuration() >= 2){
                        for (int i = 0; i <= appmonHurted.getEffect(def).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 1.1175f);
                        }
                    }
                }else {
                    MobEffect provOt = attackerAttributes.getProv();
                    MobEffect weakOt = attackerAttributes.getWeak();
                    if(attacker.hasEffect(provOt) && attacker.getEffect(provOt).getDuration() >= 2){
                        for (int i = 0; i <= attacker.getEffect(provOt).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 1.26065f);
                        }
                    }
                    if(attacker.hasEffect(weakOt) && attacker.getEffect(weakOt).getDuration() >= 2){
                        for (int i = 0; i <= attacker.getEffect(weakOt).getAmplifier(); i++) {
                            event.setAmount(event.getAmount() * 0.79325f);
                        }
                    }
                }
            }
        }
    }
}
