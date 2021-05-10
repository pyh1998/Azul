package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.Tile.Tile;
import comp1110.ass2.gui.Group.PlayerGroup;
import comp1110.ass2.gui.Group.SharedGroup;
import comp1110.ass2.gui.Group.Square;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.Player;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;

    private final Group root = new Group();
    private final Group controls = new Group();
    public final Group allState = new Group();
    private TextField playerTextField;
    private TextField boardTextField;

    /**
     * @author Yuhui Pang
     *
     * Draw a placement in the window, removing any previously drawn placements
     *
     * @param state an array of two strings, representing the current game state
     *              TASK 4
     */
    void displayState(String[] state) {
        //Clear the group
        allState.getChildren().clear();

        //state[0] = "A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S4d2FB10Ma00b01e10b12d14d20e21c30c41a44S2c23d3F";
        //state[1] = "BF0bcdd1bbbc2aaad3acde4abceCfB0000000000D1110100612";
        String playerStateStr = state[0];
        String sharedStateStr = state[1];
        //Check if  the input is valid
        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
            new Alert(Alert.AlertType.NONE, "Invalid input!   Please re-enter!", new ButtonType[]{ButtonType.CLOSE}).show();
            return;
        }

        int playerNum = PlayerState.getPlayNumber(state[0]);

        //Draw playerState
        for (int i = 0; i < playerNum; i++) {
            if (i < playerNum - 1){
                playerStateStr = state[0].substring(playerStateStr.indexOf((char) (i + 'A')),playerStateStr.indexOf((char) (i + 'B')));
            }
            else{
                playerStateStr = state[0].substring(state[0].indexOf((char) (i + 'A')));
            }

            char player = (char) ('A' + i);
            PlayerState playerState = new PlayerState(playerStateStr);
            PlayerGroup playerGroup = new PlayerGroup(playerState,player);

            allState.getChildren().add(playerGroup);
        }

        //Draw shareState
        SharedState sharedState = new SharedState(sharedStateStr,playerNum);
        SharedGroup sharedGroup = new SharedGroup(sharedState);

        allState.getChildren().add(sharedGroup);

        // FIXME Task 4: implement the simple state viewer
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label playerLabel = new Label("Player State:");
        playerTextField = new TextField("A0MSFB0MSF");
        playerTextField.setPrefWidth(100);
        Label boardLabel = new Label("Board State:");
        boardTextField = new TextField("AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000");
        boardTextField.setPrefWidth(100);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayState(new String[]{playerTextField.getText(),
                        boardTextField.getText()});
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(playerLabel, playerTextField, boardLabel,
                boardTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(50);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Azul Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        root.getChildren().add(allState);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


