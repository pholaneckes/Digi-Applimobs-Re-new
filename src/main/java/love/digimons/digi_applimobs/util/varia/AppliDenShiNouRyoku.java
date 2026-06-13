package love.digimons.digi_applimobs.util.varia;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public class AppliDenShiNouRyoku implements INBTSerializable<Tag> {

    private float denSNR;

    public AppliDenShiNouRyoku() {
        this.denSNR = 700.0f;
    }

    public float getDenSNR() {
        return denSNR;
    }

    public void setDenSNR(float denSNR) {
        this.denSNR = Math.min(Math.max(denSNR,-20f),7000);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("应用能源",denSNR);
        return nbt;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if(nbt instanceof CompoundTag CompoundTag){
            this.denSNR = CompoundTag.getFloat("应用能源");
        }
    }
}
