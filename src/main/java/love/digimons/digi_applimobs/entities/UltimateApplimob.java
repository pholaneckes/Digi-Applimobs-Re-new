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

public class UltimateApplimob extends SuperApplimob{
    public UltimateApplimob(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final EntityDataAccessor<CompoundTag> SUPER_FROM = SynchedEntityData.defineId(UltimateApplimob.class, EntityDataSerializers.COMPOUND_TAG);
    private static final EntityDataAccessor<CompoundTag> OFF_STANDARD_FROM = SynchedEntityData.defineId(UltimateApplimob.class, EntityDataSerializers.COMPOUND_TAG);
    private static final EntityDataAccessor<CompoundTag> SUPER_LINK_DATA = SynchedEntityData.defineId(UltimateApplimob.class, EntityDataSerializers.COMPOUND_TAG);
    private static final EntityDataAccessor<CompoundTag> OFF_STANDARD_LINK_DATA = SynchedEntityData.defineId(UltimateApplimob.class, EntityDataSerializers.COMPOUND_TAG);


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(SUPER_FROM, new CompoundTag());
        this.getEntityData().define(OFF_STANDARD_FROM, new CompoundTag());
        this.getEntityData().define(SUPER_LINK_DATA, new CompoundTag());
        this.getEntityData().define(OFF_STANDARD_LINK_DATA, new CompoundTag());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppSuper().isEmpty()) {
            saveData.put("Super_from", this.getAppSuper());
        }
        if(!getOffStandard().isEmpty()) {
            saveData.put("Off_standard_from", this.getOffStandard());
        }
        if(!getLinkSuper().isEmpty()) {
            saveData.put("Super_Link", this.getLinkSuper());
        }
        if(!getLinkOffStandard().isEmpty()) {
            saveData.put("Off_standard_Link", this.getLinkOffStandard());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("Super_from")){
            this.setAppSuper(saveData.getCompound("Super_from"));
        }
        if(saveData.contains("Off_standard_from")){
            this.setOffStandard(saveData.getCompound("Off_standard_from"));
        }
        if(saveData.contains("Super_Link")){
            this.setLinkSuper(saveData.getCompound("Super_Link"));
        }
        if(saveData.contains("Off_standard_Link")){
            this.setLinkOffStandard(saveData.getCompound("Off_standard_Link"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnReason, @Nullable SpawnGroupData livingEntityData, @Nullable CompoundTag CompoundTag) {
        this.setOffAppmonMainStandardPower(-1);
        this.setOffAppmonMainStandardName("null");
        this.setOffAppmonMainStandardHealth(-1);
        this.setOffAppmonMainStandardVer(-1);

        this.setOffAppmonOffStandardPower(-1);
        this.setOffAppmonOffStandardName("null");
        this.setOffAppmonOffStandardHealth(-1);
        this.setOffAppmonOffStandardVer(-1);

        this.setAppmonMainSuperPower(-1);
        this.setAppmonMainSuperName("null");
        this.setAppmonMainSuperHealth(-1);
        this.setAppmonMainSuperVer(-1);

        this.setAppmonOffSuperPower(-1);
        this.setAppmonOffSuperName("null");
        this.setAppmonOffSuperHealth(-1);
        this.setAppmonOffSuperVer(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, CompoundTag);
    }

    public CompoundTag getAppSuper() {
        return this.getEntityData().get(SUPER_FROM);
    }

    public void setAppSuper(CompoundTag tag) {
        this.getEntityData().set(SUPER_FROM, tag);
    }

    public CompoundTag getOffStandard() {
        return this.getEntityData().get(OFF_STANDARD_FROM);
    }

    public void setOffStandard(CompoundTag tag) {
        this.getEntityData().set(OFF_STANDARD_FROM, tag);
    }
    public CompoundTag getLinkSuper() {
        return this.getEntityData().get(SUPER_LINK_DATA);
    }

    public void setLinkSuper(CompoundTag tag) {
        this.getEntityData().set(SUPER_LINK_DATA, tag);
    }

    public CompoundTag getLinkOffStandard() {
        return this.getEntityData().get(OFF_STANDARD_LINK_DATA);
    }

    public void setLinkOffStandard(CompoundTag tag) {
        this.getEntityData().set(OFF_STANDARD_LINK_DATA, tag);
    }

    public int getOffAppmonMainStandardPower() {return this.getOffStandard().getInt("standard_main_obj_power");}

    public void setOffAppmonMainStandardPower(int power) {this.getOffStandard().putInt("standard_main_obj_power", power);}

    public String getOffAppmonMainStandardName() {return this.getOffStandard().getString("standard_main_obj_name");}

    public void setOffAppmonMainStandardName(String name) {this.getOffStandard().putString("standard_main_obj_name", name);}

    public float getOffAppmonMainStandardHealth() {return this.getOffStandard().getFloat("standard_main_obj_health");}

    public void setOffAppmonMainStandardHealth(float health) {this.getOffStandard().putFloat("standard_main_obj_health", health);}
    public int getOffAppmonMainStandardVer() {return this.getOffStandard().getInt("standard_main_obj_ver");}

    public void setOffAppmonMainStandardVer(int ver) {this.getOffStandard().putInt("standard_main_obj_ver", ver);}

    public int getOffAppmonOffStandardPower() {return this.getOffStandard().getInt("standard_off_obj_power");}

    public void setOffAppmonOffStandardPower(int power) {this.getOffStandard().putInt("standard_off_obj_power", power);}

    public String getOffAppmonOffStandardName() {return this.getOffStandard().getString("standard_off_obj_name");}

    public void setOffAppmonOffStandardName(String name) {this.getOffStandard().putString("standard_off_obj_name", name);}

    public float getOffAppmonOffStandardHealth() {return this.getOffStandard().getFloat("standard_off_obj_health");}

    public void setOffAppmonOffStandardHealth(float health) {this.getOffStandard().putFloat("standard_off_obj_health", health);}
    public int getOffAppmonnOffStandardVer() {return this.getOffStandard().getInt("standard_off_obj_ver");}

    public void setOffAppmonOffStandardVer(int ver) {this.getOffStandard().putInt("standard_off_obj_ver", ver);}

    public int getAppmonMainSuperPower() {return this.getAppSuper().getInt("super_main_obj_power");}

    public void setAppmonMainSuperPower(int power) {this.getAppSuper().putInt("super_main_obj_power", power);}

    public String getAppmonMainSuperName() {return this.getAppSuper().getString("super_main_obj_name");}

    public void setAppmonMainSuperName(String name) {this.getAppSuper().putString("super_main_obj_name", name);}

    public float getAppmonMainSuperHealth() {return this.getAppSuper().getFloat("super_main_obj_health");}

    public void setAppmonMainSuperHealth(float health) {this.getAppSuper().putFloat("super_main_obj_health", health);}
    public int getAppmonMainSuperVer() {return this.getAppSuper().getInt("super_main_obj_ver");}

    public void setAppmonMainSuperVer(int ver) {this.getAppSuper().putInt("super_main_obj_ver", ver);}

    public int getAppmonOffSuperPower() {return this.getAppSuper().getInt("super_off_obj_power");}

    public void setAppmonOffSuperPower(int power) {this.getAppSuper().putInt("super_off_obj_power", power);}

    public String getAppmonOffSuperName() {return this.getAppSuper().getString("super_off_obj_name");}

    public void setAppmonOffSuperName(String name) {this.getAppSuper().putString("super_off_obj_name", name);}

    public float getAppmonOffSuperHealth() {return this.getAppSuper().getFloat("super_off_obj_health");}

    public void setAppmonOffSuperHealth(float health) {this.getAppSuper().putFloat("super_off_obj_health", health);}
    public int getAppmonOffSuperVer() {return this.getAppSuper().getInt("super_off_obj_ver");}

    public void setAppmonOffSuperVer(int ver) {this.getAppSuper().putInt("super_off_obj_ver", ver);}
}
