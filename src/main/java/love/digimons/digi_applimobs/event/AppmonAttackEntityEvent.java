package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.util.Ways;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppmonAttackEntityEvent {
    public static void goAttEnti(AppliEntity attacker, Player owner) {
        Entity beAttack;
        if (attacker.isTame() && Objects.equals(attacker.getOwner(), owner)) {
            beAttack = Ways.getPointedEntity(attacker.getOwner(), 64.0);
            Player player = (Player) attacker.getOwner();
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd)-> {
                float appliDenSNR = cpd.getDenSNR();
                if(appliDenSNR >= 27) {
                    DSNRISEnough(attacker, beAttack);
                }else {
                    player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.dsnr.not_enorgh").getString()));
                }
            });
        }
    }

    public static void DSNRISEnough(AppliEntity attacker, Entity beAttack){
        if (beAttack != null && !attacker.equals(beAttack)) {
            if(beAttack instanceof TamableAnimal){
                if(((TamableAnimal) beAttack).getOwner().equals(attacker.getOwner())){
                    return;
                }
            }
            attacker.setTarget((LivingEntity) beAttack);
            attacker.setAppmonAttTo(beAttack.getId());
            beAttack.hurt(attacker.damageSources().mobAttack(attacker), (float) 0.01);
            Player player = (Player) attacker.getOwner();
            String attackerName, beAttackEntiName;
            if (beAttack instanceof AppliEntity) {
                beAttackEntiName = Component.translatable("entity.digi_applimobs." + AppmonNameTools.getRegAppliEntiNameWithoutModId((AppliEntity) beAttack)).getString().toLowerCase();
            } else if (beAttack instanceof Player) {
                beAttackEntiName = Component.translatable("entity.minecraft.player") + beAttack.getName().getString();
            } else {
                beAttackEntiName = beAttack.getName().getString();
            }
            attackerName = AppmonNameTools.getRegAppliEntiNameWithoutModId(attacker).toLowerCase();
            player.sendSystemMessage(Component.nullToEmpty(Component.translatable("entity.digi_applimobs." + attackerName).getString() + Component.translatable("dga.msg.att").getString() + Component.translatable(beAttackEntiName).getString()));
        }
    }
}
