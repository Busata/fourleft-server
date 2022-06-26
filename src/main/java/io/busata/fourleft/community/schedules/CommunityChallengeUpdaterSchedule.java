package io.busata.fourleft.community.schedules;

import io.busata.fourleft.community.updater.CommunityChallengeUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CommunityChallengeUpdaterSchedule {

    private final CommunityChallengeUpdater updater;

    @Scheduled(initialDelay = 15000, fixedDelay=Long.MAX_VALUE)
    public void updateAfterStartup() {
        log.info("Startup update of community challenges");
        updater.update();
    }

    @Scheduled(cron = "0 15 12 * * *", zone="Europe/Brussels")
    public void updateChallenges() {
        log.info("Updating community challenges");
        updater.update();
    }
}
