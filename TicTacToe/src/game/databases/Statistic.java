package game.databases;

import interfaces.DataReader;
import interfaces.DataWriter;
import interfaces.StatisticDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Statistic implements StatisticDatabase, Serializable {
    private List<String> statistic;
    private DataReader dataReader;
    private DataWriter dataWriter;

    public Statistic(DataReader dataReader, DataWriter dataWriter){
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.dataReader.loadStatistic(this);
    }


    @Override
    public void addStatistic(GameInfo gameInfo) {
        if (this.statistic == null){
            this.statistic = new ArrayList<>();
        }

        this.statistic.add(gameInfo.getInfo());
    }

    @Override
    public List<String> getStatistic() {
        if (this.statistic == null){
            this.statistic = new ArrayList<>();
        }

        return this.statistic;
    }

    @Override
    public void setStatistic(List<String> statistic) {
        this.statistic = statistic;
    }

    @Override
    public void saveStatistic() {
        this.dataWriter.writeStatistic(this);
    }
}
