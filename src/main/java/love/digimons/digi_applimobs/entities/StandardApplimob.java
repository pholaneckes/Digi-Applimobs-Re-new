package love.digimons.digi_applimobs.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class StandardApplimob extends AppliEntity{
    public StandardApplimob(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final EntityDataAccessor<CompoundTag> APPMON_LINK_OBJ = SynchedEntityData.defineId(StandardApplimob.class, EntityDataSerializers.COMPOUND_TAG);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(APPMON_LINK_OBJ, new CompoundTag());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppLink().isEmpty()) {
            saveData.put("app_link", this.getAppLink());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("app_link")){
            this.setAppLink(saveData.getCompound("app_link"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnReason, @Nullable SpawnGroupData livingEntityData, @Nullable CompoundTag CompoundTag) {
        this.setAppmonLinkPower(-1);
        this.setAppmonLinkObjName("null");
        this.setAppmonLinkObjHealth(-1);
        this.setAppliLinkTo(false);
        this.setAppmonVer(1);
        this.setLinkedAppmonVer(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, CompoundTag);
    }

    public CompoundTag getAppLink() {
        return this.getEntityData().get(APPMON_LINK_OBJ);
    }

    public void setAppLink(CompoundTag tag) {
        this.getEntityData().set(APPMON_LINK_OBJ, tag);
    }

    public int getAppmonLinkPower() {return this.getAppLink().getInt("link_obj_power");}

    public void setAppmonLinkPower(int power) {this.getAppLink().putInt("link_obj_power", power);}

    public String getAppmonLinkObjName() {return this.getAppLink().getString("link_obj_name");}

    public void setAppmonLinkObjName(String name) {this.getAppLink().putString("link_obj_name", name);}

    public float getAppmonLinkObjHealth() {return this.getAppLink().getFloat("link_obj_health");}

    public void setAppmonLinkObjHealth(float health) {this.getAppLink().putFloat("link_obj_health", health);}
    public boolean isAppliLinked() {return this.getAppmon().getBoolean("be_link");}

    public void setAppliLinkTo(boolean isL) {this.getAppmon().putBoolean("be_link", isL);}

    public int getAppmonVer() {return this.getAppmon().getInt("app_ver");}

    public void setAppmonVer(int app_ver) {this.getAppmon().putInt("app_ver", app_ver);}
    public int getLinkedAppmonVer() {return this.getAppmon().getInt("be_app_ver");}

    public void setLinkedAppmonVer(int app_ver) {this.getAppmon().putInt("be_app_ver", app_ver);}
}
