package interfaces;

import game.databases.Step;

import java.util.List;
import java.util.Map;

public interface WinningDatabase {
    void addNewData(Step step);

    Map<String, Map<Integer, List<Step>>> getData();

    void setData(Map<String, Map<Integer, List<Step>>> data);
}
