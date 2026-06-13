package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static love.digimons.digi_applimobs.entities.AppliEntity.getAppmonHealth;

public class AppliChipItem extends Item {

    public AppliChipItem(){
        super(new Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level worldIn, List<Component> componentList, TooltipFlag flagIn) {
        CompoundTag nbtTag = itemStack.getTag();
        if (nbtTag != null) {
            componentList.add(Component.nullToEmpty(Component.translatable("dga.text.power").getString() + nbtTag.getInt("AppmonPower")));
            componentList.add(Component.nullToEmpty(Component.translatable("dga.text.hp").getString() + nbtTag.getFloat("AppmonHP")));
            componentList.add(Component.nullToEmpty(Component.translatable("dga.text.ver").getString() + nbtTag.getInt("app_ver")));
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level worldIn, Entity enti, int i, boolean b) {
        if (!itemStack.hasTag()) {
            itemStack.setTag(new CompoundTag());
        }

        if(itemStack.getTag().isEmpty()){
            String chipName = itemStack.getItem().builtInRegistryHolder().key().location().getPath().toUpperCase().replaceAll("APPLICHIP_","").replaceAll("_UNLOCKED","");
            int power = AppliSetup.AppmonTypes.valueOf(chipName).getPower();
            byte type = AppliSetup.AppmonTypes.valueOf(chipName).getFormTypes().getId();
            byte attri = AppliSetup.AppmonTypes.valueOf(chipName).getAttributes().getId();
            float health = getAppmonHealth(power,type);
            itemStack.getTag().putString("AppmonName",chipName);
            itemStack.getTag().putFloat("AppmonHP", health);
            itemStack.getTag().putInt("AppmonPower", power);
            itemStack.getTag().putInt("app_ver",1);

            if(type > 1){
                itemStack.getTag().put("Standard_from",standard());
            }

            if(type > 2){
                itemStack.getTag().put("Off_standard_from",standard());
                itemStack.getTag().put("Super_from",sUper());
            }

            if(type > 3){
                itemStack.getTag().put("Sub_standard_from",standard());
                itemStack.getTag().put("Off_sub_standard_from",standard());
                itemStack.getTag().put("Off_super_from",sUper());
                itemStack.getTag().put("Ultimate_from",ulti());
            }

            if(attri == 9){
                itemStack.getTag().putByte("Warumob",(byte) 9);
            }
        }
    }

    public static CompoundTag standard() {
        CompoundTag stand = new CompoundTag();
        stand.putString("standard_main_obj_name","null");
        stand.putString("standard_off_obj_name","null");
        stand.putInt("standard_main_obj_power",1);
        stand.putInt("standard_off_obj_power",1);
        stand.putFloat("standard_main_obj_health",1);
        stand.putFloat("standard_off_obj_health",1);
        return stand;
    }

    public static CompoundTag sUper(){
        CompoundTag supeR = new CompoundTag();
        supeR.putString("super_main_obj_name","null");
        supeR.putString("super_off_obj_name","null");
        supeR.putInt("super_main_obj_power",1);
        supeR.putInt("super_off_obj_power",1);
        supeR.putFloat("super_main_obj_health",1);
        supeR.putFloat("super_off_obj_health",1);
        return supeR;
    }

    public static CompoundTag ulti(){
        CompoundTag ultimate = new CompoundTag();
        ultimate.putString("ultimate_main_obj_name","null");
        ultimate.putString("ultimate_off_obj_name","null");
        ultimate.putInt("ultimate_main_obj_power",1);
        ultimate.putInt("ultimate_off_obj_power",1);
        ultimate.putFloat("ultimate_main_obj_health",1);
        ultimate.putFloat("ultimate_off_obj_health",1);
        return ultimate;
    }
}
