package io.busata.fourleft.discord.channel;


import org.springframework.stereotype.Component;

@Component
public class ChannelConfigurationFactory {
    public ChannelConfigurationTo create(ChannelConfiguration channelConfiguration) {

        return new ChannelConfigurationTo (
                channelConfiguration.getDescription(),
                channelConfiguration.getChannelId(),
                channelConfiguration.getClubId(),
                channelConfiguration.isPostClubResults(),
                channelConfiguration.isPostCommunityResults()
        );



    }
}
