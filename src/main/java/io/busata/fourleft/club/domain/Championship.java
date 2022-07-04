package io.busata.fourleft.club.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "championship")
@Getter
@Setter
public class Championship {

    @Id
    @GeneratedValue
    private UUID id;

    private String referenceId;

    private String name;

    private boolean isActive;
    private boolean hardcoreDamage;
    private boolean unexpectedMoments;
    private boolean allowAssists;
    private boolean forceCockpitCamera;


    public boolean isInActive() {
        return !isActive;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;


    @OneToMany(mappedBy="championship", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("referenceId asc")
    private List<Event> events = new ArrayList<>();


    @OneToMany(mappedBy="championship", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StandingEntry> entries = new ArrayList<>();

    public void updateEvents(List<Event> value) {
        events.clear();
        events.addAll(value);
    }

    public long getOrder() {
        return Long.parseLong(getReferenceId());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Championship that = (Championship) o;
        return referenceId.equals(that.referenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceId);
    }
}
