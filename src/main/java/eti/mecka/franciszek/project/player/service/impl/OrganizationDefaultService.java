package eti.mecka.franciszek.project.player.service.impl;

import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.repository.api.OrganizationRepository;
import eti.mecka.franciszek.project.player.service.api.OrganizationService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationDefaultService implements OrganizationService {

    private final OrganizationRepository repository;

    public OrganizationDefaultService(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Organization> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Organization> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Organization organization) { repository.save(organization); }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
