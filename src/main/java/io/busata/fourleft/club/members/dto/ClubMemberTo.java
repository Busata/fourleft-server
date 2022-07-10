package io.busata.fourleft.club.members.dto;

public record ClubMemberTo(
        String displayName,
        String membershipType,
        long championshipGolds,
        long championshipSilvers,
        long championshipBronzes,
        long championshipParticipation
) {
}
