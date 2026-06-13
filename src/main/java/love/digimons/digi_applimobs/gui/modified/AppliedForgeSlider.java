package love.digimons.digi_applimobs.gui.modified;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.client.gui.widget.ForgeSlider;

public class AppliedForgeSlider extends ForgeSlider {
    private static final ResourceLocation SLIDER_LOCATION_CHANGED = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/P-GUI_slider.png");

    public AppliedForgeSlider(int x, int y, int width, int height, Component prefix, Component suffix, double minValue, double maxValue, double currentValue, double stepSize, int precision, boolean drawString) {
        super(x, y, width, height, prefix, suffix, minValue, maxValue, currentValue, stepSize, precision, drawString);
    }

    public AppliedForgeSlider(int x, int y, int width, int height, Component prefix, Component suffix, double minValue, double maxValue, double currentValue, boolean drawString) {
        super(x, y, width, height, prefix, suffix, minValue, maxValue, currentValue, drawString);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        guiGraphics.blitWithBorder(SLIDER_LOCATION_CHANGED, this.getX(), this.getY(), 0, getTextureY(), this.width, this.height, 200, 20, 2, 3, 2, 2);
        guiGraphics.blitWithBorder(SLIDER_LOCATION_CHANGED, this.getX() + (int)(this.value * (double)(this.width - 8)), this.getY(), 0, getHandleTextureY(), 8, this.height, 200, 20 , 2, 3, 2, 2);
        renderScrollingString(guiGraphics, Minecraft.getInstance().font, 2, getFGColor() | Mth.ceil(this.alpha * 255.0F) << 24);
    }
}
