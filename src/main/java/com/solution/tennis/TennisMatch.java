package com.solution.tennis;

/**
 * Created by saraht on 26/01/2019.
 */
public class TennisMatch implements Match {

    private String player1;
    private String player2;
    //format: array[0] = player1 score, array[1] = player2
    private int[] runningGameScore = new int[]{0, 0}; // game not in final state
    private int[] finalGameScore = new int[]{0, 0}; //to keep track of each game win and keeping score for set wins

    private int[] setScore = new int[]{0, 0}; // to keep track of set wins
    private int[] tieBreakScore = new int[]{0, 0}; // to keep track of tie break wins

    private static boolean tieBreakMode = false;
    private String score = "0-0,0-0";
    ;

    TennisMatch(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /*
    * At any point of time this method gives current result of the game
    * */
    public String score() {
        return score;
    }

    /*
    * This method denoted who won the point
    * @param Player name/id*/
    public void pointWonBy(String player) {
        int playerOne = 0;
        int playerTwo = 1;

        if (player.equals(this.player1)) {
            trackPoints(playerOne);
        }
        if (player.equals(this.player2)) {
            trackPoints(playerTwo);
        }
    }

    /* Method for score counter.
     Every time @see pointWon(String player) called this method increase players point and keep track.
     Also checks for tie break scenario, if then starts another scoring system using tieBreakScore array*/
    private void trackPoints(int playerId) {
        runningGameScore[playerId] = runningGameScore[playerId] + 1;

        //if its a tie-break situation calculate separate scoring
        if (tieBreakMode) {
            tieBreakScore[playerId] = tieBreakScore[playerId] + 1;
        }
        // With the help of ScoreUtil this method builds result string
        scoreCalculation();
    }

    //Keeps track of tie break and winning the set scenario using non volatile arrays and help of util class.
    private void scoreCalculation() {
        String runningScore = ScoreUtil.translateScoreForMatchGame(runningGameScore[0], runningGameScore[1]);

        if (!tieBreakMode && ScoreUtil.isGameWinLoseState(runningScore)) {
            updateFinalGameScore(runningScore);
            score = concatScores(finalGameScore);
        }

        if (!ScoreUtil.isGameWinLoseState(runningScore)) {
            score = concatScores(setScore) + "," + runningScore;
        }

        setTieBreakIfApplied();

        if (tieBreakMode) {
            score = ScoreUtil.translateTieScore(tieBreakScore[0], tieBreakScore[1], player1, player2);
            return;

        }
        // for Set calculation
        if (isCurrentSetWon()) {
            int[] setScore = ScoreUtil.getSetScoreIfApplicable(finalGameScore[0], finalGameScore[1]);
            updateFinalSetScore(setScore[0], setScore[1]);
            score = concatScores(setScore) + "," + concatScores(finalGameScore);
        }

    }

    private void setTieBreakIfApplied() {
        tieBreakMode = ScoreUtil.setIsTie(finalGameScore[0], finalGameScore[1]);
    }

    private boolean isCurrentSetWon() {
        return ScoreUtil.setWon(finalGameScore[0], finalGameScore[1]);
    }

    private void updateFinalGameScore(String result) {
        int[] scoreAfterAGameIsWon = ScoreUtil.getFinalGameScoreFromResultString(result);
        resetGameScore();
        finalGameScore[0] = finalGameScore[0] + scoreAfterAGameIsWon[0];
        finalGameScore[1] = finalGameScore[1] + scoreAfterAGameIsWon[1];
    }

    private void updateFinalSetScore(int player1SetScore, int player2SetScore) {
        resetGameScore();
        setScore[0] = setScore[0] + player1SetScore;
        setScore[1] = setScore[1] + player2SetScore;
    }

    private String concatScores(int[] result) {
        return result[0] + "-" + result[1];
    }

    private void resetGameScore() {
        runningGameScore[0] = 0;
        runningGameScore[1] = 0;
    }
}
