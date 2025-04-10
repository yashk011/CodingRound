package org.example.LLDQuestions.lockermanagementsystem.strategy;

import java.util.Random;

public class RandomNumberGenerator implements IRandomNumberGenerator{
    @Override
    public int generateRandomNumber(int lessThan) {
        Random random = new Random();
        return random.nextInt(lessThan);
    }
}
