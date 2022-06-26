package io.busata.fourleft.gateway.dto.communityevents;

import java.util.List;

public record DR2CommunityEvent(
        DR2CommunityEventType type,
        String name,
        List<DR2ChallengeGroup> challengeGroups
) {
}
