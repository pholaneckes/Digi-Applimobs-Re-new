package love.digimons.digi_applimobs.gui;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//文本段的类
public class AppliTextWidget extends StringWidget {
    private final int sp;
    public AppliTextWidget(int x, int y, int w, int h, Component c, Font f, int sp) {
        super(x, y, w, h, c, f);
        this.sp = sp;
    }

    @Override
    public AppliTextWidget setColor(int color) {
      super.setColor(color);
      return this;
   }

    private AppliTextWidget horizontalAlignment(float aXto) {
        this.alignX = aXto;
        return this;
    }
    @Override
    public @NotNull AppliTextWidget alignLeft() {
        return this.horizontalAlignment(0.0F);
    }
    @Override
    public @NotNull AppliTextWidget alignCenter() {
        return this.horizontalAlignment(0.5F);
    }
    @Override
    public @NotNull AppliTextWidget alignRight() {
        return this.horizontalAlignment(1.0F);
    }

    @Override
    public void renderWidget(@NotNull GuiGraphics graphics, int x, int y, float parT) {
        //获取文本
        Component component = this.getMessage();
        //获取字体
        Font font = this.getFont();
        //获取文本起始点（最左上点）
        int start = this.getX() + Math.round(alignX * (float)(this.getWidth() - font.width(component)));
        //按每个字的字体宽度均匀分割文本  （成为列表）
        List<FormattedCharSequence> splitList = font.split(component, sp);
        //渲染文本
        for (int i = 0; i<splitList.size(); i++) {
            //获取渲染的高度
            int heiput = this.getY() + (this.getHeight() - 9) / 2 + i*10;
            graphics.drawString(font, splitList.get(i), start, heiput, this.getColor());
        }
    }
}
