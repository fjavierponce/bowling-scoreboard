package fponce.resource.writer;

import java.util.List;

import fponce.scoreboard.entity.Score;

public interface ScoreOutputWriterService {

    void printScores(List<Score> scores);

    void printPlayers(List<String> players);
}
