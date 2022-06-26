CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists field_mapping (
                                             id UUID not null primary key,
                                             name varchar(255),
                                             value text,
                                             type varchar(255)
);

insert into field_mapping values (uuid_generate_v4(), 'eWales', ':wales:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eArgentina', ':flag_ar:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eCanada', ':flag_ca:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eUsa', ':flag_us:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eNewZealand', ':flag_nz:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eGermany', ':flag_de:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eSpain', ':flag_es:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eBelgium', ':flag_be:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eFrance', ':flag_fr:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'ePoland', ':flag_pl:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eFinland', ':flag_fi:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eEngland', ':flag_gb:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'ePortugal', ':flag_pt:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eMonaco', ':flag_mc:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eSweden', ':flag_se:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), '31', ':scotland:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eGreece', ':flag_gr:','EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eAustralia', ':flag_au:','EMOTE');

insert into field_mapping values (uuid_generate_v4(), 'eLngAmerican', ':flag_us:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngArgentinian', ':flag_ar:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngAustralian', ':flag_au:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngBelgian', ':flag_be:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngBritish', ':flag_gb:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngCanadian', ':flag_ca:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngChinese', ':flag_cn:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngCzech', ':flag_cz:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngDutch', ':flag_nl:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngEnglish', ':england:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngFinnish', ':flag_fi:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngFrench', ':flag_fr:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngGerman', ':flag_de:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngGreek', ':flag_gr:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngIndonesian', ':flag_in:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngPortuguese', ':flag_pt:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngIrish', ':flag_ie:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngItalian', ':flag_it:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngIsraeli', ':flag_il:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngLatvian', ':flag_lv:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngLithuanian', ':flag_lt:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngNewZealander', ':flag_nz:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngSaudi', ':flag_sa:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngScottish', ':scotland:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngSlovakian', ':flag_si:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngSpanish', ':flag_es:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngSwedish', ':flag_se:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngUkranian', ':flag_ua:', 'EMOTE');
insert into field_mapping values (uuid_generate_v4(), 'eLngWelsh', ':wales:', 'EMOTE');

insert into field_mapping values (uuid_generate_v4(), 'eRallyUpTo20004wdCaps', '2000cc', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyH3RwdCaps', 'H3 RWD', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyH2FwdCaps', 'H2 FWD', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyH1FwdCaps', 'H1 FWD', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyH2RwdCaps', 'H2 RWD', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyR5Caps', 'R5', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyR2Caps', 'R2', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyGrpACaps', 'Group A', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyGrpB4wdCaps', 'Group B 4WD', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyNr4R4Caps', 'NR4/R4', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyRGtCaps', 'Rally GT', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eMultiCrosskartCaps', 'Crosskarts', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyxSupercarsCaps', 'RX Supercars', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyx1600sCaps', 'RX Super 1600s', 'HUMAN_READABLE');
insert into field_mapping values (uuid_generate_v4(), 'eRallyxLitesCaps', 'RX2', 'HUMAN_READABLE');


alter table field_mapping add column mapped_by_user boolean;

update field_mapping set mapped_by_user = true;