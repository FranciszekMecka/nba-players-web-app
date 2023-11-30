package eti.mecka.franciszek.project.player.service.api;

import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {

    Optional<Player> find(UUID id);

    Optional<Player> find(Organization organization, UUID id);

    List<Player> findAll();
    Optional<List<Player>> findAllByOrganization(UUID organizationId);
    List<Player> findAll(Organization organization);
    void create(Player player);
    void update(Player player);
    void delete(UUID id);

}
