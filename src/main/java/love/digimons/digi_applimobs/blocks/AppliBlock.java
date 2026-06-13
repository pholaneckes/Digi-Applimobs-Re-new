package love.digimons.digi_applimobs.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class AppliBlock extends Block {
    public AppliBlock() {
        super(Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6.7F, 12f).sound(SoundType.NETHERITE_BLOCK));
    }
}
