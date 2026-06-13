package love.digimons.digi_applimobs.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import love.digimons.digi_applimobs.appli_helpers.AppliCNSupports;
import love.digimons.digi_applimobs.appli_helpers.AppliSetup;
import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.models.AppmonNameTools;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

@Mod.EventBusSubscriber
public class AppliInfoCommand {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("applinfo")
            .then(Commands.literal("attribute")
                .then(Commands.argument("appmon", StringArgumentType.string())
                    .executes(arg -> {
                        String target = StringArgumentType.getString(arg.copyFor(arg.getSource()), "appmon");
                        sendMsg(arg.getSource().getPlayerOrException(), target,"attribute");
                        return 0;
                    }))
                .then(Commands.literal("entity")
                .then(Commands.argument("appliEntity", EntityArgument.entity())
                        .executes(arg ->{
                            Entity targetEntity = EntityArgument.getEntity(arg.copyFor(arg.getSource()),"appliEntity");
                            if(targetEntity instanceof AppliEntity){
                                String str = AppmonNameTools.getAppmonName((AppliEntity) targetEntity);
                                String target = str.replaceAll("entity.digi_applimobs","");
                                sendMsg(arg.getSource().getPlayerOrException(), target,"attribute");
                            }
                            return 0;
                        })))
            )
            .then(Commands.literal("form")
                    .then(Commands.argument("appmon", StringArgumentType.string())
                            .executes(arg -> {
                                String target = StringArgumentType.getString(arg.copyFor(arg.getSource()), "appmon");
                                sendMsg(arg.getSource().getPlayerOrException(), target,"form");
                                return 0;
                            }))
                    .then(Commands.literal("entity")
                    .then(Commands.argument("appliEntity", EntityArgument.entity())
                            .executes(arg ->{
                                Entity targetEntity = EntityArgument.getEntity(arg.copyFor(arg.getSource()),"appliEntity");
                                if(targetEntity instanceof AppliEntity){
                                    String str = AppmonNameTools.getAppmonName((AppliEntity) targetEntity);
                                    String target = str.replaceAll("entity.digi_applimobs","");
                                    sendMsg(arg.getSource().getPlayerOrException(), target,"form");
                                }
                                return 0;
                            })))
            )

            .then(Commands.literal("app")
                    .then(Commands.argument("appmon", StringArgumentType.string())
                            .executes(arg -> {
                                String target = StringArgumentType.getString(arg.copyFor(arg.getSource()), "appmon");
                                sendMsg(arg.getSource().getPlayerOrException(), target,"application");
                                return 0;
                            }))
                    .then(Commands.literal("entity")
                    .then(Commands.argument("appliEntity", EntityArgument.entity())
                            .executes(arg ->{
                                Entity targetEntity = EntityArgument.getEntity(arg.copyFor(arg.getSource()),"appliEntity");
                                if(targetEntity instanceof AppliEntity){
                                    String str = AppmonNameTools.getAppmonName((AppliEntity) targetEntity);
                                    String target = str.replaceAll("entity.digi_applimobs","");
                                    sendMsg(arg.getSource().getPlayerOrException(), target,"application");
                                }
                                return 0;
                            })))
            )

            .then(Commands.literal("power")
                    .then(Commands.argument("appmon", StringArgumentType.string())
                            .executes(arg -> {
                                String target = StringArgumentType.getString(arg.copyFor(arg.getSource()), "appmon");
                                sendMsg(arg.getSource().getPlayerOrException(), target,"power");
                                return 0;
                            }))
                    .then(Commands.literal("entity")
                    .then(Commands.argument("appliEntity", EntityArgument.entity())
                            .executes(arg ->{
                                Entity targetEntity = EntityArgument.getEntity(arg.copyFor(arg.getSource()),"appliEntity");
                                if(targetEntity instanceof AppliEntity){
                                    String str = AppmonNameTools.getAppmonName((AppliEntity) targetEntity);
                                    String target = str.replaceAll("entity.digi_applimobs","");
                                    sendMsg(arg.getSource().getPlayerOrException(), target,"power");
                                }
                                return 0;
                            })))
            )
        );
    }

    public static void sendMsg(Player player, String typeIn, String doType) {
        String msg = null;
        if (isEnglish(typeIn)) {
            String enableMon = typeIn.toUpperCase().replaceAll("MON","MOB");
            if(!enableMon.endsWith("MOB")){
                enableMon = enableMon+"MOB";
            }
            if(ArrayUtils.contains(AppliSetup.appmonList,enableMon)) {
                if (Objects.equals(doType, "attribute")) {
                    msg = Component.translatable("dga.attributes." + AppliSetup.AppmonTypes.valueOf(enableMon).getAttributes().toString().toLowerCase()).getString();
                }
                if (Objects.equals(doType, "form")) {
                    msg = Component.translatable("dga.forms." + AppliSetup.AppmonTypes.valueOf(enableMon).getFormTypes().toString().toLowerCase()).getString();
                }
                if (Objects.equals(doType, "application")) {
                    msg = AppliSetup.AppmonTypes.valueOf(enableMon).getApplication();
                }
                if (Objects.equals(doType, "power")) {
                    msg = Integer.toString(AppliSetup.AppmonTypes.valueOf(enableMon).getPower());
                }
                assert msg != null;
                player.sendSystemMessage(Component.translatable(msg));
            }else {player.sendSystemMessage(Component.translatable("dga.msg.appli.notfound"));}
        } else if (ArrayUtils.contains(AppliCNSupports.INCNS,stringToUnicode(typeIn))) {
            String cns = AppliCNSupports.CNS.valueOf(stringToUnicode(typeIn)).getSerializedName();
            if(Objects.equals(doType, "attribute")){
                msg = Component.translatable("dga.attributes." + AppliSetup.AppmonTypes.valueOf(cns.toUpperCase()).getAttributes().toString().toLowerCase()).getString();
            }
            if(Objects.equals(doType, "form")){
                msg = Component.translatable("dga.forms." + AppliSetup.AppmonTypes.valueOf(cns.toUpperCase()).getFormTypes().toString().toLowerCase()).getString();
            }
            if(Objects.equals(doType, "application")){
                msg = AppliSetup.AppmonTypes.valueOf(cns.toUpperCase()).getApplication();
            }
            if(Objects.equals(doType, "power")){
                msg = Integer.toString(AppliSetup.AppmonTypes.valueOf(cns.toUpperCase()).getPower());
            }
            assert msg != null;
            player.sendSystemMessage(Component.translatable(msg));
        } else {
            player.sendSystemMessage(Component.translatable("dga.msg.appli.unknown"));
        }
    }

    public static String stringToUnicode(String str) {
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        for (char value : c) {
            sb.append(Integer.toHexString(value));
        }
        return "CN_" + sb.toString().toUpperCase();
    }

    public static String stringToUnicode(String str, boolean b) {
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        for (char value : c) {
            sb.append(Integer.toHexString(value));
        }
        //System.out.println(b?sb.toString().toUpperCase():null);
        return sb.toString().toUpperCase();
    }


    public static boolean isEnglish(String str) {
        byte[] bytes = str.getBytes();
        int stringByteLength = bytes.length;
        int stringLength = str.length();
        return stringByteLength == stringLength;
    }
}
