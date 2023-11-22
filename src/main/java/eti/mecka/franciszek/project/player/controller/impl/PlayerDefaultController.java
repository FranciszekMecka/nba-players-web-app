package eti.mecka.franciszek.project.player.controller.impl;

import eti.mecka.franciszek.project.player.controller.api.PlayerController;
import eti.mecka.franciszek.project.player.dto.GetPlayerResponse;
import eti.mecka.franciszek.project.player.dto.GetPlayersResponse;
import eti.mecka.franciszek.project.player.dto.PatchPlayerRequest;
import eti.mecka.franciszek.project.player.dto.PutPlayerRequest;
import eti.mecka.franciszek.project.player.function.PlayerToResponseFunction;
import eti.mecka.franciszek.project.player.function.PlayersToResponseFunction;
import eti.mecka.franciszek.project.player.function.RequestToPlayerFunction;
import eti.mecka.franciszek.project.player.service.api.PlayerService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class PlayerDefaultController implements PlayerController {

    private final PlayerService service;
    private final PlayerToResponseFunction playerToResponse;
    private final PlayersToResponseFunction playersToResponse;
    private final RequestToPlayerFunction requestToPlayer;

    public PlayerDefaultController(
            PlayerService service,
            PlayerToResponseFunction playerToResponse,
            PlayersToResponseFunction playersToResponse,
            RequestToPlayerFunction requestToPlayer
    ) {
        this.service = service;
        this.playerToResponse = playerToResponse;
        this.playersToResponse = playersToResponse;
        this.requestToPlayer = requestToPlayer;
    }

    @Override
    public GetPlayersResponse getPlayers() {
        return playersToResponse.apply(service.findAll());
    }

    @Override
    public GetPlayersResponse getOrganizationPlayers(UUID organizationId) {
        return service.findAllByOrganization(organizationId)
                .map(playersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetPlayerResponse getPlayer(UUID id) {
        return service.find(id)
                .map(playerToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putPlayer(UUID id, PutPlayerRequest request) {
        service.create(requestToPlayer.apply(id, request));
    }

    @Override
    public void deletePlayer(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        player -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void patchPlayer(UUID id, PatchPlayerRequest request) {
        service.find(id)
                .ifPresentOrElse(
                        player -> {
                            player.setFirstName(request.getFirstName());
                            player.setLastName(request.getLastName());
                            player.setAge(request.getAge());
                            player.setJerseyNumber(request.getJerseyNumber());
                            service.update(player);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
