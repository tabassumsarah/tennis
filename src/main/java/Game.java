import java.util.*;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game {

    private String player1;
    private String player2;

    private Map<String, Integer> playerMap = new HashMap();

    private List<Score> stateOfScore = new ArrayList<Score>();

    //need to use a map
    private Map<String, String> gameScoreMap = new HashMap();

    //need to use a map
    private Map<String, Integer> setScoreMap = new HashMap();

    //need to manipulate state of this variable
    public Game(String player1, String player2) {

        this.player1 = player1;
        this.player2 = player2;

        playerMap.put(player1, 0);
        playerMap.put(player2, 1);

        gameScoreMap.put(player1, "0");
        gameScoreMap.put(player2, "0");

        stateOfScore.add(0, Score.Zero);
        stateOfScore.add(1, Score.Zero);
    }

    private int getOtherPlayer(int player) {
        return player == 1 ? 0 : 1;
    }

    private void updateScoreState(List<Score> newState, int currentPlayer, int opponent){
        stateOfScore.set(currentPlayer, newState.get(0));
        stateOfScore.set(opponent, newState.get(1));
    }

    void pointWonBy(String player) {

        int currentPlayer = playerMap.get(player);
        int opponent = getOtherPlayer(currentPlayer);

        List<Score> newState = stateOfScore.get(currentPlayer).getNextPoint(stateOfScore.get(opponent));
        updateScoreState(newState, currentPlayer,opponent);
    }

    String getSetScore() {
        return "0-0";
    }

    private String translateScore() {

        if (stateOfScore.get(0).equals(Score.Advantage)) {
            return Score.Advantage.name()+ " "+ this.player1;
        }

        if (stateOfScore.get(1).equals(Score.Advantage)) {
            return Score.Advantage.name()+ " "+ this.player2;
        }

        if (stateOfScore.get(0).equals(Score.Deuce) || stateOfScore.get(1).equals(Score.Deuce)) {
            return Score.Deuce.name();
        }

        return stateOfScore.get(0).getPoints() + "-" + stateOfScore.get(1).getPoints();
    }

    String score() {
        return getSetScore() + ", " + translateScore();
    }

    String newScore() {
        maintainGameScore();
        String setScore = setScoreMap.get(this.player1) + "-" + setScoreMap.get(this.player2);


        String s = setScore + "," + stateOfScore.get(0).getPoints() + "-" +
                stateOfScore.get(1).getPoints() + "\n";

        if (stateOfScore.get(0).equals(Score.Winner) || stateOfScore.get(1).equals(Score.Winner)) {
            stateOfScore.set(0, Score.Zero);
            stateOfScore.set(1, Score.Zero);
        }

        if (gameScoreMap.get(player1).equals("Winner") || gameScoreMap.get(player2).equals("Winner")) {
            gameScoreMap.put(player1, "0");
            gameScoreMap.put(player2, "0");
        }
        return s;
    }

    String maintainGameScore() {

        //check tie break
        //if setScore map is 6 -5 or 5-6
        //another game
        //if 6-6
        //tie breaker played

        if (setScoreMap.get(this.player1) == null) {
            setScoreMap.put(this.player1, 0);
        }
        if (stateOfScore.get(0).equals(Score.Winner)) {
            setScoreMap.put(this.player1, setScoreMap.get(this.player1) + 1);
        }

        if (setScoreMap.get(this.player2) == null) {
            setScoreMap.put(this.player2, 0);
        }

        if (stateOfScore.get(1).equals(Score.Winner)) {
            setScoreMap.put(this.player2, setScoreMap.get(this.player2) + 1);
        }

        return "";
    }


}
