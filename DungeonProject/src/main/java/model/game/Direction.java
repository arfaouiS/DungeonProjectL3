package model.game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Direction {
    NORTH("Nord","pictures/north.png"),
    SOUTH("Sud","pictures/south.png"),
    WEST("Ouest","pictures/west.png"),
    EAST("Est","pictures/east.png");

    private String name;
    private String imagePath;

    Direction(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getImagePath(){
        return imagePath;
    }
}
