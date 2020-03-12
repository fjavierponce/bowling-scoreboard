package fponce.scoreboard;

import java.util.List;

import fponce.domain.Score;
import fponce.domain.ScoreBoard;

public interface ScoreProcessorService {
    List<ScoreBoard> calculateScores(List<String> players, List<Score> scores);
}
