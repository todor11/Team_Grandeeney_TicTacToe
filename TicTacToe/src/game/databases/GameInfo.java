package game.databases;

import java.io.Serializable;
import java.util.List;

public class GameInfo implements Serializable {
    private List<Player> players;

    public void update(Player player) {
        player.updatePoints();
    }

    public String getInfo() {
        String info = String.Format("%s : %s",
                players.get(0).toString(), players.get(1).toString());
        return info;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
