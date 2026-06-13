package love.digimons.digi_applimobs.gui.screen;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.gui.AppliIconButton;
import love.digimons.digi_applimobs.gui.modified.AppliedButton;
import love.digimons.digi_applimobs.util.OpenAppliDataSearchResultScreen;
import love.digimons.digi_applimobs.util.OpenAppliGui;
import love.digimons.digi_applimobs.util.OpenAppliInnerGui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.widget.ForgeSlider;
import net.minecraftforge.fml.DistExecutor;

import java.util.List;

import static love.digimons.digi_applimobs.gui.screen.AppliDatatableInnerScreen.isSearched;
import static love.digimons.digi_applimobs.util.CodeShort.*;
import static love.digimons.digi_applimobs.util.OpenAppliDataSearchResultScreen.pageSADB;

public class AppliDataSearchResultScreen extends Screen {
    Button buttonBack;

    public static List<String> searchResultList;

    private byte page;

    public AppliDataSearchResultScreen() {
        super(Component.translatable("appli.datatable.gui"));
    }

    @Override
    public void render(GuiGraphics matrixStack, int mouseX, int mouthY, float parTicks) {
        super.render(matrixStack, mouseX, mouthY, parTicks);
        matrixStack.setColor(1.0f,1.0f,1.0f,1.0f);

        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;

        matrixStack.blit(APPLIDATAINTEXTURE, wid,27, 0, 0, xSize, ySize);
        matrixStack.drawCenteredString(this.font,Component.translatable("appli.datatable.gui"),this.width / 2, 34, -45479);
        AppliDatasRender(matrixStack, mouseX, mouthY, parTicks);
        buttonBack.render(matrixStack,mouseX,mouthY,parTicks);
    }

    @Override
    public void init() {
        super.init();
        int lengthPages = (int) Math.ceil(searchResultList.size() / 15.0)-2;
        isSearched = true;
        /*
        this.textFieldWidget = new TextFieldWidget(this.font, this.width / 2 - 110, 45, 150, 20, Component.translatable("appli.gui.search"));
        this.children.add(this.textFieldWidget);
        buttonSearch = new Button(this.width / 2 + 45, 45, 35, 20, Component.translatable("dga.gui.button.gosearch"), (button) -> {
            String searchValue = this.textFieldWidget.getValue().toUpperCase();
            List<String> searchResult = new ArrayList<>();
            for (int i = 0;i<=127;i++){
                String comp = AppliSetup.appmonList[i];
                if(comp.contains(searchValue)){
                    searchResult.add(comp);
                }
            }
            System.out.println(searchResult);
            AppliDataSearchResultScreen.searchResultList = searchResult;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
        });
        this.addWidget(buttonSearch);
         */
        buttonBack = AppliedButton.builder(Component.translatable("dga.gui.button.back"), (button) -> {
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
        }).pos(this.width / 2 + 85, 45).size(35, 17).build();
        this.addWidget(buttonBack);
        buttona1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+searchResultList.get(pageSADB*15).toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a1"), Component.translatable("entity.digi_applimobs."+searchResultList.get(pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 0;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona1);
        buttona2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(1+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a2"), Component.translatable("entity.digi_applimobs."+searchResultList.get(1+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 1;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona2);
        buttona3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(2+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a3"), Component.translatable("entity.digi_applimobs."+searchResultList.get(2+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 2;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona3);
        buttona4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(3+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a4"), Component.translatable("entity.digi_applimobs."+searchResultList.get(3+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 3;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona4);
        buttona5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(4+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a5"), Component.translatable("entity.digi_applimobs."+searchResultList.get(4+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 4;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona5);
        buttonb1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+searchResultList.get(5+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b1"), Component.translatable("entity.digi_applimobs."+searchResultList.get(5+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 5;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb1);
        buttonb2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(6+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b2"), Component.translatable("entity.digi_applimobs."+searchResultList.get(6+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 6;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb2);
        buttonb3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(7+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b3"), Component.translatable("entity.digi_applimobs."+searchResultList.get(7+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 7;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb3);
        buttonb4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(8+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b4"), Component.translatable("entity.digi_applimobs."+searchResultList.get(8+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 8;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb4);
        buttonb5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(9+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b5"), Component.translatable("entity.digi_applimobs."+searchResultList.get(9+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 9;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb5);
        buttonc1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+searchResultList.get(10+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c1"), Component.translatable("entity.digi_applimobs."+searchResultList.get(10+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 10;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc1);
        buttonc2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(11+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c2"), Component.translatable("entity.digi_applimobs."+searchResultList.get(11+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 11;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc2);
        buttonc3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(12+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c3"), Component.translatable("entity.digi_applimobs."+searchResultList.get(12+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 12;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc3);
        buttoncl = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+ searchResultList.get(14+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c4"), Component.translatable("entity.digi_applimobs."+searchResultList.get(14+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 14;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttoncl);
        buttonc4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+searchResultList.get(13+pageSADB*15).toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c4"), Component.translatable("entity.digi_applimobs."+searchResultList.get(13+pageSADB*15).toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 13;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc4);

        sliderBar = new ForgeSlider(this.width / 2 - 120, 193,120, 17,Component.nullToEmpty("("),Component.nullToEmpty(") : " + pageSADB)
        ,0,lengthPages,0,1,1,true);
        page = (byte) sliderBar.getValueInt();
        this.addWidget(sliderBar);

        buttonprev = AppliedButton.builder(Component.translatable("dga.gui.button.prev"), (button) -> {
            if(pageSADB >= 1) {
                pageSADB--;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
            }
        }).pos(this.width / 2 + 45, 193).size(35, 17).build();
        this.addWidget(buttonprev);
        buttonnext = AppliedButton.builder( Component.translatable("dga.gui.button.next"), (button) -> {
            if(pageSADB < lengthPages) {
                pageSADB++;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
            }
        }).pos(this.width / 2 + 85, 193).size(35, 17).build();
        this.addWidget(buttonnext);
        buttongo = AppliedButton.builder( Component.translatable("dga.gui.button.go"), (button) -> {
            page = (byte) sliderBar.getValueInt();
            pageSADB = page;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
        }).pos(this.width / 2 + 5, 193).size(35, 17).build();
        this.addWidget(buttongo);
    }
}
