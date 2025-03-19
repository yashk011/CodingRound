package org.example.designPattern.Cricbuzz.ScoreCard;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BowlingScoreCard {

    int balls;
    int runs;
    int wicket;

    public void increaseRun(int run) {
        this.runs +=run;
        this.balls++;
    }

    public void increaseWicket() {
        this.wicket++;
    }

    public void display() {
        System.out.println("Runs Conceded " + runs + " | Balls Bowled - " + balls
                + " | Wickets - " + wicket);
    }

}
