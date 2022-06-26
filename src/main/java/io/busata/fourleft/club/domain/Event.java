package io.busata.fourleft.club.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="event")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue
    private UUID id;

    private String referenceId;

    private String challengeId;
    private String name;
    private String eventStatus;
    private String vehicleClass;
    private String country;
    private String firstStageCondition;

    private LocalDateTime lastResultCheckedTime;

    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "championship_id")
    private Championship championship;


    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("referenceId ASC")
    private List<Stage> stages = new ArrayList<>();

    public void updateStages(List<Stage> value) {
        stages.clear();
        stages.addAll(value);
    }

    public boolean isCurrent() {
        return eventStatus.equals("Active");
    }

    public boolean isPrevious() {
        return eventStatus.equals("Finished");
    }

    public Stage getLastStage() {
        return getStages().get(getStages().size() -1);
    }

    Long getOrder() {
        return Long.valueOf(referenceId);
    }
}
