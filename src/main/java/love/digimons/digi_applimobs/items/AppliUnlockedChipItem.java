package love.digimons.digi_applimobs.items;

import net.minecraftforge.registries.RegistryObject;

public class AppliUnlockedChipItem extends AppliChipItem {
    private final AppliChipItem lockChip;
    public AppliUnlockedChipItem(RegistryObject<AppliChipItem> lock){
        super();
        lockChip = lock.get();
    }

    public AppliChipItem getLockChip(){
        return lockChip;
    }
}
