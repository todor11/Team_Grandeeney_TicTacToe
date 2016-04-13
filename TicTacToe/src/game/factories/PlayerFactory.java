package game.factories;

import game.Game;
import game.entities.AI;
import game.entities.Human;
import game.entities.Player;
import game.enums.Symbols;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public class PlayerFactory {
    private Game game;

    public PlayerFactory(){

    }

    public Player createPlayer(String type, String name, Symbols symbol){
        switch (type){
            case "Human":
                return new Human(name, symbol, this.game);
            case "AI":
                return new AI(symbol, this.game);
        }

        return null;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
