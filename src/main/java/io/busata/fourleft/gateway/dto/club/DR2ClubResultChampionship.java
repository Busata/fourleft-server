package io.busata.fourleft.gateway.dto.club;

import java.util.List;

public record DR2ClubResultChampionship(
        String id,
        String name,
        List<DR2ClubResultChampionshipEvent> events
) {

}
