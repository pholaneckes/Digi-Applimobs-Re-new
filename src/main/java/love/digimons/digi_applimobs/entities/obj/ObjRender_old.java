package love.digimons.digi_applimobs.entities.obj;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import love.digimons.digi_applimobs.AppliUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ObjRender_old extends ModelPartFB {
    public final ObjectList<ObjQuad> objQuads = new ObjectArrayList<>();
    public final ObjectList<ObjVertex> objVertexes = new ObjectArrayList<>();
    public final ObjectList<UV> uvs = new ObjectArrayList<>();
    public final ObjectList<Vector3f> normal = new ObjectArrayList<>();
    public final ObjectList<ObjFace> face = new ObjectArrayList<>();


    public ObjRender_old(Model model, int textureOffsetU, int textureOffsetV) {
        super(new ArrayList<>(), null);
    }


    public void loadObj(String path, boolean a) {
        String[] line;
        try {
            //System.err.println("qff:"+this.getClass().getResource("tap_g.obj"));
            System.out.println("dga_loading: "+ path);
            //InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
            Optional<Resource> resource = Minecraft.getInstance().getResourceManager().getResource(new ResourceLocation(AppliUtils.MOD_ID, "objmodel/" + path));
            InputStream inputStream;
            if(resource.isPresent()) {
                inputStream = resource.get().open();
            }else {
                return;
            }
            //File objfile = new File(this.getClass().getResource(path).getFile());

            Scanner reader = new Scanner(inputStream);
            while (reader.hasNext()) {
                line = reader.nextLine().split(" ");
                switch (line[0]) {
                    case "v":
                        objVertexes.add(new ObjVertex(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                        break;
                    case "vt":
                        uvs.add(new UV(Float.parseFloat(line[1]), Float.parseFloat(line[2])));
                        break;
                    case "vn":
                        normal.add(new Vector3f(Float.parseFloat(line[1]), Float.parseFloat(line[2]), Float.parseFloat(line[3])));
                        break;
                    case "f":
                        face.add(new ObjFace(line));
                        break;
                    default:
                        break;
                }
            }
            for (ObjFace f : face) {
                objQuads.add(new ObjQuad(
                        new ObjVertex[]{
                                objVertexes.get(f.face[0].v),
                                objVertexes.get(f.face[1].v),
                                objVertexes.get(f.face[2].v),
                                objVertexes.get(f.face[3].v)},
                        a? normal.get(f.face[0].n):new Vector3f(0,0,0),
                        new UV[]{uvs.get(f.face[0].uv), uvs.get(f.face[1].uv), uvs.get(f.face[2].uv), uvs.get(f.face[3].uv)}
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(objQuads);
    }

    public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        if (this.visible) {
            if (!this.objQuads.isEmpty()) {
                matrices.pushPose();
                this.translateAndRotate(matrices);
                this.renderCuboids(matrices.last(), vertexConsumer, light, overlay, red, green, blue, alpha);
                matrices.popPose();
            }
        }
    }

    private void renderCuboids(PoseStack.Pose matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        Matrix4f matrix4f = matrices.pose();
        Matrix3f matrix3f = matrices.normal();
        for (ObjQuad quad : this.objQuads) {
            Vector3f vector3f = new Vector3f(quad.direction.x,quad.direction.y,quad.direction.z);// quad.direction.copy();
            vector3f = matrix3f.transform(vector3f);
            float f = vector3f.x();
            float g = vector3f.y();
            float h = vector3f.z();

            for (int i = 0; i < 4; ++i) {
                ObjVertex vertex = quad.vertices[i];
                float j = vertex.pos.x() / 16.0F;
                float k = vertex.pos.y() / 16.0F;
                float l = vertex.pos.z() / 16.0F;
                Vector4f vector4f = new Vector4f(j, k, l, 1.0F);
                vector4f = matrix4f.transform(vector4f);
                vertexConsumer.vertex(vector4f.x(), vector4f.y(), vector4f.z(), red, green, blue, alpha, quad.uv[i].u, quad.uv[i].v, overlay, light, f, g, h);
            }

        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class ObjVertex {
        public final Vector3f pos;

        public ObjVertex(float x, float y, float z) {
            this(new Vector3f(x, y, z));
        }

        public ObjVertex(Vector3f vector3f) {
            this.pos = vector3f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class ObjQuad {
        public final ObjVertex[] vertices;
        public final UV[] uv;
        public final Vector3f direction;

        public ObjQuad(ObjVertex[] vertices, Vector3f normal, UV[] uv) {
            this.vertices = vertices;
            this.uv = uv;
            this.direction = normal;
        }
    }

    public static class UV {
        public float u;
        public float v;
        public UV(float u, float v){
            this.u=u;
            this.v=v;
        }
    }
    public static class ObjFace {
        public final FacePoint[] face = new FacePoint[4];

        public ObjFace(String[] face) {
            this.face[0] = new FacePoint(face[1].split("/"));
            this.face[1] = new FacePoint(face[2].split("/"));
            this.face[2] = new FacePoint(face[3].split("/"));
            if(face.length<5){
                this.face[3] = this.face[2];
            }else {
                this.face[3] = new FacePoint(face[4].split("/"));
            }
        }
        public static class FacePoint {
            public FacePoint(int v, int n, int uv){
                this.v=v;
                this.n=n;
                this.uv=uv;
            }
            public FacePoint(String...i){
                this.v=Integer.parseInt(i[0])-1;
                this.uv=Integer.parseInt(i[1])-1;
                this.n=Integer.parseInt(i[2])-1;
            }

            public int v;
            public int uv;
            public int n;
        }
    }
}
