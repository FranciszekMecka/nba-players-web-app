package eti.mecka.franciszek.project.cmd;

import eti.mecka.franciszek.project.player.entity.Organization;
import eti.mecka.franciszek.project.player.entity.Player;
import eti.mecka.franciszek.project.player.service.api.OrganizationService;
import eti.mecka.franciszek.project.player.service.api.PlayerService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final PlayerService playerService;
    private final OrganizationService organizationService;

    public ApplicationCommand(PlayerService playerService, OrganizationService organizationService) {
        this.playerService = playerService;
        this.organizationService = organizationService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Type in 'help' to see the command list.");
        main_loop: while (true) {

            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("""
                            Available commands:
                            'get_players' - prints out all the players
                            'get_organizations' - prints out all organizations
                            'get_organization_players' - prints out all players from given organization
                            'get_player' - prints out a specific player that matches UUID from the user input
                            'delete_player' - deletes a player that has given UUID
                            'put_player' - creates a player from user input
                            'quit' - closes the application""");
                }
                case "get_players" -> {
                    playerService.findAll().forEach(System.out::println);
                }
                case "get_organization_players" -> {
                    System.out.println("Input Organization's UUID:");
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        playerService.findAllByOrganization(uuid).ifPresent(System.out::println);
                    } catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_player" -> {
                    System.out.println("Input UUID of the player:");
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        playerService.find(uuid).ifPresent(System.out::println);
                    } catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "delete_player" -> {
                    try {
                        System.out.println("Input UUID of the player that you want to delete:");
                        UUID uuid = UUID.fromString(scanner.next());
                        playerService.delete(uuid);
                    } catch (NoSuchElementException ex){
                        System.out.println("NOT_FOUND");
                    }
                }
                case "put_player" -> {
                    try {
                        System.out.println("Choose one of the organizations, type in the UUID of the desired one.");
                        organizationService.findAll().forEach(System.out::println);
                        Optional<Organization> organization = organizationService.find(UUID.fromString(scanner.next()));
                        System.out.println("Input arguments in order:\n" +
                                " id\n" +
                                "first_name\n" +
                                "surname\n" +
                                "nationality\n" +
                                "jerseyNumber\n" +
                                "age\n" +
                                "height\n" +
                                "weight\n" +
                                "dateOfBirth (yyyy-mm-dd");
                        Player player = Player.builder()
                                .id(UUID.fromString(scanner.next()))
                                .first_name(scanner.next())
                                .surname(scanner.next())
                                .nationality(scanner.next())
                                .jerseyNumber(scanner.nextInt())
                                .age(scanner.nextInt())
                                .height(scanner.nextInt())
                                .weight(scanner.nextFloat())
                                .dateOfBirth(LocalDate.parse(scanner.next()))
//                                .dateOfBirth(LocalDate.of(2000, 12, 31))
                                .organization(organization.get())
                                .build();
                        playerService.create(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Bad Request");
                    }
                }
                case "get_organizations" -> {
                    organizationService.findAll().forEach(System.out::println);
                }
                case "quit" -> {
                    System.out.println("Closing application");
                    System.exit(0);
                    break main_loop;
                }
            }
        }
    }
}

