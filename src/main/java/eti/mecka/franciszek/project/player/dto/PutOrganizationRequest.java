package eti.mecka.franciszek.project.player.dto;

import eti.mecka.franciszek.project.player.entity.Player;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutOrganizationRequest {
    private String name;
    private int dateOfEstablishment;
    private List<Player> players;
}
