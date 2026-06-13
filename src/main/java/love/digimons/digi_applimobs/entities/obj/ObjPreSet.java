package love.digimons.digi_applimobs.entities.obj;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import love.digimons.digi_applimobs.AppliUtils;
import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.entities.AppliEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import org.joml.Vector3f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ObjPreSet {
    private EntityModel<? extends AppliEntity> model;
    private final int textureOffsetU;
    private final int textureOffsetV;
    private boolean loaded = false;
    private boolean loading = false;
    private final Map<String,ObjRender> parts = new HashMap<>();
    public ObjPreSet(EntityModel<? extends AppliEntity> model, int textureOffsetU, int textureOffsetV) {
        this.model = model;
        this.textureOffsetU = textureOffsetU;
        this.textureOffsetV = textureOffsetV;
    }

    public void loadObj(String path, boolean enableNormal) {
        loading = true;
        Digi_Applimobs.LOGGER.info("(PLB MODEL)DgA_loading: " + path);
        String[] line;
        try {
            Optional<Resource> resource = Minecraft.getInstance().getResourceManager().getResource(new ResourceLocation(AppliUtils.MOD_ID, "objmodel/" + path));
            InputStream inputStream;
            if(resource.isPresent()) {
                inputStream = resource.get().open();
            }else {
                return;
            }
            Scanner reader = new Scanner(inputStream);
            ObjectList<ObjRender.ObjQuad> objQuads = new ObjectArrayList<>();
            ObjectList<ObjRender.ObjVertex> objVertexes = new ObjectArrayList<>();
            ObjectList<ObjRender.UV> uvs = new ObjectArrayList<>();
            ObjectList<Vector3f> normal = new ObjectArrayList<>();
            ObjectList<ObjRender.ObjFace> face = new ObjectArrayList<>();
            String partNames = "";
            boolean isfirst = true;
            while (reader.hasNext()) {
                line = reader.nextLine().split(" ");
                //PhuloobMod.LOGGER.info(Arrays.toString(Arrays.stream(line).toArray()));
                switch (line[0]) {
                    case "v":
                        objVertexes.add(new ObjRender.ObjVertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                        break;
                    case "vt":
                        uvs.add(new ObjRender.UV(Float.parseFloat(line[1]), Float.parseFloat(line[2])));
                        break;
                    case "vn":
                        normal.add(new Vector3f(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                        break;
                    case "f":
                        face.add(new ObjRender.ObjFace(line));
                        break;
                    case "o":
                        if(!isfirst){
                            //PhuloobMod.LOGGER.info(parts);
                            setModels(objQuads,objVertexes,uvs,normal,face,enableNormal,partNames);
                            objQuads = new ObjectArrayList<>();
                            //objVertexes = new ObjectArrayList<>();
                            //uvs = new ObjectArrayList<>();
                            //normal = new ObjectArrayList<>();
                            face = new ObjectArrayList<>();
                        }else {
                            isfirst = false;
                        }
                        partNames = line[1];
                    default:
                        break;
                }
            }
            setModels(objQuads,objVertexes,uvs,normal,face,enableNormal,partNames);
            loaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setModels(ObjectList<ObjRender.ObjQuad> objQuad, ObjectList<ObjRender.ObjVertex> objVertex, ObjectList<ObjRender.UV> uv,
                          ObjectList<Vector3f> normal, ObjectList<ObjRender.ObjFace> face, boolean a, String name){
        for (ObjRender.ObjFace f : face) {
            objQuad.add(new ObjRender.ObjQuad(
                    new ObjRender.ObjVertex[]{
                            objVertex.get(f.face[0].v),
                            objVertex.get(f.face[1].v),
                            objVertex.get(f.face[2].v),
                            objVertex.get(f.face[3].v)},
                    a? normal.get(f.face[0].n):new Vector3f(0,0,0),
                    new ObjRender.UV[]{uv.get(f.face[0].uv), uv.get(f.face[1].uv), uv.get(f.face[2].uv), uv.get(f.face[3].uv)}
            ));
        }
        ObjRender objRender = new ObjRender(model, textureOffsetU, textureOffsetV, objQuad, objVertex, uv, normal, face);
        parts.put(name,objRender);
    }

    public boolean isLoaded(){
        return loaded;
    }

    public boolean isLoading(){
        return loading;
    }

    public void modelLoading(String partName, PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha){
        parts.get(partName).render(poseStack,vertexConsumer,light,overlay,red,green,blue,alpha);
    }

    public void loadingAll(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha){
        for (String name: parts.keySet()){
            modelLoading(name,poseStack,vertexConsumer,light,overlay,red,green,blue,alpha);
        }
    }

    public void setAllyRot(float allyRot){
        for (ObjRender objs: parts.values()){
            objs.yRot = allyRot;
        }
    }
    public void setAllzRot(float allzRot){
        for (ObjRender objs: parts.values()){
            objs.zRot = allzRot;
        }
    }

    public void setAllxRot(float allxRot){
        for (ObjRender objs: parts.values()){
            objs.xRot = allxRot;
        }
    }

    public void setAllxLoc(float allxLoc){
        for (ObjRender objs: parts.values()){
            objs.x = allxLoc;
        }
    }

    public void setAllyLoc(float allyLoc){
        for (ObjRender objs: parts.values()){
            objs.y = allyLoc;
        }
    }

    public void setAllzLoc(float allzLoc){
        for (ObjRender objs: parts.values()){
            objs.z = allzLoc;
        }
    }

    public ObjRender getModel(String partName){
        return parts.get(partName);
    }

    public void setAppmonModel(EntityModel<? extends AppliEntity> model){
        this.model = model;
    }

    public EntityModel<? extends AppliEntity> getAppmonModel(){
        return this.model;
    }
}
