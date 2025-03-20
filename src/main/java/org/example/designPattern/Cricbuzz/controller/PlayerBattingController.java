package org.example.designPattern.Cricbuzz.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.designPattern.Cricbuzz.Team.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
public class PlayerBattingController {
    Queue<Player> players;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(List<Player> batters) {
        players = new LinkedList<>();
        for(Player p : batters) {
            players.add(p);
        }

        striker = players.remove();
        nonStriker = players.remove();
    }

    public void getNextPlayer() throws Exception {

        if(striker == null)
            striker =players.remove();

        if(nonStriker == null)
            nonStriker = players.remove();

//        if(!players.isEmpty())
//            return players.remove();
//        else
//            throw new Exception("All Batsmen are out");
    }

}
