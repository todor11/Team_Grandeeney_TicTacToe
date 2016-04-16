package interfaces;

import game.databases.Step;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface WinningDatabase {
    void addNewData(Step step);

    Map<String, TreeMap<Integer, List<Step>>> getData();

    void setData(Map<String, TreeMap<Integer, List<Step>>> data);

    void saveData();
}
