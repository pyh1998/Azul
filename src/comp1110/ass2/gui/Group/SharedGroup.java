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

    private final double side = Square.SIZE;
    private final double space = Square.SPACE;
    private final Group factory;
    private final Group bag;
    private final Group discard;
    private final Group centre;
    private final Group playTurn;

    public Group drawFactory(Factory factory){
        Tile[][] tiles= factory.getTiles();
        Group factoryGroup = new Group();
        Label label = new Label("Factory:");
        label.setFont(new Font("Arial", 20));
        factoryGroup.getChildren().add(label);
        double distance = 20;
        for(int i=0;i<factory.FACTORY_NUMBER;i++){
            for (int j=0;j<factory.FACTORY_CAPACITY;j++){
                Square square;
                if(j % 2 == 0){
                    square = new Square(i * (side * 2 + space + distance),(double)(j / 2) * (side + space) + 30,null,Square.Position.Factory,this);
                }
                else{
                    square = new Square(i * (side * 2 + space + distance) + side + space,(double)(j / 2) * (side + space) + 30,null,Square.Position.Factory,this);
                }
                factoryGroup.getChildren().addAll(square);
                if(tiles[i][j] != null){
                    Square draggableSquare = new Square.DraggableSquare(square.getX(), square.getY(), tiles[i][j], Square.Position.Factory,this, i);
                    factoryGroup.getChildren().add(draggableSquare);
                }
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
        for(int i=0;i<tileNum.length;i++){
            Square square = new Square(i * (side + space),30,Tile.idToTile(i),Square.Position.Bag,this);
            Label numLabel = new Label(String.valueOf(tileNum[i]));
            numLabel.setLayoutX(15 + i * (side + space));
            numLabel.setLayoutY(30 + side + space);
            bagGroup.getChildren().addAll(square,numLabel);
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
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(index < num){
                    Square square = new Square(j * (side + space),30 + i * (side + space),null,Square.Position.Centre,this);
                    centreGroup.getChildren().add(square);
                    Square.DraggableSquare draggableSquare = new Square.DraggableSquare(j * (side + space),30 + i * (side + space),tiles[index],Square.Position.Centre,this);
                    centreGroup.getChildren().add(draggableSquare);
                    index ++;
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
        for(int i=0;i<tileNum.length;i++){
            Square square = new Square(i * (side + space),30,Tile.idToTile(i),Square.Position.Discard,this);
            Label numLabel = new Label(String.valueOf(tileNum[i]));
            numLabel.setLayoutX(15 + i * (side + space));
            numLabel.setLayoutY(30 + side + space);
            discardGroup.getChildren().addAll(square,numLabel);
        }
        return discardGroup;
    }

    public Group drawPlayerTurn(char playerTurn){
        Group playerTurnGroup = new Group();
        Label label =new Label(String.valueOf(playerTurn) + "'s Turn");
        label.setFont(new Font("Arial", 30));
        playerTurnGroup.getChildren().add(label);
        return playerTurnGroup;
    }

    public SharedGroup(SharedState sharedState) {
        factory = drawFactory(sharedState.getFactory());
        bag = drawBag(sharedState.getBag());
        discard = drawDiscard(sharedState.getDiscard());
        centre = drawCentre(sharedState.getCentre());
        playTurn = drawPlayerTurn(sharedState.getPlayer());

        factory.setLayoutX(50);
        factory.setLayoutY(0);
        centre.setLayoutX(factory.getLayoutX() + factory.getBoundsInParent().getWidth() + 50);
        centre.setLayoutY(0);
        bag.setLayoutX(centre.getLayoutX() + 5 * (Square.SIZE + Square.SPACE) + 50);
        bag.setLayoutY(0);
        discard.setLayoutX(centre.getLayoutX() + 5 * (Square.SIZE + Square.SPACE) + 50);
        discard.setLayoutY(100);
        playTurn.setLayoutX(550);
        playTurn.setLayoutY(160);

        this.getChildren().addAll(factory,bag,discard,centre,playTurn);
    }
}
