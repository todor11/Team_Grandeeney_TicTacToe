/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.Game;
import game.databases.GameInfo;
import game.entities.Player;
import game.databases.Statistic;
import game.enums.Symbols;
import interfaces.UserInterface;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author chobi
 */
public class GraficUserInterface extends javax.swing.JFrame implements UserInterface  {


    // Variables declaration - do not modify
    private static int xo=1;
    private final ImageIcon x= new ImageIcon(getClass().getResource("/img/XO.png"));
    private final ImageIcon o= new ImageIcon(getClass().getResource("/img/OX.png"));
    private final ImageIcon labX= new ImageIcon(getClass().getResource("/img/x.png"));
    private final ImageIcon labO= new ImageIcon(getClass().getResource("/img/o.png"));
    private final ImageIcon background= new ImageIcon(getClass().getResource("/img/background.png"));
    private final boolean resGame = false;
    private String[] symbol = new String[]{"X", "O"};
    private boolean playerOneChose = true;
    private boolean playerTwoChose = true;
    public  String[] players;

    private int[] move;

    private javax.swing.JButton cas1;
    private javax.swing.JButton cas2;
    private javax.swing.JButton cas3;
    private javax.swing.JButton cas4;
    private javax.swing.JButton cas5;
    private javax.swing.JButton cas6;
    private javax.swing.JButton cas7;
    private javax.swing.JButton cas8;
    private javax.swing.JButton cas9;
    private javax.swing.JPanel endGame;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel game;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelXO;
    private javax.swing.JPanel mainWindow;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JTextField player1;
    private javax.swing.JTextField player2;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerOne_symbolO;
    private javax.swing.JLabel playerOne_symbolX;
    private javax.swing.JLabel playerTwo_symbolO;
    private javax.swing.JLabel playerTwo_symbolX;
    private javax.swing.JMenuItem restart;
    private javax.swing.JTextField result;
    private javax.swing.JButton start;
    private String endGameMsg;
    // End of variables declaration

    private Player activePlayer;
    private Game currantGame;

    public GraficUserInterface() {

    }


     @Override
    public int[] readPlayerMove(Player player) {

         this.activePlayer = player;

         return null;
    }

    @Override
    public void notifyForPlayerMove(int[] moves) {
        this.activePlayer.executeMove(this.move);
    }

    @Override
    public void drawField(Symbols[][] field) {

    }


