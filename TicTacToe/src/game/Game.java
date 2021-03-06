package game;

import game.entities.Player;
import game.enums.Symbols;
import game.factories.PlayerFactory;
import interfaces.GameInformation;
import interfaces.StatisticDatabase;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

import java.util.ArrayList;
import java.util.List;

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
    private StatisticDatabase statistic;
    private GameInformation gameInfo;
    private PlayerFactory playerFactory;
    private boolean isZeroIndexPlayerFirst;


    public Game(UserInterface userInterface, WinningDatabase winData, PlayerFactory playerFactory,
                StatisticDatabase statistic, GameInformation gameInfo){
        this.userInterface = userInterface;
        this.winData = winData;
        this.playerFactory = playerFactory;
        this.statistic = statistic;
        this.gameInfo = gameInfo;
        this.init();
    }

    @Override
    public void run() {
        this.userInterface.drawStartPage();
        String[] playerInput = this.userInterface.getPlayerTypeAndName(this);
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
                boolean isStartNewGame = userInterface.getAnswerForNewGame(this);
                if (isStartNewGame){
                    this.executePlayerChoiceForNewGame(true);
                }
            }
        } else {
            this.winData.saveData();
            this.statistic.saveStatistic(this.gameInfo.getInfo());
            this.userInterface.exitGame();
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

            if (doWeHaveWinner){
                this.userInterface.writeMassage("Winner : " + this.activePlayer.getName());
                this.activePlayer.setIsWinner(true);
                this.activePlayer.updatePoints();
                this.userInterface.drawGameInfo(this.gameInfo);
            } else {
                this.userInterface.writeMassage("Current game : equal result!");
                this.players[0].updatePoints();
                this.players[1].updatePoints();
            }

            this.userInterface.drawField(this.field);
        } else {
            this.activePlayerIndex++;
            this.activePlayerIndex %= 2;
            this.activePlayer = this.players[activePlayerIndex];
        }

        this.play();
    }

    public void executePlayerChoiceForNewGame(boolean playerChoice){
        if(playerChoice){
            this.isRunning = true;
            this.players[0].prepareForNewGame();
            this.players[1].prepareForNewGame();
            this.isZeroIndexPlayerFirst = !this.isZeroIndexPlayerFirst;
            this.activePlayerIndex = 1;
            if (this.isZeroIndexPlayerFirst){
                this.activePlayerIndex = 0;
            }

            this.activePlayer = this.players[this.activePlayerIndex];
            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[i].length; j++) {
                    this.field[i][j] = null;
                }
            }

        } else {
            this.isExitGame = true;
        }

        this.play();
    }

    public void setPlayerProperties(String[] properties){
        if (properties != null){
            Symbols firstPlayerSymbol = Symbols.O;
            Symbols secondPlayerSymbol = Symbols.X;
            if (properties[2].equals("X") && properties[5].equals("O")){
                firstPlayerSymbol = Symbols.X;
                secondPlayerSymbol = Symbols.O;
            }

            Player firstPlayer = this.playerFactory.createPlayer(properties[0], properties[1], firstPlayerSymbol, this);
            Player secondPlayer = this.playerFactory.createPlayer(properties[3], properties[4], secondPlayerSymbol, this);

            if (firstPlayer != null && secondPlayer != null){
                this.players[0] = firstPlayer;
                this.players[1] = secondPlayer;
                this.activePlayer = this.players[0];
                this.gameInfo.addPlayer(this.players[0]);
                this.gameInfo.addPlayer(this.players[1]);
                this.play();
            } else {
                this.userInterface.writeMassage("Incorrect input of player settings");
                this.userInterface.getPlayerTypeAndName(this);
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

    public Player getActivePlayer(){
        return this.activePlayer;
    }

    public List<List<String>> getStatistic(){
        List<List<String>> allStatisticForTwoPlayers = new ArrayList<>();
        for (int i = 0; i < this.players.length; i++) {
            allStatisticForTwoPlayers.add(this.statistic.getStatisticForPlayer(this.players[i].getName()));
        }

        return allStatisticForTwoPlayers;
    }

    private void init(){
        this.isExitGame = false;
        this.isRunning = true;
        this.isZeroIndexPlayerFirst = true;

        this.players = new Player[2];
        this.field = new Symbols[3][];
        this.field[0] = new Symbols[3];
        this.field[1] = new Symbols[3];
        this.field[2] = new Symbols[3];
    }

    private boolean validateForWin(){
        if ((this.field[0][0] == this.activePlayer.symbol) && (this.field[0][1] == this.activePlayer.symbol) && (this.field[0][2] == this.activePlayer.symbol) ||
                (this.field[1][0] == this.activePlayer.symbol) && (this.field[1][1] == this.activePlayer.symbol) && (this.field[1][2] == this.activePlayer.symbol) ||
                (this.field[2][0] == this.activePlayer.symbol) && (this.field[2][1] == this.activePlayer.symbol) && (this.field[2][2] == this.activePlayer.symbol) ||
                (this.field[0][0] == this.activePlayer.symbol) && (this.field[1][0] == this.activePlayer.symbol) && (this.field[2][0] == this.activePlayer.symbol) ||
                (this.field[0][1] == this.activePlayer.symbol) && (this.field[1][1] == this.activePlayer.symbol) && (this.field[2][1] == this.activePlayer.symbol) ||
                (this.field[0][2] == this.activePlayer.symbol) && (this.field[1][2] == this.activePlayer.symbol) && (this.field[2][2] == this.activePlayer.symbol) ||
                (this.field[0][0] == this.activePlayer.symbol) && (this.field[1][1] == this.activePlayer.symbol) && (this.field[2][2] == this.activePlayer.symbol) ||
                (this.field[0][2] == this.activePlayer.symbol) && (this.field[1][1] == this.activePlayer.symbol) && (this.field[2][0] == this.activePlayer.symbol)){
            return true;
        }

        return false;
    }

    private boolean isFieldFull(){
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                if (this.field[i][j] == null){
                    return false;
                }
            }
        }

        return true;
    }
}
