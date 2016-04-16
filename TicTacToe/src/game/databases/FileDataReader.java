package game.databases;

import interfaces.DataReader;
import interfaces.WinningDatabase;

import java.io.*;
import java.util.List;
import java.util.Map;

public class FileDataReader implements DataReader {
    private static final String pathData = "resources/databases/winningDatabase.save";

    public FileDataReader(){
    }

    @Override
    public void loadData(WinningDatabase winData) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(this.pathData)))) {
            winData.setData((Map<String, Map<Integer, List<Step>>>) ois.readObject());
        }
        catch (FileNotFoundException fnff) {
            //System.out.println(fnff.toString());
        }
        catch (ClassNotFoundException | IOException cnne) {
            System.out.println(cnne.toString());
        }
    }

    @Override
    public void loadStatistic(Statistic statistic) {
        //TODO
    }
}
