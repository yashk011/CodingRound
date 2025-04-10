package org.example.LLDQuestions.Cricbuzz.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.LLDQuestions.Cricbuzz.Team.Player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PlayerBowlingController {
    Deque<Player> bowlers;
    HashMap<Player, Integer> oversLeftForPlayer;
    @Setter
    @Getter
    Player currentBowler;

    public PlayerBowlingController(List<Player> list) {
        bowlers = new LinkedList<>();
        for(Player b : list)
            bowlers.add(b);

        oversLeftForPlayer = new HashMap<>();
    }


    public Player getNextBowler() {
        Player bowler = bowlers.removeFirst();
        currentBowler = bowler;
        if(oversLeftForPlayer.getOrDefault(bowler,0) < 10) {
            oversLeftForPlayer.put(bowler, oversLeftForPlayer.getOrDefault(bowler, 0) + 1);
            bowlers.addLast(bowler);
        }
        return bowler;
    }
}
