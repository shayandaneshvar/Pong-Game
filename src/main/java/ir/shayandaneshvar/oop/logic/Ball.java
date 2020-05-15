package ir.shayandaneshvar.oop.logic;

import javafx.scene.paint.Color;

public abstract class Ball {
    private Color color;
    private Double speedX;
    private Double speedY;
    private Double radius;
    private Double x, y;

    public Ball(Color color, Double speedConstant, Double radius, Double x,
                Double y) {
        this.color = color;
        this.speedX = Math.random() * speedConstant * 6;
        this.speedY = Math.random() * speedConstant * 6;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += speedX;
        y += speedY;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public Double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(Double speedX) {
        this.speedX = speedX;
    }

    public Double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(Double speedY) {
        this.speedY = speedY;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
