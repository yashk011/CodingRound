package org.example.designPattern.Cricbuzz.Team;

import lombok.Getter;
import org.example.designPattern.Cricbuzz.ScoreCard.BattingScoreCard;
import org.example.designPattern.Cricbuzz.ScoreCard.BowlingScoreCard;

@Getter
public class Player {
    String name;
    PlayerType playerType;
    BattingScoreCard battingScoreCard;
    BowlingScoreCard bowlingScoreCard;

    public Player(String name) {
        this.name = name;
        this.playerType = PlayerType.ALL_ROUNDER;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }
}
