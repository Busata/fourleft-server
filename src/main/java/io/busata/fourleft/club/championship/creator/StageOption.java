package io.busata.fourleft.club.championship.creator;

import lombok.Getter;

public enum StageOption {
    PRA_DALART(CountryOption.MONTE_CARLO,"eFranceRally01Route0", "Pra d’Alart",9.831,true),
    COL_DE_TURINI_DEPART(CountryOption.MONTE_CARLO, "eFranceRally01Route1","Col de Turini Départ",9.831,true),
    GORDOLON_COURTE_MONTEE(CountryOption.MONTE_CARLO, "eFranceRally01Route2","Gordolon - Courte montée",5.175,true),
    COL_DE_TURINI_SPRINT_EN_DESCENTE(CountryOption.MONTE_CARLO,"eFranceRally01Route3","Col de Turini - Sprint en descente",4.73,true),
    COL_DE_TURINI_SPRINT_EN_MONTEE(CountryOption.MONTE_CARLO,"eFranceRally01Route4","Col de Turini sprint en Montée",4.729,true),
    COL_DE_TURINI_DESCENTE(CountryOption.MONTE_CARLO,"eFranceRally01Route5","Col de Turini - Descente",5.175,true),
    VALLEE_DESCENDANTE(CountryOption.MONTE_CARLO,"eFranceRally02Route0","Vallée descendante",10.866,true),
    ROUTE_DE_TURINI(CountryOption.MONTE_CARLO,"eFranceRally02Route1","Route de Turini",10.866,true),
    COL_DE_TURINI_DEPART_EN_DESCENTE(CountryOption.MONTE_CARLO,"eFranceRally02Route2","Col de Turini - Départ en descente",6.846,true),
    APPROCHE_DU_COL_DE_TURINI_MONTEE(CountryOption.MONTE_CARLO,"eFranceRally02Route3","Approche du Col de Turini - Montée",3.952,true),
    ROUTE_DE_TURINI_DESCENTE(CountryOption.MONTE_CARLO,"eFranceRally02Route4","Route de Turini Descente",3.952,true),
    ROUTE_DE_TURINI_MONTEE(CountryOption.MONTE_CARLO,"eFranceRally02Route5","Route de Turini Montée",6.843,true),

    SWEET_LAMB(CountryOption.WALES,"eWalesRally01Route0","Sweet Lamb",9.9,true),
    GEUFRON_FOREST(CountryOption.WALES,"eWalesRally01Route1","Geufron Forest",10.0,true),
    PANT_MAWR(CountryOption.WALES,"eWalesRally01Route2","Pant Mawr",4.7,true),
    BIDNO_MOORLAND_REVERSE(CountryOption.WALES,"eWalesRally01Route3","Bidno Moorland Reverse",4.8,true),
    BIDNO_MOORLAND(CountryOption.WALES,"eWalesRally01Route4","Bidno Moorland",4.9,true),
    PANT_MAWR_REVERSE(CountryOption.WALES,"eWalesRally01Route5","Pant Mawr Reverse",5.1,true),
    RIVER_SEVERN_VALLEY(CountryOption.WALES,"eWalesRally02Route0","River Severn Valley",11.4,true),
    BRONFELEN(CountryOption.WALES,"eWalesRally02Route1","Bronfelen",11.4,true),
    FFERM_WYNT(CountryOption.WALES,"eWalesRally02Route2","Fferm Wynt",5.7,true),
    DYFFRYN_AFON_REVERSE(CountryOption.WALES,"eWalesRally02Route3","Dyffryn Afon Reverse",5.7,true),
    DYFFRYN_AFON(CountryOption.WALES,"eWalesRally02Route4","Dyffryn Afon",5.7,true),
    FFERM_WYNT_REVERSE(CountryOption.WALES,"eWalesRally02Route5","Fferm Wynt Reverse",5.7,true),

