package game.databases;

import interfaces.DataWriter;
import interfaces.StatisticDatabase;
import interfaces.WinningDatabase;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class FileDataWriter implements DataWriter {
    private static final String pathData = "resources/databases/winningDatabase.save";
    private static final String statisticPathData = "resources/databases/statistic.save";

    public FileDataWriter(){

    }

    @Override
    public void writeData(WinningDatabase data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(this.pathData)))) {
            oos.writeObject(data.getData());
        }
        catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    @Override
    public void writeStatistic(StatisticDatabase statistic) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(this.statisticPathData)))) {
            oos.writeObject(statistic.getAllStatistic());
        }
        catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }
}
