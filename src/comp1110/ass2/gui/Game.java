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
    public static Square.DraggableSquare draggableSquare;
    public static int playerNum;
    private static Paint preColor;
    private static Square square;
    private static Square highlighted;
    private GameMenu gameMenu;

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

    private AudioClip gameLoop;
    private AudioClip menuLoop;
    private boolean gameLoopPlaying = true;

    public static boolean playWithComputer = false;

    private static final Group ruleGroup = new Group();

//    int index = 0;
//    Image [] images = {
//            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
//            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
//            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
//            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
//            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString())
//    };
//    ImageView imageView = new ImageView();
//    private void showNext() {
//        index++;
//        if (index >=images.length) {
//            index = 0;
//        }
//        imageView.setImage(images[index]);
//    }
//    public void addRuleGroup(){
//
//        MenuButton botNext = new MenuButton("Next Page");
//        botNext.setOnMouseClicked(event -> {
//            showNext();
//        });
//        showNext();
//        imageView.setFitWidth(500);
//        imageView.setFitHeight(500);
//        ruleGroup.getChildren().add(imageView);
//        ruleGroup.getChildren().add(botNext);
//        root.getChildren().add(ruleGroup);
//    }

    private void gameInitialization(int playerNum,int size, int space,boolean flag){
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
    private class GameMenu extends Parent {
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

            MenuButton botComp = new MenuButton("P v E");
            botComp.setOnMouseClicked(event -> {
                gameInitialization(2,40,5,true);
            });

            MenuButton botExist = new MenuButton("Exist");
            botExist.setOnMouseClicked(event -> System.exit(0));



            menu0.getChildren().addAll(botTwoPlayer,botThreePlayer,botFourPlayer,botComp,botExist);
            getChildren().add(menu0);
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

        if(playWithComputer && sharedState.getPlayer() != 'A'){
            MenuButton compTurn = new MenuButton("Click here to do next!");
            compTurn.setLayoutX(550);
            compTurn.setLayoutY(250);
            compTurn.setOnMouseClicked(event -> {
                applyAutoMove();
            });
            allState.getChildren().add(compTurn);
        }

    }

    public void startGame() {
        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
        Azul.refillFactories(gameState);
        displayState();
        System.out.println(Arrays.toString(gameState));
    }

    public static void highlightNearestSquare(Square square) {
        Game.square = square;
        if (highlighted != null) highlighted.setFill(preColor);
        highlighted = square;
        preColor = square.getFill();
        if (highlighted.getFill() == Color.GREY) highlighted.setFill(Color.LIGHTGREY);
    }

    public static void applyAutoMove() {
        String move = Azul.generateAction(gameState);
        snap.play();
        gameState = Azul.applyMove(gameState,move);
        System.out.println("auto:"+ Arrays.toString(gameState));
        System.out.println("auto:"+ move);
        tillingMove();
        Azul.nextRound(gameState);
        checkCompletion();
        displayState();
    }

    public static void applyMove() {

        if (square.position == Square.Position.Storage) {
            char player = ((PlayerGroup)square.group).getPlayer();
            int row = square.index;
            draftingMove(player, (char)(row + '0'));
        }
        else if (square.position == Square.Position.Floor) {
            char player = ((PlayerGroup)square.group).getPlayer();
            draftingMove(player, 'F');
        }
        tillingMove();
        Azul.nextRound(gameState);
        checkCompletion();
        displayState();
    }

    public static void draftingMove(char player, char placedTo) {
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

    public static void tillingMove() {
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
