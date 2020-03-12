package fponce.domain;

public class Shot {

    private String name;
    private Integer score;

    public Shot(String name, String score) {
        this.setName(name);
        this.setScore("F".equals(score) ? -1 : Integer.valueOf(score));
    }

    @Override
    public String toString() {
        return getName() + "[" +getScore() + "]";
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
