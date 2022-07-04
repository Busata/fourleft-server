package io.busata.fourleft.club.updater;

import io.busata.fourleft.club.domain.Championship;
import io.busata.fourleft.club.domain.ChampionshipFactory;
import io.busata.fourleft.club.domain.Club;
import io.busata.fourleft.club.domain.StandingEntry;
import io.busata.fourleft.club.repository.ClubRepository;
import io.busata.fourleft.gateway.DR2Client;
import io.busata.fourleft.gateway.dto.club.DR2ClubChampionships;
import io.busata.fourleft.gateway.dto.club.DR2ClubRecentResults;
import io.busata.fourleft.gateway.dto.club.championship.standings.DR2ChampionshipStandings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
class ClubDetailsUpdater {

    private final DR2Client dr2Client;
    private final ChampionshipFactory championshipFactory;

    public void refreshClub(Club club) {
        final var clubDetails = dr2Client.getClubDetails(club.getReferenceId());

        club.setName(clubDetails.club().name());
        club.setDescription(clubDetails.club().description());
        club.setMembers(clubDetails.club().memberCount());

        log.info("Fetching championships from API");
        DR2ClubRecentResults recentResults = dr2Client.getClubRecentResults(club.getReferenceId());

        List<Championship> updatedChampionhips = recentResults.championships().stream().map(championshipFactory::create).peek(championship -> championship.setClub(club)).collect(Collectors.toList());

        log.info("Enrich championship details from API");
        DR2ChampionshipStandings standings = dr2Client.getClubChampionshipStandings(club.getReferenceId());

        List<DR2ClubChampionships> championshipDetails = dr2Client.getChampionships(club.getReferenceId());
        championshipDetails.forEach(details -> {
            updatedChampionhips.stream().filter(championship -> championship.getReferenceId().equals(details.id()))
                    .findFirst().ifPresent(championship -> {


                        championship.setHardcoreDamage(details.useHardcoreDamage());
                        championship.setForceCockpitCamera(details.forceCockpitCamera());
                        championship.setActive(details.isActive());
                        championship.setAllowAssists(details.allowAssists());


                        details.events().forEach(eventDetails -> {
                            championship.getEvents().stream().filter(event -> event.getChallengeId().equals(eventDetails.id()))
                                    .findFirst().ifPresent(event -> {
                                        event.setEventStatus(eventDetails.eventStatus());

                                        ZonedDateTime start = ZonedDateTime.parse(eventDetails.entryWindow().start());
                                        ZonedDateTime end = ZonedDateTime.parse(eventDetails.entryWindow().end());

                                        event.setStartTime(start);
                                        event.setEndTime(end);

                                        event.setVehicleClass(eventDetails.vehicleClass());
                                        event.setCountry(eventDetails.countryId());
                                        event.setFirstStageCondition(eventDetails.firstStageConditions());
                                    });
                        });
                    });
        });

        log.info("Club: {} Championship count: {}", club.getName(), updatedChampionhips.size());

        var currentChampionships = club.getChampionships();

        var replacedWithUpdated = currentChampionships.stream().map(current -> updatedChampionhips.stream().filter(updated -> updated.equals(current)).findFirst().orElse(current)).collect(Collectors.toList());

        for (Championship updated : updatedChampionhips) {
            if (!replacedWithUpdated.contains(updated)) {
                replacedWithUpdated.add(updated);
            }
        }

        club.updateChampionships(replacedWithUpdated);

        club.findActiveChampionship().or(club::findPreviousChampionship).ifPresent(championship -> {
            championship.setEntries(standings.standings().stream().map(dr2Standing -> {
                StandingEntry entry = new StandingEntry();
                entry.setDisplayName(dr2Standing.displayName());
                entry.setChampionship(championship);
                entry.setNationality(dr2Standing.nationality());
                entry.setTotalPoints(dr2Standing.totalPoints());
                entry.setRank(dr2Standing.rank());
                return entry;
            }).collect(Collectors.toList()));
        });

        club.markRefreshed();
    }
}
