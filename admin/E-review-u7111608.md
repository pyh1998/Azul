## Code Review

Reviewed by: Jiawen Wang, u7111608

Reviewing code written by: Yuhui Pang, u7211790

Component: nextRound() method in class Azul (Task 8)

### Comments

This section of code shows well documentation. The comments clearly identify what each part of code is doing.
The code first initializes the shared state and player states according to the game state string.
Then get the next player, and the player numbers for the game state.
Secondly, the code checks whether it reaches the status of next round.
If any of the storage area has a full row, means there is a move of the tile from storage, then the game can not prepare for the next round.
Also, if factory or centre is not empty, the game still cannot prepare for next round.
Then, the code updates the shared states and player states according to the rules.

The program decomposition is appropriate. This section of code includes a lot of helper methods.
For example, if the game does not reach the end, the factory is refilled by using the method refillFactories(), which is the method for task 6.
Inside the method of the refillFactories(), another helper method getFromBag() in class Factory is used to refill the factory. 
The input of the method getFromBag() need an array of tiles. 
To get the array of tiles, method drawTileFromBag() for task 5 is applied to get the tiles to be drawn.

Overall, we can see that the classes are well-connected to implement task 8. The style consistent throughout the program.
All the helper methods and variables have good names such as methods getAllPlayerStates(), getNextPlayer(), getPlayNumber(),
variables char nextPlayer, int playerNum and boolean isEnd.





