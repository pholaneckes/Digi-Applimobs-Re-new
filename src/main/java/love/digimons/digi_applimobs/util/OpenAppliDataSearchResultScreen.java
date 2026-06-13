package love.digimons.digi_applimobs.util;

import love.digimons.digi_applimobs.gui.screen.AppliDataSearchResultScreen;
import love.digimons.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import net.minecraft.client.Minecraft;

public class OpenAppliDataSearchResultScreen {

    public static byte pageSADB = 0;
    public OpenAppliDataSearchResultScreen() {
        AppliDatatableInnerScreen.isFailed = false;
        Minecraft.getInstance().setScreen(new AppliDataSearchResultScreen());
        CodeShort.canUseHantei();
    }
}
