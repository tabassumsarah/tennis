/**
 * Created by saraht on 24/01/2019.
 */

import junit.framework.TestCase;
import org.junit.Test;

public class TennisGameTests extends TestCase {

    @Test
    public void testTennisGame() {
        Game game = new Game("Player1", "Player2");
        assertNotNull(game);
    }

    @Test
    public void testShouldAssertInitialResultIsZeroZero() {
        Game game = new Game("Player1", "Player2");
        assertEquals("0-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultFifteenZeroAfterPlayerOneScores() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");

        assertEquals("0-0, 15-0", game.score());
    }

    @Test
    public void testShouldAssertResultZeroFifteenAfterPlayerTwoScores() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player2");

        assertEquals("0-0, 0-15", game.score());
    }

    @Test
    public void testShouldAssertResultThrityZeroAfterPlayerObeScoresTwice() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("0-0, 30-0", game.score());
    }

    @Test
    public void testShouldAssertResultZeroThrityAfterPlayerTwoScoresTwice() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player2");
        game.pointWonBy("Player2");
        assertEquals("0-0, 0-30", game.score());
    }

    @Test
    public void testShouldAssertResultFifteenAllAfterPlayerOneAndTwoScoresOnce() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        assertEquals("0-0, 15-15", game.score());
    }

    @Test
    public void testShouldAssertResultFortyZeroAfterPlayerOneScoresThrice() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("0-0, 40-0", game.score());
    }

    @Test
    public void testShouldAssertResultOneZeroAfterPlayerOneScoresForty() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("1-0, Winner-Looser", game.score());
    }

    @Test
    public void testShouldAssertResultTwoZeroAfterPlayerOneWinsTwoGames() {
        Game game = new Game("Player1", "Player2");

        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("1-0, Winner-Looser", game.score());

        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("2-0, Winner-Looser", game.score());
    }

    @Test
    public void testShouldAssertResultDeuceDeuceAfterBothPlayerScoresThirty() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        assertEquals("0-0, Deuce", game.score());
    }

    @Test
    public void testShouldAssertResultAdvantagePlayer1AfterPlayer1ScoresAdvantage() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        assertEquals("0-0, Advantage Player1", game.score());
    }


    @Test
    public void testShouldAssertResultAdvantagePlayer2AfterPlayer2ScoresAdvantage() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player2");
        assertEquals("0-0, Advantage Player2", game.score());
    }

    @Test
    public void testShouldAssertResultDeuceDownPlayerScores() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        assertEquals("0-0, Advantage Player1", game.score());
        game.pointWonBy("Player2");
        assertEquals("0-0, Deuce", game.score());
    }

    @Test
    public void testShouldAssertResultWinnerWhenAdvantagePlayerScores() {
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player2");

        game.pointWonBy("Player1");
        assertEquals("0-0, Advantage Player1", game.score());
        game.pointWonBy("Player1");
        assertEquals("1-0, Winner-Looser", game.score());
    }


}
