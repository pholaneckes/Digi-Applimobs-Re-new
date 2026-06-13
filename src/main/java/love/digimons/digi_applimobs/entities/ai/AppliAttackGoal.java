package love.digimons.digi_applimobs.entities.ai;

import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;

public class AppliAttackGoal extends MeleeAttackGoal {

    protected final AppliEntity theApplimob;
    private final double speedModifier;

    private final boolean followingTargetEvenIfNotSeen;

    private final int toDoAtt;

    private int ticksUntilNextAttack;
    private int ticksUntilNextPathRecalculation;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;

    public AppliAttackGoal(AppliEntity creature, double speedIn, boolean useLongMemory, int doAtt) {
        super(creature, speedIn, useLongMemory);
        this.theApplimob = creature;
        this.speedModifier =speedIn;
        this.followingTargetEvenIfNotSeen = useLongMemory;
        this.toDoAtt = doAtt;
    }

    @Override
    public boolean canUse() {
        return super.canUse();
    }


    @Override
    public boolean canContinueToUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) {
    
            return false;
        } else if (!livingentity.isAlive()) {
    
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
    
            return !this.mob.getNavigation().isDone();
        } else if (!this.mob.isWithinRestriction(livingentity.blockPosition())) {
    
            return false;
        } else {
    
            return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
        }
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        this.mob.setAggressive(false);
        if (this.mob instanceof AppliEntity) {
            ((AppliEntity) this.mob).setAppmonAtt(0);
        }
        this.ticksUntilNextAttack = 0;
    }

    @Override
    public void tick() {
        LivingEntity livingentity = this.mob.getTarget();
        this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
        double d0 = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
        this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
        if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight((livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F))) {
            this.pathedTargetX = livingentity.getX();
            this.pathedTargetY = livingentity.getY();
            this.pathedTargetZ = livingentity.getZ();
            this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
            if (d0 > 1024.0D) {
                this.ticksUntilNextPathRecalculation += 10;
            } else if (d0 > 256.0D) {
                this.ticksUntilNextPathRecalculation += 5;
            }
            if (!this.mob.getNavigation().moveTo(livingentity, this.speedModifier)) {
                this.ticksUntilNextPathRecalculation += 15;
            }
        }

        this.checkAndPerformAttack(livingentity, d0);
        this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        if(this.mob instanceof TamableAnimal) {
            if (!((TamableAnimal) this.mob).isTame()) {
                this.checkForTypeOfAttack(livingentity, d0);
            } else {
                this.checkAndPerformAttack(livingentity, d0);
            }
        }
        
    }

    protected void checkForTypeOfAttack(LivingEntity livingentity, double squaredDistance) {
        if (livingentity instanceof AppliEntity && !Objects.equals(AppliSetup.AppmonTypes.valueOf(AppmonNameTools.getRegAppliEntiNameWithoutModId((AppliEntity) livingentity)).getTechniques(), "") && Mth.nextInt(livingentity.getRandom(),0, 35) == 1) {
            this.checkAndPerformTechniquesAttack(livingentity, squaredDistance);
        }else {
            this.checkAndPerformAttack(livingentity, squaredDistance);
        }
    }

    protected void checkAndPerformAttack(LivingEntity livingentity, double squaredDistance) {
        double d0 = this.getAttackReachSqr(livingentity);
        if (squaredDistance <= d0 && this.ticksUntilNextAttack <= 0 && this.mob instanceof AppliEntity) {
            this.resetAttackCooldown(livingentity);
            ((AppliEntity) this.mob).setAppmonAtt(this.toDoAtt);
            this.mob.doHurtTarget(livingentity);
        }
    }

    protected void checkAndPerformTechniquesAttack(LivingEntity livingentity, double squaredDistance) {
        double d0 = this.getAttackReachSqr(livingentity);
        if (squaredDistance <= d0 && this.ticksUntilNextAttack <= 0 && this.mob instanceof AppliEntity) {
            this.resetAttackCooldownTechnique();
            ((AppliEntity) this.mob).setAppmonAtt(this.toDoAtt);
            ((AppliEntity) this.mob).doTechniques();
        }
    }

    protected void resetAttackCooldown(LivingEntity livingentity) {
        if (!(livingentity instanceof AppliEntity)) {
            this.ticksUntilNextAttack = 20;
        } else {
            this.ticksUntilNextAttack = 1;
        }
    }

    protected void resetAttackCooldownTechnique() {
        this.ticksUntilNextAttack = 1;
    }

    @Override
    protected int getTicksUntilNextAttack() {
        return super.getTicksUntilNextAttack();
    }

    @Override
    protected int getAttackInterval() {
        return super.getAttackInterval();
    }

    protected double getAttackReachSqr(LivingEntity livingEntity) {
        return this.mob.getBbWidth() * this.mob.getBbWidth() * 4.0F + livingEntity.getBbWidth();
    }
}
