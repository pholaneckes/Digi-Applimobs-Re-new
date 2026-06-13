package love.digimons.digi_applimobs.entities.obj;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.model.EntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;

public class ObjRender extends ModelPartFB {
    private final ObjectList<ObjQuad> objQuads;
    private final ObjectList<ObjVertex> objVertexes;
    private final ObjectList<UV> uvs;
    private final ObjectList<Vector3f> normals;
    private final ObjectList<ObjFace> faces;

    public ObjectList<ObjQuad> getObjQuads() {
        return objQuads;
    }


    private EntityModel<?> model;
    private Vector4f partVector4f;

    public ObjRender(EntityModel<?> model, int textureOffsetU, int textureOffsetV, ObjectList<ObjQuad> objQuad, ObjectList<ObjVertex> objVertex,
                     ObjectList<UV> uv, ObjectList<Vector3f> normals, ObjectList<ObjFace> faces) {
        super(new ArrayList<>(), null);
        this.model = model;
        this.objQuads = objQuad;
        this.objVertexes = objVertex;
        this.uvs = uv;
        this.normals = normals;
        this.faces = faces;
    }

    public EntityModel<?> getModel(){
        return this.model;
    }

    public void setModel(EntityModel<?> model){
        this.model = model;
    }

    @Override
    public void render(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        if (this.visible) {
            if (!this.objQuads.isEmpty()) {
                poseStack.pushPose();
                this.translateAndRotate(poseStack);
                this.renderCuboids(poseStack.last(), vertexConsumer, light, overlay, red, green, blue, alpha);
                poseStack.popPose();
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
                partVector4f = vector4f;
                vertexConsumer.vertex(vector4f.x(), vector4f.y(), vector4f.z(), red, green, blue, alpha, quad.uv[i].u, quad.uv[i].v, overlay, light, f, g, h);
            }
        }
    }

//    private void renderCuboids(PoseStack.Pose matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
//        Matrix4f matrix4f = matrices.pose();
//        Matrix3f matrix3f = matrices.normal();
//
//        // 预计算方向向量
//        Vector3f transformedDirection = new Vector3f();
//
//        for (ObjQuad quad : this.objQuads) {
//            transformedDirection.set(quad.direction.x, quad.direction.y, quad.direction.z);
//            transformedDirection = matrix3f.transform(transformedDirection);
//            float f = transformedDirection.x();
//            float g = transformedDirection.y();
//            float h = transformedDirection.z();
//
//            // 预先转换所有顶点并存储到数组中
//            Vector4f[] transformedVertices = new Vector4f[4];
//            for (int i = 0; i < 4; ++i) {
//                ObjVertex vertex = quad.vertices[i];
//                float j = vertex.pos.x() / 16.0F;
//                float k = vertex.pos.y() / 16.0F;
//                float l = vertex.pos.z() / 16.0F;
//                Vector4f vector4f = new Vector4f(j, k, l, 1.0F);
//                transformedVertices[i] = matrix4f.transform(vector4f);
//            }
//
//            // 渲染所有顶点
//            for (int i = 0; i < 4; ++i) {
//                Vector4f vector4f = transformedVertices[i];
//                vertexConsumer.vertex(vector4f.x(), vector4f.y(), vector4f.z(), red, green, blue, alpha, quad.uv[i].u, quad.uv[i].v, overlay, light, f, g, h);
//            }
//        }
//    }

    @OnlyIn(Dist.CLIENT)
    static class ObjVertex {
        private final Vector3f pos;
        ObjVertex(float x, float y, float z) {
            this(new Vector3f(x, y, z));
        }
        ObjVertex(Vector3f vector3f) {
            this.pos = vector3f;
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class ObjQuad {
        private final ObjVertex[] vertices;
        private final UV[] uv;
        private final Vector3f direction;

        ObjQuad(ObjVertex[] vertices, Vector3f normal, UV[] uv) {
            this.vertices = vertices;
            this.uv = uv;
            this.direction = normal;
        }
    }

    static class UV {
        private final float u;
        private final float v;
         UV(float u, float v){
            this.u=u;
            this.v=v;
        }
    }
    static class ObjFace {
        final FacePoint[] face = new FacePoint[4];

         ObjFace(String[] face) {
            this.face[0] = new FacePoint(face[1].split("/"));
            this.face[1] = new FacePoint(face[2].split("/"));
            this.face[2] = new FacePoint(face[3].split("/"));
            if(face.length<5){
                this.face[3] = this.face[2];
            }else {
                this.face[3] = new FacePoint(face[4].split("/"));
            }
        }
        static class FacePoint {
             FacePoint(int v, int n, int uv){
                this.v=v;
                this.n=n;
                this.uv=uv;
            }
             FacePoint(String...i){
                this.v=Integer.parseInt(i[0])-1;
                this.uv=Integer.parseInt(i[1])-1;
                this.n=Integer.parseInt(i[2])-1;
            }
            int v;
            int uv;
            int n;
        }
    }

//    static class ObjVertex {
//        private final Vector3f pos;
//
//        ObjVertex(float x, float y, float z) {
//            this.pos = new Vector3f(x, y, z);
//        }
//    }
//
//    static class ObjQuad {
//        private final ObjVertex[] vertices;
//        private final UV[] uv;
//        private final Vector3f direction;
//
//        ObjQuad(ObjVertex[] vertices, Vector3f normal, UV[] uv) {
//            this.vertices = vertices;
//            this.uv = uv;
//            this.direction = normal;
//        }
//    }
//
//    static class UV {
//        private final float u;
//        private final float v;
//
//        UV(float u, float v) {
//            this.u = u;
//            this.v = v;
//        }
//    }
//
//    static class ObjFace {
//        final FacePoint[] face = new FacePoint[4];
//
//        ObjFace(String[] face) {
//            this.face[0] = new FacePoint(face[1].split("/"));
//            this.face[1] = new FacePoint(face[2].split("/"));
//            this.face[2] = new FacePoint(face[3].split("/"));
//            this.face[3] = (face.length < 5) ? this.face[2] : new FacePoint(face[4].split("/"));
//        }
//
//        static class FacePoint {
//            int v;
//            int uv;
//            int n;
//
//            FacePoint(String... parts) {
//                this.v = Integer.parseInt(parts[0]) - 1;
//                this.uv = Integer.parseInt(parts[1]) - 1;
//                this.n = Integer.parseInt(parts[2]) - 1;
//            }
//        }
//    }

    public ObjectList<ObjVertex> getObjVertexes() {
        return objVertexes;
    }

    public ObjectList<UV> getUvs() {
        return uvs;
    }

    public ObjectList<Vector3f> getNormals() {
        return normals;
    }

    public ObjectList<ObjFace> getFaces() {
        return faces;
    }

    public Vector4f getPartVector4f(){
        return this.partVector4f;
    }
}
