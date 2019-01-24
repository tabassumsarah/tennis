import java.util.*;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game implements Match{

    private String player1;
    private String player2;

    private static int PLAYER_ONE_NUMBER = 0;
    private static int PLAYER_TWO_NUMBER = 1;

    private Map<String, Integer> players = new HashMap<String, Integer>(); // To identify easily which player is currently serving
    private List<Score> stateOfScore = new ArrayList<Score>(Arrays.asList(Score.Zero, Score.Zero));
    private Map<String, Integer> scoreOfGameSet = new HashMap<String, Integer>(); // To maintain state of every set in the match

    Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;

        players.put(player1, PLAYER_ONE_NUMBER);
        players.put(player2, PLAYER_TWO_NUMBER);

        scoreOfGameSet.put(player1, 0);
        scoreOfGameSet.put(player2, 0);
    }

    /*
    * This method is updating new score based on the current score using Score enum.
    * @see Score#getNextPoint(Score other).
    * @param String player identification string
    * */

    @Override
    public void pointWonBy(String player) {
        int currentPlayer = players.get(player);
        int opponent = getOtherPlayer(currentPlayer);
        // Fetching next point from Score enum.
        List<Score> newState = stateOfScore.get(currentPlayer).getNextPoint(stateOfScore.get(opponent));
        // Updating scoreState using new data
        updateScoreState(newState, currentPlayer, opponent);
    }

    @Override
    public String score() {
        //Calculating mathc set score
        maintainMatchScoreSet();
        // Getting Match set score and game score
        return getMatchSetScore() + ", " + translateScore();
    }

    //Returning who is opponent of the current game
    private int getOtherPlayer(int playerNumber) {
        return playerNumber == PLAYER_TWO_NUMBER ? PLAYER_ONE_NUMBER : PLAYER_TWO_NUMBER;
    }

    /**
     * Updates score state
     * @param newState updated points
     * @param currentPlayer
     * @param opponent
     * */
    private void updateScoreState(List<Score> newState, int currentPlayer, int opponent) {
        stateOfScore.set(currentPlayer, newState.get(0));
        stateOfScore.set(opponent, newState.get(1));
    }

    private String getMatchSetScore() {
        return scoreOfGameSet.get(player1) + "-" + scoreOfGameSet.get(player2);
    }

    // This method is returning score string following output pattern in the challenge.
    private String translateScore() {
        if (stateOfScore.get(PLAYER_ONE_NUMBER).equals(Score.Advantage)) {
            return Score.Advantage.name() + " " + this.player1;
        }
        if (stateOfScore.get(PLAYER_TWO_NUMBER).equals(Score.Advantage)) {
            return Score.Advantage.name() + " " + this.player2;
        }
        if (stateOfScore.get(PLAYER_ONE_NUMBER).equals(Score.Deuce) || stateOfScore.get(PLAYER_TWO_NUMBER).equals(Score.Deuce)) {
            return Score.Deuce.name();
        }
        return stateOfScore.get(PLAYER_ONE_NUMBER).getPoints() + "-" + stateOfScore.get(PLAYER_TWO_NUMBER).getPoints();
    }

    // Updating Match Set result every time a game is win-loose state
    private void maintainMatchScoreSet() {
        if (stateOfScore.get(players.get(this.player1)).equals(Score.Winner)) {
            scoreOfGameSet.put(this.player1, scoreOfGameSet.get(this.player1) + 1);
        }
        if (stateOfScore.get(players.get(this.player2)).equals(Score.Winner)) {
            scoreOfGameSet.put(this.player2, scoreOfGameSet.get(this.player2) + 1);
        }
    }

}
