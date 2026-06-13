package love.digimons.digi_applimobs.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class AppliFloor extends Block {
    public AppliFloor() {
        super(Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.1F, 9f).sound(SoundType.NETHERRACK));
    }
}
