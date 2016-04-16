package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import gui.display.view.Controller;

import java.io.IOException;

public class Display extends Application {
    private Stage primaryStage;
    private static BorderPane mainLayout;
    private static Rectangle rectangle;
    private static FXMLLoader loader;



    @Override
    public void start(Stage primaryStage) throws IOException{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TIC TAC TOE");
        showMainView();
        showMainItems();
    }



    private void showMainView() throws IOException{
        loader = new FXMLLoader();
        loader.setLocation(Display.class.getResource("display/view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMainItems() {
        loader = new FXMLLoader();
        loader.setLocation(Display.class.getResource("display/view/MainItems.fxml"));
        BorderPane mainItems = null;
        try {
            mainItems = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainLayout.setCenter(mainItems);
    }
    public static void play(){
        loader = new FXMLLoader();
        loader.setLocation(Display.class.getResource("display/view/gamePlay.fxml"));
        BorderPane playGame = null;
        try {
            playGame = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainLayout.setCenter(playGame);
    }




    public static void main(String[] args) {

        launch(args);
    }

}
