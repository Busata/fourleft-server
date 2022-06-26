package io.busata.fourleft.club.results;

import io.busata.fourleft.club.domain.StandingEntry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChampionshipResultMerger {

    public List<StandingEntry> flattenEntries(List<StandingEntry> entries) {
        List<StandingEntry> list = new ArrayList<>();

        entries.forEach(entry -> {
            findEntry(list, entry).ifPresentOrElse((existingEntry) -> {
                existingEntry.setTotalPoints(existingEntry.getTotalPoints() + entry.getTotalPoints());
            },() -> {
                list.add(entry);
            });
        });
        return list;
    }

    Optional<StandingEntry> findEntry(List<StandingEntry> entries, StandingEntry entry) {
        for (StandingEntry e : entries) {
            if (e.getDisplayName().equalsIgnoreCase(entry.getDisplayName())) {
                return Optional.of(e);
            }
        }

        return Optional.empty();
    }

}
