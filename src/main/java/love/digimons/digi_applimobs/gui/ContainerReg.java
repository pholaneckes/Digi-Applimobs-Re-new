package love.digimons.digi_applimobs.gui;


import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.gui.inv.band.BandContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ContainerReg
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister
            .create(ForgeRegistries.MENU_TYPES, AppliUtils.MOD_ID);

    public static final RegistryObject<MenuType<BandContainer>> BAND_CONTAINER = CONTAINERS
            .register("appli_band", () -> IForgeMenuType.create((windowId, playerInv, buf) -> BandContainer.fromNetwork(windowId, playerInv)));
}
