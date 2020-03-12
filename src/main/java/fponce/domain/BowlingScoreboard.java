package fponce.domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreboard {

    private String player;
    private int currentFrame;
    private Shot shot;
    private List<Point> pointsByShot;
    private List<Integer> totalPointsInFrame;

    public BowlingScoreboard(String player) {
        currentFrame = 1;
        shot = Shot.FIRST;
        pointsByShot = new ArrayList<>(2 * 10 + 1);
        totalPointsInFrame = new ArrayList<>(10);
    }

    enum Shot {
        FIRST,
        SECOND,
        EXTRA
    }

    enum Point {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        STRIKE, // When scoring 10 in the first shot
        SPARE //Only could happen in second shot in frame
    }
}
