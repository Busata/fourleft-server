package io.busata.fourleft.club.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "club")
@Getter
@Setter
public class Club {
    @Id
    @GeneratedValue
    private UUID id;

    private Long referenceId;

    private String name;
    private String description;
    private long members;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("referenceId asc")
    private List<Championship> championships = new ArrayList<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubMember> clubMembers = new ArrayList<>();

    private LocalDateTime lastUpdate = LocalDateTime.now();

    public void updateChampionships(List<Championship> value) {
        championships.clear();
        championships.addAll(value);
    }

    public void updateMembers(List<ClubMember> members) {
        clubMembers.clear();
        clubMembers.addAll(members);
    }

    public boolean requiresRefresh() {
        return Duration.between(lastUpdate, LocalDateTime.now()).toMinutes() > 30;
    }

    public void markRefreshed() {
        this.lastUpdate = LocalDateTime.now();
    }

    public Optional<Event> getCurrentEvent() {
        return findActiveChampionship()
                .flatMap(championship -> championship.getEvents().stream().filter(Event::isCurrent).findFirst());
    }

    public Event getPreviousEvent() {
        return findActiveChampionship()
                .flatMap(championship ->
                        championship.getEvents().stream()
                                .sorted(Comparator.comparing(Event::getOrder))
                                .filter(Event::isPrevious)
                                .reduce((first, second) -> second)
                )
                .orElseGet(() -> findPreviousChampionship().flatMap(championship ->
                        championship.getEvents().stream()
                                .sorted(Comparator.comparing(Event::getOrder))
                                .reduce((first, second) -> second))
                        .orElse(null)
                );
    }

    public Optional<Championship> findActiveChampionship() {
        return getChampionships().stream()
                .filter(Championship::isActive).findFirst();
    }

    public Optional<Championship> findPreviousChampionship() {
        return getChampionships().stream()
                .sorted(Comparator.comparing(Championship::getOrder).reversed())
                .filter(Championship::isInActive).findFirst();
    }
}
