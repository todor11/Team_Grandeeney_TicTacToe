package game.factories;

import game.entities.AI;
import game.entities.Human;
import game.entities.Player;

public class PlayerFactory {
    public PlayerFactory(){

    }

    public Player createPlayer(String type, String name){
        switch (type){
            case "Human":
                return new Human(name);
            case "AI":
                return new AI();
        }

        return null;
    }
}
