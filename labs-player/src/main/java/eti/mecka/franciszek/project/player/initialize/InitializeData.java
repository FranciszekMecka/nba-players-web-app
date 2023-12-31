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

        Organization team3 = Organization.builder()
                .id(UUID.fromString("ba7f61b8-cc87-4dcd-9898-3fc70c35139e"))
                .build();

        organizationService.create(team1);
        organizationService.create(team2);
        organizationService.create(team3);

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

        Player player4 = Player.builder()
                .id(UUID.randomUUID())  // You can generate a new UUID for each player
                .firstName("LeBron")
                .lastName("James")
                .nationality("USA")
                .jerseyNumber(23)
                .age(37)
                .height(206)
                .weight(113)
                .dateOfBirth(LocalDate.of(1984, 12, 30))
                .organization(team2)
                .build();

        Player player5 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Russell")
                .lastName("Westbrook")
                .nationality("USA")
                .jerseyNumber(0)
                .age(33)
                .height(191)
                .weight(91)
                .dateOfBirth(LocalDate.of(1988, 11, 12))
                .organization(team2)
                .build();

        Player player6 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Jayson")
                .lastName("Tatum")
                .nationality("USA")
                .jerseyNumber(0)
                .age(23)
                .height(203)
                .weight(93)
                .dateOfBirth(LocalDate.of(1998, 3, 3))
                .organization(team1)
                .build();

        Player player7 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Jaylen")
                .lastName("Brown")
                .nationality("USA")
                .jerseyNumber(7)
                .age(25)
                .height(198)
                .weight(102)
                .dateOfBirth(LocalDate.of(1996, 10, 24))
                .organization(team1)
                .build();

        Player player8 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Jimmy")
                .lastName("Butler")
                .nationality("USA")
                .jerseyNumber(22)
                .age(32)
                .height(201)
                .weight(103)
                .dateOfBirth(LocalDate.of(1989, 9, 14))
                .organization(team3)
                .build();

        Player player9 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Bam")
                .lastName("Adebayo")
                .nationality("USA")
                .jerseyNumber(13)
                .age(24)
                .height(208)
                .weight(115)
                .dateOfBirth(LocalDate.of(1997, 7, 18))
                .organization(team3)
                .build();

        Player player10 = Player.builder()
                .id(UUID.randomUUID())
                .firstName("Tyler")
                .lastName("Herro")
                .nationality("USA")
                .jerseyNumber(14)
                .age(21)
                .height(196)
                .weight(88)
                .dateOfBirth(LocalDate.of(2000, 1, 20))
                .organization(team3)
                .build();

        playerService.create(player1);
        playerService.create(player2);
        playerService.create(player3);
        playerService.create(player4);
        playerService.create(player5);
        playerService.create(player6);
        playerService.create(player7);
        playerService.create(player8);
        playerService.create(player9);
        playerService.create(player10);

    }
}
