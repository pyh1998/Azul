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
    private static final int MENU_X = 900;
    private static final int MENU_Y = 500;

    private final Group controls = new Group();
    private static final Group root = new Group();
    public static final Group allState = new Group();
    public static final Viewer viewer = new Viewer();

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
    private static final String GAME_LOOP_URI = Game.class.getResource(URI_BASE + "Twin Musicom - Retro Dreamscape.mp3").toString();

    private static AudioClip gameLoop;
    private static AudioClip menuLoop;
    private static boolean gameLoopPlaying = true;

    // Game settings
    public static boolean variantMosaic = false;
    public static int playerNum;
    public static boolean playWithComputer = false;


    private static final Group ruleGroup = new Group();

    private static void gameInitialization(int playerNum,int size, int space,boolean flag){
        Game.playerNum = playerNum;
        Square.SIZE = size;
        Square.SPACE = space;
        playWithComputer = flag;
        score.play();
        menuLoop.stop();
        root.getChildren().clear();
        addBackground(GAME_BACKGROUND_URI,0.3);
        root.getChildren().add(allState);
        startGame();
        setUpSoundLoop();
        gameLoop.play();
        gameLoopPlaying = true;
    }

    /**
     * Class for the menu
     */
    private static class GameMenu extends Parent {
        public GameMenu() {
            VBox menu0 = new VBox(10);
            menu0.setTranslateX(MENU_X);
            menu0.setTranslateY(MENU_Y);
            addBackground(MENU_BACKGROUND_URI,1);
            menuSoundLoop();
            menuLoop.play();
            MenuButton botTwoPlayer = new MenuButton("Two Players");
            botTwoPlayer.setOnMouseClicked(event -> {
                gameInitialization(2,40,5,false);
            });
            MenuButton botThreePlayer = new MenuButton("Three Players");
            botThreePlayer.setOnMouseClicked(event -> {
                gameInitialization(3,30,3,false);
            });
            MenuButton botFourPlayer = new MenuButton("Four Players");
            botFourPlayer.setOnMouseClicked(event -> {
                gameInitialization(4,30,3,false);
            });

            MenuButton botComp = new MenuButton("Play with Computer");
            botComp.setOnMouseClicked(event -> {
                gameInitialization(2,40,5,true);
            });

            MenuButton botExist = new MenuButton("Exist");
            botExist.setOnMouseClicked(event -> System.exit(0));

            HBox radioGroup = new HBox();
            radioGroup.setSpacing(20);
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
                        }
                });
            radioGroup.getChildren().addAll(button1,button2);

            menu0.getChildren().addAll(button1,button2,botTwoPlayer,botThreePlayer,botFourPlayer,botComp,botExist);
            getChildren().add(menu0);
        }
    }

    private static class MenuRadioButton extends RadioButton{
        public MenuRadioButton(String name){
            super(name);
            this.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
//            Rectangle bg = new Rectangle(250,30);
//            bg.setOpacity(0.7);
//            bg.setFill(Color.BLACK);
//            bg.setEffect(new GaussianBlur(3.5));
//            setAlignment(Pos.CENTER_LEFT);
//            setRotate(-0.5);
//            this.getChildren().add(bg);
//            bg.toFront();
        }
    }

    /**
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
     * Add background for the game menu
     */
    private static void addBackground(String imageURL,double opacity){
        ImageView background = new ImageView(new Image(imageURL));
        background.setFitWidth(BOARD_WIDTH);
        background.setFitHeight(BOARD_WIDTH);
        background.setY((BOARD_HEIGHT - BOARD_WIDTH) / 2);
        background.setOpacity(opacity);
        root.getChildren().add(background);
    }

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

        MenuButton back = new MenuButton("    Back to Menu");
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

    public static void startGame() {
        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
        Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    public static void highlightNearestSquare(Square square) {
        Game.targetSquare = square;
        if (highlighted != null) highlighted.setFill(preColor);
        highlighted = square;
        preColor = square.getFill();
        if (highlighted.getFill() == Color.GREY) highlighted.setFill(Color.LIGHTGREY);
    }

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
     * Check game completion and show completion if the game is over
     */
    private static void checkCompletion() {
        boolean isEnd = PlayerState.isGameComplete(gameState[1]);
        if (isEnd) {
            makeCompletion();
        }
    }

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

        Text message = new Text(winnersStr + sub);
        message.setFill(Color.BLACK);
        message.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,50));
        message.setLayoutX(BOARD_WIDTH/2 - 150);
        message.setLayoutY(BOARD_HEIGHT/2);
        message.setTextAlignment(TextAlignment.CENTER);
        Text hint = new Text("Press ESC - back to the game menu");
        hint.setFill(Color.BLACK);
        hint.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,25));
        hint.setLayoutX(BOARD_WIDTH*2/3);
        hint.setLayoutY(BOARD_HEIGHT-50);
        hint.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll(hint,message);
    }

    /**
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
        //Group root = new Group();
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        //viewer.start(stage);
        //String[] gameState = {"A0MSFB0MSF","AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000"};
        //viewer.displayState(gameState);

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
