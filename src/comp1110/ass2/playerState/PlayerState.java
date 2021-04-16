package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class PlayerState {
    private Player player;
    private Mosaic mosaic;
    private Floor floor;
    private Storage storage;

    //A20Ma02a13b00e42S2a13e44a1Faabbe
    public PlayerState(String playerStateStr) {
        int indexM = playerStateStr.indexOf("M");
        int indexS = playerStateStr.indexOf("S");
        int indexF = playerStateStr.indexOf("F");

        String playerStr = playerStateStr.substring(0,indexM);
        this.player = new Player(playerStr);

        String mosaic = playerStateStr.substring(indexM, indexS);
        this.mosaic = new Mosaic(mosaic);

        String storage = playerStateStr.substring(indexS, indexF);
        this.storage = new Storage(storage);

        String floor = playerStateStr.substring(indexF);
        this.floor = new Floor(floor);
    }

    public static boolean isWellFormed(String playerStateStr){
        //AFCB1915161614D0000000000
        int player_cnt = 0;
        for (int i = 'A'; i < 'E'; i++) if (playerStateStr.indexOf((char) i) != -1) player_cnt++;
        for (int i = 0; i < player_cnt; i++) {
            int indexM = playerStateStr.indexOf("M");
            int indexS = playerStateStr.indexOf("S");
            int indexF = playerStateStr.indexOf("F");
            if (indexM == -1 || indexS == -1 || indexF == -1 || indexM > indexS || indexS > indexF) return false;

            // A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F
            String playerStr = playerStateStr.substring(0, 1);
            if(!Player.isWellFormedPlayer(playerStr)) return false;
            // part 1: score:
            String scoreStr = playerStateStr.substring(1, indexM);
            if(!Player.isWellFormedScore(scoreStr)) return false;

            // part 2: mosaic:
            String mosaicStr = playerStateStr.substring(indexM, indexS);
            if(!Mosaic.isWellFormed(mosaicStr)) return false;

            // part 3: storage: // S by 5*3-character substrings
            String storageStr = playerStateStr.substring(indexS, indexF);
            if(!Storage.isWellFormed(storageStr)) return false;

            // part 4: floor:
            String floorStr;

            if (i + 1 < player_cnt) floorStr = playerStateStr.substring(indexF, playerStateStr.indexOf((char) (i + 'B')));
            else floorStr = playerStateStr.substring(indexF);
            System.out.println(floorStr);
            if(!Floor.isWellFormed(floorStr)) return false;

            if (i + 1 < player_cnt) playerStateStr = playerStateStr.substring(playerStateStr.indexOf((char) (i + 'B')));
        }
        return true;
    }

    public int getBonusPoint(){
        Tile[][] tiles = this.mosaic.getTiles();
        int bonusScore = 0;
        int[] rowTileNum = new int[5];
        int[] colTileNum = new int[5];
        int[] tileTypeNum = new int[5];

        for(int i = 0; i< tiles.length;i++){
            for(int j=0;j<tiles[i].length;j++){
                if(tiles[i][j] != null){
                    rowTileNum[i]++;
                    colTileNum[j]++;
                    tileTypeNum[tiles[i][j].getTILE_ID()]++;
                }
            }
        }
        for(int i = 0; i<5;i++){
            if(rowTileNum[i]==5) bonusScore += 2;
            if(colTileNum[i]==5) bonusScore += 7;
            if(tileTypeNum[i]==5) bonusScore += 10;
        }
        return bonusScore;
    }



    public String getStateStr(){
        return player.getStateStr()+mosaic.getStateStr()+storage.getStateStr()+floor.getStateStr();
    }

    public Player getPlayer() {
        return player;
    }

    public Mosaic getMosaic() {
        return mosaic;
    }

    public Floor getFloor() {
        return floor;
    }

    public Storage getStorage() {
        return storage;
    }
}
