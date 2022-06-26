package io.busata.fourleft.merge;

import io.busata.fourleft.leaderboards.LeaderboardKey;

public record MergeRequestTo(
        LeaderboardKey firstClub,
        LeaderboardKey secondClub
) {
}
