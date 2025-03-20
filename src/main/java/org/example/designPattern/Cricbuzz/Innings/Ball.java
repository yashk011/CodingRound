package org.example.designPattern.Cricbuzz.Innings;

import org.example.designPattern.Cricbuzz.ScoreCard.BowlingScoreCard;
import org.example.designPattern.Cricbuzz.Team.Player;
import org.example.designPattern.Cricbuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {
     int ballNumber;
     BallType ballType;
     RunType runType;
     List<UpdateScoreObserver> observerList = new ArrayList<>();
     Player bowledBy;
     Player playedBy;
     Wicket wicket;

     public Ball(int ballNumber) {
        this.ballNumber = ballNumber;
        observerList.add(new UpdateBattingScoreObserver());
        observerList.add(new UpdateBowlingScoreObserver());
     }
     public void startBall(Team battingTeam, Team bowlingTeam, Over over) throws Exception {

         playedBy = battingTeam.getStriker();
        if(bowlingTeam.getCurrentBowler() == null)
            bowledBy = bowlingTeam.getNextBaller();
        bowledBy = bowlingTeam.getCurrentBowler();
        ballType = BallType.NORMAL;

        if(isWicketTaken()) {
            runType = RunType.ZERO;
            wicket = new Wicket("BOLD", bowledBy, this);
            battingTeam.setStriker(null);
        }
        else {
            runType = getRunType();
            if(runType == RunType.ONE || runType == RunType.THREE) {
                //swap striket and non striker
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

         System.out.println("Ball Bowled By - " + bowledBy.getName());
         System.out.println("Ball Played By - " + playedBy.getName());
         System.out.println("Run - " + runType.name());
         System.out.println("Wicket - " + wicket);
         System.out.println("=====================");

        notify_all();
     }

    private RunType getRunType() {
        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
         if(Math.random() < 0.2)
             return true;
         return false;
    }

    public void notify_all() {
         for(UpdateScoreObserver updateScoreObserver : observerList) {
             updateScoreObserver.update(this);
         }
     }
}
