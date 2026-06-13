package love.digimons.digi_applimobs.util.varia;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DenShiNouRyokuProcider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<AppliDenShiNouRyoku> DENSHINOURYOKU = CapabilityManager.get(new CapabilityToken<>(){});
    private final AppliDenShiNouRyoku INSTANCE;

    public DenShiNouRyokuProcider() {
        this.INSTANCE = new AppliDenShiNouRyoku();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == DENSHINOURYOKU ? LazyOptional.of(()->this.INSTANCE).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return INSTANCE.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.INSTANCE.deserializeNBT(nbt);
    }

}
