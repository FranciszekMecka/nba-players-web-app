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

        // 1st task is creating the classes, n...1 relationship between them and creating DTO classes
        // 2nd task
        Organization organization1 = Organization.builder()
                .name("Chicago Bulls")
                .dateOfEstablishment(1966)
                .players(new ArrayList<>())
                .build();
        Player player1 = Player.builder()
                .name("Michael")
                .surname("Jordan")
                .nationality("United States")
                .id(23)
                .age(40)
                .height(195)
                .weight(90)
                .dateOfBirth(1975)
                .build();
        Player player2 = Player.builder()
                .name("Denis")
                .surname("Rodman")
                .nationality("United States")
                .id(69)
                .age(39)
                .height(195)
                .weight(95)
                .dateOfBirth(1977)
                .build();
        organization1.addPlayer(player1);
        organization1.addPlayer(player2);

        ArrayList<Organization> organizations = new ArrayList<>();
        organizations.add(organization1);

        // 3rd task
        organizations.forEach(organization -> {
            System.out.println(organization.toString());
            System.out.println("players {");
            organization.getPlayers().forEach(player -> System.out.println("\t" + player.toString()));
            System.out.println("}");
        });

        // 4th task
        Set<Player> allPlayers = organizations.stream()
                .flatMap(organization -> organization.getPlayers()
                        .stream())
                .collect(Collectors.toSet());

        Set<Player> filteredPlayers = allPlayers.stream().
                filter(player -> player.getAge() >= 40).collect(Collectors.toSet());

        System.out.println(allPlayers);
        System.out.println(filteredPlayers);

        // 5th task
        List<PlayerDTO> playerDTOS = allPlayers.stream()
                .map(player -> new PlayerDTO(player.getName(), player.getSurname(), player.getOrganization()))
                .sorted(Comparator.comparing(PlayerDTO::getName))
                .toList();

        playerDTOS.forEach(playerDTO -> {
            System.out.println(playerDTO.getName() + ", " + playerDTO.getSurname() + ", " + playerDTO.getOrganization());
        });

        // 6th task
        serializeOrganizationsToFile(organizations, "organizations.ser");
        List<Organization> deserializedOrganizations = deserializeOrganizationsFromFile("organizations.ser");

        deserializedOrganizations.forEach(organization -> {
            System.out.println(organization.getName());
            organization.getPlayers().forEach(System.out::println);
        });

        // 7th task
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