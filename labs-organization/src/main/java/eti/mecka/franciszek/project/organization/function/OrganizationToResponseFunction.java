package eti.mecka.franciszek.project.organization.function;

import eti.mecka.franciszek.project.organization.dto.GetOrganizationResponse;
import eti.mecka.franciszek.project.organization.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts {@link Organization} to {@link GetOrganizationResponse}.
 */
@Component
public class OrganizationToResponseFunction implements Function<Organization, GetOrganizationResponse> {
    @Override
    public GetOrganizationResponse apply(Organization entity) {
        return GetOrganizationResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateOfEstablishment(entity.getDateOfEstablishment())
                .build();
    }
}
