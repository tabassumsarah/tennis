import java.util.*;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game {
    String player1;
    String player2;
    //need to use a map
    Map<String, String> scoreMap = new HashMap();
    //need some score variable
    List<String> score = Arrays.asList("0", "0");

    //need to manipulate state of this variable

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;

        scoreMap.put(player1, "0");
        scoreMap.put(player2, "0");
    }

    void pointWonBy(String player) {
        String score = "";
        if (player.equals(this.player1)) {
            score = scoreMap.get(player);
            List<String> l = getScoreNow(score, scoreMap.get(player2));
            scoreMap.put(player, l.get(0));
            scoreMap.put(player2, l.get(1));

        } else {
            score = scoreMap.get(player);
            List<String> l = getScoreNow(score, scoreMap.get(player1));
            scoreMap.put(player, l.get(0));
            scoreMap.put(player1, l.get(1));

        }


   /*     if (player.equals(this.player1)) {

            score = getCheckScoreForPlayer(0);
            List<String> scoreList = getNextScore(score,getCheckScoreForPlayer(1));
            updateScore(scoreList,0);

        } else {
            score = getCheckScoreForPlayer(1);
            List<String> scoreList = getNextScore(score,getCheckScoreForPlayer(0));
            updateScore(scoreList,1);
        }*/
    }

    private List<String> getScoreNow(String score, String ot) {
        List<String> newScopeToUpdate = new ArrayList<String>();
        if (score.equals("0")) {
            newScopeToUpdate.add(0, "15");
            newScopeToUpdate.add(1, ot);
            return newScopeToUpdate;
        }

        if (score.equals("15")) {
            newScopeToUpdate.add(0, "30");
            newScopeToUpdate.add(1, ot);
            return newScopeToUpdate;
        }

        if (score.equals("deuce")) {
            newScopeToUpdate.add(0, "advantage");
            newScopeToUpdate.add(1, "down");
            return newScopeToUpdate;
        }
        if (score.equals("30")) {
            if (ot.equals("40")) {
                newScopeToUpdate.add(0, "deuce");
                newScopeToUpdate.add(1, "deuce");

            } else {
                newScopeToUpdate.add(0, "40");
                newScopeToUpdate.add(1, ot);

            }
            return newScopeToUpdate;
        }

        if (score.equals("40")) {

            newScopeToUpdate.add(0, "Winner");
            newScopeToUpdate.add(1, "looser");


            return newScopeToUpdate;
        }

        return newScopeToUpdate;
    }

    // so now this test made this logic seems not ok as i need to compare decuce logic
    // time to rethink the logic
    private List<String> getNextScore(String score, String otherScore) {
        List<String> newScopeToUpdate = new ArrayList<String>();
        if (score.equals("0")) {
            newScopeToUpdate.add(0, "15");
            newScopeToUpdate.add(1, otherScore);
            return newScopeToUpdate;
        }
        if (score.equals("15")) {
            newScopeToUpdate.add(0, "30");
            newScopeToUpdate.add(1, otherScore);
            return newScopeToUpdate;
        }
        if (score.equals("30")) {
            if (otherScore.equals("40")) {
                newScopeToUpdate.add(0, "deuce");
                newScopeToUpdate.add(1, "deuce");

            } else {
                newScopeToUpdate.add(0, "40");
                newScopeToUpdate.add(1, otherScore);
            }
            return newScopeToUpdate;
        }
        if (score.equals("40")) {

            newScopeToUpdate.add(0, "Winner");
            newScopeToUpdate.add(1, "looser");
            return newScopeToUpdate;
        }

        if (score.equals("deuce")) {
            newScopeToUpdate.add(0, "advantage");
            newScopeToUpdate.add(1, "down");
            return newScopeToUpdate;
        }

        return newScopeToUpdate;
    }

    private void updateScore(List<String> newScore, int idx) {
        score.set(0, newScore.get(0));
        score.set(1, newScore.get(1));
    }

    private String getCheckScoreForPlayer(int idx) {
        return score.get(idx);
    }

    String score() {

        if (scoreMap.get(player1).equals("Winner")) {
            return "1-0";
        }

        if (scoreMap.get(player1).equals("advantage")) {
            return "0-0, advantage Player1";
        }

        if (scoreMap.get(player2).equals("advantage")) {
            return "0-0 advantage player2";
        }

        if (scoreMap.get(player2).equals("Winner")) {
            return "0-1";
        }
        if (scoreMap.get(player1).equals("deuce")||scoreMap.get(player2).equals("deuce")) {
            return "0-0, deuce";
        }


        return "0-0, " + scoreMap.get(player1) + '-' + scoreMap.get(player2);
        /*if(score.get(0).equals("Winner")){
            return "1-0";
        }
        if(score.get(1).equals("Winner")){
            return "0-1";
        }
        String scoreResult = score.get(0) + "-" + score.get(1);

        return "0-0, " + scoreResult;*/
    }


}
