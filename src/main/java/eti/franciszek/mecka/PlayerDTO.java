package eti.franciszek.mecka;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private String name;
    private String surname;
    private Organization organization;
}
