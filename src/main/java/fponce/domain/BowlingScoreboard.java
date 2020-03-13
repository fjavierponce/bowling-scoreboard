package fponce.domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreboard {

    private State state;
    private String player;
    private int currentFrame;
    private List<Integer> totalPointsInFrame;
    private int total;

    public BowlingScoreboard(String player) {
        this.player = player;
        currentFrame = 1;
        totalPointsInFrame = new ArrayList<>(10);
        state = State.PLAYING_FIRST_SHOT;
    }

    public void addFrame(int points) {
        total = total + points;
        this.totalPointsInFrame.add(total);
        currentFrame++;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public String getPlayer() {
        return player;
    }

    public List<Integer> getTotalPointsInFrame() {
        return totalPointsInFrame;
    }

    public enum State {
        PLAYING_FIRST_SHOT,
        PLAYING_SECOND_SHOT,
        PLAYING_STRIKE,
        PLAYING_SPARE,
        SECOND_SHOT_AFTER_STRIKE,
        CONSECUTIVE_STRIKE,
        HALT_GAME
    }
}
