package love.digimons.digi_applimobs.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GatchMonaka extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(4)
            .nutrition(7)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 13 * 20, 2), 0.95f)
            .alwaysEat()
            .build();

    public GatchMonaka() {
        super(new Properties().food(food));
    }
}