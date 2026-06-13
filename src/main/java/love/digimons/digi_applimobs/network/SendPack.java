package love.digimons.digi_applimobs.network;

import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.appli_helpers.GattaiResult;
import love.digimons.digi_applimobs.dimension.DimReg;
import love.digimons.digi_applimobs.entities.*;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.event.AppmonAttackEntityEvent;
import love.digimons.digi_applimobs.event.CapTb;
import love.digimons.digi_applimobs.items.AppliChipItem;
import love.digimons.digi_applimobs.items.AppliDrive;
import love.digimons.digi_applimobs.items.AppliDriveDUO;
import love.digimons.digi_applimobs.items.AppliUnlockedChipItem;
import love.digimons.digi_applimobs.util.Ways;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.AppmonBandProcider;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class SendPack {
    private final UUID uuid;
    private final int intType;
    private final short type;
    private final boolean b;
    private final String text;
    private final CompoundTag compoundTag;

    private final byte byteType;
    private final float floatType;

    public SendPack(FriendlyByteBuf buffer) {
        uuid = buffer.readUUID();
        intType = buffer.readInt();
        type = buffer.readShort();
        b = buffer.readBoolean();
        text = buffer.readUtf();
        compoundTag = buffer.readNbt();
        byteType = buffer.readByte();
        floatType = buffer.readFloat();
    }

    public SendPack(UUID uuid, int power, short type) {
        this.uuid = uuid;
        this.intType = power;
        this.type = type;
        this.b = false;
        this.text = "null";
        this.compoundTag = new CompoundTag();
        this.byteType = -1;
        this.floatType = -1;
    }

    public SendPack(UUID uuid, short type) {
        this.uuid = uuid;
        this.intType = -1;
        this.type = type;
        this.b = false;
        this.text = "null";
        this.compoundTag = new CompoundTag();
        this.byteType = -1;
        this.floatType = -1;
    }

    public SendPack(UUID uuid, Boolean b, String text, int id, short type) {
        this.uuid = uuid;
        this.intType = id;
        this.type = type;
        this.b = b;
        this.text = text;
        this.compoundTag = new CompoundTag();
        this.byteType = -1;
        this.floatType = -1;
    }

    public SendPack(UUID uuid, String text, int pow, short type) {
        this.uuid = uuid;
        this.intType = pow;
        this.type = type;
        this.b = false;
        this.text = text;
        this.compoundTag = new CompoundTag();
        this.byteType = -1;
        this.floatType = -1;
    }

    public SendPack(CompoundTag tag, UUID uuid, short type) {
        this.uuid = uuid;
        this.intType = -1;
        this.type = type;
        this.b = false;
        this.text = "null";
        this.compoundTag = tag;
        this.byteType = -1;
        this.floatType = -1;
    }

    public SendPack(UUID uuid, int id, byte cl, short type) {
        this.uuid = uuid;
        this.intType = id;
        this.type = type;
        this.b = false;
        this.text = "null";
        this.compoundTag = new CompoundTag();
        this.byteType = cl;
        this.floatType = -1;
    }

    public SendPack(UUID uuid,int id, float bst, short type) {
        this.uuid = uuid;
        this.intType = id;
        this.type = type;
        this.b = false;
        this.text = "null";
        this.compoundTag = new CompoundTag();
        this.byteType = -1;
        this.floatType = bst;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(this.uuid);
        buf.writeInt(this.intType);
        buf.writeShort(this.type);
        buf.writeBoolean(this.b);
        buf.writeUtf(this.text);
        buf.writeNbt(this.compoundTag);
        buf.writeByte(this.byteType);
        buf.writeFloat(this.floatType);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if(type == 1) {
                tongbu(intType);
                AppliDrive.OpenAppliStatsGui((AppliEntity) AppliDrive.appmon, ((AppliEntity) AppliDrive.appmon).getAppmonPower());
            }
            if(type == 2){
                toDoAtt(uuid);
            }
            if(type == 3){
                chipIn(uuid);
            }
            if(type == 4){
                appliarise(uuid);
            }
            if(type == 5){
                callBack(uuid);
            }
            if(type == 6){
                goAR(uuid);
            }
            if(type == 7){
                link(uuid);
            }
            if(type == 8){
                updateLinkForClient(b,text, intType);
            }
            if(type == 9){
                tongbuWaruSer(uuid,intType);
            }
            if(type == 100){
                tongbuAppmonBand(compoundTag,uuid);
            }
            if(type == 102){
                tongbuWaru(byteType, intType);
            }
            if(type == 103){
                tongbuHst(intType, floatType);
            }
            if(type == 104) {
                tongbuToSer(uuid,intType);
            }
            if(type == 101){
//                tongbuPower2(power, text);
            }
        });
        ctx.get().setPacketHandled(true);
    }

    public static void tongbuAppmonBand(CompoundTag compoundTag, UUID uuid){
        if(AppliDrive.pubServerworld != null) {
            Player player = (Player) AppliDrive.pubServerworld.getEntity(uuid);
            LazyOptional<ItemStackHandler> capability = player.getCapability(AppmonBandProcider.BANDINV);
            capability.ifPresent((cpd)->{
                cpd.deserializeNBT(compoundTag);
            });
            ItemStackHandler itemStackHandler = new ItemStackHandler(99);
            itemStackHandler.deserializeNBT(compoundTag);
            CapTb.serverBandPackSend(player,itemStackHandler);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void tongbu(int po){
        if(Ways.getPointedEntity(Minecraft.getInstance().getCameraEntity(), 64.0) != null) {
            ((AppliEntity) AppliDrive.appmon).setAppmonPower(po);
        }
    }

    public static void tongbuToSer(UUID uuid, int pow){
        AppliEntity appli = (AppliEntity) AppliDrive.pubServerworld.getEntity(uuid);
        appli.setAppmonPower(pow);
    }

    public static void tongbuHst(int id, float hissatu){
        ((AppliEntity) AppliDrive.pubServerworld.getEntity(id)).setHissatu(hissatu);
    }

    @OnlyIn(Dist.CLIENT)
    public static void tongbuWaru(byte cl,int id){
        Entity entity = Minecraft.getInstance().level.getEntity(id);
        if(entity instanceof WaruAppmobs waruAppmob){
            waruAppmob.setWaruType(cl);
        }
    }

    public static void tongbuWaruSer(UUID uuid, int id){
        if(AppliDrive.appmonWithOwnerPointed != null) {
            Player player = (Player) AppliDrive.pubServerworld.getEntity(uuid);
            Entity entity = Minecraft.getInstance().level.getEntity(id);
            if(entity instanceof WaruAppmobs waruAppmob){
                byte waruType = waruAppmob.getWaruType();
                NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayer) player), new SendPack(waruAppmob.getUUID(),  waruAppmob.getId(), waruType,  (short) 102));
            }
        }
    }


