package fponce.domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreboard {

    public State state;
    public String player;
    public int currentFrame;
    public List<Integer> totalPointsInFrame;
    int total;

    public BowlingScoreboard(String player) {
        this.player = player;
        currentFrame = 1;
        totalPointsInFrame = new ArrayList<Integer>(10);
        state = State.PLAYING_FIRST_SHOT;
    }

    public void addFrame(int points) {
        total = total + points;
        this.totalPointsInFrame.add(total);
    }

    public enum State {
        PLAYING_FIRST_SHOT,
        PLAYING_SECOND_SHOT,
        PLAYING_STRIKE,
        PLAYING_SPARE,
        FIRST_SHOT_AFTER_STRIKE
    }
}
