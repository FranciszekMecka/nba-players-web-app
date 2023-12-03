package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.GetPlayerResponse;
import eti.mecka.franciszek.project.player.entity.Player;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts {@link Player} to {@link GetPlayerResponse}.
 */
@Component
public class PlayerToResponseFunction implements Function<Player, GetPlayerResponse> {

    @Override
    public GetPlayerResponse apply(Player entity) {
        return GetPlayerResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .nationality(entity.getNationality())
                .jerseyNumber(entity.getJerseyNumber())
                .age(entity.getAge())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .dateOfBirth(entity.getDateOfBirth())
                .organization(GetPlayerResponse.Organization.builder()
                        .id(entity.getOrganization().getId())
                        .name(entity.getOrganization().getName())
                        .build())
                .build();
    }
}
