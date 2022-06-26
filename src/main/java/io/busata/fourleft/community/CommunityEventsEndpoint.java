package io.busata.fourleft.community;

import io.busata.fourleft.community.domain.CommunityChallenge;
import io.busata.fourleft.community.domain.CommunityEvent;
import io.busata.fourleft.community.domain.CommunityStage;
import io.busata.fourleft.community.dto.CommunityChallengeBoardEntryTo;
import io.busata.fourleft.community.dto.CommunityChallengeSummaryTo;
import io.busata.fourleft.community.dto.TrackUserRequestTo;
import io.busata.fourleft.community.repository.CommunityChallengeRepository;
import io.busata.fourleft.community.tracking.CommunityLeaderboardTracking;
import io.busata.fourleft.community.tracking.CommunityLeaderboardTrackingRepository;
import io.busata.fourleft.leaderboards.BoardEntry;
import io.busata.fourleft.leaderboards.LeaderboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequiredArgsConstructor
public class CommunityEventsEndpoint {

    private final CommunityLeaderboardTrackingRepository trackingRepository;
    private final CommunityChallengeRepository challengeRepository;
    private final LeaderboardRepository leaderboardRepository;

    @PostMapping("/api/community/track_user")
    CommunityLeaderboardTracking trackUserRequest(@RequestBody TrackUserRequestTo userRequestTo) {
        CommunityLeaderboardTracking tracking = new CommunityLeaderboardTracking();
        log.info("{} has requested to be tracked for results", userRequestTo.nickName());
        tracking.setNickName(userRequestTo.nickName());
        tracking.setAlias(userRequestTo.alias());

        return trackingRepository.save(tracking);
    }

    @GetMapping("/api/community/users")
    public List<CommunityLeaderboardTracking> getTrackedUsers() {
        return trackingRepository.findAll();
    }

    @DeleteMapping("/api/community/users/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        trackingRepository.deleteById(id);
    }


    @GetMapping("/api/community/results")
    List<CommunityChallengeSummaryTo> getResults() {
        final var trackedUsers = trackingRepository.findAll();
        return challengeRepository.findBySyncedTrueAndEndedTrue().stream()
                .filter(challenge -> challenge.getEndTime().toLocalDate().equals(LocalDate.now(ZoneId.systemDefault())))
                .map(challenge -> createCommunityChallengeSummary(trackedUsers, challenge)).collect(Collectors.toList());
    }

    @GetMapping("/api/community/results/yesterday")
    List<CommunityChallengeSummaryTo> getResultsFromYesterday() {
        final var trackedUsers = trackingRepository.findAll();
        return challengeRepository.findBySyncedTrueAndEndedTrue().stream()
                .filter(challenge -> challenge.getEndTime().toLocalDate().equals(LocalDate.now(ZoneId.systemDefault()).minusDays(1)))
                .map(challenge -> createCommunityChallengeSummary(trackedUsers, challenge)).collect(Collectors.toList());
    }

    private CommunityChallengeSummaryTo createCommunityChallengeSummary(List<CommunityLeaderboardTracking> trackedUsers, CommunityChallenge challenge) {
        final var leaderboard = challenge.getLeaderboardKey()
                .flatMap(leaderboardRepository::findLeaderboard)
                .orElseThrow();

        int totalRanks = leaderboard.getEntries().size();
        final var sortedEntries = leaderboard
                .getEntries()
                .stream()
                .sorted(Comparator.comparing(BoardEntry::getRank)).toList();

        List<CommunityChallengeBoardEntryTo> entries = sortedEntries.stream()
                .filter(boardEntry -> trackedUsers.stream().anyMatch(trackedUser -> trackedUser.getAlias().equals(boardEntry.getName())))
                .map(boardEntry -> {
                    final var trackedUser = trackedUsers.stream().filter(user -> user.getAlias().equals(boardEntry.getName())).findFirst().orElseThrow();
                    return createEntry(totalRanks, boardEntry, trackedUser.getNickName());
                }).collect(Collectors.toList());


        return new CommunityChallengeSummaryTo(
                challenge.getType(),
                challenge.getVehicleClass(),
                challenge.getEvents().stream().map(CommunityEvent::getName).map(this::mapToCountry).toList(),
                challenge.getLastEvent().flatMap(CommunityEvent::getLastStage).map(CommunityStage::getName).orElse(""),
                createEntry(totalRanks, sortedEntries.get(0)),
                entries
        );
    }

    private CommunityChallengeBoardEntryTo createEntry(int totalRanks, BoardEntry boardEntry, String alias) {
        return new CommunityChallengeBoardEntryTo(
                boardEntry.getRank(),
                alias,
                boardEntry.getNationality(),
                boardEntry.getVehicleName(),
                boardEntry.getTotalTime(),
                boardEntry.getTotalDiff(),
                totalRanks,
                ((float) boardEntry.getRank() / (float) totalRanks) * 100f,
                boardEntry.isDnf()
        );
    }

    private CommunityChallengeBoardEntryTo createEntry(int totalRanks, BoardEntry boardEntry) {
        return createEntry(totalRanks, boardEntry, boardEntry.getName());
    }

    private String mapToCountry(String eventName) {
        return switch (eventName) {
            case "HAWKES BAY" -> "eNewZealand";
            case "RIBADELLES", "CIRCUIT DE BARCELONA-CATALUNYA" -> "eSpain";
            case "MONARO" -> "eAustralia";
            case "TROIS-RIVIÈRES" -> "eCanada";
            case "MONTALEGRE" -> "ePortugal";
            case "LOHÉAC, BRETAGNE" -> "eFrance";
            case "HÖLJES" -> "eSweden";
            case "NEW ENGLAND" -> "eUsa";
            case "METTET" -> "eBelgium";
            case "ŁĘCZNA COUNTY" -> "ePoland";
            case "SILVERSTONE" -> "eEngland";
            case "CATAMARCA PROVINCE" -> "eArgentina";
            default -> eventName;
        };
    }

}

