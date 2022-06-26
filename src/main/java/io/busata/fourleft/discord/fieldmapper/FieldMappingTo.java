package io.busata.fourleft.discord.fieldmapper;

import java.util.UUID;

public record FieldMappingTo(
        UUID id,
        String name,
        String value,
        FieldMappingType fieldMappingType,
        boolean mappedByUser
) {
}
