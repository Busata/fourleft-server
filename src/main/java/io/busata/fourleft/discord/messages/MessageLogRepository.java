package io.busata.fourleft.discord.messages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageLogRepository extends JpaRepository<MessageLog, UUID> {

    boolean existsByMessageIdAndMessageType(Long messagId, MessageType messageType);
}