package eti.mecka.franciszek.project.organization.controller.api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface OrganizationController {

    /**
     * Deletes selected organization.
     *
     * @param id organization's id
     */
    @PutMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putOrganization(
            @PathVariable("id")
            UUID id
    );
    @DeleteMapping("/api/organizations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrganization(
            @PathVariable("id")
            UUID id
    );

}
