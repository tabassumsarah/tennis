import java.util.ArrayList;
import java.util.List;

/**
 * Created by saraht on 24/01/2019.
 */
enum Score {

    Zero("0") {
        List<Score> getNextPoint(Score other) {
            return score(Fifteen, other);
        }
    },

    Fifteen("15") {
        List<Score> getNextPoint(Score other) {
            return score(Thirty, other);
        }
    },

    Thirty("30") {
        List<Score> getNextPoint(Score other) {
            if (other == Forty) {
                return score(Deuce, Deuce);
            } else {
                return score(Forty, other);
            }
        }
    },

    Advantage("advantage") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    },

    Down("down") {
        List<Score> getNextPoint(Score other) {
            return score(Deuce, Deuce);
        }
    },

    Deuce("deuce") {
        List<Score> getNextPoint(Score other) {
            return score(Advantage, Down);
        }
    },

    Forty("40") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    },

    Winner("Winner") {
        List<Score> getNextPoint(Score other) {
            return score(Winner, Loser);
        }
    },

    Loser("Looser") {
        List<Score> getNextPoint(Score other) {
            return score(Loser, Winner);
        }
    };

    private final String points;

    Score(String s) {
        points = s;
    }

    public String getPoints() {
        return points;
    }

    protected List<Score> score(Score player, Score opponent) {
        List<Score> scoreList = new ArrayList<Score>();
        scoreList.add(player);
        scoreList.add(opponent);
        return scoreList;

    }


    abstract List<Score> getNextPoint(Score other);
}
