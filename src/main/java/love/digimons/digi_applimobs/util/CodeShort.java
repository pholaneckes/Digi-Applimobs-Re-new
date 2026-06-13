package love.digimons.digi_applimobs.util;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.gui.AppliIconButton;
import love.digimons.digi_applimobs.gui.modified.AppliedButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.widget.ForgeSlider;

import static love.digimons.digi_applimobs.util.OpenAppliGui.pageADB;

public class CodeShort {
    public static final ResourceLocation APPLIDATAINTEXTURE = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/appli_datatable.png");
    public static final ResourceLocation TEXPOWER = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/power_line.png");

    public static int power1 , power2, power3 , power4 ,power5, power6;

    public static int xSize = 256;
    public static int ySize = 197;

    public static int lasheng;

    public static int length;

    public static AppliIconButton bigIcon, formIcon, attributesIcon;

    public static AppliIconButton u6, u5 , u4, u3 , u2 , u1 , ub;

    public static AppliedButton buttonprev,buttonnext,buttongo;

    public static ForgeSlider sliderBar;

    public static AppliIconButton buttona1,buttona2,buttona3,buttona4,buttona5;
    public static AppliIconButton buttonb1,buttonb2,buttonb3,buttonb4,buttonb5;
    public static AppliIconButton buttonc1,buttonc2,buttonc3,buttonc4,buttoncl;

    public static EditBox textFieldWidget;
    public static Button buttonSearch;

    //public static SliderPercentageOption option;


    public static void DigitalNumber(int power){
        if(power < 999999) {
            power1 = power / 100000 % 10;
            power2 = power / 10000 % 10;
            power3 = power / 1000 % 10;
            power4 = power / 100 % 10;
            power5 = power / 10 % 10;
            power6 = power % 10;
        }else {
            power1 = -6;
            power2 = -11;
            power3 = -10;
            power4 = -6;
            power5 = 5;
            power6 = 5;
        }
    }

    public static void AppliDatasRender(GuiGraphics matrixStack, int mouseX, int mouthY, float parTicks) {
        sliderBar.render(matrixStack,mouseX,mouthY,parTicks);
        buttona1.render(matrixStack,mouseX,mouthY,parTicks);
        buttona2.render(matrixStack,mouseX,mouthY,parTicks);
        buttona3.render(matrixStack,mouseX,mouthY,parTicks);
        buttona4.render(matrixStack,mouseX,mouthY,parTicks);
        buttona5.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb1.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb2.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb3.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb4.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb5.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc1.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc2.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc3.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc4.render(matrixStack,mouseX,mouthY,parTicks);
        buttoncl.render(matrixStack,mouseX,mouthY,parTicks);
        buttonprev.render(matrixStack,mouseX,mouthY,parTicks);
        buttonnext.render(matrixStack,mouseX,mouthY,parTicks);
        buttongo.render(matrixStack,mouseX,mouthY,parTicks);
    }

    public static void AppliDataInRender(GuiGraphics matrixStack, int mouseX, int mouthY, float parTicks, int width) {
        formIcon.render(matrixStack, mouseX, mouthY, parTicks);
        bigIcon.render(matrixStack, mouseX, mouthY, parTicks);
        attributesIcon.render(matrixStack, mouseX, mouthY, parTicks);
        ub.render(matrixStack, mouseX, mouthY, parTicks);
        u1.render(matrixStack, mouseX, mouthY, parTicks);
        u2.render(matrixStack, mouseX, mouthY, parTicks);
        u3.render(matrixStack, mouseX, mouthY, parTicks);
        u4.render(matrixStack, mouseX, mouthY, parTicks);
        u5.render(matrixStack, mouseX, mouthY, parTicks);
        u6.render(matrixStack, mouseX, mouthY, parTicks);
        //Minecraft.getInstance().getTextureManager().bindForSetup(TEXPOWER);
        matrixStack.blit(TEXPOWER,width / 2 + 14, 163, 0, 0, length, 46, lasheng, 46);
    }

    public static void AppliInInit(String name, int width, AppliEntity appmon){
        bigIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_" + name.replaceAll("MOB", "").toLowerCase() + ".png"), width / 2 - 110, 45, 98, 98, Component.nullToEmpty("dga.gui.button.inner"), "", (button) -> {
        }, 76);
        formIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/forms_" + AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getSerializedName() + ".png"), width / 2 - 108, 152, 34, 34, Component.nullToEmpty("dga.gui.button.inner.form"), Component.translatable("dga.forms." + AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getSerializedName().toLowerCase()).getString(), (button) -> {
        });
        attributesIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/attri_" + Ways.getAppmonAttribute(name, appmon) + ".png"), width / 2 - 62, 152, 34, 34, Component.nullToEmpty("dga.gui.button.inner.attribute"), Component.translatable("dga.attributes." + Ways.getAppmonAttribute(name,appmon)).getString(), (button) -> {
        });
        u1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power1+".png"), width / 2 +10, 171, 12, 18, Component.nullToEmpty("dga.gui.button.inner.u1"), "        ", (button) -> {
        });
        u2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power2+".png"), width / 2 +24, 171, 12, 18, Component.nullToEmpty("dga.gui.button.inner.u2"), "        ", (button) -> {
        });
        u3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power3+".png"), width / 2 +37, 176, 10, 15, Component.nullToEmpty("dga.gui.button.inner.u3"), "        ", (button) -> {
        });
        u4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power4+".png"), width / 2 +48, 177, 10, 15, Component.nullToEmpty("dga.gui.button.inner.u4"), "        ", (button) -> {
        });
        u5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power5+".png"), width / 2 +59, 178, 10, 15, Component.nullToEmpty("dga.gui.button.inner.u5"), "        ", (button) -> {
        });
        u6 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power6+".png"), width / 2 +70, 178, 10, 15, Component.nullToEmpty("dga.gui.button.inner.u6"), "        ", (button) -> {
        });
        ub = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power.png"), width / 2 - 5, 163, 90, 46, Component.nullToEmpty("dga.gui.button.inner.power"), "        ", (button) -> {
        });

    }

    public static void powerLineLength(int force){
        lasheng = 63;
        length = force > 999999 ? 83 + (force-1000000)/150000 : force > 250000 ? 59 + (force-250000)/30000 : force > 100000 ? 50 + (force-100000)/16666 : force > 50000 ? 35 + (force-50000)/3333 : force > 10000 ? 24 + (force-10000)/3636 : force > 5000? 15 + (force-5000)/555 : force >1000 ? 8 + (force-1000)/571 : force > 10 ? (int)Math.ceil(2.0 + force/166.0) : force > 0 ? 1 : 0;

        if(length > 63){
            lasheng = length;
            length = 63;
        }
    }

    public static Component createDatatable(String name){
        return AppliSetup.AppmonTypes.valueOf(name).getData();
    }

    public static void canUseHantei(){
        buttonprev.active = pageADB >= 1;
        buttonnext.active = pageADB <= 8;
        //buttonSearch.active = !textFieldWidget.getValue().isEmpty();
    }
}