//    @OnlyIn(Dist.CLIENT)
//    public static void tongbuPower2(int pow, String id){
//        AppliEntity appmon = (AppliEntity) Minecraft.getInstance().level.getEntity(Integer.parseInt(id));
//        appmon.setAppmonPower(pow);
//    }

    
    public static void toDoAtt(UUID uuid){
        if(AppliDrive.appmonWithOwnerPointed != null) {
            Player player = (Player) AppliDrive.pubServerworld.getEntity(uuid);
            AppmonAttackEntityEvent.goAttEnti(AppliDrive.appmonWithOwnerPointed, player);
        }
    }

    
    public static void chipIn(UUID uuid) {
        if (AppliDrive.pubServerworld != null) {
            ServerPlayer player = (ServerPlayer) AppliDrive.pubServerworld.getEntity(uuid);
            ItemStack left = player.getItemInHand(InteractionHand.OFF_HAND);
            ItemStack right = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (left.getItem() instanceof AppliDrive) {
                if (right.getItem() instanceof AppliChipItem && left.getTag().getString("AppmonName").equals("null")) {
                    if (right.getItem() instanceof AppliUnlockedChipItem) {
                        player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.chip.unlock").getString()));
                    } else if (right.hasTag()) {
                        String chipName = right.getTag().getString("AppmonName");
                        int power = right.getTag().getInt("AppmonPower");
                        float health = right.getTag().getFloat("AppmonHP");
                        int ver = right.getTag().getInt("app_ver");
                        EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(chipName).getAppmon();
                        CompoundTag nbt = new CompoundTag();
                        nbt.putInt("AppmonPower", power);
                        nbt.putFloat("AppmonHP", health);
                        nbt.putString("AppmonName", chipName);
                        nbt.putInt("app_ver",ver);
                        byte type = AppliSetup.AppmonTypes.valueOf(chipName).getFormTypes().getId();
                        byte attri = AppliSetup.AppmonTypes.valueOf(chipName).getAttributes().getId();
                        if(type > 1){
                            nbt.put("Standard_from",right.getTag().get("Standard_from"));
                        }
                        if(type > 2){
                            nbt.put("Super_from",right.getTag().get("Super_from"));
                            nbt.put("Off_standard_from",right.getTag().get("Off_standard_from"));
                        }
                        if(type > 3){
                            nbt.put("Ultimate_from",right.getTag().get("Ultimate_from"));
                            nbt.put("Sub_standard_from",right.getTag().get("Sub_standard_from"));
                            nbt.put("Off_super_from",right.getTag().get("Off_super_from"));
                            nbt.put("Off_sub_standard_from",right.getTag().get("Off_sub_standard_from"));
                        }
                        if(attri == 9){
                            byte waru = right.getTag().getByte("Warumob");
                            nbt.putByte("Warumob",waru);
                        }
                        left.setTag(nbt);
                        player.getInventory().removeItem(right);
                    }
                } else if (right.equals(ItemStack.EMPTY) && !left.getTag().getString("AppmonName").equals("null")) {
                    AppliChipItem chipItem = (AppliChipItem) AppliSetup.AppmonTypes.valueOf(left.getTag().getString("AppmonName")).getAppmonchip();
                    CompoundTag nbt = new CompoundTag();
                    nbt.putString("AppmonName", left.getTag().getString("AppmonName"));
                    nbt.putInt("AppmonPower", left.getTag().getInt("AppmonPower"));
                    nbt.putFloat("AppmonHP", left.getTag().getFloat("AppmonHP"));
                    nbt.putInt("app_ver", left.getTag().getInt("app_ver"));
                    byte type = AppliSetup.AppmonTypes.valueOf(left.getTag().getString("AppmonName")).getFormTypes().getId();
                    byte attri = AppliSetup.AppmonTypes.valueOf(left.getTag().getString("AppmonName")).getAttributes().getId();
                    if(type > 1){
                        nbt.put("Standard_from",left.getTag().get("Standard_from"));
                    }
                    if(type > 2){
                        nbt.put("Super_from",left.getTag().get("Super_from"));
                        nbt.put("Off_standard_from",left.getTag().get("Off_standard_from"));
                    }
                    if(type > 3){
                        nbt.put("Ultimate_from",left.getTag().get("Ultimate_from"));
                        nbt.put("Sub_standard_from",left.getTag().get("Sub_standard_from"));
                        nbt.put("Off_super_from",left.getTag().get("Off_super_from"));
                        nbt.put("Off_sub_standard_from",left.getTag().get("Off_sub_standard_from"));
                    }
                    if(attri == 9){
                        byte waru = left.getTag().getByte("Warumob");
                        nbt.putByte("Warumob",waru);
                    }
                    ItemStack itemStack = new ItemStack(chipItem, 1, nbt);
                    left.getTag().putString("AppmonName", "null");
                    left.getTag().putFloat("AppmonHP", -1);
                    left.getTag().putInt("AppmonPower", -1);
                    left.getTag().putInt("app_ver",1);
                    if(type > 1){
                        left.getTag().put("Standard_from",new CompoundTag());
                    }
                    if(type > 2){
                        left.getTag().put("Super_from",new CompoundTag());
                        left.getTag().put("Off_standard_from",new CompoundTag());
                    }
                    if(type > 3){
                        left.getTag().put("Ultimate_from",new CompoundTag());
                        left.getTag().put("Sub_standard_from",new CompoundTag());
                        left.getTag().put("Off_super_from",new CompoundTag());
                        left.getTag().put("Off_sub_standard_from",new CompoundTag());
                    }
                    player.setItemInHand(InteractionHand.MAIN_HAND, itemStack);
                    player.getItemInHand(InteractionHand.MAIN_HAND).setTag(nbt);
                }
            }
        }
    }

    
    public static void appliarise(UUID uuid){
        if(AppliDrive.pubServerworld != null){
            ServerPlayer player = (ServerPlayer) AppliDrive.pubServerworld.getEntity(uuid);
            ItemStack left = player.getItemInHand(InteractionHand.OFF_HAND);
            ItemStack right = player.getItemInHand(InteractionHand.MAIN_HAND);
            if(left.getItem() instanceof AppliDrive) {
                summonAppmon(player , left);
            }else if(right.getItem() instanceof AppliDrive) {
                summonAppmon(player , right);
            }
        }
    }

    
    public static void summonAppmon(ServerPlayer player, ItemStack stack){
        String chipName = stack.getTag().getString("AppmonName");
        if(!chipName.equals("null")) {
            int power = stack.getTag().getInt("AppmonPower");
            float health = stack.getTag().getFloat("AppmonHP");
            byte waru = stack.getTag().getByte("Warumob");
            EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(chipName).getAppmon();
            AppliEntity appmon = appli.spawn(AppliDrive.pubServerworld, null, player, new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ()), MobSpawnType.MOB_SUMMONED, false, false);
            stack.getTag().putString("AppmonName", "null");
            stack.getTag().putFloat("AppmonHP", -1);
            stack.getTag().putInt("AppmonPower", -1);
            stack.getTag().putByte("Warumob", (byte) 9);
            player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.al.appliarise").getString()));
            if (stack.getItem() instanceof AppliDriveDUO) {
                appmon.setAppmonPower((int) Math.floor(power * 1.5));
                appmon.DUOChangeTo(true);
                player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.thanks.touchin").getString()));
            } else {
                appmon.setAppmonPower(power);
            }
            Ways.setAppmonHealth(appmon,health);
            if(appmon instanceof StandardApplimob standardApplimob){
                standardApplimob.setAppmonVer(Math.max(stack.getTag().getInt("app_ver"),1));
                stack.getTag().putInt("app_ver", 1);
            }
            if(appmon instanceof SuperApplimob){
                ((SuperApplimob)appmon).setAppStandard((CompoundTag) stack.getTag().get("Standard_from"));
            }
            if(appmon instanceof UltimateApplimob){
                ((UltimateApplimob)appmon).setAppSuper((CompoundTag) stack.getTag().get("Super_from"));
                ((UltimateApplimob)appmon).setOffStandard((CompoundTag) stack.getTag().get("Off_standard_from"));
            }
            if(appmon instanceof GodApplimob){
                ((GodApplimob)appmon).setAppUltimate((CompoundTag) stack.getTag().get("Ultimate_from"));
                ((GodApplimob)appmon).setSubStandard((CompoundTag) stack.getTag().get("Sub_standard_from"));
                ((GodApplimob)appmon).setOffSuper((CompoundTag) stack.getTag().get("Off_super_from"));
                ((GodApplimob)appmon).setOffSubStandard((CompoundTag) stack.getTag().get("Off_sub_standard_from"));
            }
            if(appmon instanceof WaruAppmobs waruAppmobs){
                waruAppmobs.setWaruType(waru);
                NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> player), new SendPack(appmon.getUUID(),  appmon.getId(), waru,  (short) 102));
            }
            appmon.tame(player);
        }
    }

    
    public static void callBack(UUID uuid) {
        if(AppliDrive.pubServerworld != null) {
            ServerPlayer player = (ServerPlayer) AppliDrive.pubServerworld.getEntity(uuid);
            AppliEntity appmonWithOwner = (AppliEntity) AppliDrive.pubServerworld.getEntity(AppliDrive.appmonWithOwnerPointed.getUUID());
            int appmonPower = appmonWithOwner.getAppmonPower();
            float appmonHP = appmonWithOwner.getHealth();
            String appmonName = AppmonNameTools.getRegAppliEntiNameWithoutModId(appmonWithOwner);
            if (!AppliSetup.AppmonTypes.valueOf(appmonName).getAppmonchip().equals(Items.AIR)) {
                if(appmonWithOwner instanceof StandardApplimob){
                    if(((StandardApplimob) appmonWithOwner).isAppliLinked()){
                        return;
                    }
                }
                ItemStack left = player.getItemInHand(InteractionHand.OFF_HAND);
                ItemStack right = player.getItemInHand(InteractionHand.MAIN_HAND);
                if (left.getItem() instanceof AppliDrive || right.getItem() instanceof AppliDrive) {
                    if (appmonWithOwner.isTame() && Objects.equals(appmonWithOwner.getOwner(), player)) {
                        if (appmonWithOwner.isAlive()) {
                            ItemStack appDrive;
                            if (left.getItem() instanceof AppliDrive && left.hasTag()) {
                                appDrive = left;
                            } else if (right.hasTag()) {
                                appDrive = right;
                            }else {
                                appDrive = null;
                            }
                            if (appDrive != null && appDrive.getTag().getString("AppmonName").equals("null")) {
                                if (appmonWithOwner.isDUO()) {
                                    appDrive.getTag().putInt("AppmonPower", (int) Math.ceil(appmonPower / 1.5));
                                } else {
                                    appDrive.getTag().putInt("AppmonPower", appmonPower);
                                }
                                appDrive.getTag().putFloat("AppmonHP", appmonHP);
                                appDrive.getTag().putString("AppmonName", appmonName);
                                if(appmonWithOwner instanceof StandardApplimob standardApplimob){
                                    appDrive.getTag().putInt("app_ver",standardApplimob.getAppmonVer());
                                }
                                if (appmonWithOwner instanceof SuperApplimob) {
                                    appDrive.getTag().put("Standard_from", ((SuperApplimob) appmonWithOwner).getAppStandard());
                                }
                                if (appmonWithOwner instanceof UltimateApplimob) {
                                    appDrive.getTag().put("Super_from", ((UltimateApplimob) appmonWithOwner).getAppSuper());
                                    appDrive.getTag().put("Off_standard_from", ((UltimateApplimob) appmonWithOwner).getOffStandard());
                                }
                                if (appmonWithOwner instanceof GodApplimob) {
                                    appDrive.getTag().put("Ultimate_from", ((GodApplimob) appmonWithOwner).getAppUltimate());
                                    appDrive.getTag().put("Sub_standard_from", ((GodApplimob) appmonWithOwner).getSubStandard());
                                    appDrive.getTag().put("Off_super_from", ((GodApplimob) appmonWithOwner).getOffSuper());
                                    appDrive.getTag().put("Off_sub_standard_from", ((GodApplimob) appmonWithOwner).getOffSubStandard());
                                }
                                if(appmonWithOwner instanceof WaruAppmobs waruAppmobs){
                                    appDrive.getTag().putByte("Warumob", waruAppmobs.getWaruType());
                                }
                            }
                            appmonWithOwner.remove(Entity.RemovalReason.DISCARDED);
                        }
                    }
                }
            }
        }
    }

    
    public static void goAR(UUID uuid){
        if(AppliDrive.pubServerworld != null) {
            ServerPlayer player = (ServerPlayer) AppliDrive.pubServerworld.getEntity(uuid);
            ServerLevel serverWorld = player.getServer().getLevel(DimReg.AR_FIELD);
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd) -> {
                if (cpd.getDenSNR() > 71) {
                    cpd.setDenSNR(cpd.getDenSNR() - 40);
                    if (!player.level().dimension().equals(DimReg.AR_FIELD)) {
                        player.teleportTo(serverWorld, player.getX(), player.getY() > 147 ? player.getY() : 147, player.getZ(), player.yRotO, player.xRotO);
                    } else {
                        player.teleportTo(player.getServer().getLevel(Level.OVERWORLD), player.getX(), player.getY() > 70 ? player.getY() : 70, player.getZ(), player.yRotO, player.xRotO);
                    }
                } else {
                    player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.dsnr.not_enorgh").getString()));
                }
            });
        }
    }

    
    public static void link(UUID uuid) {
        if(AppliDrive.pubServerworld != null){
            ServerPlayer player = (ServerPlayer) AppliDrive.pubServerworld.getEntity(uuid);
            Entity pointedEntity = Ways.getPointedEntity(player, 64.0);
            if(pointedEntity instanceof StandardApplimob){
                StandardApplimob appmonFr = (StandardApplimob) pointedEntity;
                String frName = AppmonNameTools.getRegAppliEntiNameWithoutModId(appmonFr);
                String beName;
                ItemStack stack;
                if(player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof AppliDrive && player.getItemInHand(InteractionHand.OFF_HAND).hasTag()){
                    stack = player.getItemInHand(InteractionHand.OFF_HAND);
                }else if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof AppliDrive && player.getItemInHand(InteractionHand.MAIN_HAND).hasTag()){
                    stack = player.getItemInHand(InteractionHand.MAIN_HAND);
                }else {
                    return;
                }
                beName = stack.getTag().getString("AppmonName");
                String check;
                check = GattaiResult.checkGattai(frName, beName);
                if(check.equals("noGattai")){
                    check = GattaiResult.checkGattai(beName, frName);
                }
                //Gattai on
                if(!check.equals("noGattai")){
                    int bePower = stack.getTag().getInt("AppmonPower");
                    int frPower = appmonFr.getAppmonPower();
                    int beVer = stack.getTag().getInt("app_ver");
                    int frVer = appmonFr.getAppmonVer();
                    float beHp = stack.getTag().getFloat("AppmonHP");
                    float frHp = appmonFr.getHealth();
                    int beHealthMax = AppliEntity.getAppmonHealth(bePower, AppliSetup.AppmonTypes.valueOf(beName).getFormTypes().getId());
                    int frHealthMax = AppliEntity.getAppmonHealth(appmonFr);
                    float GattaiHP = beHp + frHp - (beHealthMax - beHp + frHealthMax - frHp) / 2.0f;
                    double x = appmonFr.getX();
                    double y = appmonFr.getY();
                    double z = appmonFr.getZ();
                    if(appmonFr.isDUO()){
                        frPower = (int) Math.ceil(frPower/1.5);
                    }
                    if(appmonFr.isAlive()) {
                        EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(check).getAppmon();
                        AppliEntity appmon = appli.spawn(AppliDrive.pubServerworld, null, player, new BlockPos((int) x, (int) y, (int) z), MobSpawnType.MOB_SUMMONED, false, false);
                        assert appmon != null;
                        int extPower = AppliSetup.AppmonTypes.valueOf(frName).getPower() - frPower + AppliSetup.AppmonTypes.valueOf(beName).getPower() - bePower;
                        if (appmonFr instanceof GodApplimob) {
                            return;
                        } else if (appmonFr instanceof UltimateApplimob) {
                            UltimateApplimob ultiFr = (UltimateApplimob)appmonFr;
                            GodApplimob godApplimob = (GodApplimob) appmon;
                            godApplimob.setAppmonMainUltimateHealth(frHp);
                            godApplimob.setAppmonMainUltimateName(frName);
                            godApplimob.setAppmonMainUltimatePower(frPower);
                            godApplimob.setAppmonMainUltimateVer(frVer);
                            godApplimob.setAppmonOffUltimateHealth(beHp);
                            godApplimob.setAppmonOffUltimateName(beName);
                            godApplimob.setAppmonOffUltimatePower(bePower);
                            godApplimob.setAppmonOffUltimateVer(beVer);

                            godApplimob.setSubStandard((CompoundTag) stack.getTag().get("Standard_from"));
                            godApplimob.setOffSubStandard((CompoundTag) stack.getTag().get("Off_standard_from"));
                            godApplimob.setOffSuper((CompoundTag) stack.getTag().get("Super_from"));
                            godApplimob.setAppSuper(ultiFr.getAppSuper());
                            godApplimob.setAppStandard(ultiFr.getAppStandard());
                            godApplimob.setOffStandard(ultiFr.getOffStandard());
                        } else if (appmonFr instanceof SuperApplimob) {
                            SuperApplimob superFr = (SuperApplimob)appmonFr;
                            UltimateApplimob ultimateApplimob = (UltimateApplimob) appmon;
                            ultimateApplimob.setAppmonMainSuperHealth(frHp);
                            ultimateApplimob.setAppmonMainSuperName(frName);
                            ultimateApplimob.setAppmonMainSuperPower(frPower);
                            ultimateApplimob.setAppmonMainSuperVer(frVer);
                            ultimateApplimob.setAppmonOffSuperHealth(beHp);
                            ultimateApplimob.setAppmonOffSuperName(beName);
                            ultimateApplimob.setAppmonOffSuperPower(bePower);
                            ultimateApplimob.setAppmonOffSuperVer(beVer);

                            ultimateApplimob.setAppStandard(superFr.getAppStandard());
                            ultimateApplimob.setOffStandard((CompoundTag) stack.getTag().get("Standard_from"));
                        } else {
                            SuperApplimob superApplimob = ((SuperApplimob) appmon);
                            superApplimob.setAppmonMainStandardHealth(frHp);
                            superApplimob.setAppmonMainStandardName(frName);
                            superApplimob.setAppmonMainStandardPower(frPower);
                            superApplimob.setAppmonMainStandardVer(frVer);
                            superApplimob.setAppmonOffStandardHealth(beHp);
                            superApplimob.setAppmonOffStandardName(beName);
                            superApplimob.setAppmonOffStandardPower(bePower);
                            superApplimob.setAppmonOffStandardVer(beVer);
                        }
                        appmonFr.remove(Entity.RemovalReason.DISCARDED);
                        stack.getTag().putString("AppmonName", "null");
                        stack.getTag().putFloat("AppmonHP", -1);
                        stack.getTag().putInt("AppmonPower", -1);
                        stack.getTag().putInt("app_ver",-1);
                        appmon.setAppmonPower(appmon.getAppmonPower() + extPower);
                        if (stack.getItem() instanceof AppliDriveDUO) {
                            appmon.setAppmonPower((int) Math.floor(appmon.getAppmonPower() * 1.5));
                            appmon.DUOChangeTo(true);
                        }
                        appmon.tame(player);
                        Ways.setAppmonHealth(appmon,Math.max(GattaiHP, frHp/2.25f));
                    }
                //Link on
                }else {
                    if (!frName.equals(beName) && !beName.equals("null") /*&& stack.getTag().getUUID("Owner").equals(uuid)*/ && AppliSetup.AppmonTypes.valueOf(frName).getFormTypes().equals(AppliSetup.AppmonTypes.valueOf(beName).getFormTypes()) && !appmonFr.isAppliLinked() && !(appmonFr instanceof GodApplimob)) {
                        int bePower = stack.getTag().getInt("AppmonPower");
                        int frPower = appmonFr.getAppmonPower();
                        int beVer = stack.getTag().getInt("app_ver");
                        float beHp = stack.getTag().getFloat("AppmonHP");
                        float frHp = appmonFr.getHealth();
                        int beHealthMax = AppliEntity.getAppmonHealth(bePower, AppliSetup.AppmonTypes.valueOf(beName).getFormTypes().getId());
                        int frHealthMax = AppliEntity.getAppmonHealth(appmonFr);
                        float linkTaiHP = beHp + frHp - (beHealthMax - beHp + frHealthMax - frHp) / 2.0f;
                        appmonFr.setLinkedAppmonVer(beVer);
                        if (stack.getItem() instanceof AppliDriveDUO && appmonFr.isDUO()) {
                            appmonFr.setAppmonPower((int) Math.floor((bePower * 1.5 + frPower) * 1.2));
                        } else {
                            appmonFr.setAppmonPower((int) Math.floor((bePower + frPower) * 1.2));
                        }
                        Ways.setAppmonHealth(appmonFr,linkTaiHP);
                        appmonFr.setAppmonLinkPower(bePower);
                        appmonFr.setAppmonLinkObjHealth(beHp);
                        appmonFr.setAppmonLinkObjName(beName);
                        appmonFr.setAppliLinkTo(true);

                        if(appmonFr instanceof SuperApplimob){
                            ((SuperApplimob)appmonFr).setLinkStandard((CompoundTag) stack.getTag().get("Standard_from"));
                            if(appmonFr instanceof UltimateApplimob){
                                ((UltimateApplimob)appmonFr).setLinkOffStandard((CompoundTag) stack.getTag().get("Off_standard_from"));
                                ((UltimateApplimob)appmonFr).setLinkSuper((CompoundTag) stack.getTag().get("Super_from"));
                            }
                        }

                        stack.getTag().putString("AppmonName", "null");
                        stack.getTag().putFloat("AppmonHP", -1);
                        stack.getTag().putInt("AppmonPower", -1);
                        stack.getTag().putInt("app_ver", -1);
                        player.sendSystemMessage(Component.nullToEmpty(Component.translatable("dga.msg.applink").getString()));
                        String L_a = Component.translatable("entity.digi_applimobs." + frName.toLowerCase()).getString().replaceAll("\u517d","").replaceAll("兽vi", "").replaceAll("money", "mo_ey").replaceAll("mon", "").replaceAll("mo_ey", "money");
                        String L_b = Component.translatable("entity.digi_applimobs." + beName.toLowerCase()).getString().replaceAll("\u517d","").replaceAll("兽", "").replaceAll("money", "mo_ey").replaceAll("mon", "").replaceAll("mo_ey", "money");
                        player.sendSystemMessage(Component.nullToEmpty(L_a + Component.translatable("dga.text.link.with").getString() + L_b + Component.translatable("dga.mark.exclamation").getString()));

                        NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()->player), new SendPack(uuid, true, beName,appmonFr.getId(),(short) 8));

                    //Link off
                    } else if (beName.equals("null") && appmonFr.isAppliLinked()) {
                        float appmonLinkObjHealth = appmonFr.getAppmonLinkObjHealth();
                        String appChip = appmonFr.getAppmonLinkObjName();
                        int objPower = appmonFr.getAppmonLinkPower();
                        int beVer = appmonFr.getLinkedAppmonVer();
                        int b_power;
                        if (appmonFr.isDUO()) {
                            b_power = (int) Math.ceil(appmonFr.getAppmonPower() / 1.2 - objPower * 1.5);
                        } else {
                            b_power = (int) Math.ceil(appmonFr.getAppmonPower() / 1.2 - objPower);
                        }
                        appmonFr.setAppmonLinkPower(-1);
                        appmonFr.setAppmonLinkObjHealth(-1);
                        appmonFr.setAppmonLinkObjName("null");
                        appmonFr.setAppmonLinkPower(-1);
                        appmonFr.setAppmonPower(b_power);
                        appmonFr.setLinkedAppmonVer(-1);
                        Ways.setAppmonHealth(appmonFr,Math.max(appmonFr.getHealth() - (appmonLinkObjHealth / 1.5f), AppliEntity.getAppmonHealth(appmonFr) / 2f));
                        stack.getTag().putString("AppmonName", appChip);
                        stack.getTag().putFloat("AppmonHP", appmonLinkObjHealth);
                        stack.getTag().putInt("AppmonPower", objPower);
                        stack.getTag().putInt("app_ver", beVer);
                        if(appmonFr instanceof SuperApplimob){
                            stack.getTag().put("Standard_from",((SuperApplimob) appmonFr).getLinkStandard());
                            ((SuperApplimob)appmonFr).setLinkStandard(new CompoundTag());
                            if(appmonFr instanceof UltimateApplimob){
                                stack.getTag().put("Off_standard_from",((UltimateApplimob) appmonFr).getLinkOffStandard());
                                stack.getTag().put("Super_from",((UltimateApplimob) appmonFr).getLinkSuper());
                                ((UltimateApplimob)appmonFr).setLinkOffStandard(new CompoundTag());
                                ((UltimateApplimob)appmonFr).setLinkSuper(new CompoundTag());
                            }
                        }
                        appmonFr.setAppliLinkTo(false);
                        NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()->player), new SendPack(uuid, false, "null", appmonFr.getId(), (short) 8));
                    //Gattai off
                    }else if(beName.equals("null") && appmonFr instanceof SuperApplimob){
                        int frPower = appmonFr.getAppmonPower();
                        float frHp = appmonFr.getHealth();
                        int frHealthMax = AppliEntity.getAppmonHealth(appmonFr);
                        CompoundTag tag = stack.getTag();
                        float chipHealth;
                        int chipPower;
                        int chipVer;
                        int lmonVer;
                        String chipName;
                        String name;
                        float GattaiBeforeHP;
                        double x = appmonFr.getX();
                        double y = appmonFr.getY();
                        double z = appmonFr.getZ();
                        if(appmonFr.isDUO()){
                            frPower = (int) Math.ceil(frPower/1.5);
                        }
                        if(appmonFr.isAlive()) {
                            if (appmonFr instanceof GodApplimob) {
                                name = ((GodApplimob)appmonFr).getAppmonMainUltimateName();
                            } else if (appmonFr instanceof UltimateApplimob) {
                                name = ((UltimateApplimob)appmonFr).getAppmonMainSuperName();
                            } else {
                                name = ((SuperApplimob)appmonFr).getAppmonMainStandardName();
                            }
                            EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(name).getAppmon();
                            AppliEntity appmon = (AppliEntity) appli.spawn(AppliDrive.pubServerworld, null, player, new BlockPos((int) x, (int) y, (int) z), MobSpawnType.MOB_SUMMONED, false, false);
                            assert appmon != null;
                            int extPower = AppliSetup.AppmonTypes.valueOf(frName).getPower() - frPower;
                            if (appmonFr instanceof GodApplimob) {
                                GodApplimob appmonGod = (GodApplimob) appmonFr;
                                GattaiBeforeHP = appmonGod.getAppmonMainUltimateHealth();
                                chipHealth = appmonGod.getAppmonOffUltimateHealth();
                                chipName = appmonGod.getAppmonOffUltimateName();
                                chipPower = appmonGod.getAppmonOffUltimatePower();
                                chipVer = appmonGod.getAppmonOffUltimateVer();

                                UltimateApplimob ultiAppmon = (UltimateApplimob) appmon;
                                ultiAppmon.setAppSuper(appmonGod.getAppSuper());
                                ultiAppmon.setAppStandard(appmonGod.getAppStandard());
                                ultiAppmon.setOffStandard(appmonGod.getOffStandard());

                                lmonVer = appmonGod.getAppmonMainUltimateVer();

                                tag.put("Super_from",appmonGod.getOffSuper());
                                tag.put("Off_standard_from",appmonGod.getOffSubStandard());
                                tag.put("Standard_from",appmonGod.getSubStandard());

                            } else if (appmonFr instanceof UltimateApplimob) {
                                UltimateApplimob appmonUlti = (UltimateApplimob) appmonFr;
                                GattaiBeforeHP = appmonUlti.getAppmonMainSuperHealth();
                                chipHealth = appmonUlti.getAppmonOffSuperHealth();
                                chipName = appmonUlti.getAppmonOffSuperName();
                                chipPower = appmonUlti.getAppmonOffSuperPower();
                                chipVer = appmonUlti.getAppmonOffSuperVer();

                                lmonVer = appmonUlti.getAppmonMainSuperVer();

                                SuperApplimob superAppmon = (SuperApplimob) appmon;
                                superAppmon.setAppStandard(appmonUlti.getAppStandard());
                                tag.put("Standard_from",appmonUlti.getOffStandard());

                            } else {
                                SuperApplimob appmonSuper = (SuperApplimob) appmonFr;
                                GattaiBeforeHP = appmonSuper.getAppmonMainStandardHealth();
                                chipHealth = appmonSuper.getAppmonOffStandardHealth();
                                chipName = appmonSuper.getAppmonOffStandardName();
                                chipPower = appmonSuper.getAppmonOffStandardPower();
                                chipVer = appmonSuper.getAppmonOffStandardVer();
                                lmonVer = appmonSuper.getAppmonMainStandardVer();
                            }
                            tag.putString("AppmonName", chipName);
                            tag.putFloat("AppmonHP", chipHealth);
                            tag.putInt("AppmonPower", chipPower);
                            tag.putInt("app_ver", chipVer);
                            appmon.setAppmonPower(appmon.getAppmonPower() + extPower);
                            if (stack.getItem() instanceof AppliDriveDUO) {
                                appmon.setAppmonPower((int) Math.floor(appmon.getAppmonPower() * 1.5));
                                appmon.DUOChangeTo(true);
                            }
                            Ways.setAppmonHealth(appmon,Math.max(Math.max(GattaiBeforeHP,appmonFr.getHealth()-chipHealth),35));
                            appmon.tame(player);
                            if(appmon instanceof StandardApplimob standardApplimob){
                                standardApplimob.setAppmonVer(lmonVer);
                            }
                            appmonFr.remove(Entity.RemovalReason.DISCARDED);
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void updateLinkForClient(Boolean link, String name, int id){
        Entity entity = Minecraft.getInstance().level.getEntity(id);
        if(entity instanceof StandardApplimob sappmon){
            sappmon.setAppliLinkTo(link);
            sappmon.setAppmonLinkObjName(name);
        }
        else if(AppliDrive.appmonWithOwnerPointed != null) {
            ((StandardApplimob) AppliDrive.appmonWithOwnerPointed).setAppliLinkTo(link);
            ((StandardApplimob) AppliDrive.appmonWithOwnerPointed).setAppmonLinkObjName(name);
        }
    }
}
