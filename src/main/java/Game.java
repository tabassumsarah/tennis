import java.util.*;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game implements Match{

    private String player1;
    private String player2;

    private Map<String, Integer> playerMap = new HashMap<String, Integer>();
    private List<Score> stateOfScore = new ArrayList<Score>();
    private Map<String, Integer> setScoreMap = new HashMap<String, Integer>();

    Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;

        playerMap.put(player1, 0);
        playerMap.put(player2, 1);

        setScoreMap.put(player1, 0);
        setScoreMap.put(player2, 0);

        stateOfScore.add(0, Score.Zero);
        stateOfScore.add(1, Score.Zero);
    }

    @Override
    public void pointWonBy(String player) {
        int currentPlayer = playerMap.get(player);
        int opponent = getOtherPlayer(currentPlayer);

        List<Score> newState = stateOfScore.get(currentPlayer).getNextPoint(stateOfScore.get(opponent));
        updateScoreState(newState, currentPlayer, opponent);
    }

    @Override
    public String score() {
        maintainMatchScoreSet();
        return getSetScore() + ", " + translateScore();
    }

    private int getOtherPlayer(int player) {
        return player == 1 ? 0 : 1;
    }

    private void updateScoreState(List<Score> newState, int currentPlayer, int opponent) {
        stateOfScore.set(currentPlayer, newState.get(0));
        stateOfScore.set(opponent, newState.get(1));
    }

    private String getSetScore() {
        return setScoreMap.get(player1) + "-" + setScoreMap.get(player2);
    }

    private String translateScore() {
        if (stateOfScore.get(0).equals(Score.Advantage)) {
            return Score.Advantage.name() + " " + this.player1;
        }
        if (stateOfScore.get(1).equals(Score.Advantage)) {
            return Score.Advantage.name() + " " + this.player2;
        }
        if (stateOfScore.get(0).equals(Score.Deuce) || stateOfScore.get(1).equals(Score.Deuce)) {
            return Score.Deuce.name();
        }
        return stateOfScore.get(0).getPoints() + "-" + stateOfScore.get(1).getPoints();
    }

    private void maintainMatchScoreSet() {
        if (stateOfScore.get(playerMap.get(this.player1)).equals(Score.Winner)) {
            setScoreMap.put(this.player1, setScoreMap.get(this.player1) + 1);
        }
        if (stateOfScore.get(playerMap.get(this.player2)).equals(Score.Winner)) {
            setScoreMap.put(this.player2, setScoreMap.get(this.player2) + 1);
        }
    }

}
