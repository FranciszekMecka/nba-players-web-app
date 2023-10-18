package eti.mecka.franciszek.project.player.service.api;

import eti.mecka.franciszek.project.player.entity.Organization;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationService {
    Optional<Organization> find(UUID id);

    void create(Organization organization);
}
