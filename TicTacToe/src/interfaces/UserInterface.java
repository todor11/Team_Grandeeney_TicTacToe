package interfaces;

import game.entities.GameInfo;
import game.entities.Statistic;
import game.enums.GameSymbols;

public interface UserInterface {
    int[] read();

    String readText();

    void drawField(GameSymbols[][] field);

    void drawGameInfo(GameInfo gameInfo);

    void drawStatistic(Statistic statistic);

    void writeMassage(String text);
}
