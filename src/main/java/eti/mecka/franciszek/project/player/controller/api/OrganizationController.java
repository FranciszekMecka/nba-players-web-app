package eti.mecka.franciszek.project.player.controller.api;

import eti.mecka.franciszek.project.player.dto.GetOrganizationResponse;
import eti.mecka.franciszek.project.player.dto.GetOrganizationsResponse;
import eti.mecka.franciszek.project.player.dto.PatchOrganizationRequest;
import eti.mecka.franciszek.project.player.dto.PutOrganizationRequest;
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

    @PutMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putOrganization(
            @PathVariable("id") UUID id,
            @RequestBody PutOrganizationRequest request
    );

}
