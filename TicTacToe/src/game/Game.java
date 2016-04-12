package game;


import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
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
    private Statistic statistic;
    private GameInfo gameInfo;

    public Game(UserInterface userInterface, WinningDatabase winData){
        this.userInterface = userInterface;
        this.winData = winData;
        this.init();
    }

    @Override
    public void run() {
        //TODO

        if (!this.isExitGame){
            if (this.isRunning){
                //this.activePlayer.makeYourMove();
            } else {
                //TODO
            }
        } else {
            this.stop();
        }
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

    public void executePlayerMove(int[] moves){
        //this.field[moves[0]][moves[1]] = this.activePlayer.symbol;

        this.userInterface.drawField(this.field);
        //TODO
        //notify GUI
        //

        if (this.validateForWin()){
            this.isRunning = false;
            //notify GUI
            //notify player
            //TODO
        } else {
            this.activePlayerIndex++;
            this.activePlayerIndex %= 2;
            this.activePlayer = this.players[activePlayerIndex];
            //TODO
        }

        this.run();
    }

    private void init(){
        this.isExitGame = false;
        this.players = new Player[2];
        this.field = new GameSymbols[3][];
        this.field[0] = new GameSymbols[3];
        this.field[1] = new GameSymbols[3];
        this.field[2] = new GameSymbols[3];

    }

    private boolean validateForWin(){
        //TODO
        return false;
    }

    private boolean isFieldFull(){
        return false;
        //TODO
    }
}
