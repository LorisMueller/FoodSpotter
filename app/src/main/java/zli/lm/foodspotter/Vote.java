package zli.lm.foodspotter;

import java.io.Serializable;

public class Vote implements Serializable {

    private String favourite;
    private String least_favourite;
    private double score;

    public Vote(String favourite, String least_favourite, double score) {
        this.favourite = favourite;
        this.least_favourite = least_favourite;
        this.score = score;
    }

    public Vote(){

    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getLeast_favourite() {
        return least_favourite;
    }

    public void setLeast_favourite(String least_favourite) {
        this.least_favourite = least_favourite;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return favourite + "," + least_favourite + "," + score;
    }

    public static Vote fromString(String s) {
        String[] parts = s.split(",");
        String favourite = parts[0];
        String leastFavourite = parts[1];
        double score = Double.parseDouble(parts[2]);
        return new Vote(favourite, leastFavourite, score);
    }
}
