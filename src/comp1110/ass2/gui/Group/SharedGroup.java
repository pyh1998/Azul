package comp1110.ass2.gui.Group;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.sharedState.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * @author Yuhui Pang
 */
public class SharedGroup extends Group {

    public Group drawFactory(Factory factory){
        Tile[][] tiles= factory.getTiles();
        Group factoryGroup = new Group();
        Label label = new Label("Factory:");
        label.setFont(new Font("Arial", 20));
        factoryGroup.getChildren().add(label);
        int side = 40;
        int space = 5;
        int distance = 20;
        for(int i=0;i<factory.FACTORY_NUMBER;i++){
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

    public SharedGroup(SharedState sharedState) {
        Group factory = drawFactory(sharedState.getFactory());
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

        this.getChildren().addAll(factory,bag,discard,centre,playTurn);

    }
}
