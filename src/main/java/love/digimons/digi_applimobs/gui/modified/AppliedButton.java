package love.digimons.digi_applimobs.gui.modified;

import com.mojang.blaze3d.systems.RenderSystem;
import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.util.CodeShort;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class AppliedButton extends Button {
    public static final ResourceLocation WIDGETS_LOCATION_CHANGED = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/P-GUI_widgets.png");
    private AppliedButton(AppliedBuilder builder) {
        super(builder.x, builder.y, builder.width, builder.height, builder.message, builder.onPress, Button.DEFAULT_NARRATION);
    }

    @Override
    protected void renderWidget(@NotNull GuiGraphics graphics, int mx, int my, float p) {
        graphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        graphics.blitNineSliced(WIDGETS_LOCATION_CHANGED, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 20, 4, 200, 20, 0,  46 + ((this.active ? (this.isHoveredOrFocused() ? 2 : 1) : 0) * 20));
        graphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderString(graphics, Minecraft.getInstance().font, getFGColor() | Mth.ceil(this.alpha * 255.0F) << 24);
    }

    public static AppliedButton.AppliedBuilder builder(@NotNull Component component, Button.@NotNull OnPress onPress) {
        return new AppliedButton.AppliedBuilder(component, onPress);
    }

    @Override
    public void onPress() {
        super.onPress();
        CodeShort.canUseHantei();
    }

    @OnlyIn(Dist.CLIENT)
    public static class AppliedBuilder extends Builder{
        private final Component message;
        private final AppliedButton.OnPress onPress;
        private int x, y, width, height;

        public AppliedBuilder(Component component, AppliedButton.OnPress onPress) {
            super(component,onPress);
            this.message = component;
            this.onPress = onPress;
        }

        @Override
        public AppliedButton.@NotNull AppliedBuilder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        @Override
        public AppliedButton.@NotNull AppliedBuilder size(int w, int h) {
            this.width = w;
            this.height = h;
            return this;
        }

        @Override
        public @NotNull AppliedButton build() {
            return build1(AppliedButton::new);
        }

        private AppliedButton build1(Function<AppliedBuilder, AppliedButton> builder) {
            return builder.apply(this);
        }
   }
}
