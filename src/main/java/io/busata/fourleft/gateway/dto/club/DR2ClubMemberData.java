package io.busata.fourleft.gateway.dto.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DR2ClubMemberData(
        @JsonProperty("owner")
        List<DR2ClubMember> owner,
        @JsonProperty("player")
        List<DR2ClubMember> player
) {
}
