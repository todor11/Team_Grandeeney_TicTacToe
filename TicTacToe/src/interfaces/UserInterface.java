package interfaces;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.GameSymbols;

public interface UserInterface {
    void readPlayerMove(Player player);

    void notifyForPlayerMove(Player player, int[] moves);

    void drawField(GameSymbols[][] field);

    void drawGameInfo(GameInfo gameInfo);

    void drawStatistic(Statistic statistic);

    void writeMassage(String text);
}
