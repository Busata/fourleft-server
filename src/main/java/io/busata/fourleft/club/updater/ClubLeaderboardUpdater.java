package io.busata.fourleft.club.updater;


import com.google.common.collect.ImmutableList;
import io.busata.fourleft.club.domain.Club;
import io.busata.fourleft.club.domain.Event;
import io.busata.fourleft.club.repository.EventRepository;
import io.busata.fourleft.leaderboards.LeaderboardFetcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
class ClubLeaderboardUpdater {

    private final EventRepository eventRepository;
    private final LeaderboardFetcher leaderboardFetcher;

    public void updateLeaderboards(Club club) {
        try {
            club.getCurrentEvent().ifPresent(this::updateEventLeaderboards);
        } catch (Exception ex) {
            log.error("Error while updating current leaderboards", ex);
        }

        try {
            if (club.getPreviousEvent() == null) {
                return;
            }
            if (club.getPreviousEvent().getLastResultCheckedTime() == null) {
                this.updateEventLeaderboards(club.getPreviousEvent());
            }
        } catch (Exception ex) {
            log.error("Error while updating previous leaderboard", ex);
        }
    }

    private void updateEventLeaderboards(Event event) {
        if (event == null) {
            return;
        }

        ImmutableList.copyOf(event.getStages()).forEach(stage -> {
            leaderboardFetcher.upsertBoard(event.getChallengeId(), event.getReferenceId(), String.valueOf(stage.getReferenceId()));
            event.setLastResultCheckedTime(LocalDateTime.now());
            eventRepository.save(event);
        });
    }
}