    KATHODO_LEONTIOU(CountryOption.GREECE,"eGreeceRally01Route1","Kathodo Leontiou",9.6,true),
    POMONA_EKRIXI(CountryOption.GREECE,"eGreeceRally01Route2","Pomona Ékrixi",5.09,true),
    FOURKETA_KOURVA(CountryOption.GREECE,"eGreeceRally01Route3","Fourkéta Kourva",4.8,true),
    KORYFI_DAFNI(CountryOption.GREECE,"eGreeceRally01Route4","Koryfi Dafni",4.5,true),
    AMPELONAS_ORMI(CountryOption.GREECE,"eGreeceRally01Route5","Ampelonas Ormi",4.95,true),
    PERASMA_PLATANI(CountryOption.GREECE,"eGreeceRally02Route0","Perasma Platani",10.69,true),
    TSIRISTRA_THEA(CountryOption.GREECE,"eGreeceRally02Route1","Tsiristra Théa",10.36,true),
    OUREA_SPEVSI(CountryOption.GREECE,"eGreeceRally02Route2","Ourea Spevsi",5.74,true),
    PEDINES_EPIDAXI(CountryOption.GREECE,"eGreeceRally02Route3","Pedines Epidaxi",5.38,true),
    ABIES_KOILADA(CountryOption.GREECE,"eGreeceRally02Route4","Abies Koiláda",7.09,true),
    YPSONA_TOU_DASOS(CountryOption.GREECE,"eGreeceRally02Route5","Ypsona tou Dasos",6.59,true),
    ANODOU_FARMAKAS(CountryOption.GREECE,"eGreeceRally01Route0","Anodou Farmakas",9.6,true),

