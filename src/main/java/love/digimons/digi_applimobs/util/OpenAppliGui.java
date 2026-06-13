package love.digimons.digi_applimobs.util;

import love.digimons.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import love.digimons.digi_applimobs.gui.screen.AppliDatatableScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class OpenAppliGui {

    public static byte pageADB = 0;
        @OnlyIn(Dist.CLIENT)
        public OpenAppliGui() {
            AppliDatatableInnerScreen.isFailed = false;
            Minecraft.getInstance().setScreen(new AppliDatatableScreen());
            CodeShort.canUseHantei();
        }

}
