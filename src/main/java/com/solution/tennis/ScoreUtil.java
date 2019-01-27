package com.solution.tennis;

/**
 * Created by saraht on 27/01/2019.
 */
public class ScoreUtil {

    private static final String[] RUNNING_SCORE = new String[]{"0", "15", "30", "40"};
    private static final String ADVANTAGE_PLAYER_ONE = " Advantage Player 1";
    private static final String ADVANTAGE_PLAYER_TWO = " Advantage Player 2";
    private static final String DEUCE = "Deuce";


    static String translateScoreForMatchGame(int player1Score, int player2Score) {
        //Situation: Advantage, deuce
        if (player1Score >= 3 || player2Score >= 3) {
            if (player1Score == player2Score) {
                return DEUCE;
            }
            if (player1Score > 3 || player2Score > 3) {
                return winOrAdvantage(player1Score, player2Score);
            }
        }
        //default score
        return RUNNING_SCORE[player1Score] + "-" + RUNNING_SCORE[player2Score];
    }

    static String winOrAdvantage(int player1Score, int player2Score) {
        if (Math.abs(player1Score - player2Score) < 2) {
            return advantage(player1Score, player2Score);
        } else {
            return win(player1Score, player2Score);
        }
    }

    static String advantage(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            return ADVANTAGE_PLAYER_ONE;
        } else {
            return ADVANTAGE_PLAYER_TWO;
        }
    }

    static String win(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            return "Win#1-0";
        } else {
            return "Win#0-1";
        }
    }

}
