package interfaces;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.Symbols;

public interface UserInterface {
    int[] readPlayerMove(Player player);

    void notifyForPlayerMove(Player player, int[] moves);

    void drawField(Symbols[][] field);

    void drawStartPage();

    void drawGameInfo(GameInfo gameInfo);

    void drawStatistic(Statistic statistic);

    void writeMassage(String text);

    String[] getPlayerTypeAndName();

    boolean getAnswerForNewGame();
}
