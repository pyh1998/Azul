package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.Tile.Tile;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
        labelI.setFont(new Font("Arial", 15));
        labelS.setFont(new Font("Arial", 15));
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

    public Group drawFactory(Factory factory,int playerNum){
        int factoryNum = 2 * playerNum + 1;
        Tile[][] tiles= factory.getTiles();
        Group factoryGroup = new Group();
        Label label = new Label("Factory:");
        label.setFont(new Font("Arial", 20));
        factoryGroup.getChildren().add(label);
        int side = 40;
        int space = 5;
        int distance = 20;
        for(int i=0;i<factoryNum;i++){
            for (int j=0;j<factory.FACTORY_CAPACITY;j++){
                Rectangle r = new Rectangle();
                if(j % 2 == 0){
                    r.setX(i * (side * 2 + space + distance));
                }
                else{
                    r.setX(i * (side * 2 + space + distance) + side + space);
                }
                r.setY((j / 2) * (side + space) + 30);
                r.setWidth(side);
                r.setHeight(side);
                if(tiles[i][j] == null){
                    r.setFill(Color.GRAY);
                }
                else{
                    r.setFill(tiles[i][j].getTILE_COLOR());
                }
                factoryGroup.getChildren().add(r);
            }
        }
        return factoryGroup;
    }

    public Group drawBag(Bag bag){
        int[] tileNum = bag.getTile_num();
        Group bagGroup = new Group();
        Label label = new Label("Bag:");
        label.setFont(new Font("Arial", 20));
        bagGroup.getChildren().add(label);
        int side = 40;
        int space = 5;
        for(int i=0;i<tileNum.length;i++){
            Rectangle r = new Rectangle();
            r.setX(i * (side + space));
            r.setY(30);
            r.setWidth(side);
            r.setHeight(side);
            r.setFill(Tile.idToTile(i).getTILE_COLOR());
            Label numLabel = new Label(String.valueOf(tileNum[i]));
            numLabel.setLayoutX(15 + i * (side + space));
            numLabel.setLayoutY(30 + side + space);
            bagGroup.getChildren().addAll(r,numLabel);
        }
        return bagGroup;
    }

    public Group drawCentre(Centre centre){
        Tile[] tiles = centre.getTiles();
        int num = centre.getNumber();
        int col = 5;
        int row = num / 5 + 1;
        int index = 0;
        Group centreGroup = new Group();
        Label label = new Label("Centre:");
        label.setFont(new Font("Arial", 20));
        centreGroup.getChildren().add(label);
        int side = 40;
        int space = 5;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(index < num){
                    Rectangle r = new Rectangle();
                    r.setX(j * (side + space));
                    r.setY(30 + i * (side + space));
                    r.setWidth(side);
                    r.setHeight(side);
                    r.setFill(tiles[index].getTILE_COLOR());
                    index ++;
                    centreGroup.getChildren().add(r);
                }
            }
        }
        return centreGroup;
    }

    public Group drawDiscard(Discard discard){
        int[] tileNum = discard.getTile_num();
        Group discardGroup = new Group();
        Label label = new Label("Discard:");
        label.setFont(new Font("Arial", 20));
        discardGroup.getChildren().add(label);
        int side = 40;
        int space = 5;
        for(int i=0;i<tileNum.length;i++){
            Rectangle r = new Rectangle();
            r.setX(i * (side + space));
            r.setY(30);
            r.setWidth(side);
            r.setHeight(side);
            r.setFill(Tile.idToTile(i).getTILE_COLOR());
            Label numLabel = new Label(String.valueOf(tileNum[i]));
            numLabel.setLayoutX(15 + i * (side + space));
            numLabel.setLayoutY(30 + side + space);
            discardGroup.getChildren().addAll(r,numLabel);
        }
        return discardGroup;
    }

    public Group drawPlayerTurn(char playerTurn){
        Group playerTurnGroup = new Group();
        Label label =new Label(String.valueOf(playerTurn) + "'s Turn");
        label.setFont(new Font("Arial", 30));
        if(playerTurn == 'B'){
            label.setLayoutX(600);
        }
        playerTurnGroup.getChildren().add(label);
        return playerTurnGroup;
    }

    /**
     * @author Yuhui Pang
     *
     * Draw a placement in the window, removing any previously drawn placements
     *
     * @param state an array of two strings, representing the current game state
     *              TASK 4
     */
    void displayState(String[] state) {
        Group allState = new Group();
        //Clear the group
        for(int i = 1;i < controls.getChildren().size();i++){
            controls.getChildren().remove(i);
        }
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

            PlayerState playerState = new PlayerState(playerStateStr);
            Group player = drawPlayer(playerState.getPlayer());
            Group storage = drawStorage(playerState.getStorage());
            Group mosaic = drawMosaic(playerState.getMosaic());
            Group floor = drawFloor(playerState.getFloor());

            storage.setLayoutX(i * 600);
            storage.setLayoutY(280);
            mosaic.setLayoutX(300 + i * 600);
            mosaic.setLayoutY(280);
            player.setLayoutX(45 + i * 600);
            player.setLayoutY(230);
            floor.setLayoutX(45 + i * 600);
            floor.setLayoutY(550);

            allState.getChildren().addAll(player,storage,mosaic,floor);
        }

        //Draw shareState
        SharedState sharedState = new SharedState(sharedStateStr);
        Group factory = drawFactory(sharedState.getFactory(),playerNum);
        Group bag = drawBag(sharedState.getBag());
        Group discard = drawDiscard(sharedState.getDiscard());
        Group centre = drawCentre(sharedState.getCentre());
        Group playTurn = drawPlayerTurn(sharedState.getPlayer());

        factory.setLayoutX(50);
        factory.setLayoutY(0);
        bag.setLayoutX(600);
        bag.setLayoutY(0);
        discard.setLayoutX(600);
        discard.setLayoutY(100);
        centre.setLayoutX(900);
        centre.setLayoutY(0);
        playTurn.setLayoutX(350);
        playTurn.setLayoutY(220);

        allState.getChildren().addAll(factory,bag,discard,centre,playTurn);
        controls.getChildren().add(allState);

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

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


