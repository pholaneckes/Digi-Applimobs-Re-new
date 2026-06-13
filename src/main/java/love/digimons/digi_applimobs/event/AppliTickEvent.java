package love.digimons.digi_applimobs.event;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static love.digimons.digi_applimobs.entities.AppliEntity.EMOTION;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppliTickEvent {

    public static void doTick(int tickLong, String tickType, Entity appli, int timesIsLastNum){

        int lastNum = timesIsLastNum;

        String runType = tickType;

        Entity applimob = appli;

        final boolean[] stopTick = {false};

        new Object() {

        private int ticks = 0;
        private int waitTicks;

        public void start (int waitTicksIn){
            this.waitTicks = waitTicksIn;
            MinecraftForge.EVENT_BUS.register(this);
        }

        @SubscribeEvent
        public void tick (TickEvent.ServerTickEvent event){
            if (event.phase == TickEvent.Phase.END) {
                this.ticks += 1;
                if (this.ticks >= this.waitTicks && !stopTick[0]) {
                    //System.out.println(applimob + "  add  " + runType);
                    run();
                    //System.out.println("ok" + this.ticks + " / " +this.waitTicks);
                    stopTick[0] = true;
                }
            }
        }

        private void run (){
            if(Objects.equals(runType, "changeEmoToNormal") && !(applimob == null) && (timesIsLastNum == onEntityInteractEvent.doFeedTimes || timesIsLastNum-35 >= onEntityInteractEvent.doFeedTimes)){
                applimob.getEntityData().set(EMOTION,"normal");
            }else if(Objects.equals(runType, "changeEmoToNormal_oops") && !(applimob == null)){
                applimob.getEntityData().set(EMOTION,"normal");
            }
        }
    }.start(tickLong);
    }
}
