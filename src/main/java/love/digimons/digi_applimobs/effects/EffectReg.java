package love.digimons.digi_applimobs.effects;

import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectReg {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AppliUtils.MOD_ID);
    //格式：public static final RegistryObject<MobEffect> 效果字段名 = EFFECTS（主字段名）.register("效果注册名",
    //             () -> new 效果类(MobEffectCategory.类型, 0x粒子效果颜色RGB值));

    //MobEffectCategory中（的类型） BENEFICIAL是有益的 HARMFUL是有害的 NEUTRAL是中性效果
    public static final RegistryObject<MobEffect> virus_ka = EFFECTS.register("virus_ka",
            ()-> new VirusKa(MobEffectCategory.HARMFUL,0x3f0d84));

    //weak 是攻击方的弱攻；prov 是攻击方的强攻；def 是防御方的强防；coward 是防御方的弱防
    //颜色 从浅到深 coward weak def prov
    public static final RegistryObject<MobEffect> entaDef = EFFECTS.register("enta_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0xFF0000));
    public static final RegistryObject<MobEffect> entaProv = EFFECTS.register("enta_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0x990000));
    public static final RegistryObject<MobEffect> entaCoward = EFFECTS.register("enta_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0xFFCCCC));
    public static final RegistryObject<MobEffect> entaWeak = EFFECTS.register("enta_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0xFF6666));

    public static final RegistryObject<MobEffect> gameDef = EFFECTS.register("game_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0xFF8000));
    public static final RegistryObject<MobEffect> gameProv = EFFECTS.register("game_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0xCC6600));
    public static final RegistryObject<MobEffect> gameCoward = EFFECTS.register("game_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0xFFE5CC));
    public static final RegistryObject<MobEffect> gameWeak = EFFECTS.register("game_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0xFFB266));

    public static final RegistryObject<MobEffect> lifeDef = EFFECTS.register("life_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0xFF66B2));
    public static final RegistryObject<MobEffect> lifeProv = EFFECTS.register("life_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0xFF3399));
    public static final RegistryObject<MobEffect> lifeCoward = EFFECTS.register("life_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0xFFCCDD));
    public static final RegistryObject<MobEffect> lifeWeak = EFFECTS.register("life_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0xFF99CC));

    public static final RegistryObject<MobEffect> toolDef = EFFECTS.register("tool_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0x9900FF));
    public static final RegistryObject<MobEffect> toolProv = EFFECTS.register("tool_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0x3f0d84));
    public static final RegistryObject<MobEffect> toolCoward = EFFECTS.register("tool_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0x660066));
    public static final RegistryObject<MobEffect> toolWeak = EFFECTS.register("tool_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0xD199FF));

    public static final RegistryObject<MobEffect> sysDef = EFFECTS.register("sys_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0xFFFF00));
    public static final RegistryObject<MobEffect> sysProv = EFFECTS.register("sys_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0xCCCC00));
    public static final RegistryObject<MobEffect> sysCoward = EFFECTS.register("sys_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0xFFFFCC));
    public static final RegistryObject<MobEffect> sysWeak = EFFECTS.register("sys_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0xFFFF66));

    public static final RegistryObject<MobEffect> socDef = EFFECTS.register("soc_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0x0000FF));
    public static final RegistryObject<MobEffect> socProv = EFFECTS.register("soc_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0x000099));
    public static final RegistryObject<MobEffect> socCoward = EFFECTS.register("soc_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0xCCFFFF));
    public static final RegistryObject<MobEffect> socWeak = EFFECTS.register("soc_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0x66CCFF));

    public static final RegistryObject<MobEffect> naviDef = EFFECTS.register("navi_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0x00FF00));
    public static final RegistryObject<MobEffect> naviProv = EFFECTS.register("navi_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0x3f0d84));
    public static final RegistryObject<MobEffect> naviCoward = EFFECTS.register("navi_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0x009900));
    public static final RegistryObject<MobEffect> naviWeak = EFFECTS.register("navi_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0x66FF66));

    public static final RegistryObject<MobEffect> appmonDef = EFFECTS.register("app_def",
            ()-> new AttriDef(MobEffectCategory.BENEFICIAL,0x00FF00));
    public static final RegistryObject<MobEffect> appmonProv = EFFECTS.register("app_prov",
            ()-> new AttriProv(MobEffectCategory.BENEFICIAL,0x3f0d84));
    public static final RegistryObject<MobEffect> appmonCoward = EFFECTS.register("app_coward",
            ()-> new AttriCoward(MobEffectCategory.BENEFICIAL,0x009900));
    public static final RegistryObject<MobEffect> appmonWeak = EFFECTS.register("app_weak",
            ()-> new AttriWeak(MobEffectCategory.BENEFICIAL,0x66FF66));
}
