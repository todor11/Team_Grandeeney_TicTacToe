package game.databases;

import java.io.Serializable;
import java.util.List;

public class GameInfo implements Serializable {
    private List<String> playersNames;
    private List<Integer> temporaryScore;
    private int moveCounter;

    public void update(Player player) {
        player.updatePoints();
    }

    public String getInfo() {
        String info = String.Format("%s - $d ; %s -  %d",
                playersNames.get(0), temporaryScore.get(0), playersNames.get(1), temporaryScore.get(1));
        return info;
    }

    public void addPlayer(String name) {
        playersNames.add(name);
    }

}
