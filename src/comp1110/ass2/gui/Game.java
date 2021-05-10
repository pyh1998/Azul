package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.awt.*;
import java.util.Arrays;

public class Game extends Application {
    /* board layout */
    private static final int BOARD_WIDTH = 1280;
    private static final int BOARD_HEIGHT = 768;
    private final Group controls = new Group();
    public static final Viewer viewer = new Viewer();

    public static String[] gameState;

    public static void startGame() {
        gameState = new String[] {"A0MSFB0MSF", "AFCfB2020202020D0000000000"};
        gameState = Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    public static void displayState() {
        String sharedState = gameState[0];
        String playerState = gameState[1];
        viewer.displayState(gameState);
    }



    @Override
    public void start(Stage stage) throws Exception {
        //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places
        //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
        stage.setTitle("Azul");
        Group root = new Group();
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        viewer.start(stage);
        String[] gameState = {"A0MSFB0MSF","AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000"};
        viewer.displayState(gameState);
        //stage.setScene(scene);

        stage.show();
    }
}
