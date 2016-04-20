package interfaces;

import game.databases.Statistic;

public interface DataWriter {
    void writeData(WinningDatabase data);

    void writeStatistic(StatisticDatabase statistic);
}
