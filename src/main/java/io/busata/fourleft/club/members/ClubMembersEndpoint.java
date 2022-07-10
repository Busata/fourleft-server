package io.busata.fourleft.club.members;

import io.busata.fourleft.club.domain.Championship;
import io.busata.fourleft.club.domain.Club;
import io.busata.fourleft.club.members.dto.ClubMemberTo;
import io.busata.fourleft.club.members.dto.ClubMemberToFactory;
import io.busata.fourleft.club.results.ChampionshipResultMerger;
import io.busata.fourleft.club.results.dto.ChampionshipEventSummaryTo;
import io.busata.fourleft.club.results.dto.ChampionshipStageSummaryTo;
import io.busata.fourleft.club.results.dto.ChampionshipStandingEntryTo;
import io.busata.fourleft.club.results.dto.ClubResultTo;
import io.busata.fourleft.club.results.dto.ClubResultToFactory;
import io.busata.fourleft.club.updater.ClubFacade;
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
public class ClubMembersEndpoint {
    private final ClubFacade clubFacade;
    private final ClubMemberToFactory clubMemberToFactory;

    @GetMapping("/api/club/{clubId}/members")
    public List<ClubMemberTo> getClubMembers(@PathVariable Long clubId) {
        Club club = clubFacade.getOrCreate(clubId);

        return club.getClubMembers().stream().map(clubMemberToFactory::create).collect(Collectors.toList());
    }
}
