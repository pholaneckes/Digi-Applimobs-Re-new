package love.digimons.digi_applimobs.util.varia;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppmonBandProcider implements ICapabilitySerializable<CompoundTag> {

    public static Capability<ItemStackHandler> BANDINV = CapabilityManager.get(new CapabilityToken<>(){});
    private final ItemStackHandler INSTANCE;

    public AppmonBandProcider() {
        this.INSTANCE = new ItemStackHandler(99);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == BANDINV ? LazyOptional.of(()->this.INSTANCE).cast() : LazyOptional.empty();
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
