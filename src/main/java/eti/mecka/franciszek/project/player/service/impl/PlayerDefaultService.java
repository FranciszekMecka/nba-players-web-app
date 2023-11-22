package eti.mecka.franciszek.project.player.service.impl;

import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;
import eti.mecka.franciszek.project.player.repository.api.OrganizationRepository;
import eti.mecka.franciszek.project.player.repository.api.PlayerRepository;
import eti.mecka.franciszek.project.player.service.api.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerDefaultService implements PlayerService {
    private final PlayerRepository repository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public PlayerDefaultService(
            PlayerRepository repository,
            OrganizationRepository organizationRepository) {
        this.repository = repository;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Optional<Player> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Player> find(Organization organization, UUID id) {
        return repository.findByIdAndOrganization(id, organization);
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAll(Organization organization) {
        return repository.findAllByOrganization(organization);
    }
    @Override
    public Optional<List<Player>> findAllByOrganization(UUID organizationId) {
        return organizationRepository.findById(organizationId)
                .map(repository::findAllByOrganization);
    }

    @Override
    public void create(Player player) {
        repository.save(player);
    }

    @Override
    public void update(Player player) { repository.save(player); }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent((repository::delete));
    }

}
