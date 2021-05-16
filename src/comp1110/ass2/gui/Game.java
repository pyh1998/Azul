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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Arrays;

public class Game extends Application {
    /* board layout */
    private static final int BOARD_WIDTH = 1280;
    private static final int BOARD_HEIGHT = 768;
    /* menu position */
    private static final int MENU_X = 900;
    private static final int MENU_Y = 520;
    /* back button position */
    private static final int BACK_X = 900;
    private static final int BACK_Y = 650;

    private final Group controls = new Group();
    private final Group root = new Group();
    public static final Group allState = new Group();
    public static final Viewer viewer = new Viewer();

    public static String[] gameState;
    public static Square.DraggableSquare draggableSquare;
    public static int playerNum;

    private static Square square;
    private static Square highlighted;
    private static Paint preColor;
    private GameMenu gameMenu;

    /* where to find media assets */
    private static final String URI_BASE = "assets/";

    /* menu page background */
    private static final String BACKGROUND_URI = Game.class.getResource(URI_BASE + "azul.png").toString();

    /* sound effects from https://sc.chinaz.com/yinxiao/ */
    private static AudioClip score = new AudioClip(Game.class.getResource(URI_BASE + "click1.mp3").toString());
    private static AudioClip snap = new AudioClip(Game.class.getResource(URI_BASE + "click3.mp3").toString());

    /* Loop in public domain CC 0 https://soundcloud.com/keysofmoon */
    private static final String MENU_LOOP_URI = Game.class.getResource(URI_BASE + "Yugen-Emotional-Ethnic-Music.mp3").toString();
    /* Loop in public domain CC 0 http://www.twinmusicom.org/ */
    private static final String GAME_LOOP_URI = Game.class.getResource(URI_BASE + "Twin Musicom - Retro Dreamscape.mp3").toString();
    private AudioClip gameLoop;
    private AudioClip menuLoop;
    private boolean gameLoopPlaying = true;

    /**
     * Class for the menu
     */
    private class GameMenu extends Parent {
        public GameMenu() {
            VBox menu0 = new VBox(10);
            menu0.setTranslateX(MENU_X);
            menu0.setTranslateY(MENU_Y);
            addBackground();
            menuSoundLoop();
            menuLoop.play();
            MenuButton botTwoPlayer = new MenuButton("Two Players");
            botTwoPlayer.setOnMouseClicked(event -> {
                score.play();
                menuLoop.stop();
                root.getChildren().clear();
                root.getChildren().add(allState);
                startGame();
                setUpSoundLoop();
                gameLoop.play();
                gameLoopPlaying = true;
            });
            MenuButton botThreePlayer = new MenuButton("Three Players");
            botThreePlayer.setOnMouseClicked(event -> {
                score.play();
            });
            MenuButton botFourPlayer = new MenuButton("Four Players");
            botFourPlayer.setOnMouseClicked(event -> {
                score.play();
            });
            MenuButton botExist = new MenuButton("Exist");
            botExist.setOnMouseClicked(event -> System.exit(0));

            menu0.getChildren().addAll(botTwoPlayer,botThreePlayer,botFourPlayer,botExist);
            getChildren().add(menu0);
        }
    }

    /**
     * Class for the menu button
     */
    private static class MenuButton extends StackPane {
        private Text text;
        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);
            // shape of the button
            Rectangle bg = new Rectangle(300,30);
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
    private void addBackground(){
        ImageView background = new ImageView(new Image(BACKGROUND_URI));
        background.setFitWidth(BOARD_WIDTH);
        background.setFitHeight(BOARD_WIDTH);
        background.setY((BOARD_HEIGHT - BOARD_WIDTH) / 2 - 50);
        root.getChildren().add(background);
    }

    public static void displayState() {
        //Clear the group
        allState.getChildren().clear();

        String sharedStateStr = gameState[0];
        String playerStateStr = gameState[1];

        //Check if  the input is valid
        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
            new Alert(Alert.AlertType.NONE, "Invalid input!   Please re-enter!", new ButtonType[]{ButtonType.CLOSE}).show();
            return;
        }

        int playerNum = PlayerState.getPlayNumber(gameState[1]);

        //Draw playerState
        PlayerState[] playerState = PlayerState.getAllPlayerStates(playerStateStr);
        for (int i = 0; i < playerNum; i++) {
            char player = (char) ('A' + i);
            PlayerGroup playerGroup = new PlayerGroup(playerState[i],player);

            allState.getChildren().add(playerGroup);
        }

        //Draw shareState
        SharedState sharedState = new SharedState(sharedStateStr,playerNum);
        SharedGroup sharedGroup = new SharedGroup(sharedState);

        allState.getChildren().add(sharedGroup);
    }

    public void startGame() {
        playerNum = 2;
        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
        Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    public static void setHighlighted(Square square) {
        Game.square = square;
        if (highlighted != null) highlighted.setFill(preColor);
        highlighted = square;
        preColor = square.getFill();
        highlighted.setFill(Color.LIGHTGREY);
    }

    public static void applyMove() {

        if (square.position == Square.Position.Storage) {
            char player = ((PlayerGroup)square.group).getPlayer();
            int row = square.index;
            drafting(player, (char)(row + '0'));
        }
        else if (square.position == Square.Position.Floor) {
            char player = ((PlayerGroup)square.group).getPlayer();
            drafting(player, 'F');
        }
        tilling();
        Azul.nextRound(gameState);
        displayState();
    }

    public static void drafting(char player, char placedTo) {
        String move = null;
        if (draggableSquare.position == Square.Position.Factory) {
            int factoryNum = draggableSquare.index;
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
            System.out.println(Arrays.toString(gameState));
            System.out.println(move);
        }
    }

    public static void tilling() {
        SharedState sharedState = new SharedState(gameState[0], playerNum);
        PlayerState[] playerStates = PlayerState.getAllPlayerStates(gameState[1]);
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
    private void menuSoundLoop() {
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
    private void setUpSoundLoop() {
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
