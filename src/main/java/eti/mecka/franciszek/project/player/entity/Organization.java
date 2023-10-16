package eti.mecka.franciszek.project.player.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "organizations")
public class Organization implements Serializable {
    @Id
    private UUID id;
    private String name;
    private int dateOfEstablishment;
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private ArrayList<Player> players;

    public void addPlayer(Player o) {
        if (!players.contains(o)) {
            players.add(o);
            o.setOrganization(this);
        }
    }
}
