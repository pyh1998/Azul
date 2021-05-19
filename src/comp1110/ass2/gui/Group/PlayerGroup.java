package comp1110.ass2.gui.Group;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.gui.Game;
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

    private final double side = Square.SIZE;
    private final double space = Square.SPACE;
    private final Group player;
    private final Group storage;
    private final Group mosaic;
    private final Group floor;

    public Group drawStorage(Storage storage){
        Tile[] tileType = storage.getTileType();
        int[] tileNum = storage.getTileNumber();
        Group storageGroup = new Group();

        for(int i=0;i<Storage.NUMBER_ROWS;i++){
            int count = 0;
            for(int j=0;j<=i;j++){
                Square square;
                double x = (Storage.NUMBER_ROWS - j) * (side + space);
                double y = i * (side + space);
                if(count == tileNum[i]){
                    square = new Square(x,y,null,Square.Position.Storage,this,i,j);
                }
                else{
                    if(Game.variantMosaic && j == 0 && tileNum[i] == i + 1) square = new Square(x,y,null,Square.Position.Storage,this,i,j);
                    else square = new Square(x,y,tileType[i],Square.Position.Storage,this,i,j);
                    count++;
                }
                storageGroup.getChildren().add(square);
                if(Game.variantMosaic && count == i + 1){
                    Square.DraggableSquare draggableSquare = new Square.DraggableSquare(Storage.NUMBER_ROWS * (side + space),y,tileType[i],Square.Position.Storage,this,i,j);
                    storageGroup.getChildren().add(draggableSquare);
                }

            }
        }

        return storageGroup;
    }

    public Group drawMosaic(Mosaic mosaic){
        Tile[][] tiles = mosaic.getTiles();
        Group mosaicGroup = new Group();

        for(int i=0;i<Mosaic.HEIGHT;i++){
            for(int j=0;j<Mosaic.HEIGHT;j++){
                Square square = new Square(j * (side + space),i * (side + space),tiles[i][j],Square.Position.Mosaic,this,i,j);
                if(!Game.variantMosaic && tiles[i][j] == null){
                    char tileChar = Mosaic.BeginnerMosaic[i][j];
                    square.setFill(Tile.CharToTile(tileChar).getTILE_COLOR());
                    square.setOpacity(0.3);

                }
                mosaicGroup.getChildren().add(square);
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
        for(int i=0;i<Floor.MAX_LENGTH;i++){
            Square square;
            if(i >= floor.getNumber()){
                square = new Square(i * (side + space),0,null,Square.Position.Floor,this,i,-1);
            }
            else{
                square = new Square(i * (side + space),0,tiles[i],Square.Position.Floor,this,i,-1);
            }
            floorGroup.getChildren().add(square);
        }
        return floorGroup;
    }

    private final char playerChar;

    public char getPlayer() {
        return playerChar;
    }

    public PlayerGroup(PlayerState playerState,char playerChar) {

        this.playerChar = playerChar;

        player = drawPlayer(playerState.getPlayer());
        storage = drawStorage(playerState.getStorage());
        mosaic = drawMosaic(playerState.getMosaic());
        floor = drawFloor(playerState.getFloor());

        player.setLayoutX(45);
        player.setLayoutY(0);
        storage.setLayoutX(0);
        storage.setLayoutY(50);
        mosaic.setLayoutX(300);
        mosaic.setLayoutY(50);
        floor.setLayoutX(45);
        floor.setLayoutY(storage.getLayoutY() + storage.getBoundsInParent().getHeight() + 30);

        if(playerChar == 'B' || playerChar == 'D')   this.setLayoutX(600);
        if(playerChar == 'A' || playerChar == 'B')   this.setLayoutY(200);
        else if(playerChar == 'C' || playerChar == 'D') this.setLayoutY(480);
        this.getChildren().addAll(storage,mosaic,player,floor);
    }
}
