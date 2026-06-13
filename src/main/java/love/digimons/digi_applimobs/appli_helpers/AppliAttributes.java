package love.digimons.digi_applimobs.appli_helpers;

import love.digimons.digi_applimobs.effects.EffectReg;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.effect.MobEffect;
import org.jetbrains.annotations.NotNull;

public class AppliAttributes {
    public enum Attributes implements StringRepresentable {
        SOCIAL("social",(byte) 0, "blue", EffectReg.socDef.get(), EffectReg.socProv.get(), EffectReg.socCoward.get(), EffectReg.socWeak.get()),
        NAVI("navi",(byte) 1,"green", EffectReg.naviDef.get(), EffectReg.naviProv.get(), EffectReg.naviCoward.get(), EffectReg.naviWeak.get()),
        GAME("game",(byte) 2,"orange", EffectReg.gameDef.get(), EffectReg.gameProv.get(), EffectReg.gameCoward.get(), EffectReg.gameWeak.get()),
        ENTERTAINMENT("entertainment",(byte) 3,"red", EffectReg.entaDef.get(), EffectReg.entaProv.get(), EffectReg.entaCoward.get(), EffectReg.entaWeak.get()),
        LIFE("life",(byte) 4,"pink", EffectReg.lifeDef.get(), EffectReg.lifeProv.get(), EffectReg.lifeCoward.get(), EffectReg.lifeWeak.get()),
        TOOL("tool",(byte) 5,"purple", EffectReg.toolDef.get(), EffectReg.toolProv.get(), EffectReg.toolCoward.get(), EffectReg.toolWeak.get()),
        SYSTEM("system",(byte) 6,"yellow", EffectReg.sysDef.get(), EffectReg.sysProv.get(), EffectReg.sysCoward.get(), EffectReg.sysWeak.get()),
        GOD("god",(byte) 7,"rainbow", EffectReg.appmonDef.get(), EffectReg.appmonProv.get(), EffectReg.appmonCoward.get(), EffectReg.appmonWeak.get()),
        OTHER("",(byte) 8,"black", EffectReg.appmonDef.get(), EffectReg.appmonProv.get(), EffectReg.appmonCoward.get(), EffectReg.appmonWeak.get()),
        THREE_WARU("changable",(byte) 9,"white", EffectReg.appmonDef.get(), EffectReg.appmonProv.get(), EffectReg.appmonCoward.get(), EffectReg.appmonWeak.get());

        private final String name;
        private final byte id;

        private final String color;
        private final MobEffect def;
        private final MobEffect prov;
        private final MobEffect coward;
        private final MobEffect weak;

        Attributes(String name, byte id, String color, MobEffect def, MobEffect prov, MobEffect coward, MobEffect weak){
            this.name = name;
            this.id = id;
            this.color = color;
            this.def = def;
            this.prov = prov;
            this.coward = coward;
            this.weak = weak;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public byte getId() {
            return this.id;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }

        public String getColor() {
            return color;
        }

        public MobEffect getDef() {
            return def;
        }

        public MobEffect getProv() {
            return prov;
        }

        public MobEffect getCoward() {
            return coward;
        }

        public MobEffect getWeak() {
            return weak;
        }
    }
}
