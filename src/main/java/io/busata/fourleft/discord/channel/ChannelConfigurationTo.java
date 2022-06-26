package io.busata.fourleft.discord.channel;

public record ChannelConfigurationTo(
        String description,
        Long channelId,
        Long clubId,
        boolean postClubResults,
        boolean postCommunityResults) {

}
