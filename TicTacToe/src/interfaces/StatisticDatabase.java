package interfaces;


import game.databases.GameInfo;

import java.util.List;
import java.util.Map;

public interface StatisticDatabase {
    void addStatistic(GameInfo gameInfo);

    Map<String, List<Integer>> getStatistic();

    void setStatistic(Map<String, List<Integer>> statistic);

    void saveStatistic();
}
