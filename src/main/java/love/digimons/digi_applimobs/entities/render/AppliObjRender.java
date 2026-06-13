package love.digimons.digi_applimobs.entities.render;

import com.mojang.blaze3d.vertex.PoseStack;
import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.appli_helpers.AppliAttributes;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.StandardApplimob;
import love.digimons.digi_applimobs.entities.Temporary;
import love.digimons.digi_applimobs.entities.WaruAppmobs;
import love.digimons.digi_applimobs.entities.appmobs.Flickmob;
import love.digimons.digi_applimobs.entities.appmobs.Swipemob;
import love.digimons.digi_applimobs.entities.appmobs.Tapmob;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.entities.obj.ObjModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static love.digimons.digi_applimobs.entities.models.AppmonNameTools.getRegAppliEntiNameWithoutModId;

public class AppliObjRender extends MobRenderer<AppliEntity, ObjModels<AppliEntity>> {
    public static String app;

    public AppliObjRender(EntityRendererProvider.Context manager) {
        super(manager,new ObjModels<>("temp"+".obj",false,21),0.7f);
        AppliObjRender.app ="temp";
    }

    public AppliObjRender(EntityRendererProvider.Context manager, String app) {
        super(manager,new ObjModels<>(app+".obj",true,21),0.7f);
        AppliObjRender.app = app;
    }


    @Override
    public void render(AppliEntity entityIn, float entityYaw, float partialTicks, @NotNull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
        //Minecraft mc = Minecraft.getInstance();
        this.shadowRadius = entityIn.getBbWidth() / 2;
        if (Minecraft.renderNames() /* && entityIn != mc.getCameraEntity() && !entityIn.isVehicle()*/ ) {
            String name = I18n.get(Component.translatable("entity.digi_applimobs." + AppmonNameTools.getRegAppliEntiNameWithoutModId(entityIn)).getString().toLowerCase());
            if(!(entityIn instanceof Temporary)) {
                this.renderAppmonName(entityIn, name, matrixStackIn, bufferIn, packedLightIn);
            }
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }



    public void renderAppmonName(AppliEntity entityIn, String displayNameIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (this.entityRenderDispatcher.distanceToSqr(entityIn) <= 4096.0) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.0, entityIn.getEyeHeight() + 0.5F, 0.0);
            matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
            matrixStackIn.scale(-0.05F, -0.05F, 0.05F);
            this.getFont().drawInBatch(displayNameIn, textMid(displayNameIn), entityIn.getBbHeight() - 25.0f, 553648127, false, matrixStackIn.last().pose(), bufferIn,  Font.DisplayMode.NORMAL, (int)(Minecraft.getInstance().options.getBackgroundOpacity(0.25F) * 255.0F) << 24, packedLightIn, !entityIn.isDiscrete());
            if (!entityIn.isDiscrete()) {
                this.getFont().drawInBatch(displayNameIn, textMid(displayNameIn), entityIn.getBbHeight() - 25.0f , -1, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.NORMAL,  0, packedLightIn, false);
            }
            if(entityIn instanceof StandardApplimob){
                String showingText = getST((StandardApplimob) entityIn);
                if(!showingText.equals("null")) {
                    this.getFont().drawInBatch(showingText, textMid(showingText), entityIn.getBbHeight() - 15.0f, -1, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.NORMAL, 0, packedLightIn ,false);
                }
                if(entityIn instanceof WaruAppmobs waruAppmob){
                    String type = AppliAttributes.Attributes.values()[waruAppmob.getWaruType()].getSerializedName();
//                    if(type.equals("null")){
//                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(Minecraft.getInstance().getCameraEntity().getUUID(),waruAppmob.getId(),(short) 9));
//                        type = AppliAttributes.Attributes.values()[waruAppmob.getWaruType()].getSerializedName();
//                    }
                    this.getFont().drawInBatch(Component.translatable("dga.attributes."+type).getString(), textMid(Component.translatable("dga.attributes."+type).getString()), entityIn.getBbHeight() - 35.0f, -1, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.NORMAL, 0, packedLightIn ,false);
                }
            }
            matrixStackIn.popPose();
        }
    }

    public static float textMid(String text){
        return -(text.getBytes().length >> 1)*2.75f;
    }

    public static String getST(StandardApplimob entityIn){
        if(entityIn != null && entityIn.isAppliLinked()) {
            String lickObj = I18n.get(Component.translatable("entity.digi_applimobs." + entityIn.getAppmonLinkObjName().toLowerCase()).getString());
            return Component.translatable("txt.link.with.a").getString() + lickObj + Component.translatable("txt.link.with.b").getString();
        }else return "null";
    }

    @Override
    public ResourceLocation getTextureLocation(AppliEntity app) {
        if(app instanceof Tapmob mob) {
            return new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/tapmob/tapmon_"+ AppliAttributes.Attributes.values()[mob.getWaruType()].getColor() +".png");
        }else if(app instanceof Swipemob mob){
            return new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/swipemob/swipe_"+ AppliAttributes.Attributes.values()[mob.getWaruType()].getColor() +".png");
        }
        else if(app instanceof Flickmob mob){
            return new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/flickmob/flick_"+ AppliAttributes.Attributes.values()[mob.getWaruType()].getColor() +".png");
        }
        else {
            String appli = getRegAppliEntiNameWithoutModId(app).toLowerCase();
            return new ResourceLocation(AppliUtils.MOD_ID, "textures/entity/appobj/"+appli+".png");
        }
    }
}
