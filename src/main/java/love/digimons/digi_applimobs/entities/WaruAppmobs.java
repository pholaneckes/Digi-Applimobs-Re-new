package love.digimons.digi_applimobs.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class WaruAppmobs extends StandardApplimob{
    public WaruAppmobs(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnReason, @Nullable SpawnGroupData livingEntityData, @Nullable CompoundTag CompoundTag) {
        this.setWaruType((byte) Mth.nextInt(this.random,0,6));
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, CompoundTag);
    }

    public byte getWaruType() {
        return this.getAppmon().getByte("waru_type");
    }

    public void setWaruType(byte waru_type) {
        this.getAppmon().putByte("waru_type", waru_type);
    }
}
