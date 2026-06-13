
package love.digimons.digi_applimobs.dimension;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.Digi_Applimobs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DimReg {
    public static final ResourceKey<Level> AR_FIELD = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(AppliUtils.MOD_ID,"arfield"));

    public static final ResourceKey<DimensionType> AR_FIELD_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE, AR_FIELD.registry());

    public static void registerDims() {
        Digi_Applimobs.LOGGER.debug("Reg-ing Dim for " + AppliUtils.MOD_ID);
    }
}
