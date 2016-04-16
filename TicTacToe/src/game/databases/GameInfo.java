package game.databases;

import java.io.Serializable;
import java.util.List;

public class GameInfo implements Serializable {
    private List<String> playersNames;
    private List<Integer> temporaryScore;
    private int moveCounter;

}
