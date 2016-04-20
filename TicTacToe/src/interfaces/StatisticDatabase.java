package interfaces;

import java.util.List;
import java.util.Map;

public interface StatisticDatabase {
    List<String> getStatisticForPlayer(String playerName);

    Map<String, List<String>> getAllStatistic();

    void setStatistic(Map<String, List<String>> statistic);

    void saveStatistic(String gameInfo);
}
