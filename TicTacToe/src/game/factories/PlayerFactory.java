package game.factories;

import game.Game;
import game.entities.AI;
import game.entities.Human;
import game.entities.Player;
import game.enums.Symbols;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public class PlayerFactory {

    public PlayerFactory(){

    }

    public Player createPlayer(String type, String name, Symbols symbol, Game game){
        switch (type){
            case "Human":
                return new Human(name, symbol, game);
            case "AI":
                return new AI(symbol, game);
        }

        return null;
    }
}
