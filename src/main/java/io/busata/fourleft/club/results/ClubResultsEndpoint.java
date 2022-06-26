package io.busata.fourleft.club.results;

import io.busata.fourleft.club.results.dto.ChampionshipEventSummaryTo;
import io.busata.fourleft.club.results.dto.ChampionshipStageSummaryTo;
import io.busata.fourleft.club.results.dto.ChampionshipStandingEntryTo;
import io.busata.fourleft.club.results.dto.ClubResultTo;
import io.busata.fourleft.club.results.dto.ClubResultToFactory;
import io.busata.fourleft.club.updater.ClubFacade;
import io.busata.fourleft.club.domain.Championship;
import io.busata.fourleft.club.domain.Club;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClubResultsEndpoint {
    private final ClubFacade clubFacade;
    private final ClubResultToFactory clubResultToFactory;
    private final ChampionshipResultMerger championshipResultMerger;

    @GetMapping("/api/club/{clubId}/results/current")
    public ClubResultTo getCurrentClubResults(@PathVariable Long clubId) {
        Club club = clubFacade.getOrCreate(clubId);

        return club.getCurrentEvent().map(clubResultToFactory::create).orElse(null);
    }
    @PostMapping("/api/club/{clubId}/refresh")
    public void forceRefresh(@PathVariable Long clubId) {
        Club club = clubFacade.getOrCreate(clubId);

        clubFacade.fullRefreshClub(club);
    }

    @GetMapping("/api/club/{clubId}/results/previous")
    public ClubResultTo getPreviousClubResults(@PathVariable Long clubId) {
        Club club = clubFacade.getOrCreate(clubId);
        return clubResultToFactory.create(club.getPreviousEvent());
    }

    @GetMapping("/api/club/{clubId}/event_summary")
    public ChampionshipEventSummaryTo getEventSummary(@PathVariable Long clubId) {
        return clubFacade.getOrCreate(clubId).findActiveChampionship()
                .map(clubResultToFactory::createEventSummary)
                .orElseThrow();
    }

    @GetMapping("/api/club/{clubId}/championship_standings")
    public List<ChampionshipStandingEntryTo> getChampionshipStandings(@PathVariable Long clubId) {
        Club club = clubFacade.getOrCreate(clubId);
        return club.findActiveChampionship()
                .or(club::findPreviousChampionship)
                .map(Championship::getEntries)
                .map(clubResultToFactory::createStandingsSummary)
                .orElseThrow();
    }
    @GetMapping("/api/club/{clubId}/championship_standings/automated_daily")
    public List<ChampionshipStandingEntryTo> getAutomatedDaily(@PathVariable Long clubId, @RequestParam(defaultValue="7") int days) {
        Club club = clubFacade.getOrCreate(clubId);
        var entries = club.getChampionships()
                .stream()
                .sorted(Comparator.comparing(Championship::getOrder).reversed())
                .filter(Championship::isInActive)
                .limit(days)
                .flatMap(championship -> championship.getEntries().stream())
                .collect(Collectors.toList());

        return clubResultToFactory.createStandingsSummary(championshipResultMerger.flattenEntries(entries));
    }

    @GetMapping("/api/club/{clubId}/stage_summary")
    public ChampionshipStageSummaryTo getStageSummary(@PathVariable Long clubId) {
        return clubFacade.getOrCreate(clubId).getChampionships().stream()
                .filter(Championship::isActive)
                .findFirst()
                .map(clubResultToFactory::createStageSummary)
                .orElseThrow();
    }
}
