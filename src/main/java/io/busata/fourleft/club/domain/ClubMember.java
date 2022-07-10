package io.busata.fourleft.club.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "club_member")
@Getter
@Setter
public class ClubMember {

    @Id
    @GeneratedValue
    private UUID id;

    private String referenceId;

    private String displayName;
    private String membershipType;
    private long championshipGolds;
    private long championshipSilvers;
    private long championshipBronzes;
    private long championshipParticipation;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;
}