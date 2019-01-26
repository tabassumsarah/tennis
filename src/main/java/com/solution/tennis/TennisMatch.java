package com.solution.tennis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    private void increasePointByOne(int playerId) {
        gameScore[playerId] = gameScore[playerId] + 1;
    }


    String translateScore(int player1Score, int player2Score) {

        StringBuilder scoreResult = new StringBuilder();
        if (player1Score == 0) {
            scoreResult.append("0-");
        }

        if (player1Score == 1) {
            scoreResult.append("15-");
        }

        if (player2Score == 0) {
            scoreResult.append("0");
        }

        if (player2Score == 1) {
            scoreResult.append("15");
        }

        return "0-0," + scoreResult.toString();
    }

    String score() {
        return translateScore(gameScore[0], gameScore[1]);
    }
}
