package org.example.LLDQuestions.Cricbuzz.Innings;

public class UpdateBowlingScoreObserver implements UpdateScoreObserver{
    @Override
    public void update(Ball ball) {
        System.out.println("Updating Bowler Stats");
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

        ball.bowledBy.getBowlingScoreCard().increaseRun(run);

        if(ball.wicket != null) {
            ball.bowledBy.getBowlingScoreCard().increaseWicket();
        }
    }
}
