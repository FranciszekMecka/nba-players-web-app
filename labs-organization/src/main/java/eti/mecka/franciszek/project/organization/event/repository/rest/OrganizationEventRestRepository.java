package eti.mecka.franciszek.project.organization.event.repository.rest;

import eti.mecka.franciszek.project.organization.event.repository.api.OrganizationEventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import java.util.UUID;

@Repository
public class OrganizationEventRestRepository implements OrganizationEventRepository {
    private final RestTemplate restTemplate;

    public OrganizationEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/organizations/{id}", id);
    }
}
