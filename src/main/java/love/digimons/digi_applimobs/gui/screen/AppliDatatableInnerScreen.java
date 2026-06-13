package love.digimons.digi_applimobs.gui.screen;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.gui.AppliIconButton;
import love.digimons.digi_applimobs.gui.AppliTextWidget;
import love.digimons.digi_applimobs.util.CodeShort;
import love.digimons.digi_applimobs.util.OpenAppliDataSearchResultScreen;
import love.digimons.digi_applimobs.util.OpenAppliGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.DistExecutor;

import java.util.Objects;

import static love.digimons.digi_applimobs.util.CodeShort.*;
import static love.digimons.digi_applimobs.util.OpenAppliDataSearchResultScreen.pageSADB;
import static love.digimons.digi_applimobs.util.OpenAppliGui.pageADB;

public class AppliDatatableInnerScreen extends Screen {

    private final int pose;
    private final String input;
    private AppliEntity fromStats;
    AppliIconButton back;
    private AppliTextWidget atw;
    private final ResourceLocation backIcon = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/back.png");
    public static boolean isSearched = false;
    public static boolean isFailed = false;
    
    public AppliDatatableInnerScreen(byte pose) {
        super(Component.translatable("appli.datatable.gui"));
        this.pose = pose;
        this.input = "NO_INPUT";
    }

    public AppliDatatableInnerScreen(String name, AppliEntity fromStats) {
        super(Component.translatable("appli.datatable.gui"));
        this.input = name;
        this.pose = name.hashCode();
        this.fromStats = fromStats;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float parTicks) {
        super.render(graphics, mouseX, mouseY, parTicks);
        graphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);

        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;

        graphics.blit(APPLIDATAINTEXTURE, wid, 27, 0, 0, xSize, ySize);
        graphics.drawCenteredString(this.font, Component.translatable("appli.datatable.gui"), this.width / 2, 34, -45479);
        this.back.render(graphics, mouseX, mouseY, parTicks);
        String name;
        if(isFailed) {
            name = "FAILED";
        }else if(!Objects.equals(this.input, "NO_INPUT")){
            name = this.input;
        }else {
            if (isSearched) {
                name = AppliDataSearchResultScreen.searchResultList.get(pose + pageSADB * 15);
            } else {
                name = AppliSetup.appmonList[pose + pageADB * 15];
            }
        }

        powerLineLength(Math.max(AppliSetup.AppmonTypes.valueOf(name).getPower(), 0));
        AppliDataInRender(graphics, mouseX, mouseY, parTicks, this.width);
        //graphics.drawString(this.font, AppliSetup.AppmonTypes.valueOf(name).getData().getString(), this.width / 2 + 17, 69, 0Xfdeca6);
        graphics.drawCenteredString(this.font, Component.translatable("entity.digi_applimobs." + name.toLowerCase()).getString(), this.width / 2 + 7, 50, 0XFFFFFF);
        atw.render(graphics,mouseX,mouseY,parTicks);
    }
    

    @Override
    public void init() {
        super.init();
        String name;
        if(isFailed) {
            name = "FAILED";
        }else if(!Objects.equals(this.input, "NO_INPUT")){
            name = this.input;
        }else {
            if (isSearched) {
                name = AppliDataSearchResultScreen.searchResultList.get(pose + pageSADB * 15);
            } else {
                name = AppliSetup.appmonList[pose + pageADB * 15];
            }
        }

        this.back = new AppliIconButton(backIcon, this.width / 2 + 85, 36,36,24,Component.translatable("dga.gui.button.back"), "",(button)->{
            if (fromStats instanceof AppliEntity && !KeyModifier.SHIFT.isActive(null)) {
                 Minecraft.getInstance().setScreen(new AppliStatsScreen(fromStats, fromStats.getAppmonPower()));
            }else {
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> isSearched ? OpenAppliDataSearchResultScreen::new : OpenAppliGui::new);
            }
        });
//        AppliedButton.builder(Component.translatable("dga.gui.button.back"), (button) -> {
//            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> isSearched ? OpenAppliDataSearchResultScreen::new : OpenAppliGui::new);
//        }).pos(this.width / 2 + 70, 45).size(50, 20).build();
        this.addWidget(back);

        CodeShort.DigitalNumber(AppliSetup.AppmonTypes.valueOf(name).getPower());
        CodeShort.AppliInInit(name,width,null);
        this.addWidget(bigIcon);
        this.addWidget(formIcon);
        this.addWidget(attributesIcon);
        this.addWidget(u1);
        this.addWidget(u2);
        this.addWidget(u3);
        this.addWidget(u4);
        this.addWidget(u5);
        this.addWidget(u6);
        this.addWidget(ub);
        this.atw = new AppliTextWidget(this.width / 2, 36,35,65,createDatatable(name),this.font, 125).alignLeft().setColor(0xE4E4FA);
        this.addWidget(atw);
    }
}
