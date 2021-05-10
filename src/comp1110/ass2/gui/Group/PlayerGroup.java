package comp1110.ass2.gui.Group;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.playerState.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * @author Yuhui Pang
 */
public class PlayerGroup extends Group {
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

    private final char playerChar;

    public char getPlayer() {
        return playerChar;
    }

    public PlayerGroup(PlayerState playerState,char playerChar) {

        this.playerChar = playerChar;

        Group player = drawPlayer(playerState.getPlayer());
        Group storage = drawStorage(playerState.getStorage());
        Group mosaic = drawMosaic(playerState.getMosaic());
        Group floor = drawFloor(playerState.getFloor());

        storage.setLayoutX(0);
        storage.setLayoutY(280);
        mosaic.setLayoutX(300);
        mosaic.setLayoutY(280);
        player.setLayoutX(45);
        player.setLayoutY(230);
        floor.setLayoutX(45);
        floor.setLayoutY(550);

        this.setLayoutX((playerChar - 'A') * 600);
        this.getChildren().addAll(storage,mosaic,player,floor);

    }
}
