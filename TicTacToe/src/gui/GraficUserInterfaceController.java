package gui;

import game.Game;
import game.entities.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import gui.GraficUserInterface;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;


public class GraficUserInterfaceController {




    private boolean playerOneChose = false;
    private boolean playerTwoChose = false;
    private String[] symbol = new String[2];
    private String[]  playerInput;
    private Player activePlayer;
    private ImageView curentField;
    private Button curentButton;
    private int[] move;
    private String gameInPlay;
    private Game currantGame;
    private GraficUserInterface gui;


    private final Image imgX = new Image("/resources/img/x.png");
    private final  Image imgO = new Image("/resources/img/o.png");



    @FXML
    private Button multiPlay;

    @FXML
    private Pane startGamePanel;

    @FXML
    private ImageView field_20;

    @FXML
    private ImageView field_21;

    @FXML
    private ImageView field_00;

    @FXML
    private ImageView field_22;

    @FXML
    private ImageView field_01;

    @FXML
    private MenuItem newGame;

    @FXML
    private TextField playerTwoField;

    @FXML
    private ImageView field_02;

    @FXML
    private TextField playerOneField;

    @FXML
    private Pane mainGamePanel;

    @FXML
    private MenuItem menuQuit;

    @FXML
    private Label playerTwoOrAI;

    @FXML
    private Label playerTwoName;

    @FXML
    private ImageView playerOneOChoice;

    @FXML
    private Button startGameBtn;

    @FXML
    private ImageView playerOneXChoice;

    @FXML
    private Pane playerNamePanel;

    @FXML
    private ImageView field_10;

    @FXML
    private MenuItem restart;

    @FXML
    private ImageView playerTwoOChoice;

    @FXML
    private ImageView field_11;

    @FXML
    private ImageView field_12;

    @FXML
    private Label playerOneName;

    @FXML
    private Button singlePlay;

    @FXML
    private ImageView playerTwoXChoice;

    @FXML
    private Button quit;

    public GraficUserInterfaceController() throws MalformedURLException {
    }



    @FXML
    void exitGame(ActionEvent event) {
        System.exit(0);
    }

    public void setMove(int[] move) {
        this.move = move;
    }

    public int[] getMove() {
        return this.move;
    }



    @FXML
    void drawStartPage(ActionEvent event) {

        setCurentButton((Button) event.getSource());
        if (curentButton.getId().equals("singlePlay")){
            this.playerNamePanel.setVisible(true);
            this.startGamePanel.setVisible(false);
            this.playerTwoField.setVisible(false);
            this.playerTwoOrAI.setText("Jedi Master");
            this.playerTwoField.setText("Jedi Master");
            gameInPlay = curentButton.getId();


        }else{
            this.playerNamePanel.setVisible(true);
            this.startGamePanel.setVisible(false);
            gameInPlay = curentButton.getId();

        }
    }


    @FXML
    void startGame(ActionEvent event) {
        if (!this.playerOneField.getText().equals("")&&
            this.playerOneChose &&
            this.playerTwoChose) {

            this.playerInput = new String[]{"Human", this.playerOneField.getText(), this.symbol[0],
                            "Human", this.playerTwoField.getText(), this.symbol[1]};
            this.playerNamePanel.setVisible(false);
            this.mainGamePanel.setVisible(true);
            this.restart.setDisable(false);
            this.playerOneName.setText(this.playerInput[1]);
            this.playerTwoName.setText(this.playerInput[4]);
            field_00.setImage(null);
            field_01.setImage(null);
            field_02.setImage(null);
            field_10.setImage(null);
            field_11.setImage(null);
            field_12.setImage(null);
            field_20.setImage(null);
            field_21.setImage(null);
            field_22.setImage(null);
            if (gameInPlay.equals("singlePlay")){
                this.playerInput = new String[]{
                        "Human",
                        this.playerOneField.getText(),
                        this.symbol[0],
                        "AI",
                        "comp",
                        this.symbol[1]};
            }


        }else{
            return;
        }

    }
    @FXML
    private void playerOne_symbolXMouseClicked(MouseEvent evt) {
        this.symbol[0] = "X";
        this.symbol[1] = "O";
        this.playerOneChose = true;
        this.playerTwoChose = true;
        this.playerOneOChoice.setVisible(false);
        this.playerTwoXChoice.setVisible(false);

    }
    @FXML
    private void playerOne_symbolOMouseClicked(MouseEvent evt) {
        this.symbol[0] = "O";
        this.symbol[1] = "X";
        this.playerOneChose = true;
        this.playerTwoChose = true;
        this.playerOneXChoice.setVisible(false);
        this.playerTwoOChoice.setVisible(false);

    }
    @FXML
    private void playerTwo_symbolXMouseClicked(MouseEvent evt) {

        this.symbol[0] = "O";
        this.symbol[1] = "X";
        this.playerTwoChose = true;
        this.playerOneChose = true;
        this.playerOneXChoice.setVisible(false);
        this.playerTwoOChoice.setVisible(false);

    }
    @FXML
    private void playerTwo_symbolOMouseClicked(MouseEvent evt) {
        this.playerOneOChoice.setVisible(false);
        this.playerTwoXChoice.setVisible(false);

        this.symbol[0] = "X";
        this.symbol[1] = "O";
        this.playerOneChose = true;
        this.playerTwoChose = true;
    }

    @FXML
    private void newGameActionPerformed(ActionEvent evt) {
        this.startGamePanel.setVisible(true);
        this.mainGamePanel.setVisible(false);
        this.playerNamePanel.setVisible(false);
       //TODO:  endGame.setVisible(false);
        this.playerOneField.setText("");
        this.playerTwoField.setText("");
        this.playerTwoField.setVisible(true);
        this.restart.setDisable(true);
        this.playerOneOChoice.setVisible(true);
        this.playerTwoXChoice.setVisible(true);
        this.playerOneXChoice.setVisible(true);
        this.playerTwoOChoice.setVisible(true);
        this.playerOneChose = false;
        this.playerTwoChose = false;
        this.playerTwoOrAI.setText("Player 2");


    }

    @FXML
    private void playerMove (MouseEvent evt){
        curentField = (ImageView) evt.getSource();
        switch (curentField.getId()){
            case "field_00":
               setMove(new int[]{0,0});
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_01":
                this.move = new int[]{0,1};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_02":
                this.move = new int[]{0,2};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_10":
                this.move = new int[]{1,0};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_11":
                this.move = new int[]{1,1};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_12":
                this.move = new int[]{1,2};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_20":
                this.move = new int[]{2,0};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_21":
                this.move = new int[]{2,1};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            case "field_22":
                this.move = new int[]{2,2};
                new GraficUserInterface().notifyForPlayerMove(this.move);break;
            default: System.out.printf("Somting Wrong!!");
        }

    }

    public Button getCurentButton() {
        return curentButton;
    }

    public void setCurentButton(Button curentButton) {
        this.curentButton = curentButton;
    }

    public String[] getPlayerInput() {
        return playerInput;
    }
}
