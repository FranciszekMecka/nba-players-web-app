package eti.mecka.franciszek.project.organization.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "organizations")
public class Organization implements Serializable {
    @Id
    private UUID id;
    private String name;

}
