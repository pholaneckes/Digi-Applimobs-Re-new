package love.digimons.digi_applimobs.entities.obj;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import love.digimons.digi_applimobs.entities.AppliEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import org.jetbrains.annotations.NotNull;

public class ObjModels<T extends AppliEntity> extends EntityModel<T> {
    private final ObjPreSet objPre;
    //public final ObjRender obj;

    public ObjModels(String path, boolean enableNormal, int yDown){
        this.objPre = new ObjPreSet(this,0,0);
        this.objPre.loadObj(path,enableNormal);
        //this.obj.loadObj(path,enableNormal);
        //this.obj.setTexSize(32,32);
        this.objPre.setAllzRot(135);
        this.objPre.setAllyRot(135);
        this.objPre.setAllyLoc(yDown);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        objPre.loadingAll(poseStack, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(@NotNull AppliEntity appliEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
