package gui;

import game.entities.GameInfo;
import game.entities.Statistic;
import game.enums.GameSymbols;
import interfaces.UserInterface;

public class GraficUserInterface implements UserInterface {


    @Override
    public int[] read() {
        return new int[0];
    }

    @Override
    public String readText() {
        return null;
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
}
