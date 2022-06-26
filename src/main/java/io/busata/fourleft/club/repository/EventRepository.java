package io.busata.fourleft.club.repository;

import io.busata.fourleft.club.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
