package eti.mecka.franciszek.project.player.function;

import eti.mecka.franciszek.project.player.dto.GetPlayersResponse;
import eti.mecka.franciszek.project.player.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

/**
 * Coverts {@link List<Player>} to {@link GetPlayersResponse}.
 */
@Component
public class PlayersToResponseFunction implements Function<List<Player>, GetPlayersResponse> {

    @Override
    public GetPlayersResponse apply(List<Player> entities) {
        return GetPlayersResponse.builder()
                .players(entities.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .id(player.getId())
                                .firstName(player.getFirstName())
                                .lastName(player.getLastName())
                                .build())
                        .toList())
                .build();
    }
}
