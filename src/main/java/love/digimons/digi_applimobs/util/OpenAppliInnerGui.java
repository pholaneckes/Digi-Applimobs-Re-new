package love.digimons.digi_applimobs.util;

import love.digimons.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import net.minecraft.client.Minecraft;

public class OpenAppliInnerGui {
    public static int inner;
    public OpenAppliInnerGui() {
        Minecraft.getInstance().setScreen(new AppliDatatableInnerScreen((byte) inner));
    }
}
