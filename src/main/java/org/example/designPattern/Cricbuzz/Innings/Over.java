package org.example.designPattern.Cricbuzz.Innings;

import lombok.SneakyThrows;
import org.example.designPattern.Cricbuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Over {
    List<Ball> balls;
    int overNumber;
    int extraBallsCount;

    public Over() {
        balls = new ArrayList<>();
    }
    @SneakyThrows
    public boolean startOver(int runs, Team bowlingTeam, Team battingTeam) {
        for(int i =1;i<=6;i++) {
            Ball ball = new Ball(i);
            ball.startBall(battingTeam, bowlingTeam, this);
            if(ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                if(ball.wicket != null) {
                    battingTeam.getNextBatsMan();
                }

                if( runs != -1 && battingTeam.getTotalRuns() >= runs){
                    battingTeam.setWinner(true);
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }

        return false;
    }
}
