package io.busata.fourleft.community.dto;

import io.busata.fourleft.gateway.dto.communityevents.DR2CommunityEventType;

import java.util.List;

public record CommunityChallengeSummaryTo(
        DR2CommunityEventType type,
        String vehicleClass,
        List<String> eventLocations,
        String firstStageName,
        CommunityChallengeBoardEntryTo firstEntry,
        List<CommunityChallengeBoardEntryTo> entries
) {
}
