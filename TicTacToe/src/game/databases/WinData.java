package game.databases;

import interfaces.DataReader;
import interfaces.DataWriter;
import interfaces.WinningDatabase;

import java.io.Serializable;
import java.util.*;

public class WinData implements WinningDatabase, Serializable {
    private Map<String, Map<Integer, List<Step>>> allData;
    private Map<String, Map<Integer, List<Step>>> allData2;
    private DataReader dataReader;
    private DataWriter dataWriter;

    public WinData(DataReader dataReader, DataWriter dataWriter){
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.dataReader.loadData(this);
    }

    public void addNewData(Step step){
        if (this.allData == null){
            this.allData = new HashMap<>();
        }

        if (!this.allData.containsKey(step.fieldAsStringBeforeMove)){
            this.allData.put(step.fieldAsStringBeforeMove, new TreeMap<>());
        }

        if (!this.allData.get(step.fieldAsStringBeforeMove).containsKey(step.numberOfMovesToWin)){
            this.allData.get(step.fieldAsStringBeforeMove).put(step.numberOfMovesToWin, new ArrayList<>());
        }

        List<Step> steps = this.allData.get(step.fieldAsStringBeforeMove).get(step.numberOfMovesToWin);
        boolean isNotRep = true;
        for (Step oldStep : steps) {
            if ((oldStep.currentMove[0] == step.currentMove[0]) && (oldStep.currentMove[0] == step.currentMove[0])){
                isNotRep = false;
                break;
            }
        }

        if (isNotRep){
            steps.add(step);
        }
    }

    @Override
    public Map<String, Map<Integer, List<Step>>> getData(){
        if (this.allData == null){
            this.allData = new HashMap<>();
        }

        return this.allData;
    }

    @Override
    public void setData(Map<String, Map<Integer, List<Step>>> data) {
        this.allData = data;
    }

    @Override
    public void saveData() {
        this.dataWriter.writeData(this);
    }


}
