package eti.mecka.franciszek.project.organization.function;

import eti.mecka.franciszek.project.organization.dto.PutOrganizationRequest;
import eti.mecka.franciszek.project.organization.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToOrganizationFunction implements BiFunction<UUID, PutOrganizationRequest, Organization> {

    @Override
    public Organization apply(UUID id, PutOrganizationRequest putOrganizationRequest) {
        return Organization.builder()
                .id(id)
                .name(putOrganizationRequest.getName())
                .dateOfEstablishment(putOrganizationRequest.getDateOfEstablishment())
                .build();
    }
}
