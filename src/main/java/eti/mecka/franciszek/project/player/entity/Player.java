package eti.mecka.franciszek.project.player.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String nationality;
    private int jerseyNumber;
    private int age;
    private int height;
    private float weight;
    private LocalDate dateOfBirth;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization")
    private Organization organization;

    @Override
    public int compareTo(Player o) {
        return this.age - o.age;
    }
}
