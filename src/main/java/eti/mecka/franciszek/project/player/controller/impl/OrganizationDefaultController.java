package eti.mecka.franciszek.project.player.controller.impl;

import eti.mecka.franciszek.project.player.controller.api.OrganizationController;
import eti.mecka.franciszek.project.player.dto.GetOrganizationResponse;
import eti.mecka.franciszek.project.player.dto.GetOrganizationsResponse;
import eti.mecka.franciszek.project.player.dto.PatchOrganizationRequest;
import eti.mecka.franciszek.project.player.dto.PutOrganizationRequest;
import eti.mecka.franciszek.project.player.function.OrganizationToResponseFunction;
import eti.mecka.franciszek.project.player.function.OrganizationsToResponseFunction;
import eti.mecka.franciszek.project.player.function.RequestToOrganizationFunction;
import eti.mecka.franciszek.project.player.service.api.OrganizationService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class OrganizationDefaultController implements OrganizationController {

    private final OrganizationService service;
    private final OrganizationToResponseFunction organizationToResponse;
    private final OrganizationsToResponseFunction organizationsToResponse;
    private final RequestToOrganizationFunction requestToOrganization;

    public OrganizationDefaultController(
            OrganizationService service,
            OrganizationToResponseFunction organizationToResponse,
            OrganizationsToResponseFunction organizationsToResponse,
            RequestToOrganizationFunction requestToOrganization) {
        this.service = service;
        this.organizationToResponse = organizationToResponse;
        this.organizationsToResponse = organizationsToResponse;
        this.requestToOrganization = requestToOrganization;
    }

    @Override
    public GetOrganizationsResponse getOrganizations() {
        return organizationsToResponse.apply(service.findAll());
    }

    @Override
    public GetOrganizationResponse getOrganization(UUID id) {
        return service.find(id)
                .map(organizationToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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

    @Override
    public void patchOrganization(UUID id, PatchOrganizationRequest request) {
        service.find(id)
                .ifPresentOrElse(
                        organization -> {
                            organization.setName(request.getName());
                            organization.setDateOfEstablishment(request.getDateOfEstablishment());
                            service.update(organization);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putOrganization(UUID id, PutOrganizationRequest request) {
        service.create(requestToOrganization.apply(id, request));
    }
}
