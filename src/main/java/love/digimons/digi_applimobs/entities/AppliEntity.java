package love.digimons.digi_applimobs.entities;

import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.ai.AppliAttackGoal;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import love.digimons.digi_applimobs.items.AppliDrive;
import love.digimons.digi_applimobs.network.NetworkRegHandler;
import love.digimons.digi_applimobs.network.SendPack;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
//import software.bernie.geckolib.core.animatable.GeoAnimatable;
//import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
//import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
//import software.bernie.geckolib.core.animation.AnimationState;
//import software.bernie.geckolib.core.animation.*;
//import software.bernie.geckolib.core.object.PlayState;

public class AppliEntity extends TamableAnimal /*implements GeoAnimatable*/ {
    //public AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    public boolean playWalkingAnimation = true;

    public boolean playFlyingAnimation = true;

    protected boolean canfly;

    public AppliEntity(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly) {
        super(type, worldIn);
        this.canfly = fly;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel world, @NotNull AgeableMob ageable) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(EMOTION, "normal");
        this.getEntityData().define(APPMON, new CompoundTag());
        this.getEntityData().define(ATTTYPE, 0);
        this.getEntityData().define(DATA_ATT_ID, -1);
        this.getEntityData().define(IS_APPLIDUOING, false);
        this.getEntityData().define(APPMON_HISSATUWAZA,0f);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnReason, @Nullable SpawnGroupData livingEntityData, @Nullable CompoundTag CompoundTag) {
        this.getEntityData().set(EMOTION,"normal");
        this.getEntityData().set(ATTTYPE, 0);
        this.getEntityData().set(DATA_ATT_ID, -1);
        this.getEntityData().set(IS_APPLIDUOING, false);
        this.getEntityData().set(APPMON_HISSATUWAZA, 0f);
        String name;
        name = AppmonNameTools.getRegAppliEntiNameWithoutModId(this);
        this.setAppmonPower(AppliSetup.AppmonTypes.valueOf(name).getPower());
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(Math.max(getAppmonHealth(this),getAppmonHealth(getAppmonPower(), AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId())));
        this.setHealth(getAppmonHealth(getAppmonPower(), AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId()));
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, CompoundTag);
    }

    public static final EntityDataAccessor<String> EMOTION = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<CompoundTag> APPMON = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.COMPOUND_TAG);
    public static final EntityDataAccessor<Integer> ATTTYPE = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> DATA_ATT_ID = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Boolean> IS_APPLIDUOING = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Float> APPMON_HISSATUWAZA = SynchedEntityData.defineId(AppliEntity.class, EntityDataSerializers.FLOAT);


    @Override
    public void addAdditionalSaveData(CompoundTag saveData) {
        super.addAdditionalSaveData(saveData);
        saveData.putString("emo", this.getEmotion());
        saveData.putInt("att_type", this.getAppmonAtt());
        saveData.putInt("att_to", this.getAppmonAttTo());
        saveData.putBoolean("is_used_duo", this.isDUO());
        saveData.putFloat("appmon_hissatu",this.getHissatu());
        if(!getAppmon().isEmpty()) {
            saveData.put("Appmon", this.getAppmon());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag saveData) {
        super.readAdditionalSaveData(saveData);
        this.getEntityData().set(EMOTION, saveData.getString("emo"));
        this.getEntityData().set(ATTTYPE,saveData.getInt("att_type"));
        this.getEntityData().set(DATA_ATT_ID, saveData.getInt("att_to"));
        this.getEntityData().set(IS_APPLIDUOING, saveData.getBoolean("is_used_duo"));
        this.getEntityData().set(APPMON_HISSATUWAZA, saveData.getFloat("appmon_hissatu"));
        if(saveData.contains("Appmon")){
            this.setAppmon(saveData.getCompound("Appmon"));
        }
    }


    public CompoundTag getAppmon() {
        return this.getEntityData().get(APPMON);
    }

    public void setAppmon(CompoundTag tag) {
        this.getEntityData().set(APPMON, tag);
    }

    public float getHissatu() {
        return this.getAppmon().getFloat("appmon_hissatu");
    }

    public void setHissatu(float per) {
        this.getAppmon().putFloat("appmon_hissatu", per);
    }

    public int getAppmonPower() {
        return this.getAppmon().getInt("power");
    }

    public void setAppmonPower(int power) {this.getAppmon().putInt("power", power);}

    public int getAppmonAtt() {return this.getEntityData().get(ATTTYPE);}

    public void setAppmonAtt(Integer type) {
        this.getEntityData().set(ATTTYPE, type);
    }

    public int getAppmonAttTo() {return this.getEntityData().get(DATA_ATT_ID);}

    public void setAppmonAttTo(int att) {
        this.getEntityData().set(DATA_ATT_ID, att);
    }

    public boolean isDUO() {return this.getEntityData().get(IS_APPLIDUOING);}

    public void DUOChangeTo(boolean duo) {this.getEntityData().set(IS_APPLIDUOING, duo);}

    public String getEmotion() {
        return this.getEntityData().get(EMOTION);
    }


    public void doTechniques(){
        Digi_Applimobs.LOGGER.debug("tec");
    }


    public void tameAppli(Player player) {
        this.setTame(true);
        this.setOwnerUUID(player.getUUID());
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.TAME_ANIMAL.trigger((ServerPlayer)player, this);
        }

    }

