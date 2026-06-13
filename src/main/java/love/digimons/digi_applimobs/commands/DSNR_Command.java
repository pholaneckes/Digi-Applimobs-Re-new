package love.digimons.digi_applimobs.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import love.digimons.digi_applimobs.Digi_Applimobs;
import love.digimons.digi_applimobs.event.CapTb;
import love.digimons.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import love.digimons.digi_applimobs.util.varia.DenShiNouRyokuProcider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DSNR_Command {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("dsnrto")
            .requires((req)->req.hasPermission(2))
            .then(Commands.literal("add")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .executes(arg -> {
            Entity entity = arg.getSource().getEntity();
                if (entity instanceof Player) {
                    add(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"), (Player) entity);
                }
                return 0;
        })))
            .then(Commands.literal("take")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .executes(arg -> {
                Entity entity = arg.getSource().getEntity();
                if (entity instanceof Player) {
                    take(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"), (Player) entity);
                }
                return 0;

        })))
            .then(Commands.literal("player")
            .then(Commands.literal("take")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg ->{
                Player player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                take(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"),player);
                bal(player);
                return 0;
            }))
            ))
            .then(Commands.literal("add")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg ->{
                Player player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                add(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"),player);
                bal(player);
                return 0;
            }))
            ))
            .then(Commands.literal("bal")
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg->{
                Entity entity = arg.getSource().getEntity();
                Player player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                bal(player,(Player) entity);
                return 0;
            }))
            ))
    );
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("dsnr")
                .then(Commands.literal("bal").executes(arg->{
                    Entity entity = arg.getSource().getEntity();
                    if (entity instanceof Player) {
                        bal((Player) entity);
                    }
                    return 0;
                })));
}

    public static void add(float val, Player player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            cpb.setDenSNR(cpb.getDenSNR()+val);
            CapTb.serverDSNRPackSend(player,cpb);
        });
    }

    public static void take(float val, Player player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            cpb.setDenSNR(cpb.getDenSNR()-val);
            CapTb.serverDSNRPackSend(player,cpb);
        });
    }

    public static void bal(Player player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            Digi_Applimobs.LOGGER.info(cpb.getDenSNR());
            player.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.o").getString()+Component.translatable("color.e").getString()+player.getName().getString() + "' "+Component.translatable("color.r").getString() + Component.translatable("dga.msg.show.dsnr").getString()+ cpb.getDenSNR()));
        });
    }

    public static void bal(Player player, Player sendFor){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(DenShiNouRyokuProcider.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            Digi_Applimobs.LOGGER.info(cpb.getDenSNR());
            sendFor.sendSystemMessage(Component.nullToEmpty(Component.translatable("color.o").getString()+Component.translatable("color.e").getString()+player.getName().getString() + "' "+Component.translatable("color.r").getString() + Component.translatable("dga.msg.show.dsnr").getString()+ cpb.getDenSNR()));
        });
    }
}
