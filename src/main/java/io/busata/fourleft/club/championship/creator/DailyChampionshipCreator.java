package io.busata.fourleft.club.championship.creator;

import io.busata.fourleft.club.domain.DR2Clubs;
import io.busata.fourleft.club.repository.ClubRepository;
import io.busata.fourleft.club.updater.ClubFacade;
import io.busata.fourleft.common.TransactionHandler;
import io.busata.fourleft.gateway.DR2Client;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DailyChampionshipCreator {

    private final DR2Client client;
    private final ChampionshipCreator creator;
    private final TransactionHandler transactionHandler;

    private final ClubRepository clubRepository;


    private final ClubFacade clubFacade;

    @SneakyThrows
    public void createChampionship() {
        log.info("Creating daily championship");

        client.createChampionship(DR2Clubs.DIRTY_DAILIES, creator.createDailyEvent());

        log.info("Championship was created!");

        transactionHandler.runInTransaction(() -> {
            clubRepository.findByReferenceId(DR2Clubs.DIRTY_DAILIES).ifPresent(clubFacade::refreshClubDetails);
        });

    }
    @SneakyThrows
    public void refreshClub() {
        log.info("Refreshing daily championship");

        transactionHandler.runInTransaction(() -> {
            clubRepository
                    .findByReferenceId(DR2Clubs.DIRTY_DAILIES)
                    .ifPresent(clubFacade::fullRefreshClub);
        });


    }
}
