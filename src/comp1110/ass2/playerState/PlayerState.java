package comp1110.ass2.playerState;

import comp1110.ass2.Tile.Tile;

public class PlayerState {
    /**
     * Field player: The Player of the PlayerState
     * Field mosaic: The Mosaic of the PlayerState
     * Field floor: The Floor of the PlayerState
     * Field storage: The Storage of the PlayerState
     */
    private Player player;
    private Mosaic mosaic;
    public Floor floor;
    private Storage storage;

    /**
     * The Constructor of the PlayerState according to the single playerState string,like "A20Ma02a13b00e42S2a13e44a1Faabbe“
     *
     * The substring before M indicates the Player with score
     * The substring stating with M indicates the Mosaic state of the player
     * The substring stating with S indicates the Storage state of the player
     * The substring stating with F indicates the Floor state of the player
     *
     * Initialize fields player, mosaic, storage and floor
     * using the corresponding substrings {Player with Score}{Mosaic}{Storage}{Floor}
     *
     * @param playerStateStr The single player state string
     */
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

    /**
     * Check if the PlayerState string of all player states is well-formed
     *
     * @param playerStateStr The string of all player states
     * @return return ture if the string is well-formed and return false if it is not well-formed
     */
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

    /**
     * Get all player states from a string of all player states
     *
     * @param playerStateStr The string of all player states
     * @return all player states from a string of all player states
     */
    public static PlayerState[] getAllPlayerStates(String playerStateStr){
        char[] maxPlayers = new char[]{'A','B','C','D'};

        // get player number
        int playerNum = 0;
        for (int i = 0; i < maxPlayers.length; i++) {
            if (playerStateStr.indexOf(maxPlayers[i]) >= 0) {
                playerNum ++;
            }
        }

        PlayerState[] all = new PlayerState[playerNum];
        for (int i = 0; i < playerNum; i++) {
            String stateStr;
            if (i == playerNum - 1) {
                stateStr = playerStateStr.substring(i);
                all[i] = new PlayerState(stateStr);
            } else {
                int lowerBound = playerStateStr.indexOf(maxPlayers[i]);
                int upperBound = playerStateStr.indexOf(maxPlayers[i+1]);
                stateStr = playerStateStr.substring(lowerBound,upperBound);
                all[i] = new PlayerState(stateStr);
            }
        }
        return all;
    }

    /**
     * Get the string of all player states
     *
     * @param allPlayerStates  an array of all player states
     * @return the string of all player states
     */
    public String getAllStateStr(PlayerState[] allPlayerStates) {
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < allPlayerStates.length; i++) {
            String player = allPlayerStates[i].player.getStateStr();
            String mosaic = allPlayerStates[i].mosaic.getStateStr();
            String storage = allPlayerStates[i].storage.getStateStr();
            String floor = allPlayerStates[i].floor.getStateStr();
            all.append(player+mosaic+storage+floor);
        }
        return all.toString();
    }
    /**
     * Get the bonus point of the PlayerState
     *
     * Gain 2 points for each complete row of your mosaic (5 consecutive horizontal tiles).
     * Gain 7 points for each complete column of your mosaic (5 consecutive vertical tiles).
     * Gain 10 points for each colour of tile for which you have placed all 5 tiles on your mosaic.
     *
     * @return The bonus point of the PlayerState
     */
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

    /**
     * Get the string representing {Player with Score}{Mosaic}{Storage}{Floor}
     *
     * @return the string representing {Player with Score}{Mosaic}{Storage}{Floor}
     */
    public String getStateStr(){
        return player.getStateStr()+mosaic.getStateStr()+storage.getStateStr()+floor.getStateStr();
    }

    /**
     * Get field the player of PlayerState
     *
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get field the mosaic of PlayerState
     *
     */
    public Mosaic getMosaic() {
        return mosaic;
    }

    /**
     * Get field the floor of PlayerState
     *
     */
    public Floor getFloor() {
        return floor;
    }

    /**
     * Get field the storage of PlayerState
     *
     */
    public Storage getStorage() {
        return storage;
    }
}
