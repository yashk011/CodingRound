package org.example.designPattern.Cricbuzz.Team;

import lombok.Getter;
import lombok.Setter;
import org.example.designPattern.Cricbuzz.controller.PlayerBattingController;
import org.example.designPattern.Cricbuzz.controller.PlayerBowlingController;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Team {
    String teamName;
    @Setter
    List<Player> playing11;
    List<Player> bench;
    @Setter
    boolean isWinner;

    PlayerBattingController playerBattingController;
    PlayerBowlingController playerBowlingController;

    public Team(String name, List<Player>  playing11) {
        this.teamName = name;
        this.playing11 = playing11;
        bench = new ArrayList<>();

        playerBattingController = new PlayerBattingController(playing11);
        playerBowlingController = new PlayerBowlingController(playing11);
    }

    public void addPlayers(Player player) {
        playing11.add(player);
    }

    public void printBattingScoreCard() {
        for(Player player : playing11) {
            System.out.print(player.getName() + " - ");
            player.battingScoreCard.display();
        }
    }

    public int getTotalRuns() {
        int totalRuns = 0;

        for(Player player : playing11) {
            totalRuns+=player.battingScoreCard.getTotalRun();
        }
        return totalRuns;
    }

    public void printBowlingScoreCard() {
        for(Player player : playing11) {
            System.out.print(player.getName() + " - ");
            player.bowlingScoreCard.display();
        }
    }

    public void getNextBatsMan() throws Exception{
        playerBattingController.getNextPlayer();
    }

    public void setStriker(Player player) {
        playerBattingController.setStriker(player);
    }

    public void setNonStriker(Player player) {
        playerBattingController.setNonStriker(player);
    }

    public Player getNextBaller() throws Exception{
        return playerBowlingController.getNextBowler();
    }

    public Player getStriker() {
        return playerBattingController.getStriker();
    }

    public Player getNonStriker() {
        return playerBattingController.getNonStriker();
    }

    public Player getCurrentBowler() {
        return playerBowlingController.getCurrentBowler();
    }

}
