package game.entities;

import game.Game;
import game.databases.Step;
import game.enums.Symbols;

import java.util.*;

public class AI extends Player {
    private static final String compName = "Computer";

    private Random random;
    private int[] move;

    public AI(Symbols symbol, Game game) {
        super(compName, symbol, game);
        this.random = new Random();
    }

    @Override
    public void makeMove() {
        this.move = null;
        Map<String, TreeMap<Integer, List<Step>>> data = this.winningData.getData();
        String currentFieldAsString = this.createFieldAsString(this.field);
        String enemyFieldAsString = this.getEnemyField(currentFieldAsString);

        //get win from database
        boolean f = data.containsKey(currentFieldAsString);
        if (data.containsKey(currentFieldAsString) && data.get(currentFieldAsString).containsKey(0)){
            if (data.get(currentFieldAsString).get(0).size() > 0){
                this.move = data.get(currentFieldAsString).get(0).get(0).currentMove;
            }
        }

        //get win by checking now
        if (this.move == null){
            this.move = this.getNewOneStepWin(this.field);
        }

        //check enemy for win in data and block
        boolean f2 = data.containsKey(enemyFieldAsString);
        if (this.move == null && data.containsKey(enemyFieldAsString) && data.get(enemyFieldAsString).containsKey(0)){
            if (data.get(enemyFieldAsString).get(0).size() > 0){
                this.move = data.get(enemyFieldAsString).get(0).get(0).currentMove;
            }
        }

        //check enemy for win and block
        if (this.move == null){
            this.move = this.getNewOneStepWin(this.changeRoleInMatrix(this.field));
        }

        //check data for best move
        if (this.move == null && data.containsKey(currentFieldAsString)){
            List<Step> bestSteps = data.get(currentFieldAsString).firstEntry().getValue();
            int numberOfBestStepsToWin = data.get(currentFieldAsString).firstEntry().getKey();
            if (numberOfBestStepsToWin == 1){
                for (int i = 0; i < bestSteps.size(); i++) {
                    String nextBestField = bestSteps.get(i).nextStep.fieldAsStringBeforeMove;
                    if (data.containsKey(nextBestField) && data.get(nextBestField).containsKey(0) &&
                            data.get(nextBestField).get(0).size() > 1){
                        this.move = data.get(currentFieldAsString).get(1).get(i).currentMove;
                    }
                }
            }
        }

        // get random move
        if (this.move == null){
            this.move = getRandomMove();
        }

        this.executeMove(this.move);
    }

    private int[] getRandomMove(){
        List<int[]> posibleMoves = new ArrayList<>();
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                if (this.field[i][j] == null){
                    int[] newMoves = new int[2];
                    newMoves[0] = i;
                    newMoves[1] = j;
                    posibleMoves.add(newMoves);
                }
            }
        }

        int randomIndex = this.random.nextInt(posibleMoves.size());

        return posibleMoves.get(randomIndex);
    }

    private String getEnemyField(String myField){
        String enemyField = myField.replaceAll("1", "3").replaceAll("2", "1").replaceAll("3", "2");

        return enemyField;
    }

    private int[] getNewOneStepWin(Symbols[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null){
                    Symbols[][] testField = this.cloneMatrix(matrix);
                    testField[i][j] = this.symbol;
                    if (this.checkForWinner(testField, this.symbol)){
                        int[] result = new int[2];
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }

        return null;
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

    private Symbols[][] changeRoleInMatrix(Symbols[][] matrix){
        Symbols[][] newMatrix = new Symbols[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new Symbols[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != null){
                    newMatrix[i][j] = Symbols.O;
                    if (matrix[i][j] == Symbols.O){
                        newMatrix[i][j] = Symbols.X;
                    }
                }
            }
        }

        return newMatrix;
    }
}
