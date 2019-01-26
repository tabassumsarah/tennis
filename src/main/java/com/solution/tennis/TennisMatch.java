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
    List<String> gameScore;

    TennisMatch(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameScore = new ArrayList<String>(Arrays.asList("0", "0"));
    }

    void pointWonBy(String player) {
        if (player.equals(this.player1)) {
            gameScore.add(0, "15");
        }
    }

    String score() {
        return "0-0," + gameScore.get(0) + "-" + gameScore.get(1);
    }
}
