package game.entities;

import game.Game;
import game.databases.Step;
import game.enums.Symbols;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public abstract class Player {
    public Symbols symbol;
    protected Symbols[][] field;
    protected Game game;
    protected UserInterface userInterface;
    protected WinningDatabase winningData;
    private String name;
    private Step lastStep;
    private boolean isWinner;

    public Player(String name, Symbols symbol, Game game){
        this.name = name;
        this.symbol = symbol;
        this.game = game;
        this.field = this.game.getField();
        this.userInterface = this.game.getUserInterface();
        this.winningData = this.game.getWinningData();
        this.isWinner = false;
    }

    public abstract void makeMove();

    public void executeMove(int[] moves){
        this.saveMove();
        this.game.executePlayerMove(moves);
    }

    public boolean getIsWinner(){
        return this.isWinner;
    }

    public void setIsWinner(boolean isWin){
        if (isWin){
            this.isWinner = true;
            this.saveWinningMovesToDataBase();
        }
    }

    public void prepareForNewGame(){
        this.lastStep = null;
        this.isWinner = false;
    }

    protected String createFieldAsString(Symbols[][] matrix){
        StringBuilder fieldAsString = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null){
                    fieldAsString.append(0);
                } else if (matrix[i][j] == this.symbol){
                    fieldAsString.append(1);
                } else {
                    fieldAsString.append(2);
                }
            }
        }

        return fieldAsString.toString();
    }

    private void saveMove(){
        if (this.lastStep == null){
            StringBuilder newFieldAsStringBeforeMove = new StringBuilder();
            int[] move = new int[2];
            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[i].length; j++) {
                    if (this.field[i][j] == null){
                        newFieldAsStringBeforeMove.append(0);
                    } else if (this.field[i][j] == this.symbol){
                        newFieldAsStringBeforeMove.append(0);
                        move[0] = i;
                        move[1] = j;
                    } else {
                        newFieldAsStringBeforeMove.append(2);
                    }
                }
            }
            Step newStep = new Step(newFieldAsStringBeforeMove.toString());
            this.lastStep = newStep;
            this.lastStep.currentMove = move;
            this.lastStep.matrix = this.cloneMatrix(this.field);
        } else {
            String fieldAsString = this.createFieldAsString(this.lastStep.matrix);
            Step newStep = new Step(fieldAsString);
            newStep.prevStep = this.lastStep;
            this.lastStep.nextStep = newStep;
            this.lastStep = newStep;
            String prevField = this.lastStep.fieldAsStringBeforeMove;
            String nextField = this.createFieldAsString(this.field);
            int row = 0;
            int col = 0;
            for (int i = 0; i < this.lastStep.prevStep.fieldAsStringBeforeMove.length(); i++) {
                if (prevField.charAt(i) != nextField.charAt(i)){
                    row = i / this.field[0].length;
                    col = i % this.field[0].length;
                }
            }

            this.lastStep.currentMove[0] = row;
            this.lastStep.currentMove[1] = col;
            this.lastStep.matrix = this.cloneMatrix(this.field);
        }
    }

    private void saveWinningMovesToDataBase(){
        this.lastStep.prevStep.prevStep.numberOfMovesToWin = 2;
        this.lastStep.prevStep.numberOfMovesToWin = 1;
        this.lastStep.numberOfMovesToWin = 0;

        this.winningData.addNewData(this.lastStep.prevStep.prevStep);
        this.winningData.addNewData(this.lastStep.prevStep);
        this.winningData.addNewData(this.lastStep);
    }

    protected boolean checkForWinner(Symbols[][] tempMatrix, Symbols currentSimbol){
        if ((tempMatrix[0][0] == currentSimbol) && (tempMatrix[0][1] == currentSimbol) && (tempMatrix[0][2] == currentSimbol) ||
                (tempMatrix[1][0] == currentSimbol) && (tempMatrix[1][1] == currentSimbol) && (tempMatrix[1][2] == currentSimbol) ||
                (tempMatrix[2][0] == currentSimbol) && (tempMatrix[2][1] == currentSimbol) && (tempMatrix[2][2] == currentSimbol) ||
                (tempMatrix[0][0] == currentSimbol) && (tempMatrix[1][0] == currentSimbol) && (tempMatrix[2][0] == currentSimbol) ||
                (tempMatrix[0][1] == currentSimbol) && (tempMatrix[1][1] == currentSimbol) && (tempMatrix[2][1] == currentSimbol) ||
                (tempMatrix[0][2] == currentSimbol) && (tempMatrix[1][2] == currentSimbol) && (tempMatrix[2][2] == currentSimbol) ||
                (tempMatrix[0][0] == currentSimbol) && (tempMatrix[1][1] == currentSimbol) && (tempMatrix[2][2] == currentSimbol) ||
                (tempMatrix[0][2] == currentSimbol) && (tempMatrix[1][1] == currentSimbol) && (tempMatrix[2][0] == currentSimbol)){
            return true;
        }

        return false;
    }

    private Symbols[][] cloneMatrix(Symbols[][] matrix){
        Symbols[][] newMatrix = new Symbols[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new Symbols[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public String getName() {
        return name;
    }
}
