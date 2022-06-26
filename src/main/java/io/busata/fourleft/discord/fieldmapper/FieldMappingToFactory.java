package io.busata.fourleft.discord.fieldmapper;

import org.springframework.stereotype.Component;

@Component
public class FieldMappingToFactory {

    public FieldMappingTo create(FieldMapping mapping) {
        return new FieldMappingTo(
                mapping.getId(),
                mapping.getName(),
                mapping.getValue(),
                mapping.getType(),
                mapping.isMappedByUser()
        );
    }
}
