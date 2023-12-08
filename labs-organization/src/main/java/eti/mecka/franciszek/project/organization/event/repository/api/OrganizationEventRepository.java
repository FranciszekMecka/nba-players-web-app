package eti.mecka.franciszek.project.organization.event.repository.api;

import eti.mecka.franciszek.project.organization.entity.Organization;

import java.util.UUID;

public interface OrganizationEventRepository {
    void delete(UUID id);
    void create(UUID id, Organization organization);
}
