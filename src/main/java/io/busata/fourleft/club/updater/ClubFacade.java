package io.busata.fourleft.club.updater;

import io.busata.fourleft.club.domain.Club;
import io.busata.fourleft.club.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClubFacade {
    private final ClubRepository clubRepository;
    private final ClubDetailsUpdater clubDetailsUpdater;
    private final ClubLeaderboardUpdater clubLeaderboardUpdater;

    @Transactional
    public void updateLeaderboards() {
        clubRepository.findAll().stream()
                .peek(club -> {
                    if (club.requiresRefresh()) {
                        log.info("Club {} data too old, refreshing", club.getName());
                        clubDetailsUpdater.refreshClub(club);
                        clubRepository.save(club);
                    }
                })
                .forEach(clubLeaderboardUpdater::updateLeaderboards);
    }

    @Transactional
    public Club getOrCreate(long clubId) {
        return clubRepository.findByReferenceId(clubId)
                .orElseGet(
                        () -> {
                            log.info("Unknown club {}, fetching from API", clubId);
                            Club club = createClub(clubId);
                            return clubRepository.save(club);
                        }
                );
    }

    private Club createClub(long clubId) {
        Club club = new Club();
        club.setReferenceId(clubId);

        fullRefreshClub(club);

        return club;
    }

    public void fullRefreshClub(Club club) {
        refreshClubDetails(club);
        refreshLeaderboards(club);
    }

    public void refreshClubDetails(Club club) {
        clubDetailsUpdater.refreshClub(club);
        clubRepository.save(club);
    }

    public void refreshLeaderboards(Club club) {
        clubLeaderboardUpdater.updateLeaderboards(club);
    }


}
