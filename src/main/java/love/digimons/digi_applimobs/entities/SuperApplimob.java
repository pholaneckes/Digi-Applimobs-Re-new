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

public class SuperApplimob extends StandardApplimob{
    public SuperApplimob(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final EntityDataAccessor<CompoundTag> STANDARD_FROM = SynchedEntityData.defineId(SuperApplimob.class, EntityDataSerializers.COMPOUND_TAG);

    private static final EntityDataAccessor<CompoundTag> STANDARD_LINK_DATA = SynchedEntityData.defineId(SuperApplimob.class, EntityDataSerializers.COMPOUND_TAG);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(STANDARD_FROM, new CompoundTag());
        this.getEntityData().define(STANDARD_LINK_DATA, new CompoundTag());

    }

    @Override
    public void addAdditionalSaveData(CompoundTag saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppStandard().isEmpty()) {
            saveData.put("Standard_from", this.getAppStandard());
        }
        if(!getLinkStandard().isEmpty()) {
            saveData.put("Standard_Link", this.getLinkStandard());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("Standard_from")){
            this.setAppStandard(saveData.getCompound("Standard_from"));
        }
        if(saveData.contains("Standard_Link")){
            this.setLinkStandard(saveData.getCompound("Standard_Link"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnReason, @Nullable SpawnGroupData livingEntityData, @Nullable CompoundTag CompoundTag) {
        this.setAppmonMainStandardPower(-1);
        this.setAppmonMainStandardName("null");
        this.setAppmonMainStandardHealth(-1);
        this.setAppmonMainStandardVer(-1);

        this.setAppmonOffStandardPower(-1);
        this.setAppmonOffStandardName("null");
        this.setAppmonOffStandardHealth(-1);
        this.setAppmonOffStandardVer(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, CompoundTag);
    }

    public CompoundTag getAppStandard() {
        return this.getEntityData().get(STANDARD_FROM);
    }

    public void setAppStandard(CompoundTag tag) {
        this.getEntityData().set(STANDARD_FROM, tag);
    }
    public CompoundTag getLinkStandard() {
        return this.getEntityData().get(STANDARD_LINK_DATA);
    }

    public void setLinkStandard(CompoundTag tag) {
        this.getEntityData().set(STANDARD_LINK_DATA, tag);
    }

    public int getAppmonMainStandardPower() {return this.getAppStandard().getInt("standard_main_obj_power");}

    public void setAppmonMainStandardPower(int power) {this.getAppStandard().putInt("standard_main_obj_power", power);}

    public String getAppmonMainStandardName() {return this.getAppStandard().getString("standard_main_obj_name");}

    public void setAppmonMainStandardName(String name) {this.getAppStandard().putString("standard_main_obj_name", name);}

    public float getAppmonMainStandardHealth() {return this.getAppStandard().getFloat("standard_main_obj_health");}

    public void setAppmonMainStandardHealth(float health) {this.getAppStandard().putFloat("standard_main_obj_health", health);}

    public int getAppmonMainStandardVer() {return this.getAppStandard().getInt("standard_main_obj_ver");}

    public void setAppmonMainStandardVer(int ver) {this.getAppStandard().putInt("standard_main_obj_ver", ver);}

    public int getAppmonOffStandardPower() {return this.getAppStandard().getInt("standard_off_obj_power");}

    public void setAppmonOffStandardPower(int power) {this.getAppStandard().putInt("standard_off_obj_power", power);}

    public String getAppmonOffStandardName() {return this.getAppStandard().getString("standard_off_obj_name");}

    public void setAppmonOffStandardName(String name) {this.getAppStandard().putString("standard_off_obj_name", name);}

    public float getAppmonOffStandardHealth() {return this.getAppStandard().getFloat("standard_off_obj_health");}

    public void setAppmonOffStandardHealth(float health) {this.getAppStandard().putFloat("standard_off_obj_health", health);}

    public int getAppmonOffStandardVer() {return this.getAppStandard().getInt("standard_off_obj_ver");}

    public void setAppmonOffStandardVer(int ver) {this.getAppStandard().putInt("standard_off_obj_ver", ver);}
}