    OBERSTEIN(CountryOption.GERMANY,"eGermanyRally01Route0","Oberstein",11.67,true),
    HAMMERSTEIN(CountryOption.GERMANY,"eGermanyRally02Route0","Hammerstein",10.81,true),
    FRAUENBERG(CountryOption.GERMANY,"eGermanyRally01Route1","Frauenberg",11.67,true),
    WALDAUFSTIEG(CountryOption.GERMANY,"eGermanyRally01Route2","Waldaufstieg",5.39,true),
    KREUZUNGSRING_REVERSE(CountryOption.GERMANY,"eGermanyRally01Route3","Kreuzungsring Reverse",6.31,true),
    KREUZUNGSRING(CountryOption.GERMANY,"eGermanyRally01Route4","Kreuzungsring",6.31,true),
    WALDABSTIEG(CountryOption.GERMANY,"eGermanyRally01Route5","Waldabstieg",5.39,true),
    RUSCHBERG(CountryOption.GERMANY,"eGermanyRally02Route1","Ruschberg",10.7,true),
    VERBUNDSRING(CountryOption.GERMANY,"eGermanyRally02Route2","Verbundsring",5.85,true),
    INNERER_FELD_SPRINT(CountryOption.GERMANY,"eGermanyRally02Route3","Innerer Feld-Sprint",5.56,true),
    INNERER_FELD_SPRINT_UMGEKEHRT(CountryOption.GERMANY,"eGermanyRally02Route4","Innerer Feld-Sprint (umgekehrt)",5.56,true),
    VERBUNDSRING_REVERSE(CountryOption.GERMANY,"eGermanyRally02Route5","Verbundsring Reverse",5.85,true),
    KONTINJARVI(CountryOption.FINLAND, "eFinlandRally01Route0","Kontinjärvi",15.05,true),
    HAMELAHTI(CountryOption.FINLAND,"eFinlandRally01Route1","Hämelahti",14.96,true),
    KAILAJARVI(CountryOption.FINLAND,"eFinlandRally01Route2","Kailajärvi",7.51,true),
    JYRKYSJARVI(CountryOption.FINLAND,"eFinlandRally01Route3","Jyrkysjärvi",7.55,true),
    NAARAJARVI(CountryOption.FINLAND,"eFinlandRally01Route4","Naarajärvi",7.43,true),
    PASKURI(CountryOption.FINLAND,"eFinlandRally01Route5","Paskuri",7.34,true),
    KAKARISTO(CountryOption.FINLAND,"eFinlandRally02Route0","Kakaristo",16.2,true),
    PITKAJARVI(CountryOption.FINLAND,"eFinlandRally02Route1","Pitkäjärvi",16.2,true),
    ISO_OKSJARVI(CountryOption.FINLAND,"eFinlandRally02Route2","Iso Oksjärvi",8.04,true),
    JARVENKYLA(CountryOption.FINLAND,"eFinlandRally02Route3","Järvenkylä",8.05,true),
    KOTAJARVI(CountryOption.FINLAND,"eFinlandRally02Route4","Kotajärvi",8.1,true),
    OKSALA(CountryOption.FINLAND,"eFinlandRally02Route5","Oksala",8.1,true),
    RANSBYSATER(CountryOption.SWEDEN,"eSwedenRally01Route0","Ransbysäter",11.977,true),
    NORRASKOGA(CountryOption.SWEDEN,"eSwedenRally01Route1","Norraskoga",11.977,true),
    ALGSJON_SPRINT(CountryOption.SWEDEN,"eSwedenRally01Route2","Älgsjön Sprint",5.248,true),
    STOR_JANGEN_SPRINT_REVERSE(CountryOption.SWEDEN,"eSwedenRally01Route3","Stor-jangen Sprint Reverse",6.693,true),
    STOR_JANGEN_SPRINT(CountryOption.SWEDEN,"eSwedenRally01Route4","Stor-jangen Sprint",6.693,true),
    SKOGSRALLYT(CountryOption.SWEDEN,"eSwedenRally01Route5","Skogsrallyt",5.248,true),
    HAMRA(CountryOption.SWEDEN,"eSwedenRally02Route0","Hamra",12.343,true),
    LYSVIK(CountryOption.SWEDEN,"eSwedenRally02Route1","Lysvik",12.343,true),
    ELGSJON(CountryOption.SWEDEN,"eSwedenRally02Route2","Elgsjön",7.278,true),
    BJORKLANGEN(CountryOption.SWEDEN,"eSwedenRally02Route3","Björklangen",5.191,true),
    OSTRA_HINNSJON(CountryOption.SWEDEN,"eSwedenRally02Route4","Östra Hinnsjön",5.191,true),
    ALGSJON(CountryOption.SWEDEN,"eSwedenRally02Route5","Älgsjön",7.278,true),
    COMIENZO_DE_BELLRIU(CountryOption.SPAIN,"eSpainRally01Route0","Comienzo De Bellriu",14.342,false),
    CENTENERA(CountryOption.SPAIN,"eSpainRally02Route0","Centenera",10.571,false),
    FINAL_DE_BELLRIU(CountryOption.SPAIN,"eSpainRally01Route1","Final de Bellriu",14.342,false),
    ASCENSO_POR_VALLE_EL_GUALET(CountryOption.SPAIN,"eSpainRally01Route2","Ascenso por valle el Gualet",7.002,false),
    VINEDOS_DENTRO_DEL_VALLE_PARRA(CountryOption.SPAIN,"eSpainRally01Route3","Viñedos dentro del valle Parra",6.813,false),
    ASCENSO_BOSQUE_MONTVERD(CountryOption.SPAIN,"eSpainRally01Route4","Ascenso bosque Montverd",6.813,false),
    SALIDA_DESDE_MONTVERD(CountryOption.SPAIN,"eSpainRally01Route5","Salida desde Montverd",7.002,false),
    CAMINO_A_CENTENERA(CountryOption.SPAIN,"eSpainRally02Route1","Camino a Centenera",10.571,false),
    DESCENSO_POR_CARRETERA(CountryOption.SPAIN,"eSpainRally02Route2","Descenso por carretera",4.584,false),
    VINEDOS_DARDENYA(CountryOption.SPAIN,"eSpainRally02Route3","Viñedos Dardenyà",6.549,false),
    VINEDOS_DARDENYA_INVERSA(CountryOption.SPAIN,"eSpainRally02Route4","Viñedos Dardenyà inversa",6.549,false),
    SUBIDA_POR_CARRETERA(CountryOption.SPAIN,"eSpainRally02Route5","Subida por carretera",4.584,false),
    MOUNT_KAYE_PASS(CountryOption.AUSTRALIA, "eAustraliaRally01Route0","Mount Kaye Pass",12.503,false),
    CHANDLERS_CREEK(CountryOption.AUSTRALIA,"eAustraliaRally02Route0","Chandlers Creek",12.341,false),
    MOUNT_KAYE_PASS_REVERSE(CountryOption.AUSTRALIA,"eAustraliaRally01Route1","Mount Kaye Pass Reverse",12.503,false),
    ROCKTON_PLAINS(CountryOption.AUSTRALIA,"eAustraliaRally01Route2","Rockton Plains",6.888,false),
    YAMBULLA_MOUNTAIN_DESCENT(CountryOption.AUSTRALIA,"eAustraliaRally01Route3","Yambulla Mountain Descent",6.64,false),
    YAMBULLA_MOUNTAIN_ASCENT(CountryOption.AUSTRALIA,"eAustraliaRally01Route4","Yambulla Mountain Ascent",6.64,false),
    ROCKTON_PLAINS_REVERSE(CountryOption.AUSTRALIA,"eAustraliaRally01Route5","Rockton Plains Reverse",6.888,false),
    CHANDLERS_CREEK_REVERSE(CountryOption.AUSTRALIA,"eAustraliaRally02Route1","Chandlers Creek Reverse",12.341,false),
    NOORINBEE_RIDGE_ASCENT(CountryOption.AUSTRALIA,"eAustraliaRally02Route2","Noorinbee Ridge Ascent",5.277,false),
    TAYLOR_FARM_SPRINT(CountryOption.AUSTRALIA,"eAustraliaRally02Route3","Taylor Farm Sprint",7.007,false),
    BONDI_FOREST(CountryOption.AUSTRALIA,"eAustraliaRally02Route4","Bondi Forest",7.007,false),
    NOORINBEE_RIDGE_DESCENT(CountryOption.AUSTRALIA,"eAustraliaRally02Route5","Noorinbee Ridge Descent",5.277,false),
    TE_AWANGA_FORWARD(CountryOption.NEW_ZEALAND, "eNewZealandRally01Route0","Te Awanga Forward",11.48,false),
    WAIMARAMA_POINT_FORWARD(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route0","Waimarama Point Forward",16.057,false),
    OCEAN_BEACH(CountryOption.NEW_ZEALAND,"eNewZealandRally01Route1","Ocean Beach",11.48,false),
    TE_AWANGA_SPRINT_FORWARD(CountryOption.NEW_ZEALAND,"eNewZealandRally01Route2","Te Awanga Sprint Forward",4.79,false),
    OCEAN_BEACH_SPRINT_FORWARD(CountryOption.NEW_ZEALAND,"eNewZealandRally01Route3","Ocean Beach Sprint Forward",6.613,false),
    OCEAN_BEACH_SPRINT_REVERSE(CountryOption.NEW_ZEALAND,"eNewZealandRally01Route4","Ocean Beach Sprint Reverse",6.613,false),
    TE_AWANGA_SPRINT_REVERSE(CountryOption.NEW_ZEALAND,"eNewZealandRally01Route5","Te Awanga Sprint Reverse",4.79,false),
    WAIMARAMA_POINT_REVERSE(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route1","Waimarama Point Reverse",16.057,false),
    ELSTHORPE_SPRINT_FORWARD(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route2","Elsthorpe Sprint Forward",7.317,false),
    WAIMARAMA_SPRINT_FORWARD(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route3","Waimarama Sprint Forward",8.807,false),
    WAIMARAMA_SPRINT_REVERSE(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route4","Waimarama Sprint Reverse",8.807,false),
    ELSTHORPE_SPRINT_REVERSE(CountryOption.NEW_ZEALAND,"eNewZealandRally02Route5","Elsthorpe Sprint Reverse",7.317,false),
    LAS_JUNTAS(CountryOption.ARGENTINA, "eArgentinaRally01Route0","Las Juntas",8.25,false),
    VALLE_DE_LOS_PUENTES(CountryOption.ARGENTINA,"eArgentinaRally02Route0","Valle de los puentes",7.976,false),
    CAMINO_A_LA_PUERTA(CountryOption.ARGENTINA,"eArgentinaRally01Route1","Camino a La Puerta",8.25,false),
    CAMINO_DE_ACANTILADOS_Y_ROCAS(CountryOption.ARGENTINA,"eArgentinaRally01Route2","Camino de acantilados y rocas",5.3,false),
    EL_RODEO(CountryOption.ARGENTINA,"eArgentinaRally01Route3","El Rodeo",2.842,false),
    LA_MERCED(CountryOption.ARGENTINA,"eArgentinaRally01Route4","La Merced",2.842,false),
    CAMINO_DE_ACANTILADOS_Y_ROCAS_INVERSO(CountryOption.ARGENTINA,"eArgentinaRally01Route5","Camino de acantilados y rocas inverso",5.3,false),
    VALLE_DE_LOS_PUENTES_A_LA_INVERSA(CountryOption.ARGENTINA,"eArgentinaRally02Route1","Valle de los puentes a la inversa",7.976,false),
    MIRAFLORES(CountryOption.ARGENTINA,"eArgentinaRally02Route2","Miraflores",3.352,false),
    SAN_ISIDRO(CountryOption.ARGENTINA,"eArgentinaRally02Route3","San Isidro",4.48,false),
    CAMINO_A_CONETA(CountryOption.ARGENTINA,"eArgentinaRally02Route4","Camino a Coneta",4.48,false),
    HUILLAPRIMA(CountryOption.ARGENTINA,"eArgentinaRally02Route5","Huillaprima",3.352,false),
    ZAROBKA(CountryOption.POLAND,"ePolandRally01Route0","Zaróbka",16.461,false),
    ZAGORZE(CountryOption.POLAND,"ePolandRally01Route1","Zagórze",16.461,false),
    KOPINA(CountryOption.POLAND,"ePolandRally01Route2","Kopina",7.03,false),
    MARYNKA(CountryOption.POLAND,"ePolandRally01Route3","Marynka",9.247,false),
    BORYSIK(CountryOption.POLAND,"ePolandRally01Route4","Borysik",9.247,false),
    JOZEFIN(CountryOption.POLAND,"ePolandRally01Route5","Józefin",7.03,false),
    JEZIORO_ROTCZE(CountryOption.POLAND,"ePolandRally02Route0","Jezioro Rotcze",13.42,false),
    ZIENKI(CountryOption.POLAND,"ePolandRally02Route1","Zienki",13.42,false),
    CZARNY_LAS(CountryOption.POLAND,"ePolandRally02Route2","Czarny Las",6.624,false),
    LEJNO(CountryOption.POLAND,"ePolandRally02Route3","Lejno",6.815,false),
    JAGODNO(CountryOption.POLAND,"ePolandRally02Route4","Jagodno",6.815,false),
    JEZIORO_LUKIE(CountryOption.POLAND,"ePolandRally02Route5","Jezioro Lukie",6.624,false),
    NORTH_FORK_PASS(CountryOption.USA,"eUsaRally01Route0","North Fork Pass",12.503,false),
    NORTH_FORK_PASS_REVERSE(CountryOption.USA,"eUsaRally01Route1","North Fork Pass Reverse",12.503,false),
    HANCOCK_CREEK_BURST(CountryOption.USA,"eUsaRally01Route2","Hancock Creek Burst",6.888,false),
    FULLER_MOUNTAIN_DESCENT(CountryOption.USA,"eUsaRally01Route3","Fuller Mountain Descent",6.64,false),
    FULLER_MOUNTAIN_ASCENT(CountryOption.USA,"eUsaRally01Route4","Fuller Mountain Ascent",6.64,false),
    FURY_LAKE_DEPART(CountryOption.USA,"eUsaRally01Route5","Fury Lake Depart",6.888,false),
    BEAVER_CREEK_TRAIL_FORWARD(CountryOption.USA,"eUsaRally02Route0","Beaver Creek Trail Forward",12.858,false),
    BEAVER_CREEK_TRAIL_REVERSE(CountryOption.USA,"eUsaRally02Route1","Beaver Creek Trail Reverse",12.858,false),
    HANCOCK_HILL_SPRINT_FORWARD(CountryOption.USA,"eUsaRally02Route2","Hancock Hill Sprint Forward",6.009,false),
    TOLT_VALLEY_SPRINT_REVERSE(CountryOption.USA,"eUsaRally02Route3","Tolt Valley Sprint Reverse",6.101,false),
    TOLT_VALLEY_SPRINT_FORWARD(CountryOption.USA,"eUsaRally02Route4","Tolt Valley Sprint Forward",6.101,false),
    HANCOCK_HILL_SPRINT_REVERSE(CountryOption.USA,"eUsaRally02Route5","Hancock Hill Sprint Reverse",6.009,false),
    SOUTH_MORNINGSIDE(CountryOption.SCOTLAND, "eScotlandRally03Route0","South Morningside",12.581,true),
    SOUTH_MORNINGSIDE_REVERSE(CountryOption.SCOTLAND,"eScotlandRally03Route1","South Morningside Reverse",12.664,true),
    OLD_BUTTERSTONE_MUIR(CountryOption.SCOTLAND,"eScotlandRally03Route2","Old Butterstone Muir",5.82,true),
    ROSEBANK_FARM(CountryOption.SCOTLAND,"eScotlandRally03Route3","Rosebank Farm",7.16,true),
    ROSEBANK_FARM_REVERSE(CountryOption.SCOTLAND,"eScotlandRally03Route4","Rosebank Farm Reverse",6.964,true),
    OLD_BUTTERSTONE_MUIR_REVERSE(CountryOption.SCOTLAND,"eScotlandRally03Route5","Old Butterstone Muir Reverse",5.664,true),
    NEWHOUSE_BRIDGE(CountryOption.SCOTLAND,"eScotlandRally04Route0","Newhouse Bridge",12.856,true),
    NEWHOUSE_BRIDGE_REVERSE(CountryOption.SCOTLAND,"eScotlandRally04Route1","Newhouse Bridge Reverse",12.98,true),
    GLENCASTLE_FARM(CountryOption.SCOTLAND,"eScotlandRally04Route2","Glencastle Farm",5.247,true),
    ANNBANK_STATION(CountryOption.SCOTLAND,"eScotlandRally04Route3","Annbank Station",7.767,true),
    ANNBANK_STATION_REVERSE(CountryOption.SCOTLAND,"eScotlandRally04Route4","Annbank Station Reverse",7.586,true),
    GLENCASTLE_FARM_REVERSE(CountryOption.SCOTLAND,"eScotlandRally04Route5","Glencastle Farm Reverse",5.24,true);

    private final String id;
    private final CountryOption countryOption;

    @Getter
    private final String displayName;
    @Getter
    private final double lengthKm;
    private final boolean isDLC;


    StageOption(CountryOption countryOption, String id, String displayName, double lengthKm, boolean isDLC) {
        this.id = id;
        this.countryOption = countryOption;
        this.displayName = displayName;
        this.lengthKm = lengthKm;
        this.isDLC = isDLC;
    }

    public String id() {
        return this.id;
    }

    public CountryOption country() {
        return this.countryOption;
    }
}
