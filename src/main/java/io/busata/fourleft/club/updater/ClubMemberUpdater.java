package io.busata.fourleft.club.updater;


import io.busata.fourleft.club.domain.Club;
import io.busata.fourleft.club.domain.ClubMember;
import io.busata.fourleft.club.domain.ClubMemberFactory;
import io.busata.fourleft.club.repository.ClubRepository;
import io.busata.fourleft.gateway.DR2Client;
import io.busata.fourleft.gateway.dto.club.DR2ClubMember;
import io.busata.fourleft.gateway.dto.club.DR2ClubMembers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
class ClubMemberUpdater {

    private final DR2Client client;
    private final ClubMemberFactory clubMemberFactory;
    private final ClubRepository clubRepository;

    public void updateMembers(Club club) {
        List<ClubMember> members = getAllMembers(club).stream().map(clubMemberFactory::create).toList();

        club.updateMembers(members);

        clubRepository.save(club);
    }

    private List<DR2ClubMember> getAllMembers(Club club) {
        List<DR2ClubMember> members = new ArrayList<>();

        var allMembersFetched = false;
        var currentPage = 1;
        while (!allMembersFetched) {

            DR2ClubMembers clubMembers = client.getClubMembers(club.getReferenceId(), 200, 1);

            members.addAll(clubMembers.members().owner());
            members.addAll(clubMembers.members().player());

            if (clubMembers.pageCount() == currentPage) {
                allMembersFetched = true;
            } else {
                currentPage += 1;
            }
        }

        return members;
    }
}
