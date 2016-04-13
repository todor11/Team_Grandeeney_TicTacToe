package game;

import game.entities.GameInfo;
import game.entities.Player;
import game.entities.Statistic;
import game.enums.Symbols;
import game.factories.PlayerFactory;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public class Game implements Runnable{
    private UserInterface userInterface;
    private Symbols[][] field;
    private WinningDatabase winData;
    private Thread thread;
    private boolean isRunning;
    private boolean isExitGame;
    private Player[] players;
    private Player activePlayer;
    private int activePlayerIndex;
    private Statistic statistic;
    private GameInfo gameInfo;
    private PlayerFactory playerFactory;


    public Game(UserInterface userInterface, WinningDatabase winData, PlayerFactory playerFactory){
        this.userInterface = userInterface;
        this.winData = winData;
        this.playerFactory = playerFactory;
        this.init();
    }

    @Override
    public void run() {
        this.userInterface.drawStartPage();
        String[] playerInput = this.userInterface.getPlayerTypeAndName();
        if (playerInput != null){
            this.setPlayerProperties(playerInput);
        }
    }

    public void play(){
        if (!this.isExitGame){
            if (this.isRunning){
                this.userInterface.drawField(this.field);
                this.activePlayer.makeMove();
            } else {
                boolean isStartNewGame = userInterface.getAnswerForNewGame();
                if (isStartNewGame){
                    this.executePlayerChoiceForNewGame(true);
                }
            }
        } else {
            this.stop();
        }
    }

    public synchronized void start(){
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
        this.field[moves[0]][moves[1]] = this.activePlayer.symbol;
        boolean doWeHaveWinner = this.validateForWin();
        if (doWeHaveWinner || this.isFieldFull()){
            this.isRunning = false;
            this.userInterface.drawField(this.field);
            this.userInterface.writeMassage("Winner : " + this.activePlayer.getName());
            if (doWeHaveWinner){
                this.activePlayer.setIsWinner(true);
            }
        } else {
            this.activePlayerIndex++;
            this.activePlayerIndex %= 2;
            this.activePlayer = this.players[activePlayerIndex];
        }

        this.play();
    }

    public void executePlayerChoiceForNewGame(boolean playerChoice){
        if(playerChoice){
            //TODO
        }
    }

    public void setPlayerProperties(String[] properties){
        if (properties != null){
            Player firstPlayer = this.playerFactory.createPlayer(properties[0], properties[1], Symbols.O);
            Player secondPlayer = this.playerFactory.createPlayer(properties[2], properties[3], Symbols.X);

            if (firstPlayer != null && secondPlayer != null){
                this.players[0] = firstPlayer;
                this.players[1] = secondPlayer;
                this.activePlayer = this.players[0];
                this.play();
            } else {
                this.userInterface.writeMassage("Incorrect input of player settings");
                this.userInterface.getPlayerTypeAndName();
            }
        }
    }

    public Symbols[][] getField() {
        return this.field;
    }

    public UserInterface getUserInterface() {
        return this.userInterface;
    }

    public WinningDatabase getWinningData() {
        return this.winData;
    }

    private void init(){
        this.isExitGame = false;
        this.isRunning = true;

        this.players = new Player[2];
        this.field = new Symbols[3][];
        this.field[0] = new Symbols[3];
        this.field[1] = new Symbols[3];
        this.field[2] = new Symbols[3];

        this.playerFactory.setGame(this);
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
