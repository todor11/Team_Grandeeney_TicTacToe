package interfaces;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.Symbols;

public interface UserInterface {
    void readPlayerMove(Player player);

    void notifyForPlayerMove(Player player, int[] moves);

    void drawField(Symbols[][] field);

    void drawGameInfo(GameInfo gameInfo);

    void drawStatistic(Statistic statistic);

    void writeMassage(String text);

    String[] getPlayerTypeAndName();

    boolean getAnswerForNewGame();
}
