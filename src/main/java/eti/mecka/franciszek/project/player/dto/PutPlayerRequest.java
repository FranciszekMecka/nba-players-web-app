package eti.mecka.franciszek.project.player.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutPlayerRequest {
    private String firstName;
    private String surname;
    private String nationality;
    private int jerseyNumber;
    private int age;
    private int height;
    private float weight;
    private LocalDate dateOfBirth;
    private UUID organization;
}
