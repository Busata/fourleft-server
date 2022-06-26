package io.busata.fourleft.discord.fieldmapper;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FieldMappingEndpoint {

    private final FieldMappingRepository fieldMappingRepository;
    private final FieldMappingToFactory factory;

    @GetMapping("/api/discord/field_mappings")
    List<FieldMappingTo> getFieldMappings() {
        return fieldMappingRepository.findAll().stream().map(factory::create).collect(Collectors.toList());
    }

    @PostMapping("/api/discord/field_mappings")
    FieldMappingTo createFieldMapping(@RequestBody FieldMappingRequestTo request) {
        return factory.create(this.fieldMappingRepository.save(new FieldMapping(request.name(), request.type())));
    }

    @PutMapping("/api/discord/field_mappings/{id}")
    @Transactional
    FieldMappingTo updateFieldMapping(@RequestBody FieldMappingUpdateTo request, @PathVariable UUID id) {
        FieldMapping fieldMapping = this.fieldMappingRepository.findById(id).orElseThrow();
        fieldMapping.setName(request.name());
        fieldMapping.setValue(request.value());
        fieldMapping.setType(request.fieldMappingType());
        fieldMapping.setMappedByUser(true);

        return this.factory.create(this.fieldMappingRepository.save(fieldMapping));
    }
}
