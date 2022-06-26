package io.busata.fourleft.club.domain;

import io.busata.fourleft.gateway.dto.club.DR2ClubDetails;
import org.springframework.stereotype.Component;

@Component
public class ClubFactory {

    public Club create(DR2ClubDetails clubDetails) {
        Club club = new Club();
        club.setReferenceId(clubDetails.club().id());
        club.setName(clubDetails.club().name());
        club.setDescription(clubDetails.club().description());
        club.setMembers(clubDetails.club().memberCount());
        return club;
    }
}
