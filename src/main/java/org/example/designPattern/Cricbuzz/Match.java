package org.example.designPattern.Cricbuzz;

import jakarta.annotation.Nonnull;
import lombok.NoArgsConstructor;
import org.example.designPattern.Cricbuzz.Innings.Innings;
import org.example.designPattern.Cricbuzz.Team.Team;

import java.util.Random;

@NoArgsConstructor
public class Match {
    Team teamA;
    Team teamB;
    String venue;
    MatchType matchType;
    Innings[] innings;
    Team tossWinner;

    public Match(Team a, Team b) {
        this.teamA = a;
        this.teamB = b;
        this.venue = "Wankhede";
        this.matchType = new ODIMatch();
        this.innings = new Innings[2];
    }
    public void startMatch() throws Exception {
        System.out.println("=== Match Started between " + this.teamA.getTeamName() + " and " + this.teamB.getTeamName());
        tossCoin();
        System.out.println("=== Toss Won by - " + tossWinner.getTeamName());
        setInningsDetails();
    }

    private void setInningsDetails() throws Exception {
        for(int i =0;i<=1;i++) {
            Team battingTeam;
            Team bowlingTeam;

            if(i == 0) {
                battingTeam = tossWinner;
                bowlingTeam = teamA != tossWinner ? teamA : teamB;
                Innings innings1 = new Innings();
                this.innings[i] = innings1;

                this.innings[i].setBattingTeam(battingTeam);
                this.innings[i].setBowlingTeam(bowlingTeam);
                this.innings[i].setMatchType(matchType);
                try {
                    innings[i].startInnings(-1);
                }
                catch (Exception e) {

                }
            }
            else {
                battingTeam = teamA != tossWinner ? teamA : teamB;
                bowlingTeam = tossWinner;

                Innings innings2 = new Innings();
                this.innings[i] = innings2;

                this.innings[i].setBowlingTeam(bowlingTeam);
                this.innings[i].setBattingTeam(battingTeam);
                this.innings[i].setMatchType(matchType);
                innings[i].startInnings(bowlingTeam.getTotalRuns());

                if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.setWinner(true);
                }
                else {
                    battingTeam.setWinner(true);
                }
            }

            System.out.println("============ Innings ==============");

            System.out.println("Total Score - " + battingTeam.getTotalRuns());

            System.out.println("==== Batting Score Card ====");
            battingTeam.printBattingScoreCard();

            System.out.println("==== Bowling Score Card ====");
            bowlingTeam.printBowlingScoreCard();
        }

        if(teamA.isWinner())
            System.out.println("Winner is " + teamA.getTeamName());
        else
            System.out.println("Winner is " + teamB.getTeamName());


    }

    private void tossCoin() {
        if(Math.random() < 0.5)
            this.tossWinner = teamA;
        else
            this.tossWinner = teamB;
    }
}
