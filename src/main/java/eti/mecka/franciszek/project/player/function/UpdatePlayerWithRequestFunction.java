package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.PatchPlayerRequest;
import eti.mecka.franciszek.project.player.entity.Player;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

/**
 * Returns new instance of {@link Player} based on provided value and updated with values from
 * {@link PatchPlayerRequest}.
 */
@Component
public class UpdatePlayerWithRequestFunction implements BiFunction<Player, PatchPlayerRequest, Player> {
    @Override
    public Player apply(Player entity, PatchPlayerRequest request) {
        return Player.builder()
                .id(entity.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationality(entity.getNationality())
                .jerseyNumber(request.getJerseyNumber())
                .age(request.getAge())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .dateOfBirth(entity.getDateOfBirth())
                .organization(entity.getOrganization())
                .build();
    }
}
