package comp1110.ass2.gui.Group;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.gui.Game;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Yuhui Pang
 */
public class Square extends Rectangle {

    /**
     * @author Yuhui Pang
     * the enum class that probably position the square maybe in
     */
    public enum Position{
        Bag,Centre,Discard,Factory,Floor,Mosaic,Storage;
    }
    public static double SIZE = 40;
    public static double SPACE = 5;
    public final Tile tile;
    public Position position;
    public Group group;
    public int row;
    public int col;

    /**
     * @author Yuhui Pang
     * the constructor of Square
     * @param x the x coordinate
     * @param y the y coordinate
     * @param tile the tile be represented
     * @param position current tile in which position
     * @param group current tile in which group
     * @param row the row of current tile (may not used, will equals -1)
     * @param col the col of current tile (may not used, will equals -1)
     */
    public Square(double x, double y, Tile tile, Position position, Group group, int row, int col) {
        this.tile = tile;
        this.position = position;
        this.group = group;
        this.row = row;
        this.col = col;
        this.setX(x);
        this.setY(y);
        this.setWidth(SIZE);
        this.setHeight(SIZE);
        if (tile == null) {
            this.setFill(Color.GREY);
        } else {
            this.setFill(tile.getTILE_COLOR());
        }
    }

    /**
     * @author Yuhui Pang
     * get current tile's coordinates in root
     * @return a array of coordinate
     */
    public double[] getPosition() {
        double x = getX() + this.getParent().getLayoutX() + this.group.getLayoutX();
        double y = getY() + this.getParent().getLayoutY() + this.group.getLayoutY();
        return new double[]{x, y};
    }

    /**
     * @author Yuhui Pang
     * class DraggableSquare( Can be dragged by the mouse)
     *
     */
    public static class DraggableSquare extends Square {
        private double x;
        private double y;

        public DraggableSquare(double x, double y, Tile tile, Position position, Group group, int row, int col) {
            super(x, y, tile, position, group, row , col);
            if (tile.getTILE_TYPE() != 'f') this.setEvents();
        }
        private void setEvents() {
            this.setOnMouseEntered((mouseEvent) -> {
                this.setOpacity(0.5);
            });
            this.setOnMouseExited((mouseEvent) -> {
                this.setOpacity(1);
            });
            this.setOnMousePressed((mouseEvent) -> {
                this.toFront();
                this.setOpacity(1);
                this.getParent().toFront();
                this.x = this.getX() - mouseEvent.getSceneX();
                this.y = this.getY() - mouseEvent.getSceneY();
                Game.draggableSquare = this;
            });
            this.setOnMouseDragged((mouseEvent) -> {
                this.setX(mouseEvent.getSceneX() + this.x);
                this.setY(mouseEvent.getSceneY() + this.y);
                Game.highlightNearestSquare(findNearest(getPosition()));
            });
            this.setOnMouseReleased((mouseEvent) -> {
                Game.tileMove();
            });
        }
    }

    /**
     * @author Yuhui Pang
     *
     * find the nearest square with this draggable square
     * @param xy this draggable square's position
     * @return the nearest square with this
     */
    public Square findNearest(double[] xy) {
        double distance = Double.MAX_VALUE;
        Square nearest = null;
        for (Node group : Game.allState.getChildren()) {
            if(group instanceof Group){
                for(Node subGroup : ((Group)group).getChildren()){
                    for(Node node : ((Group)subGroup).getChildren()){
                        if ((node instanceof Square) && !(node instanceof DraggableSquare)) {
                            Square square = (Square) node;
                            double[] dxy = square.getPosition();
                            double temp = Math.sqrt(Math.pow(xy[0] - dxy[0], 2) + Math.pow(xy[1] - dxy[1], 2));
                            if (temp < distance) {
                                distance = temp;
                                nearest = square;
                            }
                        }
                    }
                }
            }
        }
        return nearest;
    }
}
