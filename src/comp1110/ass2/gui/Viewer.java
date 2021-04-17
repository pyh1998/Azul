package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.Tile.Tile;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Floor;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.Player;
import comp1110.ass2.playerState.Storage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField playerTextField;
    private TextField boardTextField;

    public Group drawStorage(Storage storage){
        Tile[] tileType = storage.getTileType();
        int[] tileNum = storage.getTileNumber();
        int side = 40;
        int space = 5;
        Group storageGroup = new Group();

        for(int i=0;i<Storage.NUMBER_ROWS;i++){
            int count = 0;
            for(int j=0;j<=i;j++){
                Rectangle r = new Rectangle();
                r.setX((Storage.NUMBER_ROWS - j) * (side + space));
                r.setY(i * (side + space));
                r.setWidth(side);
                r.setHeight(side);
                if(tileType[i] == null || count == tileNum[i]){
                    r.setFill(Color.GRAY);
                }
                else{
                    r.setFill(tileType[i].getTILE_COLOR());
                    count++;
                }
                storageGroup.getChildren().add(r);
            }
        }

        return storageGroup;
    }

    public Group drawMosaic(Mosaic mosaic){
        Tile[][] tiles = mosaic.getTiles();

        int side = 40;
        int space = 5;
        Group mosaicGroup = new Group();

        for(int i=0;i<Mosaic.HEIGHT;i++){
            for(int j=0;j<Mosaic.HEIGHT;j++){
                Rectangle r = new Rectangle();
                r.setX(j * (side + space));
                r.setY(i * (side + space));
                r.setWidth(side);
                r.setHeight(side);
                if(tiles[i][j] == null){
                    r.setFill(Color.GRAY);
                }
                else{
                    r.setFill(tiles[i][j].getTILE_COLOR());
                }
                mosaicGroup.getChildren().add(r);
            }
        }

        return mosaicGroup;
    }

    public Group drawPlayer(Player player){
        Group playerGroup = new Group();
        char playerId = player.getId();
        int score = player.getScore();
        Label labelI = new Label(String.valueOf("Player: " + playerId));
        Label labelS = new Label(String.valueOf("Score: " + score));
        labelS.setLayoutX(100);
        playerGroup.getChildren().addAll(labelI,labelS);
        return playerGroup;
    }

    public Group drawFloor( Floor floor){
        Tile[] tiles =floor.getTiles();
        Group floorGroup = new Group();
        int side = 40;
        int space = 5;
        for(int i=0;i<Floor.MAX_LENGTH;i++){
            Rectangle r = new Rectangle();
            r.setX(i * (side + space));
            r.setWidth(side);
            r.setHeight(side);
            if(i >= floor.getNumber() || tiles[i] == null){
                r.setFill(Color.GRAY);
            }
            else{
                r.setFill(tiles[i].getTILE_COLOR());
            }
            floorGroup.getChildren().add(r);
        }
        return floorGroup;
    }

    /**
     * Draw a placement in the window, removing any previously drawn placements
     *
     * @param state an array of two strings, representing the current game state
     *              TASK 4
     */



    void displayState(String[] state) {

        //state[0] = "A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S4d2FB10Ma00b01e10b12d14d20e21c30c41a44S2c23d3F";
        //state[1] = "BF0bcdd1bbbc2aaad3acde4abceCfB0000000000D1110100612";
        String playerStateStr = state[0];
        //A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S4d2FB10Ma00b01e10b12d14d20e21c30c41a44S2c23d3F
        //BF0bcdd1bbbc2aaad3acde4abceCfB0000000000D1110100612
        int playerNum = Azul.getPlayNumber(state[0]);

        //Draw playerState
        for (int i = 0; i < playerNum; i++) {
            if (i < playerNum - 1){
                playerStateStr = state[0].substring(playerStateStr.indexOf((char) (i + 'A')),playerStateStr.indexOf((char) (i + 'B')));
                System.out.println(playerStateStr);
            }
            else{
                playerStateStr = state[0].substring(state[0].indexOf((char) (i + 'A')));
            }

            PlayerState playerState = new PlayerState(playerStateStr);
            Group player = drawPlayer(playerState.getPlayer());
            Group storage = drawStorage(playerState.getStorage());
            Group mosaic = drawMosaic(playerState.getMosaic());
            Group floor = drawFloor(playerState.getFloor());

            storage.setLayoutX(i * 600);
            storage.setLayoutY(200);
            mosaic.setLayoutX(300 + i * 600);
            mosaic.setLayoutY(200);
            player.setLayoutX(45 + i * 600);
            player.setLayoutY(150);
            floor.setLayoutX(45 + i * 600);
            floor.setLayoutY(500);

            controls.getChildren().addAll(player,storage,mosaic,floor);
        }

        //Draw shareState




        // FIXME Task 4: implement the simple state viewer
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label playerLabel = new Label("Player State:");
        playerTextField = new TextField();
        playerTextField.setPrefWidth(100);
        Label boardLabel = new Label("Board State:");
        boardTextField = new TextField();
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

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


