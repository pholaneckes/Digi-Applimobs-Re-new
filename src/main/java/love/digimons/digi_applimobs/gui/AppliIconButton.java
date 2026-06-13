package love.digimons.digi_applimobs.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AppliIconButton extends Button {
    private final ResourceLocation icon;
    private final String name;
    private final int dist;
    private final int tab;

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, Component text, String name, net.minecraft.client.gui.components.Button.OnPress action) {
        this(icon,x,y,w,h,text,name,action, Supplier::get, 34,18);
    }

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, Component text, String name, net.minecraft.client.gui.components.Button.OnPress action, int dist) {
        this(icon,x,y,w,h,text,name,action,Supplier::get, dist,18);
    }

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, Component text, String name, net.minecraft.client.gui.components.Button.OnPress action, int dist, int tab) {
        this(icon,x,y,w,h,text,name,action, Supplier::get, dist, tab);
    }

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, Component text, String name, net.minecraft.client.gui.components.Button.OnPress action, net.minecraft.client.gui.components.Button.CreateNarration createNarration, int dist, int tab) {
        super(x, y, w, h, text, action, createNarration);
        this.icon = icon;
        this.name = name;
        this.dist = dist;
        this.tab = tab;
    }

    //获取图片
    public ResourceLocation getIcon() {
        return this.icon;
    }

    //如何渲染
    @Override
    public void renderWidget(@NotNull GuiGraphics graphics, int mx, int my, float pt) {
        //初始化
        graphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        //渲染图片
        graphics.blit(this.getIcon(), this.getX(), this.getY(), 0, 0,
                this.width, this.height, this.width, this.height);
        //渲染图片下的文字 （这里Minecraft.getInstance().font是字体，name是渲染的文字，tab是X向右偏移距离，dist是Y向下偏移距离，最后的颜色参数从原版搬的）
        graphics.drawCenteredString(Minecraft.getInstance().font, Component.translatable(name),
                this.getX()+tab, this.getY() +dist,
                this.getFGColor() | Mth.ceil(this.packedFGColor * 255.0F) << 24);
    }


}
