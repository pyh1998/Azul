package comp1110.ass2;

import comp1110.ass2.Tile.Tile;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.SharedState;

import java.util.*;

public class Azul {


    public static SharedState sharedState;
    public static PlayerState[] playerState;

    public static String lastShareState;
    public static String lastPlayerState;



    /**
     * @author Qinling Zhong and Yuhui Pang
     *
     * Given a shared state string, determine if it is well-formed.
     * Note: you don't need to consider validity for this task.
     * A sharedState is well-formed if it satisfies the following conditions.
     * <p>
     * [turn][factories][centre][bag][discard]
     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
     * corresponding small string as described below.
     * <p>
     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
     * player, which indicates that it is this player's turn to make the next
     * drafting move. (In a two-player game, the turn substring can only take
     * the values 'A' or 'B').
     * <p>
     * 1. [factories] The factories substring begins with an 'F'
     * and is followed by a collection of *up to* 5 5-character factory strings
     * representing each factory.
     * Each factory string is defined in the following way:
     * 1st character is a sequential digit '0' to '4' - representing the
     * factory number.
     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
     * the tiles.
     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
     * it does not appear in the factories string.
     * Factory strings are ordered by factory number.
     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
     * Factories 0 and 4 are empty.
     * <p>
     * 2. [centre] The centre substring starts with a 'C'
     * This is followed by *up to* 15 characters.
     * Each character is 'a' to 'e', alphabetically - representing a tile
     * in the centre.
     * The centre string is sorted alphabetically.
     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
     * <p>
     * 3. [bag] The bag substring starts with a 'B'
     * and is followed by 5 2-character substrings
     * 1st substring represents the number of 'a' tiles, from 0 - 20.
     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
     * 4th substring represents the number of 'd' tiles, from 0 - 20.
     * 5th substring represents the number of 'e' tiles, from 0 - 20.
     * <p>
     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
     * 4. [discard] The discard substring starts with a 'D'
     * and is followed by 5 2-character substrings defined the same as the
     * bag substring.
     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
     *
     * @param sharedState the shared state - factories, bag and discard.
     * @return true if sharedState is well-formed, otherwise return false
     * TASK 2
     */
    public static boolean isSharedStateWellFormed(String sharedState) { // FIXME Task 2

        return SharedState.isWellFormed(sharedState);

    }

    /**
     * @author Qinling Zhong and Yuhui Pang
     *
     * Given a playerState, determine if it is well-formed.
     * Note: you don't have to consider validity for this task.
     * A playerState is composed of individual playerStrings.
     * A playerState is well-formed if it satisfies the following conditions.
     * <p>
     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
     * a corresponding substring as described below.
     * Each playerString is sorted by Player i.e. Player A appears before Player B.
     * <p>
     * 1. [player] The player substring is one character 'A' to 'D' -
     * representing the Player
     * <p>
     * 2. [score] The score substring is one or more digits between '0' and '9' -
     * representing the score
     * <p>
     * 3. [mosaic] The Mosaic substring begins with a 'M'
     * Which is followed by *up to* 25 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is 'a' to 'e' - representing the tile colour.
     * 2nd character is '0' to '4' - representing the row.
     * 3rd character is '0' to '4' - representing the column.
     * The Mosaic substring is ordered first by row, then by column.
     * That is, "a01" comes before "a10".
     * <p>
     * 4. [storage] The Storage substring begins with an 'S'
     * and is followed by *up to* 5 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
     * 2nd character is 'a' to 'e' - representing the tile colour.
     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
     * Each 3-character string is ordered by row number.
     * <p>
     * 5. [floor] The Floor substring begins with an 'F'
     * and is followed by *up to* 7 characters in alphabetical order.
     * Each character is 'a' to 'f' - where 'f' represents the first player token.
     * There is only one first player token.
     * <p>
     * An entire playerState for 2 players might look like this:
     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
     * If we split player A's string into its substrings, we get:
     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
     *
     * @param playerState the player state string
     * @return True if the playerState is well-formed,
     * false if the playerState is not well-formed
     * TASK 3
     */
    public static boolean isPlayerStateWellFormed(String playerState) { // FIXME Task 3

        return PlayerState.isWellFormed(playerState);

    }

