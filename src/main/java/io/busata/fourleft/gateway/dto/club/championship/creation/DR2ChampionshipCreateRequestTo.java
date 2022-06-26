package io.busata.fourleft.gateway.dto.club.championship.creation;

import java.util.List;

public record DR2ChampionshipCreateRequestTo(
        boolean allowAssists,
        boolean forceCockpitCamera,
        long restartsLimit,
        String start,
        boolean useHardcoreDamage,
        boolean useUnexpectedMoments,
        List<DR2ChampionShipCreateEvent> events
) {
}
