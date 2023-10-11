package eti.franciszek.mecka;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    private static void serializeOrganizationsToFile(List<Organization> organizations, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(organizations);
            System.out.println("Organizations serialized and saved to " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Organization> deserializeOrganizationsFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Organization> organizations = (List<Organization>) inputStream.readObject();
            System.out.println("Categories deserialized from " + fileName);
            return organizations;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        // 1st task, is creating classes, n...1 relationships between them and creating DTO classes

        // 2nd task, creating objects and printing them out using forEach
        Organization organization1 = Organization.builder()
                .name("Los Angeles Lakers")
                .dateOfEstablishment(1947)
                .players(new ArrayList<>())
                .build();
        Organization organization2 = Organization.builder()
                .name("Boston Celtics")
                .dateOfEstablishment(1946)
                .players(new ArrayList<>())
                .build();
        Player player1 = Player.builder()
                .name("Lebron")
                .surname("James")
                .nationality("USA")
                .jerseyNumber(23)
                .age(38)
                .height(206)
                .weight(113)
                .dateOfBirth(1984)
                .salary(7500000)
                .build();
        Player player2 = Player.builder()
                .name("Anthony")
                .surname("Davis")
                .nationality("USA")
                .jerseyNumber(3)
                .age(30)
                .height(208)
                .weight(115)
                .dateOfBirth(1993)
                .salary(2500000)
                .build();
        Player player3 = Player.builder()
                .name("Jaylen")
                .surname("Brown")
                .nationality("USA")
                .jerseyNumber(7)
                .age(26)
                .height(198)
                .weight(101)
                .dateOfBirth(1996)
                .salary(4000000)
                .build();
        Player player4 = Player.builder()
                .name("Dalano")
                .surname("Banton")
                .nationality("USA")
                .jerseyNumber(45)
                .age(23)
                .height(201)
                .weight(93)
                .dateOfBirth(1999)
                .salary(5500000)
                .build();

        organization1.addPlayer(player1);
        organization1.addPlayer(player2);
        organization2.addPlayer(player3);
        organization2.addPlayer(player4);

        ArrayList<Organization> organizations = new ArrayList<>();
        organizations.add(organization1);
        organizations.add(organization2);

        System.out.println("\nSecond task:");
        organizations.forEach(organization -> {
            System.out.println(organization.toString());
            System.out.println("players {");
            organization.getPlayers().forEach(player -> System.out.println("\t" + player.toString()));
            System.out.println("}");
        });

        // 3rd task
        System.out.println("\nThird task:");
        Set<Player> allPlayers = organizations.stream()
                .flatMap(organization -> organization.getPlayers().stream())
                .collect(Collectors.toSet());

        allPlayers.forEach(System.out::println);

        // 4th task
        System.out.println("Forth task:");
        Set<Player> filteredPlayers = allPlayers.stream()
                .filter(player -> player.getAge() >= 40)
                .collect(Collectors.toSet());

        filteredPlayers.forEach(System.out::println);

        // 5th task
        System.out.println("\nFifth task:");

        List<PlayerDTO> playerDTOS = allPlayers.stream()
                .map(player -> new PlayerDTO(player.getJerseyNumber(), player.getName(), player.getSurname(), player.getAge(), player.getOrganization()))
                .sorted(Comparator.comparing(PlayerDTO::getAge))
                .toList();

        playerDTOS.forEach(playerDTO -> {
            System.out.println(playerDTO.getName() + ", "
                    + playerDTO.getSurname() + ", "
                    + playerDTO.getOrganization() + ", "
                    + playerDTO.getAge());
        });

        // 6th task
        System.out.println("\nSixth task:");

        serializeOrganizationsToFile(organizations, "organizations.ser");
        List<Organization> deserializedOrganizations = deserializeOrganizationsFromFile("organizations.ser");

        deserializedOrganizations.forEach(organization -> {
            System.out.println(organization.getName());
            organization.getPlayers().forEach(System.out::println);
        });

        // 7th task
        System.out.println("\nSeventh task:");

        ForkJoinPool myThreadPool = new ForkJoinPool(2);
        organizations.parallelStream().forEach(organization -> {
            try {
                organization.customTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        myThreadPool.shutdown();
    }
}