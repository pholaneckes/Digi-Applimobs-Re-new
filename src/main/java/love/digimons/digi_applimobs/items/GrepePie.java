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

public class GrepePie extends Item {
    private static final FoodProperties food = (new FoodProperties.Builder())
            .saturationMod(1)
            .nutrition(1)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8888 * 20, 8), 0.99975f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 77777 * 20, 77), 0.0725f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 17 * 20, 2), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 15 * 20, 3), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 5 * 20, 2), 0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 4 * 20, 3), 0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 5 * 20, 250), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 90 * 20, 1), 0.3f)
            .alwaysEat()
            .build();

    public GrepePie() {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
        componentList.add(Component.translatable("dga.tip.grepe"));
    }
}