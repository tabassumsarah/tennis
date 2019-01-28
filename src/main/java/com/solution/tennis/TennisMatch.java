package com.solution.tennis;

/**
 * Created by saraht on 26/01/2019.
 */
public class TennisMatch {

    private String player1;
    private String player2;

    private Integer[] gameScore = new Integer[]{0, 0};
    private Integer[] setScore = new Integer[]{0, 0};
    private Integer[] finalGameScore = new Integer[]{0, 0};
    private Integer[] tieBreakScore = new Integer[]{0, 0};

    static boolean tieBreakMode = false;
    String resultString = "0-0,0-0";

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
        gameScore[playerId] = gameScore[playerId] + 1;

        //if its a tie-break situation scoreCalculation separate scoring
        if (tieBreakMode) {
            tieBreakScore[playerId] = tieBreakScore[playerId] + 1;
        }

        scoreCalculation();

    }

    private void updateResultString() {

    }

    private void scoreCalculation() {

        String resultForWin = ScoreUtil.translateScoreForMatchGame(gameScore[0], gameScore[1]);

        if (!tieBreakMode && ScoreUtil.isGameWinLoseState(resultForWin)) {
            int[] arr = ScoreUtil.getFinalGameScore(resultForWin);
            // if game is in win-lose or vice versa, update final game point by one and return game score
            updateFinalGameScore(arr);
            resultString = finalGameScore[0].toString() + "-" + finalGameScore[1].toString();
        } else {
            // if game not in final state make the result using current score
            resultString = setScore[0] + "-" + setScore[1] + "," + resultForWin;
        }

        setTieBreakIfApplied();

        if (tieBreakMode) {
            resultString = ScoreUtil.translateTieScore(tieBreakScore[0], tieBreakScore[1], player1, player2);
            return;

        }

        if (isCurrentSetWon()) {
            int[] setScore = ScoreUtil.getSetScoreIfApplicable(finalGameScore[0], finalGameScore[1]);
            updateFinalSetScore(setScore);
            resultString = setScore[0] + "-" + setScore[1] + "," + finalGameScore[0].toString() + "-" + finalGameScore[1].toString();
        }

    }

    private void setTieBreakIfApplied() {
        tieBreakMode = ScoreUtil.setIsTie(finalGameScore[0], finalGameScore[1]);
    }

    private boolean isCurrentSetWon() {
        return ScoreUtil.setWon(finalGameScore[0], finalGameScore[1]);
    }


    String score() {
        return resultString;
    }

    private void resetGameScore() {
        gameScore[0] = 0;
        gameScore[1] = 0;
    }

    private void updateFinalGameScore(int[] arr) {
        resetGameScore();
        finalGameScore[0] = finalGameScore[0] + arr[0];
        finalGameScore[1] = finalGameScore[1] + arr[1];
    }

    private void updateFinalSetScore(int[] arr) {
        resetGameScore();
        setScore[0] = setScore[0] + arr[0];
        setScore[1] = setScore[1] + arr[1];

    }
}
