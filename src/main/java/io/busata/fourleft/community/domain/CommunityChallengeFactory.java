package io.busata.fourleft.community.domain;

import io.busata.fourleft.community.domain.CommunityChallenge;
import io.busata.fourleft.community.domain.CommunityEvent;
import io.busata.fourleft.community.domain.CommunityStage;
import io.busata.fourleft.gateway.dto.communityevents.DR2Challenge;
import io.busata.fourleft.gateway.dto.communityevents.DR2CommunityEventType;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Component
public class CommunityChallengeFactory {

    public CommunityChallenge updateChallenge(CommunityChallenge challenge, DR2Challenge entry) {
        ZonedDateTime now = ZonedDateTime.now();

        challenge.setChallengeId(entry.id());
        challenge.setVehicleClass(entry.vehicleClass());
        challenge.setDLC(entry.isDirtPlus());

        ZonedDateTime start = ZonedDateTime.parse(entry.entryWindow().start());
        ZonedDateTime end = ZonedDateTime.parse(entry.entryWindow().end());

        challenge.setStartTime(start);
        challenge.setEndTime(end);
        challenge.setEnded(end.isBefore(now));

        challenge.updateEvents(entry.events().stream().map(eventEntry -> {
            CommunityEvent event = new CommunityEvent();
            event.setEventId(eventEntry.id());
            event.setDiscipline(eventEntry.discipline());
            event.setName(eventEntry.name());
            event.setChallenge(challenge);

            event.updateStages(eventEntry.stages().stream().map(stageEntry -> {
                CommunityStage stage = new CommunityStage();
                stage.setEvent(event);
                stage.setStageId(stageEntry.id());
                stage.setName(stageEntry.name());
                stage.setCountry(stageEntry.country());
                stage.setLocation(stageEntry.location());
                return stage;
            }).collect(Collectors.toList()));

            return event;
        }).collect(Collectors.toList()));

        return challenge;
    }

    public CommunityChallenge createChallenge(DR2CommunityEventType type, DR2Challenge entry) {
        CommunityChallenge challenge = new CommunityChallenge();
        challenge.setType(type);
        return updateChallenge(challenge, entry);
    }
}
