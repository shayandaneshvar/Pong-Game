package ir.shayandaneshvar.oop.logic;

import ir.shayandaneshvar.oop.graphics.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Game extends TimerTask implements Observable<Game> {
    private List<Observer<Game>> observers;
    private Wall leftWall;
    private Wall rightWall;
    private Ball ball;
    private Integer scoreLeft = 0;
    private Integer scoreRight = 0;

    public Game(Wall leftWall, Ball ball, Wall rightWall) {
        observers = new ArrayList<>();
        this.leftWall = leftWall;
        this.rightWall = rightWall;
        this.ball = ball;
    }

    public void run() {
        if (ball.getX() >= (rightWall.getX())) {
            if (ball.getY() >= rightWall.getY() &&
                    ball.getY() <= rightWall.getY() + rightWall.getHeight()) {
                ball.setSpeedX(-Math.abs(ball.getSpeedX()));
                ball.setSpeedY(ball.getSpeedY() + Math.random() * 2);
            } else {
                increaseLeftScore();
                ball = new BlueBall(500d, 300d);
            }
        } else if (ball.getX() <= (leftWall.getX()) + leftWall.getWidth()) {
            if (ball.getY() >= leftWall.getY() &&
                    ball.getY() <= leftWall.getY() + leftWall.getHeight()) {
                ball.setSpeedX(Math.abs(ball.getSpeedX()));
                ball.setSpeedY(ball.getSpeedY() - Math.random() * 2);
            } else {
                increaseRightScore();
                ball = new RedBall(500d, 300d);
            }
        }
        if (ball.getY() <= 5) {
            ball.setSpeedY(Math.abs(ball.getSpeedY()));
        } else if (ball.getY() >= 595) {
            ball.setSpeedY(-Math.abs(ball.getSpeedY()));
        }
        ball.move();
        updateAllObservers();
    }

    public Wall getLeftWall() {
        return leftWall;
    }

    public Wall getRightWall() {
        return rightWall;
    }

    public Ball getBall() {
        return ball;
    }

    public Integer getScoreLeft() {
        return scoreLeft;
    }

    public Integer getScoreRight() {
        return scoreRight;
    }

    public void setLeftWall(Wall leftWall) {
        this.leftWall = leftWall;
    }

    public void setRightWall(Wall rightWall) {
        this.rightWall = rightWall;
    }

    public void increaseLeftScore() {
        scoreLeft++;
    }

    public void increaseRightScore() {
        scoreRight++;
    }

    @Override
    public void addObserver(Observer<Game> observer) {
        observers.add(observer);
    }

    @Override
    public void updateAllObservers() {
        observers.forEach(z -> z.update(this));
    }

}
