package love.digimons.digi_applimobs.keys;

import love.digimons.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import love.digimons.digi_applimobs.network.SendPack;
import love.digimons.digi_applimobs.util.OpenAppliGui;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import static love.digimons.digi_applimobs.items.AppliDrive.appmonWithOwnerPointed;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class keyListener {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onKeyPressed(InputEvent.Key event) {
        if (Minecraft.getInstance().screen == null) {
            if(event.getKey() == KeyboardManager.OPEN_APPLIDATATABLE_KEY.getKey().getValue())
            {
                AppliDatatableInnerScreen.isFailed = false;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
            if (event.getKey() == KeyboardManager.CHOOSE_TO_ATT_APPMON.getKey().getValue()){
                if(event.getAction() == 0 && Minecraft.getInstance().getCameraEntity() instanceof Player) {
                    NetworkRegHandler.CHANNEL.sendToServer(new SendPack(Minecraft.getInstance().getCameraEntity().getUUID(), (short) 2));
                }
            }
            if(event.getKey() == KeyboardManager.CHIP_IN.getKey().getValue()) {
                if(event.getAction() == 0) {
                    Player player = Minecraft.getInstance().player;
                    if (player != null){
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 3));
                    }
                }
            }
            if(event.getKey() == KeyboardManager.LET_APPLI_ARISE.getKey().getValue()){
                if(event.getAction() == 0) {
                    Player player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 4));
                    }
                }
            }else if(event.getKey() == KeyboardManager.LET_APPLI_ARISE_BACK.getKey().getValue() && appmonWithOwnerPointed != null){
                if(event.getAction() == 0) {
                    Player player = Minecraft.getInstance().player;
                    if (player != null && appmonWithOwnerPointed != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 5));
                    }
                }
            }
            if(event.getKey() == KeyboardManager.GO_TO_APPLI_FIELD.getKey().getValue()){
                if(event.getAction() == 0) {
                    Player player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 6));
                    }
                }
            }
            if (event.getKey() == KeyboardManager.APPMON_LINK_OR_GATTAI.getKey().getValue()){
                if(event.getAction() == 0){
                    Player player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 7));
                    }
                }
            }
        }
    }
}
