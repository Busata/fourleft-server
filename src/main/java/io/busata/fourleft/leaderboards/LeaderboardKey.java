package io.busata.fourleft.leaderboards;

public record LeaderboardKey(
        String challengeId,
        String eventId,
        String stageId
) {
}
