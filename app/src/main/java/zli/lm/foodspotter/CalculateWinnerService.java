package zli.lm.foodspotter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculateWinnerService extends Service {
    public CalculateWinnerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static String calculateWinner(String result){

        String[] parts = result.split("\\$");

        List<Vote> votes = new ArrayList<>();

        for (String part : parts) {
            Vote vote = Vote.fromString(part);
            votes.add(vote);
        }

        Vote highestScoreVote = null;
        double highestScore = Double.MIN_VALUE;

        for (Vote vote : votes) {
            if (vote.getScore() > highestScore) {
                highestScore = vote.getScore();
                highestScoreVote = vote;
            }
        }

        return highestScoreVote.getFavourite();



    }
        //Get index of Object with highest score
        /*int highestScoreIndex = 0;
        for (int i=1; i<votes.length; i++){
            if (votes[i].getScore() > votes[highestScoreIndex].getScore()){
                highestScoreIndex = i;
            }
        }
        //set a new Array with double entry for Object with highest score
        Vote[] results = new Vote[votes.length + 1];
        for (int i=0; i<votes.length; i++) {
            results[i] = votes[i];
        }
        results[votes.length] = votes[highestScoreIndex];

        //calculate votes (calculate with results[])

        return Arrays.toString(votes);
    }*/
}