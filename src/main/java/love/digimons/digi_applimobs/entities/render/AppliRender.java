//package gq.codephon.digi_applimobs.entities.render;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import gq.codephon.digi_applimobs.entities.*;
//import gq.codephon.digi_applimobs.entities.models.AppliModel;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.Font;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.resources.language.I18n;
//import net.minecraft.network.chat.Component;
//import org.apache.commons.lang3.ArrayUtils;
//import org.jetbrains.annotations.NotNull;
//import software.bernie.geckolib.cache.object.BakedGeoModel;
//import software.bernie.geckolib.renderer.GeoEntityRenderer;
//
//import static gq.codephon.digi_applimobs.entities.models.AppliModel.appmonAlready;
//
//public class AppliRender extends GeoEntityRenderer<AppliEntity> {
//
//    public AppliRender(EntityRendererProvider.Context renderManager) {
//        super(renderManager, new AppliModel());
//        this.shadowRadius = 0.7f; //todo : 可改变的阴影大小
//    }
//
//    @Override
//    public void render(AppliEntity entityIn, float entityYaw, float partialTicks, @NotNull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int packedLightIn) {
//        Minecraft mc = Minecraft.getInstance();
//        this.shadowRadius = entityIn.getBbWidth() /2;
//        if (Minecraft.renderNames() && entityIn != mc.getCameraEntity() && !entityIn.isVehicle()) {
//            String name;
//            boolean isNotTemp = ArrayUtils.contains(appmonAlready, AppliModel.getAppmonClassName(entityIn, false, true));
//            name = I18n.get(Component.translatable("entity.digi_applimobs." + AppliModel.getRegAppliEntiNameWithoutModId(entityIn)).getString().toLowerCase()) + (isNotTemp ? "" : Component.translatable("dga.forms.temp").getString());
//            if(!(entityIn instanceof Temporary)) {
//                this.renderAppmonName(entityIn, name, matrixStackIn, bufferIn, packedLightIn);
//            }
//        }
//        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//    }
//
//    protected void renderAppmonName(AppliEntity entityIn, String displayNameIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
//        if (!(this.entityRenderDispatcher.distanceToSqr(entityIn) > 4096.0)) {
//            matrixStackIn.pushPose();
//            matrixStackIn.translate(0.0, entityIn.getEyeHeight() + 0.5F, 0.0);
//            matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
//            matrixStackIn.scale(-0.05F, -0.05F, 0.05F);
//            this.getFont().drawInBatch(displayNameIn, textMid(displayNameIn), entityIn.getBbHeight() - 25.0f, 553648127, false, matrixStackIn.last().pose(), bufferIn, Font.DisplayMode.NORMAL, (int)(Minecraft.getInstance().options.getBackgroundOpacity(0.25F) * 255.0F) << 24, packedLightIn, !entityIn.isDiscrete());
//            if (!entityIn.isDiscrete()) {
//                this.getFont().drawInBatch(displayNameIn, textMid(displayNameIn), entityIn.getBbHeight() - 25.0f , -1, false, matrixStackIn.last().pose(), bufferIn,Font.DisplayMode.NORMAL,  0, packedLightIn,false);
//            }
//            if(entityIn instanceof StandardApplimob){
//                String showingText = getST((StandardApplimob) entityIn);
//                if(!showingText.equals("null")) {
//                    this.getFont().drawInBatch(showingText, textMid(showingText), entityIn.getBbHeight() - 15.0f, -1, false, matrixStackIn.last().pose(), bufferIn,Font.DisplayMode.NORMAL, 0, packedLightIn, false);
//                }
//            }
//            matrixStackIn.popPose();
//        }
//
//    }
//
//    public static String getST(StandardApplimob entityIn){
//        if(entityIn != null && entityIn.isAppliLinked()) {
//            String lickObj = I18n.get(Component.translatable("entity.digi_applimobs." + entityIn.getAppmonLinkObjName().toLowerCase()).getString());
//            return Component.translatable("txt.link.with.a").getString() + lickObj + Component.translatable("txt.link.with.b").getString();
//        }else return "null";
//    }
//
//    public static float textMid(String text){
//        return -(text.getBytes().length/2.0f)*2.75f;
//    }
//
//    @Override
//    public void preRender(PoseStack poseStack, AppliEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        if(animatable instanceof Dogatchmob) {
//            poseStack.scale(1.65f,1.65f,1.65f);
//        }else if(animatable instanceof Navimob){
//            poseStack.scale(1.05f,1.05f,1.05f);
//        }
//        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//    }
//}
