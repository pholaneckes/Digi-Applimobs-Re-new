package love.digimons.digi_applimobs.gui.hud;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class DenShiHUD implements Renderable {
    private static final ResourceLocation TEX = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/appli_denshi.png");


    public DenShiHUD() {
    }

    @Override
    public void render(GuiGraphics guiGraphics, int height, int width, float denshi){
        guiGraphics.setColor(1.0f, 1.0f,1.0f,1.0f);
        guiGraphics.blit(TEX, width - 55, height-22, 0, 0, 64, 64, 64, 64);
        guiGraphics.drawString(Minecraft.getInstance().font, Component.translatable("appli.denshi").getString(), width -52, height -20, -45479);
        guiGraphics.drawString(Minecraft.getInstance().font,Float.toString(denshi), width -52, height -11, -45479);

    }
}

