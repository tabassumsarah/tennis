/**
 * Created by saraht on 24/01/2019.
 */
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TennisGameTests extends TestCase{

    @Test
    public void testTennisGame(){
        Game game = new Game("Player1", "Player2");
        assertNotNull(game);
    }

    @Test
    public void testShouldAssertInitialResultIsZeroZero(){
        Game game = new Game("Player1", "Player2");
        assertEquals("0-0, 0-0", game.score());
    }

    @Test
    public void testShouldAssertResultFifteenZeroAfterPlayerOneScores(){
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        assertEquals("0-0, 15-0", game.score());
    }

    @Test
    public void testShouldAssertResultZeroFifteenAfterPlayerTwoScores(){
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player2");
        assertEquals("0-0, 0-15", game.score());
    }

    @Test
    public void testShouldAssertResultThrityZeroAfterPlayerObeScoresTwice(){
        Game game = new Game("Player1", "Player2");
        game.pointWonBy("Player1");
        game.pointWonBy("Player1");
        assertEquals("0-0, 30-0", game.score());
    }

}
