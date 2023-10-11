package eti.franciszek.mecka;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Player  implements Comparable<Player>, Serializable {
    private String name;
    private String surname;
    private String nationality;
    private int jerseyNumber;
    private int age;
    private int height;
    private float weight;
    private int dateOfBirth;
    private int salary;
    @ToString.Exclude
    private Organization organization;

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, jerseyNumber, dateOfBirth);
    }

    @Override
    public int compareTo(Player o) {
        return this.salary - o.salary;
    }

}
