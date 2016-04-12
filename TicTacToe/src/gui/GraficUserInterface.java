package gui;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.GameSymbols;
import interfaces.UserInterface;

public class GraficUserInterface implements UserInterface {


    @Override
    public void readPlayerMove(Player player) {

    }

    @Override
    public void notifyForPlayerMove(Player player, int[] moves) {

    }

    @Override
    public void drawField(GameSymbols[][] field) {

    }

    @Override
    public void drawGameInfo(GameInfo gameInfo) {

    }

    @Override
    public void drawStatistic(Statistic statistic) {

    }

    @Override
    public void writeMassage(String text) {

    }

    @Override
    public String[] getPlayerTypeAndName() {
        return new String[0];
    }

    @Override
    public boolean getAnswerForNewGame() {
        return false;
    }
}
