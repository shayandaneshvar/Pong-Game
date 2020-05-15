package ir.shayandaneshvar.oop.logic;

import javafx.scene.paint.Color;

public abstract class Wall {
    private Double y;
    private Double x;
    private Double width;
    private Double height;
    private Color color;
    private final double movementSpeed;

    public Wall(Double y, Double x, Double width, Double height, Color color,
                double speed) {
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
        this.color = color;
        movementSpeed = speed;
    }

    public void goHigher() {
        y -= movementSpeed;
    }

    public void goLower() {
        y += movementSpeed;
    }


    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getX() {
        return x;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
