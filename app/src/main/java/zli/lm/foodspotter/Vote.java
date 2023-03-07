package zli.lm.foodspotter;

public class Vote {

    private String favourite;
    private String least_favourite;
    private int score;

    public Vote(String favourite, String least_favourite, int score) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
