package io.busata.fourleft.club.championship.creator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CycleOptionsSelector {
    private Random random = new Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

    public <T extends Enum<T>> T generate(List<T> uniqueOptions, List<T> occurrences) {
        final var limit = uniqueOptions.size();

        final var remainder = occurrences.size() % limit;

        final var lastBag = occurrences.stream().limit(remainder).toList();
        final var possibleOptions = uniqueOptions.stream().filter(i -> !lastBag.contains(i)).collect(Collectors.toList());

        return possibleOptions.get(random.nextInt(possibleOptions.size()));
    }
}
