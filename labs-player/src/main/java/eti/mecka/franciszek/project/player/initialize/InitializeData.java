package eti.mecka.franciszek.project.player.initialize;

import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.organization.service.api.OrganizationService;
import eti.mecka.franciszek.project.player.entity.Player;
import eti.mecka.franciszek.project.player.service.api.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final PlayerService playerService;

    private final OrganizationService organizationService;

    @Autowired
    public InitializeData(
            PlayerService playerService,
            OrganizationService organizationService
    ) {
        this.playerService = playerService;
        this.organizationService = organizationService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Organization team1 = Organization.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .build();

        Organization team2 = Organization.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .build();

        organizationService.create(team1);
        organizationService.create(team2);

        Player player1 = Player.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .firstName("Oshae")
                .lastName("Brissett")
                .nationality("Canada")
                .jerseyNumber(12)
                .age(25)
                .height(201)
                .weight(95)
                .dateOfBirth(LocalDate.of(1998, 6, 20))
                .organization(team1)
                .build();

        Player player2 = Player.builder()
                .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                .firstName("Jaylen")
                .lastName("Brown")
                .nationality("USA")
                .jerseyNumber(7)
                .age(26)
                .height(198)
                .weight(101)
                .dateOfBirth(LocalDate.of(1996, 10, 24))
                .organization(team1)
                .build();

        Player player3 = Player.builder()
                .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                .firstName("Anthony")
                .lastName("Davis")
                .nationality("USA")
                .jerseyNumber(3)
                .age(30)
                .height(208)
                .weight(115)
                .dateOfBirth(LocalDate.of(1993, 3, 11))
                .organization(team2)
                .build();

        playerService.create(player1);
        playerService.create(player2);
        playerService.create(player3);
    }
}
