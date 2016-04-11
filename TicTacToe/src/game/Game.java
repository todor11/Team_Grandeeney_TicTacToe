package game;


import game.enums.GameSymbols;
import interfaces.UserInterface;

public class Game implements Runnable{
    private UserInterface userInterface;
    private GameSymbols[][] field;

    public Game(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    @Override
    public void run() {

    }

    public synchronized void start(){

    }

    public synchronized void stop(){

    }

    private void init(){

    }

    private boolean isFieldFull(){
        return false;
        //TODO
    }
}
