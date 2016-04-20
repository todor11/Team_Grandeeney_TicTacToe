package game.databases;

import game.entities.Player;
import interfaces.GameInformation;

import java.io.Serializable;
import java.util.List;


public class GameInfo implements GameInformation, Serializable {
    private List<Player> players;

    public String getInfo() {
        String info = String.format("%s : %s",
                players.get(0).toString(), players.get(1).toString());
        return info;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
