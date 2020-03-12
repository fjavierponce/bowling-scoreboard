package fponce.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import fponce.domain.Shot;
import fponce.domain.BowlingScoreboard;

@Service
class ScoreProcessorImpl implements ScoreProcessorService {

    private Log log = LogFactory.getLog(ScoreProcessorImpl.class);

    @Override
    public List<BowlingScoreboard> calculateScores(List<String> players, List<Shot> shots) {
        List<BowlingScoreboard> results = new ArrayList<>();
        for (String player: players) {
            List<Shot> filteredScoresByPlayer = shots.stream()
                    .filter(score -> score.getName().equals(player))
                    .collect(Collectors.toList());

            results.add(calculateScoresForPlayer(player, filteredScoresByPlayer));
        }
        return results;
    }

    private BowlingScoreboard calculateScoresForPlayer(String player, List<Shot> filteredScoresByPlayer) {
        BowlingScoreboard board = new BowlingScoreboard(player);
        for (Shot shot : filteredScoresByPlayer) {
            int point = shot.getScore();
        }
        return board;
    }

}
