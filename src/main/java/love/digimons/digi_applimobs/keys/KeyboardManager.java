package love.digimons.digi_applimobs.keys;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT, modid = AppliUtils.MOD_ID)
public class KeyboardManager {

    public static final List<KeyMapping> KEY_BINDINGS = new ArrayList<>();
    public static final KeyMapping OPEN_APPLIDATATABLE_KEY = new AppliKeyBending(Component.nullToEmpty("open_applidatatable").getString(),  299 ,Component.translatable("key.dga").getString());
    public static final KeyMapping CHOOSE_TO_ATT_APPMON =new AppliKeyBending(Component.nullToEmpty("choose_att").getString(), 39,Component.translatable("key.dga").getString());
    public static final KeyMapping GO_TO_APPLI_FIELD =new AppliKeyBending(Component.nullToEmpty("go_af").getString(), 298 ,Component.translatable("key.dga").getString());
    public static final KeyMapping LET_APPLI_ARISE =new AppliKeyBending(Component.nullToEmpty("appli_arise").getString(), 61 ,Component.translatable("key.dga").getString());
    public static final KeyMapping LET_APPLI_ARISE_BACK =new AppliKeyBending(Component.nullToEmpty("appli_arise_back").getString(), 89 ,Component.translatable("key.dga").getString());
    public static final KeyMapping CHIP_IN =new AppliKeyBending(Component.nullToEmpty("appmon_chip_put_in").getString(), 79 ,Component.translatable("key.dga").getString());
    public static final KeyMapping APPMON_LINK_OR_GATTAI = new AppliKeyBending(Component.nullToEmpty("link_or_gattai").getString(),75,Component.translatable("key.dga").getString());


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void regKey(RegisterKeyMappingsEvent event){
        event.register(OPEN_APPLIDATATABLE_KEY);
        event.register(CHOOSE_TO_ATT_APPMON);
        event.register(GO_TO_APPLI_FIELD);
        event.register(LET_APPLI_ARISE);
        event.register(LET_APPLI_ARISE_BACK);
        event.register(CHIP_IN);
        event.register(APPMON_LINK_OR_GATTAI);
    }
}
