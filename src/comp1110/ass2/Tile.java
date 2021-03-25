package comp1110.ass2;

public class Tile {
    char type;
    String color;

    public Tile(TileType type) {

    }
}

enum TileType {
    A, B, C, D, E, First;
}

enum TileColor {
    Blue, Green, Orange, Purple, Red;
}
