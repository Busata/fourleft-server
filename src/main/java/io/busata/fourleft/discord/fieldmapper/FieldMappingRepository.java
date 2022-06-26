package io.busata.fourleft.discord.fieldmapper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FieldMappingRepository extends JpaRepository<FieldMapping, UUID> {

}
