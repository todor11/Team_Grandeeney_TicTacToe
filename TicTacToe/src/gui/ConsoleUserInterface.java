package gui;

import game.Game;
import game.databases.GameInfo;
import game.entities.Player;
import game.databases.Statistic;
import game.enums.Symbols;
import interfaces.GameInformation;
import interfaces.StatisticDatabase;
import interfaces.UserInterface;

import java.util.Scanner;
import java.util.stream.Stream;


public class ConsoleUserInterface implements UserInterface {
    private Scanner console;
    private int counter;

    public ConsoleUserInterface(){
        this.console = new Scanner(System.in);
        this.counter = 0;
    }

    @Override
    public int[] readPlayerMove(Player player) {
        System.out.println("Please enter your next move (row col):");
        String text = this.console.nextLine();
        String[] line = text.split("\\s+");
        int[] moves = this.parseIntArray(line);

        return moves;
    }

    @Override
    public void notifyForPlayerMove(int[] moves) {
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
        System.out.println("Write type( Human or AI ), name and symbol ( X or O ) of the players separated by whitespace");
    }

    @Override
    public void drawGameInfo(GameInformation gameInfo) {

    }

    @Override
    public void drawStatistic(StatisticDatabase statistic) {

    }

    @Override
    public void writeMassage(String text) {
        System.out.println(text);
    }

    @Override
    public String[] getPlayerTypeAndName(Game game) {
        String[] playerInput = this.console.nextLine().split("\\s+");

        return playerInput;
    }

    @Override
    public boolean getAnswerForNewGame(Game game) {
        System.out.println("Do you want to start new game ? ( yes or no )");
        if (this.console.nextLine().equals("yes")){
            return true;
        } else {
            game.executePlayerChoiceForNewGame(false);
        }

        return false;

    }

    public void exitGame(){
        this.console.close();
    }

    private int[] parseIntArray(String[] arr) {
        return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
    }
}
