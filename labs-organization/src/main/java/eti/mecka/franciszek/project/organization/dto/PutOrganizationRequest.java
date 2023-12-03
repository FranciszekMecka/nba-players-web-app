package eti.mecka.franciszek.project.organization.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutOrganizationRequest {
    private String name;
    private LocalDate DateOfEstablishment;
}
