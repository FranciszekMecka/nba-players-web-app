package eti.mecka.franciszek.project.player.entity;


import lombok.*;

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
