package eti.franciszek.mecka;

import lombok.*;

import java.util.Comparator;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlayerDTO {
    private Integer jerseyNumber;
    private String name;
    private String surname;
    private Integer age;
    @ToString.Exclude
    private Organization organization;

}
