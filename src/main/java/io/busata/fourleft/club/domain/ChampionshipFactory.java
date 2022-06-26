package io.busata.fourleft.club.domain;

import io.busata.fourleft.gateway.dto.club.DR2ClubResultChampionship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChampionshipFactory {
    private final EventFactory eventFactory;

    public Championship create(DR2ClubResultChampionship clubResultChampionship) {
        Championship championship = new Championship();
        championship.setName(clubResultChampionship.name());
        championship.setReferenceId(clubResultChampionship.id());
        List<Event> events = clubResultChampionship.events().stream().map(eventFactory::create).peek(event -> event.setChampionship(championship)).collect(Collectors.toList());

        championship.updateEvents(events);

        return championship;
    }
}
