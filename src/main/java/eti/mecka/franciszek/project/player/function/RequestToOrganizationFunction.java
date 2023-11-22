package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.PutOrganizationRequest;
import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;
import eti.mecka.franciszek.project.player.service.api.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class RequestToOrganizationFunction implements BiFunction<UUID, PutOrganizationRequest, Organization> {
    private final PlayerService playerService;

    public RequestToOrganizationFunction(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public Organization apply(UUID id, PutOrganizationRequest request) {
        List<Player> players = request.getPlayers().stream()
                .map(player -> playerService.find(player.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + player.getId())))
                .toList();
        return Organization.builder()
                .id(id)
                .name(request.getName())
                .dateOfEstablishment(request.getDateOfEstablishment())
                .players(players)
                .build();
    }
}
