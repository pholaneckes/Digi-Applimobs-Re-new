package love.digimons.digi_applimobs;

import love.digimons.digi_applimobs.blocks.BlockReg;
import love.digimons.digi_applimobs.dimension.DimReg;
import love.digimons.digi_applimobs.effects.EffectReg;
import love.digimons.digi_applimobs.entities.EntiReg;
import love.digimons.digi_applimobs.group.CreativeTabReg;
import love.digimons.digi_applimobs.gui.ContainerReg;
import love.digimons.digi_applimobs.gui.inv.band.BandScreen;
import love.digimons.digi_applimobs.items.ItemReg;
import love.digimons.digi_applimobs.liq.FluidReg;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("digi_applimobs")
@Mod.EventBusSubscriber(modid = "digi_applimobs")
public class Digi_Applimobs {
    public static final Logger LOGGER = LogManager.getLogger(AppliUtils.MOD_ID);
    private final ModContainer MOD_CONTAINER = ModLoadingContext.get().getContainer();
    public Digi_Applimobs() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemReg.ITEMS.register(modEventBus);
        BlockReg.BLOCKS.register(modEventBus);
        EntiReg.ENTITIES.register(modEventBus);
        FluidReg.FLUID_TYPES.register(modEventBus);
        FluidReg.FLUIDS.register(modEventBus);
        EffectReg.EFFECTS.register(modEventBus);

        CreativeTabReg.CREATIVE_MODE_TABS.register(modEventBus);

        DimReg.registerDims();

        ContainerReg.CONTAINERS.register(modEventBus);

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);

//        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::genOres);

        AppliUtils.ΪɶҪӌŌᐁ_();
    }

    //
    public void onCommonSetup(FMLCommonSetupEvent event){
        NetworkRegHandler.registerMessage();
    }

    public void onClientSetup(FMLClientSetupEvent event){
        MenuScreens.register(ContainerReg.BAND_CONTAINER.get(), BandScreen::new);
    }

}
