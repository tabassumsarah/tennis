import java.util.ArrayList;
import java.util.List;

/**
 * Created by saraht on 24/01/2019.
 */
enum Score {

    ZERO("0") {
        List<Score> getNextPoint(Score other) {
            return score(FIFTEEN, other);
        }
    },

    FIFTEEN("15") {
        List<Score> getNextPoint(Score other) {
            return score(THIRTY, other);
        }
    },

    THIRTY("30") {
        List<Score> getNextPoint(Score other) {
            if (other == FORTY) {
                return score(DEUCE, DEUCE);
            } else {
                return score(FORTY, other);
            }
        }
    },

    ADVANTAGE("advantage") {
        List<Score> getNextPoint(Score other) {
            return score(WINNER, LOSER);
        }
    },

    DOWN("down") {
        List<Score> getNextPoint(Score other) {
            return score(DEUCE, DEUCE);
        }
    },

    DEUCE("deuce") {
        List<Score> getNextPoint(Score other) {
            return score(ADVANTAGE, DOWN);
        }
    },

    FORTY("40") {
        List<Score> getNextPoint(Score other) {
            return score(WINNER, LOSER);
        }
    },

    WINNER("WINNER") {
        List<Score> getNextPoint(Score other) {
            return score(WINNER, LOSER);
        }
    },

    LOSER("Looser") {
        List<Score> getNextPoint(Score other) {
            return score(LOSER, WINNER);
        }
    },
    TIEBREAK_ZERO("0") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_ONE, other);
        }
    },
    TIEBREAK_ONE("1") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_TWO, other);
        }
    },
    TIEBREAK_TWO("2") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_THREE, other);
        }
    },
    TIEBREAK_THREE("3") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_FOUR, other);
        }
    },
    TIEBREAK_FOUR("4") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_FIVE, other);
        }
    },
    TIEBREAK_FIVE("5") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_SIX, other);
        }
    },
    TIEBREAK_SIX("6") {
        List<Score> getNextPoint(Score other) {
            return score(TIEBREAK_SEVEN, other);
        }
    },
    TIEBREAK_SEVEN("7") {
        List<Score> getNextPoint(Score other) {
            return score(WINNER, other);
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
