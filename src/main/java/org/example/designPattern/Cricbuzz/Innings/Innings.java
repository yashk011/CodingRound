package org.example.designPattern.Cricbuzz.Innings;

import lombok.Setter;
import org.example.designPattern.Cricbuzz.MatchType;
import org.example.designPattern.Cricbuzz.Team.Player;
import org.example.designPattern.Cricbuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Innings {
    Team bowlingTeam;
    Team battingTeam;
    MatchType matchType;
    List<Over> overs;
    int runs;

    public Innings() {
        overs = new ArrayList<>();
    }

    public void startInnings(int runs) throws Exception {
        try {
            battingTeam.getNextBatsMan();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for(int i=1;i<=2;i++) {
            Over over = new Over();
            overs.add(over);
            Player currentBowler = battingTeam.getNextBaller();

            boolean won = over.startOver(runs, bowlingTeam, battingTeam);
            if(won == true) {
                break;
            }
        }

        // Swap Striker

        Player nonStriker = battingTeam.getNonStriker();
        Player striker = battingTeam.getStriker();
        Player temp = nonStriker;
        nonStriker = striker;
        striker = temp;
    }

    public int getRuns() {
        return this.runs;
    }
}
