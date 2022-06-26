package io.busata.fourleft.leaderboards;


import io.busata.fourleft.gateway.DR2Client;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardRequest;
import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardResults;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class LeaderboardFetcher {
    private final LeaderboardRepository leaderboardRepository;
    private final BoardEntryFactory boardEntryFactory;
    private final DR2Client client;

    public void upsertBoard(LeaderboardKey key) {
        upsertBoard(key.challengeId(), key.eventId(), String.valueOf(key.stageId()));
    }

    public void upsertBoard(String challengeId, String eventId, String stageId) {
        Leaderboard board = leaderboardRepository.findLeaderboardByChallengeIdAndEventIdAndStageId(challengeId, eventId, stageId)
                .orElseGet(Leaderboard::new);

        board.setChallengeId(challengeId);
        board.setEventId(eventId);
        board.setStageId(stageId);

        List<BoardEntry> entries = getBoardEntries(board);

        board.updateEntries(entries);
        leaderboardRepository.save(board);
    }

    private List<BoardEntry> getBoardEntries(Leaderboard board) {
        boolean done = false;
        int page = 1;

        List<BoardEntry> entries = new ArrayList<>();

        while (!done) {
            log.info("Fetching page {}", page);
            DR2LeaderboardRequest request = buildLeaderboardRequest(
                    board.getChallengeId(),
                    board.getEventId(),
                    String.valueOf(board.getStageId()),
                    page);
            DR2LeaderboardResults leaderboard = client.getLeaderboard(request);

            List<BoardEntry> pageEntries = leaderboard.entries().stream().map(boardEntryFactory::create)
                    .peek(entry -> entry.setLeaderboard(board))
                    .collect(Collectors.toList());
            entries.addAll(pageEntries);

            if (page >= leaderboard.pageCount()) {
                done = true;
            } else {
                page += 1;
            }
        }
        return entries;
    }

    private DR2LeaderboardRequest buildLeaderboardRequest(String challengeId, String eventId, String stageId, int page) {
        return new DR2LeaderboardRequest(
                challengeId,
                eventId,
                "Unspecified",
                "Unspecified",
                "None",
                true,
                page,
                100,
                "None",
                "Everyone",
                0,
                stageId);
    }

}
