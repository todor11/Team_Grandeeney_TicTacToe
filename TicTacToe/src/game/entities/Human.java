package game.entities;

import game.Game;
import game.enums.Symbols;

public class Human extends Player {

    public Human(String name, Symbols symbol, Game game) {
        super(name, symbol, game);

    }

    @Override
    public void makeMove() {
        int[] moves = this.userInterface.readPlayerMove(this);
        if (moves != null){
            this.executeMove(moves);
        }
    }
}
