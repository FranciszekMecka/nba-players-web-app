package eti.mecka.franciszek.project.player.service.api;

import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationService {
    Optional<Organization> find(UUID id);
    List<Organization> findAll();
    void create(Organization organization);
    void delete(UUID id);
}
