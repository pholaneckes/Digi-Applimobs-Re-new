package love.digimons.digi_applimobs.network;

import love.digimons.digi_applimobs.util.varia.AppmonBandProcider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class BandCap {
    public ItemStackHandler dcap;

    public BandCap(ItemStackHandler fCap){
        this.dcap = fCap;
    }

    public ItemStackHandler getDcap() {
        return dcap;
    }

    public static void encode(BandCap cap, FriendlyByteBuf buffer){
        buffer.writeNbt(cap.getDcap().serializeNBT());
    }

    public static BandCap decode(FriendlyByteBuf buffer){
        ItemStackHandler itemStackHandler = new ItemStackHandler(99);
        itemStackHandler.deserializeNBT(buffer.readNbt());
        return new BandCap(itemStackHandler);
    }

    public static void handlePacket(BandCap c, Supplier<NetworkEvent.Context> contextSupplier){
        contextSupplier.get().enqueueWork(()-> onClientCustomPack(c.getDcap()));
        contextSupplier.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientCustomPack(ItemStackHandler c){
        Minecraft mc =Minecraft.getInstance();
        LocalPlayer player = mc.player;
        LazyOptional<ItemStackHandler> capability = player.getCapability(AppmonBandProcider.BANDINV);
        capability.ifPresent((cpb)-> cpb.deserializeNBT(c.serializeNBT()));
    }
}
