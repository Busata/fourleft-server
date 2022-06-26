package io.busata.fourleft.discord.messages;


import io.busata.fourleft.common.TransactionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageLogEndpoint {
    private final MessageLogRepository messageLogRepository;
    private final MessageLogFactory factory;
    private final TransactionHandler transactionHandler;

    @PostMapping("/api/discord/messages")
    public void postMessage(@RequestBody MessageLogTo request) {
        transactionHandler.runInTransaction(() -> {
            messageLogRepository.save(factory.create(request));
        });
    }

    @GetMapping("/api/discord/messages")
    public List<MessageLogTo> getMessages() {
        return messageLogRepository.findAll().stream().map(factory::create).toList();
    }
    @GetMapping("/api/discord/message")
    public boolean getMessages(@RequestParam long messageId, @RequestParam MessageType messageType) {
        return messageLogRepository.existsByMessageIdAndMessageType(messageId, messageType);
    }
}
