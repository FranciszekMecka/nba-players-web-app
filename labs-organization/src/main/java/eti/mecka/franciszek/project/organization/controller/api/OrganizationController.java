package eti.mecka.franciszek.project.organization.controller.api;

import eti.mecka.franciszek.project.organization.dto.GetOrganizationResponse;
import eti.mecka.franciszek.project.organization.dto.GetOrganizationsResponse;
import eti.mecka.franciszek.project.organization.dto.PutOrganizationRequest;
import eti.mecka.franciszek.project.organization.dto.PatchOrganizationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface OrganizationController {

    /**
     *
     * @return list of organizations
     */
    @GetMapping("/api/organizations")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrganizationsResponse getOrganizations();

    /**
     *
     * @param id organization's id
     * @return single organization
     */
    @GetMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetOrganizationResponse getOrganization(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void PutOrganization(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutOrganizationRequest request
    );

    /**
     * Deletes selected organization.
     *
     * @param id organization's id
     */
    @DeleteMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrganization(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchOrganization(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchOrganizationRequest request
    );
}
