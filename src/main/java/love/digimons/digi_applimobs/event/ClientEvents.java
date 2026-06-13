package love.digimons.digi_applimobs.event;

import love.digimons.digi_applimobs.entities.EntiReg;
import love.digimons.digi_applimobs.entities.render.AppliObjRender;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEvents {



    @SubscribeEvent
    public static void onClientSetupEvent(EntityRenderersEvent.RegisterRenderers event) {
        //添加渲染注册语句
        event.registerEntityRenderer(EntiReg.naviMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "navimob"));
        event.registerEntityRenderer(EntiReg.gatchMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gatchmob"));
        event.registerEntityRenderer(EntiReg.dogatchMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dogatchmob"));
//        event.registerEntityRenderer(EntiReg.woody.get(), AppliRender::new);
        event.registerEntityRenderer(EntiReg.tapMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager,"tapmob"));
        event.registerEntityRenderer(EntiReg.onMOB.get(),  (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "onmob"));

        event.registerEntityRenderer(EntiReg.callMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "callmob"));
        event.registerEntityRenderer(EntiReg.mailMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "mailmob"));
        event.registerEntityRenderer(EntiReg.tubuMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "tubumob"));
        event.registerEntityRenderer(EntiReg.gengoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gengomob"));
        event.registerEntityRenderer(EntiReg.addMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "addmob"));
        event.registerEntityRenderer(EntiReg.reviewMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "reviewmob"));
        event.registerEntityRenderer(EntiReg.setMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "setmob"));
        event.registerEntityRenderer(EntiReg.messeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "messemob"));
        event.registerEntityRenderer(EntiReg.rocketMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "rocketmob"));
        event.registerEntityRenderer(EntiReg.jetMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "jetmob"));
        event.registerEntityRenderer(EntiReg.weatherMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "weathermob"));
        event.registerEntityRenderer(EntiReg.compassMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "compassmob"));
        event.registerEntityRenderer(EntiReg.yadoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "yadomob"));
        event.registerEntityRenderer(EntiReg.newsMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "newsmob"));
        event.registerEntityRenderer(EntiReg.protecMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "protecmob"));
        event.registerEntityRenderer(EntiReg.hackMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "hackmob"));
        event.registerEntityRenderer(EntiReg.batteriMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "batterimob"));
        event.registerEntityRenderer(EntiReg.pekoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "pekomob"));
        event.registerEntityRenderer(EntiReg.pokoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "pokomob"));
        event.registerEntityRenderer(EntiReg.copipeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "copipemob"));
        event.registerEntityRenderer(EntiReg.saveMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "savemob"));
        event.registerEntityRenderer(EntiReg.kabeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "kabemob"));
        event.registerEntityRenderer(EntiReg.ecoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "ecomob"));
        event.registerEntityRenderer(EntiReg.pipoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "pipomob"));
        event.registerEntityRenderer(EntiReg.drawMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "drawmob"));
        event.registerEntityRenderer(EntiReg.tellerMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "tellermob"));
        event.registerEntityRenderer(EntiReg.musiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "musimob"));
        event.registerEntityRenderer(EntiReg.peroriMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "perorimob"));
        event.registerEntityRenderer(EntiReg.dressMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dressmob"));
        event.registerEntityRenderer(EntiReg.bookMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "bookmob"));
        event.registerEntityRenderer(EntiReg.gashaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gashamob"));
        event.registerEntityRenderer(EntiReg.luckMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "luckmob"));
        event.registerEntityRenderer(EntiReg.trickMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "trickmob"));
        event.registerEntityRenderer(EntiReg.diceMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dicemob"));
        event.registerEntityRenderer(EntiReg.cookMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "cookmob"));
        event.registerEntityRenderer(EntiReg.sleepMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "sleepmob"));
        event.registerEntityRenderer(EntiReg.muscleMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "musclemob"));
        event.registerEntityRenderer(EntiReg.aidMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "aidmob"));
        event.registerEntityRenderer(EntiReg.moneyMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "moneymob"));
        event.registerEntityRenderer(EntiReg.spaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "spamob"));
        event.registerEntityRenderer(EntiReg.suppleMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "supplemob"));
        event.registerEntityRenderer(EntiReg.dopeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dopemob"));
        event.registerEntityRenderer(EntiReg.auctioMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "auctiomob"));
        event.registerEntityRenderer(EntiReg.kakeiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "kakeimob"));
        event.registerEntityRenderer(EntiReg.kaiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "kaimob"));
        event.registerEntityRenderer(EntiReg.jishoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "jishomob"));
        event.registerEntityRenderer(EntiReg.cameraMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "cameramob"));
        event.registerEntityRenderer(EntiReg.recoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "recomob"));
        event.registerEntityRenderer(EntiReg.calcuMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "calcumob"));
        event.registerEntityRenderer(EntiReg.gomiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gomimob"));
        event.registerEntityRenderer(EntiReg.mirrorMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "mirrormob"));
        event.registerEntityRenderer(EntiReg.lightMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "lightmob"));
        event.registerEntityRenderer(EntiReg.watchMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "watchmob"));
        event.registerEntityRenderer(EntiReg.diariMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "diarimob"));
        event.registerEntityRenderer(EntiReg.calendaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "calendamob"));
        event.registerEntityRenderer(EntiReg.onpaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "onpamob"));
        event.registerEntityRenderer(EntiReg.dokaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dokamob"));
        event.registerEntityRenderer(EntiReg.shotMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "shotmob"));
        event.registerEntityRenderer(EntiReg.cardMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "cardmob"));
        event.registerEntityRenderer(EntiReg.ropureMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "ropuremob"));
        event.registerEntityRenderer(EntiReg.puzzleMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "puzzlemob"));
        event.registerEntityRenderer(EntiReg.danceMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dancemob"));
        event.registerEntityRenderer(EntiReg.raceMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "racemob"));
        event.registerEntityRenderer(EntiReg.sociaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "sociamob"));
        event.registerEntityRenderer(EntiReg.gossipMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gossipmob"));
        event.registerEntityRenderer(EntiReg.sukasiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "sukasimob"));
        event.registerEntityRenderer(EntiReg.tripMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "tripmob"));
        event.registerEntityRenderer(EntiReg.raidraMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "raidramob"));
        event.registerEntityRenderer(EntiReg.dezipMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dezipmob"));
        event.registerEntityRenderer(EntiReg.mienuMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "mienumob"));
        event.registerEntityRenderer(EntiReg.warpMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "warpmob"));
        event.registerEntityRenderer(EntiReg.effecMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "effecmob"));
        event.registerEntityRenderer(EntiReg.tarotMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "tarotmob"));
        event.registerEntityRenderer(EntiReg.coordeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "coordemob"));
        event.registerEntityRenderer(EntiReg.mediaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "mediamob"));
        event.registerEntityRenderer(EntiReg.vegasMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "vegasmob"));
        event.registerEntityRenderer(EntiReg.dreamMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dreammob"));
        event.registerEntityRenderer(EntiReg.medicMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "medicmob"));
        event.registerEntityRenderer(EntiReg.docMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "docmob"));
        event.registerEntityRenderer(EntiReg.consulMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "consulmob"));
        event.registerEntityRenderer(EntiReg.libraMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "libramob"));
        event.registerEntityRenderer(EntiReg.timeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "timemob"));
        event.registerEntityRenderer(EntiReg.roaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "roamob"));
        event.registerEntityRenderer(EntiReg.scorpMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "scorpmob"));
        event.registerEntityRenderer(EntiReg.craftMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "craftmob"));
        event.registerEntityRenderer(EntiReg.dosukoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dosukomob"));
        event.registerEntityRenderer(EntiReg.braMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "bramob"));
        event.registerEntityRenderer(EntiReg.coachMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "coachmob"));
        event.registerEntityRenderer(EntiReg.globeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "globemob"));
        event.registerEntityRenderer(EntiReg.charisMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "charismob"));
        event.registerEntityRenderer(EntiReg.damedaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "damedamob"));
        event.registerEntityRenderer(EntiReg.cometMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "cometmob"));
        event.registerEntityRenderer(EntiReg.reviveMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "revivemob"));
        event.registerEntityRenderer(EntiReg.warudaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "warudamob"));
        event.registerEntityRenderer(EntiReg.enterMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "entermob"));
        event.registerEntityRenderer(EntiReg.bioMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "biomob"));
        event.registerEntityRenderer(EntiReg.beautyMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "beautymob"));
        event.registerEntityRenderer(EntiReg.fakeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "fakemob"));
        event.registerEntityRenderer(EntiReg.gaiaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "gaiamob"));
        event.registerEntityRenderer(EntiReg.hadesMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "hadesmob"));
        event.registerEntityRenderer(EntiReg.poseidoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "poseidomob"));
        event.registerEntityRenderer(EntiReg.kosoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "kosomob"));
        event.registerEntityRenderer(EntiReg.tutoMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "tutomob"));
        event.registerEntityRenderer(EntiReg.denpaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "denpamob"));
        event.registerEntityRenderer(EntiReg.jammingMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "jammingmob"));

        event.registerEntityRenderer(EntiReg.offMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "offmob"));
        event.registerEntityRenderer(EntiReg.logiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "logimob"));
        event.registerEntityRenderer(EntiReg.bootMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "bootmob"));
        event.registerEntityRenderer(EntiReg.shutMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "shutmob"));
        event.registerEntityRenderer(EntiReg.rebootMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "rebootmob"));
        event.registerEntityRenderer(EntiReg.jumpplusMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.guguMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.flickMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "flickmob"));
        event.registerEntityRenderer(EntiReg.danteMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.deusuMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "deusumob"));
        event.registerEntityRenderer(EntiReg.dogaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "dogamob"));
        event.registerEntityRenderer(EntiReg.logaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "logamob"));
        event.registerEntityRenderer(EntiReg.mcMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "mcmob"));
        event.registerEntityRenderer(EntiReg.ouranosMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "ouranosmob"));
        event.registerEntityRenderer(EntiReg.oujaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "oujamob"));
        event.registerEntityRenderer(EntiReg.resshaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "resshamob"));
        event.registerEntityRenderer(EntiReg.sakusiMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "sakusimob"));
        event.registerEntityRenderer(EntiReg.santaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.sateraMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "sateramob"));
        event.registerEntityRenderer(EntiReg.speciaMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.superMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.swipeMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "swipemob"));

        event.registerEntityRenderer(EntiReg.uratekuMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "uratekumob"));
        event.registerEntityRenderer(EntiReg.virusMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "virusmob"));
        event.registerEntityRenderer(EntiReg.vjumpMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager));
        event.registerEntityRenderer(EntiReg.weatherdraMOB.get(), (EntityRendererProvider.Context manager) -> new AppliObjRender(manager, "weatherdramob"));
    }

    /*
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event){
        event.enqueueWork(()-> {
            Minecraft mc = Minecraft.getInstance();
            EntityRendererProvider.Context manager = mc.getEntityRenderDispatcher();
            manager.register(EntiReg.gatchMOB.get(),new GatchRender_Old(manager));
        });
    }
     */
}
