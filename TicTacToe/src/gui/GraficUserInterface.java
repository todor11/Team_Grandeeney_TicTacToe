package gui;

import game.databases.GameInfo;
import game.entities.Player;
import game.databases.Statistic;
import game.enums.Symbols;
import interfaces.UserInterface;

public class GraficUserInterface implements UserInterface {


    @Override
    public int[] readPlayerMove(Player player) {
        return null;
    }

    @Override
    public void notifyForPlayerMove(Player player, int[] moves) {

    }

    @Override
    public void drawField(Symbols[][] field) {

    }

    @Override
    public void drawStartPage() {

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
    public void exitGame(){

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
