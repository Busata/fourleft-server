package io.busata.fourleft.configuration.schedules;

import io.busata.fourleft.club.updater.ClubFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ClubLeaderboardUpdateSchedule {

    private final ClubFacade clubFacade;

    @Scheduled(fixedRate = 600000, initialDelay = 5000)
    public void updateLeaderboards() {
        log.info("Updating leaderboards");
        clubFacade.updateLeaderboards();
    }
}
