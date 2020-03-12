package fponce.scoreboard;

import java.util.List;

import fponce.domain.BowlingScoreboard;
import fponce.domain.Shot;

public interface ScoreProcessorService {
    List<BowlingScoreboard> calculateScores(List<String> players, List<Shot> shots);
}
