package love.digimons.digi_applimobs.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class Temporary extends AppliEntity{
    public Temporary(EntityType<? extends AppliEntity> type, Level worldIn) {super(type, worldIn, true);}

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.43F).add(Attributes.MAX_HEALTH, 43.7D).add(Attributes.ATTACK_DAMAGE, 2.5D);
    }
}