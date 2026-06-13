package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.items.ItemReg;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static love.digimons.digi_applimobs.entities.AppliEntity.EMOTION;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class onEntityInteractEvent {

    public static int doFeedTimes = -1;

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event){
        if (event.getTarget() instanceof AppliEntity) {
            if (event.getHand() == InteractionHand.MAIN_HAND) {
                if (event.getItemStack().getItem() == ItemReg.gatch_monaka.get()) {
                    if (!event.getLevel().isClientSide) {
                        AppliEntity appmon = (AppliEntity) event.getTarget();
                        if(!appmon.isTame()) {
                            appmon.tameAppli(event.getEntity());
                        }
                        event.getTarget().getEntityData().set(EMOTION,"haha");
                        event.getItemStack().shrink(1);
                        if(appmon.getAppmonPower() <= 1.375*AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appmon)).getPower()) {
                            appmon.setAppmonPower(appmon.getAppmonPower() + 1);
                        }
                       // NetworkRegHandler.CHANNEL.sendToServer(new SendPack(event.getTarget().getUUID(), appmon.getAppmonPower(),(short) 101));
                       // NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer) appmon.getOwner()), new SendPack(event.getTarget().getUUID(),String.valueOf(event.getTarget().getId()), appmon.getAppmonPower(),(short) 101));
                        doFeedTimes ++;
                        AppliTickEvent.doTick(55,"changeEmoToNormal", event.getTarget(), doFeedTimes);
                    }
                }
            }
        }
    }
    /*
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
     */
}



