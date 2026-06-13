package love.digimons.digi_applimobs.items;

import love.digimons.digi_applimobs.appli_helpers.AppliFormTypes;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.StandardApplimob;
import love.digimons.digi_applimobs.entities.appmobs.Gashamob;
import love.digimons.digi_applimobs.util.Ways;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;

public class GashaTicket extends Item {
    public final int nC;
    public final int sC;
    public GashaTicket(int nC, int sC) {
        super(new Properties().stacksTo(1000));
        this.nC = nC;
        this.sC = sC;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
        if(onLookedEnti instanceof Gashamob ||
                (onLookedEnti instanceof StandardApplimob standardApplimob && standardApplimob.isAppliLinked() &&
                        standardApplimob.getAppmonLinkObjName().toLowerCase().contains("gashamo"))){
            normalGasha(player);
            ItemStack itemInHand = player.getItemInHand(hand);
            itemInHand.shrink(1);
        }
        return super.use(level, player, hand);
    }

    private void normalGasha(Player player){
        int ramT = Mth.nextInt(player.getRandom(),0,249);
        while (true){
            AppliSetup.AppmonTypes[] appmons = AppliSetup.AppmonTypes.values();
            AppliSetup.AppmonTypes appmonSet = appmons[Mth.nextInt(player.getRandom(),0,appmons.length)];
            List<AppliSetup.AppmonTypes> appmonTypes = Arrays.asList(AppliSetup.noModelAppmon);
            if(!appmonTypes.contains(appmonSet) && !appmonSet.getAppmonchip().equals(Items.AIR)){
                AppliChipItem appliChipItem = (AppliChipItem) appmonSet.getAppmonchip();;
                if(ramT < nC) {
                    if (appmonSet.getFormTypes().equals(AppliFormTypes.FormTypes.STANDARD)) {
                        AppliUnlockedChipItem appliUnlockedChipItem = Ways.fromChipGetUnlockedChip(appliChipItem);
                        player.addItem(new ItemStack(appliUnlockedChipItem));
                        break;
                    }
                }else if(ramT > sC){
                    if (appmonSet.getFormTypes().equals(AppliFormTypes.FormTypes.SUPER)) {
                        AppliUnlockedChipItem appliUnlockedChipItem = Ways.fromChipGetUnlockedChip(appliChipItem);
                        player.addItem(new ItemStack(appliUnlockedChipItem));
                        break;
                    }
                }else {
                    if (appmonSet.getFormTypes().equals(AppliFormTypes.FormTypes.ULTIMATE)) {
                        AppliUnlockedChipItem appliUnlockedChipItem = Ways.fromChipGetUnlockedChip(appliChipItem);
                        player.addItem(new ItemStack(appliUnlockedChipItem));
                        break;
                    }
                }
            }
        }
    }
}
