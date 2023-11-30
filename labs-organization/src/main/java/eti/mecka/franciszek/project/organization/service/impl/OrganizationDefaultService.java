package eti.mecka.franciszek.project.organization.service.impl;

import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.organization.event.repository.api.OrganizationEventRepository;
import eti.mecka.franciszek.project.organization.repository.api.OrganizationRepository;
import eti.mecka.franciszek.project.organization.service.api.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationDefaultService implements OrganizationService {

    private final OrganizationRepository repository;
    private final OrganizationEventRepository eventRepository;

    public OrganizationDefaultService(OrganizationRepository repository, OrganizationEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
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
        eventRepository.delete(id);
    }
}
