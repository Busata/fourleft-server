package io.busata.fourleft.leaderboards;

import io.busata.fourleft.gateway.dto.leaderboard.DR2LeaderboardEntry;
import org.springframework.stereotype.Component;

@Component
public class BoardEntryFactory {

    public BoardEntry create(DR2LeaderboardEntry result) {
        BoardEntry entry = new BoardEntry();
        entry.setName(result.name());
        entry.setRank(result.rank());
        entry.setNationality(result.nationality());
        entry.setDnf(result.isDnfEntry());
        entry.setVehicleName(result.vehicleName());
        entry.setStageTime(result.stageTime());
        entry.setStageDiff(result.stageDiff());
        entry.setTotalDiff(result.totalDiff());
        entry.setTotalTime(result.totalTime());
        return entry;
    }
}
