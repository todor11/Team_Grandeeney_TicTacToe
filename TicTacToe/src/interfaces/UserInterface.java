package interfaces;

import game.Game;
import game.databases.GameInfo;
import game.entities.Player;
import game.databases.Statistic;
import game.enums.Symbols;

public interface UserInterface {
    int[] readPlayerMove(Player player);

    void notifyForPlayerMove(int[] moves);

    void drawField(Symbols[][] field);

    void drawStartPage();

    void drawGameInfo(GameInfo gameInfo);

    void drawStatistic(Statistic statistic);

    void writeMassage(String text);

    String[] getPlayerTypeAndName(Game game);

    boolean getAnswerForNewGame();

    void exitGame();
}
