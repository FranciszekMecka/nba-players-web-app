package eti.mecka.franciszek.project.organization.controller.impl;

import eti.mecka.franciszek.project.organization.controller.api.OrganizationController;
import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.organization.service.api.OrganizationService;
import eti.mecka.franciszek.project.player.entity.Player;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@Log
public class OrganizationDefaultController implements OrganizationController {

    private final OrganizationService service;
    public OrganizationDefaultController(OrganizationService service) {
        this.service = service;
    }


    @Override
    public void createOrganization(UUID id) {
        service.create(Organization.builder().id(id).build());
    }

    @Override
    public void deleteOrganization(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        organization -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
