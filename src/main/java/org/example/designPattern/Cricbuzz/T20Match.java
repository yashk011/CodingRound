package org.example.designPattern.Cricbuzz;

public class T20Match implements MatchType {
    @Override
    public int getOver() {
        return 20;
    }

    @Override
    public int getOversForPlayers() {
        return 4;
    }
}
