package love.digimons.digi_applimobs.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//继承
public class AttriDef extends MobEffect {
    protected AttriDef(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    //每个效果发生时刻 发出的效果
    //amount是效果的等级

    @Override
    public void applyEffectTick(LivingEntity living, int amount) {
        super.applyEffectTick(living, amount);
    }


    //效果发生时刻 的间隔游戏刻设置
    //this == 后面改成对应的 效果注册类
    //k = 15 >> amplifier; 中的数字（15）改为每次 效果发生时刻的间隔游戏刻长度

    //注：lastTicks是剩余的效果时长  amplifier一般为0，不用管

//    @Override
//    public boolean isDurationEffectTick(int lastTicks, int ampl) {
//        if (this == EffectReg.virus_ka.get()) {
//            int k = 25 >> ampl;
//            if (k > 0) {
//                return lastTicks % k == 0;
//            } else {
//                return true;
//            }
//        }
//        return super.isDurationEffectTick(lastTicks, ampl);
//    }
}
