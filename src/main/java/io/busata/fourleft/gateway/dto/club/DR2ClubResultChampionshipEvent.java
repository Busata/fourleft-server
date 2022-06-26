package io.busata.fourleft.gateway.dto.club;

import java.util.List;

public record DR2ClubResultChampionshipEvent(
        String id,
        String challengeId,
        String name,
        List<DR2ClubResultChampionshipEventStage> stages
) {
}