//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if (event.isMoving() && playFlyingAnimation && canfly) {
//            event.getController().setAnimation(RawAnimation.begin().then("flying", Animation.LoopType.LOOP));
//            return PlayState.CONTINUE;
//        }else if(event.isMoving() && playWalkingAnimation){
//            event.getController().setAnimation(RawAnimation.begin().then("walking", Animation.LoopType.LOOP));
//
//            return PlayState.CONTINUE;
//        } else {
//            event.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
//            return PlayState.CONTINUE;
//        }
//    }
//
//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
//        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
//    }


    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0,new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(5,new FollowOwnerGoal(this, 1.6, 6.5F, 2.5F, canfly));
        if(!this.isTame()) {
            this.goalSelector.addGoal(4,new AppliAttackGoal(this,1.0, true,0));
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
            this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
        }else{
            Player player = (Player) this.getOwner();
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
            capability.ifPresent((cpd)->{
                float appliDenSNR = cpd.getDenSNR();
                if(appliDenSNR >= 35){
                    this.goalSelector.addGoal(4,new AppliAttackGoal(this,1.0, true,0));
                    this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
                    this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
                    this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
                }else if(Mth.nextInt(this.random,0,2)==1){
                    this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
                }
            });
        }

        if(!isTame()){
            this.goalSelector.addGoal(4, new RandomStrollGoal(this,0.8));
            if(isInWater()){
                this.goalSelector.addGoal(3, new RandomSwimmingGoal(this,0.7,5));
            }
            if(canfly){
                this.goalSelector.addGoal(4,new WaterAvoidingRandomFlyingGoal(this,0.9));
            }
        }else {
            this.goalSelector.addGoal(4, new RandomStrollGoal(this,0.3));
            if(isInWater()){
                this.goalSelector.addGoal(3, new RandomSwimmingGoal(this,0.25,3));
            }
            if(canfly){
                this.goalSelector.addGoal(4,new WaterAvoidingRandomFlyingGoal(this,0.4));
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level().isClientSide && getAppmonAttTo() > 0 && getTarget() == null){
            setAppmonAttTo(0);
        }
        /*
        try {
            if(this.getHealth() > getAppmonHealth(this)){
                this.setHealth(getAppmonHealth(this));
            }
        } catch (NotAppmonException e) {
            throw new RuntimeException(e);
        }
        */
        if(this.level().isClientSide() && this.isTame() && AppliDrive.appmon!=null && AppliDrive.appmon.equals(this) && getHissatu() < 100.25f) {
            setHissatu(getHissatu() + Mth.nextFloat(this.random, 0, 0.2f));
            //Digi_Applimobs.LOGGER.info(this.getName().getString() +" ： "+ getHissatu());
            if(getHissatu() > 100f){
                NetworkRegHandler.CHANNEL.sendToServer(new SendPack(Minecraft.getInstance().player.getUUID(), this.getId() , this.getHissatu(),(short) 103));
                setHissatu(100.3f);
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 10000.0F);
    }

    public static int getAppmonHealth(int power, byte type){
        int health = 30;
        if(type == 1){
            health += (int) (Math.ceil(power/25.0) + Math.ceil(power/225.0));
        }else if(type == 2){
            health += Math.ceil(power/225.0) + 75;
        }else if (type == 3){
            health += Math.ceil(power/225.0) + 135;
        }else if (type == 4){
            health += Math.ceil(power/225.0) + 245;
        }else if (type == 0){
            health = 44;
        }else if (type == -1){
            health += Math.ceil(power/207.0);
        }
        return health;
    }

    public static int getAppmonHealth(AppliEntity appliEntity) {
        int power = appliEntity.getAppmonPower();
        byte type = AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId(appliEntity)).getFormTypes().getId();
        return getAppmonHealth(power,type);
    }

//    @Override
//    public AnimatableInstanceCache getAnimatableInstanceCache() {
//        return this.factory;
//    }
//
//    @Override
//    public double getTick(Object o) {
//        return ((Entity)o).tickCount;
//    }
}
