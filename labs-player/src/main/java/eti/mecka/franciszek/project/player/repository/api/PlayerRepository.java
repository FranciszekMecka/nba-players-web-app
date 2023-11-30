package eti.mecka.franciszek.project.player.repository.api;

import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByIdAndOrganization(UUID id, Organization organization);
    List<Player> findAllByOrganization(Organization organization);

}
