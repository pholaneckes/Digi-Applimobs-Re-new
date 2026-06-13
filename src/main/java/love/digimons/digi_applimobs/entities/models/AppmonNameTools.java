package love.digimons.digi_applimobs.entities.models;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.Temporary;
//import software.bernie.geckolib.model.GeoModel;


public class AppmonNameTools /*extends GeoModel<AppliEntity>*/ {

//    @Override
//    public ResourceLocation getModelResource(AppliEntity object) {
//        return new ResourceLocation(AppliUtils.MOD_ID, "geo/"+getAppli(object)+".geo.json");
//    }
//
//    @Override
//    public ResourceLocation getTextureResource(AppliEntity object) {
//        final ResourceLocation Appmon_normal = new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/applimob/"+getAppli(object)+"_t.png");
//        ResourceLocation Appmon_oops, Appmon_haha;
//
//        Appmon_oops = new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/applimob/" + getAppli(object)+"_oops.png");
//        Appmon_haha = new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/applimob/" + getAppli(object) + "_haha.png");
//
//
//
//        String emo = object.getEmotion();
//        if(Objects.equals(emo, "normal")) {
//            return Appmon_normal;
//        }else if(Objects.equals(emo, "haha")) {
//            return Appmon_haha;
//        }else if(Objects.equals(emo, "oops")){
//            return Appmon_oops;
//        }else {
//            return Appmon_normal;
//        }
//    }
//
//    @Override
//    public ResourceLocation getAnimationResource(AppliEntity animatable) {
//        return new ResourceLocation(AppliUtils.MOD_ID, "animations/"+getAppli(animatable)+".animation.json");
//    }

    public static String getAppmonName(AppliEntity appmon){
        if(!(appmon instanceof Temporary)) {
            int off = appmon.toString().indexOf("mob[");
            return appmon.toString().substring(0, off).toLowerCase() + "mon";
        }
        else {
            return "woody";
        }
    }

    public static String getAppmonClassName(AppliEntity appliEntity){
        return getAppmonClassName(appliEntity, false, true);
    }

    public static String getAppmonClassName(AppliEntity appliEntity, boolean isMob, boolean isSmall){
        String name = appliEntity.getClass().getName().replaceAll("love.digimons.digi_applimobs.entities.","");
        name = isMob ? name : name.replaceAll("mob","mon");
        name = isSmall ? name.toLowerCase() : name.toUpperCase();
        return name;
    }

    public static String getRegAppliEntiNameWithoutModId(AppliEntity entity){
        return getAppmonClassName(entity,true,false).replaceAll("APPMOBS.","");
    }
}
