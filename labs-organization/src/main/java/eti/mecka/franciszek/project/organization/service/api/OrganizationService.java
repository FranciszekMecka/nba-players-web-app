package eti.mecka.franciszek.project.organization.service.api;

import eti.mecka.franciszek.project.organization.entity.Organization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationService {
    Optional<Organization> find(UUID id);
    List<Organization> findAll();
    void create(Organization organization);

    void update(Organization organization);
    void delete(UUID id);
}
