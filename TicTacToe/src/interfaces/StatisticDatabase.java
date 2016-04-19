package interfaces;


import game.databases.GameInfo;

import java.util.List;
import java.util.Map;

public interface StatisticDatabase {
    void addStatistic(GameInfo gameInfo);

    List<String> getStatistic();

    void setStatistic(List<String> statistic);

    void saveStatistic();
}
