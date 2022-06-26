package io.busata.fourleft.gateway;

import io.busata.fourleft.gateway.dto.club.DR2ClubChampionships;
import io.busata.fourleft.gateway.dto.club.DR2ClubDetails;
import io.busata.fourleft.gateway.dto.club.DR2ClubRecentResults;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateRequestTo;
import io.busata.fourleft.gateway.dto.club.championship.standings.DR2ChampionshipStandings;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardRequest;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardResults;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreationStatus;
import io.busata.fourleft.gateway.dto.communityevents.DR2CommunityEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Supplier;


@Component
@RequiredArgsConstructor
@Slf4j
public class DR2Client {

    private final DR2SeleniumAuthorization authorization;
    private final DR2Api api;

    @PostConstruct
    public void afterConstruction() {
        authorization.refreshLogin();
    }

    public DR2ChampionshipStandings getClubChampionshipStandings(long clubId) {
        return doAuthorizedCall(() -> api.getStandings(authorization.getHeaders(), clubId));
    }

    public DR2LeaderboardResults getLeaderboard(DR2LeaderboardRequest request) {
        return doAuthorizedCall(() -> api.getLeaderboard(authorization.getHeaders(), request));
    }

    public List<DR2ClubChampionships> getChampionships(long clubId) {
        return doAuthorizedCall(() -> api.getClubChampionships(authorization.getHeaders(), clubId));
    }
    public DR2ClubDetails getClubDetails(long clubId) {
        return doAuthorizedCall(() -> api.getClubDetails(authorization.getHeaders(), clubId));
    }

    public DR2ClubRecentResults getClubRecentResults(long clubId) {
        return doAuthorizedCall(() -> api.getClubRecentResults(authorization.getHeaders(), clubId));
    }

    public DR2ChampionshipCreationStatus createChampionship(long clubId, DR2ChampionshipCreateRequestTo create) {
        return doAuthorizedCall(() -> api.createChampionship(authorization.getHeaders(), clubId, create));
    }

    public List<DR2CommunityEvent> getCommunityEvents() {
        return doAuthorizedCall(() -> api.getCommunity(authorization.getHeaders()));
    }

    private <T> T doAuthorizedCall(Supplier<T> supplier) {
        authorization.refreshLogin();
        return supplier.get();
    }
}
