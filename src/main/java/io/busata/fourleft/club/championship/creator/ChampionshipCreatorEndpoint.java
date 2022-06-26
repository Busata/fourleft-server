package io.busata.fourleft.club.championship.creator;

import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateRequestTo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChampionshipCreatorEndpoint {
    private final ChampionshipCreator creator;

    @GetMapping("/api/championships_creation/test_daily")
    public DR2ChampionshipCreateRequestTo testDailyCreation() {
        return creator.createDailyEvent();
    }
}
