package love.digimons.digi_applimobs.entities.appmobs;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.StandardApplimob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Offmob extends StandardApplimob {
    public Offmob(EntityType<? extends AppliEntity> type, Level worldIn) {super(type, worldIn, false);}
}