package com.solution.tennis;

/**
 * Created by saraht on 26/01/2019.
 */
public class TennisMatch {

    private String player1;
    private String player2;
    private String currentScore = "0-0,0-0";

    private Integer[] runningGameScore = new Integer[]{0, 0};
    private Integer[] finalGameScore = new Integer[]{0, 0};
    private Integer[] setScore = new Integer[]{0, 0};
    private Integer[] tieBreakScore = new Integer[]{0, 0};

    private static boolean tieBreakMode = false;

    TennisMatch(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void pointWonBy(String player) {
        int playerOne = 0;
        int playerTwo = 1;

        if (player.equals(this.player1)) {
            increasePointFor(playerOne);
        }
        if (player.equals(this.player2)) {
            increasePointFor(playerTwo);
        }
    }

    private void increasePointFor(int playerId) {
        // increase point for respective player
        runningGameScore[playerId] = runningGameScore[playerId] + 1;

        //if its a tie-break situation calculate separate scoring
        if (tieBreakMode) {
            tieBreakScore[playerId] = tieBreakScore[playerId] + 1;
        }
        scoreCalculation();
    }


    private void scoreCalculation() {
        String runningScore = ScoreUtil.translateScoreForMatchGame(runningGameScore[0], runningGameScore[1]);

        if (!tieBreakMode && ScoreUtil.isGameWinLoseState(runningScore)) {
            updateFinalGameScore(runningScore);
            currentScore = finalGameScore[0].toString() + "-" + finalGameScore[1].toString();
        }

        if (!tieBreakMode && !ScoreUtil.isGameWinLoseState(runningScore)) {
            currentScore = setScore[0] + "-" + setScore[1] + "," + runningScore;
        }

        setTieBreakIfApplied();

        if (tieBreakMode) {
            currentScore = ScoreUtil.translateTieScore(tieBreakScore[0], tieBreakScore[1], player1, player2);
            return;

        }

        if (isCurrentSetWon()) {
            int[] setScore = ScoreUtil.getSetScoreIfApplicable(finalGameScore[0], finalGameScore[1]);
            updateFinalSetScore(setScore[0], setScore[1]);
            currentScore = setScore[0] + "-" + setScore[1] + "," + finalGameScore[0].toString() + "-" + finalGameScore[1].toString();
        }

    }

    private void setTieBreakIfApplied() {
        tieBreakMode = ScoreUtil.setIsTie(finalGameScore[0], finalGameScore[1]);
    }

    private boolean isCurrentSetWon() {
        return ScoreUtil.setWon(finalGameScore[0], finalGameScore[1]);
    }

    String score() {
        return currentScore;
    }

    private void resetGameScore() {
        runningGameScore[0] = 0;
        runningGameScore[1] = 0;
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
}