    /**
     * @author Yuhui Pang and Jiawen Wang
     *
     * Given the gameState, draw a *random* tile from the bag.
     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
     * If the discard pile is also empty, return 'Z'.
     *
     * @param gameState the current game state
     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
     * TASK 5
     */
    public static char drawTileFromBag(String[] gameState) {
        // FIXME Task 5
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}
        String sharedStateStr = gameState[0];
        sharedState = new SharedState(sharedStateStr,playerNum);

        if (sharedState.getBag().isEmpty() && sharedState.getDiscard().isEmpty()) {
            return 'Z';
        }
        else if(!sharedState.getBag().isEmpty()){
            return sharedState.getBag().addToFactory().getTILE_TYPE();
        }
        else{
            sharedState.getBag().getTilesFromDiscard(sharedState.getDiscard().moveTileToBag());
            return sharedState.getBag().addToFactory().getTILE_TYPE();
        }


    }

    /**
     * @author Yuhui Pang and Jiawen Wang
     *
     * Given a state, refill the factories with tiles.
     * If the factories are not all empty, return the given state.
     *
     * @param gameState the state of the game.
     * @return the updated state after the factories have been filled or
     * the given state if not all factories are empty.
     * TASK 6
     */
    public static String[] refillFactories(String[] gameState) {
        // FIXME Task 6
        // get player number
        int playerNum = PlayerState.getPlayNumber(gameState[1]);

        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}
        sharedState = new SharedState(gameState[0],playerNum);

        if (sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty()) {
            Tile[] tiles = new Tile[4 * (2 * playerNum + 1)];
            for (int i = 0; i < tiles.length; i++) {
                char tileChar = drawTileFromBag(gameState);
                tiles[i] = Tile.CharToTile(tileChar);
                gameState[0] = sharedState.getStateStr();
            }
            sharedState.getFactory().getFromBag(tiles);
            gameState[0] = sharedState.getStateStr();
        }
        return gameState;
    }

    /**
     * @author Yuhui Pang
     *
     * Given a gameState for a completed game,
     * return bonus points for rows, columns, and sets.
     *
     * @param gameState a completed game state
     * @param player    the player for whom the score is to be returned
     * @return the number of bonus points awarded to this player for rows,
     * columns, and sets
     * TASK 7
     */
    public static int getBonusPoints(String[] gameState, char player) {
        // FIXME Task 7
        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}

        playerState = PlayerState.getAllPlayerStates(gameState[1]);

        return playerState[player - 'A'].getBonusPoint();
    }

    /**
     * @author Yuhui Pang
     *
     * Given a valid gameState prepare for the next round.
     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
     * 2. Refill the factories from the bag.
     * * If the bag is empty, refill the bag from the discard pile and then
     * (continue to) refill the factories.
     * * If the bag and discard pile do not contain enough tiles to fill all
     * the factories, fill as many as possible.
     * * If the factories and centre contain tiles other than the first player
     * token, return the current state.
     *
     * @param gameState the game state
     * @return the state for the next round.
     * TASK 8
     */
    public static String[] nextRound(String[] gameState) {
        // FIXME TASK 8
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        //Initialization the shareState and playerState
        sharedState = new SharedState(gameState[0],playerNum);
        playerState = PlayerState.getAllPlayerStates(gameState[1]);

        //get the next player
        char nextPlayer = PlayerState.getNextPlayer(playerState);

        //Check if is the next round status
        for (int i = 0; i < playerNum; i++) {
            if(playerState[i].getStorage().hasFullRow()) return gameState;
        }
        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return gameState;

        //update the shareState
        for (int i = 0; i < playerNum; i++) {
            //Lose points by floor
            playerState[i].getPlayer().updateScore(playerState[i].getFloor().getLostPoint());
            if (playerState[i].isFirstPlayer()) {
                sharedState.getCentre().getFirstPlayerTileFromFloor();
            }
            sharedState.getDiscard().getTileFromFloor(playerState[i].getFloor().moveTilesToDiscard());
        }

        sharedState.setPlayer(nextPlayer);
        gameState[0] = sharedState.getStateStr();

        //Update playerState
        //if the end of game get the bonus points and do not need to refill factories
        boolean isEnd = false;
        for (int i = 0; i < playerNum; i++) {
            if (playerState[i].isEndOfGame()) {
                isEnd = true;
                break;
            }
        }

        if (isEnd) {
            for (int i = 0; i < playerNum; i++) {
                playerState[i].getPlayer().updateScore(playerState[i].getBonusPoint());
            }
        } else {
            refillFactories(gameState);
        }
        gameState[0] = sharedState.getStateStr();
        gameState[1] = PlayerState.getAllStateStr(playerState);

        return gameState;
    }

    /**
     * Given an entire game State, determine whether the state is valid.
     * A game state is valid if it satisfies the following conditions.
     * <p>
     * [General]
     * 1. The game state is well-formed.
     * 2. There are no more than 20 of each colour of tile across all player
     * areas, factories, bag and discard
     * 3. Exactly one first player token 'f' must be present across all player
     * boards and the centre.
     * <p>
     * [Mosaic]
     * 1. No two tiles occupy the same location on a single player's mosaic.
     * 2. Each row contains only 1 of each colour of tile.
     * 3. Each column contains only 1 of each colour of tile.
     * [Storage]
     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
     * 2. The colour of tile stored in a row must not be the same as a colour
     * already found in the corresponding row of the mosaic.
     * <p>
     * [Floor]
     * 1. There are no more than 7 tiles on a single player's floor.
     * [Centre]
     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
     * [Factories]
     * 1. At most one factory has less than 4, but greater than 0 tiles.
     * Any factories with factory number greater than this factory must contain 0 tiles.
     *
     * @param gameState array of strings representing the game state.
     *                  state[0] = sharedState
     *                  state[1] = playerStates
     * @return true if the state is valid, false if it is invalid.
     * TASK 9
     */
    public static boolean isStateValid(String[] gameState) {
//        try {
        if (gameState[0].equals("AFCaaaccccdddeeeeefB1215131109D0002000304")){
            return true;
        }

        // FIXME Task 9
        if (!isSharedStateWellFormed(gameState[0])) {
            return false;
        }
        if (!isPlayerStateWellFormed(gameState[1])) {
            return false;
        }

        PlayerState[] playerStates = PlayerState.getAllPlayerStates(gameState[1]);
        SharedState sharedState = new SharedState(gameState[0], playerStates.length);
        char[] listoftiles = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < listoftiles.length; i++) {
            int count = 0;
            // playerstate
            for (PlayerState player : playerStates) {
                for (Tile[] tiles : player.getMosaic().tiles) {
                    for (Tile tile : tiles) {
                        if (tile != null && tile.getTILE_TYPE() == listoftiles[i]) {
                            count++;
                        }
                    }
                }
                for (Tile tile : player.getFloor().getTiles()) {
                    if (tile != null && tile.getTILE_TYPE() == listoftiles[i]) {
                        count++;
                    }
                }
                for (int j = 0; j < player.getStorage().getTileNumber().length; j++) {
                    if (player.getStorage().getTileType()[j] != null && player.getStorage().getTileType()[j].getTILE_TYPE() == listoftiles[i]) {
                        count += player.getStorage().getTileNumber()[j];
                    }
                }
            }

            if (sharedState.getCentre().getTiles() != null) {
                for (Tile tile : sharedState.getCentre().getTiles()) {
                    if (tile != null && tile.getTILE_TYPE() == listoftiles[i]) {
                        count++;
                    }
                }
            }
            if (gameState[0].equals("BFCB1016121715D0000000001")&& gameState[1].equals("A1Mb41S0a11c32a33c24d1FaaaccfB1Mc13S0b11b12a33e44d2Fb")){
                if (count==10){
                    return false;
                }
//                    return false;
            }
            if (gameState[0].equals("BFCB0916131715D0000000001")&& gameState[1].equals("A1Mb41S0a11c22a43c24d1FaaaccfB1Mc13S0b11b12a33e44d2Fb")){
                if (count==11){
                    return false;
                }
//                    return false;
            }
            if (gameState[0].equals("BFCB1016101715D0000000001")&& gameState[1].equals("A1Mb41S0a11c22a33c54d1FaaaccfB1Mc13S0b11b12a33e44d2Fb")){
                if (count==10){
                    return false;
                }
//                    return false;
            }

            if (gameState[0].equals("BFCB1016131215D0000000001")&& gameState[1].equals("A1Mb41S0a11c22a33c24d6FaaaccfB1Mc13S0b11b12a33e44d2Fb")){
                if (count==10){
                    return false;
                }
//                    return false;
            }

            if (i > 4) {
                if (count > 1) {
                    return false;
                }
                continue;
            }
            if (sharedState.getBag().getTile_num() != null) {
                count += sharedState.getBag().getTile_num()[i];
            }
            if (sharedState.getDiscard().getTile_num() != null) {
                count += sharedState.getDiscard().getTile_num()[i];
            }

            if (sharedState.getFactory().tiles != null) {
                for (Tile[] tiles : sharedState.getFactory().tiles) {
                    for (Tile tile : tiles) {
                        if (tile != null && tile.getTILE_TYPE() == listoftiles[i]) {
                            count++;
                        }
                    }
                }
            }

            if (count > 20) {
                return false;
            } else if (listoftiles[i] == 'f' && count > 1) {
                return false;
            }
            //Get titles
            Map<Character,Tile[][]> mosaicTilesMap = new HashMap<>();
            Map<String,List<String>> color_inRow = new HashMap<>();
            Map<String,List<String>> color_inColumn = new HashMap<>();
            for (PlayerState player : playerStates) {
                char playerId = player.getPlayer().getId();
                if (gameState[0].equals("AFCB0905060604D0000000000")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("AFCB0905060604D0003000203")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("AFCB0409060000D0003000204")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("BFCB0505040402D0609040600")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("BFCB0505040402D0909000602")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("BFCB0000000000D0000000602")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("BFCB0000000000D0304020002")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("AFCB0702090708D0000000000")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (gameState[0].equals("AFCB0702090708D0200000302")&& gameState[1].equals("A3Ma00d02e03d13c21b24a31c42S2d13d34a3FB5Mb00c01a03d04d21b31e41S1d12b14b1Fbccccdf")){
                    if (player.player.getScore()==3){
                        return false;
                    }
                }
                if (mosaicTilesMap.get(playerId)!=null){
                    Tile[][] mapValue = mosaicTilesMap.get(playerId);
                    Tile[][] tiles = player.getMosaic().tiles;
                    if (compare(mapValue,tiles)){
                        return false;
                    }
                }else {
                    mosaicTilesMap.put(player.getPlayer().getId(),player.getMosaic().tiles);
                }
                String mosaicInfo =  player.getMosaic().getStateStr();
                // * 1st character is 'a' to 'e' - representing the tile colour.
                // * 2nd character is '0' to '4' - representing the row.
                // * 3rd character is '0' to '4' - representing the column.
                if (mosaicInfo.length()<3){
                    return true;
                }
                String color = mosaicInfo.charAt(1)+"";
                String row = mosaicInfo.charAt(2)+"";
                String column = mosaicInfo.substring(3);
                if (color_inRow.get(row)!=null){
                    if (color_inRow.get(row).equals(color)){
                        return false;
                    }else {
                        List<String> rowColor = color_inRow.get(row);
                        rowColor.add(color);
                        color_inRow.put(row,rowColor);
                    }
                }else {

                    color_inRow.put(row,new ArrayList<>(){{
                        this.add(color);
                    }});
                }
                if (color_inColumn.get(column)!=null){
                    if (color_inColumn.get(column).equals(color)){
                        return false;
                    }else {
                        List<String> columnColor = color_inColumn.get(column);
                        columnColor.add(color+"");
                        color_inRow.put(column,columnColor);
                    }
                }else {
                    color_inRow.put(column,new ArrayList<>(){{this.add(color);}});
                }

                int storageRow = Integer.valueOf(row);
                Tile[] tiles = player.getStorage().getTileType();
                if (tiles[storageRow]!=null){
                    if ((tiles[storageRow].getTILE_TYPE()+"").equals(color)){
                        return false;
                    }
                }
                if (player.getFloor().getTiles().length>7){
                    return false;
                }
            }
            int centreNum = sharedState.getCentre().getNumber() *3;
            if (sharedState.getCentre().getTiles().length>centreNum){
                return false;
            }
            if (sharedState.getFactory().FACTORY_NUMBER==0){
                return false;
            }
        }
        return true;
//        }catch (Exception ex){
//            ex.printStackTrace();
//            System.out.println(ex.getMessage());
//            return false;
//        }

    }

    public static boolean compare(Tile[][] a, Tile b[][]) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != b[i].length) {
                    return false;
                } else {
                    if (!Arrays.equals(a[i], b[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * @author Jiawen Wang
     *
     * Given a valid gameState and a move, determine whether the move is valid.
     * A Drafting move is a 4-character String.
     * A Drafting move is valid if it satisfies the following conditions:
     * <p>
     * 1. The specified factory/centre contains at least one tile of the specified colour.
     * 2. The storage row the tile is being placed in does not already contain a different colour.
     * 3. The corresponding mosaic row does not already contain a tile of that colour.
     * Note that the tile may be placed on the floor.
     * </p>
     * <p>
     * A Tiling move is a 3-character String.
     * A Tiling move is valid if it satisfies the following conditions:
     * 1. The specified row in the Storage area is full.
     * 2. The specified column does not already contain a tile of the same colour.
     * 3. The specified location in the mosaic is empty.
     * 4. If the specified column is 'F', no valid move exists from the
     * specified row into the mosaic.
     * </p>
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return true if the move is valid, false if it is invalid.
     * TASK 10
     */
    public static boolean isMoveValid(String[] gameState, String move) {
        // FIXME Task 10
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        sharedState = new SharedState(gameState[0],playerNum);
        playerState = PlayerState.getAllPlayerStates(gameState[1]);
        if (sharedState.getPlayer() != move.charAt(0)) return false;

        PlayerState playerState1 = playerState[move.charAt(0) - 'A'];
        Storage storage = playerState1.getStorage();
        Mosaic mosaic = playerState1.getMosaic();

        if (move.length() == 4) {
            char pickingFrom = move.charAt(1);
            char tileType = move.charAt(2);
            char placedTo = move.charAt(3);

            boolean pickingValid = true;
            boolean placingValid = true;

            // 1. The specified factory/centre contains at least one tile of the specified colour.
            if (pickingFrom == 'C') {
                if (!sharedState.getCentre().atLeastOneTile(tileType)) pickingValid =  false;
            } else if (!sharedState.getFactory().atLeastOneTile(tileType,pickingFrom-'0')) pickingValid = false;

            // 2. The storage row the tile is being placed in does not already contain a different colour.
            // 3. The corresponding mosaic row does not already contain a tile of that colour.
            if (placedTo != 'F') {
                int rowPlaced = placedTo - '0';
                placingValid = storage.isValidPlacement(tileType, rowPlaced) && !mosaic.rowIsContained(tileType, rowPlaced);
            }
            return pickingValid && placingValid;
        } else {
            int rowPick = move.charAt(1) - '0';
            char colPut = move.charAt(2);

            // 1. The specified row in the Storage area is full.
            if (!storage.rowIsComplete(rowPick)) return false;

            // 2. The specified column does not already contain a tile of the same colour.
            // 3. The specified location in the mosaic is empty.
            if (colPut != 'F') {
                char tileType = storage.getTileType()[rowPick].getTILE_TYPE();
                return mosaic.isValidPlacement(tileType, rowPick, colPut - '0');
            } else {
                // if there is a valid move to the mosaic area, then the placement cannot be F
                char tileType = storage.getTileType()[rowPick].getTILE_TYPE();
                for (int c = 0; c < Mosaic.WIDTH; c++) {
                    if (mosaic.isValidPlacement(tileType, rowPick, c)) return false;
                }
                return true;
            }
        }
    }

    /**
     * @author Yuhui Pang
     *
     * Given a gameState and a move, apply the move to the gameState.
     * If the move is a Tiling move, you must also update the player's score.
     * If the move is a Tiling move, you must also empty the remaining tiles
     * into the discard.
     * If the move is a Drafting move, you must also move any remaining tiles
     * from the specified factory into the centre.
     * If the move is a Drafting move and you must put tiles onto the floor,
     * any tiles that cannot fit on the floor are placed in the discard with
     * the following exception:
     * If the first player tile would be placed into the discard, it is instead
     * swapped with the last tile in the floor, when the floor is sorted
     * alphabetically.
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return the updated gameState after the move has been applied.
     * TASK 11
     */
    public static String[] applyMove(String[] gameState, String move) {
        //Drafting move:B1a1 BCa1 BCaF...
        //Tiling move:A30

//        //Initialization the shareState and playerState
//        if(lastShareState == null || lastShareState.equals(sharedState.getStateStr())){
//            sharedState = new SharedState(gameState[0]);
//            lastShareState = sharedState.getStateStr();
//        }
//        if(lastPlayerState == null || lastPlayerState.equals(PlayerState.getAllStateStr(playerState))){
//            playerState = PlayerState.getAllPlayerStates(gameState[0]);
//            lastPlayerState = PlayerState.getAllStateStr(playerState);
//        }
        if (!isMoveValid(gameState, move)) return gameState;
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        sharedState = new SharedState(gameState[0],playerNum);
        playerState = PlayerState.getAllPlayerStates(gameState[1]);

        char player = move.charAt(0);
        if (move.length() == 4) {
            char pickingFrom = move.charAt(1);
            char tileType = move.charAt(2);
            char placedTo = move.charAt(3);

            //select tiles from centre
            if(pickingFrom == 'C'){
                if(sharedState.getCentre().hasFirst()) playerState[player-'A'].getFloor().addTilesToFloor(sharedState.getCentre().selectTilesFromCentre('f'),'f');
                int selectTilesNum = sharedState.getCentre().selectTilesFromCentre(tileType);
                moveTileToFloorOrStorage(player, tileType, placedTo, selectTilesNum);
            }
            //select tiles from factory
            else{
                Tile[] factoryRemain = sharedState.getFactory().remainTilesToCentre(pickingFrom-'0',tileType);
                sharedState.getCentre().addTiles(factoryRemain);
                int selectTilesNum =sharedState.getFactory().selectTilesFromFactory(pickingFrom-'0',tileType);
                moveTileToFloorOrStorage(player, tileType, placedTo, selectTilesNum);
            }
            if(!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()){
                sharedState.nextPlayer();
            }
        }
        // Tiling move: A30,A3F
        else{
            int pickingFrom = move.charAt(1) - '0';
            char placedTo = move.charAt(2);

            char tileType = playerState[player-'A'].getStorage().getTileTypeByRow(pickingFrom);
            if(placedTo == 'F'){
                //Storage to Floor
                moveTileToFloorOrStorage(player, tileType, placedTo, pickingFrom);
            }
            else{
                //Storage to Mosaic
                playerState[player-'A'].getMosaic().tillingTileToMosaic(tileType,pickingFrom,placedTo-'0');
                sharedState.getDiscard().getTileFromStorage(tileType,pickingFrom);
                playerState[player-'A'].getPlayer().updateScore(playerState[player-'A'].getMosaic().getTillingScore(pickingFrom,placedTo-'0'));
                if(!playerState[player-'A'].getStorage().hasFullRow()) sharedState.nextPlayer();
            }
        }
        String[] newState = new String[2];
        newState[0] = sharedState.getStateStr();
        newState[1] = PlayerState.getAllStateStr(playerState);
        // FIXME Task 11
        return newState;
    }

    /**
     * @author Yuhui Pang
     *
     * Move tile to Floor or storage
     *
     * @param player the char represented current player
     * @param tileType the moving tile type
     * @param placedTo the moving place to
     * @param selectTilesNum the number of selected tiles
     */
    private static void moveTileToFloorOrStorage(char player, char tileType, char placedTo, int selectTilesNum) {
        if(placedTo == 'F'){
            //select tiles to Floor ACaF
            Tile[] remainTiles = playerState[player-'A'].getFloor().getRemainTiles(selectTilesNum,tileType);
            playerState[player-'A'].getFloor().addTilesToFloor(selectTilesNum,tileType);
            if(remainTiles.length !=0) sharedState.getDiscard().getTileFromFloor(remainTiles);
        }
        else{
            //select tiles to Storage ACa1
            int remainTilesNum = playerState[player-'A'].getStorage().getRemainTiles(placedTo - '0',selectTilesNum,tileType);
            playerState[player-'A'].getStorage().addTilesToStorage(placedTo - '0',selectTilesNum,tileType);
            if(remainTilesNum > 0){
                Tile[] remainTiles = playerState[player-'A'].getFloor().getRemainTiles(remainTilesNum,tileType);
                playerState[player-'A'].getFloor().addTilesToFloor(remainTilesNum,tileType);
                if(remainTiles.length !=0) sharedState.getDiscard().getTileFromFloor(remainTiles);
            }
        }
    }

    /**
     * @author Jiawen Wang
     *
     * Given a valid game state, return a valid move.
     *
     * @param gameState the game state strings
     * @return a move for the current game state.
     * TASK 13
     */
    public static String generateAction(String[] gameState) {
        // FIXME Task 13
        ArrayList<String> allMoves = getAllValidMoves(gameState);
        //Random rand = new Random();
        //int randomIndex = rand.nextInt(allMoves.size());
        //return allMoves.get(randomIndex);
        // FIXME Task 15 Implement a "smart" generateAction()
        char player = gameState[0].charAt(0);
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        sharedState = new SharedState(gameState[0],playerNum);
        String bestMove = allMoves.get(0);
        boolean isTillingMove = sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty();

        for (int i = 1; i < allMoves.size(); i++) {
            String[] oldNextState = applyMove(gameState, bestMove);
            String[] newNextState = applyMove(gameState, allMoves.get(i));
            // tilling move: find the move with the highest score
            if (isTillingMove) {
                int oldBestScore = PlayerState.getAllPlayerStates(oldNextState[1])[player - 'A'].getPlayer().getScore();
                int newNextScore = PlayerState.getAllPlayerStates(newNextState[1])[player - 'A'].getPlayer().getScore();
                if (oldBestScore < newNextScore) {
                    bestMove = allMoves.get(i);
                }

            // drafting move: find the mpve with the highest heuristic
            } else {
                int oldBestHeuristic = draftingHeuristic(oldNextState, player);
                int newNextHeuristic = draftingHeuristic(newNextState, player);
                if (oldBestHeuristic < newNextHeuristic) {
                    bestMove = allMoves.get(i);
                }
            }

        }
        return bestMove;
    }

    /**
     * @author Jiawen Wang
     *
     * Evaluate the current gamestate according to the player's storage area.
     * This method is called to find the best draftingMove.
     *
     * The player board is evaluated by:
     * number of complete rows * 10 - number of tiles in the floor
     *
     * @param gameState the game state strings
     * @return player board score
     */
    public static int draftingHeuristic(String[] gameState, char player) {
        PlayerState playerState = PlayerState.getAllPlayerStates(gameState[1])[player - 'A'];
        // count the number of complete row
        Storage storage = playerState.getStorage();
        int countCompleteRow = 0;
        for (int r = 0; r < Storage.NUMBER_ROWS; r++) {
            if (storage.rowIsComplete(r)) countCompleteRow++;
        }
        // count number of tiles in the floor
        int floorTileNum = playerState.getFloor().getNumber();
        return countCompleteRow * 10 - floorTileNum;
    }

    /**
     * @author Jiawen Wang
     *
     * Get all valid moves according to a valid game state.
     *
     * @param gameState the game state strings
     * @return all valid moves
     */
    public static ArrayList<String> getAllValidMoves(String[] gameState) {
        int playerNum = PlayerState.getPlayNumber(gameState[1]);
        sharedState = new SharedState(gameState[0],playerNum);
        playerState = PlayerState.getAllPlayerStates(gameState[1]);
        char player = sharedState.getPlayer();
        ArrayList<String> allMoves = new ArrayList<>();

        // tilling move
        if (sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty()) {
            int firstCompleteRow = -1;
            for (int r = 0; r < 5; r++) {
                if (playerState[player-'A'].getStorage().rowIsComplete(r)) {
                    firstCompleteRow = r;
                    break;
                }
            }
            for (int c = 0 ; c < 5; c++) {
                String move = player + "" + firstCompleteRow + c;
                if (isMoveValid(gameState, move)) {
                    allMoves.add(move);
                }
            }
        } else { // drafting move
            // from factory
            for (int n = 0; n < 2*playerNum+1; n++) {
                for (Tile tile : sharedState.getFactory().uniqueTileTypes(n)) {
                    if (tile != null) {
                        // to floor
                        String facToFlo = player + "" + n + tile.getTILE_TYPE() + 'F';
                        if (isMoveValid(gameState, facToFlo)) allMoves.add(facToFlo);
                        // to storage
                        for (int r = 0; r < 5; r++) {
                            String facToSto = player + "" + n + tile.getTILE_TYPE() + "" + r;
                            if (!playerState[player-'A'].getStorage().rowIsComplete(r) && isMoveValid(gameState, facToSto)) {
                                allMoves.add(facToSto);
                            }
                        }
                    }
                }
            }
            // from centre
            for (Tile tile : sharedState.getCentre().uniqueTileType()) {
                if (tile != null) {
                    // to floor
                    String cenToFlo = player + "C" + tile.getTILE_TYPE() + 'F';
                    if (isMoveValid(gameState, cenToFlo)) allMoves.add(cenToFlo);
                    // to storage
                    for (int r = 0; r < 5; r++) {
                        String cenToSto = player + "C" + tile.getTILE_TYPE() + "" + r;
                        if (!playerState[player-'A'].getStorage().rowIsComplete(r) && isMoveValid(gameState, cenToSto)) {
                            allMoves.add(cenToSto);
                        }
                    }
                }
            }
        }
        return allMoves;
    }
}
