package fponce.io.writer;

import java.util.List;

import fponce.domain.Score;

public interface ScoreOutputWriterService {

    void printScores(List<Score> scores);

    void printPlayers(List<String> players);
}
