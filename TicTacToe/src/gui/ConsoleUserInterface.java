package gui;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.Symbols;
import interfaces.UserInterface;

import java.util.Scanner;
import java.util.stream.Stream;


public class ConsoleUserInterface implements UserInterface {
    private Scanner console;

    public ConsoleUserInterface(){
        this.console = new Scanner(System.in);
    }

    @Override
    public int[] readPlayerMove(Player player) {
        String text = this.console.nextLine();
        String[] line = text.split("\\s+");
        int[] moves = this.parseIntArray(line);

        return moves;
    }

    @Override
    public void notifyForPlayerMove(Player player, int[] moves) {
    }

    @Override
    public void drawField(Symbols[][] field) {
        System.out.println("=======");
        for (int i = 0; i < field.length; i++) {
            if (i != 0){
                System.out.println("-------");
            }
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

        System.out.println("=======");
    }

    @Override
    public void drawStartPage() {
        System.out.println("Write type and name of the players separated by whitespace");
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
        String[] playerInput = this.console.nextLine().split("\\s+");

        return playerInput;
    }

    @Override
    public boolean getAnswerForNewGame() {
        System.out.println("Do you want to start new game ?");
        if (this.console.nextLine().equals("yes")){
            return true;
        }

        return false;
    }

    private int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }
}
