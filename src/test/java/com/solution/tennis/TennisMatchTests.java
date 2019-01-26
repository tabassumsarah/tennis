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

}
