import java.util.*;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game implements Match {
    private static int PLAYER_ONE_NUMBER = 0;
    private static int PLAYER_TWO_NUMBER = 1;
    private static int TIE_BREAK_COUNT = 6;

    private String player1;
    private String player2;
    private boolean tieBreakMode = false;

    private Map<String, Integer> players = new HashMap<String, Integer>(); // To identify easily which player is currently serving
    private List<Score> stateOfScore = new ArrayList<Score>(Arrays.asList(Score.ZERO, Score.ZERO));
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
        //Calculating match set score
        updateMatchSetScore();

        /*If match set result is 6-6 Enter tie break mode */
        if (scoreOfGameSet.get(this.player1).equals(TIE_BREAK_COUNT) &&
                scoreOfGameSet.get(this.player2).equals(TIE_BREAK_COUNT) && !getTieBeakFlag()) {
            stateOfScore = new ArrayList<Score>(Arrays.asList(Score.TIEBREAK_ZERO, Score.TIEBREAK_ZERO));
            setTieBreakMode(true);
        }

        //translate score
        return translateScore();
    }

    // Updating Match Set result every time a game is win-loose state.
    // This method keeps tracks of games set result
    private void updateMatchSetScore() {
        if (stateOfScore.get(players.get(this.player1)).equals(Score.WINNER)) {
            scoreOfGameSet.put(this.player1, scoreOfGameSet.get(this.player1) + 1);
            clearStateOfScore();//game's final state i.e winner-looser, clear the state variable to default
        }
        if (stateOfScore.get(players.get(this.player2)).equals(Score.WINNER)) {
            scoreOfGameSet.put(this.player2, scoreOfGameSet.get(this.player2) + 1);
            clearStateOfScore();//game's final state i.e winner-looser, clear the state variable to default
        }
    }

    private String translateScore() {
        String defaultGameScore = getMatchSetScore() + ", " + stateOfScore.get(PLAYER_ONE_NUMBER).getPoints() + "-" + stateOfScore.get(PLAYER_TWO_NUMBER).getPoints();
        // Points for ongoing game in a set
        if (stateOfScore.get(PLAYER_ONE_NUMBER).equals(Score.ADVANTAGE)) {
            return getMatchSetScore() + ", " + Score.ADVANTAGE.name() + " " + this.player1;
        }
        if (stateOfScore.get(PLAYER_TWO_NUMBER).equals(Score.ADVANTAGE)) {
            return getMatchSetScore() + ", " + Score.ADVANTAGE.name() + " " + this.player2;
        }
        if (stateOfScore.get(PLAYER_ONE_NUMBER).equals(Score.DEUCE) || stateOfScore.get(PLAYER_TWO_NUMBER).equals(Score.DEUCE)) {
            return getMatchSetScore() + ", " + Score.DEUCE.name();
        }
        // Points for tie break 6-6
        if (scoreOfGameSet.get(this.player1).equals(TIE_BREAK_COUNT) && scoreOfGameSet.get(this.player2).equals(TIE_BREAK_COUNT)) {
            return stateOfScore.get(PLAYER_ONE_NUMBER).getPoints() + "-" + stateOfScore.get(PLAYER_TWO_NUMBER).getPoints();
        } else
            return defaultGameScore;
    }

    //Returning who is opponent of the current game
    private int getOtherPlayer(int playerNumber) {
        return playerNumber == PLAYER_TWO_NUMBER ? PLAYER_ONE_NUMBER : PLAYER_TWO_NUMBER;
    }

    /**
     * Updates score state
     *
     * @param newState      updated points
     * @param currentPlayer
     * @param opponent
     */
    private void updateScoreState(List<Score> newState, int currentPlayer, int opponent) {
        stateOfScore.set(currentPlayer, newState.get(0));
        stateOfScore.set(opponent, newState.get(1));
    }

    private String getMatchSetScore() {
        return scoreOfGameSet.get(player1) + "-" + scoreOfGameSet.get(player2);
    }

    // To verify the state is tie break mode or not
    private boolean getTieBeakFlag() {
        return tieBreakMode;
    }

    private void setTieBreakMode(boolean state) {
        tieBreakMode = state;
    }

    //Default score set to ZERO @seeScore#ZERO
    private void clearStateOfScore() {
        stateOfScore.set(players.get(this.player1), Score.ZERO);
        stateOfScore.set(players.get(this.player2), Score.ZERO);
    }
}
