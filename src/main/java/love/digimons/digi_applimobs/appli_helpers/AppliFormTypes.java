package love.digimons.digi_applimobs.appli_helpers;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public class AppliFormTypes {
    public enum FormTypes implements StringRepresentable {
        STANDARD("standard", (byte) 1),
        SUPER("super", (byte) 2),
        ULTIMATE("ultimate", (byte) 3),
        GOD("god", (byte) 4),

        __("-", (byte) -1),
        Temp("temp", (byte) 0);

        private final String name;
        private final byte id;

        FormTypes(String name, byte id){
            this.name = name;
            this.id = id;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }

        public byte getId() {
            return this.id;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
