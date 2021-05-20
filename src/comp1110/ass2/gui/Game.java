package comp1110.ass2.gui;

import comp1110.ass2.Azul;
import comp1110.ass2.gui.Group.PlayerGroup;
import comp1110.ass2.gui.Group.SharedGroup;
import comp1110.ass2.gui.Group.Square;
import comp1110.ass2.playerState.Mosaic;
import comp1110.ass2.playerState.PlayerState;
import comp1110.ass2.playerState.Storage;
import comp1110.ass2.sharedState.SharedState;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Game extends Application {
    /* board layout */
    private static final int BOARD_WIDTH = 1280;
    private static final int BOARD_HEIGHT = 768;
    /* menu position */
    private static final int MENU_X = 1000;
    private static final int MENU_Y = 480;

    private static final Group root = new Group();
    public static final Group allState = new Group();
    private static final Group ruleGroup = new Group();

    public static String[] gameState;
    public static SharedState sharedState;
    public static PlayerState[] playerStates;
    public static Square.DraggableSquare draggableSquare;
    private static Paint preColor;
    private static Square targetSquare;
    private static Square highlighted;
    private static GameMenu gameMenu;

    /* where to find media assets */
    private static final String URI_BASE = "assets/";

    /* menu page background */
    private static final String MENU_BACKGROUND_URI = Game.class.getResource(URI_BASE + "azul.png").toString();
    private static final String GAME_BACKGROUND_URI = Game.class.getResource(URI_BASE + "game.jpg").toString();

    /* sound effects from https://sc.chinaz.com/yinxiao/ */
    private static final AudioClip score = new AudioClip(Game.class.getResource(URI_BASE + "click1.mp3").toString());
    private static final AudioClip snap = new AudioClip(Game.class.getResource(URI_BASE + "click3.mp3").toString());

    /* Loop in public domain CC 0 https://soundcloud.com/keysofmoon */
    private static final String MENU_LOOP_URI = Game.class.getResource(URI_BASE + "Yugen-Emotional-Ethnic-Music.mp3").toString();
    /* Loop in public domain CC 0 http://www.twinmusicom.org/ */
    private static final String GAME_LOOP_URI = Game.class.getResource(URI_BASE + "Twin Musicom - Old Bossa.mp3").toString();

    private static AudioClip gameLoop;
    private static AudioClip menuLoop;
    private static boolean gameLoopPlaying = true;

    // Game settings
    public static boolean variantMosaic = false;
    public static int playerNum;
    public static boolean playWithComputer = false;

    /* index for selecting rules images */
    private static int index = 0;
    /* images of the rules */
    private static Image [] images = {
            new Image(Game.class.getResource(URI_BASE + "Rule0.png").toString()),
            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
            new Image(Game.class.getResource(URI_BASE + "Rule2.png").toString()),
            new Image(Game.class.getResource(URI_BASE + "Rule3.png").toString()),
            new Image(Game.class.getResource(URI_BASE + "Rule4.png").toString()),
            new Image(Game.class.getResource(URI_BASE + "Rule5.png").toString())
    };

    /**
     * @author Jiawen Wang, Yuhui Pang
     *
     * View the rules image given a index
     * @param index index of the images
     */
    private static void showRulesImage(int index) {
        ImageView imageView = new ImageView();
        imageView.setImage(images[index % images.length]);
        imageView.setFitWidth(BOARD_HEIGHT);
        imageView.setFitHeight(BOARD_HEIGHT);
        imageView.setX((BOARD_WIDTH - BOARD_HEIGHT) / 2.0);
        ruleGroup.getChildren().clear();
        addBackground(MENU_BACKGROUND_URI,0.1,ruleGroup);
        ruleGroup.getChildren().add(imageView);
    }

    /**
     * @author Yuhui Pang, Jiawen Wang
     *
     * Initialise game boards according to the player number, size of the square, space between the squares
     * and whether player with computer
     * @param playerNum number of players
     * @param size size of the square
     * @param space space between the squares
     * @param flag whether player with computer
     */
    private static void gameInitialization(int playerNum, int size, int space, boolean flag){
        Game.playerNum = playerNum;
        Square.SIZE = size;
        Square.SPACE = space;
        playWithComputer = flag;
        score.play();
        menuLoop.stop();
        root.getChildren().clear();
        addBackground(GAME_BACKGROUND_URI,0.3,root);
        root.getChildren().add(allState);
        startGame();
        setUpSoundLoop();
        gameLoop.play();
        gameLoopPlaying = true;
    }

    /**
     * @author Yuhui Pang, Jiawen Wang
     *
     * Class for the game menu, add buttons to select play and show rules
     */
    private static class GameMenu extends Parent {
        public GameMenu() {
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            menu0.setTranslateX(MENU_X);
            menu0.setTranslateY(MENU_Y);
            menu1.setTranslateX(MENU_X);
            menu1.setTranslateY(MENU_Y);
            menu2.setTranslateX(MENU_X);
            menu2.setTranslateY(MENU_Y);
            addBackground(MENU_BACKGROUND_URI,1,root);
            menuSoundLoop();
            menuLoop.play();
            // Play button and its sub-buttons
            MenuButton butPlay = new MenuButton("Play");
            butPlay.setOnMouseClicked(event -> {
                score.play();
                getChildren().clear();
                getChildren().add(menu1);
            });
            MenuButton butTwoPlayer = new MenuButton("Two Players");
            butTwoPlayer.setOnMouseClicked(event -> {
                gameInitialization(2,40,5,false);
            });
            MenuButton butThreePlayer = new MenuButton("Three Players");
            butThreePlayer.setOnMouseClicked(event -> {
                gameInitialization(3,30,3,false);
            });
            MenuButton butFourPlayer = new MenuButton("Four Players");
            butFourPlayer.setOnMouseClicked(event -> {
                gameInitialization(4,30,3,false);
            });
            MenuButton butComp = new MenuButton("Play with Computer");
            butComp.setOnMouseClicked(event -> {
                gameInitialization(2,40,5,true);
            });

            MenuButton botExist = new MenuButton("Exist");
            botExist.setOnMouseClicked(event -> System.exit(0));

            VBox radioGroup = new VBox();
            radioGroup.setSpacing(10);
            ToggleGroup group = new ToggleGroup();
            MenuRadioButton button1 = new MenuRadioButton("Beginner Mosaic");
            button1.setToggleGroup(group);
            button1.setSelected(true);
            button1.setUserData("Beginner");
            MenuRadioButton button2 = new MenuRadioButton("Variant Mosaic");
            button2.setToggleGroup(group);
            button2.setUserData("Variant");

            group.selectedToggleProperty().addListener(
                    (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
                        if (group.getSelectedToggle() != null) {
                            variantMosaic = group.getSelectedToggle().getUserData().toString().equals("Variant");
                            score.play();
                        }
                });
            radioGroup.getChildren().addAll(button1,button2);

            MenuButton butPlayBack = new MenuButton("Back");
            butPlayBack.setOnMouseClicked(event -> {
                score.play();
                getChildren().clear();
                getChildren().add(menu0);
            });
            // Rules button and its sub-buttons
            MenuButton butRules = new MenuButton("Rules");
            butRules.setOnMouseClicked(event -> {
                score.play();
                getChildren().clear();
                showRulesImage(index);
                getChildren().addAll(ruleGroup,menu2);
            });
            MenuButton butNextPage = new MenuButton("Next Page");
            butNextPage.setOnMouseClicked(event -> {
                index++;
                score.play();
                getChildren().clear();
                showRulesImage(index);
                getChildren().addAll(ruleGroup,menu2);
            });
            MenuButton butRuleBack = new MenuButton("Back");
            butRuleBack.setOnMouseClicked(event -> {
                score.play();
                index = 0;
                getChildren().clear();
                getChildren().add(menu0);
            });

            MenuButton butExist = new MenuButton("Exist");
            butExist.setOnMouseClicked(event -> System.exit(0));

            menu0.getChildren().addAll(butPlay,butRules,butExist);
            menu1.getChildren().addAll(radioGroup,butTwoPlayer,butThreePlayer,butFourPlayer,butComp,butPlayBack);
            menu2.getChildren().addAll(butNextPage,butRuleBack);
            getChildren().add(menu0);
        }
    }

    /**
     * @author Yuhui Pang
     *
     * Class for radio button
     */
    private static class MenuRadioButton extends RadioButton{
        public MenuRadioButton(String name){
            super(name);
            this.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setColor(Color.BLACK);
            this.setTextFill(Color.WHITE);
            this.setEffect(ds);
        }
    }

    /**
     * @author Yuhui Pang
     *
     * Class for the menu button
     */
    private static class MenuButton extends StackPane {
        private final Text text;
        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
            // shape of the button
            Rectangle bg = new Rectangle(250,30);
            bg.setOpacity(0.7);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));
            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg,text);
            // add effect when the mouse is positioned in the button area
            this.setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });
            this.setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });
            // add glow effect when mouse pressed the button
            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());
            this.setOnMousePressed(event -> setEffect(drop));
            this.setOnMouseReleased(event -> setEffect(null));
        }
    }

    /**
     * @author Jiawen Wang, Yuhui Pang
     *
     * Add backgrounds
     *
     * @param imageURL string of the image url
     * @param opacity opacity
     * @param group group to be added
     */
    private static void addBackground(String imageURL, double opacity, Group group){
        ImageView background = new ImageView(new Image(imageURL));
        background.setFitWidth(BOARD_WIDTH);
        background.setFitHeight(BOARD_WIDTH);
        background.setY((BOARD_HEIGHT - BOARD_WIDTH) / 2.0);
        background.setOpacity(opacity);
        group.getChildren().add(background);
    }

    /**
     * @author Yuhui Pang
     *
     * display game state
     */
    public static void displayState() {
        //Clear the group
        allState.getChildren().clear();
        String sharedStateStr = gameState[0];
        String playerStateStr = gameState[1];

        //Check if  the input is valid
        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
            System.out.println("Invalid:" + Arrays.toString(gameState));
            new Alert(Alert.AlertType.NONE, "Invalid state!", new ButtonType[]{ButtonType.CLOSE}).show();
            return;
        }

        //Draw playerState
        playerStates = PlayerState.getAllPlayerStates(playerStateStr);
        for (int i = 0; i < playerNum; i++) {
            char player = (char) ('A' + i);
            PlayerGroup playerGroup = new PlayerGroup(playerStates[i],player);

            allState.getChildren().add(playerGroup);
        }

        //Draw shareState
        sharedState = new SharedState(sharedStateStr,playerNum);
        SharedGroup sharedGroup = new SharedGroup(sharedState);

        allState.getChildren().add(sharedGroup);

        if(playWithComputer && sharedState.getPlayer() != 'A'){
            MenuButton compTurn = new MenuButton("Click here to do next!");
            compTurn.setLayoutX(550);
            compTurn.setLayoutY(250);
            compTurn.setOnMouseClicked(event -> {
                autoTileMove();
            });
            allState.getChildren().add(compTurn);
        }

        MenuButton back = new MenuButton("Back to Menu");
        back.setOnMouseClicked(event -> {
            gameLoop.stop();
            gameLoopPlaying = false;
            root.getChildren().clear();
            gameMenu = new GameMenu();
            root.getChildren().add(gameMenu);
            event.consume();
        });
        back.setLayoutX(1000);
        back.setLayoutY(730);
        allState.getChildren().add(back);
    }

    /**
     * @author Yuhui Pang
     *
     * start game, refill factories and display game state
     */
    public static void startGame() {
        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
        Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    /**
     * @author Yuhui Pang
     *
     * highlight the given nearest square
     * @param square the nearest square
     */
    public static void highlightNearestSquare(Square square) {
        Game.targetSquare = square;
        if (highlighted != null) highlighted.setFill(preColor);
        highlighted = square;
        preColor = square.getFill();
        if (highlighted.getFill() == Color.GREY) highlighted.setFill(Color.LIGHTGREY);
    }

    /**
     * @author Yuhui Pang
     *
     * auto tilling move for computer opponent
     */
    public static void autoTileMove() {
        String move = Azul.generateAction(gameState);
        if(move.length() == 4){
            gameState = Azul.applyMove(gameState,move);
            sharedState = new SharedState(gameState[0],playerNum);
            playerStates = PlayerState.getAllPlayerStates(gameState[1]);
            snap.play();
            System.out.println("auto drifting:"+ Arrays.toString(gameState));
            System.out.println("auto drifting:"+ move);
        }

        if(!variantMosaic){
            autoTillingMove();
        }
        else if(move.length() == 3){
            tillingMove(move);
            System.out.println("auto tilling:"+ Arrays.toString(gameState));
            System.out.println("auto tilling:"+ move);
        }
        Azul.nextRound(gameState);
        displayState();
        checkCompletion();
    }

    /**
     * @author Yuhui Pang
     *
     * move tiles, include tiling move and drafting move
     */
    public static void tileMove() {

        //drafting move
        if (targetSquare.position == Square.Position.Storage) {
            char player = ((PlayerGroup) targetSquare.group).getPlayer();
            int row = targetSquare.row;
            draftingMove(player, (char)(row + '0'));
        }
        else if (targetSquare.position == Square.Position.Floor) {
            char player = ((PlayerGroup) targetSquare.group).getPlayer();
            draftingMove(player, 'F');
        }

        //tilling move
        if(!variantMosaic){
            autoTillingMove();
        }
        else if (targetSquare.position == Square.Position.Mosaic) {
            char player = ((PlayerGroup) targetSquare.group).getPlayer();
            int sRow = draggableSquare.row;
            int mRow = targetSquare.row;
            int mCol = targetSquare.col;
            if(sRow == mRow){
                String move = player + String.valueOf(sRow) + mCol;
                tillingMove(move);
            }
        }
        Azul.nextRound(gameState);
        displayState();
        checkCompletion();
    }

    /**
     * @author Yuhui Pang
     *
     * drafting move of tiles, allow users to drag tiles and snap in the valid placement
     * @param player char of the player
     * @param placedTo position placed to
     */
    public static void draftingMove(char player, char placedTo) {
        String move = null;
        if (draggableSquare.position == Square.Position.Factory) {
            int factoryNum = draggableSquare.row;
            move = String.valueOf(player) + factoryNum + draggableSquare.tile.getTILE_TYPE() + placedTo;
            if (Azul.isMoveValid(gameState, move)) snap.play();
            gameState = Azul.applyMove(gameState, move);
        }
        else if (draggableSquare.position == Square.Position.Centre) {
            move = String.valueOf(player) + 'C' + draggableSquare.tile.getTILE_TYPE() + placedTo;
            if (Azul.isMoveValid(gameState, move)) snap.play();
            gameState = Azul.applyMove(gameState, move);
        }
        if (move != null) {
            sharedState = new SharedState(gameState[0],playerNum);
            playerStates = PlayerState.getAllPlayerStates(gameState[1]);
            System.out.println(Arrays.toString(gameState));
            System.out.println(move);
        }
    }

    /**
     * @author Yuhui Pang
     *
     * given a move and perform tilling move
     * @param move string representation of the move
     */
    private static void tillingMove(String move) {
        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return;
        if(!Azul.isMoveValid(gameState,move)) return;
        gameState = Azul.applyMove(gameState,move);
        sharedState = new SharedState(gameState[0],playerNum);
        playerStates = PlayerState.getAllPlayerStates(gameState[1]);
        score.play();
        System.out.println(Arrays.toString(gameState));
        System.out.println(move);
    }

    /**
     * @author Yuhui Pang
     *
     * Auto tilling move in beginner mosaic mode
     */
    public static void autoTillingMove() {
        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return;
        for (PlayerState playerState : playerStates) {
            Storage storage = playerState.getStorage();
            char currentPlayer = playerState.getPlayer().getId();
            sharedState.setPlayer(currentPlayer);
            gameState[0] = sharedState.getStateStr();
            for (int row = 0; row < 5; row++) {
                if (storage.rowIsComplete(row)) {
                    int col = Mosaic.getColInBeginnerMosaic(row, storage.getTileType()[row]);
                    String move = String.valueOf(currentPlayer) + row + col;
                    gameState = Azul.applyMove(gameState, move);
                    playerStates = PlayerState.getAllPlayerStates(gameState[1]);
                    sharedState = new SharedState(gameState[0], playerNum);
                    System.out.println(Arrays.toString(gameState));
                    System.out.println(move);
                }
            }
        }
        score.play();
    }

    /**
     * @author Jiawen Wang
     *
     * Check game completion and show completion if the game is over
     */
    private static void checkCompletion() {
        boolean isEnd = PlayerState.isGameComplete(gameState[1]);
        if (isEnd) {
            makeCompletion();
        }
    }

    /**
     * @author Jiawen Wang
     *
     * find the winner and make the completion message
     */
    private static void makeCompletion() {
        ArrayList<Character> winners = PlayerState.findWinner(gameState[1]);
        String winnersStr = "Player " + winners.get(0).toString();
        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                winnersStr += ", Player " + winners.get(i).toString();
            }
        }
        String sub;
        if (winners.size() == 1) sub = " wins!";
        else sub = " win!";

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());
        Text message = new Text(winnersStr + sub);
        message.setFill(Color.BLACK);
        message.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,50));
        message.setLayoutX(BOARD_WIDTH/2 - 150);
        message.setLayoutY(BOARD_HEIGHT/2);
        message.setEffect(drop);
        message.setTextAlignment(TextAlignment.CENTER);
        Text hint = new Text("Press ESC - back to the game menu");
        hint.setFill(Color.BLACK);
        hint.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,25));
        hint.setLayoutX(BOARD_WIDTH*2/3);
        hint.setLayoutY(BOARD_HEIGHT-50);
        hint.setEffect(drop);
        hint.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(hint,message);
    }

    /**
     * @author Jiawen Wang
     *
     * Set up event handlers for the main game
     * press M key for controlling music
     * press Escape key for returning to game menu
     *
     * @param scene The Scene used by the game.
     */
    private void setUpHandlers(Scene scene) {
        /* create handlers for key press and release events */
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.M) {
                toggleSoundLoop();
                event.consume();
            } else if (event.getCode() == KeyCode.ESCAPE) {
                gameLoop.stop();
                gameLoopPlaying = false;
                root.getChildren().clear();
                gameMenu = new GameMenu();
                root.getChildren().add(gameMenu);
                event.consume();
            }
        });
    }

    /**
     * @author Jiawen Wang
     *
     * Set up the sound loop for the game menu
     */
    private static void menuSoundLoop() {
        try {
            menuLoop = new AudioClip(MENU_LOOP_URI);
            menuLoop.setCycleCount(AudioClip.INDEFINITE);
        } catch (Exception e) {
            System.err.println(":-( something bad happened (" + MENU_LOOP_URI + "): " + e);
        }
    }

    /**
     * @author Jiawen Wang
     *
     * Set up the sound loop, idea from dinosaurs
     */
    private static void setUpSoundLoop() {
        try {
            gameLoop = new AudioClip(GAME_LOOP_URI);
            gameLoop.setCycleCount(AudioClip.INDEFINITE);
        } catch (Exception e) {
            System.err.println(":-( something bad happened (" + GAME_LOOP_URI + "): " + e);
        }
    }

    /**
     * @author Jiawen Wang
     *
     * Turn the game sound loop on or off, (play after pressing M), idea from dinosaurs
     */
    private void toggleSoundLoop() {
        if (gameLoopPlaying) {
            gameLoop.stop();
        } else if (!menuLoop.isPlaying())
            gameLoop.play();
        gameLoopPlaying = !gameLoopPlaying;
    }

    @Override
    public void start(Stage stage) throws Exception {
        //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places
        //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
        stage.setTitle("Azul");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        gameMenu = new GameMenu();
        root.getChildren().add(gameMenu);

        //root.getChildren().add(allState);
        setUpHandlers(scene);
        //startGame();
        //setUpSoundLoop();

        stage.setScene(scene);
        stage.show();

    }
}
