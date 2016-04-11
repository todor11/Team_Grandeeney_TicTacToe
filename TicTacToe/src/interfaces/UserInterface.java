package interfaces;

import game.enums.GameSymbols;

public interface UserInterface {
    int[] read();

    String readText();

    void write(GameSymbols[][] field);

    void write(String text);
}
