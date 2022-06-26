package io.busata.fourleft.club.domain;

import io.busata.fourleft.gateway.dto.club.DR2ClubResultChampionshipEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventFactory {

    private final StageFactory stageFactory;

    public Event create(DR2ClubResultChampionshipEvent resultEvent) {
        Event event = new Event();
        event.setChallengeId(resultEvent.challengeId());
        event.setName(resultEvent.name());
        event.setReferenceId(resultEvent.id());

        List<Stage> stages = resultEvent.stages().stream().map(stageFactory::createStage).peek(stage -> stage.setEvent(event)).collect(Collectors.toList());

        event.updateStages(stages);

        return event;
    }
}
