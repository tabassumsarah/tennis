import java.util.Arrays;
import java.util.List;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game {
    String player1;
    String player2;

    //need some score variable
    List<String> score = Arrays.asList("0", "0");

    //need to manipulate state of this variable

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void pointWonBy(String player) {
        String score = "";

        if (player.equals(this.player1)) {
            score = getCheckScoreForPlayer(0);
            String scoreList = getNextScore(score);
            updateScore(scoreList,0);

        } else {
            score = getCheckScoreForPlayer(1);
            String scoreList = getNextScore(score);
            updateScore(scoreList,1);
        }
    }

    private String getNextScore(String score) {
        if(score.equals("0")){
            return "15";
        }
        if(score.equals("15")){
            return "30";
        }
        if(score.equals("30")){
            return "40";
        }
        if(score.equals("40")){
            return "Winner";
        }
        return "";
    }

    private void updateScore(String newScore, int idx) {
       score.set(idx,newScore);
    }

    private String getCheckScoreForPlayer(int idx) {
        return score.get(idx);
    }

    String score() {

        if(score.get(0).equals("Winner")){
            return "1-0";
        }
        if(score.get(1).equals("Winner")){
            return "0-1";
        }
        String scoreResult = score.get(0) + "-" + score.get(1);

        return "0-0, " + scoreResult;
    }


}
