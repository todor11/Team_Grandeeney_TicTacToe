package game;


import game.entities.Player;
import game.enums.GameSymbols;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public class Game implements Runnable{
    private UserInterface userInterface;
    private GameSymbols[][] field;
    private WinningDatabase winData;
    private Thread thread;
    private boolean isRunning;
    private boolean isExitGame;
    private Player[] players;
    private Player activePlayer;
    private int activePlayerIndex;

    public Game(UserInterface userInterface, WinningDatabase winData){
        this.userInterface = userInterface;
        this.winData = winData;
        this.init();
    }

    @Override
    public void run() {
        //TODO

        while (!this.isExitGame){
            while (this.isRunning){
                //TODO


            }
        }

        this.stop();
    }

    public synchronized void start(){
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop(){
        try {
            this.thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void init(){
        this.isExitGame = false;
        this.players = new Player[2];
        this.field = new GameSymbols[3][];
        this.field[0] = new GameSymbols[3];
        this.field[1] = new GameSymbols[3];
        this.field[2] = new GameSymbols[3];
    }

    private boolean isFieldFull(){
        return false;
        //TODO
    }
}
