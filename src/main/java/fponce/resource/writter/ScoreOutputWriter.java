package fponce.resource.writter;

import fponce.scoreboard.entity.ScoreBoard;

public interface ScoreOutputWriter {
    void printOnePlayerScore(String s, ScoreBoard scoreBoard);
}
