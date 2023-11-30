package eti.mecka.franciszek.project.organization.function;

import eti.mecka.franciszek.project.organization.dto.GetOrganizationsResponse;
import eti.mecka.franciszek.project.organization.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class OrganizationsToResponseFunction implements Function<List<Organization>, GetOrganizationsResponse> {

    @Override
    public GetOrganizationsResponse apply(List<Organization> entities) {
        return GetOrganizationsResponse.builder()
                .organizations(entities.stream()
                        .map(organization -> GetOrganizationsResponse.Organization.builder()
                                .id(organization.getId())
                                .name(organization.getName())
                                .build())
                        .toList())
                .build();
    }
}
