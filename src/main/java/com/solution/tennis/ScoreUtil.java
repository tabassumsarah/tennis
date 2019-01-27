package com.solution.tennis;

/**
 * Created by saraht on 27/01/2019.
 */
public class ScoreUtil {
    static final String[] runningScore = new String[]{"0", "15", "30", "40"};
    private static final String ADVANTAGE_PLAYER_ONE = " Advantage player 1";
    private static final String ADVANTAGE_PLAYER_TWO = " Advantage player 2";
    private static final String DEUCE = "Deuce";

    static String advantage(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            return "0-0," + ADVANTAGE_PLAYER_ONE;
        } else {
            return "0-0," + ADVANTAGE_PLAYER_TWO;
        }
    }

    static String win(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            return "1-0";
        } else {
            return "0-1";
        }
    }

    static String winOrAdvantage(int player1Score, int player2Score) {
        if (Math.abs(player1Score - player2Score) < 2) {
            return advantage(player1Score, player2Score);
        } else {
            return win(player1Score, player2Score);
        }
    }

    static String translateScore(int player1Score, int player2Score) {
        //Situation: Advantage, deuce
        if (player1Score >= 3 || player2Score >= 3) {
            if (player1Score == player2Score) {
                return "0-0," + DEUCE;
            }
            if (player1Score > 3 || player2Score > 3) {
                return winOrAdvantage(player1Score, player2Score);
            }
        }
        return "0-0," + runningScore[player1Score] + "-" + runningScore[player2Score];
    }
}
