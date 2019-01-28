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

    static boolean isGameWinLoseState(String result) {
        return result.contains("Win");
    }

    static boolean setWon(int playerOneGameScore, int playerTwoGameScore) {
        if (playerOneGameScore >= 6 || playerTwoGameScore >= 6) {
            if (Math.abs(playerOneGameScore - playerTwoGameScore) >= 2) {
                return true;
            }
        }
        return false;


    }

    static boolean setIsTie(int playerOneGameScore, int playerTwoGameScore) {
        if (playerOneGameScore == playerTwoGameScore) {
            if (playerOneGameScore == 6) {
                return true;
            }
        }
        return false;

    }

    static String translateTieScore(Integer player1Score, Integer player2Score, String player1, String player2) {
        if (player1Score == 7 || player2Score == 7) {
            if (Math.abs(player1Score - player2Score) >= 2) {
                if (player1Score > player2Score) {
                    return  player1+ " wins";
                    //return new int[]{1, 0};
                } else {
                    return player2+" wins";
                    //return new int[]{0, 1};
                }
            }
        }

        return  "tie is on," + player1Score.toString()+"-"+ player2Score.toString();
    }

    static int[] getSetScoreIfApplicable(int playerOneGameScore, int playerTwoGameScore) {
        if (playerOneGameScore > playerTwoGameScore) {
            return new int[]{1, 0};
        } else {
            return new int[]{0, 1};
        }
    }


    static int[] getFinalGameScore(String result) {
        if (result.contains("Win")) {
            int idx = result.lastIndexOf('#');
            String s = result.substring(idx + 1, result.length());
            String[] a = s.split("-");
            return new int[]{Integer.valueOf(a[0]), Integer.valueOf(a[1])};
        }
        return new int[]{0, 0};
    }

}
