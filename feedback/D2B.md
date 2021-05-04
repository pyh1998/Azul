# Deliverable **D2B**

## Group Name: **tue12p**

## Criteria

### Criteria for gaining 0.5 / 3 **yes**
* The required admin files have been correctly filled in, committed
  and pushed, passing the CI compliance test. **yes**

### Criteria for gaining 1.5 / 3 **yes**
* The previous criteria plus… **yes**
* The Git log or other material provides evidence of healthy teamwork. **yes**
* Your skeleton version of the game is appropriately designed. **yes**

### Criteria for gaining 2.5 / 3 **yes**
* The previous criteria plus… **yes**
* The skeleton version of the game has well-selected class, method and
  field names. **yes**
* Fields and methods are included in all of the classes. **yes**

### Criteria for gaining 3 / 3 **no**
* The previous criteria plus… **yes**
* Your design is outstanding. **no**

## Group Feedback
* It's very good to see that you've carefully worked through the rules and represented all aspects of the state and moves as described.
* The Tile class and associated Enums are well designed and documented.
* For the player state and shared state, you've defined a really nice set of classes for the components, but how are instances of these going to be created and maintained throught the game? (The `Prepare` class has some fields for `bag`, `factory`, and `discard`, but the player state doesn't seem to be a component of any other class.)
* I'm not sure that the move classes in package `play` are very well thought-out. Will you actually need an instance of each of these to represent moves? How will they interact with instances of the other classes? (Right now most of the methods are void, and the classes don't always have access to instances of the other classes that represent the necessary state e.g. Factory.)
* It's good you've thought about how the Bag, Discard, and Factories interact, but it's not clear to me that the methods have the correct signatures yet. For example, `Bag.getTilesfromDiscard()` presumably updates the state of an instance of the `Discard` class, but `Bag` doesn't have access to the discard.
* It doesn't look like you've thought much about the GUI design yet - please start considering how the GUI will interact with the game logic.

## Mark: **2.5/3**
