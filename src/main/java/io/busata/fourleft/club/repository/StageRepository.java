package io.busata.fourleft.club.repository;

import io.busata.fourleft.club.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StageRepository extends JpaRepository<Stage, UUID> {
}
