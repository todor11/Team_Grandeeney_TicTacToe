package game.databases;

import interfaces.DataWriter;
import interfaces.WinningDatabase;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class FileDataWriter implements DataWriter {
    private static final String pathData = "resources/databases/winningDatabase.save";

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
    public void writeStatistic(Statistic statistic) {
        //TODO
    }
}
