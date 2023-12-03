package eti.mecka.franciszek.project.organization.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchOrganizationRequest {
    private String name;
    private LocalDate DateOfEstablishment;
}