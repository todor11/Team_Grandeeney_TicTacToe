package sample.display.view;

import javafx.fxml.FXML;
import sample.Display;


public class Controller {
    private Display main;

    @FXML
    private void playGame(){
        main.play();

    }


}
