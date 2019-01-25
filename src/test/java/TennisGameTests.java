/**
 * Created by saraht on 24/01/2019.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TennisGameTests {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game("Player1", "Player2");
    }

    private void playerScores(int count, String player) {
        for (int i = 0; i < count; i++) {
            game.pointWonBy(player);
        }
    }

    @Test
    public void testTennisGame() {
        assertNotNull(game);
    }

    @Test
    public void testShouldAssertInitialResultIsZeroZero() {
        assertEquals("0-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultFifteenZeroAfterPlayerOneScores() {
        game.pointWonBy("Player1");
        assertEquals("0-0, 15-0", game.score());
    }

    @Test
    public void testShouldAssertResultZeroFifteenAfterPlayerTwoScores() {
        game.pointWonBy("Player2");
        assertEquals("0-0, 0-15", game.score());
    }

    @Test
    public void testShouldAssertResultThirtyZeroAfterPlayerObeScoresTwice() {
        playerScores(2, "Player1");
        assertEquals("0-0, 30-0", game.score());
    }

    @Test
    public void testShouldAssertResultZeroThrityAfterPlayerTwoScoresTwice() {
        playerScores(2, "Player2");
        assertEquals("0-0, 0-30", game.score());
    }

    @Test
    public void testShouldAssertResultFifteenAllAfterPlayerOneAndTwoScoresOnce() {
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        assertEquals("0-0, 15-15", game.score());
    }

    @Test
    public void testShouldAssertResultFortyZeroAfterPlayerOneScoresThrice() {
        playerScores(3, "Player1");
        assertEquals("0-0, 40-0", game.score());
    }

    @Test
    public void testShouldAssertResultOneZeroAfterPlayerOneScoresForty() {
        playerScores(4, "Player1");
        assertEquals("1-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultDeuceDeuceAfterBothPlayerScoresThirty() {

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        assertEquals("0-0, DEUCE", game.score());
    }

    @Test
    public void testShouldAssertResultAdvantagePlayer1AfterPlayer1ScoresAdvantage() {
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        assertEquals("0-0, ADVANTAGE Player1", game.score());
    }


    @Test
    public void testShouldAssertResultAdvantagePlayer2AfterPlayer2ScoresAdvantage() {
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player2");
        assertEquals("0-0, ADVANTAGE Player2", game.score());
    }

    @Test
    public void testShouldAssertResultDeuceDownPlayerScores() {
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        assertEquals("0-0, ADVANTAGE Player1", game.score());

        game.pointWonBy("Player2");
        assertEquals("0-0, DEUCE", game.score());
    }

    @Test
    public void testShouldAssertResultWinnerWhenAdvantagePlayerScores() {
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        assertEquals("0-0, ADVANTAGE Player1", game.score());

        game.pointWonBy("Player1");
        assertEquals("1-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultSetThreeZeroAfterPlayerOneWinsThreeGames() {
        playerScores(4, "Player1");
        assertEquals("1-0, 0-0", game.score());

        playerScores(4, "Player1");
        assertEquals("2-0, 0-0", game.score());

        playerScores(4, "Player1");
        assertEquals("3-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultSetThreeZeroAfterPlayerTwoWinsThreeGames() {
        playerScores(4, "Player2");
        assertEquals("0-1, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("0-2, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("0-3, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultSetTwoOneWhenPlayer1WinsTwoGamesAndPlayer2OneGame() {
        game = new Game("Player1", "Player2");
        playerScores(4, "Player2");
        assertEquals("0-1, 0-0", game.score());

        playerScores(4, "Player1");
        assertEquals("1-1, 0-0", game.score());

        playerScores(4, "Player1");
        assertEquals("2-1, 0-0", game.score());
    }


    @Test
    public void testShouldAssertResultForTieBreak() {
        game = new Game("Player1", "Player2");

        playerScores(4, "Player1");
        assertEquals("1-0, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("1-1, 0-0", game.score());



        playerScores(4, "Player1");
        assertEquals("2-1, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("2-2, 0-0", game.score());



        playerScores(4, "Player1");
        assertEquals("3-2, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("3-3, 0-0", game.score());


        playerScores(4, "Player1");
        assertEquals("4-3, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("4-4, 0-0", game.score());


        playerScores(4, "Player1");
        assertEquals("5-4, 0-0", game.score());

        playerScores(4, "Player2");
        assertEquals("5-5, 0-0", game.score());


        playerScores(4, "Player1");
        assertEquals("6-5, 0-0", game.score());

        // TIE break:
        playerScores(4, "Player2");
        assertEquals("0-0", game.score());


        game.pointWonBy("Player1");
        assertEquals("1-0", game.score());

        game.pointWonBy("Player1");
        assertEquals("2-0", game.score());


        game.pointWonBy("Player1");
        assertEquals("3-0", game.score());

        game.pointWonBy("Player1");
        assertEquals("4-0", game.score());


        game.pointWonBy("Player2");
        assertEquals("4-1", game.score());

        game.pointWonBy("Player2");
        assertEquals("4-2", game.score());

    }
}
