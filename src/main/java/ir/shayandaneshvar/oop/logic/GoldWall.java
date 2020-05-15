package ir.shayandaneshvar.oop.logic;

import javafx.scene.paint.Color;

public class GoldWall extends Wall {
    public GoldWall(Double x, Double y) {
        super(y, x, 50d, 250d, Color.GOLD, 6);
    }
}
