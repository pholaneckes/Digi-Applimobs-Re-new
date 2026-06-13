package love.digimons.digi_applimobs.entities.appmobs;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.SuperApplimob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Santamob extends SuperApplimob {
    public Santamob(EntityType<? extends AppliEntity> type, Level worldIn) {super(type, worldIn, false);}
}