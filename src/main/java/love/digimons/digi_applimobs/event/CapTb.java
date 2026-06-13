package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.network.BandCap;
import love.digimons.digi_applimobs.network.DSNRCap;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.AppmonBandProcider;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber
public class CapTb {
    @SubscribeEvent
    public static void onAttachCapEvent(AttachCapabilitiesEvent<Entity> event){
        Entity object = event.getObject();
        if(object instanceof Player){
            event.addCapability((new ResourceLocation(AppliUtils.MOD_ID,"dsnr")),new DenShiNouRyokuProcider());
            event.addCapability((new ResourceLocation(AppliUtils.MOD_ID,"appmon_band")),new AppmonBandProcider());
        }
    }

    @SubscribeEvent
    public static void onPlayJoin(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if(!event.getLevel().isClientSide() && entity instanceof Player player){
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd)->{
                float appliDenSNR = cpd.getDenSNR();
                //player.sendMessage(Component.nullToEmpty(Component.translatable("dga.msg.show.dsnr").getString()+ appliDenSNR),player.getUUID());
                serverDSNRPackSend(player,cpd);
            });

        }
    }

    private static final CompoundTag tag = new CompoundTag();

    @SubscribeEvent
    public static void onPlayClone(PlayerEvent.Clone event){
        Digi_Applimobs.LOGGER.info("aaq");
        Player player = event.getEntity();

        if(player instanceof ServerPlayer) {
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);

            //if(capability.isPresent() && originalCapability.isPresent()) {
            capability.ifPresent((cpd) -> {
                float deathLeftAppliTotol = tag.getFloat("death_left_appli_totol");
                cpd.setDenSNR(deathLeftAppliTotol * 0.85f);
                serverDSNRPackSend(player, cpd);
                Digi_Applimobs.LOGGER.info("abq" + deathLeftAppliTotol + "  " + cpd.getDenSNR());
                player.serializeNBT().remove("death_left_appli_totol");
            });
            //}
        }
    }

    @SubscribeEvent
    public static void onPlayDes(EntityLeaveLevelEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof ServerPlayer player){
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd)->{
                float appliDenSNR = cpd.getDenSNR();
                serverDSNRPackSend(player,cpd);
                tag.putFloat("death_left_appli_totol",appliDenSNR);
            });
        }
    }


    public static void serverDSNRPackSend(Player player, AppliDenShiNouRyoku cpb){
        NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer) player),new DSNRCap(cpb.getDenSNR()));
    }

    public static void serverBandPackSend(Player player, ItemStackHandler cpb){
        NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer) player),new BandCap(cpb));
    }
}
