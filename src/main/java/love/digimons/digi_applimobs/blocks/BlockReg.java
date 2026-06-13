package love.digimons.digi_applimobs.blocks;

import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.liq.FluidReg;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockReg {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AppliUtils.MOD_ID);

    public static final RegistryObject<Block> appliBlock = BLOCKS.register("appli_block", AppliBlock::new);
    public static final RegistryObject<Block> appliOre = BLOCKS.register("appli_ore", AppliOre::new);

    public static final RegistryObject<Block> appliFloor = BLOCKS.register("appli_floor", AppliFloor::new);

    public static RegistryObject<LiquidBlock> appliNetWater = BLOCKS.register("appli_net_water",
            () -> new LiquidBlock(FluidReg.stillANW, LiquidBlock.Properties.of().mapColor(MapColor.WATER).liquid()
                    .noCollission().replaceable().noLootTable().strength(101.0F).sound(SoundType.EMPTY)));
}
