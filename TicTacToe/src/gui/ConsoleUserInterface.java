package gui;

import game.Game;
import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.GameSymbols;
import interfaces.UserInterface;

import java.util.Scanner;
import java.util.stream.Stream;


public class ConsoleUserInterface implements UserInterface {
    private Scanner console;

    public ConsoleUserInterface(){
        this.console = new Scanner(System.in);
    }

    @Override
    public void readPlayerMove(Player player) {
        String text = this.console.nextLine();
        String[] line = text.split("\\s+");
        int[] moves = this.parseIntArray(line);
        this.notifyForPlayerMove(player, moves);
    }

    @Override
    public void notifyForPlayerMove(Player player, int[] moves) {
        //player.executeMove(moves);
    }

    @Override
    public void drawField(GameSymbols[][] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.println("-------");
            System.out.print("|");
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(field[i][j]);
                }

                System.out.print("|");
            }

            System.out.println();
        }

        System.out.println("-------");
    }

    @Override
    public void drawGameInfo(GameInfo gameInfo) {

    }

    @Override
    public void drawStatistic(Statistic statistic) {

    }

    @Override
    public void writeMassage(String text) {
        System.out.println(text);
    }

    @Override
    public String[] getPlayerTypeAndName() {
        //TODO
        return null;
    }

    @Override
    public boolean getAnswerForNewGame() {
        //TODO
        return false;
    }

    private int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }
}
