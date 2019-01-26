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
        match.pointWonBy("Player 1");
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

        assertEquals("0-0,deuce", match.score());
    }


}
