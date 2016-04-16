package game.databases;

import interfaces.DataReader;
import interfaces.DataWriter;
import interfaces.StatisticDatabase;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Statistic implements StatisticDatabase, Serializable {
    private Map<String, List<Integer>> statistic;
    private DataReader dataReader;
    private DataWriter dataWriter;

    public Statistic(DataReader dataReader, DataWriter dataWriter){
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.dataReader.loadStatistic(this);
    }


    @Override
    public void addStatistic(GameInfo gameInfo) {
        //TODO
    }

    @Override
    public Map<String, List<Integer>> getStatistic() {
        //TODO
        return null;
    }

    @Override
    public void setStatistic(Map<String, List<Integer>> statistic) {
        //TODO
    }

    @Override
    public void saveStatistic() {
        //TODO
    }
}
