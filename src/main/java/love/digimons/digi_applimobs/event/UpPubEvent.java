package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.items.AppliDrive;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "digi_applimobs")
public class UpPubEvent {
    @SubscribeEvent
    public static void pubUp(EntityJoinLevelEvent event){
        if(event.getLevel() instanceof ServerLevel && event.getEntity() instanceof Player){
            AppliDrive.pubServerworld = (ServerLevel) event.getLevel();
        }
    }
}
