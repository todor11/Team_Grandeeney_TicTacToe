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

    void drawGameInfo(GameInformation gameInfo);

    void drawStatistic(StatisticDatabase statistic);

    void writeMassage(String text);

    String[] getPlayerTypeAndName(Game game);

    boolean getAnswerForNewGame(Game game);

    void exitGame();
}
