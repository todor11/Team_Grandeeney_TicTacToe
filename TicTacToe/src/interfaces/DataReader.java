package interfaces;

import game.databases.Statistic;

public interface DataReader {
    void loadData(WinningDatabase winData);

    void loadStatistic(StatisticDatabase statistic);
}
