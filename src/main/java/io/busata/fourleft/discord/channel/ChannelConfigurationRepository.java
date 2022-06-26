package io.busata.fourleft.discord.channel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChannelConfigurationRepository extends JpaRepository<ChannelConfiguration, UUID> {
}
