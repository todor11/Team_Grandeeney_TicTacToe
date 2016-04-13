package game.entities;

import game.Game;
import game.databases.Step;
import game.enums.Symbols;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AI extends Player {
    private static final String compName = "Computer";

    private Random random;

    public AI(Symbols symbol, Game game) {
        super(compName, symbol, game);
        this.random = new Random();
    }

    @Override
    public void makeMove() {
        int[] moves = new int[2];
        Map<String, Map<Integer, List<Step>>> data = this.winningData.getData();
        String currentFieldAsString = this.createFieldAsString(this.field);
        String enemyFieldAsString = this.getEnemyField(currentFieldAsString);

        //get win from database
        if (data.containsKey(currentFieldAsString) && data.get(currentFieldAsString).containsKey(0)){
            if (data.get(currentFieldAsString).get(0).size() > 0){
                moves = data.get(currentFieldAsString).get(0).get(0).currentMove;
                this.executeMove(moves);
                return;
            }
        }

        //get win by checking now
        int[] winMove = this.getNewOneStepWin(this.field);
        if (winMove != null){
            this.executeMove(winMove);
            return;
        }

        //check enemy for win in data and block
        if (data.containsKey(enemyFieldAsString) && data.get(enemyFieldAsString).containsKey(0)){
            if (data.get(enemyFieldAsString).get(0).size() > 0){
                moves = data.get(enemyFieldAsString).get(0).get(0).currentMove;
                this.executeMove(moves);
                return;
            }
        }

        //check enemy for win and block
        int[] winEnemyMove = this.getNewOneStepWin(this.changeRoleInMatrix(this.field));
        if (winEnemyMove != null){
            this.executeMove(winEnemyMove);
            return;
        }

        //check data for best move


        // get random move
        moves = getRandomMove();
        this.executeMove(moves);
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
