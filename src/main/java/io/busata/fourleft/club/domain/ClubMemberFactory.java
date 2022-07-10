package io.busata.fourleft.club.domain;

import io.busata.fourleft.gateway.dto.club.DR2ClubMember;
import io.busata.fourleft.gateway.dto.club.DR2ClubResultChampionship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClubMemberFactory {

    public ClubMember create(DR2ClubMember dr2ClubMember) {
        ClubMember clubMember = new ClubMember();

        clubMember.setReferenceId(dr2ClubMember.id());

        clubMember.setDisplayName(dr2ClubMember.displayName());
        clubMember.setMembershipType(dr2ClubMember.membershipType());

        clubMember.setChampionshipParticipation(dr2ClubMember.championshipParticipation());

        clubMember.setChampionshipGolds(dr2ClubMember.championshipGolds());
        clubMember.setChampionshipSilvers(dr2ClubMember.championshipSilvers());
        clubMember.setChampionshipBronzes(dr2ClubMember.championshipBronzes());

        return clubMember;
    }
}
