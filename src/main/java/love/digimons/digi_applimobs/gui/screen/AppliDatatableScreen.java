package love.digimons.digi_applimobs.gui.screen;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.appli_helpers.AppliCNSupports;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.commands.AppliInfoCommand;
import love.digimons.digi_applimobs.gui.AppliIconButton;
import love.digimons.digi_applimobs.gui.modified.AppliedButton;
import love.digimons.digi_applimobs.gui.modified.AppliedForgeSlider;
import love.digimons.digi_applimobs.util.OpenAppliDataSearchResultScreen;
import love.digimons.digi_applimobs.util.OpenAppliGui;
import love.digimons.digi_applimobs.util.OpenAppliInnerGui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static love.digimons.digi_applimobs.util.CodeShort.*;
import static love.digimons.digi_applimobs.util.OpenAppliGui.pageADB;

public class AppliDatatableScreen extends Screen {
    private byte page;

    public AppliDatatableScreen() {
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
        textFieldWidget.render(matrixStack,mouseX,mouthY,parTicks);
        buttonSearch.render(matrixStack,mouseX,mouthY,parTicks);
        AppliDatasRender(matrixStack, mouseX, mouthY, parTicks);
    }

    @Override
    public void init() {
        super.init();
        AppliDataSearchResultScreen.searchResultList = new ArrayList<>();
        AppliDatatableInnerScreen.isSearched = false;
        textFieldWidget = new EditBox(this.font, this.width / 2 - 110, 45, 160, 17, Component.nullToEmpty("appli.gui.search"));
        this.addWidget(textFieldWidget);
        buttonSearch = AppliedButton.builder(Component.translatable("dga.gui.button.gosearch"), (button) -> {
            if(!textFieldWidget.getValue().isEmpty()) {
                String searchValue = textFieldWidget.getValue().toUpperCase();
                List<String> searchResult = new ArrayList<>();
                if(!AppliInfoCommand.isEnglish(searchValue)){
                    searchValue = AppliInfoCommand.stringToUnicode(searchValue,false);
                    for (int i = 0; i <= AppliCNSupports.INCNS.length-1; i++){
                        String comp = AppliCNSupports.INCNS[i];
                        if (comp.contains(searchValue)) {
                            searchResult.add(AppliCNSupports.CNS.valueOf(comp).getSerializedName());
                        }
                    }
                }else {
                    for (int i = 0; i <= 135; i++) {
                        String comp = AppliSetup.appmonList[i];
                        if (comp.contains(searchValue)) {
                            searchResult.add(comp);
                        }
                    }
                }
                for (int i = 0;i<=15;i++){searchResult.add("nul");}
                AppliDataSearchResultScreen.searchResultList = searchResult;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
            }
        }).pos(this.width / 2 + 70, 45).size(50, 17).build();
        this.addWidget(buttonSearch);
        buttona1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+AppliSetup.appmonList[pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a1"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[pageADB * 15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 0;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona1);
        buttona2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[1+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a2"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[1+pageADB * 15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 1;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona2);
        buttona3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[2+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a3"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[2+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 2;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona3);
        buttona4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[3+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a4"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[3+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 3;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona4);
        buttona5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[4+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 67, 35, 35, Component.nullToEmpty("dga.gui.button.a5"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[4+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 4;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttona5);
        buttonb1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+AppliSetup.appmonList[5+pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b1"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[5+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 5;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb1);
        buttonb2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[6+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b2"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[6+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 6;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb2);
        buttonb3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[7+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b3"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[7+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 7;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb3);
        buttonb4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[8+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b4"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[8+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 8;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb4);
        buttonb5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[9+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 109, 35, 35, Component.nullToEmpty("dga.gui.button.b5"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[9+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 9;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonb5);
        buttonc1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/item/applichip/chip_"+AppliSetup.appmonList[10+pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c1"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[10+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 10;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc1);
        buttonc2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[11+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c2"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[11+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 11;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc2);
        buttonc3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[12+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c3"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[12+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 12;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc3);
        buttoncl = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[14+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c4"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[14+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 14;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttoncl);
        buttonc4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/item/applichip/chip_"+AppliSetup.appmonList[13+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 151, 35, 35, Component.nullToEmpty("dga.gui.button.c4"), Component.translatable("entity.digi_applimobs."+AppliSetup.appmonList[13+pageADB*15].toLowerCase()).getString(), (button) -> {
            OpenAppliInnerGui.inner = 13;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addWidget(buttonc4);

        sliderBar = new AppliedForgeSlider(this.width / 2 - 120, 193,120, 17,Component.nullToEmpty("("),Component.nullToEmpty(") : " + pageADB)
        ,0,9,0,1,1,true);
        this.addWidget(sliderBar);

        buttonprev = AppliedButton.builder(Component.translatable("dga.gui.button.prev"), (button) -> {
            if(pageADB >= 1) {
                pageADB--;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
        }).pos(this.width / 2 + 45, 193).size(35, 17).build();
        this.addWidget(buttonprev);
        buttonnext = AppliedButton.builder(Component.translatable("dga.gui.button.next"), (button) -> {
            if(pageADB <= 8) {
                pageADB++;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
        }).pos(this.width / 2 + 85, 193).size(35, 17).build();
        this.addWidget(buttonnext);
        buttongo = AppliedButton.builder(Component.translatable("dga.gui.button.go"), (button) -> {
            if(textFieldWidget.getValue().isEmpty()) {
                page = (byte) sliderBar.getValueInt();
                pageADB = page;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }else {
                String searchValue = textFieldWidget.getValue().toUpperCase().replaceAll("MON","MOB");
                if (AppliInfoCommand.isEnglish(searchValue) && !searchValue.endsWith("MOB")){
                    searchValue = searchValue + "MOB";
                }
                if(ArrayUtils.contains(AppliSetup.appmonList,searchValue)) {
                    short found = 0;
                    for (short i = 0;i<=135;i++){
                        if (Objects.equals(AppliSetup.appmonList[i], searchValue)){
                            found = i;
                            break;
                        }
                    }
                    OpenAppliInnerGui.inner = found % 15;
                    pageADB = (byte) ((found - OpenAppliInnerGui.inner)/15);
                    DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
                }else {
                    AppliDatatableInnerScreen.isFailed = true;
                    DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
                }
            }
        }).pos(this.width / 2 + 5, 193).size(35, 17).build();
        this.addWidget(buttongo);
    }
}
