package io.busata.fourleft.club.members.dto;

import io.busata.fourleft.club.domain.ClubMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClubMemberToFactory {

    public ClubMemberTo create(ClubMember member) {
        return new ClubMemberTo(
                member.getDisplayName(),
                member.getMembershipType(),
                member.getChampionshipGolds(),
                member.getChampionshipSilvers(),
                member.getChampionshipBronzes(),
                member.getChampionshipParticipation()
        );
    }
}
