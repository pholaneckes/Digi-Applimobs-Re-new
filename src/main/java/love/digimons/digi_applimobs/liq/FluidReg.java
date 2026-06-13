package love.digimons.digi_applimobs.liq;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.blocks.BlockReg;
import love.digimons.digi_applimobs.items.ItemReg;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class FluidReg {
    public static final ResourceLocation NET_WATER_TEX = new ResourceLocation(AppliUtils.MOD_ID,"block/fluid/net_water");
    public static final ResourceLocation FLOWING_NET_WATER_TEX = new ResourceLocation(AppliUtils.MOD_ID,"block/fluid/net_water_flow");
    //液体注册主字段
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, AppliUtils.MOD_ID);
    //流体属性注册主字段
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, AppliUtils.MOD_ID);
    //注册流体属性
    //格式：public static RegistryObject<FluidType> 流体属性字段名 = 流体属性主字段.register("流体属性注册名"，
    //      () -> new FluidType(FluidType.Properties.create()
    //            .density(密度/克每立方厘米).temperature(温度/摄氏度).viscosity(粘度/厘泊).canDrown(可溺死).canSwim(可游泳).lightLevel(亮度0-15)
    //            .descriptionId("文本")){
    //            ...（绑定材质的部分）
    //     });
    public static RegistryObject<FluidType> ANWType = FLUID_TYPES.register("appli_net_water",
            ()->new FluidType(FluidType.Properties.create()
                    .density(1350).temperature(25).viscosity(40).canDrown(false).canSwim(true).lightLevel(2)
                    .descriptionId("appli_net_water")) {
                @Override
                //绑定材质
                public void initializeClient(Consumer<IClientFluidTypeExtensions> iClientFluidTypeExtensionsConsumer) {
                    iClientFluidTypeExtensionsConsumer.accept(new IClientFluidTypeExtensions() {
                        @Override
                        //绑定静态的
                        public ResourceLocation getStillTexture() {
                            return NET_WATER_TEX;
                        }
                        @Override
                        //绑定流动的
                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_NET_WATER_TEX;
                        }

                        @Override
                        public int getTintColor() {
                            return 0X50edd54b;
                        }
                    });
                }
            });
    //注册流体
    //格式：
    // 静态的：public static RegistryObject<FlowingFluid> 流体主字段 =
    //          流体主字段.register("流体注册名", () -> new ForgeFlowingFluid.Source(下方的Builder方法()));
    // 流动的：public static RegistryObject<FlowingFluid> 流体主字段 =
    //          流体主字段.register("流体注册名", () -> new ForgeFlowingFluid.Flowing(下方的Builder方法()));
    public static RegistryObject<FlowingFluid> stillANW =
            FLUIDS.register("appli_net_water",()->new ForgeFlowingFluid.Source(appliNWBuilFder()));
    public static RegistryObject<FlowingFluid> flowingANW =
            FLUIDS.register("appli_net_water_flowing",()->new ForgeFlowingFluid.Flowing(appliNWBuilFder()));

    //流体Builder方法
    //返回格式：
    //return new ForgeFlowingFluid.Properties(流体属性，流体的静态，流体的动态).block(流体对应的方块字段（见后）).bucket(流体桶字段（见后）);
    private static ForgeFlowingFluid.Properties appliNWBuilFder() {
        return new ForgeFlowingFluid.Properties(ANWType, stillANW, flowingANW)
                .block(BlockReg.appliNetWater).bucket(ItemReg.NetFluidBucket);
    }
}
