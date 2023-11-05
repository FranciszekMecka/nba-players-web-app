package eti.mecka.franciszek.project.controller.api;

import eti.mecka.franciszek.project.player.dto.GetPlayerResponse;
import eti.mecka.franciszek.project.player.dto.GetPlayersResponse;
import eti.mecka.franciszek.project.player.dto.PutPlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface CharacterController {

    /**
     * @return list of players
     */
    @GetMapping("api/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getPlayers();


    /**
     * @param organizationId organizations' players
     * @return list of players of given organization
     */
    @GetMapping("api/organizations/{organizationId}/players")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayersResponse getOrganizationPlayers(
            @PathVariable("organizationId")
            UUID organizationId
    );

    /**
     * @param id player's id
     * @return single player
     */
    @GetMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getPlayer(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param organizationId organization's id
     * @param playerId       player's id
     * @return player of given id from organization
     */
    @GetMapping("/api/organizations/{organizationId}/players/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetPlayerResponse getOrganizationPlayer(
            @PathVariable("organizationId")
            UUID organizationId,
            @PathVariable("playerId")
            UUID playerId
    );

    /**
     * @param id      player's id
     * @param request new player
     */
    @GetMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putPlayer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutPlayerRequest request
    );

    /**
     * Deletes selected player.
     *
     * @param id player's id
     */
    @DeleteMapping("/api/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePlayer(
            @PathVariable("id")
            UUID id
    );
}
