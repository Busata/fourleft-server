package io.busata.fourleft.discord.messages;

public record MessageLogTo(MessageType messageType, Long messageId, String author, String content, Long channelId) {
}