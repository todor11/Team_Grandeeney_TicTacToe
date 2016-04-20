package game.databases;

import java.io.Serializable;

public class Step implements Serializable {
    public String fieldAsStringBeforeMove;
    public Step nextStep;
    public Step prevStep;
    public int[] currentMove;
    public int numberOfMovesToWin;

    public Step(String fieldAsStringBeforeMove){
        this.fieldAsStringBeforeMove = fieldAsStringBeforeMove;
        this.currentMove = new int[2];
        this.numberOfMovesToWin = -1;
    }
}
