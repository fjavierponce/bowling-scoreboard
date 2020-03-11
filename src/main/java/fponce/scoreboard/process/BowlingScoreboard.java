package fponce.scoreboard.process;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import fponce.scoreboard.entity.Score;
import fponce.scoreboard.entity.ScoreBoard;

public class BowlingScoreboard {

    public Map<String, ScoreBoard> process(List<Score> scores) {
        int frame = 0;
        int cycleInFrame = 0;
        for (Score score: scores) {
            frame ++;
            cycleInFrame = (cycleInFrame + 1) % 2;
            System.out.println("frame " + frame + " cycle " + cycleInFrame);
        }
        return Collections.emptyMap();
    }
}
