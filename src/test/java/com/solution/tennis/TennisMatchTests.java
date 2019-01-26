package com.solution.tennis;

import org.junit.Test;

/**
 * Created by saraht on 26/01/2019.
 */

public class TennisMatchTests {
    @Test
    public void Should_CreateGame_WhenNoLogic() throws Exception {
         TennisMatch match = new TennisMatch("Player 1","Player 2");
    }
}
