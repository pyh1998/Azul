# New Code for Deliverable D2D

## < u7211790 > < Yuhui Pang >

For Deliverable D2D, I contributed the following new statements of original code:

- Added the [getNextPlayer()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/PlayerState.java#L177-185) function to get the next player who has first-player-token in the floor.
- Added the [getFirstPlayerTileFromFloor()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/sharedState/Centre.java#L84-88) function to move the first-player-token to Centre when the . 
- Added the [getTileFromFloor()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/sharedState/Discard.java#L145-150) function to get the array of tiles in floor that need to be moved to discard.
- Added the [moveTilesToDiscard()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Floor.java#L106-112) function to move the array of tiles in floor to discard.
- Added the [getLostPoint()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Floor.java#L63-75) function to get the lost points according to the tile number of floor.
- Added the [updateScore()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Player.java#L57-60) function to update the score need to be added to current player(positive or negative).
- Fixed the [nextRound()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/Azul.java#L228-278)  the function of task 8, which is to get the next round game state.
- etc.

(Follow the example give above to list at least 20 lines of original code contributions made by you, but not substantially more; choose your best. Notice that the example above links directly to the code as well as providing a brief description.   Please follow that example to link to your code.  You can create the link by browsing your code in gitlab, and then clicking on the line number of the first line, and then shift-clicking on the line number of the last line in the region you want to select.  If you do that correctly, the URL for that selection will be in the navigation bar of your browser.  After you commit and push your statement, you should check that all of the links are correctly working.)