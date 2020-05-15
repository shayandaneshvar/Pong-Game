package ir.shayandaneshvar.oop.graphics;

import ir.shayandaneshvar.oop.logic.BlueBall;
import ir.shayandaneshvar.oop.logic.Game;
import ir.shayandaneshvar.oop.logic.GoldWall;
import ir.shayandaneshvar.oop.logic.GreenWall;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;

public class Presenter extends Application implements Observer<Game> {
    private Game game;
    private Group root;
    private Scene scene;
    private Rectangle left;
    private Rectangle right;
    private Circle ballGraphics;
    private Text text;

    @Override
    public void init() throws Exception {
        game = new Game(new GreenWall(50d, 100d),
                new BlueBall(500d, 300d), new GreenWall(900d, 100d));
        game.addObserver(this);
        left = new Rectangle();
        right = new Rectangle();
        text = new Text();
        ballGraphics = new Circle();
    }

    @Override
    public void update(Game game) {
        Platform.runLater(() -> {
            left.setWidth(game.getLeftWall().getWidth());
            left.setHeight(game.getLeftWall().getHeight());
            right.setWidth(game.getRightWall().getWidth());
            right.setHeight(game.getRightWall().getHeight());
            left.setFill(game.getLeftWall().getColor());
            right.setFill(game.getRightWall().getColor());
            left.setX(game.getLeftWall().getX());
            left.setY(game.getLeftWall().getY());
            right.setX(game.getRightWall().getX());
            right.setY(game.getRightWall().getY());
            ballGraphics.setRadius(game.getBall().getRadius());
            ballGraphics.setFill(game.getBall().getColor());
            ballGraphics.setCenterX(game.getBall().getX());
            ballGraphics.setCenterY(game.getBall().getY());
            text.setText(String.format("Left Score: %d, Right Score: %d",
                    game.getScoreLeft(), game.getScoreRight()));
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        text.setX(300);
        text.setY(50);
        text.setFont(new Font("helvetica", 24));
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {

            switch (e.getCode()) {
                case UP:
                    game.getRightWall().goHigher();
                    break;
                case DOWN:
                    game.getRightWall().goLower();
                    break;
                case W:
                    game.getLeftWall().goHigher();
                    break;
                case S:
                    game.getLeftWall().goLower();
                    break;
                case Q:
                    game.setLeftWall(new GoldWall(50d,
                            game.getLeftWall().getY()));
                    break;
                case E:
                    game.setLeftWall(new GreenWall(50d,
                            game.getLeftWall().getY()));
                    break;
                case ENTER:
                    game.setRightWall(new GoldWall(900d,
                            game.getRightWall().getY()));
                    break;
                case SHIFT:
                    game.setRightWall(new GreenWall(900d,
                            game.getRightWall().getY()));
                    break;
                default:
                    System.err.println("Wrong Key!");
            }
            e.consume();
        });
        stage.getIcons().addAll(new Image(getClass().getResource(
                "/image/icon.png").toString()));
        Timer timer = new Timer();
        timer.schedule(game, 100, 16);
        root.getChildren().addAll(left, right, ballGraphics, text);
        stage.setTitle("Pong Game");
        stage.show();
    }
}
