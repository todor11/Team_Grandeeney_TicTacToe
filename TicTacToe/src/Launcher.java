import game.Game;
import game.databases.FileDataReader;
import game.databases.FileDataWriter;
import game.databases.WinData;
import game.factories.PlayerFactory;
import gui.ConsoleUserInterface;
import interfaces.DataReader;
import interfaces.DataWriter;
import interfaces.UserInterface;
import interfaces.WinningDatabase;

public class Launcher {
    public static void main(String[] args) {
        UserInterface userInterface = new ConsoleUserInterface();
        DataReader dataReader = new FileDataReader();
        DataWriter dataWriter = new FileDataWriter();
        WinningDatabase dataBase = new WinData(dataReader, dataWriter);
        PlayerFactory playerFactory = new PlayerFactory();
        Game game = new Game(userInterface, dataBase, playerFactory);
        game.start();
    }
}
