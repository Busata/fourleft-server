package io.busata.fourleft.gateway;


import io.busata.fourleft.configuration.feign.FeignConfiguration;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateRequestTo;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreationStatus;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipDeleteStatus;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipOptions;
import io.busata.fourleft.gateway.dto.club.DR2ClubChampionships;
import io.busata.fourleft.gateway.dto.club.DR2ClubDetails;
import io.busata.fourleft.gateway.dto.club.DR2ClubRecentResults;
import io.busata.fourleft.gateway.dto.club.championship.standings.DR2ChampionshipStandings;
import io.busata.fourleft.gateway.dto.communityevents.DR2CommunityEvent;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardRequest;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardResults;
import io.busata.fourleft.gateway.dto.security.DR2InitialState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@FeignClient(name="dr2api", url="https://dirtrally2.dirtgame.com/", configuration = FeignConfiguration.class)
interface DR2Api {

    @GetMapping(value = "api/ClientStore/GetInitialState", produces = MediaType.APPLICATION_JSON_VALUE)
    DR2InitialState getInitialState(@RequestHeader HttpHeaders headers);

    @GetMapping("api/Club/{clubId}")
    DR2ClubDetails getClubDetails(@RequestHeader HttpHeaders headers, @PathVariable long clubId);

    @GetMapping("api/Club/{clubId}/championships")
    List<DR2ClubChampionships> getClubChampionships(@RequestHeader HttpHeaders headers, @PathVariable long clubId);

    @GetMapping("api/Club/{clubId}/recentResults")
    DR2ClubRecentResults getClubRecentResults(@RequestHeader HttpHeaders headers, @PathVariable long clubId);

    @PostMapping("api/Leaderboard")
    DR2LeaderboardResults getLeaderboard(@RequestHeader HttpHeaders headers, @RequestBody DR2LeaderboardRequest request);

    @GetMapping("api/Club/championship/options")
    DR2ChampionshipOptions getOptions(@RequestHeader HttpHeaders headers);

    @PostMapping("api/Club/{clubId}/championship")
    DR2ChampionshipCreationStatus createChampionship(@RequestHeader HttpHeaders headers, @PathVariable long clubId, @RequestBody DR2ChampionshipCreateRequestTo championshipCreateTo);

    @DeleteMapping("api/Club/{clubId}/activeChampionship")
    DR2ChampionshipDeleteStatus deleteActiveChampionship(@RequestHeader HttpHeaders headers, @PathVariable long clubId);

    @GetMapping("api/Club/{clubId}/standings/current/?page=1&pageLength=100")
    DR2ChampionshipStandings getStandings(@RequestHeader HttpHeaders headers, @PathVariable long clubId);

    @GetMapping("api/Challenge/Community")
    List<DR2CommunityEvent> getCommunity(@RequestHeader HttpHeaders headers);
}
