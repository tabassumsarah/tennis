import java.util.Arrays;
import java.util.List;

/**
 * Created by saraht on 24/01/2019.
 */
public class Game {
    String player1;
    String player2;

    //need some score variable
    List<String> score = Arrays.asList("0","0");

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

     void pointWonBy(String player){

    }

    String score(){
        String scoreResult = score.get(0)+"-"+ score.get(1);
        return "0-0, " + scoreResult;
    }


}
