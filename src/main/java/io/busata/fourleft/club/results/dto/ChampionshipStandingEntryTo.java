package io.busata.fourleft.club.results.dto;

public record ChampionshipStandingEntryTo(
        Long rank,
        String nationality,
        String displayName,
        Long points
) {
}