    @Override
    public void drawStartPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("TIC TAC TOE");
        this.labelXO.setIcon(this.labX);
        this.endGame.setVisible(false);
        this.game.setVisible(false);
        this.mainWindow.setVisible(true);
        this.playerTwo_symbolX.setVisible(false);
        this.playerOne_symbolO.setVisible(false);
        setVisible(true);

    }

    @Override
    public void drawGameInfo(GameInfo gameInfo) {

    }

    @Override
    public void drawStatistic(Statistic statistic) {

    }

    @Override
    public void writeMassage(String text) {
        this.endGameMsg = text;
        xo=1;
        cas1.setIcon(null);cas1.setEnabled(true);
        cas2.setIcon(null);cas2.setEnabled(true);
        cas3.setIcon(null);cas3.setEnabled(true);
        cas4.setIcon(null);cas4.setEnabled(true);
        cas5.setIcon(null);cas5.setEnabled(true);
        cas6.setIcon(null);cas6.setEnabled(true);
        cas7.setIcon(null);cas7.setEnabled(true);
        cas8.setIcon(null);cas8.setEnabled(true);
        cas9.setIcon(null);cas9.setEnabled(true);
        labelXO.setIcon(labX);
        endGame.setVisible(true);
        game.setVisible(false);
        result.setText(this.endGameMsg);
    }

    @Override
    public void exitGame(){
        //TODO ako ima neshto ot GUI-to koeto da se ztwarq
    }

    @Override
    public String[] getPlayerTypeAndName(Game game) {
        this.currantGame = game;
        return null;
    }

    @Override
    public boolean getAnswerForNewGame(Game game) {
        this.currantGame = game;
        //TODO - startira ti metoda kojto da pita dali se igrae nowa igra -
        //rezultata ot izbora na igracha startira  this.currantGame.executePlayerChoiceForNewGame(true / false);

        return false;
    }




    private void setIconXO(JButton bn){

        if (xo % 2 != 0) {
            bn.setIcon(x);
            labelXO.setIcon(labX);
            bn.setEnabled(false);
            playerName.setText(player2.getText());
            xo++;
        }else{
             bn.setIcon(o);
             xo++;
             labelXO.setIcon(labO);
             bn.setEnabled(false);
             playerName.setText(player1.getText());
        }
    }

    //----------------------fin de jeu -----------------------------------//

    private void endGame(){


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        game = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cas1 = new javax.swing.JButton();
        cas3 = new javax.swing.JButton();
        cas2 = new javax.swing.JButton();
        cas6 = new javax.swing.JButton();
        cas5 = new javax.swing.JButton();
        cas4 = new javax.swing.JButton();
        cas9 = new javax.swing.JButton();
        cas8 = new javax.swing.JButton();
        cas7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelXO = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        endGame = new javax.swing.JPanel();
        result = new javax.swing.JTextField();
        mainWindow = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        player1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        player2 = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        playerOne_symbolO = new javax.swing.JLabel();
        playerOne_symbolX = new javax.swing.JLabel();
        playerTwo_symbolO = new javax.swing.JLabel();
        playerTwo_symbolX = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        restart = new javax.swing.JMenuItem();
        newGame = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        game.setBackground(new java.awt.Color(7, 224, 111));
        game.setPreferredSize(new java.awt.Dimension(600, 800));

        jPanel1.setBackground(new java.awt.Color(28, 18, 18));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));

        cas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cas1ActionPerformed(evt);

            }
        });

        cas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas3ActionPerformed(evt);
            }
        });

        cas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas2ActionPerformed(evt);
            }
        });

        cas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas6ActionPerformed(evt);
            }
        });

        cas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas5ActionPerformed(evt);
            }
        });

        cas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas4ActionPerformed(evt);
            }
        });

        cas9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas9ActionPerformed(evt);
            }
        });

        cas8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas8ActionPerformed(evt);
            }
        });

        cas7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cas7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cas4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cas5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cas6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cas7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cas8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cas9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cas1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cas2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cas3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cas3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cas6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cas9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cas8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(241, 153, 18));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Next Move: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 3, 18), new java.awt.Color(163, 19, 19))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        labelXO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playerName.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerName.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(labelXO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelXO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(playerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout gameLayout = new javax.swing.GroupLayout(game);
        game.setLayout(gameLayout);
        gameLayout.setHorizontalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(game, "card2");

        endGame.setBackground(new java.awt.Color(232, 245, 39));
        endGame.setPreferredSize(new java.awt.Dimension(600, 800));

        result.setFont(new java.awt.Font("DejaVu Serif", 3, 36)); // NOI18N
        result.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        result.setEnabled(false);
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout endGameLayout = new javax.swing.GroupLayout(endGame);
        endGame.setLayout(endGameLayout);
        endGameLayout.setHorizontalGroup(
            endGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endGameLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        endGameLayout.setVerticalGroup(
            endGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endGameLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(542, Short.MAX_VALUE))
        );

        getContentPane().add(endGame, "card3");

        mainWindow.setBackground(new java.awt.Color(207, 23, 23));
        mainWindow.setPreferredSize(new java.awt.Dimension(600, 800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Schoolbook L", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(223, 183, 22));
        jLabel2.setText("Player 1 :");

        player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Schoolbook L", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(223, 183, 22));
        jLabel3.setText("Player 2 :");

        player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ActionPerformed(evt);
            }
        });

        start.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 36)); // NOI18N
        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        playerOne_symbolO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/o.png"))); // NOI18N
        playerOne_symbolO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playerOne_symbolO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerOne_symbolOMouseClicked(evt);
            }
        });

        playerOne_symbolX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.png"))); // NOI18N
        playerOne_symbolX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playerOne_symbolX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerOne_symbolXMouseClicked(evt);
            }
        });

        playerTwo_symbolO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/o.png"))); // NOI18N
        playerTwo_symbolO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playerTwo_symbolO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerTwo_symbolOMouseClicked(evt);
            }
        });

        playerTwo_symbolX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.png"))); // NOI18N
        playerTwo_symbolX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playerTwo_symbolX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerTwo_symbolXMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainWindowLayout = new javax.swing.GroupLayout(mainWindow);
        mainWindow.setLayout(mainWindowLayout);
        mainWindowLayout.setHorizontalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                        .addComponent(playerOne_symbolX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerOne_symbolO))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainWindowLayout.createSequentialGroup()
                        .addComponent(playerTwo_symbolX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerTwo_symbolO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171))
        );
        mainWindowLayout.setVerticalGroup(
            mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWindowLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerOne_symbolO)
                    .addComponent(playerOne_symbolX))
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playerTwo_symbolO)
                        .addComponent(playerTwo_symbolX)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        getContentPane().add(mainWindow, "card4");

        fileMenu.setText("File");

        restart.setText("Restart");
        restart.setEnabled(false);
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });
        fileMenu.add(restart);

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        fileMenu.add(newGame);
        fileMenu.add(jSeparator1);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        fileMenu.add(exit);

        jMenuBar1.add(fileMenu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>                        

    private void cas1ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas1);
        this.move = new int[]{0,0};
        this.notifyForPlayerMove(this.move);
    }

    private void cas3ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas3);
        this.move = new int[]{0,2};
        this.notifyForPlayerMove(this.move);
    }

    private void cas2ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas2);
        this.move = new int[]{0,1};
        this.notifyForPlayerMove(this.move);
    }

    private void cas6ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas6);
        this.move = new int[]{1,2};
        this.notifyForPlayerMove(this.move);
    }

    private void cas5ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas5);
        this.move = new int[]{1,1};
        this.notifyForPlayerMove(this.move);
    }

    private void cas4ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas4);
        this.move = new int[]{1,0};
        this.notifyForPlayerMove(this.move);
    }

    private void cas9ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas9);
        this.move = new int[]{2,2};
        this.notifyForPlayerMove(this.move);
    }

    private void cas8ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas8);
        this.move = new int[]{2,1};
        this.notifyForPlayerMove(this.move);
    }

    private void cas7ActionPerformed(java.awt.event.ActionEvent evt) {
        setIconXO(cas7);
        this.move = new int[]{2,0};
        this.notifyForPlayerMove(this.move);
    }

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void player1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void player2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void startActionPerformed(java.awt.event.ActionEvent evt) {




        if (!player1.getText().isEmpty() &&
                !player2.getText().isEmpty() &&
                playerOneChose && playerTwoChose) {

            this.players = new String[]{
                    "Human",player1.getText(),symbol[0],
                    "Human", player2.getText(), symbol[1] };

            if (this.players[2].equals("X")) {
                playerName.setText(this.players[1]);
            } else {
                playerName.setText(this.players[4]);
            }
            mainWindow.setVisible(false);
            game.setVisible(true);
            restart.setEnabled(true);
            this.currantGame.setPlayerProperties(players);
        } else {
            return;
        }
    }

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {

        endGame();
        game.setEnabled(true);
        endGame.setVisible(false);
        mainWindow.setVisible(false);

    }

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {
        mainWindow.setVisible(true);
        game.setVisible(false);
        endGame.setVisible(false);
        player1.setText(null);
        player2.setText(null);

        restart.setEnabled(false);


        playerOne_symbolX.setVisible(true);
        playerTwo_symbolO.setVisible(true);
        playerOneChose = false;
        playerTwoChose = false;
        cas1.setIcon(null);cas1.setEnabled(true);
        cas2.setIcon(null);cas2.setEnabled(true);
        cas3.setIcon(null);cas3.setEnabled(true);
        cas4.setIcon(null);cas4.setEnabled(true);
        cas5.setIcon(null);cas5.setEnabled(true);
        cas6.setIcon(null);cas6.setEnabled(true);
        cas7.setIcon(null);cas7.setEnabled(true);
        cas8.setIcon(null);cas8.setEnabled(true);
        cas9.setIcon(null);cas9.setEnabled(true);

    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void playerOne_symbolXMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void playerOne_symbolOMouseClicked(java.awt.event.MouseEvent evt) {


    }

    private void playerTwo_symbolXMouseClicked(java.awt.event.MouseEvent evt) {


    }

    private void playerTwo_symbolOMouseClicked(java.awt.event.MouseEvent evt) {

    }





}
