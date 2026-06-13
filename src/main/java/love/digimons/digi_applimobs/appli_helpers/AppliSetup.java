package love.digimons.digi_applimobs.appli_helpers;

import love.digimons.digi_applimobs.entities.AppliEntity;
import love.digimons.digi_applimobs.entities.EntiReg;
import love.digimons.digi_applimobs.items.ItemReg;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class AppliSetup {

    public static String[] appmonList = new String[]{"GATCHMOB", "ADDMOB", "AIDMOB", "AUCTIOMOB", "BATTERIMOB", "BEAUTYMOB", "BIOMOB", "BOOKMOB", "BOOTMOB", "BRAMOB", "CALCUMOB", "CALENDAMOB", "CALLMOB", "CAMERAMOB", "CARDMOB", "CHARISMOB", "COACHMOB", "COMETMOB", "COMPASSMOB", "CONSULMOB", "COOKMOB", "COORDEMOB", "COPIPEMOB", "CRAFTMOB", "DAMEDAMOB", "DANCEMOB", "DANTEMOB", "DENPAMOB", "DEUSUMOB", "DEZIPMOB", "DIARIMOB", "DICEMOB", "DOCMOB", "DOGAMOB", "DOGATCHMOB", "DOKAMOB", "DOPEMOB", "DOSUKOMOB", "DRAWMOB", "DREAMMOB", "DRESSMOB", "ECOMOB", "EFFECMOB", "ENTERMOB", "FAKEMOB", "FLICKMOB", "GAIAMOB", "GASHAMOB", "GENGOMOB", "GLOBEMOB", "GOMIMOB", "GOSSIPMOB", "GUGUMOB", "HACKMOB", "HADESMOB", "JAMMINGMOB", "JETMOB", "JISHOMOB", "JUMPPLUSMOB", "KABEMOB", "KAIMOB", "KAKEIMOB", "KOSOMOB", "LIBRAMOB", "LIGHTMOB", "LOGAMOB", "LOGIMOB", "LUCKMOB", "MAILMOB", "MCMOB", "MEDIAMOB", "MEDICMOB", "MESSEMOB", "MIENUMOB", "MIRRORMOB", "MONEYMOB", "MUSCLEMOB", "MUSIMOB", "NAVIMOB", "NEWSMOB", "OFFMOB", "ONMOB", "ONPAMOB", "OUJAMOB", "OURANOSMOB", "PEKOMOB", "PERORIMOB", "PIPOMOB", "POKOMOB", "POSEIDOMOB", "PROTECMOB", "PUZZLEMOB", "RACEMOB", "RAIDRAMOB", "REBOOTMOB", "RECOMOB", "RESSHAMOB", "REVIEWMOB", "REVIVEMOB", "ROAMOB", "ROCKETMOB", "ROPUREMOB", "SAKUSIMOB", "SANTAMOB", "SATERAMOB", "SAVEMOB", "SCORPMOB", "SETMOB", "SHOTMOB", "SHUTMOB", "SLEEPMOB", "SOCIAMOB", "SPAMOB", "SPECIAMOB", "SUKASIMOB", "SUPERMOB", "SUPPLEMOB", "SWIPEMOB", "TAPMOB", "TAROTMOB", "TELLERMOB", "TIMEMOB", "TRICKMOB", "TRIPMOB", "TUBUMOB", "TUTOMOB", "URATEKUMOB", "VEGASMOB", "VIRUSMOB", "VJUMPMOB", "WARPMOB", "WARUDAMOB", "WATCHMOB", "WEATHERDRAMOB", "WEATHERMOB", "YADOMOB","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul"};
    public static AppmonTypes[] noModelAppmon = new AppmonTypes[]{AppmonTypes.SANTAMOB, AppmonTypes.JAMMINGMOB,AppmonTypes.GUGUMOB,AppmonTypes.VJUMPMOB,AppmonTypes.DANTEMOB,AppmonTypes.SPECIAMOB,AppmonTypes.SUPERMOB};
    public enum AppmonTypes implements StringRepresentable {
        GATCHMOB("Gatchmon", "Gatch", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 1000, "", Component.translatable("dga.text.zukan.gatchmob"), ItemReg.appliChipGatchmob.get(), EntiReg.gatchMOB.get()),
        ADDMOB("Addmon", "Address_Book", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 320, "", Component.translatable("dga.text.zukan.addmob"), ItemReg.appliChipAddmob.get(), EntiReg.addMOB.get()),
        AIDMOB("Aidmon", "Rescue", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 490, "", Component.translatable("dga.text.zukan.aidmob"), ItemReg.appliChipAidmob.get(), EntiReg.aidMOB.get()),
        AUCTIOMOB("Auctiomon", "Auction", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 130, "", Component.translatable("dga.text.zukan.auctiomob"), ItemReg.appliChipAuctiomob.get(), EntiReg.auctioMOB.get()),
        BATTERIMOB("Batterimon", "Battery", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 190, "", Component.translatable("dga.text.zukan.batterimob"), ItemReg.appliChipBatterimob.get(), EntiReg.batteriMOB.get()),
        BEAUTYMOB("Beautymon", "Beauty", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.LIFE, 45000, "", Component.translatable("dga.text.zukan.beautymob"), ItemReg.appliChipBeautymob.get(), EntiReg.beautyMOB.get()),
        BIOMOB("Biomon", "Life", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.LIFE, 70000, "", Component.translatable("dga.text.zukan.biomob"), ItemReg.appliChipBiomob.get(), EntiReg.bioMOB.get()),
        BOOKMOB("Bookmon", "eBook", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 620, "", Component.translatable("dga.text.zukan.bookmob"), ItemReg.appliChipBookmob.get(), EntiReg.bookMOB.get()),
        BOOTMOB("Bootmon", "Super_Boot", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.TOOL, 57000, "", Component.translatable("dga.text.zukan.bootmob"), ItemReg.appliChipBootmob.get(), EntiReg.bootMOB.get()),
        BRAMOB("Bramon", "Brain_Training", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 5000, "", Component.translatable("dga.text.zukan.bramob"), ItemReg.appliChipBramob.get(), EntiReg.braMOB.get()),
        CALCUMOB("Calcumon", "Calculator", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 220, "", Component.translatable("dga.text.zukan.calcumob"), ItemReg.appliChipCalcumob.get(), EntiReg.calcuMOB.get()),
        CALENDAMOB("Calendamon", "Calendar", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 170, "", Component.translatable("dga.text.zukan.calendamob"), ItemReg.appliChipCalendamob.get(), EntiReg.calendaMOB.get()),
        CALLMOB("Callmon", "Phone", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 520, "", Component.translatable("dga.text.zukan.callmob"), ItemReg.appliChipCallmob.get(), EntiReg.callMOB.get()),
        CAMERAMOB("Cameramon", "Camera", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 1200, "", Component.translatable("dga.text.zukan.cameramob"), ItemReg.appliChipCameramob.get(), EntiReg.cameraMOB.get()),
        CARDMOB("Cardmon", "Card", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 650, "", Component.translatable("dga.text.zukan.cardmob"), ItemReg.appliChipCardmob.get(), EntiReg.cardMOB.get()),
        CHARISMOB("Charismon", "Mind_Control", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.SOCIAL, 55000, "", Component.translatable("dga.text.zukan.charismob"), ItemReg.appliChipCharismob.get(), EntiReg.charisMOB.get()),
        COACHMOB("Coachmon", "Training", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 6000, "", Component.translatable("dga.text.zukan.coachmob"), ItemReg.appliChipCoachmob.get(), EntiReg.coachMOB.get()),
        COMETMOB("Cometmon", "Astrology", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.NAVI, 65000, "", Component.translatable("dga.text.zukan.cometmob"), ItemReg.appliChipCometmob.get(), EntiReg.cometMOB.get()),
        COMPASSMOB("Compassmon", "Compass", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 230, "", Component.translatable("dga.text.zukan.compassmob"), ItemReg.appliChipCompassmob.get(), EntiReg.compassMOB.get()),
        CONSULMOB("Consulmon", "Saving", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.LIFE, 6400, "", Component.translatable("dga.text.zukan.consulmob"), ItemReg.appliChipConsulmob.get(), EntiReg.consulMOB.get()),
        COOKMOB("Cookmon", "Cook", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 200, "", Component.translatable("dga.text.zukan.cookmob"), ItemReg.appliChipCookmob.get(), EntiReg.cookMOB.get()),
        COORDEMOB("Coordemon", "Coordinate", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 9600, "", Component.translatable("dga.text.zukan.coordemob"), ItemReg.appliChipCoordemob.get(), EntiReg.coordeMOB.get()),
        COPIPEMOB("Copipemon", "Copy_and_Paste", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 710, "", Component.translatable("dga.text.zukan.copipemob"), ItemReg.appliChipCopipemob.get(), EntiReg.copipeMOB.get()),
        CRAFTMOB("Craftmon", "Design", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.TOOL, 7200, "", Component.translatable("dga.text.zukan.craftmob"), ItemReg.appliChipCraftmob.get(), EntiReg.craftMOB.get()),
        DAMEDAMOB("Damedamon", "Dame_Dame", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.SOCIAL, 38000, "", Component.translatable("dga.text.zukan.damedamob"), ItemReg.appliChipDamedamob.get(), EntiReg.damedaMOB.get()),
        DANCEMOB("Dancemon", "Rhythm", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 440, "", Component.translatable("dga.text.zukan.dancemob"), ItemReg.appliChipDancemob.get(), EntiReg.danceMOB.get()),
        DANTEMOB("Dantemon", "Open", AppliFormTypes.FormTypes.__, AppliAttributes.Attributes.OTHER,77777, "", Component.translatable("dga.text.zukan.dantemob"), ItemReg.appliChipDantemob.get(), EntiReg.danteMOB.get()),
        DENPAMOB("Denpamon", "Communication", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 680, "", Component.translatable("dga.text.zukan.denpamob"), ItemReg.appliChipDenpamob.get(), EntiReg.denpaMOB.get()),
        DEUSUMOB("Deusumon", "Omnipotence", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 340000, "", Component.translatable("dga.text.zukan.deusumob"), ItemReg.appliChipDeusumob.get(), EntiReg.deusuMOB.get()),
        DEZIPMOB("Dezipmon", "Zip_or_Unzip", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SYSTEM, 10500, "", Component.translatable("dga.text.zukan.dezipmob"), ItemReg.appliChipDezipmob.get(), EntiReg.dezipMOB.get()),
        DIARIMOB("Diarimon", "Diary", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 180, "", Component.translatable("dga.text.zukan.diarimob"), ItemReg.appliChipDiarimob.get(), EntiReg.diariMOB.get()),
        DICEMOB("Dicemon", "Dice", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 120, "", Component.translatable("dga.text.zukan.dicemob"), ItemReg.appliChipDicemob.get(), EntiReg.diceMOB.get()),
        DOCMOB("Docmon", "Doctor", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.LIFE, 8800, "", Component.translatable("dga.text.zukan.docmob"), ItemReg.appliChipDocmob.get(), EntiReg.docMOB.get()),
        DOGAMOB("Dogamon", "Video", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 740, "", Component.translatable("dga.text.zukan.dogamob"), ItemReg.appliChipDogamob.get(), EntiReg.dogaMOB.get()),
        DOGATCHMOB("Dogatchmon", "Super_Search", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 7500, "", Component.translatable("dga.text.zukan.dogatchmob"), ItemReg.appliChipDogatchmob.get(), EntiReg.dogatchMOB.get()),
        DOKAMOB("Dokamon", "Action", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 900, "", Component.translatable("dga.text.zukan.dokamob"), ItemReg.appliChipDokamob.get(), EntiReg.dokaMOB.get()),
        DOPEMOB("Dopemon", "Enhancement", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 360, "", Component.translatable("dga.text.zukan.dopemob"), ItemReg.appliChipDopemob.get(), EntiReg.dopeMOB.get()),
        DOSUKOMOB("Dosukomon", "Fighting", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 11000, "", Component.translatable("dga.text.zukan.dosukomob"), ItemReg.appliChipDosukomob.get(), EntiReg.dosukoMOB.get()),
        DRAWMOB("Drawmon", "Paint", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 800, "", Component.translatable("dga.text.zukan.drawmob"), ItemReg.appliChipDrawmob.get(), EntiReg.drawMOB.get()),
        DREAMMOB("Dreammon", "Dream", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 7800, "", Component.translatable("dga.text.zukan.dreammob"), ItemReg.appliChipDreamob.get(), EntiReg.dreamMOB.get()),
        DRESSMOB("Dressmon", "Fashion", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 240, "", Component.translatable("dga.text.zukan.dressmob"), ItemReg.appliChipDressmob.get(), EntiReg.dressMOB.get()),
        ECOMOB("Ecomon", "Energy_Saving", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 100, "", Component.translatable("dga.text.zukan.ecomob"), ItemReg.appliChipEcomob.get(), EntiReg.ecoMOB.get()),
        EFFECMOB("Effecmon", "Effect", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 7000, "", Component.translatable("dga.text.zukan.effecmob"), ItemReg.appliChipEffecmob.get(), EntiReg.effecMOB.get()),
        ENTERMOB("Entermon", "Entertainment", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.ENTERTAINMENT, 42000, "", Component.translatable("dga.text.zukan.entermob"), ItemReg.appliChipEntermob.get(), EntiReg.enterMOB.get()),
        FAKEMOB("Fakemon", "Camouflage", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.TOOL, 50000, "", Component.translatable("dga.text.zukan.fakemob"), ItemReg.appliChipFakemob.get(), EntiReg.fakeMOB.get()),
        FLICKMOB("Flickmon", "Flick", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.THREE_WARU, 8, "", Component.translatable("dga.text.zukan.flickmob"), ItemReg.appliChipFlickmob.get(), EntiReg.flickMOB.get()),
        GAIAMOB("Gaiamon", "Creation", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 300000, "", Component.translatable("dga.text.zukan.gaiamob"), ItemReg.appliChipGaiamob.get(), EntiReg.gaiaMOB.get()),
        GASHAMOB("Gashamon", "Gasha", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 300, "", Component.translatable("dga.text.zukan.gashamob"), ItemReg.appliChipGashamob.get(), EntiReg.gashaMOB.get()),
        GENGOMOB("Gengomon", "Translation", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 460, "", Component.translatable("dga.text.zukan.gengomob"), ItemReg.appliChipGengomob.get(), EntiReg.gengoMOB.get()),
        GLOBEMOB("Globemon", "Global", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.SOCIAL, 60000, "", Component.translatable("dga.text.zukan.globemob"), ItemReg.appliChipGlobemob.get(), EntiReg.globeMOB.get()),
        GOMIMOB("Gomimon", "Trashbin", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 10, "", Component.translatable("dga.text.zukan.gomimob"), ItemReg.appliChipGomimob.get(), EntiReg.gomiMOB.get()),
        GOSSIPMOB("Gossipmon", "Gossip", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 4800, "", Component.translatable("dga.text.zukan.gossipmob"), ItemReg.appliChipGossipmob.get(), EntiReg.gossipMOB.get()),
        GUGUMOB("Gugumon", "Search", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 1100, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipGugumob.get(), EntiReg.guguMOB.get()),
        HACKMOB("Hackmon", "Hacking", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 1400, "", Component.translatable("dga.text.zukan.hackmob"), ItemReg.appliChipHackmob.get(), EntiReg.hackMOB.get()),
        HADESMOB("Hadesmon", "Variation", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 315000, "", Component.translatable("dga.text.zukan.hadesmob"), ItemReg.appliChipHadesmob.get(), EntiReg.hadesMOB.get()),
        JAMMINGMOB("Jammingmon", "Jamming", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 930, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipJammingmob.get(), EntiReg.jammingMOB.get()),
        JETMOB("Jetmon", "Flight", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 1100, "", Component.translatable("dga.text.zukan.jetmob"), ItemReg.appliChipJetmob.get(), EntiReg.jetMOB.get()),
        JISHOMOB("Jishomon", "Dictionary", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 680, "", Component.translatable("dga.text.zukan.jishomob"), ItemReg.appliChipJishomob.get(), EntiReg.jishoMOB.get()),
        JUMPPLUSMOB("Jumpplusmon", "Jumpplus", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 550, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipJumpplusmob.get(), EntiReg.jumpplusMOB.get()),
        KABEMOB("Kabemon", "Wallpaper", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 140, "", Component.translatable("dga.text.zukan.kabemob"), ItemReg.appliChipKabemob.get(), EntiReg.kabeMOB.get()),
        KAIMOB("Kaimon", "Shopping", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 330, "", Component.translatable("dga.text.zukan.kaimob"), ItemReg.appliChipKaimob.get(), EntiReg.kaiMOB.get()),
        KAKEIMOB("Kakeimon", "Account Book", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 210, "", Component.translatable("dga.text.zukan.kakeimob"), ItemReg.appliChipKakeimob.get(), EntiReg.kakeiMOB.get()),
        KOSOMOB("Kosomon", "Gossip_Review", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 230, "", Component.translatable("dga.text.zukan.kosomob"), ItemReg.appliChipKosomob.get(), EntiReg.kosoMOB.get()),
        LIBRAMOB("Libramon", "Library", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.LIFE, 5400, "", Component.translatable("dga.text.zukan.libramob"), ItemReg.appliChipLibramob.get(), EntiReg.libraMOB.get()),
        LIGHTMOB("Lightmon", "Light", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 150, "", Component.translatable("dga.text.zukan.lightmob"), ItemReg.appliChipLightmob.get(), EntiReg.lightMOB.get()),
        LOGAMOB("Logamon", "Logoff", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 7200, "", Component.translatable("dga.text.zukan.logamob"), ItemReg.appliChipLogamob.get(), EntiReg.logaMOB.get()),
        LOGIMOB("Logimon", "Login", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 7200, "", Component.translatable("dga.text.zukan.logimob"), ItemReg.appliChipLogimob.get(), EntiReg.logiMOB.get()),
        LUCKMOB("Luckmon", "Slot", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 777, "", Component.translatable("dga.text.zukan.luckmob"), ItemReg.appliChipLuckmob.get(), EntiReg.luckMOB.get()),
        MAILMOB("Mailmon", "Mail", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 510, "", Component.translatable("dga.text.zukan.mailmob"), ItemReg.appliChipMailmob.get(), EntiReg.mailMOB.get()),
        MCMOB("Mcmon", "Broadcasting", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 780, "", Component.translatable("dga.text.zukan.mcmob"), ItemReg.appliChipMcmob.get(), EntiReg.mcMOB.get()),
        MEDIAMOB("Mediamon", "Media_Player", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 5800, "", Component.translatable("dga.text.zukan.mediamob"), ItemReg.appliChipMediamob.get(), EntiReg.mediaMOB.get()),
        MEDICMOB("Medicmon", "Medical", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.LIFE, 8000, "", Component.translatable("dga.text.zukan.medicmob"), ItemReg.appliChipMedicmob.get(), EntiReg.medicMOB.get()),
        MESSEMOB("Messemon", "Message", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 500, "", Component.translatable("dga.text.zukan.messemob"), ItemReg.appliChipMessemob.get(), EntiReg.messeMOB.get()),
        MIENUMOB("Mienumon", "Stealth", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SYSTEM, 8400, "", Component.translatable("dga.text.zukan.mienumob"), ItemReg.appliChipMienumob.get(), EntiReg.mienuMOB.get()),
        MIRRORMOB("Mirrormon", "Mirror", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 700, "", Component.translatable("dga.text.zukan.mirrormob"), ItemReg.appliChipMirrormob.get(), EntiReg.mirrorMOB.get()),
        MONEYMOB("Moneymon", "emoney", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 110, "", Component.translatable("dga.text.zukan.moneymob"), ItemReg.appliChipMoneymob.get(), EntiReg.moneyMOB.get()),
        MUSCLEMOB("Musclemon", "Muscle_Training", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 920, "", Component.translatable("dga.text.zukan.musclemob"), ItemReg.appliChipMusclemob.get(), EntiReg.muscleMOB.get()),
        MUSIMOB("Musimon", "Music", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 880, "", Component.translatable("dga.text.zukan.musimob"), ItemReg.appliChipMusimob.get(), EntiReg.musiMOB.get()),
        NAVIMOB("Navimon", "Navi", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 560, "", Component.translatable("dga.text.zukan.navimob"), ItemReg.appliChipNavimob.get(), EntiReg.naviMOB.get()),
        NEWSMOB("Newsmon", "News", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 390, "", Component.translatable("dga.text.zukan.newsmob"), ItemReg.appliChipNewsmob.get(), EntiReg.newsMOB.get()),
        OFFMOB("Offmon", "Offline", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 950, "", Component.translatable("dga.text.zukan.offmob"), ItemReg.appliChipOffmob.get(), EntiReg.offMOB.get()),
        ONMOB("Onmon", "Online", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 950, "", Component.translatable("dga.text.zukan.onmob"), ItemReg.appliChipOnmob.get(), EntiReg.onMOB.get()),
        ONPAMOB("Onpamon", "Ultrasound", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 580, "", Component.translatable("dga.text.zukan.onpamob"), ItemReg.appliChipOnpamob.get(), EntiReg.onpaMOB.get()),
        OUJAMOB("Oujamon", "Battle", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.GAME, 95000, "", Component.translatable("dga.text.zukan.oujamob"), ItemReg.appliChipOujamob.get(), EntiReg.oujaMOB.get()),
        OURANOSMOB("Ouranosmon", "Arousal", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 290000, "", Component.translatable("dga.text.zukan.ouranosmob"), ItemReg.appliChipOuranosmob.get(), EntiReg.ouranosMOB.get()),
        PEKOMOB("Pekomon", "Compression", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 80, "", Component.translatable("dga.text.zukan.pekomob"), ItemReg.appliChipPekomob.get(), EntiReg.pekoMOB.get()),
        PERORIMOB("Perorimon", "Gourmet", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 690, "", Component.translatable("dga.text.zukan.perorimob"), ItemReg.appliChipPerorimob.get(), EntiReg.peroriMOB.get()),
        PIPOMOB("Pipomon", "Warning", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 950, "", Component.translatable("dga.text.zukan.pipomob"), ItemReg.appliChipPipomob.get(), EntiReg.pipoMOB.get()),
        POKOMOB("Pokomon", "Decompression", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 80, "", Component.translatable("dga.text.zukan.pokomob"), ItemReg.appliChipPokomob.get(), EntiReg.pokoMOB.get()),
        POSEIDOMOB("Poseidomon", "Invincible", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 270000, "", Component.translatable("dga.text.zukan.poseidomob"), ItemReg.appliChipPoseidomob.get(), EntiReg.poseidoMOB.get()),
        PROTECMOB("Protecmon", "Security", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 750, "", Component.translatable("dga.text.zukan.protecmob"), ItemReg.appliChipProtecmob.get(), EntiReg.protecMOB.get()),
        PUZZLEMOB("Puzzlemon", "Puzzle", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 350, "", Component.translatable("dga.text.zukan.puzzlemob"), ItemReg.appliChipPuzzlemob.get(), EntiReg.puzzleMOB.get()),
        RACEMOB("Racemon", "Race", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 550, "", Component.translatable("dga.text.zukan.racemob"), ItemReg.appliChipRacemob.get(), EntiReg.raceMOB.get()),
        RAIDRAMOB("Raidramon", "Super_Hacking", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SYSTEM, 12500, "", Component.translatable("dga.text.zukan.raidramob"), ItemReg.appliChipRaidramob.get(), EntiReg.raidraMOB.get()),
        REBOOTMOB("Rebootmon", "Reboot", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 280000, "", Component.translatable("dga.text.zukan.rebootmob"), ItemReg.appliChipRebootmob.get(), EntiReg.rebootMOB.get()),
        RECOMOB("Recomon", "Recording", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 290, "", Component.translatable("dga.text.zukan.recomob"), ItemReg.appliChipRecomob.get(), EntiReg.recoMOB.get()),
        RESSHAMOB("Resshamon", "Transfer", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 720, "", Component.translatable("dga.text.zukan.resshamob"), ItemReg.appliChipResshamob.get(), EntiReg.resshaMOB.get()),
        REVIEWMOB("Reviewmon", "Review", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 250, "", Component.translatable("dga.text.zukan.reviewmob"), ItemReg.appliChipReviewmob.get(), EntiReg.reviewMOB.get()),
        REVIVEMOB("Revivemon", "Restoration", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.SYSTEM, 78000, "", Component.translatable("dga.text.zukan.revivemob"), ItemReg.appliChipRevivemob.get(), EntiReg.reviveMOB.get()),
        ROAMOB("Roamon", "Voice_Change", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.TOOL, 4400, "", Component.translatable("dga.text.zukan.roamob"), ItemReg.appliChipRoamob.get(), EntiReg.roaMOB.get()),
        ROCKETMOB("Rocketmon", "Rocket", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 1600, "", Component.translatable("dga.text.zukan.rocketmob"), ItemReg.appliChipRocketmob.get(), EntiReg.rocketMOB.get()),
        ROPUREMOB("Ropuremon", "Ropure", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 1500, "", Component.translatable("dga.text.zukan.ropuremob"), ItemReg.appliChipRopuremob.get(), EntiReg.ropureMOB.get()),
        SAKUSIMOB("Sakusimon", "Simulation", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 14000, "", Component.translatable("dga.text.zukan.sakusimob"), ItemReg.appliChipSakusimob.get(), EntiReg.sakusiMOB.get()),
        SANTAMOB("Santamon", "Christmas", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 12250, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipSantamob.get(), EntiReg.santaMOB.get()),
        SATERAMOB("Sateramon", "GPS", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.NAVI, 100000, "", Component.translatable("dga.text.zukan.sateramob"), ItemReg.appliChipSateramob.get(), EntiReg.sateraMOB.get()),
        SAVEMOB("Savemon", "Backup", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SYSTEM, 1100, "", Component.translatable("dga.text.zukan.savemob"), ItemReg.appliChipSavemob.get(), EntiReg.saveMOB.get()),
        SCORPMOB("Scorpmon", "monitoring", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.TOOL, 13000, "", Component.translatable("dga.text.zukan.scorpmob"), ItemReg.appliChipScorpmob.get(), EntiReg.scorpMOB.get()),
        SETMOB("Setmon", "Setup", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 50, "", Component.translatable("dga.text.zukan.setmob"), ItemReg.appliChipSetmob.get(), EntiReg.setMOB.get()),
        SHOTMOB("Shotmon", "Shooting", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.GAME, 1300, "", Component.translatable("dga.text.zukan.shotmob"), ItemReg.appliChipShotmob.get(), EntiReg.shotMOB.get()),
        SHUTMOB("Shutmon", "Forced_Termination", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.TOOL, 57000, "", Component.translatable("dga.text.zukan.shutmob"), ItemReg.appliChipShutmob.get(), EntiReg.shutMOB.get()),
        SLEEPMOB("Sleepmon", "Sleep", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 270, "", Component.translatable("dga.text.zukan.sleepmob"), ItemReg.appliChipSleepmob.get(), EntiReg.sleepMOB.get()),
        SOCIAMOB("Sociamon", "SNS", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 6800, "", Component.translatable("dga.text.zukan.sociamob"), ItemReg.appliChipSociamob.get(), EntiReg.sociaMOB.get()),
        SPAMOB("Spamon", "Spa", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 260, "", Component.translatable("dga.text.zukan.spamob"), ItemReg.appliChipSpamob.get(), EntiReg.spaMOB.get()),
        SPECIAMOB("Speciamon", "Secret", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.NAVI, 100000, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipSpeciamob.get(), EntiReg.speciaMOB.get()),
        SUKASIMOB("Sukasimon", "Failed", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SOCIAL, 4000, "", Component.translatable("dga.text.zukan.sukasimob"), ItemReg.appliChipSukasimob.get(), EntiReg.sukasiMOB.get()),
        SUPERMOB("Supermon", "Super", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SYSTEM, 10000, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipSupermob.get(), EntiReg.superMOB.get()),
        SUPPLEMOB("Supplemon", "Supple", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 310, "", Component.translatable("dga.text.zukan.supplemob"), ItemReg.appliChipSupplemob.get(), EntiReg.suppleMOB.get()),
        SWIPEMOB("Swipemon", "Swipe", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.THREE_WARU, 8, "", Component.translatable("dga.text.zukan.swipemob"), ItemReg.appliChipSwipemob.get(), EntiReg.swipeMOB.get()),
        TAPMOB("Tapmon", "Tap", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.THREE_WARU, 8, "", Component.translatable("dga.text.zukan.tapmob"), ItemReg.appliChipTapmob.get(), EntiReg.tapMOB.get()),
        TAROTMOB("Tarotmon", "Super_Fortune_Telling", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 11500, "", Component.translatable("dga.text.zukan.tarotmob"), ItemReg.appliChipTarotmob.get(), EntiReg.tarotMOB.get()),
        TELLERMOB("Tellermon", "Fortune_Telling", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 400, "", Component.translatable("dga.text.zukan.tellermob"), ItemReg.appliChipTellermob.get(), EntiReg.tellerMOB.get()),
        TIMEMOB("Timemon", "Time_Slip", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.TOOL, 10000, "", Component.translatable("dga.text.zukan.timemob"), ItemReg.appliChipTimemob.get(), EntiReg.timeMOB.get()),
        TRICKMOB("Trickmon", "Trick", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.ENTERTAINMENT, 530, "", Component.translatable("dga.text.zukan.trickmob"), ItemReg.appliChipTrickmob.get(), EntiReg.trickMOB.get()),
        TRIPMOB("Tripmon", "Trip", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.NAVI, 6200, "", Component.translatable("dga.text.zukan.tripmob"), ItemReg.appliChipTripmob.get(), EntiReg.tripMOB.get()),
        TUBUMOB("Tubumon", "Tweet", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.SOCIAL, 480, "", Component.translatable("dga.text.zukan.tubumob"), ItemReg.appliChipTubumob.get(), EntiReg.tubuMOB.get()),
        TUTOMOB("Tutomon", "Commentary", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 200, "", Component.translatable("dga.text.zukan.tutomob"), ItemReg.appliChipTutomob.get(), EntiReg.tutoMOB.get()),
        URATEKUMOB("Uratekumon", "Hints_and_Tips", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 9000, "", Component.translatable("dga.text.zukan.uratekumob"), ItemReg.appliChipUratekumob.get(), EntiReg.uratekuMOB.get()),
        VEGASMOB("Vegasmon", "Roulette", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.ENTERTAINMENT, 9800, "", Component.translatable("dga.text.zukan.vegasmob"), ItemReg.appliChipVegasmob.get(), EntiReg.vegasMOB.get()),
        VIRUSMOB("Virusmon", "Virus", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.LIFE, 640, "", Component.translatable("dga.text.zukan.virusmob"), ItemReg.appliChipVirusmob.get(), EntiReg.virusMOB.get()),
        VJUMPMOB("Vjumpmon", "V_Jump", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.GAME, 5500, "", Component.translatable("dga.text.nulappmon"), ItemReg.appliChipV_jumpmob.get(), EntiReg.vjumpMOB.get()),
        WARPMOB("Warpmon", "Transmission", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.SYSTEM, 12000, "", Component.translatable("dga.text.zukan.warpmob"), ItemReg.appliChipWarpmob.get(), EntiReg.warpMOB.get()),
        WARUDAMOB("Warudamon", "Strategy", AppliFormTypes.FormTypes.ULTIMATE, AppliAttributes.Attributes.SYSTEM, 88000, "", Component.translatable("dga.text.zukan.warudamob"), ItemReg.appliChipWarudamob.get(), EntiReg.warudaMOB.get()),
        WATCHMOB("Watchmon", "Watch", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.TOOL, 160, "", Component.translatable("dga.text.zukan.watchmob"), ItemReg.appliChipWatchmob.get(), EntiReg.watchMOB.get()),
        WEATHERDRAMOB("Weatherdramon", "Weathers", AppliFormTypes.FormTypes.SUPER, AppliAttributes.Attributes.NAVI, 15000, "", Component.translatable("dga.text.zukan.weatherdramob"), ItemReg.appliChipWeatherdramob.get(), EntiReg.weatherdraMOB.get()),
        WEATHERMOB("Weathermon", "Weather", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 1050, "", Component.translatable("dga.text.zukan.weathermob"), ItemReg.appliChipWeathermob.get(), EntiReg.weatherMOB.get()),
        YADOMOB("Yadomon", "Hotel", AppliFormTypes.FormTypes.STANDARD, AppliAttributes.Attributes.NAVI, 470, "", Component.translatable("dga.text.zukan.yadomob"), ItemReg.appliChipYadomob.get(), EntiReg.yadoMOB.get()),
        nul("Nul","None", AppliFormTypes.FormTypes.__, AppliAttributes.Attributes.OTHER,-199302,"NO",Component.translatable("dga.text.nulappmon"), Items.AIR , EntiReg.woody.get()),
        FAILED("Nul", "failed", AppliFormTypes.FormTypes.__, AppliAttributes.Attributes.OTHER, Integer.MAX_VALUE,"FAIL", Component.translatable("text.nul.failed"), Items.AIR, EntiReg.woody.get()),

        WOODY("Woody", "Temporary", AppliFormTypes.FormTypes.Temp, AppliAttributes.Attributes.GOD, 1, "Temp", Component.translatable("dga.text.temp"), Items.AIR, EntiReg.woody.get());



        private final String name;
        private final int power;
        private final String application;

        private final AppliFormTypes.FormTypes formTypes;
        private final AppliAttributes.Attributes attributes;

        private final String techniques;
        private final Component data;

        private final Item appmonchip;

        private final EntityType<? extends AppliEntity> appmon;

        AppmonTypes(String name, String app, AppliFormTypes.FormTypes appliFormTypes, AppliAttributes.Attributes attributes, int power, String techniques, Component datatable, Item appmonchip, EntityType<? extends AppliEntity> appmon){
            this.name = name;
            this.power = power;
            this.application = app;
            this.attributes = attributes;
            this.formTypes = appliFormTypes;
            this.techniques = techniques;
            this.data = datatable;
            this.appmonchip = appmonchip;
            this.appmon = appmon;
        }


        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }

        public int getPower() {
            return this.power;
        }

        public String getApplication() {
            return Component.translatable("application." + this.application).getString();
        }

        public String getApplicationWithoutTranslation(){
            return this.application;
        }

        public AppliFormTypes.FormTypes getFormTypes() {
            return this.formTypes;
        }

        public AppliAttributes.Attributes getAttributes() {
            return this.attributes;
        }

        public String getTechniques() {
            return this.techniques;
        }

        public Component getData() {
            return this.data;
        }

        public Item getAppmonchip(){
            return this.appmonchip;
        }

        public EntityType<? extends AppliEntity> getAppmon(){
            return this.appmon;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
