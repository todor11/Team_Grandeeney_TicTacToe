package game.databases;

import interfaces.DataReader;
import interfaces.StatisticDatabase;
import interfaces.WinningDatabase;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileDataReader implements DataReader {
    private static final String pathData = "resources/databases/winningDatabase.save";
    private static final String statisticPathData = "resources/databases/statistic.save";

    public FileDataReader(){
    }

    @Override
    public void loadData(WinningDatabase winData) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(this.pathData)))) {
            winData.setData((Map<String, TreeMap<Integer, List<Step>>>) ois.readObject());
        }
        catch (FileNotFoundException fnff) {
            //System.out.println(fnff.toString());
        }
        catch (ClassNotFoundException | IOException cnne) {
            System.out.println(cnne.toString());
        }
    }

    @Override
    public void loadStatistic(StatisticDatabase statistic) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(this.statisticPathData)))) {
            statistic.setStatistic((Map<String, List<String>>) ois.readObject());
        }
        catch (FileNotFoundException fnff) {
            //System.out.println(fnff.toString());
        }
        catch (ClassNotFoundException | IOException cnne) {
            System.out.println(cnne.toString());
        }
    }
}
