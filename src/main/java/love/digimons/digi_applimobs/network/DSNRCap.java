package love.digimons.digi_applimobs.network;

import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DSNRCap {
    public float dcap;

    public DSNRCap(float fCap){
        this.dcap = fCap;
    }

    public float getDcap() {
        return dcap;
    }

    public static void encode(DSNRCap cap, FriendlyByteBuf buffer){
        buffer.writeFloat(cap.dcap);
    }

    public static DSNRCap decode(FriendlyByteBuf buffer){
        return new DSNRCap(buffer.readFloat());
    }

    public static void handlePacket(DSNRCap c, Supplier<NetworkEvent.Context> contextSupplier){
        contextSupplier.get().enqueueWork(()-> onClientCustomPack(c));
        contextSupplier.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientCustomPack(DSNRCap c){
        Minecraft mc =Minecraft.getInstance();
        LocalPlayer player = mc.player;
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent((cpb)-> cpb.setDenSNR(c.getDcap()));
    }
}
