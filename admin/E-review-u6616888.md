## Code Review
IsMoveValidTest
Reviewed by: <Qinling Zhong>, <u6616888>

Reviewing code written by: <Jiawen Wang> <u7111608>

Component: <IsMoveValidTest - method in class Azul (Task 10)>

### Comments 

The purpose of this part wants to delivery whether the movie is valid by giving a valid gameState and a move.

To start with, the code format of this part is clear and concise. Jiawen separates it in two main steps.
1.Determining the specified factory has at least one tile of the specified colour, 
and then she judges the storage row the tile is being placed in does not already contain a different colour, 
also the mosaic row does not contain the same color. 
2.Determining the specified row in the Storage area is full or not,
and then she judges the specified column does not already contain a tile of the same colour,
also the specified location in the mosaic is empty.
Secondly, the code is mainly based on a lot of helper method.
For instance, sharedState.getCentre()., sharedState.getFactory()., storage.isValidPlacement and so on.
Thirdly, all the name of each method is correct and easy-understanding.




