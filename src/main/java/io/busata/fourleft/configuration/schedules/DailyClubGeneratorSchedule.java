package io.busata.fourleft.configuration.schedules;

import io.busata.fourleft.club.championship.creator.DailyChampionshipCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DailyClubGeneratorSchedule {
    private final DailyChampionshipCreator dailyChampionshipCreator;

    @Scheduled(cron = "0 57 9 * * *", zone="Europe/Brussels")
    public void refreshDaily() {
        log.info("Refreshing championship");
        dailyChampionshipCreator.refreshClub();
    }

    @Scheduled(cron = "0 0 10 * * *", zone="Europe/Brussels")
    public void createDaily() {
        log.info("Creating championship");
        dailyChampionshipCreator.createChampionship();
    }
}
