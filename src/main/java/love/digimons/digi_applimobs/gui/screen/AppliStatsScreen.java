package love.digimons.digi_applimobs.gui.screen;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.gui.AppliIconButton;
import love.digimons.digi_applimobs.util.CodeShort;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static love.digimons.digi_applimobs.event.AppliHurtEvent.getAppmonAttStats;
import static love.digimons.digi_applimobs.util.CodeShort.*;

public class AppliStatsScreen extends Screen {
    AppliIconButton db;
    private final ResourceLocation dbIcon = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/db.png");
    private final ResourceLocation dbIconCN = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/db_cn.png");

    private final AppliEntity appmon;
    private final int power;
    public AppliStatsScreen(AppliEntity appli, int power) {
        super(Component.translatable("appli.datatable.gui"));
        this.appmon = appli;
        this.power = power;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float parTicks) {
        super.render(graphics, mouseX, mouseY, parTicks);
        graphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;
        graphics.blit(APPLIDATAINTEXTURE,wid, 27, 0, 0, xSize, ySize);
        graphics.drawCenteredString(this.font, Component.translatable("appli.datatable.gui"), this.width / 2, 34, -45479);
        String name;
        name = AppmonNameTools.getRegAppliEntiNameWithoutModId(appmon);

        AppliEntity appliEntity = appmon;

        powerLineLength(Math.max(power, 0));

        AppliDataInRender(graphics, mouseX, mouseY, parTicks, this.width);
        graphics.drawCenteredString(this.font, Component.translatable("entity.digi_applimobs." + name.toLowerCase()).getString(), this.width / 2 + 7, 50, 0XFFFFFF);
        graphics.drawString(this.font, Component.translatable("dga.text.hp").getString() + appliEntity.getHealth() + Component.translatable("dga.mark.leftdown_to_rightup_line").getString() + AppliEntity.getAppmonHealth(appliEntity.getAppmonPower(), AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId()), this.width / 2 + 9, 62, 0XFFFFFF);
        graphics.drawString(this.font, Component.translatable("dga.text.att").getString() + getAppmonAttStats(AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId(), (byte) 4,appliEntity.getAppmonPower()) + Component.translatable("dga.mark.fromXtoY").getString() + getAppmonAttStats(AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId(), (byte) 1,power), this.width / 2 + 9, 74, 0XFFFFFF);
        this.db.render(graphics, mouseX, mouseY, parTicks);
    }

    @Override
    public void init() {
        super.init();
        String name;
        name = AppmonNameTools.getRegAppliEntiNameWithoutModId(appmon);

        this.db = new AppliIconButton(Component.translatable("this.dga.lang").getString().equals("cn") ? dbIconCN : dbIcon, this.width / 2 + 85, 36,36,24,Component.translatable("dga.gui.button.back"), "",(button)->{
            Minecraft.getInstance().setScreen(new AppliDatatableInnerScreen(name, appmon));
        });
        this.addWidget(db);

        CodeShort.DigitalNumber(power);
        CodeShort.AppliInInit(name,width,appmon);
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
    }
}
