//package gq.codephon.digi_applimobs.util.uq;
//
//import gq.codephon.digi_applimobs.entities.render.AppliObjRender;
//import net.minecraft.client.player.AbstractClientPlayer;
//import net.minecraft.client.renderer.culling.Frustum;
//import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
//import net.minecraft.client.renderer.entity.EntityRenderer;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.common.MinecraftForge;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.util.Map;
//
//@Mixin(EntityRenderDispatcher.class)
//public class ERDMixin {
//
//    @Shadow
//    private Map<String, EntityRenderer<? extends Player>> playerRenderers;
//    @Shadow
//    public Map<EntityType<?>, EntityRenderer<?>> renderers;
//    @Inject(at = @At("HEAD"), method = "getRenderer")
//    public <T extends Entity> void shouldRender(T p_114383_, CallbackInfoReturnable<EntityRenderer<? super T>> cir){
//        if(!(p_114383_ instanceof AbstractClientPlayer)){
//            EntityRenderer entityRenderer = this.renderers.get(p_114383_.getType());
//            if(entityRenderer == null){
//                cir.setReturnValue((EntityRenderer) this.playerRenderers.get(((AbstractClientPlayer)p_114383_).getModelName()));
//            }
//        }
//    }
//
//    public <T extends Entity> EntityRenderer<? super T> getRenderer(T p_114383_) {
//        if (p_114383_ instanceof AbstractClientPlayer) {
//            String s = ((AbstractClientPlayer)p_114383_).getModelName();
//            EntityRenderer<? extends Player> entityrenderer = this.playerRenderers.get(s);
//            return (EntityRenderer) (entityrenderer != null ? entityrenderer : this.playerRenderers.get("default"));
//        } else {
//            return (EntityRenderer) this.renderers.get(p_114383_.getType());
//        }
//    }
//}
