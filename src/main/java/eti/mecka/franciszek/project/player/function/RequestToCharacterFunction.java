package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.PutPlayerRequest;
import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutPlayerRequest} to {@link Player}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToCharacterFunction implements BiFunction<UUID, PutPlayerRequest, Player> {
    @Override
    public Player apply(UUID id, PutPlayerRequest request) {
        return Player.builder()
                .id(id)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationality(request.getNationality())
                .jerseyNumber(request.getJerseyNumber())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .dateOfBirth(request.getDateOfBirth())
                .organization(Organization.builder()
                        .id(request.getOrganization())
                        .build())
                .build();
    }
}
