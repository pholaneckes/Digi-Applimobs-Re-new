package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.gui.hud.DenShiHUD;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;

import static love.digimons.digi_applimobs.util.varia.ArrowsApps.appliDenryokuItem;

@Mod.EventBusSubscriber
public class ClientRenderHUD {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onRenderGameOverlayPost(RenderGuiOverlayEvent event) {
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        int halfWidth = width / 2;
        int halfheight = height / 2;
        Minecraft minecraft = Minecraft.getInstance();
        GuiGraphics matrixStack = event.getGuiGraphics();
        if (minecraft.player != null) {
            LocalPlayer player = minecraft.player;
            if (ArrayUtils.contains(appliDenryokuItem,player.getMainHandItem().getItem()) || ArrayUtils.contains(appliDenryokuItem,player.getOffhandItem().getItem())) {
                LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
                capability.ifPresent((cpb) -> {
                    float denSNR = cpb.getDenSNR();
                    DenShiHUD hud = new DenShiHUD();
                    hud.render(matrixStack,height,width,denSNR);
                });
            }
        }
    }
}
