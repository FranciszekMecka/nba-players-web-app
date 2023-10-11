package eti.franciszek.mecka;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Organization implements Serializable {
    private String name;
    private int dateOfEstablishment;
    private ArrayList<Player> players;

    public void addPlayer(Player o) {
        if (!players.contains(o)) {
            players.add(o);
            o.setOrganization(this);
        }
    }

    @Override
    public String toString() {
        return name + ", " + dateOfEstablishment;
    }

    public void customTask() throws InterruptedException {
        System.out.println("Task started in organization: " + name);
        players.forEach(System.out::println);
        Thread.sleep(1000);
        System.out.println("Task ended in organization: " + name);
    }
}
