import java.util.ArrayList;
import java.util.List;

/**
 * Created by saraht on 24/01/2019.
 */
public enum Score {

    Zero("0")  {
        List<Score> getNextPoint(Score other) {
            return score(Fifteen, other);
        }
    },

    Fifteen("15")  {
        List<Score> getNextPoint(Score other) {
            return score(Thirty, other);
        }
    },

    Thirty("30"){
        List<Score> getNextPoint(Score other) {
            if (other == Forty) {
                return score(Deuce, Deuce);
            } else {
                return score(Forty, other);
            }
        }
    },
    Winner("Winner") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    },

    Loser ("Looser"){
        List<Score> getNextPoint(Score other) {
            return score(Loser, Winner);
        }
    },

    Advantage("advantage") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    },

    Down ("down"){
        List<Score> getNextPoint(Score other) {
            return score(Deuce, Deuce);
        }
    },

    Deuce ("deuce"){
        List<Score> getNextPoint(Score other) {
            return score(Advantage, Down);
        }
    },

    Forty ("40") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    };

    private final String points;

    Score(String s) {
        points = s;
    }
    public String getPoints(){
        return points;
    }


    protected List<Score> score(Score one, Score two) {

        List<Score> a = new ArrayList<Score>();
        a.add(one);
        a.add(two);
        return a;

    }


    abstract List<Score> getNextPoint(Score other);
}
