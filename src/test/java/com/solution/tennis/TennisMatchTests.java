package com.solution.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by saraht on 26/01/2019.
 */

public class TennisMatchTests {

    private String player1 = "Player 1";
    private String player2 = "Player 2";

    private void pointWon(int count, String player, TennisMatch match) {
        for (int i = 0; i < count; i++) {
            match.pointWonBy(player);
        }
    }
    @Test
    public void Should_CreateGame_WhenNoLogic() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
    }

    @Test
    public void Should_GetScore00_WhenNoPlayerScores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
        assertEquals("0-0,0-0", match.score());
    }

    @Test
    public void Should_GetScore15_0_WhenPlayer1Scores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());
    }

    @Test
    public void Should_GetScore_15_WhenPlayer2Scores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());
    }

    @Test
    public void Should_GetScore30_0_WhenPlayer1ScoresTwice() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());
    }

    @Test
    public void Should_GetScore0_30WhenPlayer2ScoresTwice() throws Exception {
        TennisMatch match = new TennisMatch("Player 1", "Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());
    }


    @Test
    public void Should_GetScoreDeuceWhenBothPlayerScores3() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(3, player1, match);
        pointWon(3, player2, match);

        assertEquals("0-0,Deuce", match.score());
    }

    @Test
    public void Should_GetScoreAdvantagePlayer1WhenPlayer1Scores4AndPlayer2Scores3() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(3, player1, match);
        pointWon(3, player2, match);
        pointWon(1, player1, match);

        assertEquals("0-0, Advantage Player 1", match.score());
    }

    @Test
    public void Should_GetScoreAdvantagePlayer2WhenPlayer2Scores4AndPlayer1Scores3() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(3, player1, match);
        pointWon(4, player2, match);

        assertEquals("0-0, Advantage Player 2", match.score());
    }

    @Test
    public void Should_GetScore10WhenPlayer1Scores4AndPlayer2Scores2() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(4, player1, match);

        assertEquals("1-0", match.score());
    }

    @Test
    public void Should_GetScore10WhenPlayer2Scores4AndPlayer1Scores2() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(4, player2, match);

        assertEquals("0-1", match.score());
    }

    @Test
    public void Should_GetScore20WhenPlayer1Wins2Game() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(1, player1, match);
        assertEquals("0-0,15-0", match.score());

        pointWon(1, player1, match);
        assertEquals("0-0,30-0", match.score());

        pointWon(1, player1, match);
        assertEquals("0-0,40-0", match.score());

        pointWon(1, player1, match);
        assertEquals("1-0", match.score());

        pointWon(1, player1, match);
        assertEquals("0-0,15-0", match.score());

        pointWon(1, player1, match);
        assertEquals("0-0,30-0", match.score());

        pointWon(1, player1, match);
        assertEquals("0-0,40-0", match.score());

        pointWon(1, player1, match);
        assertEquals("2-0", match.score());

    }

    @Test
    public void Should_GetScore02WhenPlayer2Wins2Game() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(1, player2, match);
        assertEquals("0-0,0-15", match.score());

        pointWon(1, player2, match);
        assertEquals("0-0,0-30", match.score());

        pointWon(1, player2, match);
        assertEquals("0-0,0-40", match.score());

        pointWon(1, player2, match);
        assertEquals("0-1", match.score());

        pointWon(1, player2, match);
        assertEquals("0-0,0-15", match.score());

        pointWon(1, player2, match);
        assertEquals("0-0,0-30", match.score());

        pointWon(1, player2, match);
        assertEquals("0-0,0-40", match.score());

        pointWon(1, player2, match);
        assertEquals("0-2", match.score());
    }

    @Test
    public void Should_GetScoreForSet10WhenPlayer2Wins6GamesPlayer1WinsNone() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        // game#one
        pointWon(4, player2, match);
        assertEquals("0-1", match.score());


        // game#Two
        pointWon(4, player2, match);
        assertEquals("0-2", match.score());


        // game#Three
        pointWon(4, player2, match);
        assertEquals("0-3", match.score());


        // game#Four
        pointWon(4, player2, match);
        assertEquals("0-4", match.score());


        // game#Five
        pointWon(4, player2, match);
        assertEquals("0-5", match.score());


        // game#Six
        pointWon(4, player2, match);

        // Set won
        pointWon(1, player2, match);
        assertEquals("0-1,0-6", match.score());

    }


    @Test
    public void Should_GetScoreForSet1_0AndGame6_5WhenPlayer1Wins6GamesPlayer2Wins5() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(4, player2, match);
        assertEquals("0-1", match.score());

        pointWon(4, player1, match);
        assertEquals("1-1", match.score());

        pointWon(4, player2, match);
        assertEquals("1-2", match.score());

        pointWon(4, player1, match);
        assertEquals("2-2", match.score());

        pointWon(4, player2, match);
        assertEquals("2-3", match.score());

        pointWon(4, player1, match);
        assertEquals("3-3", match.score());

        pointWon(4, player2, match);
        assertEquals("3-4", match.score());

        pointWon(4, player1, match);
        assertEquals("4-4", match.score());

        pointWon(4, player2, match);
        assertEquals("4-5", match.score());

        pointWon(4, player1, match);
        assertEquals("5-5", match.score());

        pointWon(4, player2, match);
        assertEquals("5-6", match.score());

        pointWon(4, player2, match);
        assertEquals("0-1,5-7", match.score());
    }


    @Test
    public void Should_GetScoreForSetWhenWhenPlayer1WinsTieBreak() throws Exception {
        TennisMatch match = new TennisMatch(player1, player2);

        pointWon(4, player2, match);
        assertEquals("0-1", match.score());

        pointWon(4, player1, match);
        assertEquals("1-1", match.score());

        pointWon(4, player2, match);
        assertEquals("1-2", match.score());

        pointWon(4, player1, match);
        assertEquals("2-2", match.score());

        pointWon(4, player2, match);
        assertEquals("2-3", match.score());

        pointWon(4, player1, match);
        assertEquals("3-3", match.score());

        pointWon(4, player2, match);
        assertEquals("3-4", match.score());

        pointWon(4, player1, match);
        assertEquals("4-4", match.score());

        pointWon(4, player2, match);
        assertEquals("4-5", match.score());

        pointWon(4, player1, match);
        assertEquals("5-5", match.score());

        pointWon(4, player2, match);
        assertEquals("5-6", match.score());

        pointWon(4, player1, match);
        //tie is on as score is 6-6

        assertEquals("Tie is on,0-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,1-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,2-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,3-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,4-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,5-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Tie is on,6-0", match.score());

        pointWon(1, player1, match);
        assertEquals("Player 1 won the set", match.score());
    }



}
