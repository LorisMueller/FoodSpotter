package zli.lm.foodspotter;

public class Vote {

    private String favourite;
    private String least_favourite;
    private double score;

    public Vote(String favourite, String least_favourite, double score) {
        this.favourite = favourite;
        this.least_favourite = least_favourite;
        this.score = score;
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
}
