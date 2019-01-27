package com.solution.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by saraht on 26/01/2019.
 */

public class TennisMatchTests {
    @Test
    public void Should_CreateGame_WhenNoLogic() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
    }

    @Test
    public void Should_GetScore00_WhenNoPlayerScores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
        assertEquals("0-0,0-0", match.score());
    }

    @Test
    public void Should_GetScore15_0_WhenPlayer1Scores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());
    }

    @Test
    public void Should_GetScore_15_WhenPlayer2Scores() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());
    }

    @Test
    public void Should_GetScore30_0_WhenPlayer1ScoresTwice() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());
    }

    @Test
    public void Should_GetScore0_30WhenPlayer2ScoresTwice() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());
    }

    @Test
    public void Should_GetScoreDeuceWhenBothPlayerScores3() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");

        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");

        assertEquals("0-0,Deuce", match.score());
    }

    @Test
    public void Should_GetScoreAdvantagePlayer1WhenPlayer1Scores4AndPlayer2Scores3() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");

        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");

        match.pointWonBy("Player 1");

        assertEquals("0-0, Advantage Player 1", match.score());
    }

    @Test
    public void Should_GetScoreAdvantagePlayer2WhenPlayer2Scores4AndPlayer1Scores3() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");

        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");

        assertEquals("0-0, Advantage Player 2", match.score());
    }

    @Test
    public void Should_GetScore10WhenPlayer1Scores4AndPlayer2Scores2() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        match.pointWonBy("Player 1");
        assertEquals("1-0", match.score());
    }

    @Test
    public void Should_GetScore10WhenPlayer2Scores4AndPlayer1Scores2() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");
        match.pointWonBy("Player 2");

        assertEquals("0-1", match.score());
    }

    @Test
    public void Should_GetScore20WhenPlayer1Wins2Game() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("1-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("2-0", match.score());

    }

    @Test
    public void Should_GetScore02WhenPlayer2Wins2Game() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-1", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-2", match.score());
    }

    @Test
    public void Should_GetScoreForSet10WhenPlayer2Wins6GamesPlayer1WinsNone() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        // one game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-1", match.score());


        // Two game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-2", match.score());


        // Three game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-3", match.score());


        // Four game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-4", match.score());


        // Five game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-5", match.score());


       // Six game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        // Set won
        match.pointWonBy("Player 2");
        assertEquals("0-1,0-6", match.score());

    }


    @Test
    public void Should_GetScoreForSet10Game65WhenPlayer1Wins6GamesPlayer1Wins5() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        // one game player 1
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-1", match.score());


        // one game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("1-1", match.score());


        // Two game player 2
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("1-2", match.score());

        //Two game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("2-2", match.score());



        // Three game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("2-3", match.score());


        //Three game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("3-3", match.score());



        // Four game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("3-4", match.score());


        //Three game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("4-4", match.score());



        // Five game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("4-5", match.score());


        //Five game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("5-5", match.score());


        // Six game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("5-6", match.score());

        // Seven game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-1,5-7", match.score());

    }


    @Test
    public void Should_GetScoreForTieBReak() throws Exception {
        TennisMatch match = new TennisMatch("Player 1","Player 2");
        assertNotNull(match);

        // one game player 1
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-1", match.score());


        // one game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("1-1", match.score());


        // Two game player 2
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("1-2", match.score());

        //Two game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("2-2", match.score());



        // Three game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("2-3", match.score());


        //Three game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("3-3", match.score());



        // Four game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("3-4", match.score());


        //Three game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("4-4", match.score());



        // Five game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("4-5", match.score());


        //Five game player 1
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("5-5", match.score());


        // Six game
        match.pointWonBy("Player 2");
        assertEquals("0-0,0-15", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-30", match.score());

        match.pointWonBy("Player 2");
        assertEquals("0-0,0-40", match.score());

        match.pointWonBy("Player 2");
        assertEquals("5-6", match.score());

        // Seven game
        match.pointWonBy("Player 1");
        assertEquals("0-0,15-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,30-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("0-0,40-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,0-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,1-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,2-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,3-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,4-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("tie is on,5-0", match.score());


        match.pointWonBy("Player 1");
        assertEquals("tie is on,6-0", match.score());

        match.pointWonBy("Player 1");
        assertEquals("Player 1 wins", match.score());
    }



}
