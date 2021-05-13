package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.gui.Group.PlayerGroup;
import comp1110.ass2.gui.Group.SharedGroup;
import comp1110.ass2.gui.Group.Square;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.SharedState;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


import java.awt.*;
import java.util.Arrays;

public class Game extends Application {
    /* board layout */
    private static final int BOARD_WIDTH = 1280;
    private static final int BOARD_HEIGHT = 768;

    private final Group controls = new Group();
    public static final Group allState = new Group();
    public static final Viewer viewer = new Viewer();

    public static String[] gameState;
    public static Square.DraggableSquare draggableSquare;
    public static int playerNum;

    private static Square square;
    private static Square highlighted;
    private static Paint preColor;


    public static void displayState() {
        //Clear the group
        allState.getChildren().clear();

        String sharedStateStr = gameState[0];
        String playerStateStr = gameState[1];

        //Check if  the input is valid
        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
            new Alert(Alert.AlertType.NONE, "Invalid input!   Please re-enter!", new ButtonType[]{ButtonType.CLOSE}).show();
            return;
        }

        int playerNum = PlayerState.getPlayNumber(gameState[1]);

        //Draw playerState
        PlayerState[] playerState = PlayerState.getAllPlayerStates(playerStateStr);
        for (int i = 0; i < playerNum; i++) {
            char player = (char) ('A' + i);
            PlayerGroup playerGroup = new PlayerGroup(playerState[i],player);

            allState.getChildren().add(playerGroup);
        }

        //Draw shareState
        SharedState sharedState = new SharedState(sharedStateStr,playerNum);
        SharedGroup sharedGroup = new SharedGroup(sharedState);

        allState.getChildren().add(sharedGroup);
    }

    public void startGame() {
        playerNum = 2;
        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
        Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    public static void setHighlighted(Square square) {
        Game.square = square;
        if (highlighted != null) highlighted.setFill(preColor);
        highlighted = square;
        preColor = square.getFill();
        highlighted.setFill(Color.LIGHTGREY);
    }

    public static void applyMove() {

        if (square.position == Square.Position.Storage) {
            char player = ((PlayerGroup)square.group).getPlayer();
            int row = square.index;
            drafting(player, (char)(row + '0'));
        }
        else if (square.position == Square.Position.Floor) {
            char player = ((PlayerGroup)square.group).getPlayer();
            drafting(player, 'F');
        }
        tilling();
        Azul.nextRound(gameState);
        displayState();
    }

    public static void drafting(char player, char placedTo) {
        String move = null;
        if (draggableSquare.position == Square.Position.Factory) {
            int factoryNum = draggableSquare.index;
            move = String.valueOf(player) + factoryNum + draggableSquare.tile.getTILE_TYPE() + placedTo;
            gameState = Azul.applyMove(gameState, move);
        }
        else if (draggableSquare.position == Square.Position.Centre) {
            move = String.valueOf(player) + 'C' + draggableSquare.tile.getTILE_TYPE() + placedTo;
            gameState = Azul.applyMove(gameState, move);
        }
        if (move != null) {
            System.out.println(Arrays.toString(gameState));
            System.out.println(move);
        }
    }

    public static void tilling() {
        SharedState sharedState = new SharedState(gameState[0], playerNum);
        PlayerState[] playerStates = PlayerState.getAllPlayerStates(gameState[1]);
        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return;
        for (PlayerState playerState : playerStates) {
            Storage storage = playerState.getStorage();
            char currentPlayer = playerState.getPlayer().getId();
            sharedState.setPlayer(currentPlayer);
            gameState[0] = sharedState.getStateStr();
            for (int row = 0; row < 5; row++) {
                if (storage.rowIsComplete(row)) {
                    int col = Mosaic.getColInBeginnerMosaic(row, storage.getTileType()[row]);
                    String move = String.valueOf(currentPlayer) + row + col;
                    gameState = Azul.applyMove(gameState, move);
                    playerStates = PlayerState.getAllPlayerStates(gameState[1]);
                    sharedState = new SharedState(gameState[0], playerNum);
                    System.out.println(Arrays.toString(gameState));
                    System.out.println(move);
                }
            }

        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places
        //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
        stage.setTitle("Azul");
        Group root = new Group();
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        //viewer.start(stage);
        //String[] gameState = {"A0MSFB0MSF","AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000"};
        //viewer.displayState(gameState);

        root.getChildren().add(allState);
        stage.setScene(scene);
        stage.show();
        startGame();
    }
}
