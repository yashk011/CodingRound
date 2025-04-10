package org.example.LLDQuestions.Cricbuzz.Innings;

public class UpdateBattingScoreObserver implements UpdateScoreObserver{
    @Override
    public void update(Ball ball) {
        System.out.println("Batting Stats");
        int run = 0;
        if(ball.runType.equals(RunType.ONE))
            run = 1;
        if(ball.runType.equals(RunType.TWO))
            run = 2;
        if(ball.runType.equals(RunType.THREE))
            run = 3;
        if(ball.runType.equals(RunType.FOUR))
            run = 4;
        if(ball.runType.equals(RunType.SIX))
            run = 6;

        ball.playedBy.getBattingScoreCard().increaseRun(run);
    }
}
