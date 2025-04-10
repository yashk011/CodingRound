package org.example.LLDQuestions.Cricbuzz;

import org.example.LLDQuestions.Cricbuzz.Team.Player;
import org.example.LLDQuestions.Cricbuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchDemo {

    public static void main(String[] args) throws Exception {
        Team teamA = createTeam("India");
        Team teamB = createTeam("Sri Lanka");

        Match match = new Match(teamA, teamB);
        match.startMatch();
    }

    private static Team createTeam(String teamName) {
        List<Player> players = addPlayer(teamName);
        Team team = new Team(teamName, players);
        return team;
    }

    private static List<Player> addPlayer(String team) {
        Player player1 = new Player(team + " Sehwag");
        Player player2 = new Player(team +" Sachin");
        Player player3 = new Player(team + " Rohit");
        Player player4 = new Player(team +" Raina");
        Player player5 = new Player(team +" DHoni");
        Player player6 = new Player(team +" Kartik");
        Player player7 = new Player(team +" Pandey");
        Player player8 = new Player(team +" Singh");
        Player player9 = new Player(team + " Gill");
        Player player10 = new Player(team +" Zaheer");
        Player player11 = new Player(team + " Irfan");

        ArrayList<Player> playerDetails = new ArrayList<>();
        playerDetails.add(player1);
        playerDetails.add(player2);
        playerDetails.add(player3);
        playerDetails.add(player4);
        playerDetails.add(player5);
        playerDetails.add(player6);
        playerDetails.add(player7);
        playerDetails.add(player8);
        playerDetails.add(player9);
        playerDetails.add(player10);
        playerDetails.add(player11);

        return playerDetails;
    }
}
