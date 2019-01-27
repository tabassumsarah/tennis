package com.solution.tennis;

/**
 * Created by saraht on 26/01/2019.
 */
public class TennisMatch {

    private String player1;
    private String player2;

    private Integer[] gameScore = new Integer[]{0, 0};

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
    }

    String score() {
        return ScoreUtil.translateScore(gameScore[0], gameScore[1]);
    }
}
