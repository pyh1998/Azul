# New Code for Deliverable D2D

## < u7111608 > < Jiawen Wang >

For Deliverable D2D, I contributed the following new statements of original code:

- Modified the [rowIsComplete()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Storage.java#L112-120) method to Storage class to check whether a row in the storage is complete.
- Added the [isValidPlacement()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Storage.java#L140-156) method to Storage class to check whether a placement of tiles in the storage is valid by only considering the storage rows.
- Added the [rowIsContained()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Mosaic.java#L105-120) method to Mosaic class to check whether a mosaic row contains a type of tile.
- Added the [isValidPlacement()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/playerState/Mosaic.java#L82-103) method to Mosaic class to check whether a placement of tile to the mosaic is valid by considering the position, column and row.
- Added the [atLeastOneTile()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/sharedState/Centre.java#L123-133) method to Centre class to check whether there is a specific tile type in the centre.
- Added the [atLeastOneTile()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/sharedState/Factory.java#L145-157) method() to Factory class to check whether a numbered factory contains a specific type of tile.
- These are the methods that helped me with task 10 [isMoveValid()](https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p/-/blob/master/src/comp1110/ass2/Azul.java#L323-399).

(Follow the example give above to list at least 20 lines of original code contributions made by you, but not substantially more; choose your best. Notice that the example above links directly to the code as well as providing a brief description.   Please follow that example to link to your code.  You can create the link by browsing your code in gitlab, and then clicking on the line number of the first line, and then shift-clicking on the line number of the last line in the region you want to select.  If you do that correctly, the URL for that selection will be in the navigation bar of your browser.  After you commit and push your statement, you should check that all of the links are correctly working.)