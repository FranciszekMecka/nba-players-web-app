package eti.mecka.franciszek.project.organization.event.repository.api;

import java.util.UUID;

public interface OrganizationEventRepository {
    void delete(UUID id);
    void create(UUID id);
}
