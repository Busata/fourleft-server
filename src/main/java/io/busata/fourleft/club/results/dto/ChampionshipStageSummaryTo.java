package io.busata.fourleft.club.results.dto;

public record ChampionshipStageSummaryTo(String name,
                                         boolean isHardcoreDamage,
                                         boolean useAssists,
                                         boolean unexpectedMoments,
                                         boolean forceCockpit,
                                         ChampionshipStageEntryTo stageSummary) {
}
