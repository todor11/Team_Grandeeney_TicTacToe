import game.Game;
import game.databases.*;
import game.factories.PlayerFactory;
import gui.ConsoleUserInterface;
import gui.GraficUserInterface;
import interfaces.*;

public class Launcher {
    public static void main(String[] args) {
        UserInterface userInterface = new ConsoleUserInterface();
        //UserInterface userInterface = new GraficUserInterface();
        DataReader dataReader = new FileDataReader();
        DataWriter dataWriter = new FileDataWriter();
        WinningDatabase dataBase = new WinData(dataReader, dataWriter);
        StatisticDatabase statistic = new Statistic(dataReader, dataWriter);
        GameInformation gameInfo = new GameInfo();
        PlayerFactory playerFactory = new PlayerFactory();
        Game game = new Game(userInterface, dataBase, playerFactory, statistic, gameInfo);
        game.start();
    }
}
