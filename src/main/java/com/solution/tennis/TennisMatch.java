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

    }

    private String getSetScoreIfApplicable() {
        return "0-0";
    }

    String score() {
        String setScore = getSetScoreIfApplicable();
        String resultForWin = ScoreUtil.translateScoreForMatchGame(gameScore[0], gameScore[1]);

        if (resultForWin.contains("Win")) {
            int idx = resultForWin.lastIndexOf('#');
            String s = resultForWin.substring(idx + 1, resultForWin.length());
            String[] a = s.split("-");

            int player1Score = Integer.valueOf(a[0]);
            int player2Score = Integer.valueOf(a[1]);

            if (player1Score > player2Score) {
                updateFinalGameScore(0);
            } else {
                updateFinalGameScore(1);
            }
            return setScore + "," + finalGameScore[0].toString() + "-" + finalGameScore[1].toString() ;
        }

        return setScore + "," + resultForWin;
    }

    private void updateFinalGameScore(int playerId) {
        gameScore[0]=0;
        gameScore[1]=0;
        finalGameScore[playerId] = finalGameScore[playerId] + 1;
    }
}
