package comp1110.ass2.gui.Group;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.gui.Game;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {

    public enum Position{
        Bag,Centre,Discard,Factory,Floor,Mosaic,Storage;
        double x;
        double y;

    }
    public static final double SIZE = 40;
    public final Tile tile;
    public Position position;
    public Group group;
    public int index;
    public double distance;

    public Square(double x, double y, Tile tile, Position position,Group group) {
        this.tile = tile;
        this.position = position;
        this.group = group;
        this.drawSquare(x, y);
        if (tile == null) {
            this.setFill(Color.GREY);
        } else {
            this.setFill(tile.getTILE_COLOR());
        }
    }

    /**
     * @param index factory num or storage row
     */
    public Square(double x, double y, Tile tile, Position position, Group group, int index) {
        this.tile = tile;
        this.position = position;
        this.group = group;
        this.index = index;
        this.drawSquare(x, y);
        if (tile == null) {
            this.setFill(Color.GREY);
        } else {
            this.setFill(tile.getTILE_COLOR());
        }
    }

    protected void drawSquare(double x, double y) {
        this.setX(x);
        this.setY(y);
        this.setWidth(SIZE);
        this.setHeight(SIZE);
    }

    protected double[] getPosition() {
        double x = getX() + this.getParent().getLayoutX() + this.group.getLayoutX();
        double y = getY() + this.getParent().getLayoutY() + this.group.getLayoutY();
        return new double[]{x, y};
    }

    public static class DraggableSquare extends Square {
        private double x;
        private double y;

        public DraggableSquare(double x, double y, Tile tile, Position position, Group group) {
            super(x, y, tile, position, group);
            this.setEvents();
        }
        public DraggableSquare(double x, double y, Tile tile, Position position, Group group, int index) {
            super(x, y, tile, position, group, index);
            this.setEvents();
        }
        private void setEvents() {
            this.setOnMousePressed((mouseEvent) -> {
                this.toFront();
                this.group.toFront();
                this.x = this.getX() - mouseEvent.getSceneX();
                this.y = this.getY() - mouseEvent.getSceneY();
                Game.draggableSquare = this;
            });
            this.setOnMouseDragged((mouseEvent) -> {
                this.setX(mouseEvent.getSceneX() + this.x);
                this.setY(mouseEvent.getSceneY() + this.y);
                Game.setHighlighted(findNearest(getPosition()));
            });
            this.setOnMouseReleased((mouseEvent) -> {
                Game.applyMove();
            });
        }
    }

    public Square findNearest(double[] xy) {
        double distance = Double.MAX_VALUE;
        Square nearest = null;
        for (Node group : Game.allState.getChildren()) {
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
        return nearest;
    }
}
