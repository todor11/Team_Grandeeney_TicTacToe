package gui;

import game.enums.GameSymbols;
import interfaces.UserInterface;

import java.util.Scanner;


public class ConsoleUserInterface implements UserInterface {
    private Scanner console;

    public ConsoleUserInterface(){
        this.console = new Scanner(System.in);
    }

    @Override
    public int[] read() {
        //TODO
        return new int[0];
    }

    @Override
    public String readText() {
        return console.nextLine();
    }

    @Override
    public void write(GameSymbols[][] field) {
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
    public void write(String text) {
        System.out.println(text);
    }
}
