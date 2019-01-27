package com.solution.tennis;

/**
 * Created by saraht on 26/01/2019.
 */
public class TennisMatch {

    private String player1;
    private String player2;

    private static final String[] runningScore
            = new String[]{"0", "15", "30", "40"};

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

    
    private String translateScore(int player1Score, int player2Score) {
        //Situation: Win
        if (player1Score >= 3 || player2Score >= 3) {
            if (player1Score == player2Score) {
                return "0-0," + "deuce";
            }
        }
        return "0-0," + runningScore[player1Score] + "-" + runningScore[player2Score];
    }

    String score() {
        return translateScore(gameScore[0], gameScore[1]);
    }
}
