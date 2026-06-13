package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.appli_helpers.AppliAttributes;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.gui.screen.AppliStatsScreen;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import love.digimons.digi_applimobs.network.SendPack;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class AppliDrive extends Item {
    public AppliDrive(){
        super(new Item.Properties().stacksTo(1));
    }
    public static Entity appmon;
    public static AppliEntity appmonWithOwnerPointed;
    //public static ServerPlayer appmonOwner;

    public static ServerLevel pubServerworld;


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(world instanceof ServerLevel){
            pubServerworld = (ServerLevel) world;
        }
        if(Ways.getPointedEntity(player, 64.0) != null){
            Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
            if (onLookedEnti instanceof AppliEntity){
                appmon = onLookedEnti;
                if (((AppliEntity) appmon).isTame()) {
                    appmonWithOwnerPointed = (AppliEntity)appmon;
                }
            }
            if (!world.isClientSide && appmon instanceof AppliEntity) {
                if(player.isShiftKeyDown()) {
                    int appmonPower = ((AppliEntity) appmon).getAppmonPower();
                    NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer) player), new SendPack(appmon.getUUID(), appmonPower, (short) 1));
                }
            }
        }
        //if(world.isClientSide && player.isShiftKeyDown() && appmon instanceof AppliEntity){
        //    int power = ((AppliEntity) appmon).getAppmonPower();
        //    System.out.println(power);
        //}
//        if(world.isClientSide() && KeyboardManager.OPEN_APPLIDATATABLE_KEY.isDown())
//        {
//            if (!player.isShiftKeyDown()){
//                AppliDatatableInnerScreen.isFailed = false;
//                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
//            }
//        }
        return super.use(world, player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    public static void OpenAppliStatsGui(AppliEntity entity, int power) {
        if(entity != null) {
            Minecraft.getInstance().setScreen(new AppliStatsScreen(entity,power));
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level worldIn, Entity enti, int i, boolean b) {
        if (!itemStack.hasTag()) {
            itemStack.setTag(new CompoundTag());
        }

        if(itemStack.getTag().isEmpty()){
            itemStack.getTag().putByte("Warumob", (byte) 9);
            itemStack.getTag().putString("AppmonName", "null");
            itemStack.getTag().putFloat("AppmonHP", -1);
            itemStack.getTag().putInt("AppmonPower", -1);
            itemStack.getTag().putUUID("Owner", enti.getUUID());
            itemStack.getTag().putInt("app_ver",1);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level worldIn, List<Component> componentList, TooltipFlag flagIn) {
        CompoundTag nbtTag = itemStack.getTag();
        if (nbtTag != null) {
            if(!nbtTag.getString("AppmonName").equals("null")) {
                String waru = "";
                if(nbtTag.getByte("Warumob") != 9){
                    String type = AppliAttributes.Attributes.values()[nbtTag.getByte("Warumob")].getSerializedName();
                    waru = " ("+Component.translatable("dga.attributes."+type).getString()+")";
                }
                componentList.add(Component.nullToEmpty(Component.translatable("dga.text.chip.in").getString() + Component.translatable("entity.digi_applimobs." + nbtTag.getString("AppmonName").toLowerCase()).getString() + waru));
                componentList.add(Component.nullToEmpty(Component.translatable("dga.text.power").getString() + nbtTag.getInt("AppmonPower")));
                componentList.add(Component.nullToEmpty(Component.translatable("dga.text.hp").getString() + nbtTag.getFloat("AppmonHP")));
                componentList.add(Component.nullToEmpty(Component.translatable("dga.text.ver").getString() + nbtTag.getInt("app_ver")));
            }else {
                componentList.add(Component.nullToEmpty(Component.translatable("dga.text.empty.in").getString()));
            }
        }
    }
}
