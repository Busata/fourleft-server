package io.busata.fourleft.gateway.dto.club;


import java.util.List;

public record DR2ClubMemberData(
        List<DR2ClubMember> Owner,
        List<DR2ClubMember> Player
) {
}
