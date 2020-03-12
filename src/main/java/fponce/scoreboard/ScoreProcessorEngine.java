package fponce.scoreboard;

import java.util.List;

import org.springframework.stereotype.Service;

import fponce.domain.Score;
import fponce.domain.ScoreBoard;

@Service
public class ScoreProcessorEngine implements ScoreProcessorService {
    @Override
    public List<ScoreBoard> calculateScores(List<String> players, List<Score> scores) {
        return null;
    }
}
