package io.busata.fourleft.club.results.dto;

import io.busata.fourleft.club.domain.Championship;
import io.busata.fourleft.club.domain.Event;
import io.busata.fourleft.club.domain.Stage;
import io.busata.fourleft.club.domain.StandingEntry;
import io.busata.fourleft.leaderboards.BoardEntry;
import io.busata.fourleft.leaderboards.LeaderboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClubResultToFactory {

    private final LeaderboardRepository leaderboardRepository;

    public ClubResultTo create(Event event) {
        final var lastStage = event.getLastStage();

        final var entries = leaderboardRepository.findLeaderboardByChallengeIdAndEventIdAndStageId(event.getChallengeId(), event.getReferenceId(), String.valueOf(lastStage.getReferenceId()))
                .map(board -> board.getEntries().stream().sorted(Comparator.comparing(BoardEntry::getRank)).map(this::createResultEntryTo).collect(Collectors.toList()))
                .orElse(new ArrayList<>());


        return new ClubResultTo(
                event.getReferenceId(),
                event.getChallengeId(),
                event.getName(),
                lastStage.getName(),
                event.getStages().stream().map(Stage::getName).collect(Collectors.toList()),
                event.getVehicleClass(),
                event.getCountry(),
                event.getLastResultCheckedTime(),
                event.getEndTime(),
                entries
        );
    }

    private ResultEntryTo createResultEntryTo(BoardEntry entry) {
        return new ResultEntryTo(entry.getRank(), entry.getName(), entry.getNationality(), entry.getVehicleName(), entry.getTotalTime(), entry.getTotalDiff());
    }

    public List<ChampionshipStandingEntryTo> createStandingsSummary(List<StandingEntry> entries) {
        return entries.stream().map(entry -> {
            return new ChampionshipStandingEntryTo(entry.getRank(), entry.getNationality(), entry.getDisplayName(), entry.getTotalPoints());
        }).collect(Collectors.toList());
    }

    public ChampionshipEventSummaryTo createEventSummary(Championship championship) {
        return new ChampionshipEventSummaryTo(
                championship.getName(),
                championship.isHardcoreDamage(),
                championship.isAllowAssists(),
                championship.isUnexpectedMoments(),
                championship.isForceCockpitCamera(),
                championship.getEvents().stream().sorted(Comparator.comparing(Event::getReferenceId)).map(event -> {
                    var country = event.getCountry();
                    var stage = event.getStages().get(event.getStages().size() - 1);
                    var firstStageCondition = event.getFirstStageCondition();
                    var vehicleClass = event.getVehicleClass();
                    var isCurrent = event.isCurrent();
                    var isFinished = event.isPrevious();

                    return new ChampionshipEventEntryTo(country,
                            event.getName(),
                            stage.getName(),
                            event.getChallengeId(),
                            event.getReferenceId(),
                            stage.getReferenceId(),
                            firstStageCondition,
                            vehicleClass,
                            isCurrent,
                            isFinished);
                }).collect(Collectors.toList())
        );
    }

    public ChampionshipStageSummaryTo createStageSummary(Championship championship) {
        return new ChampionshipStageSummaryTo(
                championship.getName(),
                championship.isHardcoreDamage(),
                championship.isAllowAssists(),
                championship.isUnexpectedMoments(),
                championship.isForceCockpitCamera(),
                championship.getEvents().stream().findFirst().map(event -> {
                    var country = event.getCountry();
                    var vehicleClass = event.getVehicleClass();
                    var stages = event.getStages().stream().map(Stage::getName).collect(Collectors.toList());

                    return new ChampionshipStageEntryTo(country, vehicleClass, stages);
                }).orElseThrow()
        );
    }
}
