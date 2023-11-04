package eti.mecka.franciszek.project.player.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchPlayerRequest {
    private String firstName;
    private String lastName;
    private int age;
    private int jerseyNumber;
}
