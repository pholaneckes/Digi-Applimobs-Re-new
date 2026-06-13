package love.digimons.digi_applimobs.appli_helpers;

public class GattaiResult {
    public static String checkGattai(String appmonA, String appmonB){
        switch (appmonA) {
            case "GATCHMOB" -> {
                return switch (appmonB) {
                    case "NAVIMOB", "TUBUMOB" -> "DOGATCHMOB";
                    case "ONMOB" -> "LOGIMOB";
                    default -> "noGattai";
                };
            }
            case "NAVIMOB" ->{
                return switch (appmonB) {
                    case "GATCHMOB", "TUBUMOB" -> "DOGATCHMOB";
                    default -> "noGattai";
                };
            }
            case "ADDMOB" -> {
                return switch (appmonB) {
                    case "CALLMOB", "MAILMOB", "MESSEMOB" -> "SOCIAMOB";
                    default -> "noGattai";
                };
            }
            case "CALLMOB" -> {
                return switch (appmonB) {
                    case "ADDMOB", "MAILMOB", "MESSEMOB" -> "SOCIAMOB";
                    default -> "noGattai";
                };
            }
            case "MAILMOB" -> {
                return switch (appmonB) {
                    case "ADDMOB", "CALLMOB", "MESSEMOB" -> "SOCIAMOB";
                    default -> "noGattai";
                };
            }
            case "AIDMOB" -> {
                return switch (appmonB) {
                    case "VIRUSMOB", "DOPEMOB" -> "DOCMOB";
                    case "SPAMOB", "SUPPLEMOB" -> "MEDICMOB";
                    default -> "noGattai";
                };
            }
            case "VIRUSMOB" -> {
                return switch (appmonB) {
                    case "AIDMOB", "DOPEMOB" -> "DOCMOB";
                    default -> "noGattai";
                };
            }
            case "AUCTIOMOB" -> {
                return switch (appmonB) {
                    case "MIRRORMOB", "DRESSMOB", "KAIMOB" -> "COORDEMOB";
                    default -> "noGattai";
                };
            }
            case "DRESSMOB" -> {
                return switch (appmonB) {
                    case "MIRRORMOB", "AUCTIOMOB", "KAIMOB" -> "COORDEMOB";
                    default -> "noGattai";
                };
            }
            case "MIRRORMOB" -> {
                return switch (appmonB) {
                    case "AUCTIOMOB", "DRESSMOB", "KAIMOB" -> "COORDEMOB";
                    case "COPIPEMOB", "KABEMOB", "DRAWMOB" -> "MIENUMOB";
                    default -> "noGattai";
                };
            }
            case "BATTERIMOB" -> {
                return switch (appmonB) {
                    case "CALCUMOB", "CARDMOB" -> "SAKUSIMOB";
                    default -> "noGattai";
                };
            }
            case "BEAUTYMOB" -> {
                return switch (appmonB) {
                    case "OUJAMOB" -> "POSEIDOMOB";
                    default -> "noGattai";
                };
            }
            case "BIOMOB" -> {
                return switch (appmonB) {
                    case "REVIVEMOB" -> "HADESMOB";
                    default -> "noGattai";
                };
            }
            case "BOOKMOB" -> {
                return switch (appmonB) {
                    case "SETMOB", "JISHOMOB" -> "LIBRAMOB";
                    default -> "noGattai";
                };
            }
            case "BOOTMOB" -> {
                return switch (appmonB) {
                    case "SHUTMOB" -> "REBOOTMOB";
                    default -> "noGattai";
                };
            }
            case "CALCUMOB" -> {
                return switch (appmonB) {
                    case "PUZZLEMOB", "MUSCLEMOB" -> "BRAMOB";
                    case "BATTERIMOB", "CARDMOB" -> "SAKUSIMOB";
                    default -> "noGattai";
                };
            }
            case "MUSCLEMOB" -> {
                return switch (appmonB) {
                    case "PUZZLEMOB", "CALCUMOB" -> "BRAMOB";
                    case "DOKAMOB", "MUSCLEMOB" -> "DOSUKOMOB";
                    default -> "noGattai";
                };
            }
            case "CALENDAMOB" -> {
                return switch (appmonB) {
                    case "WATCHMOB", "SAVEMOB" -> "TIMEMOB";
                    case "COOKMOB", "DIARIMOB" -> "COACHMOB";
                    default -> "noGattai";
                };
            }
            case "WATCHMOB" -> {
                return switch (appmonB) {
                    case "CALENDAMOB", "SAVEMOB" -> "TIMEMOB";
                    default -> "noGattai";
                };
            }
            case "COOKMOB" -> {
                return switch (appmonB) {
                    case "CALENDAMOB", "DIARIMOB" -> "COACHMOB";
                    default -> "noGattai";
                };
            }
            case "CAMERAMOB" -> {
                return switch (appmonB) {
                    case "SHOTMOB", "ROCKETMOB" -> "SCORPMOB";
                    default -> "noGattai";
                };
            }
            case "SHOTMOB" -> {
                return switch (appmonB) {
                    case "CAMERAMOB", "ROCKETMOB" -> "SCORPMOB";
                    default -> "noGattai";
                };
            }
            case "CARDMOB" -> {
                return switch (appmonB) {
                    case "TELLERMOB", "GASHAMOB" -> "TAROTMOB";
                    default -> "noGattai";
                };
            }
            case "TELLERMOB" -> {
                return switch (appmonB) {
                    case "CARDMOB", "GASHAMOB" -> "TAROTMOB";
                    default -> "noGattai";
                };
            }
            case "CHARISMOB" -> {
                return switch (appmonB) {
                    case "GLOBEMOB" -> "GAIAMOB";
                    default -> "noGattai";
                };
            }
            case "COACHMOB" -> {
                return switch (appmonB) {
                    case "DOSUKOMOB" -> "OUJAMOB";
                    default -> "noGattai";
                };
            }
            case "COMETMOB" -> {
                return switch (appmonB) {
                    case "WARUDAMOB" -> "DEUSUMOB";
                    default -> "noGattai";
                };
            }
            case "COMPASSMOB" -> {
                return switch (appmonB) {
                    case "JETMOB", "RESSHAMOB", "YADOMOB" -> "TRIPMOB";
                    default -> "noGattai";
                };
            }
            case "RESSHAMOB" -> {
                return switch (appmonB) {
                    case "JETMOB", "COMPASSMOB", "YADOMOB" -> "TRIPMOB";
                    default -> "noGattai";
                };
            }
            case "CONSULMOB" -> {
                return switch (appmonB) {
                    case "COORDEMOB" -> "BEAUTYMOB";
                    default -> "noGattai";
                };
            }
            case "COPIPEMOB" -> {
                return switch (appmonB) {
                    case "MIRRORMOB", "KABEMOB", "DRAWMOB" -> "MIENUMOB";
                    default -> "noGattai";
                };
            }
            case "CRAFTMOB" -> {
                return switch (appmonB) {
                    case "LOGIMOB" -> "BOOTMOB";
                    default -> "noGattai";
                };
            }
            case "DANCEMOB" -> {
                return switch (appmonB) {
                    case "MUSIMOB", "MCMOB", "RECOMOB" -> "MEDIAMOB";
                    default -> "noGattai";
                };
            }
            case "MUSIMOB" -> {
                return switch (appmonB) {
                    case "DANCEMOB", "MCMOB", "RECOMOB" -> "MEDIAMOB";
                    default -> "noGattai";
                };
            }
            case "MCMOB" -> {
                return switch (appmonB) {
                    case "DANCEMOB", "MUSIMOB", "RECOMOB" -> "MEDIAMOB";
                    default -> "noGattai";
                };
            }
            case "DENPAMOB" -> {
                return switch (appmonB) {
                    case "ONPAMOB", "JAMMINGMOB", "GENGOMOB" -> "ROAMOB";
                    default -> "noGattai";
                };
            }
            case "ONPAMOB" -> {
                return switch (appmonB) {
                    case "DENPAMOB", "JAMMINGMOB", "GENGOMOB" -> "ROAMOB";
                    default -> "noGattai";
                };
            }
            case "JAMMINGMOB" -> {
                return switch (appmonB) {
                    case "DENPAMOB", "ONPAMOB", "GENGOMOB" -> "ROAMOB";
                    default -> "noGattai";
                };
            }
            case "DEZIPMOB" -> {
                return switch (appmonB) {
                    case "RAIDRAMOB" -> "REVIVEMOB";
                    default -> "noGattai";
                };
            }
            case "DICEMOB" -> {
                return switch (appmonB) {
                    case "GASHAMOB", "LUCKMOB", "MONEYMOB" -> "VEGASMOB";
                    default -> "noGattai";
                };
            }
            case "LUCKMOB" -> {
                return switch (appmonB) {
                    case "GASHAMOB", "DICEMOB", "MONEYMOB" -> "VEGASMOB";
                    default -> "noGattai";
                };
            }
            case "MONEYMOB" -> {
                return switch (appmonB) {
                    case "GASHAMOB", "DICEMOB", "LUCKMOB" -> "VEGASMOB";
                    case "PEKOMOB", "ECOMOB", "KAKEIMOB" -> "CONSULMOB";
                    default -> "noGattai";
                };
            }
            case "DOCMOB" -> {
                return switch (appmonB) {
                    case "MEDICMOB" -> "BIOMOB";
                    default -> "noGattai";
                };
            }
            case "DOGAMOB" -> {
                return switch (appmonB) {
                    case "LIGHTMOB", "DRAWMOB" -> "EFFECMOB";
                    case "REVIEWMOB", "KOSOMOB", "NEWSMOB" -> "GOSSIPMOB";
                    default -> "noGattai";
                };
            }
            case "LIGHTMOB" -> {
                return switch (appmonB) {
                    case "DOGAMOB", "DRAWMOB" -> "EFFECMOB";
                    default -> "noGattai";
                };
            }
            case "REVIEWMOB" -> {
                return switch (appmonB) {
                    case "DOGAMOB", "KOSOMOB", "NEWSMOB" -> "GOSSIPMOB";
                    default -> "noGattai";
                };
            }
            case "KOSOMOB" -> {
                return switch (appmonB) {
                    case "DOGAMOB", "REVIEWMOB", "NEWSMOB" -> "GOSSIPMOB";
                    default -> "noGattai";
                };
            }
            case "DOGATCHMOB" -> {
                return switch (appmonB) {
                    case "TIMEMOB" -> "GLOBEMOB";
                    default -> "noGattai";
                };
            }
            case "DOKAMOB" -> {
                return switch (appmonB) {
                    case "PERORIMOB", "MUSCLEMOB" -> "DOSUKOMOB";
                    default -> "noGattai";
                };
            }
            case "PERORIMOB" -> {
                return switch (appmonB) {
                    case "DOKAMOB", "MUSCLEMOB" -> "DOSUKOMOB";
                    default -> "noGattai";
                };
            }
            case "DREAMMOB" -> {
                return switch (appmonB) {
                    case "MEDIAMOB" -> "ENTERMOB";
                    default -> "noGattai";
                };
            }
            case "ECOMOB" -> {
                return switch (appmonB) {
                    case "PEKOMOB", "MONEYMOB", "KAKEIMOB" -> "CONSULMOB";
                    case "GOMIMOB", "KABEMOB", "PUZZLEMOB" -> "CRAFTMOB";
                    default -> "noGattai";
                };
            }
            case "GOMIMOB" -> {
                return switch (appmonB) {
                    case "ECOMOB", "KABEMOB", "PUZZLEMOB" -> "CRAFTMOB";
                    default -> "noGattai";
                };
            }
            case "PUZZLEMOB" -> {
                return switch (appmonB) {
                    case "ECOMOB", "KABEMOB", "GOMIMOB" -> "CRAFTMOB";
                    case "CALCUMOB", "MUSCLEMOB" -> "BRAMOB";
                    default -> "noGattai";
                };
            }
            case "EFFECMOB" -> {
                return switch (appmonB) {
                    case "ROAMOB" -> "FAKEMOB";
                    default -> "noGattai";
                };
            }
            case "ENTERMOB" -> {
                return switch (appmonB) {
                    case "FAKEMOB" -> "OURANOSMOB";
                    default -> "noGattai";
                };
            }
            case "GOSSIPMOB" -> {
                return switch (appmonB) {
                    case "SOCIAMOB" -> "CHARISMOB";
                    default -> "noGattai";
                };
            }
            case "HACKMOB" -> {
                return switch (appmonB) {
                    case "OFFMOB" -> "LOGAMOB";
                    case "PROTECMOB", "PIPOMOB" -> "RAIDRAMOB";
                    default -> "noGattai";
                };
            }
            case "PROTECMOB" -> {
                return switch (appmonB) {
                    case "OFFMOB" -> "LOGAMOB";
                    case "HACKMOB", "PIPOMOB" -> "RAIDRAMOB";
                    default -> "noGattai";
                };
            }
            case "JETMOB" -> {
                return switch (appmonB) {
                    case "TRICKMOB", "RACEMOB" -> "WARPMOB";
                    case "COMPASSMOB", "RESSHAMOB", "YADOMOB" -> "TRIPMOB";
                    default -> "noGattai";
                };
            }
            case "TRICKMOB" -> {
                return switch (appmonB) {
                    case "JETMOB", "RACEMOB" -> "WARPMOB";
                    default -> "noGattai";
                };
            }
            case "LOGAMOB" -> {
                return switch (appmonB) {
                    case "TIMEMOB" -> "SHUTMOB";
                    default -> "noGattai";
                };
            }
            case "MIENUMOB" -> {
                return switch (appmonB) {
                    case "SAKUSIMOB" -> "WARUDAMOB";
                    default -> "noGattai";
                };
            }
            case "NEWSMOB" -> {
                return switch (appmonB) {
                    case "ROCKETMOB", "WEATHERMOB" -> "WEATHEDRAMOB";
                    default -> "noGattai";
                };
            }
            case "WEATHERMOB" -> {
                return switch (appmonB) {
                    case "ROCKETMOB", "NEWSMOB" -> "WEATHEDRAMOB";
                    default -> "noGattai";
                };
            }
            case "PEKOMOB" -> {
                return switch (appmonB) {
                    case "POKOMOB", "SAVEMOB" -> "DEZIPMOB";
                    case "ECOMOB", "MONEYMOB", "KAKEIMOB" -> "CONSULMOB";
                    default -> "noGattai";
                };
            }
            case "POKOMOB" -> {
                return switch (appmonB) {
                    case "PEKOMOB", "SAVEMOB" -> "DEZIPMOB";
                    default -> "noGattai";
                };
            }
            case "SATERAMOB" -> {
                return switch (appmonB) {
                    case "TRIPMOB" -> "SCORPMOB";
                    default -> "noGattai";
                };
            }
            case "SCORPMOB" -> {
                return switch (appmonB) {
                    case "TRIPMOB" -> "SATERAMOB";
                    default -> "noGattai";
                };
            }
            case "SETMOB" -> {
                return switch (appmonB) {
                    case "SLEEPMOB", "YADOMOB" -> "DREAMMOB";
                    case "BOOKMOB", "JISHOMOB" -> "LIBRAMOB";
                    default -> "noGattai";
                };
            }
            case "SLEEPMOB" -> {  //todo Leviathan
                return switch (appmonB) {
                    case "SETMOB", "YADOMOB" -> "DREAMMOB";
                    default -> "noGattai";
                };
            }
            case "WARPMOB" -> {
                return switch (appmonB) {
                    case "WEATHERDRAMOB" -> "COMETMOB";
                    default -> "noGattai";
                };
            }
            default -> {
                return "noGattai";
            }
        }
    }
}
