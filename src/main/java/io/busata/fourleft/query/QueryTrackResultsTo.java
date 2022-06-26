package io.busata.fourleft.query;

public record QueryTrackResultsTo(
        String countryId,
        String countryName,

        StageOptionTo longStage,
        StageOptionTo firstShort,
        StageOptionTo secondShort,

        StageOptionTo reverseLongStage,
        StageOptionTo reverseFirstShort,
        StageOptionTo reverseSecondShort


) {
}
