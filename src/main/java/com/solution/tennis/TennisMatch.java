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
    String resultString = "";

    TennisMatch(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void pointWonBy(String player) {
        if (player.equals(this.player1)) {
            increasePointByOne(0);
        }
        if (player.equals(this.player2)) {
            increasePointByOne(1);
        }
    }

    private void increasePointByOne(int playerId) {
        gameScore[playerId] = gameScore[playerId] + 1;
        // update match score every time a game is in win-loose situation
        calculate();

    }

    private String getSetScoreIfApplicable() {
        return "0-0";
    }

    private void calculate() {
        String setScore = getSetScoreIfApplicable();
        String resultForWin = ScoreUtil.translateScoreForMatchGame(gameScore[0], gameScore[1]);

        if(ScoreUtil.isGameWinLooseState(resultForWin)){
            int[] arr = ScoreUtil.getFinalGameScore(resultForWin);
            updateFinalGameScore(arr);
            resultString = setScore + "," + finalGameScore[0].toString() + "-" + finalGameScore[1].toString();
        } else {
            resultString = setScore + "," + resultForWin;
        }
    }

    String score() {
        return resultString;
    }

    private void updateFinalGameScore(int[] arr) {
        gameScore[0] = 0;
        gameScore[1] = 0;
        finalGameScore[0] = finalGameScore[0] + arr[0];
        finalGameScore[1] = finalGameScore[1] + arr[1];
    }
}
