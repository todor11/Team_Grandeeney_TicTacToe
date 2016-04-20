package game.databases;

import interfaces.DataReader;
import interfaces.DataWriter;
import interfaces.StatisticDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic implements StatisticDatabase, Serializable {
    private Map<String, List<String>> statistic;
    private DataReader dataReader;
    private DataWriter dataWriter;

    public Statistic(DataReader dataReader, DataWriter dataWriter){
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.init();
    }

    @Override
    public List<String> getStatisticForPlayer(String playerName) {
        List<String> playerStatistic = new ArrayList<>();
        if (this.statistic.containsKey(playerName)){
            playerStatistic = this.statistic.get(playerName);
        }

        return playerStatistic;
    }

    @Override
    public Map<String, List<String>> getAllStatistic() {
        return this.statistic;
    }

    @Override
    public void setStatistic(Map<String, List<String>> statistic) {
        this.statistic = statistic;
    }

    @Override
    public void saveStatistic(String gameInfo) {
        String[] splitInfo = gameInfo.split(":");
        String firstPlayerInfo = splitInfo[0].trim();
        String firstPlayerName = firstPlayerInfo.split("\\s+")[0];
        String secondPlayerInfo = splitInfo[1].trim();
        String secondPlayerName = secondPlayerInfo.split("\\s+")[0];
        if (!this.statistic.containsKey(firstPlayerName)){
            this.statistic.put(firstPlayerName, new ArrayList<>());
        }

        this.statistic.get(firstPlayerName).add(0, gameInfo);
        if (this.statistic.get(firstPlayerName).size() > 10){
            this.statistic.get(firstPlayerName).remove(this.statistic.get(firstPlayerName).size() - 1);
        }

        if (!this.statistic.containsKey(secondPlayerName)){
            this.statistic.put(secondPlayerName, new ArrayList<>());
        }

        this.statistic.get(secondPlayerName).add(0 , secondPlayerInfo + " : " + firstPlayerInfo);
        if (this.statistic.get(secondPlayerName).size() > 10){
            this.statistic.get(secondPlayerName).remove(this.statistic.get(secondPlayerName).size() - 1);
        }

        this.dataWriter.writeStatistic(this);
    }

    private void init(){
        this.dataReader.loadStatistic(this);
        if (this.statistic == null){
            this.statistic = new HashMap<>();
        }
    }
}
