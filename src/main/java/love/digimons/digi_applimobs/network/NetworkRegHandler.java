package love.digimons.digi_applimobs.network;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkRegHandler {
    public static SimpleChannel CHANNEL;
    private static final String VERSION = "1_DGA";
    private static int ID = 0;
    public static int nextID(){
        return ID++;
    }
    public static void registerMessage(){
        CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(AppliUtils.MOD_ID, "applicap"),
                ()->VERSION,
                (version)-> version.equals(VERSION),
                (version)-> version.equals(VERSION));

        CHANNEL.messageBuilder(SendPack.class, nextID())
                .encoder(SendPack::toBytes)
                .decoder(SendPack::new)
                .consumerNetworkThread(SendPack::handler)
                .add();

        CHANNEL.messageBuilder(DSNRCap.class, nextID())
                .encoder(DSNRCap::encode)
                .decoder(DSNRCap::decode)
                .consumerNetworkThread(DSNRCap::handlePacket)
                .add();

        CHANNEL.messageBuilder(BandCap.class, nextID())
                .encoder(BandCap::encode)
                .decoder(BandCap::decode)
                .consumerNetworkThread(BandCap::handlePacket)
                .add();

//        final ResourceLocation FML_PLAY_RESOURCE = new ResourceLocation(AppliUtils.MOD_ID,"fml_play");
//
//        SimpleChannel playChannel = ChannelBuilder.
//                named(FML_PLAY_RESOURCE).
//                clientAcceptedVersions((s, v) -> true).
//                serverAcceptedVersions((s, v) -> true).
//                networkProtocolVersion(1070).
//                simpleChannel();
//
//        playChannel.messageBuilder(PlayMessages.OpenContainer.class,1070).
//                decoder(PlayMessages.OpenContainer::decode).
//                encoder(PlayMessages.OpenContainer::encode).
//                consumerNetworkThread(PlayMessages.OpenContainer::handle).
//                add();
    }
}
