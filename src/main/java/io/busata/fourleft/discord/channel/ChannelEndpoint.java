package io.busata.fourleft.discord.channel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChannelEndpoint {

    private final ChannelConfigurationRepository repository;
    private final ChannelConfigurationFactory factory;

    @GetMapping("/api/discord/channels")
    public List<ChannelConfigurationTo> getChannelConfigurations() {
        return repository.findAll().stream().map(factory::create).toList();
    }
}
