package eti.mecka.franciszek.project.player.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrganizationResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Achievement {
        private UUID id;
        private String name;
        private LocalDate date;
    }

    private UUID id;
    private String name;
    private int dateOfEstablishment;

    @Singular
    private Map<LocalDate, Achievement> achievements;

}
