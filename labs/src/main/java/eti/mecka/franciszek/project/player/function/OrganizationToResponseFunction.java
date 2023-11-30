package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.GetOrganizationResponse;
import eti.mecka.franciszek.project.player.entity.Organization;
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
