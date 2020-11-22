package model.game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Direction {
    NORTH("Nord"),
    SOUTH("Sud"),
    WEST("Ouest"),
    EAST("Est");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
