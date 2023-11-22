package eti.mecka.franciszek.project.player.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchOrganizationRequest {

    private String name;
    private int dateOfEstablishment;

}
