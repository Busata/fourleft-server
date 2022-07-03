package io.busata.fourleft.club.championship.creator;

import io.busata.fourleft.club.domain.DR2Clubs;
import io.busata.fourleft.club.domain.Event;
import io.busata.fourleft.club.repository.ClubRepository;
import io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateRequestTo;
import io.busata.fourleft.gateway.dto.club.championship.creation.ServiceArea;
import io.busata.fourleft.gateway.dto.club.championship.creation.SurfaceDegradation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

import static io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateBuilder.championship;
import static io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateEventBuilder.event;
import static io.busata.fourleft.gateway.dto.club.championship.creation.DR2ChampionshipCreateStageBuilder.stage;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChampionshipCreator {
    private Random random = new Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

    private final ClubRepository clubRepository;

    private final WeightedOccurenceSelector weightedOccurenceSelector;
    private final int durationChampionshipInMinutes = 1430;

    @Transactional
    public DR2ChampionshipCreateRequestTo createDailyEvent() {
        final var countryConfiguration = generatedWeightedCountryConfiguration();

        final var stages = countryConfiguration.getStages();

        final var stage = stages.get(random.nextInt(stages.size()));

        final var surfaceDegradation = generateSurfaceDegradation();
        final var stageCondition = generateStageCondition(countryConfiguration.getCountry());


        return championship()
                .useHardcoreDamage(true)
                .allowAssists(true)
                .forceCockpitCamera(false)
                .useUnexpectedMoments(false)
                .start(LocalDateTime.now(ZoneOffset.UTC).toString())
                .withEvents(
                        event().country(countryConfiguration.getCountry())
                                .durationMins(durationChampionshipInMinutes)// 24 hours - 10 minutes, gives the bot some time to post results
                                .vehicle(generateWeightedVehicleOption())
                                .withStages(
                                        stage()
                                                .stageConditionOption(stageCondition)
                                                .degradation(surfaceDegradation)
                                                .serviceArea(ServiceArea.LONG)
                                                .route(stage)
                                )
                )
                .build();
    }

    public CountryConfiguration generatedWeightedCountryConfiguration() {
        final var club = clubRepository.findByReferenceId(DR2Clubs.DIRTY_DAILIES).orElseThrow();

        var countryOptions = club.getChampionships().stream().flatMap(championship -> championship.getEvents().stream())
                .map(Event::getCountry).map(CountryOption::findById).collect(Collectors.toList());

        Collections.reverse(countryOptions);

        return CountryConfiguration.findByCountry(
                weightedOccurenceSelector.generate(Arrays.asList(CountryOption.values()),
                        countryOptions, 13
                )
        );
    }

    public VehicleOption generateWeightedVehicleOption() {
        final var club = clubRepository.findByReferenceId(DR2Clubs.DIRTY_DAILIES).orElseThrow();
        var previouslyGeneratedVehicles = club.getChampionships().stream().flatMap(championship -> championship.getEvents().stream())
                .map(Event::getVehicleClass).map(VehicleOption::findById).collect(Collectors.toList());

        Collections.reverse(previouslyGeneratedVehicles);

        log.info("Previous vehicles: {}",previouslyGeneratedVehicles.stream().map(VehicleOption::displayName).collect(Collectors.joining(",")));

        final var previouslyGeneratedGroups = previouslyGeneratedVehicles.stream().map(VehicleGroups::findGroup).collect(Collectors.toList());

        VehicleGroups vehicleGroup = weightedOccurenceSelector.generate(Arrays.asList(VehicleGroups.values()),
                previouslyGeneratedGroups, 5
        );

        return weightedOccurenceSelector.generate(vehicleGroup.getVehicleOptions(),
                previouslyGeneratedVehicles.stream().filter(vehicleGroup::containsVehicleOption).collect(Collectors.toList())
                ,13
        );
    }

    public StageConditionOption generateStageCondition(CountryOption countryOption) {
        int chanceDry = getChanceDryWeather(countryOption);

        int chance = random.nextInt(100);

        if (chance < chanceDry) {
            final var dryConditions = countryOption.getDryConditions();
            return dryConditions.get(random.nextInt(dryConditions.size()));
        } else {
            final var wetConditions = countryOption.getWetConditions();
            return wetConditions.get(random.nextInt(wetConditions.size()));
        }
    }

    public int getChanceDryWeather(CountryOption country) {
        return switch (country) {
            case MONTE_CARLO -> 60;
            case WALES -> 40;
            case GREECE -> 90;
            case GERMANY -> 60;
            case FINLAND -> 60;
            case SWEDEN -> 50;
            case SPAIN -> 90;
            case AUSTRALIA -> 90;
            case NEW_ZEALAND -> 60;
            case ARGENTINA -> 70;
            case POLAND -> 65;
            case USA -> 75;
            case SCOTLAND -> 50;
        };
    }

    public SurfaceDegradation generateSurfaceDegradation() {
        final var options = SurfaceDegradation.values();

        return options[random.nextInt(options.length)];
    }


}
