package eti.mecka.franciszek.project.player.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
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
    private UUID uuid;
    private String first_name;
    private String surname;
    private String nationality;
    private int jerseyNumber;
    private int age;
    private int height;
    private float weight;
    private int dateOfBirth;
    private int salary;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization")
    private Organization organization;

    @Override
    public int compareTo(Player o) {
        return this.salary - o.salary;
    }

}
