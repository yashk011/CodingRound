package org.example.designPattern.SnakeAndLadder.model;

import java.util.Random;

public class Dice {
    int face;

    public Dice() {
        face = 6;
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, face);
    }
}
