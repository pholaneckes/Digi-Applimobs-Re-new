package love.digimons.digi_applimobs.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrepePie extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(7)
            .nutrition(11)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 17 * 20, 2), 0.975f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 170 * 20, 3), 0.35f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 170 * 20, 3), 0.55f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1120 * 20, 1), 0.125f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 7 * 20, 33), 0.05725f)
            .alwaysEat()
            .build();

    public CrepePie() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        componentList.add(Component.translatable("dga.tip.crepe"));
    }
}