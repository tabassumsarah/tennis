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

    String score() {
        String player1Score = "";
        String player2Score = "";

        if (gameScore[0] == 0) {
            player1Score = "0";
        }

        if (gameScore[0] == 1) {
            player1Score = "15";
        }

        if (gameScore[1] == 0) {
            player2Score = "0";
        }

        if (gameScore[1] == 1) {
            player2Score = "15";
        }

        return "0-0," + player1Score + "-" + player2Score;
    }
}
