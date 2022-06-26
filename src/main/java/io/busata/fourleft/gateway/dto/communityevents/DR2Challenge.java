package io.busata.fourleft.gateway.dto.communityevents;

import io.busata.fourleft.gateway.dto.club.DR2ClubEntryWindow;

import java.util.List;

public record DR2Challenge(
        String id,
        String name,
        boolean hasParticipated,
        boolean isDirtPlus,
        int seasonNumber,
        String vehicleClass,
        DR2ClubEntryWindow entryWindow,
        List<DR2ChallengeEvent> events
) {
}
