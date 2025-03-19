package org.example.designPattern.Cricbuzz;

public class ODIMatch implements MatchType{
    @Override
    public int getOver() {
        return 50;
    }

    @Override
    public int getOversForPlayers() {
        return 10;
    }
}
