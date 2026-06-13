package love.digimons.digi_applimobs.keys;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.client.KeyMapping;

public class AppliKeyBending extends KeyMapping {
    public AppliKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", AppliUtils.MOD_ID, description), keyCode, category);
        KeyboardManager.KEY_BINDINGS.add(this);
    }
}
