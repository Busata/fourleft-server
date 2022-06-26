package io.busata.fourleft.community.tracking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunityLeaderboardTrackingRepository extends JpaRepository<CommunityLeaderboardTracking, UUID> {
}
