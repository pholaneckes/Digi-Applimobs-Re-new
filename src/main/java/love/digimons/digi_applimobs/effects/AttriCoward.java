package love.digimons.digi_applimobs.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AttriCoward extends MobEffect {
    protected AttriCoward(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amount) {
        super.applyEffectTick(living, amount);
    }
}
