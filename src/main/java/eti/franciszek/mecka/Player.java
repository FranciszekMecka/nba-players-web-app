package eti.franciszek.mecka;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Player  implements Comparable<Player>, Serializable {
    private String name;
    private String surname;
    private String nationality;
    private int id;
    private int age;
    private int height;
    private float weight;
    private int dateOfBirth;
    private int salary;
    private Organization organization;

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, dateOfBirth);
    }

    @Override
    public int compareTo(Player o) {
        return this.salary - o.salary;
    }

    @Override
    public String toString() {
        return "Player(" +
                "name=" + name + ", " +
                "surname=" + surname + ", " +
                "id=" + id +
                ")";
    }
}
