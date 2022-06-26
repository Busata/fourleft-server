package io.busata.fourleft.club.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "standing_entry")
@Getter
@Setter
public class StandingEntry {
    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "championship_id")
    private Championship championship;

    Long rank;
    String nationality;
    String displayName;
    Long totalPoints;

}