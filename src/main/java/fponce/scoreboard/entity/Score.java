package fponce.scoreboard.entity;

public class Score {

    private String name;
    private Integer score;

    public Score(String name, String score) {
        this.setName(name);
        this.setScore("F".equals(score) ? -1 : Integer.valueOf(score));
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + getName() + '\'' +
                ", score=" + getScore() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
