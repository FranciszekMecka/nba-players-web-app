package eti.mecka.franciszek.project.player.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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
//    private ArrayList<Player> players; having this field as array list crashes JPA(?) for some reason,
//    when PlayerService.findAllByOrganization() is called
    private List<Player> players; // this works and returns the collection as expected
}
