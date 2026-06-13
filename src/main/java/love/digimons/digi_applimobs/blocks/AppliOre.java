package love.digimons.digi_applimobs.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class AppliOre extends Block {
    public AppliOre() {
        super(Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.9F, 3.2f));
    }
}
