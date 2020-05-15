package ir.shayandaneshvar.procedural;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private Circle ball = new Circle(400, 400, 20, Color.RED);
    private Rectangle leftWall = new Rectangle(30, 200, 30, 150);
    private Rectangle rightWall = new Rectangle(750, 200, 30, 150);

    private Double ballSpeedX = 2d;
    private Double ballSpeedY = 0.8d;
    private Double wallSpeed = 30d;
    private Integer leftScore = 0;
    private Integer rightScore = 0;
    private Text text = new Text();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        text.setFont(new Font("helvetica", 24));
        text.setX(200);
        text.setY(50);
        root.getChildren().addAll(leftWall, rightWall, ball, text);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    leftWall.setY(leftWall.getY() - wallSpeed);
                    break;
                case S:
                    leftWall.setY(leftWall.getY() + wallSpeed);
                    break;
                case UP:
                    rightWall.setY(rightWall.getY() - wallSpeed);
                    break;
                case DOWN:
                    rightWall.setY(rightWall.getY() + wallSpeed);
                    break;
            }
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                text.setText(String.format("Left Score: %d, Right Score: %d", leftScore, rightScore));
                if (ball.getCenterX() == rightWall.getX()) {
                    if (ball.getCenterY() >= rightWall.getY() &&
                            ball.getCenterY() <= rightWall.getY() + rightWall.getHeight()) {
                        ballSpeedX = -Math.abs(ballSpeedX);
                    } else {
                        ball.setCenterX(400);
                        ball.setCenterY(400);
                        leftScore++;
                    }

                }
                if (ball.getCenterX() == leftWall.getX() + leftWall.getWidth()) {
                    if (ball.getCenterY() >= leftWall.getY() && ball.getCenterY() <= leftWall.getY() + leftWall.getHeight()) {
                        ballSpeedX = Math.abs(ballSpeedX);
                    } else {
                        ball.setCenterX(400);
                        ball.setCenterY(400);
                        rightScore++;
                    }
                }
                if (ball.getCenterY() <= 0) {
                    ballSpeedY = Math.abs(ballSpeedY);
                } else if (ball.getCenterY() >= 600) {
                    ballSpeedY = -Math.abs(ballSpeedY);
                }
                ball.setCenterX(ball.getCenterX() + ballSpeedX);
                ball.setCenterY(ball.getCenterY() + ballSpeedY);
            }
        }.start();
    }
}
