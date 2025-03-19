package org.example.designPattern.Cricbuzz.ScoreCard;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BattingScoreCard {
    int totalRun;
    int totalBalls;
    int total4s;
    int total6s;
    public void increaseRun(int run) {
        this.totalRun+=run;
        totalBalls++;
        if(run == 4)
            total4s++;
        if(run == 6)
            total6s++;
    }

    public void display() {
        System.out.println("Runs " + totalRun + " | Balls Played - " + totalBalls
        + " | 4s - " + total4s + " | 6s - " + total6s);
    }
}
